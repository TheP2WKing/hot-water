package net.thep2wking.hotwater.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.api.BoilingRecipe;
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

		if (HotWaterConfig.BOILING.ENABLE_ALL_DEFAULT_BOILING_RECIPES) {
			if (HotWaterConfig.BOILING.COOKED_MUTTON_FROM_RAW_MUTTON)
				BoilingRecipe.register(Items.MUTTON, Items.COOKED_MUTTON);

			if (HotWaterConfig.BOILING.COOKED_RABBIT_FROM_RAW_RABBIT)
				BoilingRecipe.register(Items.RABBIT, Items.COOKED_RABBIT);

			if (HotWaterConfig.BOILING.COOKED_CHICKEN_FROM_RAW_CHICKEN)
				BoilingRecipe.register(Items.CHICKEN, Items.COOKED_CHICKEN);

			if (HotWaterConfig.BOILING.COOKED_PORKCHOP_FROM_RAW_PORKCHOP)
				BoilingRecipe.register(Items.PORKCHOP, Items.COOKED_PORKCHOP);

			if (HotWaterConfig.BOILING.STEAK_FROM_RAW_BEEF)
				BoilingRecipe.register(Items.BEEF, Items.COOKED_BEEF);

			if (HotWaterConfig.BOILING.BAKED_POTATO_FROM_POTATO)
				BoilingRecipe.register(Items.POTATO, Items.BAKED_POTATO);

			if (HotWaterConfig.BOILING.BAKED_POTATO_FROM_POISONOUS_POTATO)
				BoilingRecipe.register(Items.POISONOUS_POTATO, Items.BAKED_POTATO);

			if (HotWaterConfig.BOILING.DETOXIFIED_SPIDER_EYE_FROM_SPIDER_EYE)
				BoilingRecipe.register(Items.SPIDER_EYE, ModItems.DETOXIFIED_SPIDER_EYE);

			if (HotWaterConfig.BOILING.BOILED_LEATHER_FROM_LEATHER)
				BoilingRecipe.register(Items.LEATHER, ModItems.BOILED_LEATHER);

			if (HotWaterConfig.BOILING.BOILED_LEATHER_FROM_RABBIT_HIDE)
				BoilingRecipe.register(Items.RABBIT_HIDE, ModItems.BOILED_LEATHER);

			if (HotWaterConfig.BOILING.BOILED_FLESH_FROM_ROTTEN_FLESH)
				BoilingRecipe.register(Items.ROTTEN_FLESH, ModItems.BOILED_FLESH);

			if (HotWaterConfig.BOILING.POPPED_CHORUS_FRUIT_FROM_CHORUS_FRUIT)
				BoilingRecipe.register(Items.CHORUS_FRUIT, Items.CHORUS_FRUIT_POPPED);

			if (HotWaterConfig.BOILING.COOKED_FISH_FROM_RAW_FISH)
				BoilingRecipe.register(new ItemStack(Items.FISH, 1, 0), new ItemStack(Items.COOKED_FISH, 1, 0));

			if (HotWaterConfig.BOILING.COOKED_SALMON_FROM_RAW_SALMON)
				BoilingRecipe.register(new ItemStack(Items.FISH, 1, 1), new ItemStack(Items.COOKED_FISH, 1, 1));

			if (HotWaterConfig.BOILING.BOILED_CLOWNFISH_FROM_CLOWNFISH)
				BoilingRecipe.register(new ItemStack(Items.FISH, 1, 2), ModItems.BOLIED_CLOWNFISH);

			if (HotWaterConfig.BOILING.BOILED_PUFFERFISH_FROM_PUFFERFISH)
				BoilingRecipe.register(new ItemStack(Items.FISH, 1, 3), ModItems.BOLIED_PUFFERFISH);

			if (HotWaterConfig.BOILING.BOILED_LEATHER_FROM_LEATHER_CAP)
				BoilingRecipe.register(Items.LEATHER_HELMET, new ItemStack(ModItems.BOILED_LEATHER, 5));

			if (HotWaterConfig.BOILING.BOILED_LEATHER_FROM_LEATHER_TUNIC)
				BoilingRecipe.register(Items.LEATHER_CHESTPLATE, new ItemStack(ModItems.BOILED_LEATHER, 8));

			if (HotWaterConfig.BOILING.BOILED_LEATHER_FROM_LEATHER_PANTS)
				BoilingRecipe.register(Items.LEATHER_LEGGINGS, new ItemStack(ModItems.BOILED_LEATHER, 7));

			if (HotWaterConfig.BOILING.BOILED_LEATHER_FROM_LEATHER_BOOTS)
				BoilingRecipe.register(Items.LEATHER_BOOTS, new ItemStack(ModItems.BOILED_LEATHER, 4));

			if (HotWaterConfig.BOILING.BOILED_LEATHER_FROM_SADDLE)
				BoilingRecipe.register(Items.SADDLE, new ItemStack(ModItems.BOILED_LEATHER, 5));

			if (HotWaterConfig.BOILING.DEAD_BUSH_FROM_FERN)
				BoilingRecipe.register(new ItemStack(Blocks.TALLGRASS, 1, 2), Blocks.DEADBUSH);

			if (HotWaterConfig.BOILING.GREEN_DYE_FROM_CACTUS)
				BoilingRecipe.register(Blocks.CACTUS, new ItemStack(Items.DYE, 1, 2));
		}

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
}