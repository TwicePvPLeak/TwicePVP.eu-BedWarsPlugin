package me.Bedwars.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import me.Bedwars.Main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.Listener;

public class SQL
  implements Listener
{
  private Main plugin;
  
  public SQL(Main plugin)
  {
    this.plugin = plugin;
    
    MySQL sql = this.plugin.getSql();
    sql.queryUpdate("CREATE TABLE IF NOT EXISTS punkte ( id INT AUTO_INCREMENT PRIMARY KEY , name VARCHAR(40), uuid VARCHAR(40) , points VARCHAR(100))");
    sql.queryUpdate("CREATE TABLE IF NOT EXISTS kills ( id INT AUTO_INCREMENT PRIMARY KEY , name VARCHAR(40) , kills VARCHAR(100))");
    sql.queryUpdate("CREATE TABLE IF NOT EXISTS tode ( id INT AUTO_INCREMENT PRIMARY KEY , name VARCHAR(40) , tode VARCHAR(100))");
    sql.queryUpdate("CREATE TABLE IF NOT EXISTS wins ( id INT AUTO_INCREMENT PRIMARY KEY , name VARCHAR(40) , wins VARCHAR(100))");
    sql.queryUpdate("CREATE TABLE IF NOT EXISTS bette ( id INT AUTO_INCREMENT PRIMARY KEY , name VARCHAR(40) , bette VARCHAR(100))");
    sql.queryUpdate("CREATE TABLE IF NOT EXISTS spiele ( id INT AUTO_INCREMENT PRIMARY KEY , name VARCHAR(40) , spiele VARCHAR(100))");
  }
  
  public int getPPoints(UUID player)
  {
    if (getPoints(player) != null) {
      return Integer.valueOf(getPoints(player)).intValue();
    }
    return 0;
  }
  
  public int getRanking(UUID uuid)
    throws SQLException
  {
    int rank = 0;
    int current = 0;
    MySQL sql = this.plugin.getSql();
    Statement st = sql.getConnection().createStatement();
    
    ResultSet rs = st.executeQuery("SELECT * FROM punkte");
    while (rs.next())
    {
      current = rs.getInt(2);
      if (getPKills(uuid) <= current) {
        rank++;
      }
    }
    return rank;
  }
  
  public String getPoints(UUID player)
  {
    MySQL sql = this.plugin.getSql();
    Connection conn = sql.getConnection();
    ResultSet rs = null;
    PreparedStatement state = null;
    String tokens = null;
    try
    {
      state = conn.prepareStatement("SELECT * FROM punkte WHERE uuid = ?");
      state.setString(1, String.valueOf(player));
      rs = state.executeQuery();
      rs.last();
      if (rs.getRow() != 0)
      {
        rs.first();
        tokens = rs.getString("points");
      }
    }
    catch (SQLException localSQLException) {}finally
    {
      sql.closeRessources(rs, state);
    }
    return tokens;
  }
  
  public void addPoints(UUID player, int points)
  {
    setPoints(player, String.valueOf(getPPoints(player) + points));
  }
  
  public void removePoints(UUID player, int points)
  {
    setPoints(player, String.valueOf(getPPoints(player) - points));
  }
  
  public void setPoints(UUID player, String points)
  {
    MySQL sql = this.plugin.getSql();
    if (getPoints(player) != null)
    {
      sql.queryUpdate("UPDATE punkte SET points='" + points + 
        "' WHERE uuid='" + player + "'");
    }
    else
    {
      String name = Bukkit.getOfflinePlayer(player).getName();
      
      sql.queryUpdate("INSERT INTO punkte(uuid, points, name) VALUES ('" + 
        player + "', '" + points + "', '" + name + "')");
    }
  }
  
  public int getPTode(UUID player)
  {
    if (getTode(player) != null) {
      return Integer.valueOf(getTode(player)).intValue();
    }
    return 0;
  }
  
  public String getTode(UUID player)
  {
    MySQL sql = this.plugin.getSql();
    Connection conn = sql.getConnection();
    ResultSet rs = null;
    PreparedStatement state = null;
    String tokens = null;
    try
    {
      state = conn.prepareStatement("SELECT * FROM tode WHERE name = ?");
      state.setString(1, String.valueOf(player));
      rs = state.executeQuery();
      rs.last();
      if (rs.getRow() != 0)
      {
        rs.first();
        tokens = rs.getString("tode");
      }
    }
    catch (SQLException localSQLException) {}finally
    {
      sql.closeRessources(rs, state);
    }
    return tokens;
  }
  
  public void addTod(UUID player, int points)
  {
    setTode(player, String.valueOf(getPTode(player) + points));
  }
  
  public void setTode(UUID player, String points)
  {
    MySQL sql = this.plugin.getSql();
    if (getTode(player) != null) {
      sql.queryUpdate("UPDATE tode SET tode='" + points + 
        "' WHERE name='" + player + "'");
    } else {
      sql.queryUpdate("INSERT INTO tode(name, tode) VALUES ('" + player + 
        "', '" + points + "')");
    }
  }
  
  public int getPKills(UUID player)
  {
    if (getKills(player) != null) {
      return Integer.valueOf(getKills(player)).intValue();
    }
    return 0;
  }
  
  public String getKills(UUID player)
  {
    MySQL sql = this.plugin.getSql();
    Connection conn = sql.getConnection();
    ResultSet rs = null;
    PreparedStatement state = null;
    String tokens = null;
    try
    {
      state = conn.prepareStatement("SELECT * FROM kills WHERE name = ?");
      state.setString(1, String.valueOf(player));
      rs = state.executeQuery();
      rs.last();
      if (rs.getRow() != 0)
      {
        rs.first();
        tokens = rs.getString("kills");
      }
    }
    catch (SQLException localSQLException) {}finally
    {
      sql.closeRessources(rs, state);
    }
    return tokens;
  }
  
  public void addKill(UUID player, int points)
  {
    setKills(player, String.valueOf(getPKills(player) + points));
  }
  
  public void setKills(UUID player, String points)
  {
    MySQL sql = this.plugin.getSql();
    if (getKills(player) != null) {
      sql.queryUpdate("UPDATE kills SET kills='" + points + 
        "' WHERE name='" + player + "'");
    } else {
      sql.queryUpdate("INSERT INTO kills(name, kills) VALUES ('" + player + 
        "', '" + points + "')");
    }
  }
  
  public int getPWins(UUID player)
  {
    if (getWins(player) != null) {
      return Integer.valueOf(getWins(player)).intValue();
    }
    return 0;
  }
  
  public String getWins(UUID player)
  {
    MySQL sql = this.plugin.getSql();
    Connection conn = sql.getConnection();
    ResultSet rs = null;
    PreparedStatement state = null;
    String tokens = null;
    try
    {
      state = conn.prepareStatement("SELECT * FROM wins WHERE name = ?");
      state.setString(1, String.valueOf(player));
      rs = state.executeQuery();
      rs.last();
      if (rs.getRow() != 0)
      {
        rs.first();
        tokens = rs.getString("wins");
      }
    }
    catch (SQLException localSQLException) {}finally
    {
      sql.closeRessources(rs, state);
    }
    return tokens;
  }
  
  public void addWin(UUID player, int points)
  {
    setWins(player, String.valueOf(getPWins(player) + points));
  }
  
  public void setWins(UUID player, String points)
  {
    MySQL sql = this.plugin.getSql();
    if (getWins(player) != null) {
      sql.queryUpdate("UPDATE wins SET wins='" + points + 
        "' WHERE name='" + player + "'");
    } else {
      sql.queryUpdate("INSERT INTO wins(name, wins) VALUES ('" + player + 
        "', '" + points + "')");
    }
  }
  
  public int getpbette(UUID player)
  {
    if (getbette(player) != null) {
      return Integer.valueOf(getbette(player)).intValue();
    }
    return 0;
  }
  
  public String getbette(UUID player)
  {
    MySQL sql = this.plugin.getSql();
    Connection conn = sql.getConnection();
    ResultSet rs = null;
    PreparedStatement state = null;
    String tokens = null;
    try
    {
      state = conn.prepareStatement("SELECT * FROM bette WHERE name = ?");
      state.setString(1, String.valueOf(player));
      rs = state.executeQuery();
      rs.last();
      if (rs.getRow() != 0)
      {
        rs.first();
        tokens = rs.getString("bette");
      }
    }
    catch (SQLException localSQLException) {}finally
    {
      sql.closeRessources(rs, state);
    }
    return tokens;
  }
  
  public void addbette(UUID player, int points)
  {
    setbette(player, String.valueOf(getpbette(player) + points));
  }
  
  public void setbette(UUID player, String points)
  {
    MySQL sql = this.plugin.getSql();
    if (getbette(player) != null) {
      sql.queryUpdate("UPDATE bette SET bette='" + points + 
        "' WHERE name='" + player + "'");
    } else {
      sql.queryUpdate("INSERT INTO bette(name, bette) VALUES ('" + player + 
        "', '" + points + "')");
    }
  }
  
  public int getPSpiele(UUID player)
  {
    if (getSpiele(player) != null) {
      return Integer.valueOf(getSpiele(player)).intValue();
    }
    return 0;
  }
  
  public String getSpiele(UUID player)
  {
    MySQL sql = this.plugin.getSql();
    Connection conn = sql.getConnection();
    ResultSet rs = null;
    PreparedStatement state = null;
    String tokens = null;
    try
    {
      state = 
        conn.prepareStatement("SELECT * FROM spiele WHERE name = ?");
      state.setString(1, String.valueOf(player));
      rs = state.executeQuery();
      rs.last();
      if (rs.getRow() != 0)
      {
        rs.first();
        tokens = rs.getString("spiele");
      }
    }
    catch (SQLException localSQLException) {}finally
    {
      sql.closeRessources(rs, state);
    }
    return tokens;
  }
  
  public void addSpiel(UUID player, int points)
  {
    setSpiel(player, String.valueOf(getPSpiele(player) + points));
  }
  
  public void setSpiel(UUID player, String points)
  {
    MySQL sql = this.plugin.getSql();
    if (getSpiele(player) != null) {
      sql.queryUpdate("UPDATE spiele SET spiele='" + points + 
        "' WHERE name='" + player + "'");
    } else {
      sql.queryUpdate("INSERT INTO spiele(name, spiele) VALUES ('" + 
        player + "', '" + points + "')");
    }
  }
}
