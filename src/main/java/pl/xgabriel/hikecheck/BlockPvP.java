package pl.xgabriel.hikecheck;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class BlockPvP implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity damaged = event.getEntity();
        if (damager instanceof Player) {
            Player player = (Player) damager;

            if (!player.hasPermission("hikemc.lobby.pvp")) {
                event.setCancelled(true);
                return;
            }
        }


        if (damaged instanceof Player) {
            Player player = (Player) damaged;


            if (!player.hasPermission("hikemc.lobby.pvp")) {
                event.setCancelled(true);
            }
        }
    }
}
