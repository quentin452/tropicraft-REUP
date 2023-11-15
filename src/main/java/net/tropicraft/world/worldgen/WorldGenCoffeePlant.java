package net.tropicraft.world.worldgen;

import net.minecraftforge.common.util.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.tropicraft.registry.*;
import net.minecraft.block.*;

public class WorldGenCoffeePlant extends TCGenBase
{
    private static final ForgeDirection[] cardinalDirections;
    
    public WorldGenCoffeePlant(final World world, final Random rand) {
        super(world, rand);
    }
    
    public boolean generate(final int x, final int y, final int z) {
        final int nx = x + this.rand.nextInt(8) - this.rand.nextInt(8);
        final int nz = z + this.rand.nextInt(8) - this.rand.nextInt(8);
        final int ny = y;
        if (!this.worldObj.isAirBlock(nx, ny, nz) || this.worldObj.getBlock(nx, ny - 1, nz) != Blocks.grass) {
            return false;
        }
        ForgeDirection viableDirection = ForgeDirection.UNKNOWN;
        for (final ForgeDirection dir : WorldGenCoffeePlant.cardinalDirections) {
            final int neighborx = nx + dir.offsetX;
            final int neighborz = nz + dir.offsetZ;
            if (this.worldObj.getBlock(neighborx, ny - 1, neighborz).getMaterial() == Material.water) {
                viableDirection = dir;
                break;
            }
        }
        if (viableDirection == ForgeDirection.UNKNOWN) {
            for (final ForgeDirection dir : WorldGenCoffeePlant.cardinalDirections) {
                final int neighborx = nx + dir.offsetX;
                final int neighborz = nz + dir.offsetZ;
                if (this.worldObj.isAirBlock(neighborx, ny, neighborz) && this.worldObj.getBlock(neighborx, ny - 1, neighborz) == Blocks.grass) {
                    if (!this.worldObj.isAirBlock(neighborx, ny - 2, neighborz)) {
                        boolean surrounded = true;
                        for (final ForgeDirection surroundingDir : WorldGenCoffeePlant.cardinalDirections) {
                            final int surroundingx = neighborx + surroundingDir.offsetX;
                            final int surroundingz = neighborz + surroundingDir.offsetZ;
                            if (!this.worldObj.isAirBlock(surroundingx, ny, surroundingz) || this.worldObj.getBlock(surroundingx, ny - 1, surroundingz) != Blocks.grass) {
                                surrounded = false;
                                break;
                            }
                        }
                        if (surrounded) {
                            viableDirection = dir;
                            break;
                        }
                    }
                }
            }
        }
        if (viableDirection == ForgeDirection.UNKNOWN) {
            return false;
        }
        this.worldObj.setBlock(nx + viableDirection.offsetX, ny - 1, nz + viableDirection.offsetZ, Blocks.water, 0, WorldGenCoffeePlant.blockGenNotifyFlag);
        this.worldObj.setBlock(nx, ny - 1, nz, Blocks.farmland, 7, WorldGenCoffeePlant.blockGenNotifyFlag);
        for (int i = 0; i < 3 && this.worldObj.isAirBlock(nx, ny + i, nz); ++i) {
            this.worldObj.setBlock(nx, ny + i, nz, (Block)TCBlockRegistry.coffeePlant, 6, WorldGenCoffeePlant.blockGenNotifyFlag);
        }
        return true;
    }
    
    static {
        cardinalDirections = new ForgeDirection[] { ForgeDirection.NORTH, ForgeDirection.EAST, ForgeDirection.SOUTH, ForgeDirection.WEST };
    }
}
