package com.tank.stars;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class TankStars extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture mainBgImage;
	private Texture bucketImage;
	private Sound dropSound;
	private Music menuMusic;
	private OrthographicCamera camera;
	private Rectangle bucket;
	private int score = 0;
	
	@Override
	public void create () {
		font = new BitmapFont();
		batch = new SpriteBatch();
		mainBgImage = new Texture(Gdx.files.internal("main-bg.png"));
		bucketImage = new Texture(Gdx.files.internal("bucket.png"));

		dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
		menuMusic = Gdx.audio.newMusic(Gdx.files.internal("menu-ost.mp3"));

		menuMusic.setLooping(true);
		menuMusic.play();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1920, 1080);

		batch = new SpriteBatch();

		bucket = new Rectangle();
		bucket.x = 1920 / 2 - 64 / 2;
		bucket.y = 20;
		bucket.width = 1920;
		bucket.height = 1080;

		raindrops = new Array<Rectangle>();

	}
	private Vector3 touchPos = new Vector3();
	private Array<Rectangle> raindrops;
	private long lastDropTime;
	private BitmapFont font;

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		ScreenUtils.clear(0, 0, 0.2f, 1);
		camera.update();
		batch.begin();
		batch.end();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(mainBgImage, 0, 0);
		batch.end();

		if (Gdx.input.isTouched()) {
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			bucket.x = touchPos.x - 64 / 2;
		}

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
