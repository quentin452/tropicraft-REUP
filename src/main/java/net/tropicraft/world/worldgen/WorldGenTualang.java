package net.tropicraft.world.worldgen;

import java.util.*;

import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.tropicraft.registry.*;

public class WorldGenTualang extends TCGenBase {

    private static final Block WOOD_BLOCK;
    private static final int WOOD_META = 1;
    private static final Block LEAF_BLOCK;
    private static final int LEAF_META = 1;
    private final int baseHeight;
    private final int maxHeight;

    public WorldGenTualang(final World world, final Random random, final int maxHeight, final int baseHeight) {
        super(world, random);
        this.baseHeight = baseHeight;
        this.maxHeight = maxHeight;
    }

    public boolean generate(final int i, final int j, final int k) {
        int chunkX = i >> 4;
        int chunkZ = k >> 4;
        if (!this.worldObj.getChunkProvider().chunkExists(chunkX, chunkZ)) {
            return false;
        }
        final int height = this.rand.nextInt(this.maxHeight - this.baseHeight) + this.baseHeight + j;
        final int branches = this.rand.nextInt(3) + 3;

        if (height + 6 > 256) {
            return false;
        }

        final Block blockUnder = this.worldObj.getBlock(i, j - 1, k);
        if (blockUnder != Blocks.dirt && blockUnder != Blocks.grass) {
            return false;
        }

        if (checkBlocks(i, j, k, height)) {
            return false;
        }

        setBaseBlocks(i, j, k);

        buildTrunk(i, j, k, height);

        generateBranches(i, j, k, height, branches);

        return true;
    }

    private boolean checkBlocks(int i, int j, int k, int height) {
        for (int y = j; y < j + height; ++y) {
            Block block = this.worldObj.getBlock(i, y, k);
            if (block != null && block.getMaterial().isOpaque()) {
                return true;
            }

            block = this.worldObj.getBlock(i - 1, y, k);
            if (block != null && block.getMaterial().isOpaque()) {
                return true;
            }

            block = this.worldObj.getBlock(i + 1, y, k);
            if (block != null && block.getMaterial().isOpaque()) {
                return true;
            }

            block = this.worldObj.getBlock(i, y, k - 1);
            if (block != null && block.getMaterial().isOpaque()) {
                return true;
            }

            block = this.worldObj.getBlock(i, y, k + 1);
            if (block != null && block.getMaterial().isOpaque()) {
                return true;
            }
        }
        return false;
    }

    private void setBaseBlocks(int i, int j, int k) {
        this.worldObj.setBlock(i, j, k, Blocks.dirt, 0, WorldGenTualang.blockGenNotifyFlag);
        this.worldObj.setBlock(i - 1, j, k, Blocks.dirt, 0, WorldGenTualang.blockGenNotifyFlag);
        this.worldObj.setBlock(i + 1, j, k, Blocks.dirt, 0, WorldGenTualang.blockGenNotifyFlag);
        this.worldObj.setBlock(i, j, k - 1, Blocks.dirt, 0, WorldGenTualang.blockGenNotifyFlag);
        this.worldObj.setBlock(i, j, k + 1, Blocks.dirt, 0, WorldGenTualang.blockGenNotifyFlag);
    }

    private void buildTrunk(int i, int j, int k, int height) {
        for (int y2 = j; y2 < height; ++y2) {
            for (int x = i - 1; x <= i + 1; ++x) {
                for (int z = k - 1; z <= k + 1; ++z) {
                    this.worldObj.setBlock(x, y2, z, WorldGenTualang.WOOD_BLOCK, 1, WorldGenTualang.blockGenNotifyFlag);
                }
            }
        }
    }

    private void generateBranches(int i, int j, int k, int height, int branches) {
        for (int x = 0; x < branches; ++x) {
            final int branchHeight = this.rand.nextInt(4) + 2 + height;
            final int bx = this.rand.nextInt(15) - 8 + i;
            final int bz = this.rand.nextInt(15) - 8 + k;

            int midX = i + this.sign((bx - i) / 2);
            int midZ = k + this.sign((bz - k) / 2);
            this.placeBlockLine(new int[]{midX, height, midZ}, new int[]{bx, branchHeight, bz},
                WorldGenTualang.WOOD_BLOCK, 1);

            this.genCircle(bx, branchHeight, bz, 2.0, 1.0, WorldGenTualang.LEAF_BLOCK, 1, false);
            this.genCircle(bx, branchHeight + 1, bz, 3.0, 2.0, WorldGenTualang.LEAF_BLOCK, 1, false);
        }
    }

    private int sign(final int i) {
        return (i == 0) ? 0 : ((i <= 0) ? -1 : 1);
    }

    static {
        WOOD_BLOCK = TCBlockRegistry.logs;
        LEAF_BLOCK = TCBlockRegistry.rainforestLeaves;
    }
}
