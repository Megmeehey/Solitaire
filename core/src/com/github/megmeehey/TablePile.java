package com.github.megmeehey;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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

    private void stackDisplay(SpriteBatch mainBatch, Card aCard) {
        // here goes logic for display
        int i = -30;
        for (Card card: cards) {
            i += 30;
            mainBatch.draw(Card.backside, x, y + i);
        }
    }

    @Override
    public void display(SpriteBatch mainBatch) {
        // если не пустая, отрисовать их друг на друге
        stackDisplay(mainBatch, top());
        // иначе, отрисовать пустую ячейку для карт
        // mainBatch.draw(Card.empty, x, y);
    }
}
