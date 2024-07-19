package fr.amitron.arena.runnable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
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
					pls.setGameMode(GameMode.SURVIVAL);
					pls.sendMessage("§r");
					pls.sendMessage("§a§l[EVENT] §r§aVoici votre stuff, pensez a équipez votre armure! ");
					pls.sendMessage("§r");
					ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
					ItemMeta swordmeta = sword.getItemMeta();
					swordmeta.setDisplayName("§a§lEpee de la mort qui tue");
					swordmeta.setLore(Arrays.asList("§eCette épée est ultra méga puissante pour", "§etué tout vos ennemis"));
					sword.setItemMeta(swordmeta);
					pls.getInventory().addItem(sword);
					pls.getInventory().addItem(new ItemStack(Material.IRON_HELMET, 1));
					pls.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE, 1));
					pls.getInventory().addItem(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
					pls.getInventory().addItem(new ItemStack(Material.LEATHER_LEGGINGS, 1));
					ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 5);
					ItemMeta gapplemeta = gapple.getItemMeta();
					gapplemeta.setDisplayName("§eLa Pomme Magique");
					gapple.setItemMeta(gapplemeta);
					pls.getInventory().addItem(gapple);
					ItemStack egapple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 2);
					ItemMeta egapplemeta = egapple.getItemMeta();
					egapplemeta.setDisplayName("§e§lLa Pomme Ultra Magique");
					egapple.setItemMeta(egapplemeta);
					pls.getInventory().addItem(egapple);
					
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