package com.tank.stars.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.tank.stars.Bullet;
import com.tank.stars.Objs.Ground;
import com.tank.stars.TankStars;
import com.tank.stars.sprites.Tank1;
import com.tank.stars.sprites.Tank2;
import org.w3c.dom.Text;

public class Battlefield implements Screen{
    //Reference to our Game, used to set Screens
    private TextureAtlas atlas;
    private TankStars game;
    public static boolean alreadyDestroyed = false;

    //basic playscreen variables
    private OrthographicCamera gamecam;
    private Viewport gamePort;

    //Tiled map variables
    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;




    //sprites


    private Music music;

    private World world;
    private Box2DDebugRenderer bdr;
    private Tank1 t1;
    private Tank2 t2;
    private Texture txt;
    private Texture txt1;
    private Bullet b;
    public Battlefield(TankStars game){

        txt = new Texture("tank1-player.png");
        txt1 = new Texture("tank2-enemy.png");
        this.game = game;
        //create cam used to follow mario through cam world
        gamecam = new OrthographicCamera();

        //create a FitViewport to maintain virtual aspect ratio despite screen size
        gamePort = new FitViewport(608 , 368, gamecam);

        //create our game HUD for scores/timers/level info

        //Load our map and setup our map renderer
        maploader = new TmxMapLoader();
        map = maploader.load("untitled.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1  );

        gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);
        world =new World(new Vector2(0,-10),true);
        bdr=new Box2DDebugRenderer();
        t1 = new Tank1(world,this);
        t2 = new Tank2(world,this);
        //b = new Bullet(world);
        new Ground(world,map);

        //create our Box2D world, setting no gravity in X, -10 gravity in Y, and allow bodies to sleep
        //world = new World(new Vector2(0, -10), true);
        //allows for debug lines of our box2d world.
        //b2dr = new Box2DDebugRenderer();

    }



    public TextureAtlas getAtlas(){
        return atlas;
    }

    @Override
    public void show() {


    }

    public void handleInput(float dt){

        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            t1.body.applyLinearImpulse(new Vector2(0.3f,0),t1.body.getWorldCenter(),true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            t1.body.applyLinearImpulse(new Vector2(-0.3f,0),t1.body.getWorldCenter(),true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            t2.body.applyLinearImpulse(new Vector2(0.3f,0),t2.body.getWorldCenter(),true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            t2.body.applyLinearImpulse(new Vector2(-0.3f,0),t2.body.getWorldCenter(),true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            b = new Bullet(world);
            b.b.applyLinearImpulse(new Vector2(10f,10f),t1.body.getLocalCenter(),true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.F)){
            b = new Bullet(world);
            b.b.applyLinearImpulse(new Vector2(-10f,10f),t2.body.getLocalCenter(),true);
        }
    }

    public void update(float dt){
        //handle user input first
        handleInput(dt);

        world.step(1/60f,6,2);
        t1.update(dt);
        t2.update(dt);
        //takes 1 step in the physics simulation(60 times per second)




        //update our gamecam with correct coordinates after changes
        gamecam.update();
        //tell our renderer to draw only what our camera can see in our game world.
        renderer.setView(gamecam);

    }


    @Override
    public void render(float delta) {
        //separate our update logic from render
        update(delta);

        //Clear the game screen with Black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //render our game map
        renderer.render();
        bdr.render(world,gamecam.combined);

        //renderer our Box2DDebugLines

        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        game.batch.draw(txt,t1.body.getPosition().x,t1.body.getPosition().y,32,32);
        game.batch.draw(txt1,t2.body.getPosition().x,t2.body.getPosition().y,32,32);
        game.batch.end();



    }


    @Override
    public void resize(int width, int height) {
        //updated our game viewport
        gamePort.update(width,height);

    }

    public TiledMap getMap(){
        return map;
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
    public void dispose() {
        //dispose of all our opened resources
        map.dispose();
        renderer.dispose();
    }
}