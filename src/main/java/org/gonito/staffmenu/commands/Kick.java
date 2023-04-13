package org.gonito.staffmenu.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)){
            if(args.length == 0){
                sender.sendMessage(ChatColor.DARK_RED + "Tienes que mencionar a un jugador");
            }else{
                Player t = Bukkit.getPlayerExact(args[0]);
                t.kickPlayer(args[1]);
            }
        }else{
            Player p = (Player) sender;
            if(!p.hasPermission("staffmenu.kick")){
                p.sendMessage(ChatColor.DARK_RED+"No tienes permiso para usar este comando");
            }else{
                if(args.length == 0){
                    sender.sendMessage(ChatColor.DARK_RED + "Tienes que mencionar a un jugador");
                }else if(args.length == 2){
                    Player t = Bukkit.getPlayerExact(args[0]);
                    t.kickPlayer(args[1]);
                }else if(args.length == 1){
                    Player t = Bukkit.getPlayerExact(args[0]);
                    t.kickPlayer(null);
                }
            }
        }
        return true;
    }
}
