package org.gonito.staffmenu.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.gonito.staffmenu.StaffMenu;


public class VanishEvent implements Listener {
    StaffMenu plugin;

    public VanishEvent(StaffMenu plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void vanishEvent(PlayerJoinEvent e){
        Player p = e.getPlayer();
        for(int i = 0; i<plugin.vanished.size(); i++){
            p.hidePlayer(plugin.vanished.get(i));
        }
    }
    @EventHandler
    public void vanishPlayer(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Staff Menu")) {
            if (e.getCurrentItem().getType() == Material.GRAY_DYE) {
                if (!plugin.vanished.contains(p)) {
                    for (Player ps : Bukkit.getOnlinePlayers()) {
                        if (!ps.hasPermission("staffmenu.vanish")) {
                            ps.hidePlayer(p);
                        }
                    }
                    plugin.vanished.add(p);
                    p.sendMessage(ChatColor.DARK_GREEN + "Vanish enable");
                }
            }else if (e.getCurrentItem().getType() == Material.LIME_DYE){
                if (plugin.vanished.contains(p)) {
                    for (Player ps : Bukkit.getOnlinePlayers()) {
                        ps.showPlayer(p);
                    }
                    plugin.vanished.remove(p);
                    p.sendMessage( ChatColor.DARK_GREEN + "Vanish disable");
                }
            }
        }
    }
}
