package me.Bedwars.Listener;

import me.Bedwars.Main;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Schwerter
  implements Listener
{
  @EventHandler
  public void Inventory(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getName().equalsIgnoreCase("§6Schwerter"))
    {
      e.setCancelled(true);
      
      ItemStack istack = new ItemStack(Material.STICK, 1);
      ItemMeta istackMeta = istack.getItemMeta();
      istackMeta.setDisplayName("§cSchwert-Stock");
      istackMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
      
      istack.setItemMeta(istackMeta);
      
      ItemStack istack2 = new ItemStack(Material.WOOD_SWORD, 1);
      ItemMeta istackMeta2 = istack.getItemMeta();
      istackMeta2.setDisplayName("§6Schwert I");
      
      istack2.setItemMeta(istackMeta2);
      
      ItemStack istack3 = new ItemStack(Material.GOLD_SWORD, 1);
      ItemMeta istackMeta3 = istack.getItemMeta();
      istackMeta3.setDisplayName("§6Schwert II");
      istackMeta3.addEnchant(Enchantment.DURABILITY, 1, true);
      
      istack3.setItemMeta(istackMeta3);
      
      ItemStack istack4 = new ItemStack(Material.STONE_SWORD, 1);
      ItemMeta istackMeta4 = istack.getItemMeta();
      istackMeta4.setDisplayName("§6Schwert III");
      istackMeta4.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
      
      istack4.setItemMeta(istackMeta4);
      
      ItemStack istack41 = new ItemStack(Material.GOLD_SWORD, 1);
      ItemMeta istackMeta41 = istack.getItemMeta();
      istackMeta41.setDisplayName("§6Schwert IV");
      istackMeta41.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
      istackMeta41.addEnchant(Enchantment.DURABILITY, 2, true);
      
      istack41.setItemMeta(istackMeta41);
      
      ItemStack istack411 = new ItemStack(Material.IRON_SWORD, 1);
      ItemMeta istackMeta411 = istack.getItemMeta();
      istackMeta411.setDisplayName("§6Schwert V");
      istack411.setItemMeta(istackMeta411);
      istackMeta411.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
      istackMeta411.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
      istackMeta411.addEnchant(Enchantment.KNOCKBACK, 1, true);
      
      istack411.setItemMeta(istackMeta411);
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§cSchwert-Stock") {
        if (p.getLevel() >= 5)
        {
          p.getInventory().addItem(new ItemStack[] { istack });
          p.setLevel(p.getLevel() - 5);
          e.getView().close();
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.getView().close();
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Schwert I") {
        if (p.getLevel() >= 20)
        {
          p.getInventory().addItem(new ItemStack[] { istack2 });
          p.setLevel(p.getLevel() - 20);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Schwert II") {
        if (p.getLevel() >= 40)
        {
          p.getInventory().addItem(new ItemStack[] { istack3 });
          p.setLevel(p.getLevel() - 40);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Schwert III") {
        if (p.getLevel() >= 75)
        {
          p.getInventory().addItem(new ItemStack[] { istack4 });
          p.setLevel(p.getLevel() - 75);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Schwert IV") {
        if (p.getLevel() >= 115)
        {
          p.getInventory().addItem(new ItemStack[] { istack41 });
          p.setLevel(p.getLevel() - 115);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Schwert V") {
        if (p.getLevel() >= 250)
        {
          p.getInventory().addItem(new ItemStack[] { istack411 });
          p.setLevel(p.getLevel() - 250);
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
