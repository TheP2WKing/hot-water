package net.thep2wking.hotwater.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.reloadedlib.util.ModLogger;
import net.thep2wking.reloadedlib.util.ModRegistryHelper;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.init.ModBlocks;
import net.thep2wking.hotwater.init.ModFluids;
import net.thep2wking.hotwater.init.ModItems;

@Mod.EventBusSubscriber
public class ModRegistry {
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

		ModRegistryHelper.registerItem(event, ModItems.BOILED_FLESH);
		ModRegistryHelper.registerItem(event, ModItems.BOILED_LEATHER);
		ModRegistryHelper.registerItem(event, ModItems.DETOXIFIED_SPIDER_EYE);
	}

	public static void registerFluids(FMLPreInitializationEvent event) {
        ModRegistryHelper.registerFluid(ModFluids.HOT_WATER);
		ModRegistryHelper.registerFluid(ModFluids.SPRING_WATER);
		ModRegistryHelper.registerFluid(ModFluids.SUPERHEATED_LAVA);
	}
}