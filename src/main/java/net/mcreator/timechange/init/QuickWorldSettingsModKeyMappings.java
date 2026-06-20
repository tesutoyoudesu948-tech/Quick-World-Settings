/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.timechange.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.timechange.network.YorukiMessage;
import net.mcreator.timechange.network.HirukiMessage;
import net.mcreator.timechange.network.GuikidoukiMessage;
import net.mcreator.timechange.network.AsakiMessage;
import net.mcreator.timechange.QuickWorldSettingsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class QuickWorldSettingsModKeyMappings {
	public static final KeyMapping ASAKI = new KeyMapping("key.quick_world_settings_.asaki", GLFW.GLFW_KEY_U, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				QuickWorldSettingsMod.PACKET_HANDLER.sendToServer(new AsakiMessage(0, 0));
				AsakiMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping HIRUKI = new KeyMapping("key.quick_world_settings_.hiruki", GLFW.GLFW_KEY_I, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				QuickWorldSettingsMod.PACKET_HANDLER.sendToServer(new HirukiMessage(0, 0));
				HirukiMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping YORUKI = new KeyMapping("key.quick_world_settings_.yoruki", GLFW.GLFW_KEY_O, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				QuickWorldSettingsMod.PACKET_HANDLER.sendToServer(new YorukiMessage(0, 0));
				YorukiMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping GUIKIDOUKI = new KeyMapping("key.quick_world_settings_.guikidouki", GLFW.GLFW_KEY_P, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				QuickWorldSettingsMod.PACKET_HANDLER.sendToServer(new GuikidoukiMessage(0, 0));
				GuikidoukiMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(ASAKI);
		event.register(HIRUKI);
		event.register(YORUKI);
		event.register(GUIKIDOUKI);
	}

	@Mod.EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				ASAKI.consumeClick();
				HIRUKI.consumeClick();
				YORUKI.consumeClick();
				GUIKIDOUKI.consumeClick();
			}
		}
	}
}