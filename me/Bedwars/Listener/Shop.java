package me.Bedwars.Listener;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import me.Bedwars.Data.Data;
import me.Bedwars.GameStatus.GameStatus;
import me.Bedwars.Main;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.SkullType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scoreboard.Team;

public class Shop
  implements Listener
{
  @EventHandler
  public void onE(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof ArmorStand)) && ((e.getDamager() instanceof Arrow))) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onEs(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof ArmorStand)) && ((e.getDamager() instanceof Player))) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onInteractwithBslau(PlayerInteractAtEntityEvent e)
  {
    e.setCancelled(true);
  }
  
  @EventHandler
  public void onInteractwithBlau(PlayerInteractAtEntityEvent e)
  {
    if ((Data.status == GameStatus.LOBBY) && 
      (e.getRightClicked().getType() == EntityType.ARMOR_STAND) && (e.getRightClicked().getCustomName().equals("§9Team Blau")))
    {
      e.setCancelled(true);
      

      Player p = e.getPlayer();
      if (Data.blau.contains(p))
      {
        p.sendMessage(Data.prefix + "§c Du bist schon in diesem Team!");
        return;
      }
      if (canJoin("blue"))
      {
        p.sendMessage(Data.prefix + "§5 Du bist nun im Team §9Blau");
        Data.rot.remove(p);
        Data.blau.remove(p);
        Data.blau.add(p);
        Data.noteam.remove(p);
        if (Main.teamr.hasPlayer(p)) {
          Main.teamr.removePlayer(p);
        }
        Main.teamb.addPlayer(p);
      }
      else
      {
        p.sendMessage(Data.prefix + " §cDieses Team ist bereits voll!");
      }
    }
  }
  
  @EventHandler
  public void onInteractwithBlaus(PlayerInteractAtEntityEvent e)
  {
    if ((e.getRightClicked().getType() == EntityType.ARMOR_STAND) && (e.getRightClicked().getCustomName().equals("§cTeam Rot")) && 
      (Data.status == GameStatus.LOBBY))
    {
      e.setCancelled(true);
      
      Player p = e.getPlayer();
      if (Data.rot.contains(p))
      {
        p.sendMessage(Data.prefix + "§c Du bist schon in diesem Team!");
        return;
      }
      if (canJoin("red"))
      {
        p.sendMessage(Data.prefix + "§5 Du bist nun im Team §cRot");
        Data.blau.remove(p);
        Data.rot.remove(p);
        Data.rot.add(p);
        Data.noteam.remove(p);
        if (Main.teamb.hasPlayer(p)) {
          Main.teamb.removePlayer(p);
        }
        Main.teamr.addPlayer(p);
      }
      else
      {
        p.sendMessage(Data.prefix + " §cDieses Team ist bereits voll!");
      }
    }
  }
  
  public boolean canJoin(String team)
  {
    double maxSize = 0.0D;
    double anzTeams = 2.0D;
    if (Bukkit.getOnlinePlayers().size() % anzTeams == 0.0D) {
      maxSize = Bukkit.getOnlinePlayers().size() / anzTeams;
    } else {
      maxSize = Math.floor(Bukkit.getOnlinePlayers().size() / anzTeams) + 1.0D;
    }
    if ((team.equalsIgnoreCase("red")) && (Data.rot.size() < maxSize)) {
      return true;
    }
    if ((team.equalsIgnoreCase("blue")) && (Data.blau.size() < maxSize)) {
      return true;
    }
    return false;
  }
  
  @EventHandler
  public void onInteract(PlayerInteractAtEntityEvent e)
  {
    if ((e.getRightClicked().getType() == EntityType.ARMOR_STAND) && (e.getRightClicked().getCustomName().startsWith("§6Drogendealer")))
    {
      e.setCancelled(true);
      Player p = e.getPlayer();
      
      ItemStack essen = new ItemStack(Material.APPLE, 1);
      ItemMeta essenmeta = essen.getItemMeta();
      essenmeta.setDisplayName("§5Essen");
      essen.setItemMeta(essenmeta);
      
      ItemStack essen1 = new ItemStack(Material.SANDSTONE, 1);
      ItemMeta essenmeta1 = essen1.getItemMeta();
      essenmeta1.setDisplayName("§5Baumaterialien");
      essen1.setItemMeta(essenmeta1);
      
      ItemStack essen11 = new ItemStack(Material.BOW, 1);
      ItemMeta essenmeta11 = essen11.getItemMeta();
      essenmeta11.setDisplayName("§5Bögen");
      essen11.setItemMeta(essenmeta11);
      
      ItemStack essen111 = new ItemStack(Material.GOLD_SWORD, 1);
      ItemMeta essenmeta111 = essen111.getItemMeta();
      essenmeta111.setDisplayName("§5Schwerter");
      essen111.setItemMeta(essenmeta111);
      
      ItemStack essen1111 = new ItemStack(Material.ENDER_PEARL, 1);
      ItemMeta essenmeta1111 = essen1111.getItemMeta();
      essenmeta1111.setDisplayName("§5Sonstiges");
      essen1111.setItemMeta(essenmeta1111);
      
      ItemStack essen11111 = new ItemStack(Material.POTION, 1);
      ItemMeta essenmeta11111 = essen11111.getItemMeta();
      essenmeta11111.setDisplayName("§5Tränke");
      essen11111.setItemMeta(essenmeta11111);
      
      ItemStack essen111111 = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
      ItemMeta essenmeta111111 = essen111111.getItemMeta();
      essenmeta111111.setDisplayName("§5Rüstung");
      essen111111.setItemMeta(essenmeta111111);
      

      ItemStack essen1111111 = new ItemStack(Material.IRON_PICKAXE, 1);
      ItemMeta essenmeta1111111 = essen1111111.getItemMeta();
      essenmeta1111111.setDisplayName("§5Spitzhacken");
      essen1111111.setItemMeta(essenmeta1111111);
      
      ItemStack sonst11111 = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
      SkullMeta sonstmeta11111 = (SkullMeta)sonst11111.getItemMeta();
      sonstmeta11111.setDisplayName("§5Spezial");
      sonstmeta11111.setOwner("Tom_tomi14");
      sonst11111.setItemMeta(sonstmeta11111);
      
      Inventory inv40 = p.getPlayer().getServer().createInventory(null, 9, "§8SHOP");
      
      inv40.setItem(0, essen);
      inv40.setItem(1, essen1);
      inv40.setItem(2, essen11);
      inv40.setItem(3, essen111);
      inv40.setItem(4, essen1111);
      inv40.setItem(5, essen11111);
      inv40.setItem(6, essen111111);
      inv40.setItem(7, essen1111111);
      inv40.setItem(8, sonst11111);
      p.openInventory(inv40);
    }
  }
  
  @EventHandler
  public void onClickBauMaterial(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getName().equalsIgnoreCase("§8SHOP"))
    {
      e.setCancelled(true);
      

      ItemStack block = new ItemStack(Material.SANDSTONE, 15, (short)1);
      ItemMeta blockmeta = block.getItemMeta();
      blockmeta.setDisplayName("§615 Sandstein");
      blockmeta.setLore(Arrays.asList(new String[] { "§8Kosten:§c 20 Level" }));
      block.setItemMeta(blockmeta);
      
      ItemStack block1 = new ItemStack(Material.SANDSTONE, 30, (short)1);
      ItemMeta blockmeta1 = block1.getItemMeta();
      blockmeta1.setDisplayName("§630 Sandstein");
      blockmeta1.setLore(Arrays.asList(new String[] { "§8Kosten:§c 35 Level" }));
      block1.setItemMeta(blockmeta1);
      
      ItemStack block11 = new ItemStack(Material.SANDSTONE, 64, (short)1);
      ItemMeta blockmeta11 = block11.getItemMeta();
      blockmeta11.setDisplayName("§664 Sandstein");
      blockmeta11.setLore(Arrays.asList(new String[] { "§8Kosten:§c 60 Level" }));
      block11.setItemMeta(blockmeta11);
      
      ItemStack block111 = new ItemStack(Material.ENDER_STONE, 10);
      ItemMeta blockmeta111 = block111.getItemMeta();
      blockmeta111.setDisplayName("§610 Endstein");
      blockmeta111.setLore(Arrays.asList(new String[] { "§8Kosten:§c 50 Level" }));
      block111.setItemMeta(blockmeta111);
      
      ItemStack block1111 = new ItemStack(Material.CHEST, 1);
      ItemMeta blockmeta1111 = block1111.getItemMeta();
      blockmeta1111.setDisplayName("§61 Kiste");
      blockmeta1111.setLore(Arrays.asList(new String[] { "§8Kosten:§c 65 Level" }));
      block1111.setItemMeta(blockmeta1111);
      
      ItemStack block11111 = new ItemStack(Material.WEB, 1);
      ItemMeta blockmeta11111 = block11111.getItemMeta();
      blockmeta11111.setDisplayName("§61 Netz");
      blockmeta11111.setLore(Arrays.asList(new String[] { "§8Kosten:§c 20 Level" }));
      block11111.setItemMeta(blockmeta11111);
      


      ItemStack istack = new ItemStack(Material.STICK, 1);
      ItemMeta istackMeta = istack.getItemMeta();
      istackMeta.setDisplayName("§cSchwert-Stock");
      istackMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
      istackMeta.setLore(Arrays.asList(new String[] { "§8Kosten: §c5 Level" }));
      istack.setItemMeta(istackMeta);
      
      ItemStack istack2 = new ItemStack(Material.WOOD_SWORD, 1);
      ItemMeta istackMeta2 = istack.getItemMeta();
      istackMeta2.setDisplayName("§6Schwert I");
      istackMeta2.setLore(Arrays.asList(new String[] { "§8Kosten: §c20 Level" }));
      istack2.setItemMeta(istackMeta2);
      
      ItemStack istack3 = new ItemStack(Material.GOLD_SWORD, 1);
      ItemMeta istackMeta3 = istack.getItemMeta();
      istackMeta3.setDisplayName("§6Schwert II");
      istackMeta3.addEnchant(Enchantment.DURABILITY, 1, true);
      istackMeta3.setLore(Arrays.asList(new String[] { "§8Kosten: §c40 Level" }));
      istack3.setItemMeta(istackMeta3);
      
      ItemStack istack4 = new ItemStack(Material.STONE_SWORD, 1);
      ItemMeta istackMeta4 = istack.getItemMeta();
      istackMeta4.setDisplayName("§6Schwert III");
      istackMeta4.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
      istackMeta4.setLore(Arrays.asList(new String[] { "§8Kosten: §c75 Level" }));
      istack4.setItemMeta(istackMeta4);
      
      ItemStack istack41 = new ItemStack(Material.GOLD_SWORD, 1);
      ItemMeta istackMeta41 = istack.getItemMeta();
      istackMeta41.setDisplayName("§6Schwert IV");
      istackMeta41.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
      istackMeta41.addEnchant(Enchantment.DURABILITY, 2, true);
      istackMeta41.setLore(Arrays.asList(new String[] { "§8Kosten: §c115 Level" }));
      istack41.setItemMeta(istackMeta41);
      
      ItemStack istack411 = new ItemStack(Material.IRON_SWORD, 1);
      ItemMeta istackMeta411 = istack.getItemMeta();
      istackMeta411.setDisplayName("§6Schwert V");
      istack411.setItemMeta(istackMeta411);
      istackMeta411.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
      istackMeta411.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
      istackMeta411.addEnchant(Enchantment.KNOCKBACK, 1, true);
      istackMeta411.setLore(Arrays.asList(new String[] { "§8Kosten: §c250 Level" }));
      istack411.setItemMeta(istackMeta411);
      



      ItemStack bogen = new ItemStack(Material.BOW, 1);
      ItemMeta bogenmeta = bogen.getItemMeta();
      bogenmeta.setDisplayName("§6Bogen I");
      bogenmeta.setLore(Arrays.asList(new String[] { "§8Kosten§c: 150 Level" }));
      bogenmeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
      bogen.setItemMeta(bogenmeta);
      
      ItemStack bogen1 = new ItemStack(Material.BOW, 1);
      ItemMeta bogenmeta1 = bogen1.getItemMeta();
      bogenmeta1.setDisplayName("§6Bogen II");
      bogenmeta1.setLore(Arrays.asList(new String[] { "§8Kosten§c: 205 Level" }));
      bogenmeta1.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
      bogenmeta1.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
      bogen1.setItemMeta(bogenmeta1);
      
      ItemStack bogen11 = new ItemStack(Material.BOW, 1);
      ItemMeta bogenmeta11 = bogen11.getItemMeta();
      bogenmeta11.setDisplayName("§6Bogen III");
      bogenmeta11.setLore(Arrays.asList(new String[] { "§8Kosten§c: 300 Level" }));
      bogenmeta11.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
      bogenmeta11.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
      bogenmeta11.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
      bogen11.setItemMeta(bogenmeta11);
      
      ItemStack bogen111 = new ItemStack(Material.BOW, 1);
      ItemMeta bogenmeta111 = bogen111.getItemMeta();
      bogenmeta111.setDisplayName("§6Bogen IV");
      bogenmeta111.setLore(Arrays.asList(new String[] { "§8Kosten§c: 450 Level" }));
      bogenmeta111.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
      bogenmeta111.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
      bogenmeta111.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
      bogenmeta111.addEnchant(Enchantment.ARROW_FIRE, 1, true);
      bogen111.setItemMeta(bogenmeta111);
      
      ItemStack bogen1111 = new ItemStack(Material.ARROW, 1);
      ItemMeta bogenmeta1111 = bogen1111.getItemMeta();
      bogenmeta1111.setDisplayName("§6Pfeil");
      bogenmeta1111.setLore(Arrays.asList(new String[] { "§8Kosten§c: 25 Level" }));
      bogen1111.setItemMeta(bogenmeta1111);
      

      ItemStack sonst111 = new ItemStack(Material.BLAZE_ROD, 1);
      ItemMeta sonstmeta111 = sonst111.getItemMeta();
      sonstmeta111.setDisplayName("§6Rettungsplattform");
      sonstmeta111.setLore(Arrays.asList(new String[] { "§8Kosten:§c 100 Level" }));
      sonst111.setItemMeta(sonstmeta111);
      
      ItemStack sonst1111 = new ItemStack(Material.SULPHUR, 1);
      ItemMeta sonstmeta1111 = sonst1111.getItemMeta();
      sonstmeta1111.setDisplayName("§6Base-Teleport");
      sonstmeta1111.setLore(Arrays.asList(new String[] { "§8Kosten:§c 115 Level" }));
      sonst1111.setItemMeta(sonstmeta1111);
      
      ItemStack sonst11111 = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
      SkullMeta sonstmeta11111 = (SkullMeta)sonst11111.getItemMeta();
      sonstmeta11111.setDisplayName("§6Mobiler-Drogendealer");
      sonstmeta11111.setOwner("Tom_tomi14");
      sonstmeta11111.setLore(Arrays.asList(new String[] { "§8Kosten:§c 75 Level" }));
      sonst11111.setItemMeta(sonstmeta11111);
      
      ItemStack sonst111111 = new ItemStack(Material.FEATHER, 1);
      ItemMeta sonstmeta111111 = sonst111111.getItemMeta();
      sonstmeta111111.setDisplayName("§6Fallschirm");
      sonstmeta111111.setLore(Arrays.asList(new String[] { "§8Kosten:§c 135 Level" }));
      sonst111111.setItemMeta(sonstmeta111111);
      
      ItemStack sonst1111111 = new ItemStack(Material.FIREBALL, 1);
      ItemMeta sonstmeta1111111 = sonst1111111.getItemMeta();
      sonstmeta1111111.setDisplayName("§6Bombenangriff");
      sonstmeta1111111.setLore(Arrays.asList(new String[] { "§8Kosten:§c 300 Level" }));
      sonst1111111.setItemMeta(sonstmeta1111111);
      
      ItemStack sonst11111111 = new ItemStack(Material.MONSTER_EGG, 1, (short)95);
      ItemMeta sonstmeta11111111 = sonst11111111.getItemMeta();
      sonstmeta11111111.setDisplayName("§6Wolf");
      sonstmeta11111111.setLore(Arrays.asList(new String[] { "§8Kosten:§c 180 Level" }));
      sonst11111111.setItemMeta(sonstmeta11111111);
      

      ItemStack tränke = new ItemStack(Material.POTION, 1, (short)8201);
      ItemMeta tränkemeta = tränke.getItemMeta();
      tränkemeta.setDisplayName("§6Stärke Trank");
      tränkemeta.setLore(Arrays.asList(new String[] { "§8Kosten:§c 400 level" }));
      tränke.setItemMeta(tränkemeta);
      
      ItemStack tränke1 = new ItemStack(Material.POTION, 1, (short)8257);
      ItemMeta tränkemeta1 = tränke1.getItemMeta();
      tränkemeta1.setDisplayName("§6Regenerations Trank");
      tränkemeta1.setLore(Arrays.asList(new String[] { "§8Kosten:§c 150 level" }));
      tränke1.setItemMeta(tränkemeta1);
      
      ItemStack tränke11 = new ItemStack(Material.POTION, 1, (short)8258);
      ItemMeta tränkemeta11 = tränke11.getItemMeta();
      tränkemeta11.setDisplayName("§6Schnelligkeits Trank");
      tränkemeta11.setLore(Arrays.asList(new String[] { "§8Kosten:§c 150 level" }));
      tränke11.setItemMeta(tränkemeta11);
      

      ItemStack hacke = new ItemStack(Material.WOOD_PICKAXE, 1);
      ItemMeta hackemeta = hacke.getItemMeta();
      hackemeta.setDisplayName("§6Spitzhacke I");
      hackemeta.setLore(Arrays.asList(new String[] { "§8Kosten:§c 25 Level" }));
      hacke.setItemMeta(hackemeta);
      
      ItemStack hacke1 = new ItemStack(Material.STONE_PICKAXE, 1);
      ItemMeta hackemeta1 = hacke1.getItemMeta();
      hackemeta1.setDisplayName("§6Spitzhacke II");
      hackemeta1.setLore(Arrays.asList(new String[] { "§8Kosten:§c 50 Level" }));
      hacke1.setItemMeta(hackemeta1);
      
      ItemStack hacke11 = new ItemStack(Material.IRON_PICKAXE, 1);
      ItemMeta hackemeta11 = hacke11.getItemMeta();
      hackemeta11.setDisplayName("§6Spitzhacke III");
      hackemeta11.setLore(Arrays.asList(new String[] { "§8Kosten:§c 75 Level" }));
      hacke11.setItemMeta(hackemeta11);
      

      ItemStack sonst = new ItemStack(Material.SNOW_BALL, 16);
      ItemMeta sonstmeta = sonst.getItemMeta();
      sonstmeta.setDisplayName("§6Schneeball");
      sonstmeta.setLore(Arrays.asList(new String[] { "§8Kosten:§c 35 Level" }));
      sonst.setItemMeta(sonstmeta);
      
      ItemStack sonst1 = new ItemStack(Material.ENDER_PEARL, 1);
      ItemMeta sonstmeta1 = sonst1.getItemMeta();
      sonstmeta1.setDisplayName("§6Enderperle");
      sonstmeta1.setLore(Arrays.asList(new String[] { "§8Kosten:§c 500 Level" }));
      sonst1.setItemMeta(sonstmeta1);
      
      ItemStack sonst11 = new ItemStack(Material.LADDER, 5);
      ItemMeta sonstmeta11 = sonst11.getItemMeta();
      sonstmeta11.setDisplayName("§6Leiter");
      sonstmeta11.setLore(Arrays.asList(new String[] { "§8Kosten:§c 10 Level" }));
      sonst11.setItemMeta(sonstmeta11);
      




      ItemStack essen = new ItemStack(Material.APPLE, 3);
      ItemMeta essenmeta = essen.getItemMeta();
      essenmeta.setDisplayName("§6Apfel");
      essenmeta.setLore(Arrays.asList(new String[] { "§8Kosten:§c 5 Level" }));
      essen.setItemMeta(essenmeta);
      
      ItemStack essen1 = new ItemStack(Material.COOKED_BEEF, 1);
      ItemMeta essenmeta1 = essen1.getItemMeta();
      essenmeta1.setDisplayName("§6Steak");
      essenmeta1.setLore(Arrays.asList(new String[] { "§8Kosten:§c 5 Level" }));
      essen1.setItemMeta(essenmeta1);
      
      ItemStack essen11 = new ItemStack(Material.CAKE);
      ItemMeta essenmeta11 = essen11.getItemMeta();
      essenmeta11.setDisplayName("§6Kuchen");
      essenmeta11.setLore(Arrays.asList(new String[] { "§8Kosten:§c 10 Level" }));
      essen11.setItemMeta(essenmeta11);
      
      ItemStack essen111 = new ItemStack(Material.GOLDEN_APPLE);
      ItemMeta essenmeta111 = essen111.getItemMeta();
      essenmeta111.setDisplayName("§6Goldener Apfel");
      essenmeta111.setLore(Arrays.asList(new String[] { "§8Kosten:§c 65 Level" }));
      essen111.setItemMeta(essenmeta111);
      

      ItemStack rüssi = new ItemStack(Material.LEATHER_HELMET);
      LeatherArmorMeta rüssimeta = (LeatherArmorMeta)rüssi.getItemMeta();
      rüssimeta.setDisplayName("§6Helm");
      rüssimeta.setLore(Arrays.asList(new String[] { "§8Kosten:§c 5 Level" }));
      rüssi.setItemMeta(rüssimeta);
      
      ItemStack rüssi1 = new ItemStack(Material.LEATHER_LEGGINGS);
      LeatherArmorMeta rüssimeta1 = (LeatherArmorMeta)rüssi1.getItemMeta();
      rüssimeta1.setDisplayName("§6Hose");
      rüssimeta1.setLore(Arrays.asList(new String[] { "§8Kosten:§c 5 Level" }));
      rüssi1.setItemMeta(rüssimeta1);
      
      ItemStack rüssi11 = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta rüssimeta11 = (LeatherArmorMeta)rüssi11.getItemMeta();
      rüssimeta11.setDisplayName("§6Brustplatte");
      rüssimeta11.setLore(Arrays.asList(new String[] { "§8Kosten:§c 5 Level" }));
      rüssi11.setItemMeta(rüssimeta11);
      
      ItemStack rüssi111 = new ItemStack(Material.LEATHER_BOOTS);
      LeatherArmorMeta rüssimeta111 = (LeatherArmorMeta)rüssi111.getItemMeta();
      rüssimeta111.setDisplayName("§6Schuhe");
      rüssimeta111.setLore(Arrays.asList(new String[] { "§8Kosten:§c 5 Level" }));
      rüssi111.setItemMeta(rüssimeta111);
      
      ItemStack rüssi1111 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
      ItemMeta rüssimeta1111 = rüssi1111.getItemMeta();
      rüssimeta1111.setDisplayName("§6Rüssi I");
      rüssimeta1111.setLore(Arrays.asList(new String[] { "§8Kosten:§c 75 Level" }));
      rüssimeta1111.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
      rüssi1111.setItemMeta(rüssimeta1111);
      
      ItemStack rüssi11111 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
      ItemMeta rüssimeta11111 = rüssi11111.getItemMeta();
      rüssimeta11111.setDisplayName("§6Rüssi II");
      rüssimeta11111.setLore(Arrays.asList(new String[] { "§8Kosten:§c 150 Level" }));
      rüssimeta11111.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
      rüssi11111.setItemMeta(rüssimeta11111);
      
      ItemStack rüssi111111 = new ItemStack(Material.IRON_CHESTPLATE);
      ItemMeta rüssimeta111111 = rüssi111111.getItemMeta();
      rüssimeta111111.setDisplayName("§6Rüssi III");
      rüssimeta111111.setLore(Arrays.asList(new String[] { "§8Kosten:§c 300 Level" }));
      rüssimeta111111.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
      rüssimeta111111.addEnchant(Enchantment.PROTECTION_PROJECTILE, 3, true);
      rüssi111111.setItemMeta(rüssimeta111111);
      if (e.getCurrentItem().getItemMeta().getDisplayName() == "§5Baumaterialien")
      {
        Inventory inv4 = p.getPlayer().getServer().createInventory(null, 9, "§6Baumaterialien");
        
        inv4.setItem(0, block);
        inv4.setItem(1, block1);
        inv4.setItem(2, block11);
        inv4.setItem(3, block111);
        inv4.setItem(4, block1111);
        inv4.setItem(5, block11111);
        p.openInventory(inv4);
      }
      else if (e.getCurrentItem().getItemMeta().getDisplayName() == "§5Rüstung")
      {
        Inventory inv6 = p.getPlayer().getServer().createInventory(null, 9, "§6Rüstung");
        if (Data.rot.contains(p))
        {
          rüssimeta.setColor(Color.RED);
          rüssimeta1.setColor(Color.RED);
          rüssimeta11.setColor(Color.RED);
          rüssimeta111.setColor(Color.RED);
          rüssi.setItemMeta(rüssimeta);
          rüssi1.setItemMeta(rüssimeta1);
          rüssi11.setItemMeta(rüssimeta11);
          rüssi111.setItemMeta(rüssimeta111);
        }
        else if (Data.blau.contains(p))
        {
          rüssimeta.setColor(Color.BLUE);
          rüssimeta1.setColor(Color.BLUE);
          rüssimeta11.setColor(Color.BLUE);
          rüssimeta111.setColor(Color.BLUE);
          rüssi.setItemMeta(rüssimeta);
          rüssi1.setItemMeta(rüssimeta1);
          rüssi11.setItemMeta(rüssimeta11);
          rüssi111.setItemMeta(rüssimeta111);
        }
        inv6.setItem(0, rüssi);
        inv6.setItem(1, rüssi11);
        inv6.setItem(2, rüssi1);
        inv6.setItem(3, rüssi111);
        inv6.setItem(4, rüssi1111);
        inv6.setItem(5, rüssi11111);
        inv6.setItem(6, rüssi111111);
        p.openInventory(inv6);
      }
      else if (e.getCurrentItem().getItemMeta().getDisplayName() == "§5Schwerter")
      {
        Inventory inv5 = p.getPlayer().getServer().createInventory(null, 9, "§6Schwerter");
        

        inv5.setItem(0, istack);
        inv5.setItem(1, istack2);
        inv5.setItem(2, istack3);
        inv5.setItem(3, istack4);
        inv5.setItem(4, istack41);
        inv5.setItem(5, istack411);
        
        p.openInventory(inv5);
      }
      else if (e.getCurrentItem().getItemMeta().getDisplayName() == "§5Bögen")
      {
        Inventory inv7 = p.getPlayer().getServer().createInventory(null, 9, "§6Bögen");
        inv7.setItem(0, bogen);
        inv7.setItem(1, bogen1);
        inv7.setItem(2, bogen11);
        inv7.setItem(3, bogen111);
        inv7.setItem(3, bogen1111);
        
        p.openInventory(inv7);
      }
      else if (e.getCurrentItem().getItemMeta().getDisplayName() == "§5Tränke")
      {
        Inventory inv8 = p.getPlayer().getServer().createInventory(null, 9, "§6Tränke");
        inv8.setItem(0, tränke);
        inv8.setItem(1, tränke1);
        inv8.setItem(2, tränke11);
        
        p.openInventory(inv8);
      }
      else if (e.getCurrentItem().getItemMeta().getDisplayName() == "§5Essen")
      {
        Inventory inv9 = p.getPlayer().getServer().createInventory(null, 9, "§6Essen");
        inv9.setItem(0, essen);
        inv9.setItem(1, essen1);
        inv9.setItem(2, essen11);
        inv9.setItem(3, essen111);
        
        p.openInventory(inv9);
      }
      else if (e.getCurrentItem().getItemMeta().getDisplayName() == "§5Sonstiges")
      {
        Inventory inv10 = p.getPlayer().getServer().createInventory(null, 9, "§6Sonstiges");
        
        inv10.setItem(0, sonst);
        inv10.setItem(1, sonst1);
        inv10.setItem(2, sonst11);
        

        p.openInventory(inv10);
      }
      else if (e.getCurrentItem().getItemMeta().getDisplayName() == "§5Spezial")
      {
        Inventory inv111 = p.getPlayer().getServer().createInventory(null, 9, "§6Spezial");
        

        inv111.setItem(0, sonst111);
        inv111.setItem(1, sonst1111);
        inv111.setItem(2, sonst11111);
        inv111.setItem(3, sonst111111);
        inv111.setItem(4, sonst1111111);
        inv111.setItem(5, sonst11111111);
        p.openInventory(inv111);
      }
      else if (e.getCurrentItem().getItemMeta().getDisplayName() == "§5Spitzhacken")
      {
        Inventory inv11 = p.getPlayer().getServer().createInventory(null, 9, "§6Spitzhacken");
        inv11.setItem(0, hacke);
        inv11.setItem(1, hacke1);
        inv11.setItem(2, hacke11);
        
        p.openInventory(inv11);
      }
    }
  }
}
