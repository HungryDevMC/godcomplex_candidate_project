package com.godcomplex.domain;

import com.godcomplex.domain.drawable_impl.DrawableOutlinedTriangle;
import com.godcomplex.domain.drawable_impl.DrawableParticleLine;
import com.godcomplex.utils.LocationUtil;
import org.bukkit.Location;

import java.util.List;

public enum ParticleShapeType {
    TRIANGLE(new DrawableOutlinedTriangle()),
    TRIANGLE_FILLED((player, locations, arguments) -> {
        DrawableOutlinedTriangle drawableOutlinedTriangle = new DrawableOutlinedTriangle();
        drawableOutlinedTriangle.drawShape(player, locations, arguments);

        DrawableParticleLine drawableParticleLine = new DrawableParticleLine();
        double stepDistance = 0.5;
        LocationUtil.getLocationsSteppedBetweenTwoLocations(locations.get(0), locations.get(1), stepDistance).forEach(steppingLocation -> {
            drawableParticleLine.drawShape(player, List.of(steppingLocation, locations.get(2)));
        });
    }),
    LINE(new DrawableParticleLine());

    private DrawableParticleShape shapeDrawer;

    ParticleShapeType(DrawableParticleShape shapeDrawer) {
        this.shapeDrawer = shapeDrawer;
    }

    public DrawableParticleShape getShapeDrawer() {
        return shapeDrawer;
    }
}
