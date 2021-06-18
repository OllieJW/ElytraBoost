package com.olliejw.Troll.elytraboost;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.Particle;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class Launch implements CommandExecutor {

    ElytraBoost plugin;


    // Launch upwards
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (sender instanceof Player) {
            // Check for permission
            if (player.hasPermission(plugin.getConfig().getString(ChatColor.translateAlternateColorCodes('&',"Perm")))) {
                // Check if you have an Elytra equipped
                ItemStack item = player.getInventory().getChestplate();
                if (item != null && item.getType() == Material.ELYTRA) {
                    // Already flying?
                    if ((player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) & (!player.isGliding())) {
                        // Lift off
                        player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 10, 1);
                        player.spawnParticle(Particle.EXPLOSION_LARGE, player.getLocation(), 5, 0, 1, 1);
                        player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "LIFT OFF!");
                        player.setVelocity(new Vector(0, 2, 0));
                    }
                    else {
                        // Is flying
                        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[!]" + "You must land before launching!");
                    }

                }
                else {
                    // Not wearing elytra
                    player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[!]" + "You need to wear an elytra for this!");
                }
            }
            else {
                // Do not have permission
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[!]" + "You do not have permission to do this!");
                return true;
            }
            return true;
        }
        return true;
    }
}

