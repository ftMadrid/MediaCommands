package dev.madrid.mediacmd;

import java.util.List;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import dev.madrid.mediacmd.commands.NewVideo;
import dev.madrid.mediacmd.commands.Principal;
import dev.madrid.mediacmd.commands.Recording;
import dev.madrid.mediacmd.commands.Stream;
import dev.madrid.mediacmd.utils.ConfigFile;

public class MediaCommands extends JavaPlugin{
	
	PluginDescriptionFile loader = getDescription();
	public String version = loader.getVersion();
	public List<String> authors = loader.getAuthors();
	
	public static MediaCommands instance;
	
	public void onEnable() {
		instance = this;
		ConfigFile.getConfig();
		registerCommands();
	}
	
	public void registerCommands() {
		getCommand("mediacommands").setExecutor((CommandExecutor)new Principal(this));
		getCommand("stream").setExecutor((CommandExecutor)new Stream());
		getCommand("newvideo").setExecutor((CommandExecutor)new NewVideo());
		getCommand("recording").setExecutor((CommandExecutor)new Recording());
	}
	
	public static MediaCommands getInstance() {
	    return instance;
	}
}
