package org.gonito.staffmenu.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.gonito.staffmenu.StaffMenu;

import java.util.ArrayList;

public class Vanish implements CommandExecutor {
    StaffMenu plugin;

    public Vanish(StaffMenu plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "Este comando debe ser usado por un jugador");
            return false;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("staffmenu.vanish")) {
            p.sendMessage(ChatColor.DARK_RED + "No tienes permiso para usar este comando");
            return false;
        }
        if (!plugin.vanished.contains(p)) {
            for (Player ps : Bukkit.getOnlinePlayers()) {
                if (!ps.hasPermission("staffmenu.vanish")) {
                    ps.hidePlayer(p);
                }
            }
            plugin.vanished.add(p);
            p.sendMessage(ChatColor.DARK_GREEN + "Vanish enable");
        } else {
            for (Player ps : Bukkit.getOnlinePlayers()) {
                ps.showPlayer(p);
            }
            plugin.vanished.remove(p);
            p.sendMessage(ChatColor.DARK_GREEN + "Vanish disable");
        }
        return true;
    }

}
