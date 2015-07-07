package me.Bedwars.Listener;

import java.util.List;
import me.Bedwars.Data.Data;
import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EntityPlayer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R1.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffectType;

public class RespawnListener
  implements Listener
{
  public void clearPotionEffects(Player p)
  {
    if (p.hasPotionEffect(PotionEffectType.ABSORPTION)) {
      p.removePotionEffect(PotionEffectType.ABSORPTION);
    }
    if (p.hasPotionEffect(PotionEffectType.BLINDNESS)) {
      p.removePotionEffect(PotionEffectType.BLINDNESS);
    }
    if (p.hasPotionEffect(PotionEffectType.CONFUSION)) {
      p.removePotionEffect(PotionEffectType.CONFUSION);
    }
    if (p.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
      p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
    }
    if (p.hasPotionEffect(PotionEffectType.FAST_DIGGING)) {
      p.removePotionEffect(PotionEffectType.FAST_DIGGING);
    }
    if (p.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
      p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
    }
    if (p.hasPotionEffect(PotionEffectType.HARM)) {
      p.removePotionEffect(PotionEffectType.HARM);
    }
    if (p.hasPotionEffect(PotionEffectType.HEAL)) {
      p.removePotionEffect(PotionEffectType.HEAL);
    }
    if (p.hasPotionEffect(PotionEffectType.HEALTH_BOOST)) {
      p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
    }
    if (p.hasPotionEffect(PotionEffectType.HUNGER)) {
      p.removePotionEffect(PotionEffectType.HUNGER);
    }
    if (p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
      p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
    }
    if (p.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
      p.removePotionEffect(PotionEffectType.INVISIBILITY);
    }
    if (p.hasPotionEffect(PotionEffectType.JUMP)) {
      p.removePotionEffect(PotionEffectType.JUMP);
    }
    if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
      p.removePotionEffect(PotionEffectType.NIGHT_VISION);
    }
    if (p.hasPotionEffect(PotionEffectType.POISON)) {
      p.removePotionEffect(PotionEffectType.POISON);
    }
    if (p.hasPotionEffect(PotionEffectType.REGENERATION)) {
      p.removePotionEffect(PotionEffectType.REGENERATION);
    }
    if (p.hasPotionEffect(PotionEffectType.SLOW)) {
      p.removePotionEffect(PotionEffectType.SLOW);
    }
    if (p.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
      p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
    }
    if (p.hasPotionEffect(PotionEffectType.SPEED)) {
      p.removePotionEffect(PotionEffectType.SPEED);
    }
    if (p.hasPotionEffect(PotionEffectType.WATER_BREATHING)) {
      p.removePotionEffect(PotionEffectType.WATER_BREATHING);
    }
    if (p.hasPotionEffect(PotionEffectType.WEAKNESS)) {
      p.removePotionEffect(PotionEffectType.WEAKNESS);
    }
    if (p.hasPotionEffect(PotionEffectType.WITHER)) {
      p.removePotionEffect(PotionEffectType.WITHER);
    }
  }
  
  @EventHandler
  public void onTry(PlayerPickupItemEvent e)
  {
    if (Data.spec.contains(e.getPlayer())) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void on(PlayerRespawnEvent e)
  {
    Player p = e.getPlayer();
    
    clearPotionEffects(p);
    if ((!Data.respawn_rot) && (Data.rot.contains(p)))
    {
      Data.blau.remove(p);
      Data.rot.remove(p);
      Data.players.remove(p);
      Data.spec.add(p);
      IChatBaseComponent headertext = 
        ChatSerializer.a("{\"text\":\"§cDu bist\"}");
      PacketPlayOutTitle header = new PacketPlayOutTitle(
        EnumTitleAction.TITLE, headertext);
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(header);
      
      IChatBaseComponent footertext = 
        ChatSerializer.a("{\"text\":\"§causgeschieden\"}");
      PacketPlayOutTitle footer = new PacketPlayOutTitle(
        EnumTitleAction.SUBTITLE, footertext);
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(footer);
      
      PacketPlayOutTitle times = new PacketPlayOutTitle(
        EnumTitleAction.TIMES, null, 20, 60, 20);
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(times);
    }
    PacketPlayOutTitle header;
    if ((!Data.respawn_blau) && (Data.blau.contains(p)))
    {
      Data.blau.remove(p);
      Data.rot.remove(p);
      Data.players.remove(p);
      Data.spec.add(p);
      IChatBaseComponent headertext = 
        ChatSerializer.a("{\"text\":\"§cDu bist\"}");
      header = new PacketPlayOutTitle(
        EnumTitleAction.TITLE, headertext);
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(header);
      
      IChatBaseComponent footertext = 
        ChatSerializer.a("{\"text\":\"§causgeschieden\"}");
      PacketPlayOutTitle footer = new PacketPlayOutTitle(
        EnumTitleAction.SUBTITLE, footertext);
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(footer);
      
      PacketPlayOutTitle times = new PacketPlayOutTitle(
        EnumTitleAction.TIMES, null, 20, 60, 20);
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(times);
    }
    if ((Data.blau.contains(p)) && (Data.respawn_blau))
    {
      e.setRespawnLocation(Data.getLocation("blauspawn"));
      e.getPlayer().teleport(Data.getLocation("blauspawn"));
    }
    if ((Data.rot.contains(p)) && (Data.respawn_rot))
    {
      e.setRespawnLocation(Data.getLocation("rotspawn"));
      e.getPlayer().teleport(Data.getLocation("rotspawn"));
    }
    if ((!Data.blau.contains(p)) && (!Data.rot.contains(p)))
    {
      for (Player all : Bukkit.getOnlinePlayers()) {
        all.hidePlayer(p);
      }
      e.setRespawnLocation(Data.getLocation("zuschauerspawn"));
      
      p.setAllowFlight(true);
      p.setFlying(true);
      p.setGameMode(GameMode.SPECTATOR);
      String blauname = "§7" + p.getName();
      if (blauname.length() > 16)
      {
        int i = blauname.length() - 16;
        blauname = blauname.substring(0, blauname.length() - i);
        p.setPlayerListName(blauname);
      }
    }
  }
}
