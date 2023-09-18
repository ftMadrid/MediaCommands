package dev.madrid.mediacmd.utils;

import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import dev.madrid.mediacmd.MediaCommands;

public class ConfigFile extends YamlConfiguration {
  private static ConfigFile config;
  
  private Plugin plugin;
  
  private File Config;
  
  private Plugin main() {
    return (Plugin)MediaCommands.getInstance();
  }
  
  public void save() {
    try {
      save(this.Config);
    } catch (Exception exception) {}
  }
  
  public void saveDefault() {
    this.plugin.saveResource("config.yml", false);
  }
  
  public ConfigFile() {
    this.plugin = main();
    this.Config = new File(this.plugin.getDataFolder(), "config.yml");
    saveDefault();
    reload();
  }
  
  public void saveAll() {
    save();
    reload();
  }
  
  public static ConfigFile getConfig() {
    if (config == null)
      config = new ConfigFile(); 
    return config;
  }
  
  public void reload() {
    try {
      load(this.Config);
    } catch (Exception exception) {}
  }
}