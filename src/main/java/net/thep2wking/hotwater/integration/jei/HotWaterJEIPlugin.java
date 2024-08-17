package net.thep2wking.hotwater.integration.jei;

import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.config.HotWaterConfig;
import net.thep2wking.hotwater.init.ModFluids;
import net.thep2wking.hotwater.integration.jei.boiling.BoilingRecipeCategory;
import net.thep2wking.hotwater.integration.jei.boiling.BoilingRecipeWrapper;
import net.thep2wking.hotwater.integration.jei.springwater.SpringWaterRecipeCategory;
import net.thep2wking.hotwater.integration.jei.springwater.SpringWaterRecipeWrapper;
import net.thep2wking.oedldoedlcore.api.integration.ModJEIPluginBase;
import net.thep2wking.oedldoedlcore.util.ModFluidUtil;

@JEIPlugin
public class HotWaterJEIPlugin extends ModJEIPluginBase {
	@Override
	public String getModId() {
		return HotWater.MODID;
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		if (HotWaterConfig.INTEGRATION.JEI_INTEGRATION && HotWaterConfig.CONTENT.BOILING) {
			addRecipeCategory(registry, new BoilingRecipeCategory(getGuiHelper(registry)));
		}
		if (HotWaterConfig.INTEGRATION.JEI_INTEGRATION && HotWaterConfig.CONTENT.SPRING_WATER
				&& HotWaterConfig.CONTENT.SPRING_WATER_CREATION) {
			addRecipeCategory(registry, new SpringWaterRecipeCategory(getGuiHelper(registry)));
		}
	}

	@Override
	public void register(IModRegistry registry) {
		if (HotWaterConfig.INTEGRATION.JEI_INTEGRATION) {
			super.register(registry);

			addStackInfo(registry, ModFluidUtil.addFluidBucket(ModFluids.HOT_WATER), "hot_water_bucket");
			addFluidStackInfo(registry, new FluidStack(ModFluids.HOT_WATER, 1000), "hot_water");

			addStackInfo(registry, ModFluidUtil.addFluidBucket(ModFluids.SPRING_WATER), "spring_water_bucket");
			addFluidStackInfo(registry, new FluidStack(ModFluids.SPRING_WATER, 1000), "spring_water");

			addStackInfo(registry, ModFluidUtil.addFluidBucket(ModFluids.SUPERHEATED_LAVA), "superheated_lava_bucket");
			addFluidStackInfo(registry, new FluidStack(ModFluids.SUPERHEATED_LAVA, 1000), "superheated_lava");

			if (HotWaterConfig.CONTENT.BOILING) {
				addRecipeCatalyst(registry, ModFluidUtil.addFluidBucket(ModFluids.HOT_WATER),
						BoilingRecipeCategory.UID);
				addRecipes(registry, BoilingRecipeWrapper.getBoilingRecipes(), BoilingRecipeCategory.UID);
			}

			if (HotWaterConfig.CONTENT.SPRING_WATER && HotWaterConfig.CONTENT.SPRING_WATER_CREATION) {
				addRecipeCatalyst(registry, ModFluidUtil.addFluidBucket(ModFluids.HOT_WATER),
						SpringWaterRecipeCategory.UID);
				addRecipeCatalyst(registry, new ItemStack(Blocks.STONE), SpringWaterRecipeCategory.UID);
				addRecipeCatalyst(registry, ModFluidUtil.addFluidBucket(FluidRegistry.LAVA),
						SpringWaterRecipeCategory.UID);
				addRecipes(registry, SpringWaterRecipeWrapper.getSpringWaterRecipes(), SpringWaterRecipeCategory.UID);
			}
		}
	}
}