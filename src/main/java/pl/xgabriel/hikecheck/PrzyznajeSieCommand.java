package pl.xgabriel.hikecheck;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PrzyznajeSieCommand implements CommandExecutor {

    private JavaPlugin plugin;

    public PrzyznajeSieCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Komendę można wywołać tylko w grze.");
            return true;
        }

        Player player = (Player) sender;
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        Bukkit.dispatchCommand(console, "tempban " + player.getName() + " 7d Przyznanie się do cheatów");
        Bukkit.broadcastMessage("§cGracz §4" + player.getName() + " §cprzyznał się do §4cheatów");
        return true;
    }
}
