package givePotion;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class Speed implements CommandExecutor{
	
	public static String speed = "speed";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player pl = (Player) sender;
		if(pl.hasPermission("potioneffects.speed")) {
			if(sender instanceof Player) {
				if(cmd.getName().equalsIgnoreCase(speed)) {
					if(pl.hasPotionEffect(PotionEffectType.SPEED)) {
						pl.removePotionEffect(PotionEffectType.SPEED);
						pl.sendMessage(ChatColor.BLUE + "Speed Removed!!");
						return true;
					}else {
						pl.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, false, false));
						pl.sendMessage(ChatColor.BLUE + "Speed Effect Added!");
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
