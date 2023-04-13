package org.gonito.staffmenu.events;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class BanEvent implements Listener {

    private Player t;
    private String banReason;
    private Date banTime = new Date();
    @EventHandler
    public void banPlayerList(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        Inventory gui = Bukkit.createInventory(p,54, ChatColor.DARK_RED + "Ban Player Selector");
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Staff Menu")){
            if(Objects.requireNonNull(e.getCurrentItem()).getType() == Material.BARRIER){
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
    public void selectBanReason(InventoryClickEvent e){

    }
    @EventHandler
    public void selectBanTimer(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "Ban Player Selector")){
            if(Objects.requireNonNull(e.getCurrentItem()).getType() == Material.PLAYER_HEAD){
                t = p.getServer().getPlayerExact(ChatColor.stripColor(Objects.requireNonNull(e.getCurrentItem().getItemMeta()).getDisplayName()));
                e.setCancelled(true);

                Inventory timeSelect = Bukkit.createInventory(p, 27, ChatColor.DARK_RED + "Time Select");

                ItemStack minutes15 = new ItemStack(Material.DIRT, 1);
                ItemStack minutes30 = new ItemStack(Material.GRASS_BLOCK, 1);
                ItemStack hour1 = new ItemStack(Material.STONE, 1);
                ItemStack hour2 = new ItemStack(Material.OAK_WOOD, 1);
                ItemStack hour6 = new ItemStack(Material.COAL_ORE, 1);
                ItemStack hour12 = new ItemStack(Material.IRON_ORE, 1);
                ItemStack days1 = new ItemStack(Material.GOLD_ORE, 1);
                ItemStack days2 = new ItemStack(Material.DIAMOND_ORE, 1);
                ItemStack days5 = new ItemStack(Material.COAL_BLOCK, 1);
                ItemStack days10 = new ItemStack(Material.IRON_BLOCK, 1);
                ItemStack days15 = new ItemStack(Material.GOLD_BLOCK, 1);
                ItemStack days30 = new ItemStack(Material.DIAMOND_BLOCK, 1);
                ItemStack days60 = new ItemStack(Material.NETHERITE_BLOCK, 1);
                ItemStack perm = new ItemStack(Material.BARRIER, 1);
                ItemStack greenGlass = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);

                ItemMeta minutes15Meta = minutes15.getItemMeta();
                assert minutes15Meta != null;
                minutes15Meta.setDisplayName(ChatColor.DARK_RED + "15 minutes ban");
                minutes15.setItemMeta(minutes15Meta);

                ItemMeta minutes30Meta = minutes30.getItemMeta();
                assert minutes30Meta != null;
                minutes30Meta.setDisplayName(ChatColor.DARK_RED + "30 minutes ban");
                minutes30.setItemMeta(minutes30Meta);

                ItemMeta hour1Meta = hour1.getItemMeta();
                assert hour1Meta != null;
                hour1Meta.setDisplayName(ChatColor.DARK_RED + "1 hour ban");
                hour1.setItemMeta(hour1Meta);

                ItemMeta hour2Meta = hour2.getItemMeta();
                assert hour2Meta != null;
                hour2Meta.setDisplayName(ChatColor.DARK_RED + "2 hour ban");
                hour2.setItemMeta(hour2Meta);

                ItemMeta hour6Meta = hour6.getItemMeta();
                assert hour6Meta != null;
                hour6Meta.setDisplayName(ChatColor.DARK_RED + "6 hour ban");
                hour6.setItemMeta(hour6Meta);

                ItemMeta hour12Meta = hour12.getItemMeta();
                assert hour12Meta != null;
                hour12Meta.setDisplayName(ChatColor.DARK_RED + "12 hour ban");
                hour12.setItemMeta(hour12Meta);

                ItemMeta days1Meta = days1.getItemMeta();
                assert days1Meta != null;
                days1Meta.setDisplayName(ChatColor.DARK_RED + "1 day ban");
                days1.setItemMeta(days1Meta);

                ItemMeta days2Meta = days2.getItemMeta();
                assert days2Meta != null;
                days2Meta.setDisplayName(ChatColor.DARK_RED + "2 day ban");
                days2.setItemMeta(days2Meta);

                ItemMeta days5Meta = days5.getItemMeta();
                assert days5Meta != null;
                days5Meta.setDisplayName(ChatColor.DARK_RED + "5 day ban");
                days5.setItemMeta(days5Meta);

                ItemMeta days10Meta = days10.getItemMeta();
                assert days10Meta != null;
                days10Meta.setDisplayName(ChatColor.DARK_RED + "10 day ban");
                days10.setItemMeta(days10Meta);

                ItemMeta days15Meta = days15.getItemMeta();
                assert days15Meta != null;
                days15Meta.setDisplayName(ChatColor.DARK_RED + "15 day ban");
                days15.setItemMeta(days15Meta);

                ItemMeta days30Meta = days30.getItemMeta();
                assert days30Meta != null;
                days30Meta.setDisplayName(ChatColor.DARK_RED + "30 day ban " + ChatColor.BOLD + "(En desarrollo)");
                days30.setItemMeta(days30Meta);

                ItemMeta days60Meta = days60.getItemMeta();
                assert days60Meta != null;
                days60Meta.setDisplayName(ChatColor.DARK_RED + "60 day ban " + ChatColor.BOLD + "(En desarrollo)");
                days60.setItemMeta(days60Meta);

                ItemMeta permMeta = perm.getItemMeta();
                assert permMeta != null;
                permMeta.setDisplayName(ChatColor.DARK_RED + "Perm ban");
                perm.setItemMeta(permMeta);

                timeSelect.addItem(minutes15, minutes30, hour1, hour2, hour6, hour12, days1, days2, days5);
                timeSelect.setItem(20,days10);
                timeSelect.setItem(21,days15);
                timeSelect.setItem(22,days30);
                timeSelect.setItem(23,days60);
                timeSelect.setItem(24,perm);

                // Rellena los slots vacios con cristales
                for (int i = 0; i <timeSelect.getSize(); i++) {
                    if (timeSelect.getItem(i) == null) {
                        timeSelect.setItem(i, greenGlass);
                    }
                }
                p.openInventory(timeSelect);
            }
        }else if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "Time Select")){
            switch (Objects.requireNonNull(e.getCurrentItem()).getType()){
                case DIRT:
                    banTime = new Date(System.currentTimeMillis() + 900000);
                    t.getServer().getBanList(BanList.Type.NAME).addBan(t.getName(),"Fuiste Baneado hasta el " + banTime,banTime,null);
                    t.kickPlayer("Fuiste Baneado hasta el " + banTime);
                    p.closeInventory();
                    break;

                case GRASS_BLOCK:
                    banTime = new Date(System.currentTimeMillis() + 1800000);
                    t.getServer().getBanList(BanList.Type.NAME).addBan(t.getName(),"Fuiste Baneado hasta el " + banTime,banTime,null);
                    t.kickPlayer("Fuiste Baneado hasta el " + banTime);
                    p.closeInventory();
                    break;

                case STONE:
                    banTime = new Date(System.currentTimeMillis() + 3600000);
                    t.getServer().getBanList(BanList.Type.NAME).addBan(t.getName(),"Fuiste Baneado hasta el " + banTime,banTime,null);
                    t.kickPlayer("Fuiste Baneado hasta el " + banTime);
                    p.closeInventory();
                    break;

                case OAK_WOOD:
                    banTime = new Date(System.currentTimeMillis() + 7200000);
                    t.getServer().getBanList(BanList.Type.NAME).addBan(t.getName(),"Fuiste Baneado hasta el " + banTime,banTime,null);
                    t.kickPlayer("Fuiste Baneado hasta el " + banTime);
                    p.closeInventory();
                    break;

                case COAL_ORE:
                    banTime = new Date(System.currentTimeMillis() + 21600000);
                    t.getServer().getBanList(BanList.Type.NAME).addBan(t.getName(),"Fuiste Baneado hasta el " + banTime,banTime,null);
                    t.kickPlayer("Fuiste Baneado hasta el " + banTime);
                    p.closeInventory();
                    break;

                case IRON_ORE:
                    banTime = new Date(System.currentTimeMillis() + 43200000);
                    t.getServer().getBanList(BanList.Type.NAME).addBan(t.getName(),"Fuiste Baneado hasta el " + banTime,banTime,null);
                    t.kickPlayer("Fuiste Baneado hasta el " + banTime);
                    p.closeInventory();
                    break;

                case GOLD_ORE:
                    banTime = new Date(System.currentTimeMillis() + 86400000);
                    t.getServer().getBanList(BanList.Type.NAME).addBan(t.getName(),"Fuiste Baneado hasta el " + banTime,banTime,null);
                    t.kickPlayer("Fuiste Baneado hasta el " + banTime);
                    p.closeInventory();
                    break;

                case DIAMOND_ORE:
                    banTime = new Date(System.currentTimeMillis() + 172800000);
                    t.getServer().getBanList(BanList.Type.NAME).addBan(t.getName(),"Fuiste Baneado hasta el " + banTime,banTime,null);
                    t.kickPlayer("Fuiste Baneado hasta el " + banTime);
                    p.closeInventory();
                    break;

                case COAL_BLOCK:
                    banTime = new Date(System.currentTimeMillis() + 432000000);
                    t.getServer().getBanList(BanList.Type.NAME).addBan(t.getName(),"Fuiste Baneado hasta el " + banTime,banTime,null);
                    t.kickPlayer("Fuiste Baneado hasta el " + banTime);
                    p.closeInventory();
                    break;

                case IRON_BLOCK:
                    banTime = new Date(System.currentTimeMillis() + 864000000);
                    t.getServer().getBanList(BanList.Type.NAME).addBan(t.getName(),"Fuiste Baneado hasta el " + banTime,banTime,null);
                    t.kickPlayer("Fuiste Baneado hasta el " + banTime);
                    p.closeInventory();
                    break;

                case GOLD_BLOCK:
                    banTime = new Date(System.currentTimeMillis() + 1296000000);
                    t.getServer().getBanList(BanList.Type.NAME).addBan(t.getName(),"Fuiste Baneado hasta el " + banTime,banTime,null);
                    t.kickPlayer("Fuiste Baneado hasta el " + banTime);
                    p.closeInventory();
                    break;

               /*case DIAMOND_BLOCK:
                    banTime = new Date(System.currentTimeMillis() + (1296000000 * 2));
                    t.getServer().getBanList(BanList.Type.NAME).addBan(t.getName(),"Fuiste Baneado hasta el " + banTime,banTime,null);
                    t.kickPlayer("Fuiste Baneado hasta el " + banTime);
                    p.closeInventory();
                    break;

                case NETHERITE_BLOCK:
                    banTime = new Date(System.currentTimeMillis() + 500 * 60 * 60 * 60 * 24);
                    t.getServer().getBanList(BanList.Type.NAME).addBan(t.getName(),"Fuiste Baneado hasta el " + banTime,banTime,null);
                    t.kickPlayer("Fuiste Baneado hasta el " + banTime);
                    break;*/

                case BARRIER:
                    t.getServer().getBanList(BanList.Type.NAME).addBan(t.getName(),"Fuiste Baneado permanentemente ",null,null);
                    t.kickPlayer("Fuiste Baneado permanenetemente");
                    break;
            }
            e.setCancelled(true);
        }
    }
}
