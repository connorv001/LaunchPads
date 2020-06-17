package com.ItsAZZA.jump;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class JumpMain extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new OnStep(), this);
    }
}
