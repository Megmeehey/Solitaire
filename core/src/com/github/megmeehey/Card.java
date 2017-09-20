package com.github.megmeehey;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

class Card {
    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
    public enum Rank { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }
    public enum Color { RED, BLACK }

    public static final Texture backside = new Texture("cardback.png");

    private final Suit suit;
    private final Rank rank;
    private final FileHandle fileHandle;
    private boolean faceup;
    private Texture texture;

    public Card(Suit suit, Rank rank, FileHandle fileHandle) {
        this.suit = suit;
        this.rank = rank;
        this.fileHandle = fileHandle;
        faceup = false;
    }

    // access attributes of card
    public Suit getSuit() { return suit; }

    public Rank getRank() {
        return rank;
    }

    public Color getColor() {
        return getSuit().equals(Suit.CLUBS) || getSuit().equals(Suit.SPADES) ? Color.BLACK : Color.RED;
    }

    public Texture getTexture() {
        if (texture == null) {
            texture = new Texture(fileHandle);
        }
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public boolean isFaceUp() {
        return faceup;
    }

    public void flip() {
        faceup = !faceup;
    }

    public void draw(SpriteBatch mainBatch, int x, int y) {
        mainBatch.draw(texture, x, y);
    }
}