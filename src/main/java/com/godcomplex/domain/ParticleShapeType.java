package com.godcomplex.domain;

public enum ParticleShapeType {
    TRIANGLE((player, location) -> {
        player.sendMessage("§aDrawing outlined triangle!");
    }),
    TRIANGLE_FILLED((player, location) -> {
        player.sendMessage("§aDrawing filled triangle!");
    });

    private DrawableParticleShape shapeDrawer;

    ParticleShapeType(DrawableParticleShape shapeDrawer) {
        this.shapeDrawer = shapeDrawer;
    }

    public DrawableParticleShape getShapeDrawer() {
        return shapeDrawer;
    }
}
