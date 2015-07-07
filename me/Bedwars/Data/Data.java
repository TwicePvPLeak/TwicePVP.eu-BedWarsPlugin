package me.Bedwars.Data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import me.Bedwars.GameStatus.GameStatus;
import me.Bedwars.Main;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public class Data
{
  public static String prefix = "§f[§5Bedwars§f]";
  public static String KeineRechte = prefix + " §cDu hast keine Rechte!";
  public static List<Player> blau = new ArrayList();
  public static List<Player> rot = new ArrayList();
  public static List<Player> players = new ArrayList();
  public static List<Player> noteam = new ArrayList();
  public static List<Player> spec = new ArrayList();
  public static List<Player> cooldown = new ArrayList();
  public static List<Player> cooldown1 = new ArrayList();
  public static List<Player> cooldown2 = new ArrayList();
  public static File file = new File("plugins/BedWars", "location.yml");
  public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
  public static boolean respawn_blau = true;
  public static boolean respawn_rot = true;
  public static boolean spawnmob = false;
  public static boolean start = false;
  public static int countdown = 60;
  public static GameStatus status = GameStatus.LOBBY;
  
  public static void setLocation(String path, Location loc)
  {
    cfg.set(path + ".x", Double.valueOf(loc.getX()));
    cfg.set(path + ".y", Double.valueOf(loc.getY()));
    cfg.set(path + ".z", Double.valueOf(loc.getZ()));
    cfg.set(path + ".yaw", Float.valueOf(loc.getYaw()));
    cfg.set(path + ".pitch", Float.valueOf(loc.getPitch()));
    cfg.set(path + ".world", loc.getWorld().getName());
    try
    {
      cfg.save(file);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  
  public static Location getLocation(String path)
  {
    double x = cfg.getDouble(path + ".x");
    double y = cfg.getDouble(path + ".y");
    double z = cfg.getDouble(path + ".z");
    double yaw = cfg.getDouble(path + ".yaw");
    double pitch = cfg.getDouble(path + ".pitch");
    String w = cfg.getString(path + ".world");
    World world = Bukkit.getWorld(w);
    Location loc = new Location(world, x, y, z);
    loc.setPitch((float)pitch);
    loc.setYaw((float)yaw);
    return loc;
  }
  
  public static void teleportSpawns()
  {
    for (Player rot_ : rot) {
      rot_.teleport(getLocation("rotspawn"));
    }
    for (Player blau_ : blau) {
      blau_.teleport(getLocation("blauspawn"));
    }
  }
  
  public static ItemStack createItemStack(Material m, int anzahl, int sh, String name, String lore)
  {
    ItemStack item = new ItemStack(m, anzahl, (short)sh);
    ItemMeta itemm = item.getItemMeta();
    itemm.setDisplayName(name);
    ArrayList<String> list = new ArrayList();
    list.add(lore);
    itemm.setLore(list);
    item.setItemMeta(itemm);
    return item;
  }
  
  public static void spawnBronze(Location loc)
  {
    new BukkitRunnable()
    {
      ItemStack bronze = new ItemStack(Material.CLAY_BRICK, 1);
      
      public void run()
      {
        Data.this.getWorld().dropItem(Data.this, this.bronze);
        Data.this.getWorld().playEffect(Data.this, Effect.HEART, 0, 1);
      }
    }.runTaskTimer(Main.plugin, 0L, 20L);
  }
  
  public static void spawnEisen(Location loc)
  {
    new BukkitRunnable()
    {
      ItemStack eisen = new ItemStack(Material.IRON_INGOT, 1);
      
      public void run()
      {
        Data.this.getWorld().dropItem(Data.this, this.eisen);
        Data.this.getWorld().playEffect(Data.this, Effect.HEART, 2, 2);
      }
    }.runTaskTimer(Main.plugin, 700L, 100L);
  }
  
  public static void spawnGold(Location loc)
  {
    new BukkitRunnable()
    {
      ItemStack gold = new ItemStack(Material.GOLD_INGOT, 1);
      
      public void run()
      {
        Data.this.getWorld().dropItem(Data.this, this.gold);
        Data.this.getWorld().playEffect(Data.this, Effect.HEART, 3, 3);
      }
    }.runTaskTimer(Main.plugin, 1800L, 300L);
  }
  
  public static void sendAllLobby()
  {
    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new BukkitRunnable()
    {
      public void run()
      {
        Bukkit.getServer().shutdown();
      }
    }, 100L);
  }
}
