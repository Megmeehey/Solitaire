package com.github.megmeehey;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Matrix4;

class Card {
    public final static float CARD_WIDTH = 1f;
    public final static float CARD_HEIGHT = CARD_WIDTH * 277f / 200f;
    public final static float MINIMUM_VIEWPORT_SIZE = 5f;

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

    public enum Color {
        Red, Black;
    }

    public static final Texture BACKSIDE = new Texture("cardback.png");
    public static final Texture EMPTY = new Texture("empty.png");

    private final Suit suit;
    private final Rank rank;
    private final Sprite front;
    private final Sprite back;
    private final Color color;
    public final float[] vertices;
    public final short[] indices;
    public final Matrix4 transform = new Matrix4();
    private boolean isFaceUp;

    public Card(Suit suit, Rank rank, TextureAtlas atlas) {
            front = atlas.createSprite(suit.name + rank.value);
            back = atlas.createSprite("cardback");
            this.color = ((getSuit()  == Suit.Club) || (getSuit() == Suit.Spade)) ? Color.Black : Color.Red;
            this.suit = suit;
            this.rank = rank;

            front.setSize(CARD_WIDTH, CARD_HEIGHT);
            back.setSize(CARD_WIDTH, CARD_HEIGHT);
            front.setPosition(-front.getWidth() * 0.5f, -front.getHeight() * 0.5f);
            back.setPosition(-back.getWidth() * 0.5f, -back.getHeight() * 0.5f);

            vertices = convert(front.getVertices(), back.getVertices());
            indices = new short[] {0, 1, 2, 2, 3, 0, 4, 5, 6, 6, 7, 4 };
        }

    public Suit getSuit() { return suit; }

    public Rank getRank() {
        return rank;
    }

    public Color getColor() {
        return color;
    }

    private static float[] convert(float[] front, float[] back) {
        return new float[] {
                front[Batch.X2], front[Batch.Y2], 0, 0, 0, 1, front[Batch.U2], front[Batch.V2],
                front[Batch.X1], front[Batch.Y1], 0, 0, 0, 1, front[Batch.U1], front[Batch.V1],
                front[Batch.X4], front[Batch.Y4], 0, 0, 0, 1, front[Batch.U4], front[Batch.V4],
                front[Batch.X3], front[Batch.Y3], 0, 0, 0, 1, front[Batch.U3], front[Batch.V3],

                back[Batch.X1], back[Batch.Y1], 0, 0, 0, -1, back[Batch.U1], back[Batch.V1],
                back[Batch.X2], back[Batch.Y2], 0, 0, 0, -1, back[Batch.U2], back[Batch.V2],
                back[Batch.X3], back[Batch.Y3], 0, 0, 0, -1, back[Batch.U3], back[Batch.V3],
                back[Batch.X4], back[Batch.Y4], 0, 0, 0, -1, back[Batch.U4], back[Batch.V4]
        };
    }

    public void flip() {
        isFaceUp = !isFaceUp;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public boolean isNextSuitOf(Card other) {
        return this.getRank() == Card.Rank.values()[(other.getRank().ordinal() + 1) % Rank.values().length];
    }
}