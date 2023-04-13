package org.gonito.staffmenu.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


import java.util.ArrayList;
import java.util.HashMap;


public class ChannelManager {

    public HashMap<String, ArrayList<Player>> channels = new HashMap<String,ArrayList<Player>>();
    public HashMap<Player,String> playerChannel = new HashMap<>();

    public void joinChannel(Player p, String cN){
        if(playerChannel.get(p) != null){
            String prevChannel = playerChannel.get(p);
            leaveChannel(p,cN);
        }
        ArrayList<Player> players = channels.get(cN);
        if(players == null){
            players = new ArrayList<Player>();
        }
        players.add(p);
        channels.put(cN, players);
        playerChannel.put(p,cN);
    }
    public void leaveChannel(Player p, String cN){
        ArrayList<Player> players = channels.get(cN);
        players.remove(p);
        channels.put(cN,players);
        playerChannel.remove(p);
    }
    public ArrayList<Player> getChannel(Player p){
        String cN = playerChannel.get(p);
        return channels.get(cN);
    }
}
