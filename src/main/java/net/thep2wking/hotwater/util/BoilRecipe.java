package net.thep2wking.hotwater.util;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BoilRecipe {
	@SuppressWarnings("all")
	public static ArrayList<BoilData> boilList = new ArrayList();

	public static void register(BoilData data) {
		boilList.add(data);
	}

	public static void reset() {
		boilList.clear();
	}

	public static boolean ignoreMetaData(int index) {
		return boilList.get(index).ignoreMetadata();
	}

	public static ItemStack getInput(int index) {
		return boilList.get(index).getInput();
	}

	public static ItemStack getOutput(int index) {
		return boilList.get(index).getOutput();
	}

	public static boolean containInput(ItemStack itemstack) {
		for (BoilData data : boilList) {
			ItemStack storedItemStack = data.getInput();
			Item inputItem = itemstack.getItem();
			Item storedItem = storedItemStack.getItem();
			int storedMetadata = storedItemStack.getItemDamage();
			int inputMetadata = storedItemStack.getItemDamage();
			if (!(data.ignoreMetadata() ? inputItem == storedItem
					: inputItem == storedItem && inputMetadata == storedMetadata))
				continue;
			return true;
		}
		return false;
	}

	public static int size() {
		return boilList.size();
	}
}