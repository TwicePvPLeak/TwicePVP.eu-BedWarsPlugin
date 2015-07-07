package me.Bedwars.Listener;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import me.Bedwars.Data.Data;
import me.Bedwars.GameStatus.GameStatus;
import me.Bedwars.Main;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EntityPlayer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R1.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.Vector;

public class JoinListener
  implements Listener
{
  public void clearPotionEffects(Player p)
  {
    if (p.hasPotionEffect(PotionEffectType.ABSORPTION)) {
      p.removePotionEffect(PotionEffectType.ABSORPTION);
    }
    if (p.hasPotionEffect(PotionEffectType.BLINDNESS)) {
      p.removePotionEffect(PotionEffectType.BLINDNESS);
    }
    if (p.hasPotionEffect(PotionEffectType.CONFUSION)) {
      p.removePotionEffect(PotionEffectType.CONFUSION);
    }
    if (p.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
      p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
    }
    if (p.hasPotionEffect(PotionEffectType.FAST_DIGGING)) {
      p.removePotionEffect(PotionEffectType.FAST_DIGGING);
    }
    if (p.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
      p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
    }
    if (p.hasPotionEffect(PotionEffectType.HARM)) {
      p.removePotionEffect(PotionEffectType.HARM);
    }
    if (p.hasPotionEffect(PotionEffectType.HEAL)) {
      p.removePotionEffect(PotionEffectType.HEAL);
    }
    if (p.hasPotionEffect(PotionEffectType.HEALTH_BOOST)) {
      p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
    }
    if (p.hasPotionEffect(PotionEffectType.HUNGER)) {
      p.removePotionEffect(PotionEffectType.HUNGER);
    }
    if (p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
      p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
    }
    if (p.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
      p.removePotionEffect(PotionEffectType.INVISIBILITY);
    }
    if (p.hasPotionEffect(PotionEffectType.JUMP)) {
      p.removePotionEffect(PotionEffectType.JUMP);
    }
    if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
      p.removePotionEffect(PotionEffectType.NIGHT_VISION);
    }
    if (p.hasPotionEffect(PotionEffectType.POISON)) {
      p.removePotionEffect(PotionEffectType.POISON);
    }
    if (p.hasPotionEffect(PotionEffectType.REGENERATION)) {
      p.removePotionEffect(PotionEffectType.REGENERATION);
    }
    if (p.hasPotionEffect(PotionEffectType.SLOW)) {
      p.removePotionEffect(PotionEffectType.SLOW);
    }
    if (p.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
      p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
    }
    if (p.hasPotionEffect(PotionEffectType.SPEED)) {
      p.removePotionEffect(PotionEffectType.SPEED);
    }
    if (p.hasPotionEffect(PotionEffectType.WATER_BREATHING)) {
      p.removePotionEffect(PotionEffectType.WATER_BREATHING);
    }
    if (p.hasPotionEffect(PotionEffectType.WEAKNESS)) {
      p.removePotionEffect(PotionEffectType.WEAKNESS);
    }
    if (p.hasPotionEffect(PotionEffectType.WITHER)) {
      p.removePotionEffect(PotionEffectType.WITHER);
    }
  }
  
  public static int getRandom(int lower, int upper)
  {
    Random random = new Random();
    return random.nextInt(upper - lower + 1) + lower;
  }
  
  public void sendTablist(Player p, String header, String footer)
  {
    if (header == null) {
      header = "";
    }
    if (footer == null) {
      footer = "";
    }
    header = ChatColor.translateAlternateColorCodes('&', header);
    footer = ChatColor.translateAlternateColorCodes('&', footer);
    
    header = header.replaceAll("%WELT%", p.getWorld().getName());
    footer = footer.replaceAll("%WORLD%", Main.plugin.getConfig().getString("maps.game"));
    
    PlayerConnection con = ((CraftPlayer)p).getHandle().playerConnection;
    
    IChatBaseComponent tabheader = ChatSerializer.a("{\"text\": \"" + header + "\"}");
    
    IChatBaseComponent tabfooter = ChatSerializer.a("{\"text\": \"" + footer + "\"}");
    
    PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter(tabheader);
    try
    {
      Field f = packet.getClass().getDeclaredField("b");
      f.setAccessible(true);
      f.set(packet, tabfooter);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      con.sendPacket(packet);
    }
  }
  
  @EventHandler
  public void onlobby(PlayerInteractEvent e)
  {
    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || 
      (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (e.getPlayer().getItemInHand().getType() == Material.MAGMA_CREAM)) {
      e.getPlayer().kickPlayer("closed");
    }
  }
  
  @EventHandler
  public void onShop(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && (
      (e.getPlayer().getItemInHand().getType() == Material.SKULL_ITEM) || (e.getPlayer().getItemInHand().getType() == Material.SKULL))) {
      if ((Data.players.contains(p)) && (Data.status == GameStatus.INGAME))
      {
        if (!Data.cooldown1.contains(p))
        {
          Data.cooldown1.add(p);
          new BukkitRunnable()
          {
            public void run()
            {
              Data.cooldown1.remove(p);
            }
          }.runTaskLater(Main.plugin, 5L);
          if (p.getItemInHand().getAmount() == 1)
          {
            p.getInventory().remove(Material.SKULL);
            p.getInventory().remove(Material.SKULL_ITEM);
          }
          p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
          
          Data.spawnmob = true;
          

          final ArmorStand pl = (ArmorStand)p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
          

          ItemStack xd = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
          SkullMeta meta = (SkullMeta)xd.getItemMeta();
          meta.setOwner("Tom_tomi14");
          xd.setItemMeta(meta);
          pl.setHelmet(xd);
          

          pl.setBoots(new ItemStack(Material.LEATHER_BOOTS));
          pl.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
          pl.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
          

          pl.setArms(true);
          

          pl.setVisible(true);
          

          Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new BukkitRunnable()
          {
            int i = 15;
            
            public void run()
            {
              if (this.i != 0)
              {
                pl.setCustomName("§6Drogendealer §c" + this.i);
                this.i -= 1;
              }
              else
              {
                pl.remove();
              }
            }
          }, 20L, 20L);
          

          pl.setCustomNameVisible(true);
          


          Data.spawnmob = false;
        }
      }
      else {
        p.sendMessage("§cNicht jetzt ausführbar!");
      }
    }
  }
  
  @EventHandler
  public void onBaseTeleport(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (e.getPlayer().getItemInHand().getType() == Material.SULPHUR)) {
      if ((Data.players.contains(p)) && (Data.status == GameStatus.INGAME))
      {
        if (!Data.cooldown1.contains(p))
        {
          Data.cooldown1.add(p);
          new BukkitRunnable()
          {
            public void run()
            {
              Data.cooldown1.remove(p);
            }
          }.runTaskLater(Main.plugin, 5L);
          if (p.getItemInHand().getAmount() == 1) {
            p.getInventory().remove(Material.SULPHUR);
          }
          p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
          

          new BukkitRunnable()
          {
            public void run()
            {
              p.sendMessage(Data.prefix + "§4 Teleport in §c2");
            }
          }.runTaskLater(Main.plugin, 20L);
          
          new BukkitRunnable()
          {
            public void run()
            {
              p.sendMessage(Data.prefix + "§4 Teleport in §c1");
            }
          }.runTaskLater(Main.plugin, 40L);
          
          new BukkitRunnable()
          {
            public void run()
            {
              if (Data.rot.contains(p))
              {
                p.teleport(Data.getLocation("rotspawn"));
                p.sendMessage(Data.prefix + "§a Teleportiert!");
              }
              else if (Data.blau.contains(p))
              {
                p.teleport(Data.getLocation("blauspawn"));
                p.sendMessage(Data.prefix + "§a Teleportiert!");
              }
            }
          }.runTaskLater(Main.plugin, 60L);
          


          p.sendMessage(Data.prefix + "§c Base-Teleporter eingesetzt!");
          p.sendMessage(Data.prefix + "§4 Teleport in §c3");
        }
      }
      else {
        p.sendMessage("§cNicht jetzt ausführbar!");
      }
    }
  }
  
  @EventHandler
  public void onFallschirm(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (e.getPlayer().getItemInHand().getType() == Material.FEATHER)) {
      if ((Data.players.contains(p)) && (Data.status == GameStatus.INGAME))
      {
        if (!Data.cooldown1.contains(p))
        {
          Data.cooldown1.add(p);
          new BukkitRunnable()
          {
            public void run()
            {
              Data.cooldown1.remove(p);
            }
          }.runTaskLater(Main.plugin, 5L);
          if (p.getItemInHand().getAmount() == 1) {
            p.getInventory().remove(Material.FEATHER);
          }
          p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
          

          Data.spawnmob = true;
          


          final Chicken s = (Chicken)e.getPlayer().getWorld().spawn(p.getLocation(), Chicken.class);
          
          final int[] IDS = new int[1];
          IDS[0 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new BukkitRunnable()
          {
            public void run()
            {
              if (s.isOnGround())
              {
                s.remove();
                Bukkit.getScheduler().cancelTask(IDS[0]);
              }
              if (!(s.getPassenger() instanceof Player))
              {
                s.remove();
                Bukkit.getScheduler().cancelTask(IDS[0]);
              }
              if (s.getPassenger().isDead())
              {
                s.remove();
                Bukkit.getScheduler().cancelTask(IDS[0]);
              }
            }
          }, 1L, 1L);
          
          s.setPassenger(p);
          s.setBaby();
          
          p.sendMessage(Data.prefix + "§c Fallschirm eingesetzt!");
          
          Data.spawnmob = false;
        }
      }
      else {
        p.sendMessage("§c Nicht jetzt ausführbar!");
      }
    }
  }
  
  @EventHandler
  public void onRettung(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (e.getPlayer().getItemInHand().getType() == Material.BLAZE_ROD)) {
      if ((Data.players.contains(p)) && (Data.status == GameStatus.INGAME))
      {
        if (!Data.cooldown1.contains(p))
        {
          Data.cooldown1.add(p);
          new BukkitRunnable()
          {
            public void run()
            {
              Data.cooldown1.remove(p);
            }
          }.runTaskLater(Main.plugin, 5L);
          Location Blockunterspieler0 = e.getPlayer().getLocation().add(new Vector(0, -1, 0));
          Location Blockunterspieler1 = e.getPlayer().getLocation().add(new Vector(1, -1, 0));
          Location Blockunterspieler2 = e.getPlayer().getLocation().add(new Vector(0, -1, 1));
          Location Blockunterspieler3 = e.getPlayer().getLocation().add(new Vector(1, -1, 1));
          Location Blockunterspieler4 = e.getPlayer().getLocation().add(new Vector(-1, -1, 0));
          Location Blockunterspieler5 = e.getPlayer().getLocation().add(new Vector(-1, -1, -1));
          Location Blockunterspieler6 = e.getPlayer().getLocation().add(new Vector(0, -1, -1));
          
          Location Blockunterspieler01 = e.getPlayer().getLocation().add(new Vector(0, -2, 0));
          Location Blockunterspieler11 = e.getPlayer().getLocation().add(new Vector(1, -2, 0));
          Location Blockunterspieler21 = e.getPlayer().getLocation().add(new Vector(0, -2, 1));
          Location Blockunterspieler31 = e.getPlayer().getLocation().add(new Vector(1, -2, 1));
          Location Blockunterspieler41 = e.getPlayer().getLocation().add(new Vector(-1, -2, 0));
          Location Blockunterspieler51 = e.getPlayer().getLocation().add(new Vector(-1, -2, -1));
          Location Blockunterspieler61 = e.getPlayer().getLocation().add(new Vector(0, -2, -1));
          
          Location Blockunterspieler02 = e.getPlayer().getLocation().add(new Vector(0, -3, 0));
          Location Blockunterspieler12 = e.getPlayer().getLocation().add(new Vector(1, -3, 0));
          Location Blockunterspieler22 = e.getPlayer().getLocation().add(new Vector(0, -3, 1));
          Location Blockunterspieler32 = e.getPlayer().getLocation().add(new Vector(1, -3, 1));
          Location Blockunterspieler42 = e.getPlayer().getLocation().add(new Vector(-1, -3, 0));
          Location Blockunterspieler52 = e.getPlayer().getLocation().add(new Vector(-1, -3, -1));
          Location Blockunterspieler62 = e.getPlayer().getLocation().add(new Vector(0, -3, -1));
          if ((Blockunterspieler0.getBlock().getType().equals(Material.AIR)) && 
            (Blockunterspieler1.getBlock().getType().equals(Material.AIR)) && 
            (Blockunterspieler2.getBlock().getType().equals(Material.AIR)) && 
            (Blockunterspieler3.getBlock().getType().equals(Material.AIR)) && 
            (Blockunterspieler4.getBlock().getType().equals(Material.AIR)) && 
            (Blockunterspieler5.getBlock().getType().equals(Material.AIR)) && 
            (Blockunterspieler6.getBlock().getType().equals(Material.AIR))) {
            if ((Blockunterspieler01.getBlock().getType().equals(Material.AIR)) && 
              (Blockunterspieler11.getBlock().getType().equals(Material.AIR)) && 
              (Blockunterspieler21.getBlock().getType().equals(Material.AIR)) && 
              (Blockunterspieler31.getBlock().getType().equals(Material.AIR)) && 
              (Blockunterspieler41.getBlock().getType().equals(Material.AIR)) && 
              (Blockunterspieler51.getBlock().getType().equals(Material.AIR)) && 
              (Blockunterspieler61.getBlock().getType().equals(Material.AIR))) {
              if ((Blockunterspieler02.getBlock().getType().equals(Material.AIR)) && 
                (Blockunterspieler12.getBlock().getType().equals(Material.AIR)) && 
                (Blockunterspieler22.getBlock().getType().equals(Material.AIR)) && 
                (Blockunterspieler32.getBlock().getType().equals(Material.AIR)) && 
                (Blockunterspieler42.getBlock().getType().equals(Material.AIR)) && 
                (Blockunterspieler52.getBlock().getType().equals(Material.AIR)) && 
                (Blockunterspieler62.getBlock().getType().equals(Material.AIR)))
              {
                Location loc0 = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() - 3.0D, p.getLocation().getZ());
                
                Location loc1 = new Location(p.getWorld(), p.getLocation().getX() + 1.0D, p.getLocation().getY() - 3.0D, p.getLocation().getZ());
                Location loc2 = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() - 3.0D, p.getLocation().getZ() + 1.0D);
                Location loc3 = new Location(p.getWorld(), p.getLocation().getX() + 1.0D, p.getLocation().getY() - 3.0D, p.getLocation().getZ() + 1.0D);
                
                Location loc4 = new Location(p.getWorld(), p.getLocation().getX() - 1.0D, p.getLocation().getY() - 3.0D, p.getLocation().getZ());
                Location loc5 = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() - 3.0D, p.getLocation().getZ() - 1.0D);
                Location loc6 = new Location(p.getWorld(), p.getLocation().getX() - 1.0D, p.getLocation().getY() - 3.0D, p.getLocation().getZ() - 1.0D);
                


                loc0.getBlock().setType(Material.ENDER_STONE);
                loc1.getBlock().setType(Material.ENDER_STONE);
                loc2.getBlock().setType(Material.ENDER_STONE);
                loc3.getBlock().setType(Material.ENDER_STONE);
                loc4.getBlock().setType(Material.ENDER_STONE);
                loc5.getBlock().setType(Material.ENDER_STONE);
                loc6.getBlock().setType(Material.ENDER_STONE);
                if (p.getItemInHand().getAmount() == 1) {
                  p.getInventory().remove(Material.BLAZE_ROD);
                }
                p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
                
                p.sendMessage(Data.prefix + "§c Rettungsplattform eingesetzt!");
                return;
              }
            }
          }
          p.sendMessage("§c Es befinden sich unter dir Blöcke! Du kannst die Plattform hier nicht einsetzen!");
        }
      }
      else {
        p.sendMessage("§c Nicht jetzt ausführbar!");
      }
    }
  }
  
  @EventHandler
  public void onInteract(PlayerInteractEntityEvent e)
  {
    if ((e.getRightClicked() instanceof Wolf))
    {
      Wolf wo = (Wolf)e.getRightClicked();
      
      wo.setSitting(false);
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onKaka(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      ((e.getPlayer().getItemInHand().getType() == Material.MONSTER_EGG) || 
      (e.getPlayer().getItemInHand().getType() == Material.MONSTER_EGGS)) && 
      (Data.players.contains(p)) && (Data.status == GameStatus.INGAME) && 
      (!Data.cooldown1.contains(p)))
    {
      Data.cooldown1.add(p);
      new BukkitRunnable()
      {
        public void run()
        {
          Data.cooldown1.remove(p);
        }
      }.runTaskLater(Main.plugin, 5L);
      if (p.getItemInHand().getAmount() == 1)
      {
        p.getInventory().remove(Material.MONSTER_EGG);
        p.getInventory().remove(Material.MONSTER_EGGS);
      }
      p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
      
      new BukkitRunnable()
      {
        public void run()
        {
          Data.spawnmob = true;
          final Wolf w = (Wolf)p.getWorld().spawn(p.getLocation(), Wolf.class);
          Data.spawnmob = false;
          if (Data.rot.contains(p))
          {
            w.setOwner(p);
            w.setAdult();
            w.setCollarColor(DyeColor.RED);
            w.setTamed(true);
            w.setSitting(false);
            

            Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new BukkitRunnable()
            {
              public void run()
              {
                double radius = 7.0D;
                
                Player po = (Player)w.getOwner();
                if (((po instanceof Player)) && 
                  (po.getName() == w.getOwner().getName()) && 
                  (this.val$p.getLocation().distance(w.getLocation()) >= radius)) {
                  w.teleport(this.val$p.getLocation());
                }
              }
            }, 20L, 20L);
          }
          if (Data.blau.contains(p))
          {
            w.setOwner(p);
            w.setAdult();
            w.setCollarColor(DyeColor.BLUE);
            w.setTamed(true);
            w.setSitting(false);
            
            Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new BukkitRunnable()
            {
              public void run()
              {
                double radius = 7.0D;
                
                Player po = (Player)w.getOwner();
                if (((po instanceof Player)) && 
                  (po.getName() == w.getOwner().getName()) && 
                  (this.val$p.getLocation().distance(w.getLocation()) >= radius)) {
                  w.teleport(this.val$p.getLocation());
                }
              }
            }, 20L, 20L);
          }
        }
      }.runTaskLater(Main.plugin, 10L);
    }
  }
  
  @EventHandler
  public void onFall(EntityDamageEvent e)
  {
    if ((e.getCause() == EntityDamageEvent.DamageCause.FALL) && (e.getEntityType() == EntityType.WOLF)) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onBombenAngriff(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (e.getPlayer().getItemInHand().getType() == Material.FIREBALL) && 
      (Data.players.contains(p)) && (Data.status == GameStatus.INGAME) && 
      (!Data.cooldown1.contains(p)))
    {
      Data.cooldown1.add(p);
      new BukkitRunnable()
      {
        public void run()
        {
          Data.cooldown1.remove(p);
        }
      }.runTaskLater(Main.plugin, 5L);
      if (p.getItemInHand().getAmount() == 1) {
        p.getInventory().remove(Material.FIREBALL);
      }
      p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
      









      ItemStack i = new ItemStack(Material.WOOL, 1, (short)11);
      ItemMeta im = i.getItemMeta();
      im.setDisplayName("§9Blau");
      im.setLore(Arrays.asList(new String[] { "§7Attackiert dieses Team mit Bomben!" }));
      i.setItemMeta(im);
      
      ItemStack i1 = new ItemStack(Material.WOOL, 1, (short)14);
      ItemMeta im1 = i1.getItemMeta();
      im1.setDisplayName("§cRot");
      im1.setLore(Arrays.asList(new String[] { "§7Attackiert dieses Team mit Bomben!" }));
      i1.setItemMeta(im1);
      
      ItemStack i11 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
      ItemMeta im11 = i11.getItemMeta();
      im11.setDisplayName("§8");
      i11.setItemMeta(im11);
      if (Data.rot.contains(p))
      {
        Inventory inv99 = p.getPlayer().getServer().createInventory(null, 27, "§cZiel");
        
        inv99.setItem(0, i11);
        inv99.setItem(1, i11);
        inv99.setItem(2, i11);
        inv99.setItem(3, i11);
        inv99.setItem(4, i11);
        inv99.setItem(5, i11);
        inv99.setItem(6, i11);
        inv99.setItem(7, i11);
        inv99.setItem(8, i11);
        inv99.setItem(9, i11);
        inv99.setItem(10, i11);
        inv99.setItem(11, i11);
        inv99.setItem(12, i11);
        inv99.setItem(13, i);
        inv99.setItem(14, i11);
        inv99.setItem(15, i11);
        inv99.setItem(16, i11);
        inv99.setItem(17, i11);
        inv99.setItem(18, i11);
        inv99.setItem(19, i11);
        inv99.setItem(20, i11);
        inv99.setItem(21, i11);
        inv99.setItem(22, i11);
        inv99.setItem(23, i11);
        inv99.setItem(24, i11);
        inv99.setItem(25, i11);
        inv99.setItem(26, i11);
        
        p.openInventory(inv99);
      }
      else if (Data.blau.contains(p))
      {
        Inventory inv98 = p.getPlayer().getServer().createInventory(null, 27, "§cZiel");
        
        inv98.setItem(0, i11);
        inv98.setItem(1, i11);
        inv98.setItem(2, i11);
        inv98.setItem(3, i11);
        inv98.setItem(4, i11);
        inv98.setItem(5, i11);
        inv98.setItem(6, i11);
        inv98.setItem(7, i11);
        inv98.setItem(8, i11);
        inv98.setItem(9, i11);
        inv98.setItem(10, i11);
        inv98.setItem(11, i11);
        inv98.setItem(12, i11);
        inv98.setItem(13, i1);
        inv98.setItem(14, i11);
        inv98.setItem(15, i11);
        inv98.setItem(16, i11);
        inv98.setItem(17, i11);
        inv98.setItem(18, i11);
        inv98.setItem(19, i11);
        inv98.setItem(20, i11);
        inv98.setItem(21, i11);
        inv98.setItem(22, i11);
        inv98.setItem(23, i11);
        inv98.setItem(24, i11);
        inv98.setItem(25, i11);
        inv98.setItem(26, i11);
        
        p.openInventory(inv98);
      }
    }
  }
  
  @EventHandler
  public void Inventorsy(InventoryClickEvent e)
  {
    final Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getName().equalsIgnoreCase("§cZiel"))
    {
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§cRot")
      {
        e.setCancelled(true);
        if (!Data.cooldown1.contains(p))
        {
          Data.cooldown1.add(p);
          new BukkitRunnable()
          {
            public void run()
            {
              Data.cooldown1.remove(p);
            }
          }.runTaskLater(Main.plugin, 5L);
          
          Bukkit.broadcastMessage("§c-==-§4 ☢✘☢ §c-==-§c-==-§4 ☢✘☢ §c-==-§c-==-§4 ☢✘☢ §c-==-");
          Bukkit.broadcastMessage("§8Ein Bombenagriff von§9 Team Blau§8 wurde auf§c Team Rot§8 aktiviert.");
          Bukkit.broadcastMessage("§c-==-§4 ☢✘☢ §c-==-§c-==-§4 ☢✘☢ §c-==-§c-==-§4 ☢✘☢ §c-==-");
          e.getView().close();
          for (Player bl : Data.rot)
          {
            final int[] IDS = new int[1];
            IDS[0 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new BukkitRunnable()
            {
              public void run()
              {
                int minx = Data.getLocation("rotspawn").getBlockX() - 15;
                int maxx = Data.getLocation("rotspawn").getBlockX() + 15;
                int minz = Data.getLocation("rotspawn").getBlockZ() + 15;
                int maxz = Data.getLocation("rotspawn").getBlockZ() - 15;
                final int randx = minx + (int)(Math.random() * (maxx - minx + 1));
                final int randz = minz + (int)(Math.random() * (maxz - minz + 1));
                

                Location rand1 = new Location(Data.getLocation("rotspawn").getWorld(), randx, Data.getLocation("rotspawn").getY() + JoinListener.getRandom(3, 40), randz);
                rand1.getWorld().spawnEntity(rand1, EntityType.PRIMED_TNT);
                
                Location rand10 = new Location(Data.getLocation("rotspawn").getWorld(), randx, Data.getLocation("rotspawn").getY() + JoinListener.getRandom(3, 40), randz);
                Fireball s1 = (Fireball)rand10.getWorld().spawn(rand10, Fireball.class);
                s1.setBounce(false);
                s1.setDirection(new Vector(0, 5, 0));
                

                final int[] IDSS = new int[1];
                IDSS[0 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new BukkitRunnable()
                {
                  public void run()
                  {
                    Location rand3 = new Location(Data.getLocation("rotspawn").getWorld(), randx, Data.getLocation("rotspawn").getY() + JoinListener.getRandom(0, 4), randz);
                    rand3.getWorld().playEffect(rand3, Effect.MOBSPAWNER_FLAMES, 20);
                    rand3.getWorld().playEffect(rand3, Effect.LAVA_POP, 20);
                    rand3.getWorld().playEffect(rand3, Effect.LAVADRIP, 20);
                  }
                }, 3L, 3L);
                

                Location rand5 = new Location(Data.getLocation("rotspawn").getWorld(), randx, Data.getLocation("rotspawn").getY() + JoinListener.getRandom(0, 1), randz);
                rand5.getWorld().strikeLightning(rand5);
                
                Location rand2 = new Location(Data.getLocation("rotspawn").getWorld(), randx, Data.getLocation("rotspawn").getY() + 50.0D, randz);
                Fireball s = (Fireball)rand2.getWorld().spawn(rand2, Fireball.class);
                s.setBounce(false);
                
                s.setDirection(Data.getLocation("rotspawn").toVector().subtract(s.getLocation().toVector()).normalize());
                
                new BukkitRunnable()
                {
                  public void run()
                  {
                    Bukkit.getScheduler().cancelTask(this.val$IDS[0]);
                    Bukkit.getScheduler().cancelTask(IDSS[0]);
                  }
                }.runTaskLater(Main.plugin, 160L);
              }
            }, 8L, 8L);
          }
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§9Blau")
      {
        e.setCancelled(true);
        if (!Data.cooldown1.contains(p))
        {
          Data.cooldown1.add(p);
          new BukkitRunnable()
          {
            public void run()
            {
              Data.cooldown1.remove(p);
            }
          }.runTaskLater(Main.plugin, 5L);
          
          Bukkit.broadcastMessage("§c-==-§4 ☢✘☢ §c-==-§c-==-§4 ☢✘☢ §c-==-§c-==-§4 ☢✘☢ §c-==-");
          Bukkit.broadcastMessage("§8Ein Bombenagriff von§c Team Rot§8 wurde auf§9 Team Blau§8 aktiviert.");
          Bukkit.broadcastMessage("§c-==-§4 ☢✘☢ §c-==-§c-==-§4 ☢✘☢ §c-==-§c-==-§4 ☢✘☢ §c-==-");
          e.getView().close();
          for (Player bl : Data.blau)
          {
            final int[] IDS = new int[1];
            IDS[0 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new BukkitRunnable()
            {
              public void run()
              {
                int minx = Data.getLocation("blauspawn").getBlockX() - 15;
                int maxx = Data.getLocation("blauspawn").getBlockX() + 15;
                int minz = Data.getLocation("blauspawn").getBlockZ() + 15;
                int maxz = Data.getLocation("blauspawn").getBlockZ() - 15;
                final int randx = minx + (int)(Math.random() * (maxx - minx + 1));
                final int randz = minz + (int)(Math.random() * (maxz - minz + 1));
                

                Location rand1 = new Location(Data.getLocation("blauspawn").getWorld(), randx, Data.getLocation("blauspawn").getY() + JoinListener.getRandom(3, 40), randz);
                rand1.getWorld().spawnEntity(rand1, EntityType.PRIMED_TNT);
                
                Location rand10 = new Location(Data.getLocation("blauspawn").getWorld(), randx, Data.getLocation("blauspawn").getY() + JoinListener.getRandom(3, 40), randz);
                Fireball s1 = (Fireball)rand10.getWorld().spawn(rand10, Fireball.class);
                s1.setBounce(false);
                s1.setDirection(new Vector(0, 5, 0));
                

                final int[] IDSS = new int[1];
                IDSS[0 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new BukkitRunnable()
                {
                  public void run()
                  {
                    Location rand3 = new Location(Data.getLocation("blauspawn").getWorld(), randx, Data.getLocation("blauspawn").getY() + JoinListener.getRandom(0, 4), randz);
                    rand3.getWorld().playEffect(rand3, Effect.MOBSPAWNER_FLAMES, 20);
                    rand3.getWorld().playEffect(rand3, Effect.LAVA_POP, 20);
                    rand3.getWorld().playEffect(rand3, Effect.LAVADRIP, 20);
                  }
                }, 3L, 3L);
                

                Location rand5 = new Location(Data.getLocation("blauspawn").getWorld(), randx, Data.getLocation("blauspawn").getY() + JoinListener.getRandom(0, 1), randz);
                rand5.getWorld().strikeLightning(rand5);
                
                Location rand2 = new Location(Data.getLocation("blauspawn").getWorld(), randx, Data.getLocation("blauspawn").getY() + 50.0D, randz);
                Fireball s = (Fireball)rand2.getWorld().spawn(rand2, Fireball.class);
                s.setBounce(false);
                
                s.setDirection(Data.getLocation("blauspawn").toVector().subtract(s.getLocation().toVector()).normalize());
                
                new BukkitRunnable()
                {
                  public void run()
                  {
                    Bukkit.getScheduler().cancelTask(this.val$IDS[0]);
                    Bukkit.getScheduler().cancelTask(IDSS[0]);
                  }
                }.runTaskLater(Main.plugin, 160L);
              }
            }, 8L, 8L);
          }
        }
      }
    }
  }
  
  @EventHandler
  public void onStats(final PlayerInteractEvent e)
  {
    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (e.getPlayer().getItemInHand().getType() == Material.PAPER) && 
      (!Data.cooldown.contains(e.getPlayer())))
    {
      Data.cooldown.add(e.getPlayer());
      
      e.getPlayer().performCommand("stats");
      Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, 
        new BukkitRunnable()
        {
          public void run()
          {
            Data.cooldown.remove(e.getPlayer());
          }
        }, 60L);
    }
  }
  
  @EventHandler
  public void onLogin(PlayerLoginEvent e)
  {
    Player p = e.getPlayer();
    if ((p.hasPermission("twice.premium")) && (Bukkit.getOnlinePlayers().size() == Bukkit.getMaxPlayers()))
    {
      e.allow();
      for (Player pl : Bukkit.getOnlinePlayers()) {
        if (!pl.hasPermission("twice.premium"))
        {
          pl.kickPlayer("§6Du wurdest von einem Premium Spieler aus der Runde geschubst!");
          return;
        }
      }
      e.disallow(PlayerLoginEvent.Result.KICK_FULL, "§cDieser Server ist gefüllt von Premiumspielern...");
    }
  }
  
  @EventHandler
  public void on(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    if ((Data.status == GameStatus.INGAME) || (Data.status == GameStatus.ENDE))
    {
      e.setJoinMessage(null);
      p.setGameMode(GameMode.SPECTATOR);
      IChatBaseComponent headertext = ChatSerializer.a("{\"text\":\"§6Du bist im\"}");
      PacketPlayOutTitle header = new PacketPlayOutTitle(EnumTitleAction.TITLE, headertext);
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(header);
      
      IChatBaseComponent footertext = ChatSerializer.a("{\"text\":\"§6Zuschauermodus\"}");
      PacketPlayOutTitle footer = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, footertext);
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(footer);
      
      PacketPlayOutTitle times = new PacketPlayOutTitle(EnumTitleAction.TIMES, null, 20, 60, 20);
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(times);
    }
    sendTablist(p, "§7▂ ▄ ▅ ▆ ▇ █ §eBEDWARS§7 █ ▇ ▆ ▅ ▄ ▂", "§7Du spielst auf der Map: §4%WORLD%");
    if (Main.teamr.hasPlayer(e.getPlayer())) {
      Main.teamr.removePlayer(e.getPlayer());
    }
    if (Main.teamb.hasPlayer(e.getPlayer())) {
      Main.teamb.removePlayer(e.getPlayer());
    }
    clearPotionEffects(p);
    
    p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
    
    Data.blau.remove(p);
    Data.rot.remove(p);
    Data.noteam.add(p);
    
    Inventory inv = p.getInventory();
    if (Data.status == GameStatus.LOBBY)
    {
      e.getPlayer().setGameMode(GameMode.SURVIVAL);
      
      e.setJoinMessage("§7" + p.getName() + " §6hat den Server betreten! §8(§a" + Bukkit.getServer().getOnlinePlayers().size() + "§8/§a" + Bukkit.getServer().getMaxPlayers() + "§8)");
      
      p.getInventory().clear();
      p.getInventory().setArmorContents(null);
      



      ItemStack item = new ItemStack(Material.DIAMOND);
      ItemMeta itemmeat = item.getItemMeta();
      itemmeat.setDisplayName("§eErfolge");
      item.setItemMeta(itemmeat);
      inv.setItem(8, item);
      


      ItemStack item1 = new ItemStack(Material.MAGMA_CREAM);
      ItemMeta itemmeat1 = item1.getItemMeta();
      itemmeat1.setDisplayName("§eZurück zur Lobby");
      item1.setItemMeta(itemmeat1);
      inv.setItem(0, item1);
      


      ItemStack item21 = new ItemStack(Material.PAPER);
      ItemMeta itemmeat21 = item21.getItemMeta();
      itemmeat21.setDisplayName("§eStatistiken");
      item21.setItemMeta(itemmeat21);
      inv.setItem(4, item21);
      
      p.updateInventory();
      p.setMaxHealth(20.0D);
      p.setHealth(20.0D);
      p.setFoodLevel(20);
      p.setFlying(false);
      


      IChatBaseComponent headertext = ChatSerializer.a("{\"text\":\"§6§lBedwars\"}");
      PacketPlayOutTitle header = new PacketPlayOutTitle(EnumTitleAction.TITLE, headertext);
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(header);
      
      IChatBaseComponent footertext = ChatSerializer.a("{\"text\":\"§cTwicePvP.eu\"}");
      PacketPlayOutTitle footer = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, footertext);
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(footer);
      
      PacketPlayOutTitle times = new PacketPlayOutTitle(EnumTitleAction.TIMES, null, 20, 60, 20);
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(times);
      


      p.teleport(Data.getLocation("lobbyspawn"));
    }
  }
}
