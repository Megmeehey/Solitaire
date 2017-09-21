package com.github.megmeehey;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.RenderableProvider;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.MeshBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.Pool;

public class Solitaire implements ApplicationListener {
    public final static float CARD_WIDTH = 1f;
    public final static float CARD_HEIGHT = CARD_WIDTH * 277f / 200f;
    public final static float MINIMUM_VIEWPORT_SIZE = 5f;

    TextureAtlas atlas;
    Sprite front;
    Sprite back;
    PerspectiveCamera cam;
    CardPile deck;
    Card.CardBatch cards;
    CameraInputController camController;
    ModelBatch modelBatch;
    Model tableTopModel;
    ModelInstance tableTop;

    @Override
    public void create() {
        modelBatch = new ModelBatch();
        atlas = new TextureAtlas("Cards.atlas");
        Material material = new Material(
                TextureAttribute.createDiffuse(atlas.getTextures().first()),
                new BlendingAttribute(false, 1f),
                FloatAttribute.createAlphaTest(0.5f));
        cards = new Card.CardBatch(material);

        deck = new DeckPile(atlas);

        Card card1 = deck.pollFirst();
        card1.position.set(-1, 0, 0.01f);
        card1.update();
        cards.add(card1);

        Card card2 = deck.pollFirst();
        card2.position.set(0, 0, 0.01f);
        card2.update();
        cards.add(card2);

        Card card3 = deck.pollFirst();
        card3.position.set(1, 0, 0.01f);
        card3.update();
        cards.add(card3);

        cam = new PerspectiveCamera();
        cam.position.set(0, 0, 10);
        cam.lookAt(0, 0, 0);
        camController = new CameraInputController(cam);
        Gdx.input.setInputProcessor(camController);

        ModelBuilder builder = new ModelBuilder();
        builder.begin();
        builder.node().id = "top";
        builder.part("top", GL20.GL_TRIANGLES, Usage.Position | Usage.Normal,
                new Material(ColorAttribute.createDiffuse(new Color(0x63750A))))
                .box(0f, 0f, -0.5f, 20f, 20f, 1f);
        tableTopModel = builder.end();
        tableTop = new ModelInstance(tableTopModel);
    }

    @Override
    public void resize(int width, int height) {
        float halfHeight = MINIMUM_VIEWPORT_SIZE * 0.5f;
        if (height > width)
            halfHeight *= (float)height / (float)width;
        float halfFovRadians = MathUtils.degreesToRadians * cam.fieldOfView * 0.5f;
        float distance = halfHeight / (float)Math.tan(halfFovRadians);

        cam.viewportWidth = width;
        cam.viewportHeight = height;
        cam.position.set(0, 0, distance);
        cam.lookAt(0, 0, 0);
        cam.update();
    }

    @Override
    public void render() {
        final float delta = Math.min(1/30f, Gdx.graphics.getDeltaTime());

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        camController.update();

        Card card = cards.first();
        card.angle = (card.angle + 90 * delta) % 360;
        card.update();

        modelBatch.begin(cam);
        modelBatch.render(tableTop);
        modelBatch.render(cards);
        modelBatch.end();
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
    }

    @Override
    public void dispose() {
        modelBatch.dispose();
        atlas.dispose();
        cards.dispose();
        tableTopModel.dispose();
    }
}