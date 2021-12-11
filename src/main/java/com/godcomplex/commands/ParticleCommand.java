package com.godcomplex.commands;

import com.godcomplex.domain.ParticleShapeType;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ParticleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player playerSender)) {
            return false;
        }

        if (args.length == 0) {
            playerSender.sendMessage("§cPlease provide a shape that you want to draw.");
            playerSender.sendMessage("§cYou can choose between the following shapes: §f" + Arrays
                    .stream(ParticleShapeType.values())
                    .map(particleShapeType -> StringUtils.capitalize(particleShapeType.name().toLowerCase()))
                    .collect(Collectors.joining(", ")));
            return false;
        }

        ParticleShapeType particleShapeType;
        try {
            particleShapeType = ParticleShapeType.valueOf(args[0].toUpperCase());
        } catch (IllegalArgumentException illegalArgumentException) {
            playerSender.sendMessage("§cCould not find a particle shape named > " + args[0]);
            return false;
        }

        Location drawingLocation = playerSender.getEyeLocation();
        Block targetBlock = playerSender.getTargetBlock(20);
        if (targetBlock != null) {
            drawingLocation = targetBlock.getLocation().add(0, 2, 0);
        }

        if (args.length == 1) {
            //particleShapeType.getShapeDrawer().drawShape(playerSender, drawingLocation);
            return true;
        }

        String[] shapeArguments = Arrays.copyOfRange(args, 1, args.length);
        //particleShapeType.getShapeDrawer().drawShape(playerSender, drawingLocation, shapeArguments);
        return true;
    }
}
