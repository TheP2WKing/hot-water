package net.thep2wking.hotwater.content.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.thep2wking.hotwater.init.ModFluids;

public class BiomeHotSpring extends Biome {
	public BiomeHotSpring() {
		super(new BiomeProperties("Hot Springs").setRainDisabled().setSnowEnabled().setBaseHeight(0.0f)
				.setHeightVariation(0.0f));
		this.topBlock = ModFluids.SPRING_WATER.getBlock().getDefaultState();
		this.fillerBlock = Blocks.COBBLESTONE.getDefaultState();
	}
}