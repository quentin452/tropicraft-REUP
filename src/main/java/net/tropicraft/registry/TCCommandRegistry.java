package net.tropicraft.registry;

import cpw.mods.fml.common.event.*;
import net.tropicraft.command.*;
import net.minecraft.command.*;

public class TCCommandRegistry
{
    public static void init(final FMLServerStartingEvent event) {
        event.registerServerCommand((ICommand)new CommandTropicsTeleport());
    }
}
