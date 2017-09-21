package com.github.megmeehey;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Solitaire extends ApplicationAdapter {
    public static final String CARDBACK = "cardback";
    public final static float CARD_WIDTH = 1f;
    public final static float CARD_HEIGHT = CARD_WIDTH * 277f / 200f;
    public final static float MINIMUM_VIEWPORT_SIZE = 5f;

    SpriteBatch batch;
    Texture background;
    int width;
    int height;
    static DeckPile deckPile;
    static DiscardPile discardPile;
    static TablePile[] tableau;
    static SuitPile[] suitPile;
    static CardPile[] allPiles;

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("fabric.jpg");

        // first allocate the arrays
        allPiles = new CardPile[13];
        suitPile = new SuitPile[4];
        tableau = new TablePile[7];
        // then fill them in
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        allPiles[0] = deckPile = new DeckPile(350 + 85 + 85,height - 130);
        allPiles[1] = discardPile = new DiscardPile(350 + 85, height - 130);
        for (int i = 0; i < 4; i++) {
            allPiles[2 + i] = suitPile[i] =
                    new SuitPile(10 + 85 * i, height - 130);
        }
        for (int i = 0; i < 7; i++) {
            allPiles[6 + i] = tableau[i] =
                    new TablePile(10 + 85 * i, height - 260, i + 1);
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(48, 93, 53, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0);
        for (CardPile pile : allPiles) {
            pile.display(batch);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
    }

}

/*
public class Solitare extends Applet {
	static DeckPile deckPile;
	static DiscardPile discardPile;
	static TablePile tableau[];
	static SuitPile suitPile[];
	static CardPile allPiles[];

	@Override
	public void init() {
		// first allocate the arrays
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
	public void paint(Graphics g) {
		for (int i = 0; i < 13; i++) {
			allPiles[i].display(g);
		}
	}

	@Override
	public boolean mouseDown(Event evt, int x, int y) {
		for (int i = 0; i < 13; i++) {
			if (allPiles[i].includes(x, y)) {
				allPiles[i].select(x, y);
				repaint();
				return true;
			}
		}
		return true;
	}
}
 */