package me.Bedwars;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import me.Bedwars.Commands.Command_BedWars;
import me.Bedwars.Commands.Command_Random;
import me.Bedwars.Commands.Command_Ranking;
import me.Bedwars.Commands.Command_Restart;
import me.Bedwars.Commands.Command_Start;
import me.Bedwars.Commands.Command_Stats;
import me.Bedwars.Data.Data;
import me.Bedwars.GameStatus.GameStatus;
import me.Bedwars.Listener.AchievListener;
import me.Bedwars.Listener.Baumaterialien;
import me.Bedwars.Listener.BlockListener;
import me.Bedwars.Listener.Bögen;
import me.Bedwars.Listener.ChatListener;
import me.Bedwars.Listener.DamageListener;
import me.Bedwars.Listener.DeathListener;
import me.Bedwars.Listener.Essen;
import me.Bedwars.Listener.FoodListener;
import me.Bedwars.Listener.InteractListener;
import me.Bedwars.Listener.JoinListener;
import me.Bedwars.Listener.MobListener;
import me.Bedwars.Listener.QuitListener;
import me.Bedwars.Listener.RespawnListener;
import me.Bedwars.Listener.Rüstung;
import me.Bedwars.Listener.Schwerter;
import me.Bedwars.Listener.Shop;
import me.Bedwars.Listener.Sonstiges;
import me.Bedwars.Listener.SpectatorListener;
import me.Bedwars.Listener.Spezial;
import me.Bedwars.Listener.Spitzhacken;
import me.Bedwars.Listener.Tränke;
import me.Bedwars.MySQL.MySQL;
import me.Bedwars.MySQL.SQL;
import me.Bedwars.WorldReset.WorldReset;
import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EntityPlayer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R1.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Main
  extends JavaPlugin
{
  public static Main plugin;
  public static MySQL sql;
  private SQL sqluti;
  
  public static void setScoreboard()
  {
    for (Player p : )
    {
      ScoreboardManager manager = Bukkit.getScoreboardManager();
      Scoreboard board = manager.getMainScoreboard();
      
      Objective objective = board.getObjective("test");
      if (objective == null) {
        objective = board.registerNewObjective("test", "team");
      }
      objective.setDisplaySlot(DisplaySlot.SIDEBAR);
      objective.setDisplayName("§fBedwars - Teams");
      
      board.resetScores("§a✔§9 BLAU");
      board.resetScores("§c✘§9 BLAU");
      board.resetScores("§a✔§c ROT");
      board.resetScores("§c✘§c ROT");
      if (Data.respawn_blau)
      {
        Score score = objective.getScore("§a✔§9 BLAU");
        int x = Data.blau.size();
        score.setScore(x);
      }
      else if (!Data.respawn_blau)
      {
        Score score = objective.getScore("§c✘§9 BLAU");
        int x = Data.blau.size();
        score.setScore(x);
      }
      if (Data.respawn_rot)
      {
        Score score = objective.getScore("§a✔§c ROT");
        int x = Data.rot.size();
        score.setScore(x);
      }
      else if (!Data.respawn_rot)
      {
        Score score = objective.getScore("§c✘§c ROT");
        int x = Data.rot.size();
        score.setScore(x);
      }
      p.setScoreboard(board);
    }
  }
  
  public static void timeLobby()
  {
    int[] IDS = new int[1];
    IDS[0 = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new BukkitRunnable()
    {
      public void run()
      {
        if (Data.countdown != 0)
        {
          if (Data.countdown != -1)
          {
            if (Data.countdown == 1)
            {
              Bukkit.broadcastMessage(Data.prefix + " §5Die Spielphase beginnt in §d" + Data.countdown + " §5Sekunde!");
              for (Player all : Bukkit.getOnlinePlayers()) {
                all.playSound(all.getLocation(), Sound.ENDERMAN_HIT, 1.0F, 1.0F);
              }
            }
            if ((Data.countdown == 60) || (Data.countdown == 30) || (Data.countdown == 10) || (Data.countdown == 5) || (Data.countdown == 4) || (Data.countdown == 3) || (Data.countdown == 3) || (Data.countdown == 2))
            {
              Bukkit.broadcastMessage(Data.prefix + " §5Die Spielphase beginnt in §d" + Data.countdown + " §5Sekunden!");
              for (Player all : Bukkit.getOnlinePlayers()) {
                all.playSound(all.getLocation(), Sound.ENDERMAN_HIT, 1.0F, 1.0F);
              }
            }
            if (Data.countdown <= 60)
            {
              Bukkit.getServer().setWhitelist(false);
              for (Player online : Bukkit.getOnlinePlayers()) {
                online.setLevel(Data.countdown);
              }
            }
            Data.countdown -= 1;
          }
        }
        else if (Bukkit.getOnlinePlayers().size() >= 4)
        {
          for (ArmorStand r : Main.ranking) {
            if (!r.isDead()) {
              r.remove();
            }
          }
          Data.countdown = 0;
          for (Player all : Bukkit.getOnlinePlayers()) {
            all.performCommand("xyzhdu");
          }
          new BukkitRunnable()
          {
            public void run() {}
          }.runTaskLater(Main.plugin, 60L);
          
          final int[] IDSS = new int[1];
          IDSS[0 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, 
            new BukkitRunnable()
            {
              public void run()
              {
                Data.status = GameStatus.INGAME;
                


                Data.teleportSpawns();
                if (Bukkit.getOnlinePlayers().size() == 0) {
                  Bukkit.shutdown();
                }
                String players = "";
                for (Player alle : Data.blau) {
                  players = players + alle.getName() + " ";
                }
                String playerss = "";
                for (Player alles : Data.rot) {
                  playerss = playerss + alles.getName() + " ";
                }
                Bukkit.broadcastMessage("■■■■■■■■■■■■■■■■■■■■■■■");
                Bukkit.broadcastMessage("§9Team Blau: " + players);
                Bukkit.broadcastMessage("§cTeam Rot: " + playerss);
                Bukkit.broadcastMessage("■■■■■■■■■■■■■■■■■■■■■■■");
                for (Player blue : Data.blau)
                {
                  IChatBaseComponent headertext = ChatSerializer.a("{\"text\":\"§6Du bist im Team\"}");
                  PacketPlayOutTitle header = new PacketPlayOutTitle(EnumTitleAction.TITLE, headertext);
                  ((CraftPlayer)blue).getHandle().playerConnection.sendPacket(header);
                  
                  IChatBaseComponent footertext = ChatSerializer.a("{\"text\":\"§9Blau\"}");
                  PacketPlayOutTitle footer = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, footertext);
                  ((CraftPlayer)blue).getHandle().playerConnection.sendPacket(footer);
                  
                  PacketPlayOutTitle times = new PacketPlayOutTitle(EnumTitleAction.TIMES, null, 20, 60, 20);
                  ((CraftPlayer)blue).getHandle().playerConnection.sendPacket(times);
                }
                PacketPlayOutTitle header;
                for (Player blue : Data.rot)
                {
                  IChatBaseComponent headertext = ChatSerializer.a("{\"text\":\"§6Du bist im Team\"}");
                  header = new PacketPlayOutTitle(EnumTitleAction.TITLE, headertext);
                  ((CraftPlayer)blue).getHandle().playerConnection.sendPacket(header);
                  
                  IChatBaseComponent footertext = ChatSerializer.a("{\"text\":\"§cRot\"}");
                  PacketPlayOutTitle footer = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, footertext);
                  ((CraftPlayer)blue).getHandle().playerConnection.sendPacket(footer);
                  
                  PacketPlayOutTitle times = new PacketPlayOutTitle(EnumTitleAction.TIMES, null, 20, 60, 20);
                  ((CraftPlayer)blue).getHandle().playerConnection.sendPacket(times);
                }
                for (??? = Bukkit.getOnlinePlayers().iterator(); ???.hasNext(); header.hasNext())
                {
                  Player all = (Player)???.next();
                  all.getInventory().clear();
                  all.getInventory().setArmorContents(null);
                  all.updateInventory();
                  all.setLevel(0);
                  all.playSound(all.getLocation(), Sound.ANVIL_BREAK, 1.0F, 1.0F);
                  Data.players.add(all);
                  Main.plugin.getCommands().addSpiel(all.getUniqueId(), 1);
                  
                  AchievListener.griefer.put(all.getUniqueId(), Integer.valueOf(0));
                  AchievListener.killstreak.put(all.getUniqueId(), Integer.valueOf(0));
                  AchievListener.todstreak.put(all.getUniqueId(), Integer.valueOf(0));
                  AchievListener.schwarzarbeiter.put(all.getUniqueId(), Integer.valueOf(0));
                  if ((!all.hasPermission("achievement.gelegenheitsspieler")) && 
                    (Main.plugin.getCommands().getPSpiele(all.getUniqueId()) == 15))
                  {
                    PermissionsEx.getUser(all).addPermission("achievement.gelegenheitsspieler");
                    
                    all.sendMessage("§8§k**********************************************");
                    all.sendMessage("§8");
                    all.sendMessage("§8Errungschaft: §cGelegenheitsspieler §a✔");
                    all.sendMessage("§8");
                    all.sendMessage("§8§k**********************************************");
                  }
                  if ((!all.hasPermission("achievement.zocker")) && 
                    (Main.plugin.getCommands().getPSpiele(all.getUniqueId()) == 50))
                  {
                    PermissionsEx.getUser(all).addPermission("achievement.zocker");
                    
                    all.sendMessage("§8§k**********************************************");
                    all.sendMessage("§8");
                    all.sendMessage("§8Errungschaft: §cZocker §a✔");
                    all.sendMessage("§8");
                    all.sendMessage("§8§k**********************************************");
                  }
                  if ((!all.hasPermission("achievement.erstesspiel")) && 
                    (Main.plugin.getCommands().getPSpiele(all.getUniqueId()) == 15))
                  {
                    PermissionsEx.getUser(all).addPermission("achievement.erstesspiel");
                    
                    all.sendMessage("§8§k**********************************************");
                    all.sendMessage("§8");
                    all.sendMessage("§8Errungschaft: §cErstes Spiel §a✔");
                    all.sendMessage("§8");
                    all.sendMessage("§8§k**********************************************");
                  }
                  Data.status = GameStatus.INGAME;
                  for (Player rot : Data.rot)
                  {
                    String rotname = "§c" + rot.getName();
                    if (rotname.length() > 16)
                    {
                      int i = rotname.length() - 16;
                      rotname = rotname.substring(0, rotname.length() - i);
                    }
                    rot.setPlayerListName(rotname);
                  }
                  header = Data.blau.iterator(); continue;Player blau = (Player)header.next();
                  String blauname = "§9" + blau.getName();
                  if (blauname.length() > 16)
                  {
                    int i = blauname.length() - 16;
                    blauname = blauname.substring(0, blauname.length() - i);
                  }
                  blau.setPlayerListName(blauname);
                }
                Data.spawnEisen(Data.getLocation("eisenspawnrot"));
                Data.spawnEisen(Data.getLocation("eisenspawnblau"));
                
                Data.spawnBronze(Data.getLocation("bronzespawnrot"));
                Data.spawnBronze(Data.getLocation("bronzespawnblau"));
                
                Data.spawnGold(Data.getLocation("goldspawn"));
                
                Data.countdown = -1;
                Bukkit.getScheduler().cancelTask(this.val$IDS[0]);
                Bukkit.getScheduler().cancelTask(IDSS[0]);
                

                new BukkitRunnable()
                {
                  public void run()
                  {
                    for (Player all : ) {
                      if (all.hasPermission("bw.herzen2")) {
                        all.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 200000, 1));
                      } else if (all.hasPermission("bw.herzen2")) {
                        all.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 200000, 0));
                      }
                    }
                  }
                }.runTaskLater(Main.plugin, 6L);
                

                new BukkitRunnable()
                {
                  public void run()
                  {
                    for (Player all : ) {
                      if (all.hasPermission("bw.speed2")) {
                        all.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2400, 0));
                      } else if (all.hasPermission("bw.speed1")) {
                        all.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 0));
                      }
                    }
                  }
                }.runTaskLater(Main.plugin, 15L);
                

                new BukkitRunnable()
                {
                  public void run()
                  {
                    for (Player all : ) {
                      if (all.hasPermission("bw.level1")) {
                        all.setLevel(5);
                      }
                    }
                  }
                }.runTaskLater(Main.plugin, 3L);
                
                new BukkitRunnable()
                {
                  public void run()
                  {
                    for (Player all : ) {
                      if (all.hasPermission("bw.level2")) {
                        all.setLevel(15);
                      }
                    }
                  }
                }.runTaskLater(Main.plugin, 6L);
                for (Player all : Bukkit.getOnlinePlayers()) {
                  if (all.hasPermission("bw.level3")) {
                    all.setLevel(25);
                  }
                }
                new BukkitRunnable()
                {
                  public void run()
                  {
                    for (Player all : ) {
                      if (all.hasPermission("bw.level3")) {
                        all.setLevel(25);
                      }
                    }
                  }
                }.runTaskLater(Main.plugin, 9L);
                for (Player all : Bukkit.getOnlinePlayers()) {
                  if (all.hasPermission("bw.schuhe1")) {
                    all.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS));
                  }
                }
                new BukkitRunnable()
                {
                  public void run()
                  {
                    for (Player all : ) {
                      if (all.hasPermission("bw.schuhe2")) {
                        all.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
                      }
                    }
                  }
                }.runTaskLater(Main.plugin, 3L);
                new BukkitRunnable()
                {
                  public void run()
                  {
                    for (Player all : ) {
                      if (all.hasPermission("bw.schuhe3")) {
                        all.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                      }
                    }
                  }
                }.runTaskLater(Main.plugin, 6L);
              }
            }, 5L);
        }
        else
        {
          Data.countdown = 60;
          Bukkit.broadcastMessage(Data.prefix + "§c Es sind leider zu wenige Spieler online!");
        }
      }
    }, 0L, 20L);
  }
  
  public static String prefix = "§f[§5Bedwars§f] ";
  public static Team teamr;
  public static Team teamb;
  public static List<ArmorStand> ranking = new ArrayList();
  
  public void onEnable()
  {
    Data.status = GameStatus.LOBBY;
    
    getConfig().addDefault("maps.game", "MAPNAME");
    getConfig().addDefault("maps.lobby", "bwlobby");
    
    getConfig().options().copyDefaults(true);
    saveConfig();
    
    Bukkit.createWorld(new WorldCreator(getConfig().getString("maps.game")));
    
    plugin = this;
    timeLobby();
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(new DamageListener(), this);
    pm.registerEvents(new JoinListener(), this);
    pm.registerEvents(new QuitListener(), this);
    pm.registerEvents(new BlockListener(), this);
    pm.registerEvents(new DeathListener(), this);
    pm.registerEvents(new FoodListener(), this);
    pm.registerEvents(new InteractListener(), this);
    pm.registerEvents(new JoinListener(), this);
    pm.registerEvents(new MobListener(), this);
    pm.registerEvents(new QuitListener(), this);
    pm.registerEvents(new RespawnListener(), this);
    pm.registerEvents(new ChatListener(), this);
    pm.registerEvents(new Baumaterialien(), this);
    pm.registerEvents(new Bögen(), this);
    pm.registerEvents(new Essen(), this);
    pm.registerEvents(new Rüstung(), this);
    pm.registerEvents(new Schwerter(), this);
    pm.registerEvents(new Spezial(), this);
    pm.registerEvents(new Shop(), this);
    pm.registerEvents(new Sonstiges(), this);
    pm.registerEvents(new Spitzhacken(), this);
    pm.registerEvents(new Tränke(), this);
    pm.registerEvents(new AchievListener(), this);
    pm.registerEvents(new SpectatorListener(), this);
    
    getCommand("setlocation").setExecutor(new Command_BedWars());
    getCommand("stats").setExecutor(new Command_Stats());
    getCommand("xyzhdu").setExecutor(new Command_Random());
    getCommand("ranking").setExecutor(new Command_Ranking());
    getCommand("start").setExecutor(new Command_Start());
    getCommand("countdown").setExecutor(new Command_Restart());
    
    Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    for (World worlds : Bukkit.getWorlds()) {
      worlds.setAutoSave(false);
    }
    try
    {
      sql = new MySQL();
      this.sqluti = new SQL(this);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    Scoreboard b = Bukkit.getScoreboardManager().getMainScoreboard();
    
    teamr = b.getTeam("red");
    if (teamr == null) {
      teamr = b.registerNewTeam("red");
    }
    teamr.setPrefix("§c");
    teamr.setAllowFriendlyFire(false);
    teamr.setCanSeeFriendlyInvisibles(true);
    
    teamb = b.getTeam("blue");
    if (teamb == null) {
      teamb = b.registerNewTeam("blue");
    }
    teamb.setPrefix("§9");
    teamb.setAllowFriendlyFire(false);
    teamb.setCanSeeFriendlyInvisibles(true);
    try
    {
      PreparedStatement stmt = sql.getConnection().prepareStatement("SELECT name, points FROM punkte ORDER BY cast(points as unsigned) DESC LIMIT 0,10");
      ResultSet rs = stmt.executeQuery();
      
      int i = 1;
      
      Data.spawnmob = true;
      while ((rs.next()) && (i <= 10) && (Data.cfg.contains("ranking." + i + ".world")))
      {
        Data.getLocation("ranking." + i).getChunk().load();
        
        ArmorStand r = (ArmorStand)Data.getLocation("ranking." + i).getWorld().spawnEntity(Data.getLocation("ranking." + i), EntityType.ARMOR_STAND);
        
        r.setCustomNameVisible(true);
        r.setCustomName("§5§l#" + i + " §7" + rs.getString("name"));
        
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta skullmeta = (SkullMeta)head.getItemMeta();
        skullmeta.setOwner(rs.getString("name"));
        head.setItemMeta(skullmeta);
        
        r.setArms(true);
        
        r.setHelmet(head);
        
        r.setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
        
        r.setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
        
        r.setBoots(new ItemStack(Material.GOLD_BOOTS));
        
        ranking.add(r);
        i++;
      }
      Data.spawnmob = false;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
  
  public void onDisable()
  {
    for (ArmorStand r : ranking) {
      if (!r.isDead()) {
        r.remove();
      }
    }
    for (World w : Bukkit.getWorlds()) {
      Bukkit.unloadWorld(w, false);
    }
    WorldReset.startDeleting("./" + getConfig().getString("maps.game"));
    WorldReset.startDeleting("./world");
    try
    {
      WorldReset.copyFolder(new File("/home/maps/" + getConfig().getString("maps.game")), new File("./" + getConfig().getString("maps.game")));
      WorldReset.copyFolder(new File("/home/maps/" + getConfig().getString("maps.lobby")), new File("./world"));
    }
    catch (IOException e)
    {
      System.out.println("Konnte Welt nicht resetten!");
      e.printStackTrace();
    }
  }
  
  public MySQL getSql()
  {
    return sql;
  }
  
  public SQL getCommands()
  {
    return this.sqluti;
  }
  
  public static Main getInstance()
  {
    return plugin;
  }
}
