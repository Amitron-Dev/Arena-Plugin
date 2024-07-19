package fr.amitron.arena.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listeners implements Listener {
	
	@EventHandler
	public void OnJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		
		p.sendMessage("§r§o---------------------------");
		p.sendMessage("§&§lBienvenue sur L'event !");
		p.sendMessage("§r§o---------------------------");
		World world = Bukkit.getWorld("world");
		p.teleport(new Location(world, 193.453, 63.0, 442.648, 0.1f, 2.5f));
		p.setFoodLevel(20);
		p.setHealth(20);
		
		
		if(p.hasPermission("event.admin")) {
			
			
		}
		
		if(!p.hasPermission("event.admin")) {
			p.setGameMode(GameMode.ADVENTURE);
			p.getInventory().clear();
			
			
		}
		
	}
	
	
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		e.setQuitMessage("§cLe joueur " + p.getName() + " est partit !");
		
	}
	
	
	

}
