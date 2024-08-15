package net.thep2wking.hotwater.util.render;

import net.thep2wking.oedldoedlcore.util.ModFluidUtil;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.init.ModBlocks;

public class ModRenderer {
    public static void registerFluidRenderer() {
		ModFluidUtil.addRenderForFluid(HotWater.MODID, "hot_water", ModBlocks.HOT_WATER);
		ModFluidUtil.addRenderForFluid(HotWater.MODID, "spring_water", ModBlocks.SPRING_WATER);
		ModFluidUtil.addRenderForFluid(HotWater.MODID, "superheated_lava", ModBlocks.SUPERHEATED_LAVA);
    }
}