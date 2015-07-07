package me.Bedwars.Commands;

import java.text.DecimalFormat;
import me.Bedwars.Main;
import me.Bedwars.MySQL.SQL;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Stats
  implements CommandExecutor
{
  public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3)
  {
    Player p = (Player)arg0;
    
    int spiele = Main.getInstance().getCommands()
      .getPSpiele(p.getUniqueId());
    
    int gewonnen = Main.getInstance().getCommands()
      .getPWins(p.getUniqueId());
    
    int verloren = spiele - gewonnen;
    if (arg3.length == 0)
    {
      p.sendMessage("§5§lBedwars Statistik von " + p.getName());
      p.sendMessage("§fKills ➽ §5" + Main.getInstance().getCommands().getKills(p.getUniqueId()));
      p.sendMessage("§fTode ➽ §5" + Main.getInstance().getCommands().getTode(p.getUniqueId()));
      p.sendMessage("§fK/D ➽ §5" + getKDR(p));
      p.sendMessage("§fW/L ➽ §5" + getWL(p));
      p.sendMessage("§fSpiele ➽ §5" + spiele + " §f(Gewonnen: §5" + gewonnen + "§f | Verloren: §5" + verloren + "§f)");
      p.sendMessage("§fPunkte ➽ §5" + Main.getInstance().getCommands().getPoints(p.getUniqueId()));
      p.sendMessage("§fAbgebaute Betten ➽ §5" + Main.getInstance().getCommands().getbette(p.getUniqueId()));
    }
    if (arg3.length == 1)
    {
      Player p2 = Bukkit.getPlayer(arg3[0]);
      if (p2 != null)
      {
        int spiele1 = Main.getInstance().getCommands()
          .getPSpiele(p2.getUniqueId());
        
        int gewonnen1 = Main.getInstance().getCommands()
          .getPWins(p2.getUniqueId());
        
        int verloren1 = spiele - gewonnen;
        
        p.sendMessage("§5§lBedwars Statistik von " + p2.getName());
        p.sendMessage("§fKills ➽ §5" + 
          Main.getInstance().getCommands()
          .getKills(p2.getUniqueId()));
        p.sendMessage("§fTode ➽ §5" + 
          Main.getInstance().getCommands()
          .getTode(p2.getUniqueId()));
        p.sendMessage("§fK/D ➽ §5" + getKDR(p2));
        p.sendMessage("§fW/L ➽ §5" + getWL(p2));
        p.sendMessage("§fSpiele ➽ §5" + spiele1 + " §f(Gewonnen: §5" + 
          gewonnen1 + "§f | Verloren: §5" + verloren1 + "§f)");
        p.sendMessage("§fPunkte ➽ §5" + 
          Main.getInstance().getCommands()
          .getPoints(p2.getUniqueId()));
        p.sendMessage("§fAbgebaute Betten ➽ §5" + 
          Main.getInstance().getCommands()
          .getbette(p.getUniqueId()));
      }
      else
      {
        p.sendMessage("§3Dieser Spieler wurde nicht gefunden!");
      }
    }
    return false;
  }
  
  public static double getWL(Player p)
  {
    double wl = 0.0D;
    int spiele = Main.getInstance().getCommands()
      .getPSpiele(p.getUniqueId());
    
    int gewonnen = Main.getInstance().getCommands()
      .getPWins(p.getUniqueId());
    
    int verloren = spiele - gewonnen;
    if (verloren == 0) {
      verloren = 1;
    }
    wl = Double.parseDouble(Integer.toString(gewonnen)) / 
      Double.parseDouble(Integer.toString(verloren));
    DecimalFormat df = new DecimalFormat("0.000");
    String s = df.format(wl).replace(",", ".");
    if (s.endsWith("0")) {
      s = s.substring(0, s.length() - 1);
    }
    if (s.endsWith("0")) {
      s = s.substring(0, s.length() - 1);
    }
    if (s.endsWith("0")) {
      s = s.substring(0, s.length() - 1);
    }
    if (s.endsWith(",")) {
      s = s.substring(0, s.length() - 1);
    }
    wl = Double.parseDouble(s);
    return wl;
  }
  
  public static double getKDR(Player p)
  {
    double kdr = 0.0D;
    int de = Main.getInstance().getCommands().getPTode(p.getUniqueId());
    int ki = Main.getInstance().getCommands().getPKills(p.getUniqueId());
    if (de == 0) {
      de = 1;
    }
    kdr = Double.parseDouble(Integer.toString(ki)) / 
      Double.parseDouble(Integer.toString(de));
    DecimalFormat df = new DecimalFormat("0.000");
    String s = df.format(kdr).replace(",", ".");
    if (s.endsWith("0")) {
      s = s.substring(0, s.length() - 1);
    }
    if (s.endsWith("0")) {
      s = s.substring(0, s.length() - 1);
    }
    if (s.endsWith("0")) {
      s = s.substring(0, s.length() - 1);
    }
    if (s.endsWith(",")) {
      s = s.substring(0, s.length() - 1);
    }
    kdr = Double.parseDouble(s);
    return kdr;
  }
}
