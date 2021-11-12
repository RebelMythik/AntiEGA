package rebelmythik.preventenchantedapple;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.EventListener;

public final class Preventenchantedapple extends JavaPlugin implements EventListener, Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this, this);

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent event) {
        if (event.getItem().getType() == Material.ENCHANTED_GOLDEN_APPLE) {
            event.setCancelled(true);
        }
    }
}
