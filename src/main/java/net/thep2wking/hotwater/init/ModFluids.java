package net.thep2wking.hotwater.init;

import net.minecraftforge.fluids.Fluid;
import net.thep2wking.oedldoedlcore.api.fluid.ModFluidBase;
import net.thep2wking.oedldoedlcore.util.ModFluidUtil;
import net.thep2wking.oedldoedlcore.util.ModRarities;
import net.thep2wking.hotwater.HotWater;

public class ModFluids {
	public static final Fluid HOT_WATER = new ModFluidBase(HotWater.MODID, "hot_water", ModFluidUtil.addStillTexture(HotWater.MODID, "hot_water"), ModFluidUtil.addFlowTexture(HotWater.MODID, "hot_water"), 1000, 300, 1000, 0, false, ModRarities.WHITE);
	public static final Fluid SPRING_WATER = new ModFluidBase(HotWater.MODID, "spring_water", ModFluidUtil.addStillTexture(HotWater.MODID, "spring_water"), ModFluidUtil.addFlowTexture(HotWater.MODID, "spring_water"), 1000, 300, 1000, 0, false, ModRarities.WHITE);
	public static final Fluid SUPERHEATED_LAVA = new ModFluidBase(HotWater.MODID, "superheated_lava_hw", ModFluidUtil.LAVA_STILL, ModFluidUtil.LAVA_FLOW, 3000, 300, 1000, 10, false, ModRarities.YELLOW);
}