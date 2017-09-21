package com.github.megmeehey;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import java.util.Deque;
import java.util.LinkedList;

public class CardPile {
    protected Deque<Card> cards;
    protected TextureAtlas atlas;

    public CardPile(TextureAtlas atlas) {
        cards = new LinkedList<Card>();
        this.atlas = atlas;
    }

    /**
     * Get first card, but not remove.
     * Can be null
     * @return
     */
    Card peekFirst() {
        return cards.peekFirst();
    } // top

    /**
     * Get first card, and remove.
     * Can be null
     * @return
     */
    Card pollFirst() {
        return cards.pollFirst();
    }

    /**
     * Checks if the CardPile is empty
     * @return True if empty. False otherwise.
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    } // empty

    /**
     * Pushes an element in the head of CardPile.
     * Can throw E
     * @param cardToAdd
     */
    public void push(Card cardToAdd) {
        cards.push(cardToAdd);
    }

    /**
     * Removes and returns the first element of CardPile.
     * Can throw NSEE
     * @return first card
     */
    public Card pop() {
        return cards.pop();
    }

//  public abstract void select(int tx, int ty);

//  canTake
}
