package com.tank.stars;

import com.badlogic.gdx.physics.box2d.*;

public class Bullet {
    public World world;
    public Body b;
    public Bullet(World world){
        this.world = world;
        bullet();
    }
    public void bullet(){
        BodyDef bd = new BodyDef();
        bd.position.set(32,200);
        bd.type = BodyDef.BodyType.DynamicBody;
        b = world.createBody(bd);

        FixtureDef fd = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(3);
        fd.shape = shape;
        b.createFixture(fd);
    }
}
