package com.github.megmeehey;

import com.badlogic.gdx.Gdx;
import com.github.megmeehey.Solitaire;

class DeckPile extends CardPile {

    DeckPile(int x, int y) {
        super(x, y);
        loadDeck();
        shuffleDeck();
    }

    public void shuffleDeck() {
        cards.shuffle();
        index = 0;
    }

    private void loadDeck() {
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.ACE, Gdx.files.internal("c01.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.TWO, Gdx.files.internal("c02.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.THREE, Gdx.files.internal("c03.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.FOUR, Gdx.files.internal("c04.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.FIVE, Gdx.files.internal("c05.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.SIX, Gdx.files.internal("c06.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.SEVEN, Gdx.files.internal("c07.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.EIGHT, Gdx.files.internal("c08.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.NINE, Gdx.files.internal("c09.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.TEN, Gdx.files.internal("c10.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.JACK, Gdx.files.internal("c11.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.QUEEN, Gdx.files.internal("c12.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.KING, Gdx.files.internal("c13.png")));

        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE, Gdx.files.internal("d01.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO, Gdx.files.internal("d02.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.THREE, Gdx.files.internal("d03.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.FOUR, Gdx.files.internal("d04.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.FIVE, Gdx.files.internal("d05.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.SIX, Gdx.files.internal("d06.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.SEVEN, Gdx.files.internal("d07.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.EIGHT, Gdx.files.internal("d08.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.NINE, Gdx.files.internal("d09.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TEN, Gdx.files.internal("d10.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.JACK, Gdx.files.internal("d11.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.QUEEN, Gdx.files.internal("d12.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.KING, Gdx.files.internal("d13.png")));

        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.ACE, Gdx.files.internal("h01.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.TWO, Gdx.files.internal("h02.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.THREE, Gdx.files.internal("h03.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.FOUR, Gdx.files.internal("h04.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.FIVE, Gdx.files.internal("h05.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.SIX, Gdx.files.internal("h06.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.SEVEN, Gdx.files.internal("h07.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.EIGHT, Gdx.files.internal("h08.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.NINE, Gdx.files.internal("h09.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.TEN, Gdx.files.internal("h10.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.JACK, Gdx.files.internal("h11.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.QUEEN, Gdx.files.internal("h12.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.KING, Gdx.files.internal("h13.png")));

        cards.add(new Card(Card.Suit.SPADES, Card.Rank.ACE, Gdx.files.internal("s01.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.TWO, Gdx.files.internal("s02.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.THREE, Gdx.files.internal("s03.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.FOUR, Gdx.files.internal("s04.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.FIVE, Gdx.files.internal("s05.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.SIX, Gdx.files.internal("s06.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.SEVEN, Gdx.files.internal("s07.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.EIGHT, Gdx.files.internal("s08.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.NINE, Gdx.files.internal("s09.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.TEN, Gdx.files.internal("s10.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.JACK, Gdx.files.internal("s11.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.QUEEN, Gdx.files.internal("s12.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.KING, Gdx.files.internal("s13.png")));
    }

    @Override
    public void display() {
        // TODO
    }

    @Override
    public void select(int tx, int ty) {
        // TODO
//        if (empty()) {
//            Card card;
//            card = Solitare.discardPile.pop();
//            while (card != null) {
//                if (card.isFaceUp()) {
//                    card.flip();
//                }
//                Solitare.deckPile.push(card);
//                card = Solitare.discardPile.pop();
//            }
//            return;
//        }
//        Solitare.discardPile.push(pop());
    }
}
