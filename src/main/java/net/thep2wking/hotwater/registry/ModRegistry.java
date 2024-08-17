package net.thep2wking.hotwater.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModRegistryHelper;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.init.ModBlocks;
import net.thep2wking.hotwater.init.ModFluids;
import net.thep2wking.hotwater.init.ModItems;
import net.thep2wking.hotwater.util.render.ModRenderer;

@Mod.EventBusSubscriber
public class ModRegistry {
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		ModRegistryHelper.registerModels(event, HotWater.MODID);
		ModRenderer.registerFluidRenderer();
	}

	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		ModLogger.registeredBlocksLogger(HotWater.MODID);

		ModRegistryHelper.registerBlock(event, ModBlocks.HOT_WATER);
		ModRegistryHelper.registerBlock(event, ModBlocks.SPRING_WATER);
		ModRegistryHelper.registerBlock(event, ModBlocks.SUPERHEATED_LAVA);
	}

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		ModLogger.registeredItemsLogger(HotWater.MODID);

		ModRegistryHelper.registerItem(event, ModItems.BOILED_LEATHER);
		ModRegistryHelper.registerItem(event, ModItems.BOILED_FLESH);
		ModRegistryHelper.registerItem(event, ModItems.BOLIED_CLOWNFISH);
		ModRegistryHelper.registerItem(event, ModItems.BOLIED_PUFFERFISH);
		ModRegistryHelper.registerItem(event, ModItems.DETOXIFIED_SPIDER_EYE);
	}

	public static void registerFluids() {
		ModLogger.registeredFluidsLogger(HotWater.MODID);

        ModRegistryHelper.registerFluid(ModFluids.HOT_WATER);
		ModRegistryHelper.registerFluid(ModFluids.SPRING_WATER);
		ModRegistryHelper.registerFluid(ModFluids.SUPERHEATED_LAVA);
	}
}