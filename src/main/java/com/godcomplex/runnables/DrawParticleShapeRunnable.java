package com.godcomplex.runnables;

import com.godcomplex.domain.ParticleShapeType;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class DrawParticleShapeRunnable extends BukkitRunnable {

    private ParticleShapeType particleShapeType;
    private Player player;
    private List<Location> locations;
    private String[] args;
    private int amount;

    public DrawParticleShapeRunnable(ParticleShapeType particleShapeType, Player player, List<Location> locations, int amount, String... args) {
        this.particleShapeType = particleShapeType;
        this.player = player;
        this.locations = locations;
        this.amount = amount;
        this.args = args;
    }

    public DrawParticleShapeRunnable(ParticleShapeType particleShapeType, Player player, List<Location> locations, String... args) {
        this(particleShapeType, player, locations, 1, args);
    }

    @Override
    public void run() {
        amount--;
        particleShapeType.getShapeDrawer().drawShape(player, locations, args);
        if(amount == 0) {
            this.cancel();
        }
    }
}
