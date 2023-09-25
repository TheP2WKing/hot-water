package net.thep2wking.hotwater.integration.jei;

import java.util.ArrayList;
import java.util.List;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.item.ItemStack;
import net.thep2wking.hotwater.api.BoilingRecipe;
import net.thep2wking.hotwater.config.HotWaterConfig;
import net.thep2wking.hotwater.init.ModFluids;
import net.thep2wking.reloadedlib.util.ModFluidUtil;

@mezz.jei.api.JEIPlugin
public class HotWaterJEIPlugin implements IModPlugin {
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		if (HotWaterConfig.ENABLE_JEI_INTEGRATION && HotWaterConfig.ENABLE_BOILING) {
			registry.addRecipeCategories(new BoilingRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
		}
	}

	@Override
	public void register(IModRegistry registry) {
		if (HotWaterConfig.ENABLE_JEI_INTEGRATION && HotWaterConfig.ENABLE_BOILING) {
			List<BoilingRecipeWrapper> boilingList = new ArrayList<>();
			for (int q = 0; q < BoilingRecipe.size(); ++q) {
				ItemStack input = BoilingRecipe.getInput(q);;
				ItemStack output = BoilingRecipe.getOutput(q);
				boilingList.add(new BoilingRecipeWrapper(output, new ItemStack(input.getItem(), 1, input.getMetadata())));
				registry.addRecipes(boilingList, BoilingRecipeCategory.UID);
				boilingList.clear();
			}
			registry.addRecipeCatalyst(ModFluidUtil.addFluidBucket(ModFluids.HOT_WATER), BoilingRecipeCategory.UID);
		}
	}
}