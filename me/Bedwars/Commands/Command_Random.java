package me.Bedwars.Commands;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import me.Bedwars.Data.Data;
import me.Bedwars.GameStatus.GameStatus;
import me.Bedwars.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

public class Command_Random
  implements CommandExecutor
{
  public static int getRandom(int lower, int upper)
  {
    Random random = new Random();
    return random.nextInt(upper - lower + 1) + lower;
  }
  
  public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3)
  {
    Player p = (Player)arg0;
    if (Data.status == GameStatus.LOBBY)
    {
      if ((!Data.rot.contains(p)) && (!Data.blau.contains(p))) {
        if (canJoin("red"))
        {
          Data.blau.remove(p);
          Data.rot.remove(p);
          Data.rot.add(p);
          Data.noteam.remove(p);
          


          Main.teamr.addPlayer(p);
        }
        else if (canJoin("blue"))
        {
          Data.rot.remove(p);
          Data.blau.remove(p);
          Data.blau.add(p);
          Data.noteam.remove(p);
          


          Main.teamb.addPlayer(p);
        }
      }
    }
    else {
      p.sendMessage("§cNein.");
    }
    return false;
  }
  
  public boolean canJoin(String team)
  {
    double maxSize = 0.0D;
    double anzTeams = 2.0D;
    if (Bukkit.getOnlinePlayers().size() % anzTeams == 0.0D) {
      maxSize = Bukkit.getOnlinePlayers().size() / anzTeams;
    } else {
      maxSize = Math.floor(Bukkit.getOnlinePlayers().size() / anzTeams) + 1.0D;
    }
    if ((team.equalsIgnoreCase("red")) && (Data.rot.size() < maxSize)) {
      return true;
    }
    if ((team.equalsIgnoreCase("blue")) && (Data.blau.size() < maxSize)) {
      return true;
    }
    return false;
  }
}
