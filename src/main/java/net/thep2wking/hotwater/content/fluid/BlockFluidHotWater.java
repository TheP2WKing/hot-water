package net.thep2wking.hotwater.content.fluid;

import java.util.Random;

import javax.annotation.Nonnull;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.api.BoilingRecipe;
import net.thep2wking.hotwater.config.HotWaterConfig;
import net.thep2wking.hotwater.init.ModBlocks;
import net.thep2wking.reloadedlib.api.fluid.ModBlockFluidBase;

public class BlockFluidHotWater extends ModBlockFluidBase {
    public static final DamageSource DAMAGE_SOURCE = new DamageSource(HotWater.MODID + ".hot_water");

    public BlockFluidHotWater(String modid, String name, Fluid fluid, Material material, MapColor mapColor) {
        super(modid, name, fluid, material, mapColor);
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if (entityIn instanceof EntityLivingBase) {
            entityIn.attackEntityFrom(DAMAGE_SOURCE, 2.0f);
            worldIn.playSound(null, pos.add(0.5, 0.5, 0.5), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.AMBIENT,
                    0.5f, 2.6f + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8f);
        } else if (entityIn instanceof EntityItem && !worldIn.isRemote) {
            if (HotWaterConfig.ENABLE_BOILING) {
                this.cook(worldIn, pos, (EntityItem) entityIn);
            }
        }
    }

    public void cook(World world, BlockPos pos, EntityItem entity) {
        EntityItem itemEntity = entity;
        ItemStack input = itemEntity.getItem();
        for (int q = 0; q < BoilingRecipe.size(); ++q) {
            ItemStack itemStack = BoilingRecipe.getInput(q);
            if (input.getItemDamage() <= input.getMaxDamage()) {
                if (itemStack.getItem() != input.getItem())
                    continue;
                this.boil(world, pos, itemEntity, BoilingRecipe.getOutput(q), input.getCount());
                continue;
            }
            if (itemStack.getItem() != input.getItem() || itemStack.getMetadata() != input.getMetadata())
                continue;
            this.boil(world, pos, itemEntity, BoilingRecipe.getOutput(q), input.getCount());
        }
    }

    public void boil(World world, BlockPos pos, EntityItem itemEntity, ItemStack output, int amount) {
        world.playSound(null, pos.add(0.5, 0.5, 0.5), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.AMBIENT, 0.5f,
                2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);
        if (amount < output.getCount() * amount) {
            amount *= output.getCount();
        }
        for (int q = 0; q < amount; ++q) {
            itemEntity.entityDropItem(new ItemStack(output.getItem(), 1, output.getMetadata()), 0.0f);
        }
        itemEntity.setDead();
    }

    @Override
    public void updateTick(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull IBlockState state,
            @Nonnull Random random) {
        Material material;
        super.updateTick(world, pos, state, random);
        if (HotWaterConfig.ENABLE_SPRING_WATER) {
            if (random.nextInt(2) == 0 && world.getBlockState(pos.down(2)).getMaterial() == Material.LAVA
                    && ((material = world.getBlockState(pos.down(1)).getMaterial()) == Material.GROUND
                            || material == Material.ROCK)) {
                world.setBlockState(pos, ModBlocks.SPRING_WATER.getDefaultState());
            }
        }
    }

    @Override
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(2) == 0) {
            for (int l = 0; l < 2; ++l) {
                double x = (float) pos.getX() + random.nextFloat();
                double y = (double) pos.getY() + 1.2;
                double z = (float) pos.getZ() + random.nextFloat();
                world.spawnParticle(EnumParticleTypes.CLOUD, x, y, z, 0.0, 0.1, 0.0, new int[0]);
            }
        }
    }
}