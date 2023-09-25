package net.thep2wking.hotwater.init;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.content.BlockFluidHotWater;
import net.thep2wking.hotwater.content.BlockFluidSpringWater;
import net.thep2wking.hotwater.content.BlockFluidSuperheatedLava;

public class ModBlocks {
	public static final BlockFluidClassic HOT_WATER = new BlockFluidHotWater(HotWater.MODID, "hot_water", ModFluids.HOT_WATER, Material.WATER, MapColor.WATER);
	public static final BlockFluidClassic SPRING_WATER = new BlockFluidSpringWater(HotWater.MODID, "spring_water", ModFluids.SPRING_WATER, Material.WATER, MapColor.WATER);
	public static final BlockFluidClassic SUPERHEATED_LAVA = new BlockFluidSuperheatedLava(HotWater.MODID, "superheated_lava", ModFluids.SUPERHEATED_LAVA, Material.LAVA, MapColor.RED);
}