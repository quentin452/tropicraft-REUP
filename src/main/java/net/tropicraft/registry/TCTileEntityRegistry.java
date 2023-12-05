package net.tropicraft.registry;

import net.minecraft.tileentity.*;
import net.tropicraft.block.tileentity.*;

import cpw.mods.fml.common.registry.*;

public class TCTileEntityRegistry {

    public static void init() {
        registerTE((Class<? extends TileEntity>) TileEntityTropicraftFlowerPot.class, "TCFlowerPot");
        registerTE((Class<? extends TileEntity>) TileEntityFirePit.class, "TCFirePit");
        registerTE((Class<? extends TileEntity>) TileEntityAirCompressor.class, "TCAirCompressor");
        registerTE((Class<? extends TileEntity>) TileEntityBambooChest.class, "TCBambooChest");
        registerTE((Class<? extends TileEntity>) TileEntitySifter.class, "TCSifter");
        registerTE((Class<? extends TileEntity>) TileEntityCurareBowl.class, "TCCurareBowl");
        registerTE((Class<? extends TileEntity>) TileEntityKoaChest.class, "TCKoaChest");
        registerTE((Class<? extends TileEntity>) TileEntityPurchasePlate.class, "TCTradePlate");
        registerTE((Class<? extends TileEntity>) TileEntityBambooMug.class, "TCBambooMug");
        registerTE((Class<? extends TileEntity>) TileEntityEIHMixer.class, "TCEIHMixer");
    }

    private static void registerTE(final Class<? extends TileEntity> clazz, final String name) {
        GameRegistry.registerTileEntity((Class) clazz, name);
    }
}
