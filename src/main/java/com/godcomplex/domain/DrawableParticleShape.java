package com.godcomplex.domain;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@FunctionalInterface
public interface DrawableParticleShape {
    void drawShape(Player player, List<Location> locations, String... args);
}
