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
import java.util.Objects;

public class KickEvent implements Listener {
    private Player t;
    @EventHandler
    public void kickPlayerList(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        Inventory gui = Bukkit.createInventory(p,54, ChatColor.DARK_RED + "Kick Player Selector");
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Staff Menu")){
            if(Objects.requireNonNull(e.getCurrentItem()).getType() == Material.OAK_DOOR){
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
    @EventHandler
    public void kickPlayer(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "Kick Player Selector")) {
            if (Objects.requireNonNull(e.getCurrentItem()).getType() == Material.PLAYER_HEAD) {
                t = p.getServer().getPlayerExact(ChatColor.stripColor(Objects.requireNonNull(e.getCurrentItem().getItemMeta()).getDisplayName()));
                e.setCancelled(true);
                t.kickPlayer(null);
            }
        }
    }
}
