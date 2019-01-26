package secondly.potioneffects.shprqness;

import org.bukkit.plugin.java.JavaPlugin;

import givePotion.NightVision;
import givePotion.Strong;

public class Main extends JavaPlugin {
	
	private NightVision commands = new NightVision();
	private Strong commands1 = new Strong();
	
	public void onEnable() {
		getCommand(Strong.strength).setExecutor(commands1);
		getCommand(NightVision.nightvision).setExecutor(commands);
		getServer().getConsoleSender().sendMessage("Potion Effects Plugin Coded by Shprqness // Secondly");
	}
	

}
