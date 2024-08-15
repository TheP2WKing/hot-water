package net.thep2wking.hotwater.util.world;

import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.config.HotWaterConfig;
import net.thep2wking.hotwater.init.ModBiomes;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.world.ModBiomeUtil;

public class ModBiomeGen {
	public static void registerModBiomeGen() {
		if (HotWaterConfig.WORLD.SPRING_WATER_BIOME) {
			ModLogger.registeredBiomesLogger(HotWater.MODID);
			
			ModBiomeUtil.addBasicBiome(ModBiomes.HOT_SPRING, HotWater.MODID, "hot_spring",
					HotWaterConfig.WORLD.SPRING_WATER_BIOME_WEIGHT, BiomeType.DESERT, Type.WET, Type.WATER);
		}
	}
}