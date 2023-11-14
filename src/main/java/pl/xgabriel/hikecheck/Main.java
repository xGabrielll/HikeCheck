package pl.xgabriel.hikecheck;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Plugin ChatPrefixPlugin został włączony.");
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new BlockPvP(), this);
        getServer().getPluginManager().registerEvents(new Build(), this);
        getCommand("przyznajesie").setExecutor(new PrzyznajeSieCommand(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin ChatPrefixPlugin został wyłączony.");
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String playerName = event.getPlayer().getName();
        String message = event.getMessage();

        String formattedMessage = ChatColor.translateAlternateColorCodes('&',
                "§8[§2CHECK§8] §7" + playerName + ": §f" + message);

        event.getPlayer().sendMessage(formattedMessage);
        event.setCancelled(true);
    }
}
