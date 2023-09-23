package net.thep2wking.hotwater.util.render;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.thep2wking.reloadedlib.util.ModFluidUtil;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.init.ModBlocks;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ModFluidRedering {
	@SubscribeEvent
    public static void registerModel(ModelRegistryEvent event) {
		ModFluidUtil.addRenderForFluid(HotWater.MODID, "hot_water", ModBlocks.HOT_WATER);
		ModFluidUtil.addRenderForFluid(HotWater.MODID, "spring_water", ModBlocks.SPRING_WATER);
		ModFluidUtil.addRenderForFluid(HotWater.MODID, "superheated_lava", ModBlocks.SUPERHEATED_LAVA);
    }
}