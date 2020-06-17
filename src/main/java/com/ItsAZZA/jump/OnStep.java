package com.ItsAZZA.jump;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import static org.bukkit.Tag.REGISTRY_BLOCKS;

public class OnStep implements Listener {
    @EventHandler
    public void onStep(PlayerInteractEvent event) {
        if (event.getAction() != Action.PHYSICAL) return;

        Block block = event.getClickedBlock();
        if (block == null) return;
        if (!isPressureplate(block.getType())) return;

        Block dataBlock = block.getRelative(0, -2, 0);
        if(!isSign(dataBlock.getType())) return;

        Sign sign = (Sign) dataBlock.getState();
        String label = sign.getLine(0);
        if(!label.toLowerCase().equals("[launch]")) return;

        double x = Double.parseDouble(sign.getLine(1));
        double y = Double.parseDouble(sign.getLine(2));
        double z = Double.parseDouble(sign.getLine(3));

        Player player = event.getPlayer();
        Vector velocity = player.getVelocity();
        velocity.setX(x);
        velocity.setY(y);
        velocity.setZ(z);

        player.setVelocity(velocity);
    }

    private boolean isPressureplate(Material material) {
        switch (material) {
            case LIGHT_WEIGHTED_PRESSURE_PLATE:
            case HEAVY_WEIGHTED_PRESSURE_PLATE:
            case ACACIA_PRESSURE_PLATE:
            case BIRCH_PRESSURE_PLATE:
            case DARK_OAK_PRESSURE_PLATE:
            case JUNGLE_PRESSURE_PLATE:
            case OAK_PRESSURE_PLATE:
            case SPRUCE_PRESSURE_PLATE:
            case STONE_PRESSURE_PLATE:
                return true;
            default:
                return false;
        }
    }

    private boolean isSign(Material material) {
        return Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("signs"), Material.class).isTagged(material);
    }
}