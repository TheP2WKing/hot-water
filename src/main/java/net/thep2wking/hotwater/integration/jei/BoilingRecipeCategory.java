package net.thep2wking.hotwater.integration.jei;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiFluidStackGroup;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.init.ModFluids;
import net.thep2wking.reloadedlib.util.ModFluidUtil;

public class BoilingRecipeCategory implements IRecipeCategory<BoilingRecipeWrapper> {
	public static final String UID = HotWater.MODID + "." + "boiling";
	public static final String TITLE = I18n.format("jei." + HotWater.MODID + "." + "boiling.category");
	public static final String MOD = HotWater.NAME;
	public static final ResourceLocation BACKGROUND = new ResourceLocation(HotWater.MODID,
			"textures/gui/jei_boiling.png");

	public IDrawable background;
	public IDrawable icon;

	public BoilingRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.drawableBuilder(BACKGROUND, 0, 0, 120, 34).addPadding(2, 0, 0, 0).build(); // 0 0 0 2
		icon = guiHelper.createDrawableIngredient(ModFluidUtil.addFluidBucket(ModFluids.HOT_WATER));
	}

	@Override
	public String getUid() {
		return UID;
	}

	@Override
	public String getModName() {
		return MOD;
	}

	@Override
	public String getTitle() {
		return TITLE;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, BoilingRecipeWrapper recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		IGuiFluidStackGroup guiFluidStacks = recipeLayout.getFluidStacks();
		
		guiFluidStacks.init(0, true, 45, 10, 16, 16, 1000, false, null);
		guiItemStacks.init(0, false, 92, 9);
		guiItemStacks.init(12, true, 8, 9);
		guiItemStacks.set(ingredients);
		guiFluidStacks.set(ingredients);
	}
}