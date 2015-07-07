package me.Bedwars.Listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import me.Bedwars.Data.Data;
import me.Bedwars.GameStatus.GameStatus;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class AchievListener
  implements Listener
{
  public static HashMap<UUID, Integer> killstreak = new HashMap();
  public static HashMap<UUID, Integer> todstreak = new HashMap();
  public static HashMap<UUID, Integer> griefer = new HashMap();
  public static HashMap<UUID, Integer> schwarzarbeiter = new HashMap();
  ArrayList<Player> chat1 = new ArrayList();
  ArrayList<Player> chat2 = new ArrayList();
  ArrayList<Player> chat3 = new ArrayList();
  ArrayList<Player> chat4 = new ArrayList();
  ArrayList<Player> chat5 = new ArrayList();
  
  @EventHandler
  public void osn(PlayerDeathEvent e)
  {
    if (e.getEntity().getKiller() != null) {
      killstreak.put(e.getEntity().getKiller().getUniqueId(), 
        Integer.valueOf(((Integer)killstreak.get(e.getEntity().getKiller()
        .getUniqueId())).intValue() + 1));
    }
    if (e.getEntity().getKiller() != null) {
      todstreak.put(e.getEntity().getKiller().getUniqueId(), Integer.valueOf(0));
    }
    killstreak.put(e.getEntity().getUniqueId(), Integer.valueOf(0));
    
    todstreak.put(e.getEntity().getUniqueId(), 
      Integer.valueOf(((Integer)todstreak.get(e.getEntity().getUniqueId())).intValue() + 1));
    if ((e.getEntity().getKiller() != null) && 
      (!e.getEntity().getKiller().hasPermission("achievement.tom")) && 
      (e.getEntity().getName().equals("Tom_tomi14")))
    {
      PermissionsEx.getUser(e.getEntity().getKiller()).addPermission("achievement.tom");
      
      e.getEntity()
        .getKiller()
        .sendMessage(
        "§8§k**********************************************");
      e.getEntity().getKiller().sendMessage("§8");
      e.getEntity()
        .getKiller()
        .sendMessage(
        "§8Errungschaft: §cTom_tomi14 getötet! §a✔");
      e.getEntity().getKiller().sendMessage("§8");
      e.getEntity()
        .getKiller()
        .sendMessage(
        "§8§k**********************************************");
    }
    if (e.getEntity().getKiller() != null) {
      if (!e.getEntity().getKiller().hasPermission("achievement.ersterkill"))
      {
        PermissionsEx.getUser(e.getEntity().getKiller()).addPermission(
          "achievement.ersterkill");
        
        e.getEntity()
          .getKiller()
          .sendMessage(
          "§8§k**********************************************");
        e.getEntity().getKiller().sendMessage("§8");
        e.getEntity().getKiller()
          .sendMessage("§8Errungschaft: §cErster Kill! §a✔");
        e.getEntity().getKiller().sendMessage("§8");
        e.getEntity()
          .getKiller()
          .sendMessage(
          "§8§k**********************************************");
      }
    }
    if (e.getEntity().getKiller() != null) {
      if ((!e.getEntity().getKiller().hasPermission("achievement.killstreak3")) && 
        (((Integer)killstreak.get(e.getEntity().getKiller().getUniqueId())).intValue() == 3))
      {
        PermissionsEx.getUser(e.getEntity().getKiller()).addPermission("achievement.killstreak3");
        e.getEntity()
          .getKiller()
          .sendMessage(
          "§8§k**********************************************");
        e.getEntity().getKiller().sendMessage("§8");
        e.getEntity()
          .getKiller()
          .sendMessage(
          "§8Errungschaft: §c3-er Killstreak! §a✔");
        e.getEntity().getKiller().sendMessage("§8");
        e.getEntity()
          .getKiller()
          .sendMessage(
          "§8§k**********************************************");
      }
    }
    if (e.getEntity().getKiller() != null) {
      if ((!e.getEntity().getKiller().hasPermission("achievement.killstreak7")) && 
        (((Integer)killstreak.get(e.getEntity().getKiller().getUniqueId())).intValue() == 7))
      {
        PermissionsEx.getUser(e.getEntity().getKiller()).addPermission("achievement.killstreak3");
        e.getEntity()
          .getKiller()
          .sendMessage(
          "§8§k**********************************************");
        e.getEntity().getKiller().sendMessage("§8");
        e.getEntity()
          .getKiller()
          .sendMessage(
          "§8Errungschaft: §c7-er Killstreak! §a✔");
        e.getEntity().getKiller().sendMessage("§8");
        e.getEntity()
          .getKiller()
          .sendMessage(
          "§8§k**********************************************");
      }
    }
    if (e.getEntity().getKiller() != null) {
      if ((!e.getEntity().getKiller().hasPermission("achievement.killstreak12")) && 
        (((Integer)killstreak.get(e.getEntity().getKiller().getUniqueId())).intValue() == 12))
      {
        PermissionsEx.getUser(e.getEntity().getKiller()).addPermission("achievement.killstreak3");
        e.getEntity()
          .getKiller()
          .sendMessage(
          "§8§k**********************************************");
        e.getEntity().getKiller().sendMessage("§8");
        e.getEntity()
          .getKiller()
          .sendMessage(
          "§8Errungschaft: §c12-er Killstreak! §a✔");
        e.getEntity().getKiller().sendMessage("§8");
        e.getEntity()
          .getKiller()
          .sendMessage(
          "§8§k**********************************************");
      }
    }
    if ((e.getEntity().getKiller() != null) && 
      (!e.getEntity().getKiller().hasPermission("achievement.raduan")) && 
      (e.getEntity().getName().equals("LordHadow")))
    {
      PermissionsEx.getUser(e.getEntity().getKiller()).addPermission("achievement.raduan");
      
      e.getEntity()
        .getKiller()
        .sendMessage(
        "§8§k**********************************************");
      e.getEntity().getKiller().sendMessage("§8");
      e.getEntity()
        .getKiller()
        .sendMessage(
        "§8Errungschaft: §cLordHadow getötet! §a✔");
      e.getEntity().getKiller().sendMessage("§8");
      e.getEntity()
        .getKiller()
        .sendMessage(
        "§8§k**********************************************");
    }
    if ((!e.getEntity().hasPermission("achievement.todstreak3")) && 
      (((Integer)todstreak.get(e.getEntity().getUniqueId())).intValue() == 3))
    {
      PermissionsEx.getUser(e.getEntity()).addPermission(
        "achievement.todstreak3");
      
      e.getEntity().sendMessage(
        "§8§k**********************************************");
      e.getEntity().sendMessage("§8");
      e.getEntity().sendMessage(
        "§8Errungschaft: §c3 Tode in einer Runde §a✔");
      e.getEntity().sendMessage("§8");
      e.getEntity().sendMessage(
        "§8§k**********************************************");
    }
    if ((!e.getEntity().hasPermission("achievement.todstreak7")) && 
      (((Integer)todstreak.get(e.getEntity().getUniqueId())).intValue() == 7))
    {
      PermissionsEx.getUser(e.getEntity()).addPermission(
        "achievement.todstreak7");
      
      e.getEntity().sendMessage(
        "§8§k**********************************************");
      e.getEntity().sendMessage("§8");
      e.getEntity().sendMessage(
        "§8Errungschaft: §c7 Tode in einer Runde §a✔");
      e.getEntity().sendMessage("§8");
      e.getEntity().sendMessage(
        "§8§k**********************************************");
    }
    if ((!e.getEntity().hasPermission("achievement.todstreak12")) && 
      (((Integer)todstreak.get(e.getEntity().getUniqueId())).intValue() == 12))
    {
      PermissionsEx.getUser(e.getEntity()).addPermission(
        "achievement.todstreak12");
      
      e.getEntity().sendMessage(
        "§8§k**********************************************");
      e.getEntity().sendMessage("§8");
      e.getEntity().sendMessage(
        "§8Errungschaft: §c12 Tode in einer Runde §a✔");
      e.getEntity().sendMessage("§8");
      e.getEntity().sendMessage(
        "§8§k**********************************************");
    }
    if (!e.getEntity().hasPermission("achievement.erstertod"))
    {
      PermissionsEx.getUser(e.getEntity()).addPermission(
        "achievement.erstertod");
      
      e.getEntity().sendMessage(
        "§8§k**********************************************");
      e.getEntity().sendMessage("§8");
      e.getEntity().sendMessage("§8Errungschaft: §cErster Tod §a✔");
      e.getEntity().sendMessage("§8");
      e.getEntity().sendMessage(
        "§8§k**********************************************");
    }
  }
  
  @EventHandler
  public void onPlayerDeath(PlayerDeathEvent e)
  {
    if ((e.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent))
    {
      Entity damager = ((EntityDamageByEntityEvent)e.getEntity().getLastDamageCause()).getDamager();
      if ((damager instanceof Arrow))
      {
        Player i = (Player)((Arrow)damager).getShooter();
        if (!i.hasPermission("achievement.bogen"))
        {
          PermissionsEx.getUser((Player)((Arrow)damager).getShooter()).addPermission("achievement.bogen");
          i.sendMessage("§8§k**********************************************");
          i.sendMessage("§8");
          i.sendMessage("§8Errungschaft: §cBogenschütze! §a✔");
          i.sendMessage("§8");
          i.sendMessage("§8§k**********************************************");
        }
      }
    }
    if ((e.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent))
    {
      Entity damager1 = ((EntityDamageByEntityEvent)e.getEntity()
        .getLastDamageCause()).getDamager();
      if ((damager1 instanceof Snowball))
      {
        Player i = (Player)((Snowball)damager1).getShooter();
        if (!i.hasPermission("achievement.schnee"))
        {
          PermissionsEx.getUser((Player)((Snowball)damager1).getShooter()).addPermission("achievement.schnee");
          i.sendMessage("§8§k**********************************************");
          i.sendMessage("§8");
          i.sendMessage("§8Errungschaft: §cSchneemann! §a✔");
          i.sendMessage("§8");
          i.sendMessage("§8§k**********************************************");
        }
      }
    }
  }
  
  @EventHandler
  public void onBreak(BlockBreakEvent e)
  {
    if (!e.getPlayer().hasPermission("achievement.griefer")) {
      if ((e.getBlock().getType() == Material.SANDSTONE) || 
        (e.getBlock().getType() == Material.ENDER_STONE) || 
        (e.getBlock().getType() == Material.WEB) || 
        (e.getBlock().getType() == Material.CHEST))
      {
        griefer.put(e.getPlayer().getUniqueId(), 
          Integer.valueOf(((Integer)griefer.get(e.getPlayer().getUniqueId())).intValue() + 1));
        if (((Integer)griefer.get(e.getPlayer().getUniqueId())).intValue() == 50)
        {
          PermissionsEx.getUser(e.getPlayer()).addPermission(
            "achievement.griefer");
          
          e.getPlayer()
            .sendMessage(
            "§8§k**********************************************");
          e.getPlayer().sendMessage("§8");
          e.getPlayer().sendMessage("§8Errungschaft: §cGriefer §a✔");
          e.getPlayer().sendMessage("§8");
          e.getPlayer()
            .sendMessage(
            "§8§k**********************************************");
        }
      }
    }
  }
  
  @EventHandler
  public void onArbeiten(BlockPlaceEvent e)
  {
    if (!e.getPlayer().hasPermission("achievement.schwarzarbeiter")) {
      if ((e.getBlock().getType() == Material.SANDSTONE) || 
        (e.getBlock().getType() == Material.ENDER_STONE) || 
        (e.getBlock().getType() == Material.WEB) || 
        (e.getBlock().getType() == Material.CHEST))
      {
        schwarzarbeiter.put(e.getPlayer().getUniqueId(), 
          Integer.valueOf(((Integer)schwarzarbeiter.get(e.getPlayer().getUniqueId())).intValue() + 1));
        if (((Integer)schwarzarbeiter.get(e.getPlayer().getUniqueId())).intValue() == 128)
        {
          PermissionsEx.getUser(e.getPlayer()).addPermission(
            "achievement.schwarzarbeiter");
          
          e.getPlayer()
            .sendMessage(
            "§8§k**********************************************");
          e.getPlayer().sendMessage("§8");
          e.getPlayer().sendMessage(
            "§8Errungschaft: §cSchwarzarbeiter §a✔");
          e.getPlayer().sendMessage("§8");
          e.getPlayer()
            .sendMessage(
            "§8§k**********************************************");
        }
      }
    }
  }
  
  @EventHandler
  public void onEat(PlayerItemConsumeEvent e)
  {
    Player p = e.getPlayer();
    if ((p.getItemInHand().getTypeId() == 322) && 
      (!e.getPlayer().hasPermission("achievement.op")))
    {
      PermissionsEx.getUser(e.getPlayer()).addPermission(
        "achievement.op");
      
      e.getPlayer().sendMessage(
        "§8§k**********************************************");
      e.getPlayer().sendMessage("§8");
      e.getPlayer().sendMessage("§8Errungschaft: §cGET OP! §a✔");
      e.getPlayer().sendMessage("§8");
      e.getPlayer().sendMessage(
        "§8§k**********************************************");
    }
  }
  
  @EventHandler
  public void onChat(AsyncPlayerChatEvent e)
  {
    if ((Data.status == GameStatus.INGAME) && 
      (!e.getPlayer().hasPermission("achievement.spammer")))
    {
      if (this.chat5.contains(e.getPlayer()))
      {
        PermissionsEx.getUser(e.getPlayer()).addPermission(
          "achievement.spammer");
        
        e.getPlayer().sendMessage(
          "§8§k**********************************************");
        e.getPlayer().sendMessage("§8");
        e.getPlayer().sendMessage("§8Errungschaft: §cSpammer §a✔");
        e.getPlayer().sendMessage("§8");
        e.getPlayer().sendMessage(
          "§8§k**********************************************");
      }
      if (this.chat4.contains(e.getPlayer())) {
        this.chat5.add(e.getPlayer());
      }
      if (this.chat3.contains(e.getPlayer())) {
        this.chat4.add(e.getPlayer());
      }
      if (this.chat2.contains(e.getPlayer())) {
        this.chat3.add(e.getPlayer());
      }
      if (this.chat1.contains(e.getPlayer())) {
        this.chat2.add(e.getPlayer());
      }
      this.chat1.add(e.getPlayer());
    }
  }
  
  @EventHandler
  public void onProj(ProjectileLaunchEvent e)
  {
    if ((e.getEntity() instanceof EnderPearl))
    {
      Player p = (Player)e.getEntity().getShooter();
      if (!p.hasPermission("achievement.enderdrache"))
      {
        PermissionsEx.getUser(p).addPermission(
          "achievement.enderdrache");
        
        p.sendMessage("§8§k**********************************************");
        p.sendMessage("§8");
        p.sendMessage("§8Errungschaft: §cEnderdrache §a✔");
        p.sendMessage("§8");
        p.sendMessage("§8§k**********************************************");
      }
    }
  }
  
  @EventHandler
  public void onClickBauMaterial(InventoryClickEvent e)
  {
    if (e.getInventory().getName().equalsIgnoreCase("§eErfolge")) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void on(PlayerInteractEvent e)
  {
    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || 
      (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (Data.status == GameStatus.LOBBY) && 
      (e.getPlayer().getItemInHand().getType() == Material.DIAMOND))
    {
      Inventory inv = Bukkit.createInventory(e.getPlayer(), 27, 
        "§eErfolge");
      e.setCancelled(true);
      if (e.getPlayer().hasPermission("achievement.tom"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§5Tom_tomi14");
        ArrayList<String> list = new ArrayList();
        list.add("§fTöte den Owner Tom_tomi14 §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(0, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(0, item);
      }
      if (e.getPlayer().hasPermission("achievement.killstreak3"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§53-er Killstreak");
        ArrayList<String> list = new ArrayList();
        list.add("§fTöte drei Spieler ohne zu sterben §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(3, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(3, item);
      }
      if (e.getPlayer().hasPermission("achievement.raduan"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§5LordHadow");
        ArrayList<String> list = new ArrayList();
        list.add("§fTöte den Owner LordHadow §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(1, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(1, item);
      }
      if (e.getPlayer().hasPermission("achievement.ersterkill"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§5Erster Kill");
        ArrayList<String> list = new ArrayList();
        list.add("§fTöte einen gegnerischen Spieler §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(2, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(2, item);
      }
      if (e.getPlayer().hasPermission("achievement.killstreak12"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§512-er Killstreak");
        ArrayList<String> list = new ArrayList();
        list.add("§fTöte zwölf Spieler ohne zu sterben §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(5, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(5, item);
      }
      if (e.getPlayer().hasPermission("achievement.todstreak7"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§57 Tode in einer Runde");
        ArrayList<String> list = new ArrayList();
        list.add("§fStirb sieben mal ohne jemanden zu töten §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(7, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(7, item);
      }
      if (e.getPlayer().hasPermission("achievement.killstreak7"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§57-er Killstreak");
        ArrayList<String> list = new ArrayList();
        list.add("§fTöte sieben Spieler ohne zu sterben §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(4, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(4, item);
      }
      if (e.getPlayer().hasPermission("achievement.griefer"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§5Griefer");
        ArrayList<String> list = new ArrayList();
        list.add("§fBau fünfzig Blöcke ab §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(11, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(11, item);
      }
      if (e.getPlayer().hasPermission("achievement.todstreak12"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§512 Tode in einer Runde");
        ArrayList<String> list = new ArrayList();
        list.add("§fStirb zwölf mal ohne jemanden zu töten §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(8, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(8, item);
      }
      if (e.getPlayer().hasPermission("achievement.todstreak3"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§53 Tode in einer Runde");
        ArrayList<String> list = new ArrayList();
        list.add("§fStirb drei mal ohne jemanden zu töten §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(6, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(6, item);
      }
      if (e.getPlayer().hasPermission("achievement.erstertod"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§5Erster Tod");
        ArrayList<String> list = new ArrayList();
        list.add("§fStirb einmal! §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(9, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(9, item);
      }
      if (e.getPlayer().hasPermission("achievement.enderdrache"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§5Enderdrache");
        ArrayList<String> list = new ArrayList();
        list.add("§fWirf eine Enderperle §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(10, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(10, item);
      }
      if (e.getPlayer().hasPermission("achievement.schwarzarbeiter"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§5Schwarzarbeiter");
        ArrayList<String> list = new ArrayList();
        list.add("§fPlatziere zwei Stack Blöcke §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(12, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(12, item);
      }
      if (e.getPlayer().hasPermission("achievement.spammer"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§5Spammer");
        ArrayList<String> list = new ArrayList();
        list.add("§fSchreibe sieben Nachrichten im Teamchat §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(13, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(13, item);
      }
      if (e.getPlayer().hasPermission("achievement.schnee"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§5Schnee");
        ArrayList<String> list = new ArrayList();
        list.add("§fTöte einen Spieler per Schneeball §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(14, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(14, item);
      }
      if (e.getPlayer().hasPermission("achievement.bogen"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§5Bogenschütze");
        ArrayList<String> list = new ArrayList();
        list.add("§fTöte einen Spieler per Pfeil §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(15, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(15, item);
      }
      if (e.getPlayer().hasPermission("achievement.op"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§5GET OP!");
        ArrayList<String> list = new ArrayList();
        list.add("§fIss einen goldenen Apfel §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(16, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(16, item);
      }
      if (e.getPlayer().hasPermission("achievement.erstesspiel"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§5Erstes Spiel");
        ArrayList<String> list = new ArrayList();
        list.add("§fSpiele deine erste Runde Bedwars §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(17, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(17, item);
      }
      if (e.getPlayer().hasPermission("achievement.gelegenheitsspieler"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§5Gelegenheitsspieler");
        ArrayList<String> list = new ArrayList();
        list.add("§fSpiele 15 Runden Bedwars §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(18, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(18, item);
      }
      if (e.getPlayer().hasPermission("achievement.zocker"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§5Zocker");
        ArrayList<String> list = new ArrayList();
        list.add("§fSpiele 50 Runden Bedwars §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(19, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(19, item);
      }
      if (e.getPlayer().hasPermission("achievement.rusher"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§5Rusher");
        ArrayList<String> list = new ArrayList();
        list.add("§fBaue ein gegnerisches Bett ab §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(20, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(20, item);
      }
      if (e.getPlayer().hasPermission("achievement.erstersieg"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§5Erster Sieg");
        ArrayList<String> list = new ArrayList();
        list.add("§fGewinne ein Spiel §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(21, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(21, item);
      }
      if (e.getPlayer().hasPermission("achievement.fortgeschrittener"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§5Fortgeschrittener");
        ArrayList<String> list = new ArrayList();
        list.add("§fGewinne 25 Spiele §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(22, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(22, item);
      }
      if (e.getPlayer().hasPermission("achievement.meister"))
      {
        ItemStack item = new ItemStack(264);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§5Meister");
        ArrayList<String> list = new ArrayList();
        list.add("§fGewinne 50 Spiele §a✔");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(23, item);
      }
      else
      {
        ItemStack item = new ItemStack(Material.IRON_FENCE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§c???");
        ArrayList<String> list = new ArrayList();
        list.add("§c???");
        im.setLore(list);
        item.setItemMeta(im);
        inv.setItem(23, item);
      }
      e.getPlayer().openInventory(inv);
    }
  }
  
  @EventHandler
  public void on(InventoryClickEvent e)
  {
    if (e.getInventory().getName().equals("§eAchievements"))
    {
      e.setCancelled(true);
      e.getWhoClicked().closeInventory();
    }
  }
}
