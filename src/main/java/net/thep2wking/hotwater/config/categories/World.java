package net.thep2wking.hotwater.config.categories;

import net.minecraftforge.common.config.Config;

public class World {
	@Config.Name("Spring Water Biome")
	public boolean SPRING_WATER_BIOME = true;

	@Config.Name("Spring Water Biome Weight")
	@Config.RangeInt(min = 0, max = 100)
	public int SPRING_WATER_BIOME_WEIGHT = 5;
}