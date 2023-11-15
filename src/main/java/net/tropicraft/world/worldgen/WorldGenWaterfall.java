package net.tropicraft.world.worldgen;

import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.tropicraft.registry.*;

public class WorldGenWaterfall extends TCDirectionalGen
{
    private static final Block WATER_BLOCK;
    
    public WorldGenWaterfall(final World world, final Random random) {
        super(world, random);
    }
    
    public boolean generate(final int i, final int j, final int k) {
        if (this.worldObj.getBlock(i, j, k) == Blocks.stone) {
            int size = this.rand.nextInt(4) + 3;
            if (this.worldObj.getBlock(i + 1, j, k) == Blocks.air) {
                final int dir = (this.worldObj.getBlock(i, j, k + 1) == Blocks.stone) ? 1 : -1;
                size *= dir;
                for (int x = 0; x < size; x += dir) {
                    this.worldObj.setBlock(i, j, k + x, WorldGenWaterfall.WATER_BLOCK, 0, WorldGenWaterfall.blockGenNotifyFlag);
                    if (this.worldObj.getBlock(i + 1, j, k + x + dir) != Blocks.air) {
                        break;
                    }
                    if (this.worldObj.getBlock(i + x + dir, j, k) != Blocks.stone) {
                        break;
                    }
                }
            }
            if (this.worldObj.getBlock(i - 1, j, k) == Blocks.air) {
                final int dir = (this.worldObj.getBlock(i, j, k + 1) == Blocks.stone) ? 1 : -1;
                size *= dir;
                for (int x = 0; x < size; x += dir) {
                    this.worldObj.setBlock(i, j, k + x, WorldGenWaterfall.WATER_BLOCK, 0, WorldGenWaterfall.blockGenNotifyFlag);
                    if (this.worldObj.getBlock(i - 1, j, k + x + dir) != Blocks.air) {
                        break;
                    }
                    if (this.worldObj.getBlock(i + x + dir, j, k) != Blocks.stone) {
                        break;
                    }
                }
            }
            if (this.worldObj.getBlock(i, j, k + 1) == Blocks.air) {
                final int dir = (this.worldObj.getBlock(i + 1, j, k) == Blocks.stone) ? 1 : -1;
                size *= dir;
                for (int x = 0; x < size; x += dir) {
                    this.worldObj.setBlock(i + x, j, k, WorldGenWaterfall.WATER_BLOCK, 0, WorldGenWaterfall.blockGenNotifyFlag);
                    if (this.worldObj.getBlock(i + x + dir, j, k + 1) != Blocks.air) {
                        break;
                    }
                    if (this.worldObj.getBlock(i + x + dir, j, k) != Blocks.stone) {
                        break;
                    }
                }
            }
            if (this.worldObj.getBlock(i, j, k - 1) == Blocks.air) {
                final int dir = (this.worldObj.getBlock(i + 1, j, k) == Blocks.stone) ? 1 : -1;
                size *= dir;
                for (int x = 0; x < size; x += dir) {
                    this.worldObj.setBlock(i + x, j, k, WorldGenWaterfall.WATER_BLOCK, 0, WorldGenWaterfall.blockGenNotifyFlag);
                    if (this.worldObj.getBlock(i + x + dir, j, k + 1) != Blocks.air) {
                        break;
                    }
                    if (this.worldObj.getBlock(i + x + dir, j, k) != Blocks.stone) {
                        break;
                    }
                }
            }
        }
        return true;
    }
    
    static {
        WATER_BLOCK = (Block)TCBlockRegistry.tropicsWater;
    }
}
