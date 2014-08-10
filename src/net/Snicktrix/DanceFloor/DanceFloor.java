package net.Snicktrix.DanceFloor;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Luke on 8/9/14.
 */
public class DanceFloor extends JavaPlugin {
	public ConfigData configData;

	@Override
	public void onEnable() {
		this.configData = new ConfigData(this);
	}

	private void createDanceFloor() {
		Bukkit.getWorld("test").getBlockAt(configData.getEdge1().getBlockX(), configData.getEdge1().getBlockX(), configData.getEdge1().getBlockX());
	}

	//Psuedo code for tomorrow morning...

	/**
	 * get min/max of each X and Z for each location
	 * loop up from min to max for X and Z
	 * Create random wool method
	 * Can use the random color method from firework
	 */
}
