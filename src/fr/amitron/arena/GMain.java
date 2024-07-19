package fr.amitron.arena;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import fr.amitron.arena.listeners.Listeners;

public class GMain extends JavaPlugin{
	
	@Override
	public void onEnable() {
		System.out.println("§Arena Plugin");
		getCommand("event").setExecutor(new EventCMD());
		Bukkit.getPluginManager().registerEvents(new Listeners(), this);
	}

}
