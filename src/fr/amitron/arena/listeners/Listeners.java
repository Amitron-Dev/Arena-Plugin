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

import fr.amitron.arena.GMain;
import fr.amitron.arena.enumeration.GState;

public class Listeners implements Listener {
	
	private GMain main;


	public Listeners(GMain main) {
		this.main = main;
		// TODO Auto-generated constructor stub
	}


	@EventHandler
	public void OnJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if(main.isState(GState.WAITING)) {
			
			p.sendMessage("§r§o---------------------------");
			p.sendMessage("§&§lBienvenue sur L'event !");
			p.sendMessage("§r§o---------------------------");
			World world = Bukkit.getWorld("world");
			p.teleport(new Location(world, 193.453, 63.0, 442.648, 0.1f, 2.5f));
			p.setFoodLevel(20);
			p.setHealth(20);
			p.setLevel(0);
			

			
			
			if(p.hasPermission("event.admin")) {
				p.sendMessage("§4§lVous êtes admin.");
				p.setGameMode(GameMode.CREATIVE);
				e.setJoinMessage("§4§lL'administrateur " + p.getName() + " a rejoint le serveur.");
				
			}
			
			if(!p.hasPermission("event.admin")) {
				p.setGameMode(GameMode.ADVENTURE);
				p.getInventory().clear();
				e.setJoinMessage("§aLe joueur " + p.getName() + " a rejoint le serveur !");
			}
			
		}
		
		if(!main.isState(GState.WAITING)) {
			
			if(!p.hasPermission("event.admin")) {
				p.sendMessage("");
				p.sendMessage("§c§lLe jeu a deja commencé.");
				p.sendMessage("");
				World world = Bukkit.getWorld("world");
				p.teleport(new Location(world, 248.496, 111.0, 356.475, -89.7f, 0.8f));
				p.setGameMode(GameMode.SPECTATOR);
				
			}

		}
	}

	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		e.setQuitMessage("§cLe joueur " + p.getName() + " est partit !");
		
	}
	
	
	

}
