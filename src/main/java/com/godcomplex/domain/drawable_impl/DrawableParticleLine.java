package com.godcomplex.domain.drawable_impl;

import com.godcomplex.domain.DrawableParticleShape;
import com.godcomplex.utils.ArgumentParser;
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
        double covered = 0;

        Location startingLocation = locations.get(0);
        Location destinationLocation = locations.get(1);
        Location accumulativeLocation = startingLocation.clone();

        Vector lineVector = destinationLocation.toVector().clone().subtract(accumulativeLocation.toVector()).normalize().multiply(distanceBetweenParticles);
        double distance = accumulativeLocation.distance(destinationLocation);
        while (covered < distance) {
            accumulativeLocation.add(lineVector);
            Location nextStepLocation = new Location(accumulativeLocation.getWorld(), accumulativeLocation.getX(), accumulativeLocation.getY(), accumulativeLocation.getZ());
            nextStepLocation.getWorld().spawnParticle(Particle.REDSTONE, nextStepLocation, 1, new Particle.DustOptions(Color.RED, 1.0F));
            covered += distanceBetweenParticles;
        }
    }
}
