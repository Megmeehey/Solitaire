//package com.github.megmeehey;
//
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//
//class SuitPile extends CardPile {
//
//    SuitPile(int x, int y) {
//        super(x, y);
//    }
//
//    @Override
//    public boolean canTake(Card aCard) {
//        if (isEmpty()) {
//            // if SuitPile is empty, we can store card here only if it is ACE.
//            return aCard.getRank() == Card.Rank.ACE;
//        }
//        Card topCard = getFirst();
//        return (aCard.getSuit() == topCard.getSuit()) && (aCard.isNextSuitOf(topCard)); // should be nextRank
//    }
//
//    @Override
//    public void display(SpriteBatch mainBatch) {
//        if (cards.isEmpty()) {
//            mainBatch.draw(Card.EMPTY, x, y);
//        } else {
//            Card card = cards.peek();
//            if (!card.isFaceUp()) {
//                card.flip();
//            }
//            mainBatch.draw(card.getTexture(), x, y);
//        }
//    }
//
//    @Override
//    public void select(int tx, int ty) {
//        // TODO
//    }
//}
