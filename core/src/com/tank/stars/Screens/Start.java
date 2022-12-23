package com.tank.stars.Screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tank.stars.TankStars;

public class Start implements Screen {
    public SpriteBatch batch;
    private TankStars game;
    private Texture mainBgImage;
    private Texture bucketImage;
    private Sound dropSound;
    private Music menuMusic;
    private OrthographicCamera camera;
    private Rectangle bucket;
    private int score = 0;
    private Sprite start;
    public Start(TankStars game) {
        this.game=game;
    }



    @Override
    public void render (float delta) {
        ScreenUtils.clear(1, 0, 0, 1);
        ScreenUtils.clear(0, 0, 0.2f, 1);
        batch.begin();
        start.draw(batch);
        batch.end();
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            game.setScreen(new Menu(game));
        }

    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        mainBgImage = new Texture(Gdx.files.internal("main-bg.png"));
        start = new Sprite(mainBgImage);
        start.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose () {
//		batch.dispose();
//		dropImage.dispose();
//		bucketImage.dispose();
//		dropSound.dispose();
//		rainMusic.dispose();
//		batch.dispose();
    }
}


