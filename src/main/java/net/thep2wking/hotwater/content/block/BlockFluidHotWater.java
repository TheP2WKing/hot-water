package net.thep2wking.hotwater.content.block;

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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.thep2wking.hotwater.HotWater;
import net.thep2wking.hotwater.api.BoilingRecipe;
import net.thep2wking.hotwater.api.BoilingRecipeRegistry;
import net.thep2wking.hotwater.config.HotWaterConfig;
import net.thep2wking.hotwater.init.ModBlocks;
import net.thep2wking.oedldoedlcore.api.fluid.ModBlockFluidBase;

public class BlockFluidHotWater extends ModBlockFluidBase {
    public static final DamageSource DAMAGE_SOURCE = new DamageSource(HotWater.MODID + ".hot_water");

    public BlockFluidHotWater(String modid, String name, Fluid fluid, Material material, MapColor mapColor) {
        super(modid, name, fluid, material, mapColor);
        setTickRandomly(true);
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if (entityIn instanceof EntityLivingBase) {
            entityIn.attackEntityFrom(DAMAGE_SOURCE, 2.0f);
            worldIn.playSound(null, pos.add(0.5, 0.5, 0.5), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.AMBIENT,
                    0.5f, 2.6f + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8f);
        } else if (entityIn instanceof EntityItem && !worldIn.isRemote) {
            EntityItem entityItem = (EntityItem) entityIn;
            NBTTagCompound tag = entityItem.getEntityData();
            if (!tag.getBoolean("ProcessedByHotWater")) {
                if (HotWaterConfig.CONTENT.BOILING) {
                    this.cook(worldIn, pos, entityItem);
                    tag.setBoolean("ProcessedByHotWater", true);
                }
            }
        }
    }

    public void cook(World world, BlockPos pos, EntityItem entity) {
        EntityItem itemEntity = entity;
        ItemStack input = itemEntity.getItem();
        for (BoilingRecipe recipe : BoilingRecipeRegistry.getBoilingRecipes()) {
            ItemStack itemStack = recipe.getInput();
            if (input.getItemDamage() <= input.getMaxDamage()) {
                if (itemStack.getItem() != input.getItem())
                    continue;
                this.boil(world, pos, itemEntity, recipe.getOutput(), input.getCount());
                continue;
            }
            if (itemStack.getItem() != input.getItem() || itemStack.getMetadata() != input.getMetadata())
                continue;
            this.boil(world, pos, itemEntity, recipe.getOutput(), input.getCount());
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
        super.updateTick(world, pos, state, random);
        if (HotWaterConfig.CONTENT.SPRING_WATER && HotWaterConfig.CONTENT.SPRING_WATER_CREATION) {
            if (world.getBlockState(pos.down(2)).getMaterial() == Material.LAVA
                    && world.getBlockState(pos.down(1)).getMaterial() == Material.ROCK) {
                if (random.nextInt(4) == 0) {
                    world.setBlockState(pos, ModBlocks.SPRING_WATER.getDefaultState());
                    world.playSound(null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.AMBIENT, 0.5f,
                            1.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);
                }
            }
        }
    }

    @Override
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(2) == 0 && HotWaterConfig.CONTENT.HOT_WATER_PARTICLES) {
            for (int l = 0; l < 2; ++l) {
                double x = (float) pos.getX() + random.nextFloat();
                double y = (double) pos.getY() + 1.2;
                double z = (float) pos.getZ() + random.nextFloat();
                world.spawnParticle(EnumParticleTypes.CLOUD, x, y, z, 0.0, 0.1, 0.0, new int[0]);
            }
        }
    }
}