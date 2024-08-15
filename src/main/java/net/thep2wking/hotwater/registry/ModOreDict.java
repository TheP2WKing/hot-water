package net.thep2wking.hotwater.registry;

import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModRecipeHelper;
import net.minecraft.init.Items;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.init.ModItems;

public class ModOreDict {
	public static void registerOreDict() {
		ModLogger.registeredOreDictLogger(HotWater.MODID);

		ModRecipeHelper.addOreDict("listAllleathercooked", ModItems.BOILED_LEATHER, 0);
		ModRecipeHelper.addOreDict("listAllmeatcooked", ModItems.BOILED_FLESH, 0);
		ModRecipeHelper.addOreDict("listAllmeatcooked", ModItems.BOLIED_CLOWNFISH, 0);
		ModRecipeHelper.addOreDict("listAllfishcooked", ModItems.BOLIED_CLOWNFISH, 0);
		ModRecipeHelper.addOreDict("listAllmeatcooked", ModItems.BOLIED_PUFFERFISH, 0);
		ModRecipeHelper.addOreDict("listAllfishcooked", ModItems.BOLIED_PUFFERFISH, 0);
		ModRecipeHelper.addOreDict("listAllmeatcooked", Items.COOKED_FISH, 0);
		ModRecipeHelper.addOreDict("listAllfishcooked", Items.COOKED_FISH, 0);
		ModRecipeHelper.addOreDict("listAllmeatcooked", Items.COOKED_FISH, 1);
		ModRecipeHelper.addOreDict("listAllfishcooked", Items.COOKED_FISH, 1);
		ModRecipeHelper.addOreDict("listAlllspidereyecooked", ModItems.DETOXIFIED_SPIDER_EYE, 0);
	}
}