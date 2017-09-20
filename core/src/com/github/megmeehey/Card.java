package com.github.megmeehey;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import java.io.File;

class Card {
    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
    public enum Rank { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }

    /*private static final String names[] = {"A", "2", "3", "4", "5", "6",
        "7", "8", "9", "10", "J", "Q", "K"};*/

    // data fields
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

    public Texture getTexture() {
        if (texture == null) {
            texture = new Texture(fileHandle);
        }
        return texture;
    }

    public boolean isFaceUp() {
        return faceup;
    }

    public void flip() {
        faceup = !faceup;
    }
}