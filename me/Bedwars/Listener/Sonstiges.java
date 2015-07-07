package me.Bedwars.Listener;

import me.Bedwars.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Sonstiges
  implements Listener
{
  @EventHandler
  public void Inventory(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getName().equalsIgnoreCase("§6Sonstiges"))
    {
      e.setCancelled(true);
      
      ItemStack sonst = new ItemStack(Material.SNOW_BALL, 16);
      ItemMeta sonstmeta = sonst.getItemMeta();
      sonstmeta.setDisplayName("§6Schneeball");
      
      sonst.setItemMeta(sonstmeta);
      
      ItemStack sonst1 = new ItemStack(Material.ENDER_PEARL, 1);
      ItemMeta sonstmeta1 = sonst1.getItemMeta();
      sonstmeta1.setDisplayName("§6Enderperle");
      
      sonst1.setItemMeta(sonstmeta1);
      
      ItemStack sonst11 = new ItemStack(Material.LADDER, 5);
      ItemMeta sonstmeta11 = sonst11.getItemMeta();
      sonstmeta11.setDisplayName("§6Leiter");
      
      sonst11.setItemMeta(sonstmeta11);
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Schneeball") {
        if (p.getLevel() >= 35)
        {
          p.getInventory().addItem(new ItemStack[] { sonst });
          p.setLevel(p.getLevel() - 35);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Enderperle") {
        if (p.getLevel() >= 500)
        {
          p.getInventory().addItem(new ItemStack[] { sonst1 });
          p.setLevel(p.getLevel() - 500);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Leiter") {
        if (p.getLevel() >= 10)
        {
          p.getInventory().addItem(new ItemStack[] { sonst11 });
          p.setLevel(p.getLevel() - 10);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
    }
  }
}
