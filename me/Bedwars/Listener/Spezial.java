package me.Bedwars.Listener;

import me.Bedwars.Main;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Spezial
  implements Listener
{
  @EventHandler
  public void Inventorsy(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getName().equalsIgnoreCase("§6Spezial"))
    {
      e.setCancelled(true);
      
      ItemStack sonst111 = new ItemStack(Material.BLAZE_ROD, 1);
      ItemMeta sonstmeta111 = sonst111.getItemMeta();
      sonstmeta111.setDisplayName("§6Rettungsplattform");
      
      sonst111.setItemMeta(sonstmeta111);
      
      ItemStack sonst1111 = new ItemStack(Material.SULPHUR, 1);
      ItemMeta sonstmeta1111 = sonst1111.getItemMeta();
      sonstmeta1111.setDisplayName("§6Base-Teleport");
      
      sonst1111.setItemMeta(sonstmeta1111);
      
      ItemStack sonst11111 = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
      SkullMeta sonstmeta11111 = (SkullMeta)sonst11111.getItemMeta();
      sonstmeta11111.setDisplayName("§6Mobiler-Drogendealer");
      sonstmeta11111.setOwner("Tom_tomi14");
      
      sonst11111.setItemMeta(sonstmeta11111);
      
      ItemStack sonst111111 = new ItemStack(Material.FEATHER, 1);
      ItemMeta sonstmeta111111 = sonst111111.getItemMeta();
      sonstmeta111111.setDisplayName("§6Fallschirm");
      
      sonst111111.setItemMeta(sonstmeta111111);
      
      ItemStack sonst1111111 = new ItemStack(Material.FIREBALL, 1);
      ItemMeta sonstmeta1111111 = sonst1111111.getItemMeta();
      sonstmeta1111111.setDisplayName("§6Bombenangriff");
      
      sonst1111111.setItemMeta(sonstmeta1111111);
      
      ItemStack sonst11111111 = new ItemStack(Material.MONSTER_EGG, 1, (short)95);
      ItemMeta sonstmeta11111111 = sonst11111111.getItemMeta();
      sonstmeta11111111.setDisplayName("§6Wolf");
      
      sonst11111111.setItemMeta(sonstmeta11111111);
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Rettungsplattform") {
        if (p.getLevel() >= 100)
        {
          p.getInventory().addItem(new ItemStack[] { sonst111 });
          p.setLevel(p.getLevel() - 100);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Base-Teleport") {
        if (p.getLevel() >= 115)
        {
          p.getInventory().addItem(new ItemStack[] { sonst1111 });
          p.setLevel(p.getLevel() - 115);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Mobiler-Drogendealer") {
        if (p.getLevel() >= 75)
        {
          p.getInventory().addItem(new ItemStack[] { sonst11111 });
          p.setLevel(p.getLevel() - 75);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Fallschirm") {
        if (p.getLevel() >= 135)
        {
          p.getInventory().addItem(new ItemStack[] { sonst111111 });
          p.setLevel(p.getLevel() - 135);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Bombenangriff") {
        if (p.getLevel() >= 300)
        {
          p.getInventory().addItem(new ItemStack[] { sonst1111111 });
          p.setLevel(p.getLevel() - 300);
          e.setCancelled(true);
        }
        else
        {
          p.sendMessage(Main.prefix + "§cNicht genug Level!");
          e.setCancelled(true);
        }
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§6Wolf") {
        if (p.getLevel() >= 180)
        {
          p.getInventory().addItem(new ItemStack[] { sonst11111111 });
          p.setLevel(p.getLevel() - 180);
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
