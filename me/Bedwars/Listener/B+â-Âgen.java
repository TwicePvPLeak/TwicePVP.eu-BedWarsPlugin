package me.Bedwars.Listener;

import me.Bedwars.Main;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Bögen
  implements Listener
{
  @EventHandler
  public void Inventory(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getName().equalsIgnoreCase("§6Bögen"))
    {
      e.setCancelled(true);
      


      ItemStack bogen = new ItemStack(Material.BOW, 1);
      ItemMeta bogenmeta = bogen.getItemMeta();
      bogenmeta.setDisplayName("§6Bogen I");
      
      bogenmeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
      bogen.setItemMeta(bogenmeta);
      
      ItemStack bogen1 = new ItemStack(Material.BOW, 1);
      ItemMeta bogenmeta1 = bogen1.getItemMeta();
      bogenmeta1.setDisplayName("§6Bogen II");
      
      bogenmeta1.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
      bogenmeta1.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
      bogen1.setItemMeta(bogenmeta1);
      
      ItemStack bogen11 = new ItemStack(Material.BOW, 1);
      ItemMeta bogenmeta11 = bogen11.getItemMeta();
      bogenmeta11.setDisplayName("§6Bogen III");
      
      bogenmeta11.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
      bogenmeta11.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
      bogenmeta11.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
      bogen11.setItemMeta(bogenmeta11);
      
      ItemStack bogen111 = new ItemStack(Material.BOW, 1);
      ItemMeta bogenmeta111 = bogen111.getItemMeta();
      bogenmeta111.setDisplayName("§6Bogen IV");
      
      bogenmeta111.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
      bogenmeta111.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
      bogenmeta111.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
      bogenmeta111.addEnchant(Enchantment.ARROW_FIRE, 1, true);
      bogen111.setItemMeta(bogenmeta111);
      
      ItemStack bogen1111 = new ItemStack(Material.ARROW, 1);
      ItemMeta bogenmeta1111 = bogen1111.getItemMeta();
      bogenmeta1111.setDisplayName("§6Pfeil");
      
      bogen1111.setItemMeta(bogenmeta1111);
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Bogen I") {
        if (p.getLevel() >= 150)
        {
          p.getInventory().addItem(new ItemStack[] { bogen });
          p.setLevel(p.getLevel() - 150);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Bogen II") {
        if (p.getLevel() >= 205)
        {
          p.getInventory().addItem(new ItemStack[] { bogen1 });
          p.setLevel(p.getLevel() - 205);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Bogen III") {
        if (p.getLevel() >= 300)
        {
          p.getInventory().addItem(new ItemStack[] { bogen11 });
          p.setLevel(p.getLevel() - 300);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Bogen IV") {
        if (p.getLevel() >= 450)
        {
          p.getInventory().addItem(new ItemStack[] { bogen111 });
          p.setLevel(p.getLevel() - 450);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Pfeil") {
        if (p.getLevel() >= 25)
        {
          p.getInventory().addItem(new ItemStack[] { bogen1111 });
          p.setLevel(p.getLevel() - 25);
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
