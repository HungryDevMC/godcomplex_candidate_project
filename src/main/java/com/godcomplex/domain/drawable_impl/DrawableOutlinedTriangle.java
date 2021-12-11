package com.godcomplex.domain.drawable_impl;

import com.godcomplex.domain.DrawableParticleShape;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public class DrawableOutlinedTriangle implements DrawableParticleShape {
    @Override
    public void drawShape(Player player, List<Location> locations, String... args) {
        DrawableParticleLine drawableParticleLine = new DrawableParticleLine();
        drawableParticleLine.drawShape(player, List.of(locations.get(0), locations.get(1)));
        drawableParticleLine.drawShape(player, List.of(locations.get(1), locations.get(2)));
        drawableParticleLine.drawShape(player, List.of(locations.get(2), locations.get(0)));
    }
}
