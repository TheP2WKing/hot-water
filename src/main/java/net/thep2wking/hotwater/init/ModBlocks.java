package net.thep2wking.hotwater.init;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.content.block.BlockFluidHotWater;
import net.thep2wking.hotwater.content.block.BlockFluidSpringWater;
import net.thep2wking.hotwater.content.block.BlockFluidSuperheatedLava;

public class ModBlocks {
	public static final BlockFluidClassic HOT_WATER = new BlockFluidHotWater(HotWater.MODID, "hot_water", ModFluids.HOT_WATER, 0x3f76e4, Material.WATER, MapColor.WATER);
	public static final BlockFluidClassic SPRING_WATER = new BlockFluidSpringWater(HotWater.MODID, "spring_water", ModFluids.SPRING_WATER, 0x3f76e4, Material.WATER, MapColor.WATER);
	public static final BlockFluidClassic SUPERHEATED_LAVA = new BlockFluidSuperheatedLava(HotWater.MODID, "superheated_lava_hw", ModFluids.SUPERHEATED_LAVA, 0xff4500, Material.LAVA, MapColor.RED);
}