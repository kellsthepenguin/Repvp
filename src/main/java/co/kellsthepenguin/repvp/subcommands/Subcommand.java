package co.kellsthepenguin.repvp.subcommands;

import org.bukkit.entity.Player;

public interface Subcommand {
    void execute(Player p, String[] args);
}
