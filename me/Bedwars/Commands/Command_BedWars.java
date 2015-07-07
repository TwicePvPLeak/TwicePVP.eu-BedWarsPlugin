package me.Bedwars.Commands;

import me.Bedwars.Data.Data;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Command_BedWars
  implements CommandExecutor
{
  public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args)
  {
    Player p = (Player)cs;
    if (p.hasPermission("bedwars.*"))
    {
      if (args.length == 0)
      {
        p.sendMessage("§8Befehl Liste");
        p.sendMessage("§7Alle Befehle sind immer mit §c/setlocation §7danach musst du immer Argumente verwenden!§7Hier liste ich dir alle Argumente auf!");
        

        p.sendMessage("§clobbyspawn, zuschauerspawn, rotspawn, blauspawn, eisenspawnrot, eisenspawnblau,§c bronzespawnrot, bronzespawnblau, goldspawn, bettblau1, bettblau2, bettrot1, bettrot2, villagerspawn, teamblau, teamrot, ranking [1-10]");
      }
      if (args.length == 1)
      {
        if (args[0].equalsIgnoreCase("lobbyspawn"))
        {
          Data.setLocation("lobbyspawn", p.getLocation());
          p.sendMessage("§4Die Location vom -> §clobbyspawn§4 <- wurde abgespeichert!");
        }
        if (args[0].equalsIgnoreCase("villagerspawn"))
        {
          Data.spawnmob = true;
          

          ArmorStand pl = (ArmorStand)p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
          

          ItemStack xd = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
          SkullMeta meta = (SkullMeta)xd.getItemMeta();
          meta.setOwner("Tom_tomi14");
          xd.setItemMeta(meta);
          pl.setHelmet(xd);
          

          pl.setBoots(new ItemStack(Material.LEATHER_BOOTS));
          pl.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
          pl.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
          

          pl.setArms(true);
          

          pl.setVisible(true);
          

          pl.setCustomName("§6Drogendealer");
          

          pl.setCustomNameVisible(true);
          


          Data.spawnmob = false;
        }
        if (args[0].equalsIgnoreCase("teamblau"))
        {
          Data.spawnmob = true;
          
          ArmorStand pl = (ArmorStand)p.getWorld().spawnEntity(
            p.getLocation(), EntityType.ARMOR_STAND);
          
          ItemStack rüssi1 = new ItemStack(Material.LEATHER_LEGGINGS);
          LeatherArmorMeta rüssimeta1 = (LeatherArmorMeta)rüssi1.getItemMeta();
          rüssimeta1.setDisplayName("§6Hose");
          rüssimeta1.setColor(Color.BLUE);
          
          rüssi1.setItemMeta(rüssimeta1);
          
          ItemStack rüssi11 = new ItemStack(
            Material.LEATHER_CHESTPLATE);
          LeatherArmorMeta rüssimeta11 = (LeatherArmorMeta)rüssi11
            .getItemMeta();
          rüssimeta11.setDisplayName("§6Brustplatte");
          rüssimeta11.setColor(Color.BLUE);
          
          rüssi11.setItemMeta(rüssimeta11);
          
          ItemStack rüssi111 = new ItemStack(Material.LEATHER_BOOTS);
          LeatherArmorMeta rüssimeta111 = (LeatherArmorMeta)rüssi111
            .getItemMeta();
          rüssimeta111.setDisplayName("§6Schuhe");
          rüssimeta111.setColor(Color.BLUE);
          
          rüssi111.setItemMeta(rüssimeta111);
          
          pl.setBoots(rüssi111);
          pl.setLeggings(rüssi11);
          pl.setChestplate(rüssi1);
          
          ItemStack xd = new ItemStack(Material.SKULL_ITEM, 1, 
            (short)3);
          SkullMeta meta = (SkullMeta)xd.getItemMeta();
          meta.setOwner("GoldenCharms");
          xd.setItemMeta(meta);
          pl.setHelmet(xd);
          pl.setArms(true);
          pl.setVisible(true);
          pl.setCustomName("§9Team Blau");
          pl.setCustomNameVisible(true);
          Data.spawnmob = false;
        }
        if (args[0].equalsIgnoreCase("teamrot"))
        {
          Data.spawnmob = true;
          
          ArmorStand pl = (ArmorStand)p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
          
          ItemStack rüssi1 = new ItemStack(Material.LEATHER_LEGGINGS);
          LeatherArmorMeta rüssimeta1 = (LeatherArmorMeta)rüssi1.getItemMeta();
          rüssimeta1.setDisplayName("§6Hose");
          rüssimeta1.setColor(Color.RED);
          rüssi1.setItemMeta(rüssimeta1);
          
          ItemStack rüssi11 = new ItemStack(
            Material.LEATHER_CHESTPLATE);
          LeatherArmorMeta rüssimeta11 = (LeatherArmorMeta)rüssi11
            .getItemMeta();
          rüssimeta11.setDisplayName("§6Brustplatte");
          rüssimeta11.setColor(Color.RED);
          
          rüssi11.setItemMeta(rüssimeta11);
          
          ItemStack rüssi111 = new ItemStack(Material.LEATHER_BOOTS);
          LeatherArmorMeta rüssimeta111 = (LeatherArmorMeta)rüssi111
            .getItemMeta();
          rüssimeta111.setDisplayName("§6Schuhe");
          rüssimeta111.setColor(Color.RED);
          
          rüssi111.setItemMeta(rüssimeta111);
          
          pl.setBoots(rüssi111);
          pl.setLeggings(rüssi11);
          pl.setChestplate(rüssi1);
          
          ItemStack xd = new ItemStack(Material.SKULL_ITEM, 1, 
            (short)3);
          SkullMeta meta = (SkullMeta)xd.getItemMeta();
          meta.setOwner("LetsTaddlLP");
          xd.setItemMeta(meta);
          pl.setHelmet(xd);
          pl.setArms(true);
          pl.setVisible(true);
          pl.setCustomName("§cTeam Rot");
          pl.setCustomNameVisible(true);
          Data.spawnmob = false;
        }
        if (args[0].equalsIgnoreCase("zuschauerspawn"))
        {
          Data.setLocation("zuschauerspawn", p.getLocation());
          p.sendMessage("§4Die Location vom -> §czuschauerspawn§4 <- wurde abgespeichert!");
        }
        if (args[0].equalsIgnoreCase("blauspawn"))
        {
          Data.setLocation("blauspawn", p.getLocation());
          p.sendMessage("§4Die Location vom -> §cblauspawn§4 <- wurde abgespeichert!");
        }
        if (args[0].equalsIgnoreCase("rotspawn"))
        {
          Data.setLocation("rotspawn", p.getLocation());
          p.sendMessage("§4Die Location vom -> §crotspawn§4 <- wurde abgespeichert!");
        }
        if (args[0].equalsIgnoreCase("goldspawn"))
        {
          Data.setLocation("goldspawn", p.getLocation());
          p.sendMessage("§4Die Location vom -> §cgoldspawn§4 <- wurde abgespeichert!");
        }
        if (args[0].equalsIgnoreCase("bettblau1"))
        {
          Data.setLocation("bettblau1", p.getLocation());
          Block x = p.getLocation().getBlock();
          x.setType(Material.BED_BLOCK);
          p.sendMessage("§4Die Location vom -> §cbettblau1§4 <- wurde abgespeichert!");
        }
        if (args[0].equalsIgnoreCase("bettblau2"))
        {
          Data.setLocation("bettblau2", p.getLocation());
          Block x = p.getLocation().getBlock();
          x.setType(Material.BED_BLOCK);
          p.sendMessage("§4Die Location vom -> §cbettblau2§4 <- wurde abgespeichert!");
        }
        if (args[0].equalsIgnoreCase("bettrot1"))
        {
          Data.setLocation("bettrot1", p.getLocation());
          Block x = p.getLocation().getBlock();
          x.setType(Material.BED_BLOCK);
          p.sendMessage("§4Die Location vom -> §cbettrot1§4 <- wurde abgespeichert!");
        }
        if (args[0].equalsIgnoreCase("bettrot2"))
        {
          Data.setLocation("bettrot2", p.getLocation());
          Block x = p.getLocation().getBlock();
          x.setType(Material.BED_BLOCK);
          p.sendMessage("§4Die Location vom -> §cbettrot2§4 <- wurde abgespeichert!");
        }
        if (args[0].equalsIgnoreCase("eisenspawnblau"))
        {
          Data.setLocation("eisenspawnblau", p.getLocation());
          p.sendMessage("§4Die Location vom -> §ceisenspawnblau§4 <- wurde abgespeichert!");
        }
        if (args[0].equalsIgnoreCase("eisenspawnrot"))
        {
          Data.setLocation("eisenspawnrot", p.getLocation());
          p.sendMessage("§4Die Location vom -> §ceisenspawnrot§4 <- wurde abgespeichert!");
        }
        if (args[0].equalsIgnoreCase("bronzespawnblau"))
        {
          Data.setLocation("bronzespawnblau", p.getLocation());
          p.sendMessage("§4Die Location vom -> §cbronzwspawnblau§4 <- wurde abgespeichert!");
        }
        if (args[0].equalsIgnoreCase("bronzespawnrot"))
        {
          Data.setLocation("bronzespawnrot", p.getLocation());
          p.sendMessage("§4Die Location vom -> §cbronzespawnrot§4 <- wurde abgespeichert!");
        }
      }
      if ((args.length == 2) && 
        (args[0].equalsIgnoreCase("ranking")))
      {
        Data.setLocation("ranking." + args[1], p.getLocation());
        p.sendMessage("§4Die Location von Ranking " + args[1] + " wurde gesetzt!");
      }
    }
    else
    {
      p.sendMessage(Data.KeineRechte);
    }
    return false;
  }
}
