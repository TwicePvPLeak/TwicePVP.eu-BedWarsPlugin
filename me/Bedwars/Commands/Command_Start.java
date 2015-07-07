package me.Bedwars.Commands;

import me.Bedwars.Data.Data;
import me.Bedwars.GameStatus.GameStatus;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Start
  implements CommandExecutor
{
  public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3)
  {
    Player p = (Player)arg0;
    if (p.isOp())
    {
      if (Data.status == GameStatus.LOBBY)
      {
        Data.countdown = 1;
        Bukkit.broadcastMessage("§e***************************");
        Bukkit.broadcastMessage("§6Schnellstart von§4 " + p.getName());
        Bukkit.broadcastMessage("§e***************************");
      }
    }
    else {
      p.sendMessage("§cHAHHAH Klarrr");
    }
    return false;
  }
}
