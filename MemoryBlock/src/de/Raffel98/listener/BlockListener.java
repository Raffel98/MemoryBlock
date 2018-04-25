package de.Raffel98.listener;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import de.Raffel98.MemoryBlock.Main;

public class BlockListener implements Listener {

	private Main plugin;

	public BlockListener(Main plugin) {
		this.plugin = plugin;
	}
	
	int BlockNR = 1;
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		System.out.println(plugin.PREFIX + "Break " + e.getPlayer().getName());
		SimpleDateFormat Datum_Uhrzeit = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		String TIME = Datum_Uhrzeit.format(new Date());
		plugin.Blogs_cfg.set("MemoryBlock." + e.getPlayer().getName() + ".UUID", e.getPlayer().getUniqueId().toString());
		plugin.Blogs_cfg.set("MemoryBlock." + e.getPlayer().getName() + ".Blocks.Break."+BlockNR+".Typ" , e.getBlock().getType().toString());
		plugin.Blogs_cfg.set("MemoryBlock." + e.getPlayer().getName() + ".Blocks.Break."+BlockNR+".Location",e.getBlock().getLocation().getBlockX() + "," + e.getBlock().getLocation().getBlockY() + "," + e.getBlock().getLocation().getBlockZ());
		plugin.Blogs_cfg.set("MemoryBlock." + e.getPlayer().getName() + ".Blocks.Break."+BlockNR+".World",e.getBlock().getWorld().getName());
		plugin.Blogs_cfg.set("MemoryBlock." + e.getPlayer().getName() + ".Blocks.Break."+BlockNR+".Date" , TIME);
		
		try {
			plugin.Blogs_cfg.save(plugin.Blocks);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		BlockNR++;
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
	
		System.out.println(plugin.PREFIX + "Place " + e.getPlayer().getName());
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
	}
}
