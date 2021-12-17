package me.twelvextwelve.fullbright;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Fullbright extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }
    @EventHandler
   public void onPlayerJoin(PlayerJoinEvent event) {
       getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
           ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
           String effect = "effect give @a night_vision 25555 1";
           Bukkit.dispatchCommand(console, effect);
       }, 0, 51000);


    }


}
