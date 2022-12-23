package com.tank.stars.Objs;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;

public class Ground {
    public Ground(World world, TiledMap map) {
        BodyDef bodydef = new BodyDef();
        PolygonShape polshape = new PolygonShape();
        FixtureDef fixdef = new FixtureDef();
        Body body;

        for (MapObject object : map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            bodydef.type = BodyDef.BodyType.StaticBody;
            bodydef.position.set((rect.getX() + rect.getWidth() / 2) , (rect.getY() + rect.getHeight() / 2) );
            body = world.createBody(bodydef);
            polshape.setAsBox(rect.getWidth() / 2 , rect.getHeight() / 2 );
            fixdef.shape = polshape;
            body.createFixture(fixdef);
        }
    }
}
