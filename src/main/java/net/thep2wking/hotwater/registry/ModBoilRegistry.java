package net.thep2wking.hotwater.registry;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.thep2wking.hotwater.init.ModItems;
import net.thep2wking.hotwater.util.BoilData;
import net.thep2wking.hotwater.util.BoilRecipe;

public class ModBoilRegistry {
	public static void init() {
		BoilRecipe.register(new BoilData(Items.MUTTON, Items.COOKED_MUTTON));
		BoilRecipe.register(new BoilData(Items.RABBIT, Items.COOKED_RABBIT));
		BoilRecipe.register(new BoilData(Items.CHICKEN, Items.COOKED_CHICKEN));
		BoilRecipe.register(new BoilData(Items.PORKCHOP, Items.COOKED_PORKCHOP));
		BoilRecipe.register(new BoilData(Items.BEEF, Items.COOKED_BEEF));
		BoilRecipe.register(new BoilData(Items.POTATO, Items.BAKED_POTATO));
		BoilRecipe.register(new BoilData(Items.POISONOUS_POTATO, Items.BAKED_POTATO));
		BoilRecipe.register(new BoilData(Items.SPIDER_EYE, ModItems.DETOXIFIED_SPIDER_EYE));
		BoilRecipe.register(new BoilData(Items.LEATHER, ModItems.BOILED_LEATHER));
		BoilRecipe.register(new BoilData(Items.RABBIT_HIDE, ModItems.BOILED_LEATHER));
		BoilRecipe.register(new BoilData(Items.ROTTEN_FLESH, ModItems.BOILED_FLESH));
		BoilRecipe.register(new BoilData(new ItemStack(Items.FISH, 1, 0), new ItemStack(Items.COOKED_FISH, 1, 0)));
		BoilRecipe.register(new BoilData(new ItemStack(Items.FISH, 1, 1), new ItemStack(Items.COOKED_FISH, 1, 1)));
		BoilRecipe.register(new BoilData(Items.LEATHER_BOOTS, new ItemStack(ModItems.BOILED_LEATHER, 4), true));
		BoilRecipe.register(
				new BoilData((Item) Items.LEATHER_CHESTPLATE, new ItemStack(ModItems.BOILED_LEATHER, 8), true));
		BoilRecipe.register(new BoilData(Items.LEATHER_HELMET, new ItemStack(ModItems.BOILED_LEATHER, 5), true));
		BoilRecipe.register(new BoilData(Items.LEATHER_LEGGINGS, new ItemStack(ModItems.BOILED_LEATHER, 7), true));
	}
}