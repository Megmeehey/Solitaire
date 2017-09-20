package com.github.megmeehey;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;


public class GameScreen implements Screen {
    final Solitaire game;
    OrthographicCamera camera;
    Texture background;
    Solitaire s = new Solitaire();

    static DeckPile deckPile;
    static DiscardPile discardPile;
    static TablePile[] tableau;
    static SuitPile[] suitPile;
    static CardPile[] allPiles;

    public GameScreen(Solitaire game) {
        this.game = game;


        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        allPiles = new CardPile[13];
        suitPile = new SuitPile[4];
        tableau = new TablePile[7];
        // then fill them in
        allPiles[0] = deckPile = new DeckPile(335, 5);
        allPiles[1] = discardPile = new DiscardPile(268, 5);
        for (int i = 0; i < 4; i++) {
            allPiles[2 + i] = suitPile[i] =
                    new SuitPile(15 + 60 * i, 5);
        }
        for (int i = 0; i < 7; i++) {
            allPiles[6 + i] = tableau[i] =
                    new TablePile(5 + 55 * i, 80, i + 1);
        }
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(48, 93, 53, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        if (Gdx.input.isTouched()) {
            // LOGIC TO UNDERSTAND, WHAT IS TOUCHED?
        }

        game.batch.begin();
        //batch.draw(background, 0, 0);
        for (CardPile pile : allPiles) {
            pile.display(game.batch);
        }
        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}
}