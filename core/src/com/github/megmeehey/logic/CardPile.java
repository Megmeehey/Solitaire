package com.github.megmeehey.logic;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.Deque;
import java.util.LinkedList;

public class CardPile {
    protected Deque<com.github.megmeehey.logic.Card> cards;
    protected TextureAtlas atlas;

    public CardPile(TextureAtlas atlas) {
        cards = new LinkedList<com.github.megmeehey.logic.Card>();
        this.atlas = atlas;
    }

    /**
     * Get first card, but not remove.
     * Can be null
     * @return
     */
    com.github.megmeehey.logic.Card peekFirst() {
        return cards.peekFirst();
    } // top

    /**
     * Get first card, and remove.
     * Can be null
     * @return
     */
    com.github.megmeehey.logic.Card pollFirst() {
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
    public void push(com.github.megmeehey.logic.Card cardToAdd) {
        cards.push(cardToAdd);
    }

    /**
     * Removes and returns the first element of CardPile.
     * Can throw NSEE
     * @return first card
     */
    public com.github.megmeehey.logic.Card pop() {
        return cards.pop();
    }

//  public abstract void select(int tx, int ty);

//  canTake
}
