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
        getFirst().flip();
    }

    @Override
    public boolean canTake(Card aCard) {
        if (isEmpty()) {
            // if empty, we can put here only the King
            return aCard.getRank() == Card.Rank.KING;
        }
        Card topCard = getFirst();
        return (aCard.getColor() != topCard.getColor()) &&
                (topCard.isNextSuitOf(aCard));
    }

    @Override
    public void select(int tx, int ty) {
        if (isEmpty()) {
            return;
        }

        // if face down, then flip
        Card topCard = getFirst();
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

    @Override
    public void display(SpriteBatch mainBatch) {
        if (isEmpty()) {
            mainBatch.draw(Card.EMPTY, x, y);
        } else {
            int i = 0;
            for (Card card : cards) {
                if (i != cards.size() - 1) {
                    mainBatch.draw(Card.BACKSIDE, x, y - i * 40);
                    i++;
                } else {
                    mainBatch.draw(card.getTexture(), x, y - i * 40);
                }
            }
        }
    }
}
