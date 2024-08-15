package net.thep2wking.hotwater.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.config.categories.Content;
import net.thep2wking.hotwater.config.categories.Integration;
import net.thep2wking.hotwater.config.categories.Boiling;
import net.thep2wking.hotwater.config.categories.World;

@Config(modid = HotWater.MODID, name = HotWater.MODID, category = HotWater.MODID)
public class HotWaterConfig {
	@Config.Name("boiling")
    public static final Boiling BOILING = new Boiling();

	@Config.Name("content")
    public static final Content CONTENT = new Content();

	@Config.Name("world")
    public static final World WORLD = new World();

	@Config.Name("integration")
    public static final Integration INTEGRATION = new Integration();

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