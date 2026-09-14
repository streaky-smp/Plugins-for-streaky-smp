package com.pluginname;

import org.bukkit.plugin.java.JavaPlugin;

public final class PluginNamePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("PluginName has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("PluginName has been disabled!");
    }
}
