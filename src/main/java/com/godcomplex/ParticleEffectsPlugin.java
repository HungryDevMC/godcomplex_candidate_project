package com.godcomplex;

import com.godcomplex.commands.ParticleCommand;
import com.godcomplex.listeners.PlayerClickListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ParticleEffectsPlugin extends JavaPlugin {

    private static ParticleEffectsPlugin instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        getCommand("shape").setExecutor(new ParticleCommand());
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerClickListener(), this);
    }

    public static ParticleEffectsPlugin getInstance() {
        return instance;
    }
}
