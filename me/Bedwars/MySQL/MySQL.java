package me.Bedwars.MySQL;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.configuration.file.YamlConfiguration;

public class MySQL
{
  private String host;
  private int port;
  private String user;
  private String password;
  private String database;
  private Connection conn;
  
  public MySQL()
    throws Exception
  {
    File file = new File("plugins/BedWars", "database.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    
    String db = "database.";
    
    cfg.addDefault(db + "host", "localhost");
    cfg.addDefault(db + "port", Integer.valueOf(3306));
    cfg.addDefault(db + "user", "user");
    cfg.addDefault(db + "password", "password");
    cfg.addDefault(db + "database", "database");
    
    cfg.options().copyDefaults(true);
    try
    {
      cfg.save(file);
    }
    catch (IOException localIOException) {}
    this.host = cfg.getString(db + "host");
    this.port = cfg.getInt(db + "port");
    this.user = cfg.getString(db + "user");
    this.password = cfg.getString(db + "password");
    this.database = cfg.getString(db + "database");
    
    openConnection();
  }
  
  public Connection openConnection()
    throws Exception
  {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://" + 
      this.host + ":" + this.port + "/" + this.database + "?user=" + 
      this.user + "&password=" + this.password + 
      "&autoReconnect=true");
    this.conn = conn;
    return this.conn;
  }
  
  public Connection getConnection()
  {
    return this.conn;
  }
  
  public boolean hasConnection()
  {
    try
    {
      return (this.conn != null) || (this.conn.isValid(1));
    }
    catch (SQLException e) {}
    return false;
  }
  
  public void queryUpdate(String query)
  {
    Connection conn = this.conn;
    PreparedStatement st = null;
    try
    {
      st = conn.prepareStatement(query);
      st.executeUpdate();
    }
    catch (SQLException e)
    {
      System.err.print("Failed to send Update '" + query + "'.");
    }
    finally
    {
      closeRessources(null, st);
    }
  }
  
  public void closeRessources(ResultSet rs, PreparedStatement st)
  {
    if (rs != null) {
      try
      {
        rs.close();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
    if (st != null) {
      try
      {
        st.close();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public void closeConnection()
  {
    try
    {
      this.conn.close();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    finally
    {
      this.conn = null;
    }
  }
}
