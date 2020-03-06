package nl.hanze.roy.ads.week2.sets;

import java.io.*;
import java.util.*;

/**
 * Class
 */
public class CountKeywords {
    public static Set<String> keywords = new HashSet<>(Arrays.asList("abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum",
            "extends", "for", "final", "finally", "float", "goto",
            "if", "implements", "import", "instanceof", "int",
            "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", "volatile",
            "while"));

    public static void main(String[] args) throws IOException {
        int count = 0;

        FileInputStream fstream = new FileInputStream("src/nl/hanze/roy/ads/week2/sets/CountKeywords.java");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fstream))) {
            String line;

            while ((line = reader.readLine()) != null) {

                line = removeStringsAndComments(line, reader);

                if (!line.isEmpty()) {
                    for (String keyword: keywords) {
                        if(line.contains(keyword)) {
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println("Keyword count: " + count);
    }

    private static String removeStringsAndComments(String line, BufferedReader reader) throws IOException {
        boolean hasMultilineComment = line.contains("/*");
        boolean hasSingleLineComment = line.contains("//");
        boolean hasString = line.contains("\"");

        /*
         * Remove comments and strings since these can contains keywords that should not be counted
         */
        if (hasString && !(hasMultilineComment || hasSingleLineComment)) { // Only string should be replaced
            line = removeStrings(line);
        } else if (hasMultilineComment || hasSingleLineComment) {

            if (!hasString) { // Only comments should be replaced

                line = removeMultilineComments(line, reader);
                line = removeSingleLineComment(line);

            } else { // Line contains strings and comments

                int multilineCommentIndex;
                int singleLineCommentIndex;
                int stringIndex;

                do {
                    // Determine which should be replaced first.
                    multilineCommentIndex = line.indexOf("/*");
                    singleLineCommentIndex = line.indexOf("//");
                    stringIndex = line.indexOf("\"");

                    // String has first occurrence
                    if ((stringIndex < multilineCommentIndex || stringIndex < singleLineCommentIndex) && stringIndex != -1) {
                        line = removeFirstString(line);
                    } else if (multilineCommentIndex < stringIndex && multilineCommentIndex != -1) { // Multiline comment has first occurrence
                        line = removeFirstMultilineComment(new StringBuilder(line), reader).toString();
                    } else { // Single line comment has first occurrence
                        line = removeSingleLineComment(line);
                    }
                } while (multilineCommentIndex != -1 || singleLineCommentIndex != -1 || stringIndex != -1);
            }
        }

        return line;
    }

    private static String removeMultilineComments(String line, BufferedReader reader) throws IOException {
        StringBuilder lineBuilder = new StringBuilder(line);

        while (lineBuilder.toString().contains("/*")) { // Multiple multiline comments on same line
            lineBuilder = removeFirstMultilineComment(lineBuilder, reader);
        }

        return lineBuilder.toString();
    }

    private static StringBuilder removeFirstMultilineComment(StringBuilder lineBuilder, BufferedReader reader) throws IOException {
        String nextLine;

        if (!lineBuilder.toString().contains("*/")) { // Combine lines to make a closed comment on the same line
            do {
                nextLine = reader.readLine();
            } while (!nextLine.contains("*/"));

            lineBuilder.append(nextLine);
        }

        String segment1 = lineBuilder.substring(0, lineBuilder.indexOf("/*"));
        String segment2 = lineBuilder.substring(lineBuilder.indexOf("*/") + 2);

        return new StringBuilder(segment1 + segment2);
    }

    private static String removeSingleLineComment(String line) {
        if (line.contains("//")) {
            return line.substring(0, line.indexOf("//"));
        }

        return line;
    }

    private static String removeStrings(String line) {
        while (line.contains("\"")) { // Multiple strings on the same line
            line = removeFirstString(line);
        }

        return line;
    }

    private static String removeFirstString(String line) {
        line = line.replace("\\\"", ""); // Replace escaped double quotes in string
        line = line.replace("'\"'", ""); // Replace double quotes in char

        if (line.indexOf('"') != -1) {
            String segment1 = line.substring(0, line.indexOf('"'));
            String segment2 = line.substring(line.indexOf('"', line.indexOf('"') + 1) + 1);

            return segment1 + segment2;
        }

        return line;
    }
}
