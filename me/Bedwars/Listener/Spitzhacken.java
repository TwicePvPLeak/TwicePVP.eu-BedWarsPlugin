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

public class Spitzhacken
  implements Listener
{
  @EventHandler
  public void Inventory(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getName().equalsIgnoreCase("§6Spitzhacken"))
    {
      e.setCancelled(true);
      
      ItemStack hacke = new ItemStack(Material.WOOD_PICKAXE, 1);
      ItemMeta hackemeta = hacke.getItemMeta();
      hackemeta.setDisplayName("§6Spitzhacke I");
      
      hacke.setItemMeta(hackemeta);
      
      ItemStack hacke1 = new ItemStack(Material.STONE_PICKAXE, 1);
      ItemMeta hackemeta1 = hacke1.getItemMeta();
      hackemeta1.setDisplayName("§6Spitzhacke II");
      
      hacke1.setItemMeta(hackemeta1);
      
      ItemStack hacke11 = new ItemStack(Material.IRON_PICKAXE, 1);
      ItemMeta hackemeta11 = hacke11.getItemMeta();
      hackemeta11.setDisplayName("§6Spitzhacke III");
      
      hacke11.setItemMeta(hackemeta11);
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Spitzhacke I") {
        if (p.getLevel() >= 25)
        {
          p.getInventory().addItem(new ItemStack[] { hacke });
          p.setLevel(p.getLevel() - 25);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Spitzhacke II") {
        if (p.getLevel() >= 50)
        {
          p.getInventory().addItem(new ItemStack[] { hacke1 });
          p.setLevel(p.getLevel() - 50);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Spitzhacke III") {
        if (p.getLevel() >= 75)
        {
          p.getInventory().addItem(new ItemStack[] { hacke11 });
          p.setLevel(p.getLevel() - 75);
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
