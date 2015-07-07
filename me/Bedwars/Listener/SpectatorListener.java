package me.Bedwars.Listener;

import java.util.List;
import me.Bedwars.Data.Data;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

public class SpectatorListener
  implements Listener
{
  @EventHandler
  public void on(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((p.getItemInHand().getType() == Material.COMPASS) && 
      (Data.spec.contains(p)))
    {
      Inventory i = Bukkit.createInventory(null, 27, "§eTeleporter");
      Integer slots = Integer.valueOf(0);
      for (Player pw : Data.players)
      {
        ItemStack is = new ItemStack(Material.SKULL, 1, (short)5);
        ItemMeta ism = is.getItemMeta();
        ism.setDisplayName(pw.getName());
        is.setItemMeta(ism);
        i.setItem(slots.intValue(), is);
        slots = Integer.valueOf(slots.intValue() + 1);
        p.openInventory(i);
      }
    }
  }
  
  @EventHandler
  public void on(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getName().equalsIgnoreCase("§eTeleporter")) && 
      (e.getCurrentItem().getType().equals(Material.SKULL)))
    {
      String name = e.getCurrentItem().getItemMeta().getDisplayName();
      if (Bukkit.getPlayerExact(name) != null)
      {
        Player clicked = Bukkit.getPlayerExact(name);
        p.teleport(clicked.getLocation());
        p.sendMessage(Data.prefix + " §5Du hast dich zu dem Spieler§d " + 
          clicked.getName() + "§5 teleportiert!");
        p.playSound(p.getLocation(), Sound.HORSE_JUMP, 3.0F, 3.0F);
        p.closeInventory();
      }
      else
      {
        p.sendMessage(Data.prefix + 
          "§c Der Spieler ist schon offline gegangen!");
        p.closeInventory();
      }
    }
  }
  
  @EventHandler
  public void on(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (Data.spec.contains(p)) {
      for (Player players : Data.players) {
        if (e.getTo().distance(players.getLocation()) < 2.0D) {
          p.setVelocity(p.getLocation().getDirection().multiply(-1.0D));
        }
      }
    }
  }
}
