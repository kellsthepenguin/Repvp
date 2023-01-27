package co.kellsthepenguin.repvp;

import co.kellsthepenguin.repvp.subcommands.Create;
import co.kellsthepenguin.repvp.subcommands.Subcommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Repvp extends JavaPlugin {
    private static Repvp instance;
    private final HashMap<String, Subcommand> subcommands = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;
        this.saveDefaultConfig();
        this.getCommand("pvp").setExecutor(new PvpCommand());
        subcommands.put("create", new Create());
    }

    public HashMap<String, Subcommand> getSubCommands() {
        return subcommands;
    }

    public static Repvp getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
