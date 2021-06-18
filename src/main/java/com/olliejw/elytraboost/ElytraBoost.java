package com.olliejw.Troll.elytraboost;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class ElytraBoost extends JavaPlugin {

    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        // Register commands
        this.getCommand("launch").setExecutor(new Launch());
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
