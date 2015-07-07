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

public class Essen
  implements Listener
{
  @EventHandler
  public void Inventory(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getName().equalsIgnoreCase("§6Essen"))
    {
      e.setCancelled(true);
      
      ItemStack essen = new ItemStack(Material.APPLE, 3);
      ItemMeta essenmeta = essen.getItemMeta();
      essenmeta.setDisplayName("§6Apfel");
      
      essen.setItemMeta(essenmeta);
      
      ItemStack essen1 = new ItemStack(Material.COOKED_BEEF, 1);
      ItemMeta essenmeta1 = essen1.getItemMeta();
      essenmeta1.setDisplayName("§6Steak");
      
      essen1.setItemMeta(essenmeta1);
      
      ItemStack essen11 = new ItemStack(Material.CAKE);
      ItemMeta essenmeta11 = essen11.getItemMeta();
      essenmeta11.setDisplayName("§6Kuchen");
      
      essen11.setItemMeta(essenmeta11);
      
      ItemStack essen111 = new ItemStack(Material.GOLDEN_APPLE);
      ItemMeta essenmeta111 = essen111.getItemMeta();
      essenmeta111.setDisplayName("§6Goldener Apfel");
      
      essen111.setItemMeta(essenmeta111);
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Apfel") {
        if (p.getLevel() >= 5)
        {
          p.getInventory().addItem(new ItemStack[] { essen });
          p.setLevel(p.getLevel() - 5);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Kuchen") {
        if (p.getLevel() >= 10)
        {
          p.getInventory().addItem(new ItemStack[] { essen11 });
          p.setLevel(p.getLevel() - 10);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Steak") {
        if (p.getLevel() >= 5)
        {
          p.getInventory().addItem(new ItemStack[] { essen1 });
          p.setLevel(p.getLevel() - 5);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Goldener Apfel") {
        if (p.getLevel() >= 65)
        {
          p.getInventory().addItem(new ItemStack[] { essen111 });
          p.setLevel(p.getLevel() - 65);
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
