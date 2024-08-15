package net.thep2wking.hotwater.api;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

public class BoilingRecipeRegistry {
	private static final List<BoilingRecipe> BOILING_RECIPES = new ArrayList<>();

	public static void registerBoiling(BoilingRecipe recipe) {
		BOILING_RECIPES.add(recipe);
	}

	public static List<BoilingRecipe> getBoilingRecipes() {
		return BOILING_RECIPES;
	}

	public static void addBoilingRecipe(ItemStack input, ItemStack output) {
		registerBoiling(new BoilingRecipe(input, output));
	}
}