package net.thep2wking.hotwater.init;

import net.minecraft.item.Item;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.oedldoedlcore.api.item.ModItemFoodBase;
import net.thep2wking.oedldoedlcore.util.ModRarities;

public class ModItems {	
	public static final Item BOILED_FLESH = new ModItemFoodBase(HotWater.MODID, "boiled_flesh", HotWater.TAB, 4, 1f, true, ModRarities.WHITE, false, 0, 0);
	public static final Item BOLIED_CLOWNFISH = new ModItemFoodBase(HotWater.MODID, "boiled_clownfish", HotWater.TAB, 3, 0.5f, false, ModRarities.WHITE, false, 0, 0);
	public static final Item BOLIED_PUFFERFISH = new ModItemFoodBase(HotWater.MODID, "boiled_pufferfish", HotWater.TAB, 3, 0.5f, false, ModRarities.WHITE, false, 0, 0);
	public static final Item BOILED_LEATHER = new ModItemFoodBase(HotWater.MODID, "boiled_leather", HotWater.TAB, 1, 0.5f, true, ModRarities.WHITE, false, 0, 0);
	public static final Item DETOXIFIED_SPIDER_EYE = new ModItemFoodBase(HotWater.MODID, "detoxified_spider_eye", HotWater.TAB, 2, 0.75f, false, ModRarities.WHITE, false, 0, 0);
}