package net.thep2wking.hotwater;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.tab.ModCreativeTabBase;
import net.thep2wking.oedldoedlcore.util.ModFluidUtil;
import net.thep2wking.oedldoedlcore.util.ModLogInUtil;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModReferences;
import net.thep2wking.hotwater.init.ModFluids;
import net.thep2wking.hotwater.registry.ModRecipes;
import net.thep2wking.hotwater.registry.ModOreDict;
import net.thep2wking.hotwater.registry.ModRegistry;
import net.thep2wking.hotwater.util.proxy.CommonProxy;
import net.thep2wking.hotwater.util.world.ModBiomeGen;

@Mod(modid = HotWater.MODID, name = HotWater.NAME, version = HotWater.VERSION, dependencies = HotWater.DEPENDENCIES)
public class HotWater {
    public static final String MODID = "hotwater";
    public static final String PREFIX = MODID + ":";
    public static final String MC_VERSION = "1.12.2";
    public static final String NAME = "Hot Water Reloaded";
    public static final String VERSION = MC_VERSION + "-" + "1.0.0";
    public static final String DEPENDENCIES = "required-after:forge@[14.23.5.2847,);required-after:oedldoedlcore@[1.12.2-4.2.0,);" + ModReferences.OEDLDOEDL_MODS_FIRST;
    public static final String CLIENT_PROXY_CLASS = "net.thep2wking.hotwater.util.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "net.thep2wking.hotwater.util.proxy.ServerProxy";

    @Mod.Instance(MODID)
    public static HotWater INSTANCE;

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
    public static CommonProxy PROXY;

    public static final CreativeTabs TAB = new ModCreativeTabBase(MODID, ModReferences.CREATIVE_TAB_LIGHT, false,
            true) {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return ModFluidUtil.addFluidBucket(ModFluids.HOT_WATER);
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModLogger.preInitLogger(MODID);
        ModRegistry.registerFluids(event);
        ModRecipes.registerBoilingRecipe();
        PROXY.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModLogger.initLogger(MODID);
        ModOreDict.registerOreDict();
        ModRecipes.registerRecipes();
        ModBiomeGen.registerModBiomeGen();
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

    @Mod.EventBusSubscriber
    public static class ModJoinMessage {
        @SubscribeEvent
        public static void addJoinMessage(PlayerLoggedInEvent event) {
            ModLogInUtil.addJoinMessage(event, NAME, "hot-water-reloaded", VERSION, true);
        }
    }
}