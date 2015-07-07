package me.Bedwars.Listener;

import java.util.List;
import me.Bedwars.Data.Data;
import me.Bedwars.GameStatus.GameStatus;
import me.Bedwars.Main;
import net.minecraft.server.v1_8_R1.Explosion;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.WitherSkull;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class DamageListener
  implements Listener
{
  @EventHandler(priority=EventPriority.MONITOR)
  public void onEntDmg(EntityDamageEvent e)
  {
    if (Data.status == GameStatus.LOBBY)
    {
      e.setCancelled(true);
      return;
    }
    if (e.getEntity().getType() == EntityType.VILLAGER)
    {
      e.setCancelled(true);
      return;
    }
    if ((e.getEntity() instanceof Player))
    {
      if (e.getCause() == EntityDamageEvent.DamageCause.VOID)
      {
        if (Data.blau.contains((Player)e.getEntity())) {
          ((Player)e.getEntity()).teleport(Data.getLocation("blue"));
        }
        if (Data.rot.contains((Player)e.getEntity())) {
          ((Player)e.getEntity()).teleport(Data.getLocation("red"));
        }
      }
      if (Data.spec.contains((Player)e.getEntity())) {
        e.setCancelled(true);
      }
    }
  }
  
  @EventHandler
  public void onHit(EntityDamageByEntityEvent e)
  {
    if ((((e.getEntity() instanceof ArmorStand)) && 
      ((e.getDamager() instanceof Explosion))) || (((e.getEntity() instanceof ArmorStand)) && 
      ((e.getDamager() instanceof TNTPrimed))) || (
      ((e.getEntity() instanceof ArmorStand)) && 
      ((e.getDamager() instanceof LightningStrike)))) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onEntDmgByEnt(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Wolf)) && 
      ((e.getDamager() instanceof Player)))
    {
      Player d = (Player)e.getDamager();
      Wolf p = (Wolf)e.getEntity();
      Player owner = (Player)p.getOwner();
      if ((Data.blau.contains(owner)) && (Data.blau.contains(d))) {
        e.setCancelled(true);
      }
      if ((Data.rot.contains(owner)) && (Data.rot.contains(d))) {
        e.setCancelled(true);
      }
      if (Data.spec.contains(d)) {
        e.setCancelled(true);
      }
    }
    if (((e.getEntity() instanceof Wolf)) && ((e.getDamager() instanceof Arrow)))
    {
      Player shooter = (Player)((Arrow)e.getDamager()).getShooter();
      Wolf p = (Wolf)e.getEntity();
      Player owner = (Player)p.getOwner();
      if ((Data.blau.contains(shooter)) && (Data.blau.contains(owner))) {
        e.setCancelled(true);
      }
      if ((Data.rot.contains(shooter)) && (Data.rot.contains(owner))) {
        e.setCancelled(true);
      }
    }
    if (((e.getEntity() instanceof Wolf)) && ((e.getDamager() instanceof Snowball)))
    {
      Player shooter = (Player)((Snowball)e.getDamager()).getShooter();
      Wolf p = (Wolf)e.getEntity();
      Player owner = (Player)p.getOwner();
      if ((Data.blau.contains(shooter)) && (Data.blau.contains(owner))) {
        e.setCancelled(true);
      }
      if ((Data.rot.contains(shooter)) && (Data.rot.contains(owner))) {
        e.setCancelled(true);
      }
    }
  }
  
  @EventHandler
  public void onEntDmgByEnts(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Player)) && 
      ((e.getDamager() instanceof Player)))
    {
      Player d = (Player)e.getDamager();
      Player p = (Player)e.getEntity();
      if ((Data.blau.contains(p)) && (Data.blau.contains(d))) {
        e.setCancelled(true);
      }
      if ((Data.rot.contains(p)) && (Data.rot.contains(d))) {
        e.setCancelled(true);
      }
      if (Data.spec.contains(d)) {
        e.setCancelled(true);
      }
    }
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Arrow)))
    {
      Player shooter = (Player)((Arrow)e.getDamager()).getShooter();
      Player p = (Player)e.getEntity();
      if ((Data.blau.contains(shooter)) && (Data.blau.contains(p))) {
        e.setCancelled(true);
      }
      if ((Data.rot.contains(shooter)) && (Data.rot.contains(p))) {
        e.setCancelled(true);
      }
    }
    if (((e.getEntity() instanceof Player)) && 
      ((e.getDamager() instanceof Snowball)))
    {
      Player shooter = (Player)((Snowball)e.getDamager()).getShooter();
      Player p = (Player)e.getEntity();
      if ((Data.blau.contains(shooter)) && (Data.blau.contains(p))) {
        e.setCancelled(true);
      }
      if ((Data.rot.contains(shooter)) && (Data.rot.contains(p))) {
        e.setCancelled(true);
      }
    }
    if (((e.getEntity() instanceof Player)) && 
      ((e.getDamager() instanceof EnderPearl)))
    {
      Player shooter = (Player)((EnderPearl)e.getDamager())
        .getShooter();
      Player p = (Player)e.getEntity();
      if ((Data.blau.contains(shooter)) && (Data.blau.contains(p))) {
        e.setCancelled(true);
      }
      if ((Data.rot.contains(shooter)) && (Data.rot.contains(p))) {
        e.setCancelled(true);
      }
    }
    if (((e.getEntity() instanceof WitherSkull)) && 
      ((e.getDamager() instanceof WitherSkull)))
    {
      Player shooter = (Player)e.getDamager();
      Player p = (Player)e.getEntity();
      if ((Data.blau.contains(shooter)) && (Data.blau.contains(p))) {
        e.setCancelled(true);
      }
      if ((Data.rot.contains(shooter)) && (Data.rot.contains(p))) {
        e.setCancelled(true);
      }
    }
    if (((e.getEntity() instanceof Player)) && 
      ((e.getDamager() instanceof TNTPrimed)))
    {
      Player shooter = (Player)e.getDamager();
      Player p = (Player)e.getEntity();
      if ((Data.blau.contains(shooter)) && (Data.blau.contains(p))) {
        e.setCancelled(true);
      }
      if ((Data.rot.contains(shooter)) && (Data.rot.contains(p))) {
        e.setCancelled(true);
      }
    }
  }
  
  @EventHandler
  public void onMove(final PlayerMoveEvent e)
  {
    if ((!Data.spec.contains(e.getPlayer())) && 
      (Data.status == GameStatus.INGAME) && 
      (e.getPlayer().getLocation().getY() <= 5.0D) && 
      (!Data.cooldown2.contains(e.getPlayer())))
    {
      Data.cooldown2.add(e.getPlayer());
      e.getPlayer().damage(2000.0D);
      
      new BukkitRunnable()
      {
        public void run()
        {
          Data.cooldown2.remove(e.getPlayer());
        }
      }.runTaskLater(Main.plugin, 60L);
    }
  }
}
