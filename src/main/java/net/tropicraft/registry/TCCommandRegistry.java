package net.tropicraft.registry;

import net.minecraft.command.*;
import net.tropicraft.command.*;

import cpw.mods.fml.common.event.*;

public class TCCommandRegistry {

    public static void init(final FMLServerStartingEvent event) {
        event.registerServerCommand((ICommand) new CommandTropicsTeleport());
    }
}
