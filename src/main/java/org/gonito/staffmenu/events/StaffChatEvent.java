package org.gonito.staffmenu.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.gonito.staffmenu.StaffMenu;

public class StaffChatEvent implements Listener {
    private final StaffMenu plugin;

    public StaffChatEvent(StaffMenu plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        e.getRecipients().clear();
        plugin.cM.getChannel(p).forEach(player -> e.getRecipients().add(player));
    }
    @EventHandler
    public void onJoinChannel(PlayerJoinEvent e){
        plugin.cM.joinChannel(e.getPlayer(),"General");
    }
}
