package net.mcreator.timechange.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class MannpukudoProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.getFoodData().setSaturation(20);
		if (entity instanceof Player _player)
			_player.getFoodData().setFoodLevel(20);
	}
}