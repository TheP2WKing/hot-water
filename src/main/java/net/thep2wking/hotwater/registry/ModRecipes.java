package net.thep2wking.hotwater.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.api.BoilingRecipeRegistry;
import net.thep2wking.hotwater.config.HotWaterConfig;
import net.thep2wking.hotwater.init.ModFluids;
import net.thep2wking.hotwater.init.ModItems;
import net.thep2wking.oedldoedlcore.util.ModFluidUtil;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModRecipeHelper;

@Mod.EventBusSubscriber
public class ModRecipes {
	public static void registerRecipes() {
		ModLogger.registeredRecipesLogger(HotWater.MODID);

		if (HotWaterConfig.CONTENT.HOT_WATER) {
			ModRecipeHelper.addSmeltingRecipe(ModFluidUtil.addFluidBucket(FluidRegistry.WATER),
					ModFluidUtil.addFluidBucket(ModFluids.HOT_WATER), 0.1f);
		}

		if (HotWaterConfig.CONTENT.SUPERHEATED_LAVA) {
			ModRecipeHelper.addShapelessRecipe(HotWater.MODID, "superheated_lava_bucket",
					ModFluidUtil.addFluidBucket(ModFluids.SUPERHEATED_LAVA),
					ModFluidUtil.addFluidBucket(FluidRegistry.LAVA), "netherStar");
		}
	}

	public static void registerBoilingRecipe() {
		if (HotWaterConfig.BOILING.ENABLE_ALL_DEFAULT_BOILING_RECIPES) {
			if (HotWaterConfig.BOILING.COOKED_MUTTON_FROM_RAW_MUTTON) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.MUTTON), new ItemStack(Items.COOKED_MUTTON));
			}
			if (HotWaterConfig.BOILING.COOKED_RABBIT_FROM_RAW_RABBIT) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.RABBIT), new ItemStack(Items.COOKED_RABBIT));
			}
			if (HotWaterConfig.BOILING.COOKED_CHICKEN_FROM_RAW_CHICKEN) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.CHICKEN),
						new ItemStack(Items.COOKED_CHICKEN));
			}
			if (HotWaterConfig.BOILING.COOKED_PORKCHOP_FROM_RAW_PORKCHOP) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.PORKCHOP),
						new ItemStack(Items.COOKED_PORKCHOP));
			}
			if (HotWaterConfig.BOILING.STEAK_FROM_RAW_BEEF) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.BEEF), new ItemStack(Items.COOKED_BEEF));
			}
			if (HotWaterConfig.BOILING.BAKED_POTATO_FROM_POTATO) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.POTATO), new ItemStack(Items.BAKED_POTATO));
			}
			if (HotWaterConfig.BOILING.BAKED_POTATO_FROM_POISONOUS_POTATO) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.POISONOUS_POTATO),
						new ItemStack(Items.BAKED_POTATO));
			}
			if (HotWaterConfig.BOILING.DETOXIFIED_SPIDER_EYE_FROM_SPIDER_EYE) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.SPIDER_EYE),
						new ItemStack(ModItems.DETOXIFIED_SPIDER_EYE));
			}
			if (HotWaterConfig.BOILING.BOILED_LEATHER_FROM_LEATHER) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.LEATHER),
						new ItemStack(ModItems.BOILED_LEATHER));
			}
			if (HotWaterConfig.BOILING.BOILED_LEATHER_FROM_RABBIT_HIDE) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.RABBIT_HIDE),
						new ItemStack(ModItems.BOILED_LEATHER));
			}
			if (HotWaterConfig.BOILING.BOILED_FLESH_FROM_ROTTEN_FLESH) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.ROTTEN_FLESH),
						new ItemStack(ModItems.BOILED_FLESH));
			}
			if (HotWaterConfig.BOILING.POPPED_CHORUS_FRUIT_FROM_CHORUS_FRUIT) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.CHORUS_FRUIT),
						new ItemStack(Items.CHORUS_FRUIT_POPPED));
			}
			if (HotWaterConfig.BOILING.COOKED_FISH_FROM_RAW_FISH) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.FISH, 1, 0),
						new ItemStack(Items.COOKED_FISH, 1, 0));
			}
			if (HotWaterConfig.BOILING.COOKED_SALMON_FROM_RAW_SALMON) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.FISH, 1, 1),
						new ItemStack(Items.COOKED_FISH, 1, 1));
			}
			if (HotWaterConfig.BOILING.BOILED_CLOWNFISH_FROM_CLOWNFISH) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.FISH, 1, 2),
						new ItemStack(ModItems.BOLIED_CLOWNFISH));
			}
			if (HotWaterConfig.BOILING.BOILED_PUFFERFISH_FROM_PUFFERFISH) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.FISH, 1, 3),
						new ItemStack(ModItems.BOLIED_PUFFERFISH));
			}
			if (HotWaterConfig.BOILING.BOILED_LEATHER_FROM_LEATHER_CAP) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.LEATHER_HELMET),
						new ItemStack(ModItems.BOILED_LEATHER, 5));
			}
			if (HotWaterConfig.BOILING.BOILED_LEATHER_FROM_LEATHER_TUNIC) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.LEATHER_CHESTPLATE),
						new ItemStack(ModItems.BOILED_LEATHER, 8));
			}
			if (HotWaterConfig.BOILING.BOILED_LEATHER_FROM_LEATHER_PANTS) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.LEATHER_LEGGINGS),
						new ItemStack(ModItems.BOILED_LEATHER, 7));
			}
			if (HotWaterConfig.BOILING.BOILED_LEATHER_FROM_LEATHER_BOOTS) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.LEATHER_BOOTS),
						new ItemStack(ModItems.BOILED_LEATHER, 4));
			}
			if (HotWaterConfig.BOILING.BOILED_LEATHER_FROM_SADDLE) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Items.SADDLE),
						new ItemStack(ModItems.BOILED_LEATHER, 5));
			}
			if (HotWaterConfig.BOILING.DEAD_BUSH_FROM_FERN) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Blocks.TALLGRASS, 1, 2),
						new ItemStack(Blocks.DEADBUSH));
			}
			if (HotWaterConfig.BOILING.GREEN_DYE_FROM_CACTUS) {
				BoilingRecipeRegistry.addBoilingRecipe(new ItemStack(Blocks.CACTUS), new ItemStack(Items.DYE, 1, 2));
			}
		}
	}
}