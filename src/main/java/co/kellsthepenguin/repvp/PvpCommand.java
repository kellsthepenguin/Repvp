package co.kellsthepenguin.repvp;

import co.kellsthepenguin.repvp.subcommands.Subcommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;

public class PvpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Player only command");
            return true;
        }

        Player player = ((Player) sender);
        HashMap<String, Subcommand> subcommands = Repvp.getInstance().getSubCommands();

        if (args.length < 1) {
            player.sendMessage(ChatColor.RED + "Not enough args");
            return true;
        }

        String subcommand = args[0];

        if (!subcommands.containsKey(subcommand)) {
            player.sendMessage(ChatColor.RED + "Invalid subcommand");
            return true;
        }

        subcommands.get(subcommand).execute(player, Arrays.copyOfRange(args, 1, args.length));

        return true;
    }
}
