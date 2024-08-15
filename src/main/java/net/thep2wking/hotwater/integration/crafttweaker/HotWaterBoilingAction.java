package net.thep2wking.hotwater.integration.crafttweaker;

import crafttweaker.IAction;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.item.ItemStack;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.api.BoilingRecipe;

abstract class HotWaterBoilingAction implements IAction {
    final ItemStack output;
    final ItemStack input;

    public HotWaterBoilingAction(ItemStack output, ItemStack input) {
        this.output = output;
        this.input = input;
    }

    public HotWaterBoilingAction(IItemStack output, IItemStack input) {
        this(CraftTweakerMC.getItemStack(output), CraftTweakerMC.getItemStack(input));
    }

    private static String prefix() {
        return "[" + HotWater.NAME + " | Boiling]: ";
    }

    static class Add extends HotWaterBoilingAction {
        Add(IItemStack output, IItemStack input) {
            super(output, input);
        }

        @Override
        public void apply() {
            BoilingRecipe.register(this.input, this.output);
        }

        @Override
        public String describe() {
            return prefix() + "Adding boiling recipe for Input " + "<" + this.input + "> and Output <" + this.output
                    + ">";
        }
    }
}
