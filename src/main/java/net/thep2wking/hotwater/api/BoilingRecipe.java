package net.thep2wking.hotwater.api;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BoilingRecipe {
	public static List<ItemStack> inputs = new ArrayList<ItemStack>();
	public static List<ItemStack> outputs = new ArrayList<ItemStack>();

	public BoilingRecipe(ItemStack boilingInput, ItemStack boilingOutput) {
		if (boilingInput instanceof ItemStack) {
			inputs.add(boilingInput);
		}

		if (boilingOutput instanceof ItemStack) {
			outputs.add(boilingOutput);
		}
	}

	public static BoilingRecipe register(ItemStack boilingInput, ItemStack boilingOutput) {
		return new BoilingRecipe(boilingInput, boilingOutput);
	}

	public static BoilingRecipe register(Item boilingInput, Item boilingOutput) {
		return new BoilingRecipe(new ItemStack(boilingInput), new ItemStack(boilingOutput));
	}

	public static BoilingRecipe register(Block boilingInput, Item boilingOutput) {
		return new BoilingRecipe(new ItemStack(boilingInput), new ItemStack(boilingOutput));
	}

	public static BoilingRecipe register(Item boilingInput, Block boilingOutput) {
		return new BoilingRecipe(new ItemStack(boilingInput), new ItemStack(boilingOutput));
	}

	public static BoilingRecipe register(Block boilingInput, Block boilingOutput) {
		return new BoilingRecipe(new ItemStack(boilingInput), new ItemStack(boilingOutput));
	}

	public static BoilingRecipe register(ItemStack boilingInput, Item boilingOutput) {
		return new BoilingRecipe(boilingInput, new ItemStack(boilingOutput));
	}

	public static BoilingRecipe register(ItemStack boilingInput, Block boilingOutput) {
		return new BoilingRecipe(boilingInput, new ItemStack(boilingOutput));
	}

	public static BoilingRecipe register(Item boilingInput, ItemStack boilingOutput) {
		return new BoilingRecipe(new ItemStack(boilingInput), boilingOutput);
	}

	public static BoilingRecipe register(Block boilingInput, ItemStack boilingOutput) {
		return new BoilingRecipe(new ItemStack(boilingInput), boilingOutput);
	}

	public static ItemStack getInput(int index) {
		return inputs.get(index);
	}

	public static ItemStack getOutput(int index) {
		return outputs.get(index);
	}

	public static int size() {
		return inputs.size();
	}
}