package net.Snicktrix.DanceFloor;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Created by Luke on 8/1/14.
 */
public class ConfigData {
    private DanceFloor danceFloor;

    private Location edge1;
	private Location edge2;

    private FileConfiguration config;

    public ConfigData (DanceFloor danceFloor) {
        this.danceFloor = danceFloor;
        this.config = this.danceFloor.getConfig();

        this.loadConfig();
    }

    private void loadConfig() {
        //Set up the config
        this.danceFloor.getConfig().options().copyDefaults(true);
        this.danceFloor.saveDefaultConfig();

		double edge1X = danceFloor.getConfig().getDouble("Edge1X");
		double edge1Y = danceFloor.getConfig().getDouble("Edge1Y");
		double edge1Z = danceFloor.getConfig().getDouble("Edge1Z");

		Location edge1 = new Location(Bukkit.getWorlds().get(0), edge1X, edge1Y, edge1Z);

		double edge2X = danceFloor.getConfig().getDouble("Edge2X");
		double edge2Y = danceFloor.getConfig().getDouble("Edge2Y");
		double edge2Z = danceFloor.getConfig().getDouble("Edge2Z");

		Location edge2 = new Location(Bukkit.getWorlds().get(0), edge2X, edge2Y, edge2Z);

		this.edge1 = edge1;
		this.edge2 = edge2;

    }

	public Location getEdge1() {
		return edge1;
	}
	public Location getEdge2() {
		return edge2;
	}

}

