package net.thep2wking.hotwater.init;

import net.minecraft.item.Item;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.reloadedlib.api.item.ModItemFoodBase;
import net.thep2wking.reloadedlib.util.ModRarities;

public class ModItems {	
	public static final Item BOILED_FLESH = new ModItemFoodBase(HotWater.MODID, "boiled_flesh", HotWater.TAB, ModRarities.WHITE, false, 0, 4, 1f, true);
	public static final Item BOLIED_CLOWNFISH = new ModItemFoodBase(HotWater.MODID, "boiled_clownfish", HotWater.TAB, ModRarities.WHITE, false, 0, 3, 0.5f, false);
	public static final Item BOLIED_PUFFERFISH = new ModItemFoodBase(HotWater.MODID, "boiled_pufferfish", HotWater.TAB, ModRarities.WHITE, false, 0, 3, 0.5f, false);
	public static final Item BOILED_LEATHER = new ModItemFoodBase(HotWater.MODID, "boiled_leather", HotWater.TAB, ModRarities.WHITE, false, 0, 1, 0.5f, true);
	public static final Item DETOXIFIED_SPIDER_EYE = new ModItemFoodBase(HotWater.MODID, "detoxified_spider_eye", HotWater.TAB, ModRarities.WHITE, false, 0, 2, 0.75f, false);
}