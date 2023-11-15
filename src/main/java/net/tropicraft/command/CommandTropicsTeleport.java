package net.tropicraft.command;

import net.minecraft.command.*;
import net.tropicraft.util.*;
import net.minecraft.entity.player.*;

public class CommandTropicsTeleport extends CommandBase
{
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
