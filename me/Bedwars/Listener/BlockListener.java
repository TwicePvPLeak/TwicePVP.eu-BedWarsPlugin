package me.Bedwars.Listener;

import java.util.Collection;
import java.util.List;
import me.Bedwars.Data.Data;
import me.Bedwars.GameStatus.GameStatus;
import me.Bedwars.Main;
import me.Bedwars.MySQL.SQL;
import me.Tokens.TokenSQLUtils;
import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EntityPlayer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R1.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.server.ServerListPingEvent;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class BlockListener
  implements Listener
{
  @EventHandler
  public void onBlockBreak(BlockBreakEvent e)
  {
    if (!Data.players.contains(e.getPlayer()))
    {
      e.setCancelled(true);
      return;
    }
    if (Data.status == GameStatus.LOBBY) {
      e.setCancelled(true);
    }
    if ((e.getBlock().getType() != Material.SANDSTONE) && 
      (e.getBlock().getType() != Material.BED_BLOCK) && 
      (e.getBlock().getType() != Material.CAKE) && 
      (e.getBlock().getType() != Material.CAKE_BLOCK) && 
      (e.getBlock().getType() != Material.LONG_GRASS) && 
      (e.getBlock().getType() != Material.MELON_BLOCK) && 
      (e.getBlock().getType() != Material.WATER_LILY) && 
      (e.getBlock().getType() != Material.DEAD_BUSH) && 
      (e.getBlock().getType() != Material.DOUBLE_PLANT) && 
      (e.getBlock().getType() != Material.RED_ROSE) && 
      (e.getBlock().getType() != Material.YELLOW_FLOWER) && 
      (e.getBlock().getType() != Material.BED_BLOCK) && 
      (e.getBlock().getType() != Material.WEB) && 
      (e.getBlock().getType() != Material.ENDER_STONE) && 
      (e.getBlock().getType() != Material.CHEST) && 
      (e.getBlock().getType() != Material.LADDER) && 
      (e.getBlock().getType() != Material.LONG_GRASS)) {
      e.setCancelled(true);
    }
    if (e.getBlock().getType() == Material.BED_BLOCK)
    {
      e.getBlock().getDrops().clear();
      Location loc1 = Data.getLocation("bettblau1");
      Location loc2 = Data.getLocation("bettblau2");
      
      Location loc3 = Data.getLocation("bettrot1");
      Location loc4 = Data.getLocation("bettrot2");
      
      int bedXB1 = loc1.getBlockX();int bedYB1 = loc1.getBlockY();
      int bedZB1 = loc1.getBlockZ();
      int bedXO1 = loc2.getBlockX();int bedYO1 = loc2.getBlockY();
      int bedZO1 = loc2.getBlockZ();
      
      int bedXB2 = loc3.getBlockX();int bedYB2 = loc3.getBlockY();
      int bedZB2 = loc3.getBlockZ();
      int bedXO2 = loc4.getBlockX();int bedYO2 = loc4.getBlockY();
      int bedZO2 = loc4.getBlockZ();
      
      Location loc = e.getBlock().getLocation();
      if ((Data.status == GameStatus.INGAME) && 
        (Data.players.contains(e.getPlayer())))
      {
        if (((loc.getBlockX() == bedXB2) && (loc.getBlockY() == bedYB2) && 
          (loc.getBlockZ() == bedZB2) && 
          (Data.rot.contains(e.getPlayer()))) || (
          (loc.getBlockX() == bedXO2) && 
          (loc.getBlockY() == bedYO2) && 
          (loc.getBlockZ() == bedZO2) && 
          (Data.rot.contains(e.getPlayer()))))
        {
          e.getPlayer().sendMessage(
            Data.prefix + 
            " §cEs ist nicht gestattet dein eigenes Bett abzubauen!");
          e.setCancelled(true);
          e.getBlock().getDrops().clear();
        }
        else if (((loc.getBlockX() == bedXB2) && 
          (loc.getBlockY() == bedYB2) && 
          (loc.getBlockZ() == bedZB2) && 
          (Data.blau.contains(e.getPlayer()))) || (
          (loc.getBlockX() == bedXO2) && 
          (loc.getBlockY() == bedYO2) && 
          (loc.getBlockZ() == bedZO2) && 
          (Data.blau.contains(e.getPlayer()))))
        {
          Bukkit.broadcastMessage("§6Das Bett von §cRot§6 wurde von §9" + e.getPlayer().getDisplayName() + "§6 abgebaut!");
          
          Main.plugin.getCommands().addbette(e.getPlayer().getUniqueId(), 1);
          Main.plugin.getCommands().addPoints(e.getPlayer().getUniqueId(), 10);
          TokenSQLUtils.addTokens(e.getPlayer().getUniqueId(), 10);
          if (e.getPlayer().hasPermission("twice.premium")) {
            TokenSQLUtils.addTokens(e.getPlayer().getUniqueId(), 10);
          }
          e.getPlayer().giveExpLevels(200);
          e.getPlayer().sendMessage("§6+ 200 Level [Bett abbauen]");
          e.getBlock().getDrops().clear();
          
          e.setCancelled(true);
          e.getBlock().setType(Material.AIR);
          for (Player all : Bukkit.getOnlinePlayers()) {
            all.playSound(all.getEyeLocation(), 
              Sound.BAT_DEATH, 1.0F, 1.0F);
          }
          Data.respawn_rot = false;
          
          Main.setScoreboard();
          for (Player rots : Data.rot)
          {
            IChatBaseComponent headertext = ChatSerializer.a("{\"text\":\"§6Dein Bett\"}");
            PacketPlayOutTitle header = new PacketPlayOutTitle(EnumTitleAction.TITLE, headertext);
            ((CraftPlayer)rots).getHandle().playerConnection.sendPacket(header);
            
            IChatBaseComponent footertext = ChatSerializer.a("{\"text\":\"§6wurde abgebaut\"}");
            PacketPlayOutTitle footer = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, footertext);
            ((CraftPlayer)rots).getHandle().playerConnection.sendPacket(footer);
            
            PacketPlayOutTitle times = new PacketPlayOutTitle(EnumTitleAction.TIMES, null, 20, 60, 20);
            ((CraftPlayer)rots).getHandle().playerConnection.sendPacket(times);
          }
          if (!e.getPlayer().hasPermission("achievement.rusher"))
          {
            PermissionsEx.getUser(e.getPlayer()).addPermission("achievement.rusher");
            e.getPlayer().sendMessage("§8§k**********************************************");
            e.getPlayer().sendMessage("§8");
            e.getPlayer().sendMessage("§8Errungschaft: §cRusher  §a✔");
            e.getPlayer().sendMessage("§8");
            e.getPlayer().sendMessage("§8§k**********************************************");
          }
        }
        if (((loc.getBlockX() == bedXB1) && (loc.getBlockY() == bedYB1) && 
          (loc.getBlockZ() == bedZB1) && 
          (Data.blau.contains(e.getPlayer()))) || (
          (loc.getBlockX() == bedXO1) && 
          (loc.getBlockY() == bedYO1) && 
          (loc.getBlockZ() == bedZO1) && 
          (Data.blau.contains(e.getPlayer()))))
        {
          e.getPlayer().sendMessage(
            Data.prefix + 
            " §cEs ist nicht gestattet dein eigenes Bett abzubauen!");
          e.setCancelled(true);
          e.getBlock().getDrops().clear();
        }
        else if (((loc.getBlockX() == bedXB1) && 
          (loc.getBlockY() == bedYB1) && 
          (loc.getBlockZ() == bedZB1) && 
          (Data.rot.contains(e.getPlayer()))) || (
          (loc.getBlockX() == bedXO1) && 
          (loc.getBlockY() == bedYO1) && 
          (loc.getBlockZ() == bedZO1) && 
          (Data.rot.contains(e.getPlayer()))))
        {
          Bukkit.broadcastMessage("§6Das Bett von §9Blau§6 wurde von §c" + 
            e.getPlayer().getDisplayName() + 
            "§6 abgebaut!");
          
          Main.plugin.getCommands().addbette(
            e.getPlayer().getUniqueId(), 1);
          if (e.getPlayer().hasPermission("twice.premium")) {
            TokenSQLUtils.addTokens(e.getPlayer().getUniqueId(), 10);
          }
          TokenSQLUtils.addTokens(e.getPlayer().getUniqueId(), 10);
          Main.plugin.getCommands().addPoints(e.getPlayer().getUniqueId(), 10);
          e.getPlayer().giveExpLevels(200);
          e.getPlayer().sendMessage(
            "§6+ 200 Level [Bett abbauen]");
          e.getBlock().getDrops().clear();
          
          e.setCancelled(true);
          e.getBlock().setType(Material.AIR);
          for (Player all : Bukkit.getOnlinePlayers()) {
            all.playSound(all.getEyeLocation(), 
              Sound.BAT_DEATH, 1.0F, 1.0F);
          }
          Data.respawn_blau = false;
          
          Main.setScoreboard();
          for (Player blaus : Data.blau)
          {
            IChatBaseComponent headertext = 
              ChatSerializer.a("{\"text\":\"§6Dein Bett\"}");
            PacketPlayOutTitle header = new PacketPlayOutTitle(
              EnumTitleAction.TITLE, headertext);
            ((CraftPlayer)blaus).getHandle().playerConnection
              .sendPacket(header);
            
            IChatBaseComponent footertext = 
              ChatSerializer.a("{\"text\":\"§6wurde abgebaut\"}");
            PacketPlayOutTitle footer = new PacketPlayOutTitle(
              EnumTitleAction.SUBTITLE, footertext);
            ((CraftPlayer)blaus).getHandle().playerConnection
              .sendPacket(footer);
            
            PacketPlayOutTitle times = new PacketPlayOutTitle(
              EnumTitleAction.TIMES, null, 20, 60, 20);
            ((CraftPlayer)blaus).getHandle().playerConnection
              .sendPacket(times);
          }
          if (!e.getPlayer().hasPermission("achievement.rusher"))
          {
            PermissionsEx.getUser(e.getPlayer()).addPermission("achievement.rusher");
            e.getPlayer().sendMessage("§8§k**********************************************");
            e.getPlayer().sendMessage("§8");
            e.getPlayer().sendMessage("§8Errungschaft: §cRusher  §a✔");
            e.getPlayer().sendMessage("§8");
            e.getPlayer().sendMessage("§8§k**********************************************");
          }
        }
      }
    }
  }
  
  @EventHandler
  public void on(BlockPlaceEvent e)
  {
    if ((Data.status == GameStatus.INGAME) && 
      (Data.players.contains(e.getPlayer())))
    {
      if ((e.getBlock().getType() != Material.SANDSTONE) && 
        (e.getBlock().getType() != Material.BED_BLOCK) && 
        (e.getBlock().getType() != Material.CAKE) && 
        (e.getBlock().getType() != Material.CAKE_BLOCK) && 
        (e.getBlock().getType() != Material.LONG_GRASS) && 
        (e.getBlock().getType() != Material.MELON_BLOCK) && 
        (e.getBlock().getType() != Material.WATER_LILY) && 
        (e.getBlock().getType() != Material.DEAD_BUSH) && 
        (e.getBlock().getType() != Material.DOUBLE_PLANT) && 
        (e.getBlock().getType() != Material.RED_ROSE) && 
        (e.getBlock().getType() != Material.YELLOW_FLOWER) && 
        (e.getBlock().getType() != Material.BED_BLOCK) && 
        (e.getBlock().getType() != Material.WEB) && 
        (e.getBlock().getType() != Material.ENDER_STONE) && 
        (e.getBlock().getType() != Material.CHEST) && 
        (e.getBlock().getType() != Material.LADDER) && 
        (e.getBlock().getType() != Material.LONG_GRASS)) {
        e.setCancelled(true);
      } else {
        e.setCancelled(false);
      }
    }
    else {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onBlockIgnite(BlockIgniteEvent e)
  {
    if (e.getCause() == BlockIgniteEvent.IgniteCause.SPREAD) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onBlockIgsnite(LeavesDecayEvent e)
  {
    e.setCancelled(true);
  }
  
  @EventHandler
  public void onBlockBurn(BlockBurnEvent event)
  {
    event.setCancelled(true);
  }
  
  @EventHandler
  public void on(PlayerBedEnterEvent e)
  {
    e.setCancelled(true);
  }
  
  @EventHandler
  public void on(ServerListPingEvent e)
  {
    if (Data.status != GameStatus.LOBBY) {
      e.setMotd("§4§lINGAME");
    } else {
      e.setMotd("§a" + Data.getLocation("blauspawn").getWorld().getName());
    }
  }
  
  @EventHandler
  public void on(PlayerLoginEvent e)
  {
    if (Bukkit.getOnlinePlayers().size() == Bukkit.getMaxPlayers()) {
      e.disallow(
        PlayerLoginEvent.Result.KICK_BANNED, 
        "§6Kaufe dir §9Premium§6 in unserem Shop! http://shop.twicepvp.eu");
    }
  }
  
  @EventHandler
  public void ons(PlayerLoginEvent e)
  {
    if (Data.status == GameStatus.INGAME) {
      e.disallow(
        PlayerLoginEvent.Result.KICK_BANNED, 
        "§4Der Server ist schon Ingame!");
    }
  }
  
  @EventHandler
  public void on(CraftItemEvent e)
  {
    e.setCancelled(true);
  }
}
