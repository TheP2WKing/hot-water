package net.thep2wking.hotwater;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.UniversalBucket;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.reloadedlib.util.ModFluidUtil;
import net.thep2wking.reloadedlib.util.ModLogger;
import net.thep2wking.hotwater.init.ModFluids;
import net.thep2wking.hotwater.registry.ModRecipes;
import net.thep2wking.hotwater.registry.ModOreDict;
import net.thep2wking.hotwater.registry.ModRegistry;
import net.thep2wking.hotwater.util.proxy.CommonProxy;

@Mod(modid = HotWater.MODID, name = HotWater.NAME, version = HotWater.VERSION, dependencies = HotWater.DEPENDENCIES)
public class HotWater {
    public static final String MODID = "hotwater";
    public static final String PREFIX = MODID + ":";
    public static final String MC_VERSION = "1.12.2";
    public static final String NAME = "Hot Water Reloaded";
    public static final String VERSION = MC_VERSION + "-" + "1.0.0";
    public static final String DEPENDENCIES = "required-after:forge@[14.23.5.2847,);required-after:reloadedlib@[1.12.2-1.0.0,);after:jei@[4.16.1.1000,);after:theoneprobe@[1.4.28,);after:crafttweaker@[4,);";
    public static final String CLIENT_PROXY_CLASS = "net.thep2wking.hotwater.util.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "net.thep2wking.hotwater.util.proxy.ServerProxy";
    
    @Instance
    public static HotWater INSTANCE;

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
    public static CommonProxy PROXY;

    static {
        FluidRegistry.enableUniversalBucket();
    }

    public static final CreativeTabs TAB = new CreativeTabs(HotWater.MODID + ".name") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return ModFluidUtil.addFluidBucket(ModFluids.HOT_WATER);
        }

        @Override
        @SuppressWarnings("all")
        public void displayAllRelevantItems(NonNullList<ItemStack> itemList) {
            super.displayAllRelevantItems(itemList);
            for (Fluid bucketFluid : FluidRegistry.getBucketFluids()) {
                if (bucketFluid.getBlock() != null
                        && bucketFluid.getBlock().getRegistryName().getResourceDomain().equals(HotWater.MODID)) {
                    ItemStack itemstack = UniversalBucket
                            .getFilledBucket(ForgeModContainer.getInstance().universalBucket, bucketFluid);
                    itemList.add(itemstack);
                }
            }
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModLogger.preInitLogger(MODID);
        ModRegistry.registerFluids(event);
        PROXY.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModLogger.initLogger(MODID);
        ModOreDict.registerOreDict();
        ModRecipes.registerRecipes();
        PROXY.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        ModLogger.postInitLogger(MODID);
        PROXY.postInit(event);
    }

    @Mod.EventHandler
    public void loadComplete(FMLLoadCompleteEvent event) {
        ModLogger.loadCompleteLogger(MODID, VERSION);
    }
}