package net.thep2wking.hotwater.integration.jei;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.thep2wking.hotwater.api.BoilingRecipe;

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
		ingredients.setInput(VanillaTypes.ITEM, inputItem);
		ingredients.setOutput(VanillaTypes.ITEM, outputItem);
		ingredients.setInput(VanillaTypes.FLUID, new FluidStack(FluidRegistry.getFluid("hot_water"), 1000));
	}

	@Override
	public boolean handleClick(Minecraft minecraft, int mouseX, int mouseY, int mouseButton) {
		return false;
	}
}