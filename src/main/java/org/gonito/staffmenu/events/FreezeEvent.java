package org.gonito.staffmenu.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.gonito.staffmenu.StaffMenu;


public class FreezeEvent implements Listener {
    StaffMenu plugin;

    public FreezeEvent(StaffMenu plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void freezePlayer(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(plugin.freezed.contains(p)){
            p.sendMessage(ChatColor.RED +"You are freeze");
            e.setCancelled(true);
        }
    }
}
