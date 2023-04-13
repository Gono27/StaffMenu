package org.gonito.staffmenu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.gonito.staffmenu.commands.*;
import org.gonito.staffmenu.events.*;
import org.gonito.staffmenu.util.ChannelManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


public final class StaffMenu extends JavaPlugin {
    public ChannelManager cM;
    public ArrayList<Player> freezed = new ArrayList<>();
    public ArrayList<Player> vanished = new ArrayList<>();
    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "StaffMenu");
        Objects.requireNonNull(getCommand("sm")).setExecutor(new GUICommand(this));
        Objects.requireNonNull(getCommand("vanish")).setExecutor(new Vanish(this));
        Objects.requireNonNull(getCommand("freeze")).setExecutor(new Freeze(this));
        Objects.requireNonNull(getCommand("staffchat")).setExecutor(new StaffChat(this));
        getServer().getPluginManager().registerEvents(new VanishEvent(this),this);
        getServer().getPluginManager().registerEvents(new FreezeEvent(this),this);
        getServer().getPluginManager().registerEvents(new BanEvent(),this);
        getServer().getPluginManager().registerEvents(new PlayersListEvent(),this);
        getServer().getPluginManager().registerEvents(new StaffChatEvent(this),this);
        getServer().getPluginManager().registerEvents(new TpEvent(),this);
        getServer().getPluginManager().registerEvents(new KickEvent(),this);

        cM = new ChannelManager();
    }
    @Override
    public void onDisable() {

    }
}
