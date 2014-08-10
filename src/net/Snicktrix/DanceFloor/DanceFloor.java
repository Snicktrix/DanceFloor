package net.Snicktrix.DanceFloor;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

/**
 * Created by Luke on 8/9/14.
 */
public class DanceFloor extends JavaPlugin {
	public ConfigData configData;

	@Override
	public void onEnable() {
		//Config preparation
		this.saveDefaultConfig();

		this.configData = new ConfigData(this);
		this.startDanceFloor();
	}

	private void createDanceFloor() {
		Location edge1 = configData.getEdge1();
		Location edge2 = configData.getEdge2();

		int highX;
		int lowX;

		int highZ;
		int lowZ;

		highX = Math.max(edge1.getBlockX(), edge2.getBlockX());
		lowX = Math.min(edge1.getBlockX(), edge2.getBlockX());

		highZ = Math.max(edge1.getBlockZ(), edge2.getBlockZ());
		lowZ = Math.min(edge1.getBlockZ(), edge2.getBlockZ());

//		if (highX < 0) {
//			highX += 1;
//		} else {
//			highX -= 1;
//		}
//		if (highZ < 0) {
//			highZ += 1;
//		} else {
//			highZ -= 1;
//		}

		for (int x = lowX; x < (highX); x++) {
			for (int z = lowZ; z < (highZ + 1); z++) {
				Location loc = new Location(Bukkit.getWorlds().get(0), x, edge1.getY(), z);
				Block block = Bukkit.getWorlds().get(0).getBlockAt(loc);

				block.setTypeIdAndData(35, getRandombyte(), true);

			}
		}
	}

	private void startDanceFloor() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				if (Bukkit.getOnlinePlayers().length > 0) {
					createDanceFloor();
				}
			}
		}, 0, 10);
	}

	private byte getRandombyte() {
		Random rand = new Random();
		int i = rand.nextInt(15 - 1 + 1) + 1;

		if (i == 1) {
			return (byte) 1;
		}
		if (i == 2) {
			return (byte) 2;
		}
		if (i == 3) {
			return (byte) 3;
		}
		if (i == 4) {
			return (byte) 4;
		}
		if (i == 5) {
			return (byte) 5;
		}
		if (i == 6) {
			return (byte) 6;
		}
		if (i ==7) {
			return (byte) 7;
		}
		if (i == 8) {
			return (byte) 8;
		}
		if (i == 9) {
			return (byte) 9;
		}
		if (i == 10) {
			return (byte) 10;
		}
		if (i == 11) {
			return (byte) 11;
		}
		if (i == 12) {
			return (byte) 12;
		}
		if (i == 13) {
			return (byte) 13;
		}
		if (i == 14) {
			return (byte) 14;
		}
		if (i == 15) {
			return (byte) 15;
		}
		return (byte) 0;
	}



	//Psuedo code for tomorrow morning...



	/**
	 * get min/max of each X and Z for each location
	 * loop up from min to max for X and Z
	 * Create random wool method
	 * Can use the random color method from firework
	 */

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equals("dance")) {
			this.createDanceFloor();
			return true;
		}
		return false;
	}
}
