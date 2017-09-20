package com.github.megmeehey;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

import java.util.Deque;

abstract class CardPile {
    // coordinates of the card pile
    protected int x;
    protected int y;
    private Array<Card> cards;
    private int index;

    CardPile(int x, int y) {
        this.x = x;
        this.y = y;
        cards = null;
    }

    public Card top() {
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

    public void shuffleDeck() {
        cards.shuffle();
        index = 0;
    }

    public int getIndex() {
        return index;
    }

    public boolean includes(int tx, int ty) {
//        return x <= tx && tx <= x + Card.width &&
//                y <= ty && ty <= y + Card.height;
    }

    public void select(int tx, int ty) {
        // do nothing
    }

    public void display() {
//        g.setColor(Color.black);
//        if (firstCard == null) {
//            g.drawRect(x, y, Card.width, Card.height);
//        } else {
//            firstCard.draw(g, x, y);
//        }
    }

    public boolean canTake(Card aCard) {
        return false;
    }

}