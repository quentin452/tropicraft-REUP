package net.tropicraft.command;

import net.minecraft.command.*;
import net.minecraft.entity.player.*;
import net.tropicraft.util.*;

public class CommandTropicsTeleport extends CommandBase {

    public String getCommandName() {
        return "tropics";
    }

    public String getCommandUsage(final ICommandSender commandSender) {
        return "";
    }

    public void processCommand(final ICommandSender commandSender, final String[] args) {
        final EntityPlayerMP player = getCommandSenderAsPlayer(commandSender);
        TropicraftWorldUtils.teleportPlayer(player);
    }
}
