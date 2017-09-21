package com.github.megmeehey;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.github.megmeehey.Card.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class DeckPile extends CardPile {

    DeckPile(TextureAtlas atlas) {
        super(atlas);
        loadDeck();
        this.cards = shuffleDeck();
    }

    public Deque<Card> shuffleDeck() {
        Deque<Card> shuffledDeck = new LinkedList<Card>();
        List<Card> ls = (List<Card>) cards;
        while (ls.size() > 0) {
            int index = (int) (Math.random() * cards.size());
            shuffledDeck.add(ls.remove(index));
        }
        return shuffledDeck;
    }

    private void loadDeck() {
        cards.add(new Card(Suit.Club, Rank.Ace, this.atlas));
        cards.add(new Card(Suit.Club, Rank.Two, this.atlas));
        cards.add(new Card(Suit.Club, Rank.Three, this.atlas));
        cards.add(new Card(Suit.Club, Rank.Four, this.atlas));
        cards.add(new Card(Suit.Club, Rank.Five, this.atlas));
        cards.add(new Card(Suit.Club, Rank.Six, this.atlas));
        cards.add(new Card(Suit.Club, Rank.Seven, this.atlas));
        cards.add(new Card(Suit.Club, Rank.Eight, this.atlas));
        cards.add(new Card(Suit.Club, Rank.Nine, this.atlas));
        cards.add(new Card(Suit.Club, Rank.Ten, this.atlas));
        cards.add(new Card(Suit.Club, Rank.Jack, this.atlas));
        cards.add(new Card(Suit.Club, Rank.Queen, this.atlas));
        cards.add(new Card(Suit.Club, Rank.King, this.atlas));

        cards.add(new Card(Suit.Diamond, Rank.Ace, this.atlas));
        cards.add(new Card(Suit.Diamond, Rank.Two, this.atlas));
        cards.add(new Card(Suit.Diamond, Rank.Three, this.atlas));
        cards.add(new Card(Suit.Diamond, Rank.Four, this.atlas));
        cards.add(new Card(Suit.Diamond, Rank.Five, this.atlas));
        cards.add(new Card(Suit.Diamond, Rank.Six, this.atlas));
        cards.add(new Card(Suit.Diamond, Rank.Seven, this.atlas));
        cards.add(new Card(Suit.Diamond, Rank.Eight, this.atlas));
        cards.add(new Card(Suit.Diamond, Rank.Nine, this.atlas));
        cards.add(new Card(Suit.Diamond, Rank.Ten, this.atlas));
        cards.add(new Card(Suit.Diamond, Rank.Jack, this.atlas));
        cards.add(new Card(Suit.Diamond, Rank.Queen, this.atlas));
        cards.add(new Card(Suit.Diamond, Rank.King, this.atlas));

        cards.add(new Card(Suit.Heart, Rank.Ace, this.atlas));
        cards.add(new Card(Suit.Heart, Rank.Two, this.atlas));
        cards.add(new Card(Suit.Heart, Rank.Three, this.atlas));
        cards.add(new Card(Suit.Heart, Rank.Four, this.atlas));
        cards.add(new Card(Suit.Heart, Rank.Five, this.atlas));
        cards.add(new Card(Suit.Heart, Rank.Six, this.atlas));
        cards.add(new Card(Suit.Heart, Rank.Seven, this.atlas));
        cards.add(new Card(Suit.Heart, Rank.Eight, this.atlas));
        cards.add(new Card(Suit.Heart, Rank.Nine, this.atlas));
        cards.add(new Card(Suit.Heart, Rank.Ten, this.atlas));
        cards.add(new Card(Suit.Heart, Rank.Jack, this.atlas));
        cards.add(new Card(Suit.Heart, Rank.Queen, this.atlas));
        cards.add(new Card(Suit.Heart, Rank.King, this.atlas));

        cards.add(new Card(Suit.Spade, Rank.Ace, this.atlas));
        cards.add(new Card(Suit.Spade, Rank.Two, this.atlas));
        cards.add(new Card(Suit.Spade, Rank.Three, this.atlas));
        cards.add(new Card(Suit.Spade, Rank.Four, this.atlas));
        cards.add(new Card(Suit.Spade, Rank.Five, this.atlas));
        cards.add(new Card(Suit.Spade, Rank.Six, this.atlas));
        cards.add(new Card(Suit.Spade, Rank.Seven, this.atlas));
        cards.add(new Card(Suit.Spade, Rank.Eight, this.atlas));
        cards.add(new Card(Suit.Spade, Rank.Nine, this.atlas));
        cards.add(new Card(Suit.Spade, Rank.Ten, this.atlas));
        cards.add(new Card(Suit.Spade, Rank.Jack, this.atlas));
        cards.add(new Card(Suit.Spade, Rank.Queen, this.atlas));
        cards.add(new Card(Suit.Spade, Rank.King, this.atlas));
    }
}

    /**
     * On click if empty, remove all cards from discard and move to deck
     * else, push to DiscardPile first element of this deque and remove it from DeckPile
     * @param tx
     * @param ty
     */
    // TODO select logic
//    public void select(int tx, int ty) {
//        if (isEmpty()) {
//            Card card = Solitaire.discardPile.pop();
//            while (card != null) {
//                if (card.isFaceUp()) {
//                    card.flip();
//                }
//                Solitaire.deckPile.push(card);
//                card = Solitaire.discardPile.pop();
//            }
//        } else {
//            Solitaire.discardPile.push(pop());
//        }
//        return;
//    }
