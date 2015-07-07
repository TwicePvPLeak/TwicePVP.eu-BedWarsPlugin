package me.Bedwars.Listener;

import java.util.List;
import me.Bedwars.Data.Data;
import me.Bedwars.GameStatus.GameStatus;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class FoodListener
  implements Listener
{
  @EventHandler
  public void on(FoodLevelChangeEvent e)
  {
    if ((Data.status == GameStatus.INGAME) && (Data.players.contains(e.getEntity())))
    {
      e.setCancelled(false);
    }
    else
    {
      e.setFoodLevel(20);
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onInteract(PlayerInteractEvent e)
  {
    if (((e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && (
      (e.getClickedBlock().getType() == Material.ANVIL) || 
      (e.getClickedBlock().getType() == Material.WORKBENCH) || 
      (e.getClickedBlock().getType() == Material.DISPENSER) || 
      (e.getClickedBlock().getType() == Material.ENDER_CHEST) || 
      (e.getClickedBlock().getType() == Material.DROPPER))) {
      e.setCancelled(true);
    }
  }
}
