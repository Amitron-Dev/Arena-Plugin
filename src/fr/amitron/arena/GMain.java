package fr.amitron.arena;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import fr.amitron.arena.enumeration.GState;
import fr.amitron.arena.listeners.Listeners;

public class GMain extends JavaPlugin{
	
	private GState state;
	
	@Override
	public void onEnable() {
		setState(GState.WAITING);
		System.out.println("§Arena Plugin");
		getCommand("event").setExecutor(new EventCMD(this));
		Bukkit.getPluginManager().registerEvents(new Listeners(this), this);
	}
	
	public void setState(GState state) {
		this.state = state;
		
	}
	
	public boolean isState(GState state) {
		return this.state == state;
		
	}

}
