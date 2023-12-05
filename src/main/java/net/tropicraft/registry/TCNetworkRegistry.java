package net.tropicraft.registry;

import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.network.simpleimpl.*;

public class TCNetworkRegistry {

    public static final SimpleNetworkWrapper network;

    public static void init() {}

    static {
        network = NetworkRegistry.INSTANCE.newSimpleChannel("tropicraft");
    }
}
