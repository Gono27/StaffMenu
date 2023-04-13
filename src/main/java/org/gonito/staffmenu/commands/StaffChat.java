package org.gonito.staffmenu.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.gonito.staffmenu.StaffMenu;

public class StaffChat implements CommandExecutor {
    StaffMenu plugin;
    public StaffChat(StaffMenu plugin){

        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.DARK_RED+"Este comando solo puede ser usado in-game");
            return false;
        }
        Player p = (Player) sender;
        if(!p.hasPermission("staffmenu.staffchat")){
            sender.sendMessage(ChatColor.DARK_RED+"No tienes permisos para usar este comando");
            return false;
        }
        plugin.cM.joinChannel(p,"Staff Chat");

        return true;
    }
}
