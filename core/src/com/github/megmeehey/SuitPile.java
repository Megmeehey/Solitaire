package com.github.megmeehey;


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
    public void display() {
        // TODO
    }

    @Override
    public void select(int tx, int ty) {
        // TODO
    }
}
