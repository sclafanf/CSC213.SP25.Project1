package edu.canisius.csc213.project1;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import edu.canisius.csc213.project1.Card.Suit;
import java.util.*;

/**
 * Represents a deck of playing cards with a configurable size.
 */
public class Deck {
    private final List<Card> cards;
    private static final int max_size = 52;
    private static final String[] Ranks = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
    private static final String[] Suits = {"HEARTS", "DIAMONDS", "CLUBS", "SPADES"};
    /**
     * Creates a deck with a given size.
     * The size must be a multiple of 4 and at most 52.
     * 
     * @param size The number of cards in the deck.
     * @throws IllegalArgumentException if size is invalid.
     */
    public Deck(int size) {
        if (size % 4 != 0 || size <= 0 || size > max_size) {
           throw new IllegalArgumentException("Must be a multiple of 4 and at most 52");

        }
        cards = new ArrayList<>();
        initializeDeck(size);
    }
    private void initializeDeck(int size) {
        while (cards.size() < size) {
            for (String cardRank : Ranks) {

        
            for (String cardSuit : Suits) {
                cards.add(new Card(Card.Suit.valueOf(cardSuit), Card.Rank.valueOf(cardRank)));
            }
        }
        }

        
        //  Card card1 = new Card(Card.Suit.CLUBS, Card.Rank.TEN);
        // card2 = new Card(Card.Suit.CLUBS, Card.Rank.TEN);
        // Card card3 = new Card(Card.Suit.DIAMONDS, Card.Rank.TEN);
    }
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Draws the top card from the deck.
     * 
     * @return The drawn card.
     * @throws NoSuchElementException if the deck is empty.
     */
    public Card draw() {
        if (cards.isEmpty()) {
            throw new NoSuchElementException("The Deck is empty.");
        }
        
        // TODO: Implement draw logic.
        return cards.remove(0);
    }

    /**
     * Gets the number of remaining cards in the deck.
     *
     * @return The number of cards left.
     */
    public int size() {
        // TODO: Implement size method.
        return cards.size();
    }
}