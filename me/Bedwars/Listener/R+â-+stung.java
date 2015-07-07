package me.Bedwars.Listener;

import java.util.List;
import me.Bedwars.Data.Data;
import me.Bedwars.Main;
import org.bukkit.Color;
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
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Rüstung
  implements Listener
{
  @EventHandler
  public void Inventory(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getName().equalsIgnoreCase("§6Rüstung"))
    {
      e.setCancelled(true);
      
      ItemStack rüssi = new ItemStack(Material.LEATHER_HELMET);
      LeatherArmorMeta rüssimeta = (LeatherArmorMeta)rüssi.getItemMeta();
      rüssimeta.setDisplayName("§6Helm");
      
      rüssi.setItemMeta(rüssimeta);
      
      ItemStack rüssi1 = new ItemStack(Material.LEATHER_LEGGINGS);
      LeatherArmorMeta rüssimeta1 = (LeatherArmorMeta)rüssi1
        .getItemMeta();
      rüssimeta1.setDisplayName("§6Hose");
      
      rüssi1.setItemMeta(rüssimeta1);
      
      ItemStack rüssi11 = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta rüssimeta11 = (LeatherArmorMeta)rüssi11
        .getItemMeta();
      rüssimeta11.setDisplayName("§6Brustplatte");
      
      rüssi11.setItemMeta(rüssimeta11);
      
      ItemStack rüssi111 = new ItemStack(Material.LEATHER_BOOTS);
      LeatherArmorMeta rüssimeta111 = (LeatherArmorMeta)rüssi111
        .getItemMeta();
      rüssimeta111.setDisplayName("§6Schuhe");
      
      rüssi111.setItemMeta(rüssimeta111);
      
      ItemStack rüssi1111 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
      ItemMeta rüssimeta1111 = rüssi1111.getItemMeta();
      rüssimeta1111.setDisplayName("§6Rüssi I");
      
      rüssimeta1111.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, 
        true);
      rüssi1111.setItemMeta(rüssimeta1111);
      
      ItemStack rüssi11111 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
      ItemMeta rüssimeta11111 = rüssi11111.getItemMeta();
      rüssimeta11111.setDisplayName("§6Rüssi II");
      
      rüssimeta11111.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, 
        true);
      rüssi11111.setItemMeta(rüssimeta11111);
      
      ItemStack rüssi111111 = new ItemStack(Material.IRON_CHESTPLATE);
      ItemMeta rüssimeta111111 = rüssi111111.getItemMeta();
      rüssimeta111111.setDisplayName("§6Rüssi III");
      
      rüssimeta111111.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, 
        true);
      rüssimeta111111.addEnchant(Enchantment.PROTECTION_PROJECTILE, 3, 
        true);
      rüssi111111.setItemMeta(rüssimeta111111);
      if (Data.rot.contains(p))
      {
        rüssimeta.setColor(Color.RED);
        rüssimeta1.setColor(Color.RED);
        rüssimeta11.setColor(Color.RED);
        rüssimeta111.setColor(Color.RED);
        
        rüssimeta.setDisplayName("§cHelm");
        rüssimeta1.setDisplayName("§cHose");
        rüssimeta11.setDisplayName("§cBrustplatte");
        rüssimeta111.setDisplayName("§cSchuhe");
        
        rüssi.setItemMeta(rüssimeta);
        rüssi1.setItemMeta(rüssimeta1);
        rüssi11.setItemMeta(rüssimeta11);
        rüssi111.setItemMeta(rüssimeta111);
      }
      if (Data.blau.contains(p))
      {
        rüssimeta.setColor(Color.BLUE);
        rüssimeta1.setColor(Color.BLUE);
        rüssimeta11.setColor(Color.BLUE);
        rüssimeta111.setColor(Color.BLUE);
        
        rüssimeta.setDisplayName("§9Helm");
        rüssimeta1.setDisplayName("§9Hose");
        rüssimeta11.setDisplayName("§9Brustplatte");
        rüssimeta111.setDisplayName("§9Schuhe");
        
        rüssi.setItemMeta(rüssimeta);
        rüssi1.setItemMeta(rüssimeta1);
        rüssi11.setItemMeta(rüssimeta11);
        rüssi111.setItemMeta(rüssimeta111);
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Helm") {
        if (p.getLevel() >= 5)
        {
          p.getInventory().addItem(new ItemStack[] { rüssi });
          p.setLevel(p.getLevel() - 5);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Hose") {
        if (p.getLevel() >= 5)
        {
          p.getInventory().addItem(new ItemStack[] { rüssi1 });
          p.setLevel(p.getLevel() - 5);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Brustplatte") {
        if (p.getLevel() >= 5)
        {
          p.getInventory().addItem(new ItemStack[] { rüssi11 });
          p.setLevel(p.getLevel() - 5);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Schuhe") {
        if (p.getLevel() >= 5)
        {
          p.getInventory().addItem(new ItemStack[] { rüssi111 });
          p.setLevel(p.getLevel() - 5);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Rüssi I") {
        if (p.getLevel() >= 75)
        {
          p.getInventory().addItem(new ItemStack[] { rüssi1111 });
          p.setLevel(p.getLevel() - 75);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Rüssi II") {
        if (p.getLevel() >= 150)
        {
          p.getInventory().addItem(new ItemStack[] { rüssi11111 });
          p.setLevel(p.getLevel() - 150);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Rüssi III") {
        if (p.getLevel() >= 300)
        {
          p.getInventory().addItem(new ItemStack[] { rüssi111111 });
          p.setLevel(p.getLevel() - 300);
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
