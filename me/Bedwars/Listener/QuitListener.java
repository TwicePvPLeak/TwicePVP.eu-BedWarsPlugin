package me.Bedwars.Listener;

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
import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Team;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class QuitListener
  implements Listener
{
  @EventHandler
  public void on(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    Data.rot.remove(p);
    Data.blau.remove(p);
    Data.players.remove(p);
    e.setQuitMessage(null);
    if (Main.teamr.hasPlayer(e.getPlayer())) {
      Main.teamr.removePlayer(e.getPlayer());
    }
    if (Main.teamb.hasPlayer(e.getPlayer())) {
      Main.teamb.removePlayer(e.getPlayer());
    }
    if (Data.status != GameStatus.LOBBY) {
      Main.setScoreboard();
    }
    if (Data.status == GameStatus.LOBBY) {
      e.setQuitMessage("§7" + p.getName() + 
        " §6hat den Server verlassen!");
    }
    if ((Data.status != GameStatus.LOBBY) && 
      (Data.status != GameStatus.ENDE))
    {
      if (Data.rot.size() == 0)
      {
        Data.status = GameStatus.ENDE;
        Bukkit.broadcastMessage(Data.prefix + 
          "§6§l Das Team§9 Blau§6§l hat das Spiel für sich entschieden!");
        Bukkit.broadcastMessage(Data.prefix + 
          "§7 Der Server restartet in Kürze!");
        Bukkit.broadcastMessage("§cPlugin vom TwicePvP.eu - Developer Team");
        Data.sendAllLobby();
        for (Player all : Bukkit.getOnlinePlayers())
        {
          all.setGameMode(GameMode.SPECTATOR);
          all.setFlying(true);
          IChatBaseComponent headertext = 
            ChatSerializer.a("{\"text\":\"§6Gewinner: §9Team Blau!\"}");
          PacketPlayOutTitle header = new PacketPlayOutTitle(
            EnumTitleAction.TITLE, headertext);
          ((CraftPlayer)all).getHandle().playerConnection
            .sendPacket(header);
          
          IChatBaseComponent footertext = 
            ChatSerializer.a("{\"text\":\"§7Der Server restartet jetzt . . .\"}");
          PacketPlayOutTitle footer = new PacketPlayOutTitle(
            EnumTitleAction.SUBTITLE, footertext);
          ((CraftPlayer)all).getHandle().playerConnection
            .sendPacket(footer);
          
          PacketPlayOutTitle times = new PacketPlayOutTitle(
            EnumTitleAction.TIMES, null, 20, 60, 20);
          ((CraftPlayer)all).getHandle().playerConnection
            .sendPacket(times);
        }
        for (Player blau : Data.blau)
        {
          Main.plugin.getCommands().addPoints(blau.getUniqueId(), 
            30);
          Main.plugin.getCommands().addWin(blau.getUniqueId(), 1);
          TokenSQLUtils.addTokens(blau.getUniqueId(), 30);
          if (blau.hasPermission("twice.premium")) {
            TokenSQLUtils.addTokens(blau.getUniqueId(), 30);
          }
          if ((!blau.hasPermission("achievement.erstersieg")) && 
            (Main.plugin.getCommands().getPWins(
            blau.getUniqueId()) == 1))
          {
            PermissionsEx.getUser(blau).addPermission(
              "achievement.erstersieg");
            blau.sendMessage("§8§k**********************************************");
            blau.sendMessage("§8");
            blau.sendMessage("§8Errungschaft: §cErster Sieg  §a✔");
            blau.sendMessage("§8");
            blau.sendMessage("§8§k**********************************************");
          }
          if ((!blau.hasPermission("achievement.fortgeschrittener")) && 
            (Main.plugin.getCommands().getPWins(
            blau.getUniqueId()) == 25))
          {
            PermissionsEx.getUser(blau).addPermission(
              "achievement.fortgeschrittener");
            blau.sendMessage("§8§k**********************************************");
            blau.sendMessage("§8");
            blau.sendMessage("§8Errungschaft: §cFortgeschrittener  §a✔");
            blau.sendMessage("§8");
            blau.sendMessage("§8§k**********************************************");
          }
          if ((!blau.hasPermission("achievement.meister")) && 
            (Main.plugin.getCommands().getPWins(
            blau.getUniqueId()) == 50))
          {
            PermissionsEx.getUser(blau).addPermission(
              "achievement.meister");
            blau.sendMessage("§8§k**********************************************");
            blau.sendMessage("§8");
            blau.sendMessage("§8Errungschaft: §cMeister  §a✔");
            blau.sendMessage("§8");
            blau.sendMessage("§8§k**********************************************");
          }
        }
      }
      if (Data.blau.size() == 0)
      {
        Data.status = GameStatus.ENDE;
        Bukkit.broadcastMessage(Data.prefix + 
          "§6§l Das Team§c Rot§6§l hat das Spiel für sich entschieden!");
        Bukkit.broadcastMessage(Data.prefix + 
          "§7 Der Server restartet in Kürze!");
        Bukkit.broadcastMessage("§cPlugin vom TwicePvP.eu - Developer Team");
        Data.sendAllLobby();
        for (Player all : Bukkit.getOnlinePlayers())
        {
          all.setGameMode(GameMode.SPECTATOR);
          all.setFlying(true);
          IChatBaseComponent headertext = 
            ChatSerializer.a("{\"text\":\"§6Gewinner: §cTeam Rot!\"}");
          PacketPlayOutTitle header = new PacketPlayOutTitle(
            EnumTitleAction.TITLE, headertext);
          ((CraftPlayer)all).getHandle().playerConnection
            .sendPacket(header);
          
          IChatBaseComponent footertext = 
            ChatSerializer.a("{\"text\":\"§7Der Server restartet jetzt . . .\"}");
          PacketPlayOutTitle footer = new PacketPlayOutTitle(
            EnumTitleAction.SUBTITLE, footertext);
          ((CraftPlayer)all).getHandle().playerConnection
            .sendPacket(footer);
          
          PacketPlayOutTitle times = new PacketPlayOutTitle(
            EnumTitleAction.TIMES, null, 20, 60, 20);
          ((CraftPlayer)all).getHandle().playerConnection
            .sendPacket(times);
        }
        for (Player rot : Data.rot)
        {
          Main.plugin.getCommands().addWin(rot.getUniqueId(), 1);
          Main.plugin.getCommands().addPoints(rot.getUniqueId(), 
            30);
          
          TokenSQLUtils.addTokens(rot.getUniqueId(), 30);
          if (rot.hasPermission("twice.premium")) {
            TokenSQLUtils.addTokens(rot.getUniqueId(), 30);
          }
          if ((!rot.hasPermission("achievement.erstersieg")) && 
            (Main.plugin.getCommands().getPWins(
            rot.getUniqueId()) == 1))
          {
            PermissionsEx.getUser(rot).addPermission(
              "achievement.erstersieg");
            rot.sendMessage("§8§k**********************************************");
            rot.sendMessage("§8");
            rot.sendMessage("§8Errungschaft: §cErster Sieg  §a✔");
            rot.sendMessage("§8");
            rot.sendMessage("§8§k**********************************************");
          }
          if ((!rot.hasPermission("achievement.fortgeschrittener")) && 
            (Main.plugin.getCommands().getPWins(
            rot.getUniqueId()) == 25))
          {
            PermissionsEx.getUser(rot).addPermission(
              "achievement.fortgeschrittener");
            rot.sendMessage("§8§k**********************************************");
            rot.sendMessage("§8");
            rot.sendMessage("§8Errungschaft: §cFortgeschrittener  §a✔");
            rot.sendMessage("§8");
            rot.sendMessage("§8§k**********************************************");
          }
          if ((!rot.hasPermission("achievement.meister")) && 
            (Main.plugin.getCommands().getPWins(
            rot.getUniqueId()) == 50))
          {
            PermissionsEx.getUser(rot).addPermission(
              "achievement.meister");
            rot.sendMessage("§8§k**********************************************");
            rot.sendMessage("§8");
            rot.sendMessage("§8Errungschaft: §cMeister  §a✔");
            rot.sendMessage("§8");
            rot.sendMessage("§8§k**********************************************");
          }
        }
      }
    }
  }
}
