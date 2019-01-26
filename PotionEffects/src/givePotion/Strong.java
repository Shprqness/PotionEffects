package givePotion;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class Strong implements CommandExecutor{
	
	public static String strength = "strength";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player pl = (Player) sender;
		if(pl.hasPermission("potioneffects.strength")) {
			if(sender instanceof Player) {
				if(cmd.getName().equalsIgnoreCase(strength)) {
					if(pl.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
						pl.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
						pl.sendMessage(ChatColor.BLUE + "Strength Removed!!");
						return true;
					}else {
						pl.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1, false, false));
						pl.sendMessage(ChatColor.BLUE + "Strength Effect Added!");
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
