package nl.hanze.roy.ads.week4.backtracking;

import java.util.Scanner;

public class Problem {
    private Candidates candidates = new Candidates();
    private Solution solution = new Solution();
    private Scanner reader = new Scanner(System.in);

    public void solve() {
        int index = 0;
        while (index < candidates.size()) {
            if (solution.fits(candidates.get(index))) {
                solution.record(candidates.remove(index)); //move candidate to solution
                if (solution.complete()) {
                    solution.show();
                } else {
                    solve();
                }

                candidates.add(index, solution.eraseRecording()); //move candidate to candidates
            }
            index++;
        }
    }

    public static void main(String[] args) {
        new Problem().solve();
    }

}
        
          
         









