package de.Raffel98.MemoryBlock;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import de.Raffel98.cmds.MBlockCmd;
import de.Raffel98.listener.BlockListener;

public class Main extends JavaPlugin implements Listener{
	
	public File Blocks = new File("plugins/MemoryBlock", "Blocks.yml");
	public FileConfiguration Blogs_cfg = YamlConfiguration.loadConfiguration(Blocks);
	public String PREFIX = "[MemoryBlock] ";
	
	@Override
	public void onEnable(){
		System.out.println(PREFIX + "Plugin Enabeld");
		this.getServer().getPluginManager().registerEvents(new BlockListener(this), this);
		getCommands();
		loadConfigs();
		try {
			Blogs_cfg.save(Blocks);
			} catch (IOException e) {
				System.out.println("[MemoryBlock] Blogs.yml cou could not be loaded!");
				e.printStackTrace();
			}
		PREFIX = getConfig().getString("")
	}
	
	private void loadConfigs() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		
	}

	private void getCommands() {
		getCommand("MBlock").setExecutor(new MBlockCmd(this));
		
	}

	@Override
	public void onDisable(){
		System.out.println("[MemoryBlock] Plugin Disabeld");
	}

	
}
