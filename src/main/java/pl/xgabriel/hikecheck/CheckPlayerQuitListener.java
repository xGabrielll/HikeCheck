package pl.xgabriel.hikecheck;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CheckPlayerQuitListener {

    private JavaPlugin plugin;

    public CheckPlayerQuitListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String playerName = event.getPlayer().getName();
            String quitMessage = ChatColor.translateAlternateColorCodes('&',
                    "§8» §8[§2CHECK§8] §7" + playerName + " §aopuścił §7serwer §acheck");
            Bukkit.getServer().broadcastMessage(quitMessage);
        }


}

