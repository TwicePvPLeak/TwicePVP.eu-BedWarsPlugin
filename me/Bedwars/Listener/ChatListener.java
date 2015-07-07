package me.Bedwars.Listener;

import java.util.List;
import me.Bedwars.Data.Data;
import me.Bedwars.GameStatus.GameStatus;
import me.Bedwars.Main;
import me.Bedwars.MySQL.SQL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener
  implements Listener
{
  @EventHandler
  public void on(AsyncPlayerChatEvent e)
  {
    e.setCancelled(true);
    if (Data.status == GameStatus.ENDE) {
      Bukkit.broadcastMessage("§7" + e.getPlayer().getName() + "§8:§6 " + e.getMessage());
    }
    if ((Data.spec.contains(e.getPlayer())) && (Data.status != GameStatus.ENDE))
    {
      e.getPlayer().sendMessage(Data.prefix + "§c Du darfst als Zuschauer nicht schreiben!");
      e.setCancelled(true);
    }
    if (Data.status == GameStatus.LOBBY) {
      if (Data.rot.contains(e.getPlayer()))
      {
        Bukkit.broadcastMessage("§6[§8" + Main.plugin.getCommands().getPoints(e.getPlayer().getUniqueId()) + "§6]§c " + e.getPlayer().getName() + "§8:§6 " + e.getMessage());
        e.setCancelled(true);
      }
      else if (Data.blau.contains(e.getPlayer()))
      {
        Bukkit.broadcastMessage("§6[§8" + Main.plugin.getCommands().getPoints(e.getPlayer().getUniqueId()) + "§6]§9 " + e.getPlayer().getName() + "§8:§6 " + e.getMessage());
        e.setCancelled(true);
      }
      else
      {
        Bukkit.broadcastMessage("§6[§8" + Main.plugin.getCommands().getPoints(e.getPlayer().getUniqueId()) + "§6]§7 " + e.getPlayer().getName() + "§8:§6 " + e.getMessage());
        e.setCancelled(true);
      }
    }
    if (Data.status == GameStatus.INGAME)
    {
      e.setCancelled(true);
      if (Data.players.contains(e.getPlayer()))
      {
        if (e.getMessage().toLowerCase().startsWith("@all"))
        {
          e.getMessage().replace("@all", "");
          for (Player all : Bukkit.getOnlinePlayers()) {
            all.sendMessage("§6" + e.getPlayer().getName() + 
              "§8: §7" + e.getMessage());
          }
        }
        else if (Data.rot.contains(e.getPlayer()))
        {
          for (Player rot : Data.rot) {
            rot.sendMessage("§cRot: " + e.getPlayer().getName() + 
              "§8: §7" + e.getMessage());
          }
        }
        else if (Data.blau.contains(e.getPlayer()))
        {
          for (Player blau : Data.blau) {
            blau.sendMessage("§9Blau: " + 
              e.getPlayer().getName() + "§8: §7" + 
              e.getMessage());
          }
        }
      }
      else {
        e.setCancelled(true);
      }
    }
  }
}
