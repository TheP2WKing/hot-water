package net.thep2wking.hotwater.integration.jei.springwater;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IGuiFluidStackGroup;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.init.ModFluids;
import net.thep2wking.oedldoedlcore.util.ModFluidUtil;

public class SpringWaterRecipeCategory implements IRecipeCategory<SpringWaterRecipeWrapper> {
	public static final String UID = HotWater.MODID + "." + "spring_water";
	public static final String TITLE = I18n.format("jei." + HotWater.MODID + "." + "spring_water.category");
	public static final String MOD = HotWater.NAME;
	public static final ResourceLocation BACKGROUND = new ResourceLocation(HotWater.MODID,
			"textures/gui/jei_spring_water.png");

	public IDrawable background;
	public IDrawable icon;
	private IDrawableAnimated progress;

	public SpringWaterRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.drawableBuilder(BACKGROUND, 0, 0, 122, 68).addPadding(0, 0, 0, 0).build();
		icon = guiHelper.createDrawableIngredient(ModFluidUtil.addFluidBucket(ModFluids.SPRING_WATER));
		progress = guiHelper.createAnimatedDrawable(guiHelper.drawableBuilder(BACKGROUND, 122, 0, 15, 14).build(), 80,
				IDrawableAnimated.StartDirection.BOTTOM, false);
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
	public void drawExtras(Minecraft minecraft) {
		this.progress.draw(minecraft, 11, 27);
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, SpringWaterRecipeWrapper recipeWrapper,
			IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		IGuiFluidStackGroup guiFluidStacks = recipeLayout.getFluidStacks();

		guiItemStacks.addTooltipCallback((slotIndex, input, ingredient, tooltip) -> {
			if (slotIndex == 1) {
				tooltip.add(I18n.format("jei." + HotWater.MODID + ".spring_water.category.info2"));
			}
		});

		guiFluidStacks.addTooltipCallback((slotIndex, input, ingredient, tooltip) -> {
			if (slotIndex == 2) {
				tooltip.add(I18n.format("jei." + HotWater.MODID + ".spring_water.category.info3"));
			}
		});

		guiFluidStacks.init(0, true, 29, 10, 16, 16, 1000, false, null);
		guiItemStacks.init(1, true, 28, 25);
		guiFluidStacks.init(2, true, 29, 42, 16, 16, 1000, false, null);
		guiFluidStacks.init(3, false, 85, 22, 24, 24, 1000, false, null);
		guiItemStacks.set(ingredients);
		guiFluidStacks.set(ingredients);
	}
}