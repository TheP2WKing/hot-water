package net.thep2wking.hotwater.content.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.config.HotWaterConfig;
import net.thep2wking.oedldoedlcore.api.fluid.ModBlockFluidBase;

public class BlockFluidSuperheatedLava extends ModBlockFluidBase {
	public static final DamageSource DAMAGE_SOURCE = new DamageSource(HotWater.MODID + ".superheated_lava");

	public BlockFluidSuperheatedLava(String modid, String name, Fluid fluid, Material material, MapColor mapColor) {
		super(modid, name, fluid, material, mapColor);
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if (entityIn instanceof EntityLivingBase) {
			entityIn.attackEntityFrom(DAMAGE_SOURCE, 18.0f);
		}
	}

	public boolean destroyUnbreakableBlocks(Block block, IBlockAccess world, BlockPos pos) {
		if (block.getHarvestLevel(world.getBlockState(pos)) == -1
				&& !HotWaterConfig.CONTENT.SUPERHEATED_LAVA_DESTROYS_UNBREAKABLE_BLOCKS) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean canDisplace(IBlockAccess world, BlockPos pos) {
		Block block = world.getBlockState(pos).getBlock();
		if (HotWaterConfig.CONTENT.SUPERHEATED_LAVA && destroyUnbreakableBlocks(block, world, pos)) {
			if (block.isAir(world.getBlockState(pos), world, pos)) {
				return true;
			}
			return block != this;
		}
		return block.isAir(world.getBlockState(pos), world, pos);
	}

	@Override
	public boolean displaceIfPossible(World world, BlockPos pos) {
		Block block = world.getBlockState(pos).getBlock();
		if (HotWaterConfig.CONTENT.SUPERHEATED_LAVA && destroyUnbreakableBlocks(block, world, pos)) {
			return block != this;
		}
		return block.isAir(world.getBlockState(pos), world, pos);
	}

	@Override
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
		if (HotWaterConfig.CONTENT.SUPERHEATED_LAVA_PARTICLES) {
			for (int l = 0; l < 4; ++l) {
				double x = (float) pos.getX() + random.nextFloat();
				double z = (float) pos.getZ() + random.nextFloat();
				world.spawnParticle(EnumParticleTypes.LAVA, x, (double) pos.getY(), z, 0.0, (double) random.nextFloat(),
						0.0, new int[0]);
			}
		}
	}
}