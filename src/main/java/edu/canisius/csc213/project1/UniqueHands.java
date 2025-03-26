package edu.canisius.csc213.project1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class UniqueHands {
    private static final String CSV_FILE = "unique_hands_result.csv";

    public static void main(String[] args) {
        int[] deckSizes = {28};
        int[] handSizes = {6};
        int trials = 5;

        System.out.println("Deck Simulation: How long to see every possible hand?");
        System.out.println("----------------------------------------------------");
        // TODO: Implement nested loops
            for(int i = 0; i < deckSizes.length; i++){

                for (int j = 0; j < handSizes.length; j++) {

                }
            }
        // Outer loop: Iterates through deck sizes (24, 28)
            
        // Inner loop: Iterates through hand sizes (6, 7)
        // Inside inner loop: Run 5 trials, track time and attempts, and compute averages.  Which is probably another loop!

    }


    // TODO: Implement countAttemptsToSeeAllHands()
    // TODO: Implement calculateTotalUniqueHands()
}