package co.kellsthepenguin.repvp.subcommands;

import co.kellsthepenguin.repvp.Repvp;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Create implements Subcommand {

    @Override
    public void execute(Player p, String[] args) {
        if (args.length < 2) {
            p.sendMessage(ChatColor.RED + "Not enough args");
            return;
        }

        if (args[0].equals("kit")) {
            Repvp plugin = Repvp.getInstance();
            ItemStack[] contents = p.getInventory().getContents();
            FileConfiguration config = plugin.getConfig();
            config.set("kits." + args[1], contents);
            plugin.saveConfig();

            p.sendMessage(ChatColor.GREEN + "Successfully created kit " + args[1]);
        }
    }
}
