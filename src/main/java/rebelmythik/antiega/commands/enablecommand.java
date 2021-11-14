package rebelmythik.antiega.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import rebelmythik.antiega.AntiEGA;
import rebelmythik.antiega.ext;

import java.util.Objects;

public class enablecommand implements CommandExecutor {
    ext exts = new ext();
    AntiEGA plugin;
    public enablecommand(AntiEGA plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("ega.enable")){
            sender.sendMessage(exts.cm(plugin.getConfig().getString("messages.no-perm")));
            return true;
        }
        if(Objects.equals(plugin.getConfig().getString("enabled"), "false")){
            plugin.getConfig().set("enabled", true);
            plugin.saveConfig();
            plugin.reloadConfig();
            sender.sendMessage(exts.cm(plugin.getConfig().getString("messages.enable-message")));
            return true;
        }
        sender.sendMessage(exts.cm(plugin.getConfig().getString("messages.already-enabled")));
        return false;
    }
}
