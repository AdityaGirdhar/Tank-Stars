package com.tank.stars.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import com.tank.stars.Screens.Battlefield;
import com.tank.stars.TankStars;

public class Tank1 extends Sprite {
    public World world;
    public Body body;

    public Tank1(World world, Battlefield screen) {
        this.world = world;
        defineTank();
    }
    public void update(float dt) {
        setPosition(body.getPosition().x - getWidth() / 2, body.getPosition().y - getHeight() / 2);
    }
    public void defineTank() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(32 , 200);
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(10 );

        fdef.shape = shape;
        body.createFixture(fdef);
    }
}
