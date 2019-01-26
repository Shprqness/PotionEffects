package givePotion;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class NightVision implements CommandExecutor {

	public static String nightvision = "nightvision";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player pl = (Player) sender;
		if(pl.hasPermission("potioneffects.nightvision")) {
			if(sender instanceof Player) {
				if(cmd.getName().equalsIgnoreCase(nightvision)) {
					if(pl.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
						pl.removePotionEffect(PotionEffectType.NIGHT_VISION);
						pl.sendMessage(ChatColor.BLUE + "Night Vision Removed!!");
						return true;
					}else {
						pl.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1, false, false));
						pl.sendMessage(ChatColor.BLUE + "NightVision Effect Added!");
					}
				}else {
					pl.sendMessage(ChatColor.RED + "No Perms");
				}
			}else {
				pl.sendMessage(ChatColor.RED + "Cannot Execute from Console.");
				return true;
			}
		}
		return true;
	}
	
	
	
}
