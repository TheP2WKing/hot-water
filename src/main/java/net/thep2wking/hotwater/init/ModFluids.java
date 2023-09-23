package net.thep2wking.hotwater.init;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.thep2wking.reloadedlib.api.fluid.ModFluidBase;
import net.thep2wking.reloadedlib.util.ModFluidUtil;
import net.thep2wking.reloadedlib.util.ModRarities;
import net.thep2wking.hotwater.HotWater;

public class ModFluids {
	public static final Fluid HOT_WATER = new ModFluidBase(HotWater.MODID, "hot_water", textureStill("hot_water"), textureFlow("hot_water"), 11068159, 1000, 300, 1000, 0, false, ModRarities.WHITE);
	public static final Fluid SPRING_WATER = new ModFluidBase(HotWater.MODID, "spring_water", textureStill("spring_water"), textureFlow("spring_water"), 11068159, 1000, 300, 1000, 0, false, ModRarities.WHITE);
	public static final Fluid SUPERHEATED_LAVA = new ModFluidBase(HotWater.MODID, "superheated_lava", ModFluidUtil.MOLTEN_STILL_BASE, ModFluidUtil.MOLTEN_FLOW_BASE, 16204556, 3000, 300, 1000, 0, false, ModRarities.WHITE);

	public static ResourceLocation textureStill(String name) {
		return new ResourceLocation(HotWater.MODID, "blocks/" + name + "_still");
	}

	public static ResourceLocation textureFlow(String name) {
		return new ResourceLocation(HotWater.MODID, "blocks/" + name + "_flow");
	}
}