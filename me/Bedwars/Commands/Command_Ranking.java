package me.Bedwars.Commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import me.Bedwars.Data.Data;
import me.Bedwars.Main;
import me.Bedwars.MySQL.MySQL;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Command_Ranking
  implements CommandExecutor
{
  private List<String> cooldown = new ArrayList();
  
  public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args)
  {
    final Player p = (Player)sender;
    if (this.cooldown.contains(p.getName()))
    {
      p.sendMessage(Main.prefix + " Warte noch einen Moment, bis du den Befehl wieder verwendest!");
      return true;
    }
    this.cooldown.add(p.getName());
    
    new BukkitRunnable()
    {
      public void run()
      {
        p.sendMessage(Main.prefix + " Die 10 besten Spieler!");
        try
        {
          PreparedStatement stmt = Main.sql.getConnection().prepareStatement("SELECT name, points FROM punkte ORDER BY cast(points as unsigned) DESC LIMIT 0,10");
          ResultSet rs = stmt.executeQuery();
          
          int i = 1;
          do
          {
            p.sendMessage("    §5§l#" + i + " §7" + rs.getString("name") + " §8(§7" + rs.getInt("points") + " Punkte§8)");
            i++;
            if (!rs.next()) {
              break;
            }
          } while (i <= 10);
        }
        catch (SQLException e)
        {
          p.sendMessage(Data.prefix + "§c Es ist ein Fehler aufgetreten!");
          e.printStackTrace();
        }
        new BukkitRunnable()
        {
          public void run()
          {
            Command_Ranking.this.cooldown.remove(this.val$p.getName());
          }
        }.runTaskLater(Main.plugin, 100L);
      }
    }.runTaskAsynchronously(Main.plugin);
    
    return true;
  }
}
