package rebelmythik.antiega;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import rebelmythik.antiega.commands.disablecommand;
import rebelmythik.antiega.commands.enablecommand;
import rebelmythik.antiega.commands.reloadcommand;

import java.util.EventListener;
import java.util.Objects;

public final class AntiEGA extends JavaPlugin implements EventListener, Listener {
    ext exts = new ext();

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this, this);
        getCommand("egareload").setExecutor(new reloadcommand(this));
        getCommand("egaenable").setExecutor(new enablecommand(this));
        getCommand("egadisable").setExecutor(new disablecommand(this));
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
            if (player.hasPermission("ega.bypass") || Objects.equals(this.getConfig().getString("enabled"), "true")) {
                return;
            }
            event.setCancelled(true);
            player.sendMessage(exts.cm(this.getConfig().getString("messages.deny")));
        }
    }
}