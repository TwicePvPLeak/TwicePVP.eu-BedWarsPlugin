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

public class Baumaterialien
  implements Listener
{
  @EventHandler
  public void Inventory(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getName().equalsIgnoreCase("§6Baumaterialien"))
    {
      e.setCancelled(true);
      
      ItemStack block = new ItemStack(Material.SANDSTONE, 15, (short)1);
      ItemMeta blockmeta = block.getItemMeta();
      blockmeta.setDisplayName("§6Sandstein");
      
      block.setItemMeta(blockmeta);
      
      ItemStack block1 = new ItemStack(Material.SANDSTONE, 30, (short)1);
      ItemMeta blockmeta1 = block1.getItemMeta();
      blockmeta1.setDisplayName("§6Sandstein");
      
      block1.setItemMeta(blockmeta1);
      
      ItemStack block11 = new ItemStack(Material.SANDSTONE, 64, (short)1);
      ItemMeta blockmeta11 = block11.getItemMeta();
      blockmeta11.setDisplayName("§6Sandstein");
      
      block11.setItemMeta(blockmeta11);
      
      ItemStack block111 = new ItemStack(Material.ENDER_STONE, 10);
      ItemMeta blockmeta111 = block111.getItemMeta();
      blockmeta111.setDisplayName("§6Endstein");
      
      block111.setItemMeta(blockmeta111);
      
      ItemStack block1111 = new ItemStack(Material.CHEST, 1);
      ItemMeta blockmeta1111 = block1111.getItemMeta();
      blockmeta1111.setDisplayName("§6Kiste");
      
      block1111.setItemMeta(blockmeta1111);
      
      ItemStack block11111 = new ItemStack(Material.WEB, 1);
      ItemMeta blockmeta11111 = block11111.getItemMeta();
      blockmeta11111.setDisplayName("§6Netz");
      
      block11111.setItemMeta(blockmeta11111);
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§615 Sandstein")
      {
        if (p.getLevel() >= 20)
        {
          p.getInventory().addItem(new ItemStack[] { block });
          p.setLevel(p.getLevel() - 20);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      else if (e.getCurrentItem().getItemMeta().getDisplayName() == "§630 Sandstein")
      {
        if (p.getLevel() >= 35)
        {
          p.getInventory().addItem(new ItemStack[] { block1 });
          p.setLevel(p.getLevel() - 35);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      else if (e.getCurrentItem().getItemMeta().getDisplayName() == "§664 Sandstein")
      {
        if (p.getLevel() >= 60)
        {
          p.getInventory().addItem(new ItemStack[] { block11 });
          p.setLevel(p.getLevel() - 60);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      else if (e.getCurrentItem().getItemMeta().getDisplayName() == "§610 Endstein")
      {
        if (p.getLevel() >= 50)
        {
          p.getInventory().addItem(new ItemStack[] { block111 });
          p.setLevel(p.getLevel() - 50);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      else if (e.getCurrentItem().getItemMeta().getDisplayName() == "§61 Kiste")
      {
        if (p.getLevel() >= 65)
        {
          p.getInventory().addItem(new ItemStack[] { block1111 });
          p.setLevel(p.getLevel() - 65);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      else if (e.getCurrentItem().getItemMeta().getDisplayName() == "§61 Netz") {
        if (p.getLevel() >= 20)
        {
          p.getInventory().addItem(new ItemStack[] { block11111 });
          p.setLevel(p.getLevel() - 20);
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
