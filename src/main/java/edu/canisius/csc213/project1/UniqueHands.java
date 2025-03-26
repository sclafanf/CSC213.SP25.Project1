package edu.canisius.csc213.project1;

import static org.junit.Assert.assertArrayEquals;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class UniqueHands {
    private static final String CSV_FILE = "unique_hands_result.csv";

    public static void main(String[] args) {
        int[] deckSizes = {24, 28};
        int[] handSizes = {6, 7};
        int trials = 5;

        System.out.println("Deck Simulation: How long to see every possible hand?");
        System.out.println("----------------------------------------------------");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE))) {
            writer.write("Deck Size,Hand Size,Trial,Attempts,Time (sec)\n");
        // TODO: Implement nested loops
            for(int i = 0; i < deckSizes.length; i++){

                for (int j = 0; j < handSizes.length; j++) {
                    for (int k = 1; k <= trials; k++){
                        long start = System.currentTimeMillis();
                        int attempts = countAttemptsToSeeAllHands(deckSizes[i], handSizes[j]);
                        long end = System.currentTimeMillis();
                        double timeTaken =  (end - start) / 1000.0;
                        System.out.printf("Deck Size: %d | Hand size %d | Trial %d | Attemps %d | Time: %3f sec\n",
                            i, j, k, attempts, timeTaken);
                        writer.write(String.format("%d,%d,%d,%d,%.3f\n", deckSizes[i], handSizes[j], k, attempts, timeTaken));
                    }
                }
            }

        // Inner loop: Iterates through hand sizes (6, 7)
        // Inside inner loop: Run 5 trials, track time and attempts, and compute averages.  Which is probably another loop!

    }
    // TODO: Implement countAttemptsToSeeAllHands()
    public static int countAttemptsToSeeAllHands(int deckSize, int handSize){
        Deck deck = new Deck(deckSize);
        Set<Set<Card>> uniqueHands = new HashSet<>();
        Random random = new Random();
        int attempts = 0;
        int totalUniqueHands = calculateTotalUniqueHands(deckSize, handSize);
        while (uniqueHands.size() < totalUniqueHands){
            deck.shuffle();
            Set<Card> hand = new HashSet<>();
            
            for (int i = 0; i < handSize; i++){
                hand.add(deck.draw());

            }
            uniqueHands.add(hand);
            attempts = attempts + 1;

            deck = new Deck(handSize);

            if (attempts % 100_000 == 0){
                int uniqueS = uniqueHands.size();
                int needed = totalUniqueHands - uniqueS;
                double coverage = ((double)uniqueS / totalUniqueHands)* 100;
                System.out.printf("Progress: %.2f%% coverage after %d attempts (Unique Hands: %d / %d | Needed:  %d)", coverage, attempts, uniqueS, uniqueHands, needed);

                
            }
        }
        return attempts; 
    }
    public static int calculateTotalUniqueHands(int n, int k){
        BigInteger total = factorial(n).divide(factorial(k).multiply(factorial(n-k)));
        return total.intValue();

    }
    public static BigInteger factorial(int number){
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= number; i++){
            result = result.multiply(BigInteger.valueOf(i));
        
        }
        return result;
    }
    // TODO: Implement countAttemptsToSeeAllHands()
    // TODO: Implement calculateTotalUniqueHands()
}
    */