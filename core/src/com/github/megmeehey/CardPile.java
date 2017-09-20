package com.github.megmeehey;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Deque;
import java.util.LinkedList;

public abstract class CardPile {
    // coordinates of the card pile
    protected int x;
    protected int y;
    protected Deque<Card> cards;

    CardPile(int x, int y) {
        this.x = x;
        this.y = y;
        cards = new LinkedList<Card>();
    }

    /**
     * Get first card
     * @return
     */
    Card getFirst() {
        return cards.getFirst();
    }

    /**
     * Checks if the CardPile is empty
     * @return True if empty. False otherwise.
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public void push(Card cardToAdd) {
        cards.push(cardToAdd);
    }

    public Card pop() {
        return cards.pop();
    }

    public abstract void select(int tx, int ty);

    public abstract void display(SpriteBatch mainBatch);

    public boolean canTake(Card aCard) {
        return false;
    }

}