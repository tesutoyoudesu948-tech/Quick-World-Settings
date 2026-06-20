package net.mcreator.timechange.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;

public class AsaProcedure {
	public static void execute(LevelAccessor world) {
		if (world instanceof ServerLevel _level)
			_level.setDayTime(1);
	}
}