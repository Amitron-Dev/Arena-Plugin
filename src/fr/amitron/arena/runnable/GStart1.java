package fr.amitron.arena.runnable;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

import fr.amitron.arena.GMain;

public class GStart1 extends BukkitRunnable implements Listener{

	private int timer = 10;
	private GMain main;
	private Set<Player> noPvpPlayers = new HashSet<>();

	public GStart1(GMain main) {
		this.main = main;
		Bukkit.getPluginManager().registerEvents(this, main);
	}

	@Override
	public void run() {
		
		for(Player pls: Bukkit.getServer().getOnlinePlayers()) {
			pls.setLevel(timer);
			
			if (timer > 0) {
                noPvpPlayers.add(pls);
                pls.sendMessage("§aIl reste " + timer + " secondes avant le PvP !");
            }
        }
		
		if(timer == 0) {
			Bukkit.broadcastMessage("§c§l[EVENT] Le pvp est maintenant activé !");
			for(Player pls: Bukkit.getServer().getOnlinePlayers()) {
				if(!pls.hasPermission("event.admin")) {
					pls.getInventory().addItem(new ItemStack())
					
				}
				noPvpPlayers.clear();
			}
			cancel();
		}
		
		timer --;

	}
	
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player damagedPlayer = (Player) event.getEntity();
            if (noPvpPlayers.contains(damagedPlayer)) {
                event.setCancelled(true);
            }
        }
    }
}