package me.Bedwars.Listener;

import java.util.List;
import me.Bedwars.Data.Data;
import me.Bedwars.GameStatus.GameStatus;
import me.Bedwars.Main;
import me.Bedwars.MySQL.SQL;
import me.Tokens.TokenSQLUtils;
import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EntityPlayer;
import net.minecraft.server.v1_8_R1.EnumClientCommand;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayInClientCommand;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R1.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class DeathListener
  implements Listener
{
  @EventHandler
  public void onDeath(PlayerDeathEvent e)
  {
    e.setDeathMessage(null);
    


    e.getDrops().clear();
    e.setDroppedExp(0);
    


    final Player p = e.getEntity();
    


    new BukkitRunnable()
    {
      public void run()
      {
        ((CraftPlayer)p).getHandle().playerConnection.a(new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN));
      }
    }.runTaskLater(Main.plugin, 2L);
    if (e.getEntity().getKiller() == null) {
      e.setDeathMessage(Data.prefix + " §d" + p.getName() + " §5ist gestorben!");
    } else {
      e.setDeathMessage(Data.prefix + " §d" + p.getName() + " §5wurde von §d" + p.getKiller().getName() + " §5getötet!");
    }
    if ((!Data.respawn_blau) && (Data.blau.contains(p)))
    {
      Data.blau.remove(p);
      Data.players.remove(p);
      Data.spec.add(p);
      Main.plugin.getCommands().addTod(p.getUniqueId(), 1);
      if (p.getKiller() != null)
      {
        Main.plugin.getCommands().addKill(p.getKiller().getUniqueId(), 1);
        Main.plugin.getCommands().addPoints(p.getKiller().getUniqueId(), 5);
        TokenSQLUtils.addTokens(p.getKiller().getUniqueId(), 5);
        if (p.getKiller().hasPermission("twice.premium")) {
          TokenSQLUtils.addTokens(p.getKiller().getUniqueId(), 5);
        }
      }
      for (Player all : Bukkit.getOnlinePlayers()) {
        all.hidePlayer(p);
      }
    }
    if ((!Data.respawn_rot) && (Data.rot.contains(p)))
    {
      Data.rot.remove(p);
      Data.players.remove(p);
      Data.spec.add(p);
      Main.plugin.getCommands().addTod(p.getUniqueId(), 1);
      if (p.getKiller() != null)
      {
        Main.plugin.getCommands().addKill(p.getKiller().getUniqueId(), 1);
        Main.plugin.getCommands().addPoints(p.getKiller().getUniqueId(), 5);
        TokenSQLUtils.addTokens(p.getKiller().getUniqueId(), 5);
        if (p.getKiller().hasPermission("twice.premium")) {
          TokenSQLUtils.addTokens(p.getKiller().getUniqueId(), 5);
        }
      }
      for (Player all : Bukkit.getOnlinePlayers()) {
        all.hidePlayer(p);
      }
    }
    if (Data.status != GameStatus.ENDE) {
      if (Data.rot.size() == 0)
      {
        Data.status = GameStatus.ENDE;
        Bukkit.broadcastMessage(Data.prefix + "§6§l Das Team§9 Blau§6§l hat das Spiel für sich entschieden!");
        Bukkit.broadcastMessage(Data.prefix + "§7 Der Server restartet in Kürze!");
        Bukkit.broadcastMessage("§cPlugin vom TwicePvP.eu - Developer Team");
        Data.sendAllLobby();
        for (Player all : Bukkit.getOnlinePlayers())
        {
          all.setGameMode(GameMode.SPECTATOR);
          all.setFlying(true);
          IChatBaseComponent headertext = ChatSerializer.a("{\"text\":\"§6Gewinner: §9Team Blau!\"}");
          PacketPlayOutTitle header = new PacketPlayOutTitle(EnumTitleAction.TITLE, headertext);
          ((CraftPlayer)all).getHandle().playerConnection.sendPacket(header);
          
          IChatBaseComponent footertext = ChatSerializer.a("{\"text\":\"§7Der Server restartet jetzt . . .\"}");
          PacketPlayOutTitle footer = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, footertext);
          ((CraftPlayer)all).getHandle().playerConnection.sendPacket(footer);
          
          PacketPlayOutTitle times = new PacketPlayOutTitle(EnumTitleAction.TIMES, null, 20, 60, 20);
          ((CraftPlayer)all).getHandle().playerConnection.sendPacket(times);
        }
        for (Player blau : Data.blau)
        {
          Main.plugin.getCommands().addWin(blau.getUniqueId(), 1);
          Main.plugin.getCommands().addPoints(blau.getUniqueId(), 20);
          TokenSQLUtils.addTokens(blau.getUniqueId(), 30);
          if (blau.hasPermission("twice.premium")) {
            TokenSQLUtils.addTokens(blau.getUniqueId(), 30);
          }
          if ((!blau.hasPermission("achievement.erstersieg")) && 
            (Main.plugin.getCommands().getPWins(blau.getUniqueId()) == 1))
          {
            PermissionsEx.getUser(blau).addPermission("achievement.erstersieg");
            blau.sendMessage("§8§k**********************************************");
            blau.sendMessage("§8");
            blau.sendMessage("§8Errungschaft: §cErster Sieg  §a✔");
            blau.sendMessage("§8");
            blau.sendMessage("§8§k**********************************************");
          }
          if ((!blau.hasPermission("achievement.fortgeschrittener")) && 
            (Main.plugin.getCommands().getPWins(blau.getUniqueId()) == 25))
          {
            PermissionsEx.getUser(blau).addPermission("achievement.fortgeschrittener");
            blau.sendMessage("§8§k**********************************************");
            blau.sendMessage("§8");
            blau.sendMessage("§8Errungschaft: §cFortgeschrittener  §a✔");
            blau.sendMessage("§8");
            blau.sendMessage("§8§k**********************************************");
          }
          if ((!blau.hasPermission("achievement.meister")) && 
            (Main.plugin.getCommands().getPWins(blau.getUniqueId()) == 50))
          {
            PermissionsEx.getUser(blau).addPermission("achievement.meister");
            blau.sendMessage("§8§k**********************************************");
            blau.sendMessage("§8");
            blau.sendMessage("§8Errungschaft: §cMeister  §a✔");
            blau.sendMessage("§8");
            blau.sendMessage("§8§k**********************************************");
          }
        }
      }
      else if (Data.blau.size() == 0)
      {
        Data.status = GameStatus.ENDE;
        Bukkit.broadcastMessage(Data.prefix + "§6§l Das Team§c Rot§6§l hat das Spiel für sich entschieden!");
        Bukkit.broadcastMessage(Data.prefix + "§7 Der Server restartet in Kürze!");
        Bukkit.broadcastMessage("§cPlugin vom TwicePvP.eu - Developer Team");
        Data.sendAllLobby();
        for (Player all : Bukkit.getOnlinePlayers())
        {
          all.setGameMode(GameMode.SPECTATOR);
          all.setFlying(true);
          IChatBaseComponent headertext = ChatSerializer.a("{\"text\":\"§6Gewinner: §cTeam Rot!\"}");
          PacketPlayOutTitle header = new PacketPlayOutTitle(EnumTitleAction.TITLE, headertext);
          ((CraftPlayer)all).getHandle().playerConnection.sendPacket(header);
          
          IChatBaseComponent footertext = ChatSerializer.a("{\"text\":\"§7Der Server restartet jetzt . . .\"}");
          PacketPlayOutTitle footer = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, footertext);
          ((CraftPlayer)all).getHandle().playerConnection.sendPacket(footer);
          
          PacketPlayOutTitle times = new PacketPlayOutTitle(EnumTitleAction.TIMES, null, 20, 60, 20);
          ((CraftPlayer)all).getHandle().playerConnection.sendPacket(times);
        }
        for (Player rot : Data.rot)
        {
          Main.plugin.getCommands().addWin(rot.getUniqueId(), 1);
          Main.plugin.getCommands().addPoints(rot.getUniqueId(), 20);
          TokenSQLUtils.addTokens(rot.getUniqueId(), 30);
          if (rot.hasPermission("twice.premium")) {
            TokenSQLUtils.addTokens(rot.getUniqueId(), 30);
          }
          if ((!rot.hasPermission("achievement.erstersieg")) && 
            (Main.plugin.getCommands().getPWins(rot.getUniqueId()) == 1))
          {
            PermissionsEx.getUser(rot).addPermission("achievement.erstersieg");
            rot.sendMessage("§8§k**********************************************");
            rot.sendMessage("§8");
            rot.sendMessage("§8Errungschaft: §cErster Sieg  §a✔");
            rot.sendMessage("§8");
            rot.sendMessage("§8§k**********************************************");
          }
          if ((!rot.hasPermission("achievement.fortgeschrittener")) && 
            (Main.plugin.getCommands().getPWins(rot.getUniqueId()) == 25))
          {
            PermissionsEx.getUser(rot).addPermission("achievement.fortgeschrittener");
            rot.sendMessage("§8§k**********************************************");
            rot.sendMessage("§8");
            rot.sendMessage("§8Errungschaft: §cFortgeschrittener  §a✔");
            rot.sendMessage("§8");
            rot.sendMessage("§8§k**********************************************");
          }
          if ((!rot.hasPermission("achievement.meister")) && 
            (Main.plugin.getCommands().getPWins(rot.getUniqueId()) == 50))
          {
            PermissionsEx.getUser(rot).addPermission("achievement.meister");
            rot.sendMessage("§8§k**********************************************");
            rot.sendMessage("§8");
            rot.sendMessage("§8Errungschaft: §cMeister  §a✔");
            rot.sendMessage("§8");
            rot.sendMessage("§8§k**********************************************");
          }
        }
      }
    }
    if (Data.status != GameStatus.LOBBY) {
      Main.setScoreboard();
    }
  }
}
