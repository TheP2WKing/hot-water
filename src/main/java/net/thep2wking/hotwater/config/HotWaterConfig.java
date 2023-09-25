package net.thep2wking.hotwater.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.config.categories.Recipes;

@Config(modid = HotWater.MODID, name = HotWater.MODID, category = HotWater.MODID)
public class HotWaterConfig {
	@Config.Name("recipes")
    public static final Recipes RECIPES = new Recipes();

	@Config.Name("Enable Hot Water")
	public static boolean ENABLE_HOT_WATER = true;

	@Config.Name("Enable Spring Water")
	public static boolean ENABLE_SPRING_WATER = true;

	@Config.Name("Enable Superheated Lava")
	public static boolean ENABLE_SUPERHEATED_LAVA = true;

	@Config.Name("Enable Boiling")
	public static boolean ENABLE_BOILING = true;

	@Config.Name("Disable Default Boiling Recipes")
	public static boolean DISABLE_DEFAULT_BOILING_RECIPES = false;

	@Config.Name("Enable JEI Integration")
	public static boolean ENABLE_JEI_INTEGRATION = true;

	@Mod.EventBusSubscriber
	public static class ConfigHolder {
		@SubscribeEvent
		public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(HotWater.MODID)) {
				ConfigManager.sync(HotWater.MODID, Config.Type.INSTANCE);
			}
		}
	}
}