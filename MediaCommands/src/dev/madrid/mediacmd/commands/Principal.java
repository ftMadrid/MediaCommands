package dev.madrid.mediacmd.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.madrid.mediacmd.MediaCommands;
import dev.madrid.mediacmd.utils.ConfigFile;

public class Principal implements CommandExecutor{
	
	private MediaCommands loader;
	public Principal(MediaCommands loader) {this.loader = loader;}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
		
		ConfigFile config = ConfigFile.getConfig();
		String reloadmsg = config.getString("messages.reload");
		String noperm = config.getString("messages.no_permission");
		
		if(!(sender instanceof Player)) {
			if(args.length > 0) {
				if(args[0].equalsIgnoreCase("help")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m----------------------------------"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lMediaCommands &f&lHelp"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/mc reload &7- &fReload the plugin."));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/mc info &7- &fShows plugin information."));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m----------------------------------"));
					return false;
				}
				if(args[0].equalsIgnoreCase("reload")) {
					ConfigFile.getConfig().reload();
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', reloadmsg));
					return false;
				}
				if(args[0].equalsIgnoreCase("info")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m----------------------------------"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lMediaCommands &f&lInformation"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eAuthor&7:&f "+loader.authors));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eVersion&7:&f "+loader.version));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m----------------------------------"));
					return false;
				}
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cWrong Command."));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUse: &f/mediacommands help"));
				return false;
				}
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUse: &f/mediacommands help"));
				return false;
				
		}
		Player p = (Player) sender;
		if(p.hasPermission("mediacommands.*") && p.hasPermission("mediacommands.admin")) {
			if(args.length > 0) {
				if(args[0].equalsIgnoreCase("help")) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m----------------------------------"));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lMediaCommands &f&lHelp"));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/mc reload &7- &fReload the plugin."));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/mc info &7- &fShows plugin information."));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m----------------------------------"));
					return true;
				}
				if(args[0].equalsIgnoreCase("reload")) {
					ConfigFile.getConfig().reload();
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', reloadmsg));
					return true;
				}
				if(args[0].equalsIgnoreCase("info")) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m----------------------------------"));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lMediaCommands &f&lInformation"));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eAuthor&7:&f "+loader.authors));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eVersion&7:&f "+loader.version));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m----------------------------------"));
					return true;
				}
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cWrong Command."));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUse: &f/mediacommands help"));
				return true;
				}
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUse: &f/mediacommands help"));
				return true;
				}
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', noperm));
				return true;
			}
  		}