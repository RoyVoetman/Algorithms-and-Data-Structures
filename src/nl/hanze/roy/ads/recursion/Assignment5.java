package nl.hanze.roy.ads.recursion;

public class Assignment5 {
    static float series(float i) {
        if(i == 1) {
            return 1f/3f;
        }

        return i / ((2f*i)+1f) + Assignment5.series(i - 1);
    }

    public static void main(String[] args) {
        System.out.println("Antwoord: " + series(3));
    }
}