package com.github.megmeehey;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.RenderableProvider;
import com.badlogic.gdx.graphics.g3d.utils.MeshBuilder;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.Pool;

import static com.github.megmeehey.Solitaire.CARD_HEIGHT;
import static com.github.megmeehey.Solitaire.CARD_WIDTH;

public class Card {
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

    public static class CardBatch extends ObjectSet<Card> implements RenderableProvider, Disposable {
        Renderable renderable;
        Mesh mesh;
        MeshBuilder meshBuilder;

        public CardBatch(Material material) {
            final int maxNumberOfCards = 52;
            final int maxNumberOfVertices = maxNumberOfCards * 8;
            final int maxNumberOfIndices = maxNumberOfCards * 12;
            mesh = new Mesh(false, maxNumberOfVertices, maxNumberOfIndices,
                    VertexAttribute.Position(), VertexAttribute.Normal(), VertexAttribute.TexCoords(0));
            meshBuilder = new MeshBuilder();

            renderable = new Renderable();
            renderable.material = material;
        }

        @Override
        public void getRenderables(Array<Renderable> renderables, Pool<Renderable> pool) {
            meshBuilder.begin(mesh.getVertexAttributes());
            meshBuilder.part("cards", GL20.GL_TRIANGLES, renderable.meshPart);
            for (Card card : this) {
                meshBuilder.setVertexTransform(card.transform);
                meshBuilder.addMesh(card.vertices, card.indices);
            }
            meshBuilder.end(mesh);

            renderables.add(renderable);
        }

        @Override
        public void dispose() {
            mesh.dispose();
        }
    }

    private final Suit suit;
    private final Rank rank;
    private final Sprite front;
    private final Sprite back;
    private final Color color;
    public final float[] vertices;
    public final short[] indices;
    public final Matrix4 transform = new Matrix4();
    public final Vector3 position = new Vector3();
    public float angle;
    private boolean isFaceUp;

    public Card(Suit suit, Rank rank, TextureAtlas atlas) {
            this.color = ((getSuit()  == Suit.Club) || (getSuit() == Suit.Spade)) ? Color.Black : Color.Red;
            this.suit = suit;
            this.rank = rank;
            front = atlas.createSprite(suit.name + rank.value); // forms name of item in Cards.atlas
            back = atlas.createSprite("cardback");
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

    public void flip() {
        isFaceUp = !isFaceUp;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public boolean isNextSuitOf(Card other) {
        return this.getRank().value == other.getRank().value + 1;
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

    public void update() {
        float z = position.z + 0.5f * Math.abs(MathUtils.sinDeg(angle));
        transform.setToRotation(Vector3.Y, angle);
        transform.trn(position.x, position.y, z);
    }

}