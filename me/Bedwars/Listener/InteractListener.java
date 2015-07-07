package me.Bedwars.Listener;

import java.util.List;
import java.util.Random;
import me.Bedwars.Data.Data;
import me.Bedwars.GameStatus.GameStatus;
import me.Bedwars.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class InteractListener
  implements Listener
{
  @EventHandler
  public void ons(PlayerPickupItemEvent e)
  {
    final Player p = e.getPlayer();
    ItemStack x = e.getItem().getItemStack();
    ItemStack pickedup = e.getItem().getItemStack();
    int amount = 0;
    if (!Data.spec.contains(e.getPlayer()))
    {
      if (x.getType() == Material.CLAY_BRICK)
      {
        e.getItem().remove();
        amount = 1;
        

        new BukkitRunnable()
        {
          public void run()
          {
            if (p.hasPermission("bw.verdopplung2"))
            {
              Random r1 = new Random();
              int i1 = r1.nextInt(3);
              if (i1 == 0)
              {
                p.giveExpLevels(2);
                p.sendMessage("§c+2 Zusatzlevel");
              }
            }
            else if (p.hasPermission("bw.verdopplung1"))
            {
              Random r1 = new Random();
              int i1 = r1.nextInt(9);
              if (i1 == 0)
              {
                p.giveExpLevels(2);
                p.sendMessage("§c+2 Zusatzlevel");
              }
            }
          }
        }.runTaskLater(Main.plugin, 3L);
        




        p.giveExpLevels(amount * pickedup.getAmount());
        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
        e.setCancelled(true);
      }
      if (e.getItem().getItemStack().getType() == Material.IRON_INGOT)
      {
        e.getItem().remove();
        amount = 10;
        p.giveExpLevels(amount * pickedup.getAmount());
        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
        e.setCancelled(true);
      }
      if (e.getItem().getItemStack().getType() == Material.GOLD_INGOT)
      {
        e.getItem().remove();
        amount = 50;
        p.giveExpLevels(amount * pickedup.getAmount());
        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
        e.setCancelled(true);
      }
      if (e.getItem().getItemStack().getType() == Material.BED)
      {
        e.getItem().remove();
        e.setCancelled(true);
      }
    }
    else
    {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onEntityDamage(EntityDamageEvent e)
  {
    Entity schaf = e.getEntity();
    if (((schaf instanceof Chicken)) && 
      ((schaf.getPassenger() instanceof Player)) && 
      (e.getCause().equals(EntityDamageEvent.DamageCause.FALL))) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onHitChicken(EntityDamageByEntityEvent e)
  {
    Player d = (Player)e.getDamager();
    Entity p = e.getEntity();
    if (((p instanceof Chicken)) && ((d instanceof Player))) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onDie(PlayerMoveEvent e)
  {
    if (e.getPlayer().getLocation().getY() <= 0.0D) {
      e.getPlayer().damage(100.0D);
    }
  }
  
  @EventHandler
  public void on(PlayerDropItemEvent e)
  {
    if ((Data.status == GameStatus.INGAME) && (Data.players.contains(e.getPlayer()))) {
      e.setCancelled(false);
    } else {
      e.setCancelled(true);
    }
  }
}
