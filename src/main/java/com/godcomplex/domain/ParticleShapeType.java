package com.godcomplex.domain;

import com.godcomplex.domain.drawable_impl.DrawableParticleLine;
import com.godcomplex.utils.ArgumentParser;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.util.Vector;

import java.util.Date;
import java.util.List;

public enum ParticleShapeType {
    TRIANGLE((player, locations, arguments) -> {
        DrawableParticleLine drawableParticleLine = new DrawableParticleLine();
        drawableParticleLine.drawShape(player, List.of(locations.get(0), locations.get(1)));
        drawableParticleLine.drawShape(player, List.of(locations.get(0), locations.get(2)));
        drawableParticleLine.drawShape(player, List.of(locations.get(1), locations.get(2)));
    }),
    TRIANGLE_FILLED((player, location, argumentLocations) -> {

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
