package net.tropicraft.world.worldgen;

import java.util.*;

import net.minecraft.block.*;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.*;

public class WorldGenTallFlower extends TCGenBase {

    private final int FLOWER_TRIES;
    private final Block plantBlock;
    private final int plantBottomMeta;
    private final int plantTopMeta;

    public WorldGenTallFlower(final World world, final Random rand, final Block plantBlock,
                              final int plantBottomMeta, final int plantTopMeta) {
        super(world, rand);
        this.FLOWER_TRIES = 4;
        this.plantBlock = plantBlock;
        this.plantBottomMeta = plantBottomMeta;
        this.plantTopMeta = plantTopMeta;
    }

    public boolean generate(final int i, final int j, final int k) {
        int chunkX = i >> 4;
        int chunkZ = k >> 4;

        if (!this.worldObj.getChunkProvider().chunkExists(chunkX, chunkZ)) {
            return false;
        }

        for (int l = 0; l < this.FLOWER_TRIES; ++l) {
            final int i2 = i + this.rand.nextInt(8) - this.rand.nextInt(8);
            final int j2 = j + this.rand.nextInt(3) - this.rand.nextInt(3);
            final int k2 = k + this.rand.nextInt(8) - this.rand.nextInt(8);

            if (canPlaceFlowerAt(i2, j2, k2)) {
                placeFlower(i2, j2, k2);
            }
        }

        return true;
    }

    private boolean canPlaceFlowerAt(int i, int j, int k) {
        int blockID = Block.getIdFromBlock(this.worldObj.getBlock(i, j, k));
        int blockAboveID = Block.getIdFromBlock(this.worldObj.getBlock(i, j + 1, k));

        return blockID == 0 && blockAboveID == 0
            && this.plantBlock.canBlockStay(this.worldObj, i, j, k);
    }

    private void placeFlower(int i, int j, int k) {
        this.worldObj.setBlock(i, j, k, this.plantBlock, this.plantBottomMeta, 2);
        this.worldObj.setBlock(i, j + 1, k, this.plantBlock, this.plantTopMeta, 2);
    }
}
