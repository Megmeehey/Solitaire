package com.github.megmeehey;

import java.awt.*;

class TablePile extends CardPile {

    TablePile(int x, int y, int c) {
        // initialize the parent class
        super(x, y);
            // then initialize our pile of cards
            for (int i = 0; i < c; i++) {
            push(Solitaire.deckPile.pop());
        }
        // flip topmost card face up
        top().flip();
    }

    @Override
    public boolean canTake(Card aCard) {
        if (empty()) {
            return false;
        }
        Card topCard = top();
        return (aCard.getColor() != topCard.getColor()) &&
                (aCard.getRank() == Card.Rank.values()[topCard.getRank().ordinal() - 1]);
    }

    @Override
    public void select(int tx, int ty) {
        if (empty()) {
            return;
        }

        // if face down, then flip
        Card topCard = top();
        if (!topCard.isFaceUp()) {
            topCard.flip();
            return;
        }

        // else see if any suit pile can take card
        topCard = pop();
        for (int i = 0; i < 4; i++) {
            if (Solitaire.suitPile[i].canTake(topCard)) {
                Solitaire.suitPile[i].push(topCard);
                return;
            }
        }
        // else see if any other table pile can take card
        for (int i = 0; i < 7; i++) {
            if (Solitaire.tableau[i].canTake(topCard)) {
                Solitaire.tableau[i].push(topCard);
                return;
            }
        }
        // else put it back on our pile
        push(topCard);
    }

    private int stackDisplay(Card aCard) {
        // here goes logic for display
//        int localy;
//        if (aCard == null) {
//            return y;
//        }
//        localy = stackDisplay(g, aCard.link);
//        aCard.draw(g, x, localy);
//        return localy + 35;
        return 35;
    }

    @Override
    public void display() {
        stackDisplay(top());
    }

}
