package net.tropicraft.world.worldgen;

import java.util.*;

import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.Chunk;
import net.tropicraft.registry.*;

public class WorldGenTallTree extends TCGenBase {

    private static final int VINE_CHANCE = 5;
    private static final int SMALL_LEAF_CHANCE = 3;
    private static final int SECOND_CANOPY_CHANCE = 3;
    private static final Block WOOD_BLOCK;
    private static final int WOOD_META = 1;
    private static final Block LEAF_BLOCK;
    private static final int LEAF_META = 1;

    public WorldGenTallTree(final World world, final Random random) {
        super(world, random);
    }

    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        return this.generate(i, j, k);
    }

    public boolean generate(final int i, final int j, final int k) {
        int chunkX = i >> 4;
        int chunkZ = k >> 4;

        if (!this.worldObj.getChunkProvider().chunkExists(chunkX, chunkZ)) {
            return false;
        }
        Block blockUnder = this.worldObj.getBlock(i, j - 1, k);
        if (blockUnder != Blocks.dirt && blockUnder != Blocks.grass) {
            return false;
        }
        blockUnder = this.worldObj.getBlock(i + 1, j - 1, k);
        if (blockUnder != Blocks.dirt && blockUnder != Blocks.grass) {
            return false;
        }
        blockUnder = this.worldObj.getBlock(i - 1, j - 1, k);
        if (blockUnder != Blocks.dirt && blockUnder != Blocks.grass) {
            return false;
        }
        blockUnder = this.worldObj.getBlock(i, j - 1, k + 1);
        if (blockUnder != Blocks.dirt && blockUnder != Blocks.grass) {
            return false;
        }
        blockUnder = this.worldObj.getBlock(i, j - 1, k - 1);
        if (blockUnder != Blocks.dirt && blockUnder != Blocks.grass) {
            return false;
        }
        final int height = this.rand.nextInt(15) + 15;
        for (int y = j; y < j + height + 6; ++y) {
            for (int x = i - 1; x <= i + 1; ++x) {
                for (int z = k - 1; z <= k + 1; ++z) {
                    final Block block = this.worldObj.getBlock(x, y, z);
                    if (block != Blocks.air && block != Blocks.tallgrass && block != WorldGenTallTree.LEAF_BLOCK) {
                        return false;
                    }
                }
            }
        }
        this.worldObj.setBlock(i, j, k, Blocks.dirt, 0, WorldGenTallTree.blockGenNotifyFlag);
        this.worldObj.setBlock(i - 1, j, k, Blocks.dirt, 0, WorldGenTallTree.blockGenNotifyFlag);
        this.worldObj.setBlock(i + 1, j, k, Blocks.dirt, 0, WorldGenTallTree.blockGenNotifyFlag);
        this.worldObj.setBlock(i, j, k - 1, Blocks.dirt, 0, WorldGenTallTree.blockGenNotifyFlag);
        this.worldObj.setBlock(i, j, k + 1, Blocks.dirt, 0, WorldGenTallTree.blockGenNotifyFlag);
        for (int y = j; y < j + height; ++y) {
            this.worldObj.setBlock(i, y, k, WorldGenTallTree.WOOD_BLOCK, 1, WorldGenTallTree.blockGenNotifyFlag);
            this.worldObj.setBlock(i - 1, y, k, WorldGenTallTree.WOOD_BLOCK, 1, WorldGenTallTree.blockGenNotifyFlag);
            this.worldObj.setBlock(i + 1, y, k, WorldGenTallTree.WOOD_BLOCK, 1, WorldGenTallTree.blockGenNotifyFlag);
            this.worldObj.setBlock(i, y, k - 1, WorldGenTallTree.WOOD_BLOCK, 1, WorldGenTallTree.blockGenNotifyFlag);
            this.worldObj.setBlock(i, y, k + 1, WorldGenTallTree.WOOD_BLOCK, 1, WorldGenTallTree.blockGenNotifyFlag);
            if (y - j > height / 2 && this.rand.nextInt(3) == 0) {
                final int nx = this.rand.nextInt(3) - 1 + i;
                final int nz = this.rand.nextInt(3) - 1 + k;
                this.genCircle(nx, y + 1, nz, 1.0, 0.0, WorldGenTallTree.LEAF_BLOCK, 1, false);
                this.genCircle(nx, y, nz, 2.0, 1.0, WorldGenTallTree.LEAF_BLOCK, 1, false);
                for (int x2 = nx - 3; x2 <= nx + 3; ++x2) {
                    for (int z2 = nz - 3; z2 <= nz + 3; ++z2) {
                        for (int y2 = y - 1; y2 <= y; ++y2) {
                            if (this.rand.nextInt(5) == 0) {
                                this.genVines(x2, y2, z2);
                            }
                        }
                    }
                }
            }
            if (y - j > height - height / 4 && y - j < height - 3 && this.rand.nextInt(3) == 0) {
                final int nx = i + this.rand.nextInt(9) - 4;
                final int nz = k + this.rand.nextInt(9) - 4;
                final int leafSize = this.rand.nextInt(3) + 5;
                this.genCircle(nx, y + 3, nz, (leafSize - 2), 0.0, WorldGenTallTree.LEAF_BLOCK, 1, false);
                this.genCircle(nx, y + 2, nz, (leafSize - 1), (leafSize - 3), WorldGenTallTree.LEAF_BLOCK, 1, false);
                this.genCircle(nx, y + 1, nz, leafSize, (leafSize - 1), WorldGenTallTree.LEAF_BLOCK, 1, false);
                this.placeBlockLine(new int[] { i, y - 2, k }, new int[] { nx, y + 2, nz }, WorldGenTallTree.WOOD_BLOCK, 1);
                for (int x3 = nx - leafSize; x3 <= nx + leafSize; ++x3) {
                    for (int z3 = nz - leafSize; z3 <= nz + leafSize; ++z3) {
                        for (int y3 = y; y3 <= y + 2; ++y3) {
                            if (this.rand.nextInt(5) == 0) {
                                this.genVines(x3, y3, z3);
                            }
                        }
                    }
                }
            }
        }
        final int leafSize2 = this.rand.nextInt(5) + 9;
        this.genCircle(i, j + height, k, leafSize2 - 2, 0.0, WorldGenTallTree.LEAF_BLOCK, 1, false);
        this.genCircle(i, j + height - 1, k, (leafSize2 - 1), (leafSize2 - 4), WorldGenTallTree.LEAF_BLOCK, 1, false);
        this.genCircle(i, j + height - 2, k, leafSize2, (leafSize2 - 1), WorldGenTallTree.LEAF_BLOCK, 1, false);

        generateVineCluster(i, j, k, leafSize2, height);
        return true;
    }

    private void generateVineCluster(int i, int j, int k, int leafSize2, int height) {
        List<ChunkCoordinates> vineCoordinates = new ArrayList<>();

        for (int x = i - leafSize2; x <= i + leafSize2; ++x) {
            for (int z = k - leafSize2; z <= k + leafSize2; ++z) {
                for (int y4 = j + height + 3; y4 <= j + height + 6; ++y4) {
                    if (this.rand.nextInt(5) == 0) {
                        vineCoordinates.add(new ChunkCoordinates(x, y4, z));
                    }
                }
            }
        }

        placeVines(vineCoordinates);
    }

    private void placeVines(List<ChunkCoordinates> vineCoordinates) {
        int chunkX, chunkZ;
        int vineChance = 5;

        for (ChunkCoordinates pos : vineCoordinates) {
            chunkX = pos.posX >> 4;
            chunkZ = pos.posZ >> 4;

            if (!this.worldObj.getChunkProvider().chunkExists(chunkX, chunkZ)) {
                continue;
            }

            if (this.rand.nextInt(vineChance) == 0) {
                this.genVines(pos.posX, pos.posY, pos.posZ);
            }
        }
    }

    private boolean genVines(final int i, final int j, final int k) {
        int chunkX = i >> 4;
        int chunkZ = k >> 4;

        if (!this.worldObj.getChunkProvider().chunkExists(chunkX, chunkZ)) {
            return false;
        }

        Block vineBlock = Blocks.vine;
        Random rand = this.rand;

        boolean isBlockAir = false;

        for (int m = 2; m <= 5; ++m) {
            if (vineBlock.canPlaceBlockOnSide(this.worldObj, i, j, k, m)) {
                int vineSide = 1 << Direction.facingToDirection[Facing.oppositeSide[m]];

                int maxLength = 8;
                int length = rand.nextInt(maxLength) + 1;
                int startY = j - length;
                startY = Math.max(0, startY);

                if (this.worldObj.isAirBlock(i, j, k)) {
                    isBlockAir = true;
                }

                if (isBlockAir || canPlaceVines(i, j, k, startY)) {
                    placeVinesBottomUp(i, j, k, vineBlock, vineSide, startY, j);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canPlaceVines(int i, int j, int k, int startY) {
        for (int y = j - 1; y >= startY; --y) {
            if (!this.worldObj.isAirBlock(i, y, k)) {
                return false;
            }
        }
        return true;
    }


    private void placeVinesBottomUp(int i, int j, int k, Block vineBlock, int vineSide, int startY, int endY) {
        int chunkX = i >> 4;
        int chunkZ = k >> 4;
        Chunk chunk = this.worldObj.getChunkFromChunkCoords(chunkX, chunkZ);

        int adjustedJ = Math.min(j, endY);

        for (int y = adjustedJ; y >= startY; --y) {
            int localX = i & 15;
            int localZ = k & 15;

            if (chunk.getBlock(localX, y, localZ).isAir(this.worldObj, localX, y, localZ)) {
                chunk.func_150807_a(localX, y, localZ, vineBlock, vineSide);
            }
        }
    }


    static {
        WOOD_BLOCK = TCBlockRegistry.logs;
        LEAF_BLOCK = TCBlockRegistry.rainforestLeaves;
    }
}
