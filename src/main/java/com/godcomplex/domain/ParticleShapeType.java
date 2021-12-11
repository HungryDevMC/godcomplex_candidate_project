package com.godcomplex.domain;

import com.godcomplex.utils.ArgumentParser;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.util.Vector;

public enum ParticleShapeType {
    TRIANGLE((player, location, argumentLocations) -> {

    }),
    TRIANGLE_FILLED((player, location, argumentLocations) -> {

    }),
    LINE((player, locations, arguments) -> {
        int expectedLocations = 2;
        if (locations.size() != expectedLocations) {
            player.sendMessage("§cExpected " + expectedLocations + " argument location but got: " + locations.size());
            return;
        }

        String argument = arguments.length > 0 ? arguments[0] : "0.5";
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
    });

    private DrawableParticleShape shapeDrawer;

    ParticleShapeType(DrawableParticleShape shapeDrawer) {
        this.shapeDrawer = shapeDrawer;
    }

    public DrawableParticleShape getShapeDrawer() {
        return shapeDrawer;
    }
}
