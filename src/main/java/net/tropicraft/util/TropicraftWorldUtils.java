package net.tropicraft.util;

import net.minecraftforge.common.*;
import net.minecraft.entity.player.*;
import net.minecraft.server.*;
import net.tropicraft.world.*;
import net.minecraft.world.*;
import net.minecraft.server.management.*;

public class TropicraftWorldUtils
{
    public static final int TROPICS_DIMENSION_ID = -127;
    
    public static void initializeDimension() {
        DimensionManager.registerProviderType(-127, (Class)WorldProviderTropicraft.class, true);
        DimensionManager.registerDimension(-127, -127);
    }
    
    public static void teleportPlayer(final EntityPlayerMP player) {
        final long time = System.currentTimeMillis();
        if (player.dimension == -127) {
            final TeleporterTropics tropicsTeleporter = new TeleporterTropics(MinecraftServer.getServer().worldServerForDimension(0));
            final ServerConfigurationManager scm = MinecraftServer.getServer().getConfigurationManager();
            scm.transferPlayerToDimension(player, 0, (Teleporter)tropicsTeleporter);
        }
        else {
            final TeleporterTropics tropicsTeleporter = new TeleporterTropics(MinecraftServer.getServer().worldServerForDimension(-127));
            final ServerConfigurationManager scm = MinecraftServer.getServer().getConfigurationManager();
            scm.transferPlayerToDimension(player, -127, (Teleporter)tropicsTeleporter);
        }
        final long time2 = System.currentTimeMillis();
        System.out.printf("It took %f seconds to teleport\n", (time2 - time) / 1000.0f);
    }
}
