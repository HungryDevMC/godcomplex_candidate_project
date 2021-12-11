package com.godcomplex.domain;

import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Collection;

public class Triangle {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public Collection<Vector> getOffsetVectors(int stepsPerPoint) {
        return getOffsetVectors(stepsPerPoint, false);
    }

    public Collection<Vector> getOffsetVectors(int stepsPerPoint, boolean filled) {
        double stepHeight = height / stepsPerPoint;
        double stepWidth = base / stepsPerPoint;
        Collection<Vector> vectorOffsetsCollection = new ArrayList<>();

        for (double x = 0; x < base; x += stepWidth) {
            vectorOffsetsCollection.add(new Vector(x, 0, 0));
        }

        int step = 0;
        double maxPadding = base / 2.0;
        for (double y = stepHeight; y < height; y += stepHeight) {
            step++;
            double xPadding = stepWidth * step;

            if (xPadding > maxPadding) {
                vectorOffsetsCollection.add(new Vector(maxPadding, y, 0));
                break;
            }

            if (!filled) {
                vectorOffsetsCollection.add(new Vector(xPadding, y, 0));
                vectorOffsetsCollection.add(new Vector(base - xPadding, y, 0));
                continue;
            }

            for (double x = xPadding; x < (base - xPadding); x += stepWidth) {
                vectorOffsetsCollection.add(new Vector(x, y, 0));
            }
        }

        return vectorOffsetsCollection;
    }

}
