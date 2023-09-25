package net.thep2wking.hotwater.integration.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.hotwater.boiling")
@ZenRegister
public class HotWaterBoiling {
    @ZenMethod
    public static void addRecipe(final IItemStack output, final IItemStack input) {
        if (checkNull(output, false) & checkNull(input, true))
		{
            CraftTweakerAPI.apply(new HotWaterBoilingAction.Add(output, input));
        }
    }

    private static boolean checkNull(Object obj, boolean isInput) {
		if (obj == null)
		{
			CraftTweakerAPI.logError((isInput ? "Input" : "Output") + " cannot be null");
			return false;
		}
		return true;
	}
}