package com.github.megmeehey;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.ACE, Gdx.files.internal("club1.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.TWO, Gdx.files.internal("club2.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.THREE, Gdx.files.internal("club3.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.FOUR, Gdx.files.internal("club4.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.FIVE, Gdx.files.internal("club5.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.SIX, Gdx.files.internal("club6.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.SEVEN, Gdx.files.internal("club7.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.EIGHT, Gdx.files.internal("club8.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.NINE, Gdx.files.internal("club9.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.TEN, Gdx.files.internal("club10.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.JACK, Gdx.files.internal("club11.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.QUEEN, Gdx.files.internal("club12.png")));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.KING, Gdx.files.internal("club13.png")));

        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE, Gdx.files.internal("diamond1.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO, Gdx.files.internal("diamond2.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.THREE, Gdx.files.internal("diamond3.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.FOUR, Gdx.files.internal("diamond4.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.FIVE, Gdx.files.internal("diamond5.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.SIX, Gdx.files.internal("diamond6.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.SEVEN, Gdx.files.internal("diamond7.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.EIGHT, Gdx.files.internal("diamond8.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.NINE, Gdx.files.internal("diamond9.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TEN, Gdx.files.internal("diamond10.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.JACK, Gdx.files.internal("diamond11.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.QUEEN, Gdx.files.internal("diamond12.png")));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.KING, Gdx.files.internal("diamond13.png")));

        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.ACE, Gdx.files.internal("heart1.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.TWO, Gdx.files.internal("heart2.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.THREE, Gdx.files.internal("heart3.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.FOUR, Gdx.files.internal("heart4.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.FIVE, Gdx.files.internal("heart5.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.SIX, Gdx.files.internal("heart6.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.SEVEN, Gdx.files.internal("heart7.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.EIGHT, Gdx.files.internal("heart8.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.NINE, Gdx.files.internal("heart9.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.TEN, Gdx.files.internal("heart10.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.JACK, Gdx.files.internal("heart11.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.QUEEN, Gdx.files.internal("heart12.png")));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.KING, Gdx.files.internal("heart13.png")));

        cards.add(new Card(Card.Suit.SPADES, Card.Rank.ACE, Gdx.files.internal("spade1.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.TWO, Gdx.files.internal("spade2.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.THREE, Gdx.files.internal("spade3.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.FOUR, Gdx.files.internal("spade4.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.FIVE, Gdx.files.internal("spade5.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.SIX, Gdx.files.internal("spade6.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.SEVEN, Gdx.files.internal("spade7.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.EIGHT, Gdx.files.internal("spade8.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.NINE, Gdx.files.internal("spade9.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.TEN, Gdx.files.internal("spade10.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.JACK, Gdx.files.internal("spade11.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.QUEEN, Gdx.files.internal("spade12.png")));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.KING, Gdx.files.internal("spade13.png")));
    }

    @Override
    public void display(SpriteBatch mainBatch) {
        // if непустая, отрисовать рубашку
        mainBatch.draw(cards.first().getTexture(), x, y);
        // иначе, отрисовать пустую ячейку для карты
    }

    @Override
    public void select(int tx, int ty) {
        if (empty()) {
            Card card;
            card = Solitaire.discardPile.pop();
            while (card != null) {
                if (card.isFaceUp()) {
                    card.flip();
                }
                Solitaire.deckPile.push(card);
                card = Solitaire.discardPile.pop();
            }
            return;
        }
        Solitaire.discardPile.push(pop());
    }
}
