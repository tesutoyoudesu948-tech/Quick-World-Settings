package net.mcreator.timechange.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.timechange.world.inventory.SetteiMenu;
import net.mcreator.timechange.network.SetteiButtonMessage;
import net.mcreator.timechange.init.QuickWorldSettingsModScreens;
import net.mcreator.timechange.QuickWorldSettingsMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class SetteiScreen extends AbstractContainerScreen<SetteiMenu> implements QuickWorldSettingsModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_sunrise;
	private Button button_day;
	private Button button_night;
	private Button button_clear;
	private Button button_rain;
	private Button button_thunder;
	private Button button_freeze;
	private Button button_resume;
	private Button button_enable;
	private Button button_disable;
	private Button button_empty;
	private static final ResourceLocation BACKGROUND = new ResourceLocation("quick_world_settings_:textures/screens/settei.png");

	public SetteiScreen(SetteiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.quick_world_settings_.settei.label_set_time"), 60, 7, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.quick_world_settings_.settei.label_set_weather"), 51, 43, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.quick_world_settings_.settei.label_time_lock"), 6, 79, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.quick_world_settings_.settei.label_night_vision"), 1, 100, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.quick_world_settings_.settei.label_feed"), 2, 120, -16777216, false);
	}

	@Override
	public void init() {
		super.init();
		button_sunrise = Button.builder(Component.translatable("gui.quick_world_settings_.settei.button_sunrise"), e -> {
			int x = SetteiScreen.this.x;
			int y = SetteiScreen.this.y;
			if (true) {
				QuickWorldSettingsMod.PACKET_HANDLER.sendToServer(new SetteiButtonMessage(0, x, y, z));
				SetteiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 16, 61, 20).build();
		this.addRenderableWidget(button_sunrise);
		button_day = Button.builder(Component.translatable("gui.quick_world_settings_.settei.button_day"), e -> {
			int x = SetteiScreen.this.x;
			int y = SetteiScreen.this.y;
			if (true) {
				QuickWorldSettingsMod.PACKET_HANDLER.sendToServer(new SetteiButtonMessage(1, x, y, z));
				SetteiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 69, this.topPos + 16, 40, 20).build();
		this.addRenderableWidget(button_day);
		button_night = Button.builder(Component.translatable("gui.quick_world_settings_.settei.button_night"), e -> {
			int x = SetteiScreen.this.x;
			int y = SetteiScreen.this.y;
			if (true) {
				QuickWorldSettingsMod.PACKET_HANDLER.sendToServer(new SetteiButtonMessage(2, x, y, z));
				SetteiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 114, this.topPos + 16, 51, 20).build();
		this.addRenderableWidget(button_night);
		button_clear = Button.builder(Component.translatable("gui.quick_world_settings_.settei.button_clear"), e -> {
			int x = SetteiScreen.this.x;
			int y = SetteiScreen.this.y;
			if (true) {
				QuickWorldSettingsMod.PACKET_HANDLER.sendToServer(new SetteiButtonMessage(3, x, y, z));
				SetteiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 52, 51, 20).build();
		this.addRenderableWidget(button_clear);
		button_rain = Button.builder(Component.translatable("gui.quick_world_settings_.settei.button_rain"), e -> {
			int x = SetteiScreen.this.x;
			int y = SetteiScreen.this.y;
			if (true) {
				QuickWorldSettingsMod.PACKET_HANDLER.sendToServer(new SetteiButtonMessage(4, x, y, z));
				SetteiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 60, this.topPos + 52, 46, 20).build();
		this.addRenderableWidget(button_rain);
		button_thunder = Button.builder(Component.translatable("gui.quick_world_settings_.settei.button_thunder"), e -> {
			int x = SetteiScreen.this.x;
			int y = SetteiScreen.this.y;
			if (true) {
				QuickWorldSettingsMod.PACKET_HANDLER.sendToServer(new SetteiButtonMessage(5, x, y, z));
				SetteiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 109, this.topPos + 52, 61, 20).build();
		this.addRenderableWidget(button_thunder);
		button_freeze = Button.builder(Component.translatable("gui.quick_world_settings_.settei.button_freeze"), e -> {
			int x = SetteiScreen.this.x;
			int y = SetteiScreen.this.y;
			if (true) {
				QuickWorldSettingsMod.PACKET_HANDLER.sendToServer(new SetteiButtonMessage(6, x, y, z));
				SetteiButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 55, this.topPos + 74, 56, 20).build();
		this.addRenderableWidget(button_freeze);
		button_resume = Button.builder(Component.translatable("gui.quick_world_settings_.settei.button_resume"), e -> {
			int x = SetteiScreen.this.x;
			int y = SetteiScreen.this.y;
			if (true) {
				QuickWorldSettingsMod.PACKET_HANDLER.sendToServer(new SetteiButtonMessage(7, x, y, z));
				SetteiButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 113, this.topPos + 74, 56, 20).build();
		this.addRenderableWidget(button_resume);
		button_enable = Button.builder(Component.translatable("gui.quick_world_settings_.settei.button_enable"), e -> {
			int x = SetteiScreen.this.x;
			int y = SetteiScreen.this.y;
			if (true) {
				QuickWorldSettingsMod.PACKET_HANDLER.sendToServer(new SetteiButtonMessage(8, x, y, z));
				SetteiButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 63, this.topPos + 96, 56, 20).build();
		this.addRenderableWidget(button_enable);
		button_disable = Button.builder(Component.translatable("gui.quick_world_settings_.settei.button_disable"), e -> {
			int x = SetteiScreen.this.x;
			int y = SetteiScreen.this.y;
			if (true) {
				QuickWorldSettingsMod.PACKET_HANDLER.sendToServer(new SetteiButtonMessage(9, x, y, z));
				SetteiButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}).bounds(this.leftPos + 114, this.topPos + 96, 61, 20).build();
		this.addRenderableWidget(button_disable);
		button_empty = Button.builder(Component.translatable("gui.quick_world_settings_.settei.button_empty"), e -> {
			int x = SetteiScreen.this.x;
			int y = SetteiScreen.this.y;
			if (true) {
				QuickWorldSettingsMod.PACKET_HANDLER.sendToServer(new SetteiButtonMessage(10, x, y, z));
				SetteiButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}).bounds(this.leftPos + 63, this.topPos + 115, 25, 20).build();
		this.addRenderableWidget(button_empty);
	}
}