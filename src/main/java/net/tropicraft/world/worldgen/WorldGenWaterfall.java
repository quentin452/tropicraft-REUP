package net.tropicraft.world.worldgen;

import java.util.*;

import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.tropicraft.registry.*;

public class WorldGenWaterfall extends TCDirectionalGen {

    private static final Block WATER_BLOCK;

    public WorldGenWaterfall(final World world, final Random random) {
        super(world, random);
    }

    public boolean generate(final int i, final int j, final int k) {
        if (this.worldObj.getBlock(i, j, k) == Blocks.stone) {
            int size = this.rand.nextInt(4) + 3;
            sizeLoop:
            for (int[] direction : new int[][]{{1, 0, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1}}) {
                int dirX = direction[0];
                int dirY = direction[1];
                int dirZ = direction[2];

                if (this.worldObj.getBlock(i + dirX, j + dirY, k + dirZ) == Blocks.air) {
                    int dir = (this.worldObj.getBlock(i, j, k + 1) == Blocks.stone) ? 1 : -1;
                    size *= dir;

                    for (int x = 0; x < size; x += dir) {
                        this.worldObj.setBlock(i + (dirX * x), j + (dirY * x), k + (dirZ * x), WorldGenWaterfall.WATER_BLOCK, 0, WorldGenWaterfall.blockGenNotifyFlag);

                        if (this.worldObj.getBlock(i + (dirX * (x + dir)), j + (dirY * (x + dir)), k + dirZ) != Blocks.air || this.worldObj.getBlock(i + (dirX * (x + dir)), j + (dirY * (x + dir)), k) != Blocks.stone) {
                            continue sizeLoop;
                        }
                    }
                }
            }
        }
        return true;
    }

    static {
        WATER_BLOCK = TCBlockRegistry.tropicsWater;
    }
}
