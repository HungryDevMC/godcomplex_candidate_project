package com.godcomplex.domain;

import org.bukkit.Location;
import org.bukkit.entity.Player;

@FunctionalInterface
public interface DrawableParticleShape {
    void drawShape(Player player, Location location);
}
