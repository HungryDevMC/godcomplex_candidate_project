package com.godcomplex.listeners;

import com.godcomplex.ParticleEffectsPlugin;
import com.godcomplex.domain.ParticleShapeType;
import com.godcomplex.runnables.DrawParticleShapeRunnable;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.*;

public class PlayerClickListener implements Listener {

    private static final HashMap<UUID, List<Location>> PLAYER_VERTICES_SELECTION_MAP = new HashMap<>();

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (!e.getAction().equals(Action.RIGHT_CLICK_AIR) && !e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            return;
        }

        if (e.getHand() == null || !e.getHand().equals(EquipmentSlot.HAND)) {
            return;
        }

        Player clickerPlayer = e.getPlayer();
        UUID playerUuid = clickerPlayer.getUniqueId();
        List<Location> VERTICES_LIST = PLAYER_VERTICES_SELECTION_MAP.getOrDefault(playerUuid, new ArrayList<>());

        Location targetLocation = clickerPlayer.getEyeLocation();
        Block targetBlock = clickerPlayer.getTargetBlock(10);
        if (targetBlock != null) {
            targetLocation = targetBlock.getLocation();
        }

        VERTICES_LIST.add(targetLocation);
        StringJoiner locationJoiner = new StringJoiner(", ");
        locationJoiner.add(targetLocation.getX() + "");
        locationJoiner.add(targetLocation.getY() + "");
        locationJoiner.add(targetLocation.getZ() + "");
        clickerPlayer.sendMessage("§aAdded location " + locationJoiner + " to vertices list");

        if (VERTICES_LIST.size() == 1) {
            PLAYER_VERTICES_SELECTION_MAP.put(playerUuid, VERTICES_LIST);
            return;
        }

        if (VERTICES_LIST.size() == 3) {
            DrawParticleShapeRunnable drawParticleShapeRunnable = new DrawParticleShapeRunnable(ParticleShapeType.TRIANGLE, e.getPlayer(), VERTICES_LIST, 3);
            drawParticleShapeRunnable.runTaskTimer(ParticleEffectsPlugin.getInstance(), 0, 10);
            PLAYER_VERTICES_SELECTION_MAP.remove(playerUuid);
        }
    }

}
