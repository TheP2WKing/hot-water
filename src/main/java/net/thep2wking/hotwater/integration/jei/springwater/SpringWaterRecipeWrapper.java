package net.thep2wking.hotwater.integration.jei.springwater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.init.ModFluids;

public class SpringWaterRecipeWrapper implements IRecipeWrapper {
	public ItemStack inputItem;

	public SpringWaterRecipeWrapper(ItemStack in) {
		this.inputItem = in;
	}
	
	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInputs(VanillaTypes.FLUID, Arrays.asList(
			new FluidStack(ModFluids.HOT_WATER, 1000),
			new FluidStack(FluidRegistry.LAVA, 1000)
		));
		ingredients.setInputs(VanillaTypes.ITEM, Arrays.asList(inputItem));
		ingredients.setOutput(VanillaTypes.FLUID, new FluidStack(ModFluids.SPRING_WATER, 1000));
	}

	@Override
	public boolean handleClick(Minecraft minecraft, int mouseX, int mouseY, int mouseButton) {
		return false;
	}

	@Override
	public List<String> getTooltipStrings(int mouseX, int mouseY) {
		if (mouseX >= 52 && mouseX <= 76 && mouseY >= 25 && mouseY <= 42) {
			return Arrays.asList(I18n.format("jei." + HotWater.MODID + ".spring_water.category.info1"));
		}
		return IRecipeWrapper.super.getTooltipStrings(mouseX, mouseY);
	}

	public static List<SpringWaterRecipeWrapper> getSpringWaterRecipes() {
		List<SpringWaterRecipeWrapper> springWaterRecipes = new ArrayList<>();
		springWaterRecipes.add(new SpringWaterRecipeWrapper(new ItemStack(Blocks.STONE)));
		return springWaterRecipes;
	}
}