package de.Raffel98.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Raffel98.MemoryBlock.Main;

public class MBlockCmd implements CommandExecutor {

	private Main plugin;

	public MBlockCmd(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("MBlock")) {
			if (sender instanceof Player) {

				return true;
			} else {
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("reloade")) {
						plugin.reloadConfig();
						sender.sendMessage("Pl Reloade");
						return true;
					}
				} else {
					sender.sendMessage("Zu Viele Args");
					return true;
				}
			}
		}
		return false;
	}

}
