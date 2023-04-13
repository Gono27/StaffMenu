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


public class TpEvent implements Listener {

    @EventHandler
    public void clickMenuEvent(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Inventory gui = Bukkit.createInventory(p,54, ChatColor.DARK_RED + "Tp Player Selector");
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Staff Menu")){
            if(Objects.requireNonNull(e.getCurrentItem()).getType() == Material.COMPASS) {
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
    public void selectPlayerToTp(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "Tp Player Selector")){
            if(Objects.requireNonNull(e.getCurrentItem()).getType() == Material.PLAYER_HEAD) {
                Player t = p.getServer().getPlayerExact(ChatColor.stripColor(Objects.requireNonNull(e.getCurrentItem().getItemMeta()).getDisplayName()));
                assert t != null;
                p.teleport(t);
            }
        }
    }
}

