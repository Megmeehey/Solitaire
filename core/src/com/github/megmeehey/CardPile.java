package com.github.megmeehey;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public abstract class CardPile {
    // coordinates of the card pile
    protected int x;
    protected int y;
    protected Array<Card> cards;
    protected int index;

    CardPile(int x, int y) {
        this.x = x;
        this.y = y;
        cards = new Array<Card>();
    }

    Card top() {
        return cards.first();
    }

    public boolean empty() {
        return cards.size == 0;
    }

    public void push(Card cardToAdd) {
        cards.add(cardToAdd);
    }

    public Card pop() {
        return cards.pop();
    }

    public int getIndex() {
        return index;
    }

    public abstract void select(int tx, int ty);

    public abstract void display(SpriteBatch mainBatch);

    public boolean canTake(Card aCard) {
        return false;
    }

}