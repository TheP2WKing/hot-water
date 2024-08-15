package net.thep2wking.hotwater.api;

import net.minecraft.item.ItemStack;

public class BoilingRecipe {
	private final ItemStack input;
	private final ItemStack output;

	public BoilingRecipe(ItemStack input, ItemStack output) {
		this.input = input;
		this.output = output;
	}

	public ItemStack getInput() {
		return this.input;
	}

	public ItemStack getOutput() {
		return this.output;
	}
}