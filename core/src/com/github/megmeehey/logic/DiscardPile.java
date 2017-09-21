package com.github.megmeehey.logic;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

class DiscardPile extends com.github.megmeehey.logic.CardPile {

    DiscardPile(TextureAtlas atlas) {
        super(atlas);
    }

    @Override
    public void push(com.github.megmeehey.logic.Card aCard) {
        if (!aCard.isFaceUp()) {
            aCard.flip();
        }
        super.push(aCard);
    }

//    @Override
//    public void select(int tx, int ty) {
//        if (isEmpty()) {
//            return;
//        }
//        Card topCard = pop();
//        for (int i = 0; i < 4; i++) {
//            // Checking, if we can put this card in SuitPiles
//            if (Solitaire.suitPile[i].canTake(topCard)) {
//                Solitaire.suitPile[i].push(topCard);
//                return;
//            }
//        }
//        for (int i = 0; i < 7; i++) {
//            // ...if we can't, trying to put this card in TablePiles
//            if (Solitaire.tableau[i].canTake(topCard)) {
//                Solitaire.tableau[i].push(topCard);
//                return;
//            }
//        }
//        // nobody can use it, put it back on our list
//        push(topCard);
//    }
}
