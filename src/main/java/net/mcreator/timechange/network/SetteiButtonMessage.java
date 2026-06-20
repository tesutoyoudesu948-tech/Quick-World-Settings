package net.mcreator.timechange.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.SectionPos;

import net.mcreator.timechange.procedures.*;
import net.mcreator.timechange.QuickWorldSettingsMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public record SetteiButtonMessage(int buttonID, int x, int y, int z) {
	public SetteiButtonMessage(FriendlyByteBuf buffer) {
		this(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt());
	}

	public static void buffer(SetteiButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(SetteiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> handleButtonAction(context.getSender(), message.buttonID, message.x, message.y, message.z));
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (buttonID == 0) {

			AsaProcedure.execute(world);
		}
		if (buttonID == 1) {

			HiruProcedure.execute(world);
		}
		if (buttonID == 2) {

			YoruProcedure.execute(world);
		}
		if (buttonID == 3) {

			AProcedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			BProcedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			CProcedure.execute(world, x, y, z);
		}
		if (buttonID == 6) {

			KoteisuruProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			ZikannmodosuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			AnndoDProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			AnndoIIIIIIIIIIIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			MannpukudoProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		QuickWorldSettingsMod.addNetworkMessage(SetteiButtonMessage.class, SetteiButtonMessage::buffer, SetteiButtonMessage::new, SetteiButtonMessage::handler);
	}
}