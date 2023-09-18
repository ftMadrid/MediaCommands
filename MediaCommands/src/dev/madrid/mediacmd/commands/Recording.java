package dev.madrid.mediacmd.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.madrid.mediacmd.utils.ConfigFile;

public class Recording implements CommandExecutor{
	
	Map<String, Long> cooldowns = new HashMap<String, Long>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
		
		ConfigFile config = ConfigFile.getConfig();
		String path = "commands.recording";
		int cooldown = config.getInt("configuration.recording.cooldown");
		String cdmsg = config.getString("messages.on_cooldown");
		String pathmsg = config.getString("messages.disabled_command");
		String noperm = config.getString("messages.no_permission");
		List<String> message = config.getStringList("configuration.recording.message");
		
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis command is only for players."));
			return false;
			
		}
		Player p = (Player) sender;
		if(p.hasPermission("mediacommands.command.recording") && p.hasPermission("mediacommands.*")) {
		if(config.getString(path).equals("true")) {
		if(cooldowns.containsKey(p.getName())) {
			if(cooldowns.get(p.getName()) > System.currentTimeMillis()) {
				long time = (cooldowns.get(p.getName()) - System.currentTimeMillis()) / 1000;
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', cdmsg).replace("<cooldown>", ChatColor.translateAlternateColorCodes('&', String.valueOf(time))));
				return true;
			}
		}
		for(int i = 0;i <message.size();i++) {
			String msg = message.get(i).replaceAll("%player%", p.getName());
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
			cooldowns.put(p.getName(), System.currentTimeMillis() + (cooldown * 1000));
			
		}
		return true;
		}
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', pathmsg));
		return true;
		}
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', noperm));
		return true;
	}
}