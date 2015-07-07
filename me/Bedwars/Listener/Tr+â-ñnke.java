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

public class Tränke
  implements Listener
{
  @EventHandler
  public void Inventory(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getName().equalsIgnoreCase("§6Tränke"))
    {
      e.setCancelled(true);
      
      ItemStack tränke = new ItemStack(Material.POTION, 1, (short)8201);
      ItemMeta tränkemeta = tränke.getItemMeta();
      tränkemeta.setDisplayName("§6Stärke Trank");
      
      tränke.setItemMeta(tränkemeta);
      
      ItemStack tränke1 = new ItemStack(Material.POTION, 1, (short)8257);
      ItemMeta tränkemeta1 = tränke1.getItemMeta();
      tränkemeta1.setDisplayName("§6Regenerations Trank");
      
      tränke1.setItemMeta(tränkemeta1);
      
      ItemStack tränke11 = new ItemStack(Material.POTION, 1, (short)8258);
      ItemMeta tränkemeta11 = tränke11.getItemMeta();
      tränkemeta11.setDisplayName("§6Schnelligkeits Trank");
      
      tränke11.setItemMeta(tränkemeta11);
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Stärke Trank") {
        if (p.getLevel() >= 400)
        {
          p.getInventory().addItem(new ItemStack[] { tränke });
          p.setLevel(p.getLevel() - 400);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Regenerations Trank") {
        if (p.getLevel() >= 150)
        {
          p.getInventory().addItem(new ItemStack[] { tränke1 });
          p.setLevel(p.getLevel() - 150);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Schnelligkeits Trank") {
        if (p.getLevel() >= 150)
        {
          p.getInventory().addItem(new ItemStack[] { tränke11 });
          p.setLevel(p.getLevel() - 150);
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
