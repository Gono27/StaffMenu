package org.gonito.staffmenu.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class PlayersListEvent implements Listener {

    @EventHandler
    public void playersList(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);
        Inventory gui = Bukkit.createInventory(p,54, ChatColor.DARK_RED + "Players Online");
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Staff Menu")){
            if(e.getCurrentItem().getType() == Material.PLAYER_HEAD){
                for(Player all : Bukkit.getOnlinePlayers()){
                    String playersName = all.getName();
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add("Heal: " + all.getHealth());
                    lore.add("IP: " + all.getAddress());

                    ItemStack playersList = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
                    SkullMeta playerListMeta = (SkullMeta) playersList.getItemMeta();

                    playerListMeta.setOwner(playersName);
                    playerListMeta.setDisplayName(playersName);
                    playerListMeta.setLore(lore);
                    playersList.setItemMeta(playerListMeta);

                    gui.addItem(playersList);

                    p.openInventory(gui);
                }
            }
        }
    }
}
