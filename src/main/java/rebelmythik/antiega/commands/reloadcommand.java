package rebelmythik.antiega.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import rebelmythik.antiega.AntiEGA;
import rebelmythik.antiega.ext;

public class reloadcommand implements CommandExecutor {

    AntiEGA plugin;
    public reloadcommand(AntiEGA plugin) {
        this.plugin = plugin;
    }
    ext exts = new ext();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("egareload")){
            if(!sender.hasPermission("ega.reload")) {
                sender.sendMessage(exts.cm(plugin.getConfig().getString("messages.no-perm")));
                return true;
            }
            sender.sendMessage(exts.cm(plugin.getConfig().getString("messages.reload-message")));
            plugin.reloadConfig();
        }

        return false;

    }

}
