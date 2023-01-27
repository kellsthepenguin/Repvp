package co.kellsthepenguin.repvp.subcommands;

import co.kellsthepenguin.repvp.Repvp;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Create implements Subcommand {

    @Override
    public void execute(Player p, String[] args) {
        Repvp plugin = Repvp.getInstance();
        FileConfiguration config = plugin.getConfig();

        switch (args[0]) {
            case "kit" -> {
                if (args.length < 2) {
                    p.sendMessage(ChatColor.RED + "Usage: /pvp createkit <name>");
                    return;
                }

                ItemStack[] contents = p.getInventory().getContents();
                config.set("kits." + args[1], contents);
                plugin.saveConfig();

                p.sendMessage(ChatColor.GREEN + "Successfully created kit " + args[1]);
            }
            case "mode" -> {
                if (args.length < 13) {
                    p.sendMessage(ChatColor.RED + "Usage: /pvp createmode <name> <kit> <schem> <px> <py> <pz> <fx> <fy> <fz> <sx> <sy> <sz>");
                    return;
                }

                String name = args[1];
                String kit = args[2];
                String schem = args[3];
                int px = Integer.parseInt(args[4]);
                int py = Integer.parseInt(args[5]);
                int pz = Integer.parseInt(args[6]);
                int fx = Integer.parseInt(args[7]);
                int fy = Integer.parseInt(args[8]);
                int fz = Integer.parseInt(args[9]);
                int sx = Integer.parseInt(args[10]);
                int sy = Integer.parseInt(args[11]);
                int sz = Integer.parseInt(args[12]);
                ConfigurationSection mode = config.createSection("modes." + name);

                mode.set("kit", kit);
                mode.set("schem", schem);
                mode.set("pasteLoc", new Location(null, px, py, pz));
                mode.set("firstLoc", new Location(null, fx, fy, fz));
                mode.set("secondLoc", new Location(null, sx, sy, sz));

                plugin.saveConfig();
            }
        }
    }
}
