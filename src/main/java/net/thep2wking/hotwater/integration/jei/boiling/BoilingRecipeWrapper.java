package net.thep2wking.hotwater.integration.jei.boiling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.api.BoilingRecipe;
import net.thep2wking.hotwater.api.BoilingRecipeRegistry;
import net.thep2wking.hotwater.config.HotWaterConfig;
import net.thep2wking.hotwater.init.ModFluids;

public class BoilingRecipeWrapper implements IRecipeWrapper {
	public BoilingRecipe recipe;
	public ItemStack inputItem;
	public ItemStack outputItem;

	public BoilingRecipeWrapper(ItemStack out, ItemStack in) {
		this.inputItem = in;
		this.outputItem = out;
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInputs(VanillaTypes.ITEM, Arrays.asList(inputItem));
		ingredients.setInputs(VanillaTypes.FLUID, Arrays.asList(new FluidStack(ModFluids.HOT_WATER, 1000)));
		ingredients.setOutput(VanillaTypes.ITEM, outputItem);
	}

	@Override
	public boolean handleClick(Minecraft minecraft, int mouseX, int mouseY, int mouseButton) {
		return false;
	}

	@Override
	public List<String> getTooltipStrings(int mouseX, int mouseY) {
		if (mouseX >= 31 && mouseX <= 44 && mouseY >= 7 && mouseY <= 24) {
			return Arrays.asList(I18n.format("jei." + HotWater.MODID + ".boiling.category.info1"));
		} else if (mouseX >= 62 && mouseX <= 83 && mouseY >= 7 && mouseY <= 24) {
			return Arrays.asList(I18n.format("jei." + HotWater.MODID + ".boiling.category.info1"));
		}
		return IRecipeWrapper.super.getTooltipStrings(mouseX, mouseY);
	}

	public static List<BoilingRecipeWrapper> getBoilingRecipes() {
		List<BoilingRecipeWrapper> boilingRecipes = new ArrayList<>();
		if (HotWaterConfig.CONTENT.BOILING) {
			for (BoilingRecipe recipe : BoilingRecipeRegistry.getBoilingRecipes()) {
				ItemStack input = recipe.getInput();
				ItemStack output = recipe.getOutput();
				boilingRecipes
						.add(new BoilingRecipeWrapper(output, new ItemStack(input.getItem(), 1, input.getMetadata())));
			}
		}
		return boilingRecipes;
	}
}