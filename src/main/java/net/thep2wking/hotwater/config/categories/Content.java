package net.thep2wking.hotwater.config.categories;

import net.minecraftforge.common.config.Config;

public class Content {
	@Config.Name("Hot Water")
	public boolean HOT_WATER = true;

	@Config.Name("Hot Water Particles")
	public boolean HOT_WATER_PARTICLES = true;

	@Config.Name("Spring Water")
	public boolean SPRING_WATER = true;
	
	@Config.Name("Spring Water Particles")
	public boolean SPRING_WATER_PARTICLES = true;

	@Config.Name("Spring Water Creation")
	public boolean SPRING_WATER_CREATION = true;

	@Config.Name("Superheated Lava")
	public boolean SUPERHEATED_LAVA = true;

	@Config.Name("Superheated Lava Particles")
	public boolean SUPERHEATED_LAVA_PARTICLES = true;

	@Config.Name("Superheated Lava Destroys Unbreakable Blocks")
	public boolean SUPERHEATED_LAVA_DESTROYS_UNBREAKABLE_BLOCKS = true;

	@Config.Name("Enable Boiling")
	public boolean BOILING = true;
}