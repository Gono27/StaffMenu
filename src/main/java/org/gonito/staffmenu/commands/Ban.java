package org.gonito.staffmenu.commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;


public class Ban implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "Este comando solo se puede ejecutar in-game");
            return false;
        }
        Player p = (Player) sender;
        Inventory gui = Bukkit.createInventory(p, 54, ChatColor.DARK_RED + "Players Online");
        if (!p.hasPermission("staffmenu.ban")) {
            p.sendMessage(ChatColor.DARK_RED + "No tienes permiso para usar este comando");
            return false;
        }
        return true;
    }
}
