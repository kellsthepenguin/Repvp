package co.kellsthepenguin.repvp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class PvpTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> tabCompleters = new ArrayList<>();

        if (args.length == 1) {
            tabCompleters.add("create");
        }

        if (args.length == 2) {
            if (args[0].equals("create")) {
                tabCompleters.add("kit");
                tabCompleters.add("mode");
            }
        }

        return tabCompleters;
    }
}
