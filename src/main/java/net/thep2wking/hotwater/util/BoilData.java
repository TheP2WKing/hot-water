package net.thep2wking.hotwater.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BoilData {
	private ItemStack input;
	private ItemStack output;
	private boolean ignoreMetadata;

	public BoilData(ItemStack input, ItemStack output, boolean ignoreMetadata) {
		this.input = input;
		this.output = output;
		this.ignoreMetadata = ignoreMetadata;
	}

	public BoilData(Item input, Item output, boolean ignoreMetadata) {
		this(new ItemStack(input), new ItemStack(output), ignoreMetadata);
	}

	public BoilData(Item input, ItemStack output, boolean ignoreMetadata) {
		this(new ItemStack(input), output, ignoreMetadata);
	}

	public BoilData(ItemStack input, ItemStack output) {
		this(input, output, false);
	}

	public BoilData(Item input, Item output) {
		this(new ItemStack(input), new ItemStack(output), false);
	}

	public BoilData(ItemStack input, Item output) {
		this(input, new ItemStack(output), false);
	}

	public ItemStack getInput() {
		return this.input;
	}

	public ItemStack getOutput() {
		return this.output;
	}

	public boolean ignoreMetadata() {
		return this.ignoreMetadata;
	}

	public String toConfig() {
		String str = this.input.getItem().getUnlocalizedName();
		str = !this.ignoreMetadata ? str + "#" + this.input.getItemDamage() + "," : str + ",";
		str = this.output.getItemDamage() > 0
				? str + this.output.getItem().getUnlocalizedName() + "#" + this.output.getItemDamage() + ","
						+ this.ignoreMetadata + "\n"
				: str + this.output.getItem().getUnlocalizedName() + "," + this.ignoreMetadata + "\n";
		return str;
	}

	@SuppressWarnings("null")
	public String toString() {
		return this.input.getItem().getUnlocalizedName() + "#" + this.input.getItemDamage()
				+ this.input.getTagCompound().toString();
	}
}
