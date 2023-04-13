package org.gonito.staffmenu.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.gonito.staffmenu.StaffMenu;

import java.util.ArrayList;

public class GUICommand implements CommandExecutor {
    StaffMenu plugin;
    Player p;

    public GUICommand(StaffMenu plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED+"Esto solo puede ser usado por un usuario");
            return false;
        }
        p = (Player) sender;
        Inventory gui = Bukkit.createInventory(p, 9, ChatColor.AQUA + "Staff Menu");

        ItemStack playerList = new ItemStack(Material.PLAYER_HEAD, Bukkit.getOnlinePlayers().size());
        SkullMeta playerListMeta = (SkullMeta) playerList.getItemMeta();
        ItemStack banMenu = new ItemStack(Material.BARRIER, 1);
        ItemMeta banMenuMeta = banMenu.getItemMeta();
        ItemStack tpToPlayer = new ItemStack(Material.COMPASS, 1);
        ItemMeta tpToPlayerMeta = tpToPlayer.getItemMeta();
        ItemStack vanishOff = new ItemStack(Material.GRAY_DYE, 1);
        ItemMeta vanishOffMeta = vanishOff.getItemMeta();
        ItemStack vanishOn = new ItemStack(Material.LIME_DYE, 1);
        ItemMeta vanishOnMeta = vanishOn.getItemMeta();
        ItemStack kickMenu = new ItemStack(Material.OAK_DOOR, 1);
        ItemMeta kickMenuMeta = kickMenu.getItemMeta();

        ArrayList<String> playerListLore = new ArrayList<>();
        playerListLore.add("List of the players online");
        ArrayList<String> banMenuLore = new ArrayList<>();
        banMenuLore.add("Ban a player");
        ArrayList<String> tpToPlayerLore = new ArrayList<>();
        tpToPlayerLore.add("Tp tp select player");
        ArrayList<String> vanishOffLore = new ArrayList<>();
        vanishOffLore.add("Enable o disable Vanish");
        ArrayList<String> vanishOnLore = new ArrayList<>();
        vanishOnLore.add("Tp tp select player");
        ArrayList<String> kickMenuLore = new ArrayList<>();
        kickMenuLore.add("Kick a player");

        assert playerListMeta != null;
        playerListMeta.setDisplayName("Players List");
        playerListMeta.setLore(playerListLore);
        playerListMeta.setOwnerProfile(p.getPlayerProfile());
        playerList.setItemMeta(playerListMeta);

        assert banMenuMeta != null;
        banMenuMeta.setDisplayName("Ban Players");
        banMenuMeta.setLore(banMenuLore);
        banMenu.setItemMeta(banMenuMeta);

        assert tpToPlayerMeta != null;
        tpToPlayerMeta.setDisplayName("Tp player");
        tpToPlayerMeta.setLore(tpToPlayerLore);
        tpToPlayer.setItemMeta(tpToPlayerMeta);

        assert vanishOffMeta != null;
        vanishOffMeta.setDisplayName("Vanish disable");
        vanishOffMeta.setLore(vanishOffLore);
        vanishOff.setItemMeta(vanishOffMeta);

        assert vanishOnMeta != null;
        vanishOnMeta.setDisplayName("Vanish enable");
        vanishOnMeta.setLore(vanishOnLore);
        vanishOn.setItemMeta(vanishOnMeta);

        assert kickMenuMeta != null;
        kickMenuMeta.setDisplayName("Vanish enable");
        kickMenuMeta.setLore(kickMenuLore);
        kickMenu.setItemMeta(kickMenuMeta);

        if (plugin.vanished.contains(p)) {
            gui.addItem(playerList, banMenu, tpToPlayer, vanishOn, kickMenu);
            p.closeInventory();
        } else {
            gui.addItem(playerList, banMenu, tpToPlayer, vanishOff, kickMenu);
            p.closeInventory();
        }
        p.openInventory(gui);
        return true;
    }

}
