package net.tropicraft.command;

import net.minecraft.command.*;
import net.minecraft.util.*;
import CoroUtil.world.location.*;
import net.tropicraft.world.location.*;
import net.minecraft.entity.player.*;
import CoroUtil.world.*;
import java.util.*;

public class CommandTropicraft extends CommandBase
{
    public String getCommandName() {
        return "tc";
    }
    
    public String getCommandUsage(final ICommandSender commandSender) {
        return "";
    }
    
    public void processCommand(final ICommandSender commandSender, final String[] args) {
        final EntityPlayerMP player = getCommandSenderAsPlayer(commandSender);
        if (args.length > 0) {
            if (args[0].equals("village_new")) {
                final int x = MathHelper.floor_double(player.posX);
                final int z = MathHelper.floor_double(player.posZ);
                int y = player.worldObj.getHeightValue(x, z);
                if (y < 63) {
                    y = 64;
                }
                final TownKoaVillage village = new TownKoaVillage();
                final WorldDirector wd = WorldDirectorManager.instance().getCoroUtilWorldDirector(player.worldObj);
                final int newID = wd.lookupTickingManagedLocations.size();
                village.initData(newID, player.worldObj.provider.dimensionId, new ChunkCoordinates(x, y, z));
                village.initFirstTime();
                wd.addTickingLocation((ManagedLocation)village);
            }
            else if (args[0].equals("village_try")) {
                final int x = MathHelper.floor_double(player.posX);
                final int z = MathHelper.floor_double(player.posZ);
                int y = player.worldObj.getTopSolidOrLiquidBlock(x, z);
                if (y < 63) {
                    y = 64;
                }
                TownKoaVillageGenHelper.hookTryGenVillage(new ChunkCoordinates(x, y, z), player.worldObj);
            }
            else if (args[0].equals("village_clear")) {
                final WorldDirector wd2 = WorldDirectorManager.instance().getCoroUtilWorldDirector(player.worldObj);
                for (final Map.Entry<Integer, ManagedLocation> entry : wd2.lookupTickingManagedLocations.entrySet()) {
                    entry.getValue().cleanup();
                    wd2.removeTickingLocation((ManagedLocation)entry.getValue());
                }
            }
            else if (args[0].equals("village_regen")) {
                final WorldDirector wd2 = WorldDirectorManager.instance().getCoroUtilWorldDirector(player.worldObj);
                for (final ManagedLocation ml : wd2.lookupTickingManagedLocations.values()) {
                    ml.initFirstTime();
                }
            }
            else if (args[0].equals("village_repopulate")) {
                final WorldDirector wd2 = WorldDirectorManager.instance().getCoroUtilWorldDirector(player.worldObj);
                for (final ManagedLocation ml : wd2.lookupTickingManagedLocations.values()) {
                    if (ml instanceof TownKoaVillage) {}
                }
            }
        }
    }
}
