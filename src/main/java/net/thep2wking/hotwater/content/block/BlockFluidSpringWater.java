package net.thep2wking.hotwater.content.block;

import java.util.Random;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.thep2wking.hotwater.config.HotWaterConfig;
import net.thep2wking.oedldoedlcore.api.fluid.ModBlockFluidBase;

public class BlockFluidSpringWater extends ModBlockFluidBase {
	public BlockFluidSpringWater(String modid, String name, Fluid fluid, Material material, MapColor mapColor) {
		super(modid, name, fluid, material, mapColor);
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if (entityIn instanceof EntityLivingBase && !worldIn.isRemote) {
			EntityLivingBase living = (EntityLivingBase) entityIn;
			living.curePotionEffects(new ItemStack(Items.MILK_BUCKET, 1, 0));
			if (living.ticksExisted % 30 == 0 && living.getHealth() > 0.0f) {
				living.setHealth(living.getHealth() + 1.0f);
				if (living instanceof EntityPlayer) {
					((EntityPlayer) living).getFoodStats().addExhaustion(0.75f);
				}
			}
		}
	}

	@Override
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
		if (HotWaterConfig.CONTENT.SPRING_WATER_PARTICLES) {
			for (int l = 0; l < 4; ++l) {
				double x = (float) pos.getX() + random.nextFloat();
				double z = (float) pos.getZ() + random.nextFloat();
				world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, x, (double) pos.getY(), z, 0.0,
						(double) random.nextFloat(), 0.0, new int[0]);
			}
		}
	}
}