package me.twelvextwelve.fullbright;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;


public final class Fullbright extends JavaPlugin implements Listener  {

@Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(this, this);

}

    @EventHandler
   public void onPlayerJoin(PlayerJoinEvent event) {
        //need to fix
            getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
                if (event.getPlayer().isOnline()) {
                    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                    String effect = "effect give @a night_vision 25555 1";
                    Bukkit.dispatchCommand(console, effect);
                }
            }, 0, 24000);
        }


@EventHandler
//0.0.2 death fix
      public void onRespawn(PlayerRespawnEvent event) {
    BukkitRunnable task = new BukkitRunnable() {
        @Override
        public void run() {
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            String effect = "effect give @a night_vision 25555 1";
            Bukkit.dispatchCommand(console,effect);
        }
    };task.runTaskLater(this, 20 * 2); //2 seconds just to be safe for slower connections (you can use 1 if you like)
    }


}

