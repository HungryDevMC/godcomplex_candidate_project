package com.godcomplex.domain.drawable_impl;

import com.godcomplex.domain.DrawableParticleShape;
import com.godcomplex.utils.ArgumentParser;
import com.godcomplex.utils.LocationUtil;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.List;

public class DrawableParticleLine implements DrawableParticleShape {
    @Override
    public void drawShape(Player player, List<Location> locations, String... args) {
        int expectedLocations = 2;
        if (locations.size() != expectedLocations) {
            player.sendMessage("§cExpected " + expectedLocations + " argument location but got: " + locations.size());
            return;
        }

        String argument = args.length > 0 ? args[0] : "0.5";
        double distanceBetweenParticles = ArgumentParser.parseDouble(argument).orElse(0.5);

        LocationUtil.getLocationsSteppedBetweenTwoLocations(locations.get(0), locations.get(1), distanceBetweenParticles).forEach(steppingLocation -> {
            steppingLocation.getWorld().spawnParticle(Particle.REDSTONE, steppingLocation, 1, new Particle.DustOptions(Color.RED, 1.0F));
        });
    }
}
