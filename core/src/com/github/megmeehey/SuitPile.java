package com.github.megmeehey;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;

class SuitPile extends CardPile {

    SuitPile(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canTake(Card aCard) {
        if (empty()) {
            return false;
        }
        Card topCard = top();
        return (aCard.getSuit() == topCard.getSuit()) &&
                (aCard.getRank() == Card.Rank.values()[topCard.getRank().ordinal() + 1]); // should be nextRank
    }

    @Override
    public void display(SpriteBatch mainBatch) {
        // if непустая отрисовать последнюю положенную карту
        mainBatch.draw(Card.backside, x, y);
        // иначе, отрисовать пустую ячейку для карт
    }

    @Override
    public void select(int tx, int ty) {
        // TODO
    }
}
