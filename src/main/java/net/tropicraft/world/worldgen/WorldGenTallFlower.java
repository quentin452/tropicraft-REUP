package net.tropicraft.world.worldgen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        List<ChunkCoordinates> potentialFlowerLocations = new ArrayList<>();

        for (int l = 0; l < this.FLOWER_TRIES; ++l) {
            final int i2 = i + this.rand.nextInt(17) - 8;
            final int j2 = j + this.rand.nextInt(7) - 3;
            final int k2 = k + this.rand.nextInt(17) - 8;

            potentialFlowerLocations.add(new ChunkCoordinates(i2, j2, k2));
        }

        for (ChunkCoordinates pos : potentialFlowerLocations) {
            if (canPlaceFlowerAt(pos.posX, pos.posY, pos.posZ)) {
                placeFlower(pos.posX, pos.posY, pos.posZ);
            }
        }

        return true;
    }
    private boolean canPlaceFlowerAt(int i, int j, int k) {
        Block block = this.worldObj.getBlock(i, j, k);
        Block blockAbove = this.worldObj.getBlock(i, j + 1, k);

        return block == Blocks.grass
            && blockAbove.isAir(worldObj, i, j + 1, k)
            && this.plantBlock.canBlockStay(this.worldObj, i, j, k);
    }

    private void placeFlower(int i, int j, int k) {
        this.worldObj.setBlock(i, j, k, this.plantBlock, this.plantBottomMeta, 2);
        this.worldObj.setBlock(i, j + 1, k, this.plantBlock, this.plantTopMeta, 2);
    }
}
