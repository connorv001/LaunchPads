package com.ItsAZZA.LaunchPads;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LaunchPadsMain extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new OnStep(), this);
    }
}
