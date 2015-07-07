package me.Bedwars.Data;

import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Game
{
  public static ItemStack buildItemStack(Material m, String name)
  {
    ItemStack item = new ItemStack(
      m);
    ItemMeta itemmeta = item.getItemMeta();
    itemmeta.setDisplayName(name);
    item.setItemMeta(itemmeta);
    
    return item;
  }
  
  public static ItemStack buildItemStack(Material type, int ammount, short dmg, byte data, String displayname, List<String> list)
  {
    ItemStack item = new ItemStack(
      type, ammount, dmg, Byte.valueOf(data));
    ItemMeta itemmeta = item.getItemMeta();
    itemmeta.setDisplayName(displayname);
    itemmeta.setLore(list);
    item.setItemMeta(itemmeta);
    
    return item;
  }
}
