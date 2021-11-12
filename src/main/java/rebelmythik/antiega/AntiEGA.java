package rebelmythik.AntiEGA;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import rebelmythik.AntiEGA.ext;

import java.util.EventListener;

public final class AntiEGA extends JavaPlugin implements EventListener, Listener {
    ext exts = new ext();


    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this, this);
        saveDefaultConfig();

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        if (event.getItem().getType() == Material.ENCHANTED_GOLDEN_APPLE) {
            event.setCancelled(true);
            player.sendMessage(exts.cm(this.getConfig().getString("deny")));

        }
    }
}
