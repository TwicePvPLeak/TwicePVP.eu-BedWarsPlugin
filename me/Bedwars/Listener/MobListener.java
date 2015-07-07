package me.Bedwars.Listener;

import java.util.Iterator;
import java.util.List;
import me.Bedwars.Data.Data;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class MobListener
  implements Listener
{
  @EventHandler
  public void on(CreatureSpawnEvent e)
  {
    if (((Data.spawnmob) && (e.getEntity().getType() == EntityType.ARMOR_STAND)) || 
      ((Data.spawnmob) && (e.getEntity().getType() == EntityType.CHICKEN)) || (
      (Data.spawnmob) && (e.getEntity().getType() == EntityType.WOLF))) {
      e.setCancelled(false);
    } else {
      e.setCancelled(true);
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
  public void onTntExplode(EntityExplodeEvent event)
  {
    Entity entity = event.getEntity();
    
    Iterator<Block> blockIterator = event.blockList().iterator();
    while (blockIterator.hasNext()) {
      if ((!((Block)blockIterator.next()).getType().equals(Material.SANDSTONE)) || 
        (!((Block)blockIterator.next()).getType().equals(Material.CAKE)) || 
        (!((Block)blockIterator.next()).getType().equals(Material.CAKE_BLOCK)) || 
        (!((Block)blockIterator.next()).getType().equals(Material.LONG_GRASS)) || 
        (!((Block)blockIterator.next()).getType().equals(Material.MELON_BLOCK)) || 
        (!((Block)blockIterator.next()).getType().equals(Material.DEAD_BUSH)) || 
        (!((Block)blockIterator.next()).getType().equals(Material.WATER_LILY)) || 
        (!((Block)blockIterator.next()).getType().equals(Material.DOUBLE_PLANT)) || 
        (!((Block)blockIterator.next()).getType().equals(Material.RED_ROSE)) || 
        (!((Block)blockIterator.next()).getType().equals(Material.YELLOW_FLOWER)) || 
        (!((Block)blockIterator.next()).getType().equals(Material.WEB)) || 
        (!((Block)blockIterator.next()).getType().equals(Material.ENDER_STONE)) || 
        (!((Block)blockIterator.next()).getType().equals(Material.LADDER)) || 
        (!((Block)blockIterator.next()).getType().equals(Material.CHEST))) {
        blockIterator.remove();
      }
    }
  }
  
  @EventHandler
  public void onFall(EntityDamageEvent e)
  {
    if ((e.getCause() == EntityDamageEvent.DamageCause.FALL) && (e.getEntityType() == EntityType.WOLF)) {
      e.setCancelled(true);
    }
  }
}
