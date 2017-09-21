package com.github.megmeehey;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

class Card {
    public enum Suit {
        Club("club", 0), Diamond("diamond", 1), Heart("heart", 2), Spade("spade", 3);
        public final String name;
        public final int index;

        private Suit(String name, int index) {
            this.name = name;
            this.index = index;
        }
    }

    public enum Rank {
        Ace(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(11), Queen(12), King(13);
        public final int value;

        private Rank(int value) {
            this.value = value;
        }
    }

    public static final Texture BACKSIDE = new Texture("cardback.png");
    public static final Texture EMPTY = new Texture("empty.png");

    private final Suit suit;
    private final Rank rank;
    private final Color color;
    private boolean faceup;
    private Texture texture;

    public Card(Suit suit, Rank rank, FileHandle fileHandle) {
        this.suit = suit;
        this.rank = rank;
        this.color = ((getSuit()  == Suit.CLUBS) || (getSuit() == Suit.SPADES)) ? Color.BLACK : Color.RED;
        this.texture = new Texture(fileHandle);
        this.faceup = false;
    }

    public Suit getSuit() { return suit; }

    public Rank getRank() {
        return rank;
    }

    public Color getColor() {
        return color;
    }

    public Texture getTexture() {
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

    public boolean isNextSuitOf(Card other) {
        return this.getRank() == Card.Rank.values()[(other.getRank().ordinal() + 1) % Rank.values().length];
    }

    public void draw(SpriteBatch mainBatch, int x, int y) {
        mainBatch.draw(texture, x, y);
    }
}