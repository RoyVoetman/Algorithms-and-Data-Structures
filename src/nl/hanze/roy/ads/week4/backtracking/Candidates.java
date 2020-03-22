package nl.hanze.roy.ads.week4.backtracking;

import java.util.Iterator;
import java.util.LinkedList;

public class Candidates extends LinkedList<Candidate> {

    public Candidates() {
        super.add(new Candidate('A', 2)); //Ace
        super.add(new Candidate('H', 2)); //King
        super.add(new Candidate('V', 2)); //Queen
        super.add(new Candidate('B', 2)); //Jack
    }

    public Candidate remove(int index) //overwrites super.remove
    {
        Candidate candidate = get(index);
        candidate.takeOne();
        if (candidate.getAvailable() == 0) {
            candidate = super.remove(index);
        }
        return candidate;
    }

    public void add(int index, Candidate candidate) //overwrites super.add
    {
        candidate.addOne();
        if (candidate.getAvailable() == 1) {
            super.add(index, candidate);
        }
    }

    public String toString() {
        Iterator it = iterator();
        String rS = "";
        while (it.hasNext()) {
            rS += it.next() + " ";
        }
        return rS;
    }

}

    
    
