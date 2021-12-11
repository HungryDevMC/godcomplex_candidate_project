package com.godcomplex;

import com.godcomplex.commands.ParticleCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class ParticleEffectsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("shape").setExecutor(new ParticleCommand());
    }
}
