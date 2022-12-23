package com.tank.stars;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tank.stars.Screens.Start;
import com.tank.stars.Screens.Battlefield;

public class TankStars extends Game {
	public SpriteBatch batch;
	private Sound dropSound;
	private Music menuMusic;
	public static final float PPM = 100;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new Start(this));
		dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
		menuMusic = Gdx.audio.newMusic(Gdx.files.internal("menu-ost.mp3"));

		menuMusic.setLooping(true);
		menuMusic.play();



	}

	@Override
	public void render () {
		super.render();

//		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) bucket.x -= 200 * Gdx.graphics.getDeltaTime();
//		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) bucket.x += 200 * Gdx.graphics.getDeltaTime();
//		if (bucket.x < 0) bucket.x = 0;
//		if (bucket.x > 1920 - 64) bucket.x = 1920 - 64;
//
//		if (TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnRaindrop();
//
//		Rectangle raindrop = null;
//		batch.begin();
//		font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
//		font.draw(batch, "Score: " + score, 25, 160);
//		batch.end();
//		for (Iterator<Rectangle> iter = raindrops.iterator(); iter.hasNext(); ) {
//			raindrop = iter.next();
//			raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
//			if (raindrop.y + 64 < 0) iter.remove();
//
//			if (raindrop.overlaps(bucket)) {
//				dropSound.play();
//				iter.remove();
//				score++;
//			}
//		}
//
//		batch.begin();
//		batch.draw(bucketImage, bucket.x, bucket.y);
//		for (Rectangle rd : raindrops) {
//			batch.draw(dropImage, rd.x, rd.y);
//		}
//		batch.end();
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

