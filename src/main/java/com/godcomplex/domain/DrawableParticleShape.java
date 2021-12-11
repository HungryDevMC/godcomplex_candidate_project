package com.godcomplex.domain;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

@FunctionalInterface
public interface DrawableParticleShape {
    void drawShape(Player player, List<Location> locations, String... args);
}
