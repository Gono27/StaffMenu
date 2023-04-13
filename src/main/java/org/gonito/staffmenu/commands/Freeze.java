package org.gonito.staffmenu.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.gonito.staffmenu.StaffMenu;


public class Freeze implements CommandExecutor {

    StaffMenu plugin;

    public Freeze(StaffMenu plugin){

        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)){
            if (args.length == 0) {
                sender.sendMessage("Tiene que mencionar a un jugador");
            }
            Player t = Bukkit.getPlayerExact(args[0]);
            if (t == null) {
                sender.sendMessage("Player is not online");
            }
            assert t != null;
            if (!plugin.freezed.contains(t)) {
                plugin.freezed.add(t);
                sender.sendMessage("Player freeze");
            } else {
                plugin.freezed.remove(t);
                sender.sendMessage("Player unfreeze");
                t.sendMessage("Unfreeze");
            }
        }else {
            Player p = (Player) sender;
            if (!p.hasPermission("staffmenu.freeze")) {
                p.sendMessage(ChatColor.DARK_RED+"No tienes permiso para usar este comando");
            }else {
                if (args.length == 0) {
                    p.sendMessage("Tiene que mencionar a un jugador");
                }else {
                    Player t = Bukkit.getPlayerExact(args[0]);
                    if (t == null) {
                        p.sendMessage("Player is not online");
                    }
                    assert t != null;
                    if (!plugin.freezed.contains(t)) {
                        plugin.freezed.add(t);
                        p.sendMessage("Player freeze");
                    } else {
                        plugin.freezed.remove(t);
                        p.sendMessage("Player unfreeze");
                        t.sendMessage("Unfreeze");
                    }
                }
            }
        }
        return true;
    }
}
