package com.godcomplex.utils;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Collection;

public class LocationUtil {

    public static Collection<Location> getLocationsSteppedBetweenTwoLocations(Location location1, Location location2, double steppingDistance) {
        Collection<Location> steppingLocations = new ArrayList<>();
        Location accumulativeLocation = location1.clone();

        Vector lineVector = location2.toVector().clone().subtract(accumulativeLocation.toVector()).normalize().multiply(steppingDistance);
        double distance = accumulativeLocation.distance(location2);
        double covered = 0;

        while (covered < distance) {
            accumulativeLocation.add(lineVector);
            Location nextStepLocation = new Location(accumulativeLocation.getWorld(), accumulativeLocation.getX(), accumulativeLocation.getY(), accumulativeLocation.getZ());
            steppingLocations.add(nextStepLocation);
            covered += steppingDistance;
        }

        return steppingLocations;
    }

}
