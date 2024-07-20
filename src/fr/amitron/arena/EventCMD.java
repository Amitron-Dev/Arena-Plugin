package fr.amitron.arena;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.amitron.arena.runnable.GStart1;

public class EventCMD implements CommandExecutor {

	private GMain main;

	public EventCMD(GMain main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		
		if(p != null && p.isOnline()) {
			if(args.length == 1) {
				if(p.hasPermission("event.use")) {
					
					if(args[0].equalsIgnoreCase("start")) {
						
						// Etape 1 -> tp les joueurs dans l'arene. (meme position pour tout le monde)
						// Etape 2 -> desactivé le pvp et faire un conteur de 10 secondes pour les laisser s'échappé du centre
						// Etape 3 -> a la fin du décompte, activé le pvp.
						
						
						for(Player pls: Bukkit.getServer().getOnlinePlayers()) {
							
							if(!pls.hasPermission("event.admin")) {
								World world = Bukkit.getWorld("world");
								pls.teleport(new Location(world, 248.496, 111.0, 356.475, -89.7f, 0.8f)); //tp dans l'arene
							}
						}
						GStart1 start = new GStart1(main);
						start.runTaskTimer(main, 0, 20); //demarre le timer du pvp
						
						
					}
					
					
					if(args[0].equalsIgnoreCase("stop")) {
						
						for(Player pls: Bukkit.getServer().getOnlinePlayers()) {
							if(!pls.hasPermission("event.admin")) {
								World world = Bukkit.getWorld("world");
								pls.teleport(new Location(world, 193.453, 63.0, 442.648, 0.1f, 2.5f));
								pls.sendMessage("§a§l[EVENT] Fin de la partie !");
								pls.getInventory().clear();
								pls.setGameMode(GameMode.ADVENTURE);
								pls.setLevel(0);
								pls.setHealth(20);
								pls.setFoodLevel(20);
							}
							
						}
						
						
					}
					
				}else {
					p.sendMessage("§c§lVous n'avez pas la permission !");
					
				}
				
				if(!args[0].equalsIgnoreCase("start") && !args[0].equalsIgnoreCase("stop")) {
					
					p.sendMessage("§c§lMauvais Argument de la commande §r- §6/event §r pour l'aide");
					
				}
				
				
				
		}else {
			p.sendMessage("§7§m------ §rHelp §r§7§m------"); // Message d'help
			p.sendMessage("§a/event start §r --> Permet de demarré le jeu.");
			p.sendMessage("§a/event stop §r --> Arrete le jeu.");
			p.sendMessage("§7§m------ §rHelp §r§7§m------");
			
		}
					
					
}
				
			

		
		
		
		
		
		
		
		
		
		
		
		
		return false;
	}

}
