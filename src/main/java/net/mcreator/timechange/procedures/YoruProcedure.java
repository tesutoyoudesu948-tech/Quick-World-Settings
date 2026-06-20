package net.mcreator.timechange.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;

public class YoruProcedure {
	public static void execute(LevelAccessor world) {
		if (world instanceof ServerLevel _level)
			_level.setDayTime(13000);
	}
}