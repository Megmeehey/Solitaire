package com.github.megmeehey;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

class DiscardPile extends CardPile {

    DiscardPile(int x, int y) {
        super(x, y);
    }

    @Override
    public void push(Card aCard) {
        if (!aCard.isFaceUp()) {
            aCard.flip();
        }
        super.push(aCard);
    }

    @Override
    public void select(int tx, int ty) {
        if (isEmpty()) {
            return;
        }
        Card topCard = pop();
        for (int i = 0; i < 4; i++) {
            // Checking, if we can put this card in SuitPiles
            if (Solitaire.suitPile[i].canTake(topCard)) {
                Solitaire.suitPile[i].push(topCard);
                return;
            }
        }
        for (int i = 0; i < 7; i++) {
            // ...if we can't, trying to put this card in TablePiles
            if (Solitaire.tableau[i].canTake(topCard)) {
                Solitaire.tableau[i].push(topCard);
                return;
            }
        }
        // nobody can use it, put it back on our list
        push(topCard);
    }

    @Override
    public void display(SpriteBatch mainBatch) {
        if (isEmpty()) {
            mainBatch.draw(Card.EMPTY, x, y);
        } else {
            Card card = cards.peek();
            if (!card.isFaceUp()) {
                card.flip();
            }
            mainBatch.draw(card.getTexture(), x, y);
        }
    }
}
