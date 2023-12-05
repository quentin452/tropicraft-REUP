package net.tropicraft.world.worldgen;

import java.util.*;

import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.tropicraft.block.tileentity.*;
import net.tropicraft.registry.*;

public class WorldGenForestAltarRuin extends TCDirectionalGen {

    public WorldGenForestAltarRuin(final World world, final Random random) {
        super(world, random, random.nextInt(4));
    }

    public boolean generate(final int i, int j, final int k) {
        j = Integer.MAX_VALUE;
        this.setOrigin(i, k);
        final int width = (this.rand.nextInt(2) + 3) * 2;
        final int length = this.rand.nextInt(6) + 10;
        final int halfWidth = width / 2;
        boolean hasGennedTunnel = false;
        for (int z = 0; z < length; ++z) {
            for (int x = 0; x < width; ++x) {
                if (this.getTerrainHeightWithDir(x, z) < j) {
                    j = this.getTerrainHeightWithDir(x, z);
                }
            }
        }
        for (int y = j; this.worldObj.getBlock(i, y, k) != Blocks.air; ++y) {
            if (this.worldObj.getBlock(i, y, k) == TCBlockRegistry.tropicsWater) {
                return false;
            }
        }
        for (int z = 0; z < length; ++z) {
            int x = 0;
            Label_0157: while (x < width) {
                while (true) {
                    for (int y2 = 0; y2 < 4; ++y2) {
                        if (this.worldObj.getBlock(x, y2 + j, z) == TCBlockRegistry.logs) {
                            ++x;
                            continue Label_0157;
                        }
                        if (this.rand.nextInt(4) != 0) {
                            this.placeBlockWithDir(x, y2 + j, z, Blocks.air, 0);
                        }
                    }
                    int y2 = j;
                    this.placeBlockWithDir(x, y2, z, (Block) TCBlockRegistry.logs, 1);
                    if (z == 0) {
                        if (x == 0 || x == width - 1) {
                            this.placeBlockWithDir(x, y2 + 1, z, (Block) TCBlockRegistry.palmFence, 0);
                            this.placeBlockWithDir(x, y2 + 2, z, (Block) TCBlockRegistry.palmFence, 0);
                            continue;
                        }
                        this.placeBlockWithDir(x, y2 + 1, z, (Block) TCBlockRegistry.singleSlabs, 2);
                        this.placeBlockWithDir(x, y2 + 2, z, (Block) TCBlockRegistry.palmFence, 0);
                        continue;
                    } else if (z == 1) {
                        if (x == 0 || x == width - 1) {
                            this.placeBlockWithDir(x, y2 + 1, z, (Block) TCBlockRegistry.palmFence, 0);
                            continue;
                        }
                        if (x == 1 || x == width - 2) {
                            this.placeBlockWithDir(x, y2 + 1, z, (Block) TCBlockRegistry.chunkOHead, 0);
                            this.placeBlockWithDir(x, y2 + 2, z, (Block) TCBlockRegistry.flowerPot, 0);
                            final TileEntityTropicraftFlowerPot pot = (TileEntityTropicraftFlowerPot) this
                                .getTEWithDir(x, y2 + 2, z);
                            if (pot != null) {
                                pot.setFlowerID((short) (this.rand.nextInt(13) + 1));
                            }
                            continue;
                        }
                        if (x == halfWidth - 1 || x == halfWidth) {
                            this.placeBlockWithDir(x, y2, z, Blocks.netherrack, 0);
                            this.placeBlockWithDir(x, y2 + 1, z, (Block) Blocks.fire, 0);
                            continue;
                        }
                        this.placeBlockWithDir(x, y2 + 1, z, (Block) TCBlockRegistry.singleSlabs, 2);
                        continue;
                    } else if (z == 2) {
                        if (x == 0 || x == width - 1) {
                            this.placeBlockWithDir(x, y2 + 1, z, (Block) TCBlockRegistry.palmFence, 0);
                            continue;
                        }
                        this.placeBlockWithDir(x, y2 + 1, z, (Block) TCBlockRegistry.singleSlabs, 2);
                        continue;
                    } else if (z % 2 == 1) {
                        if (x == 0 || x == width - 1) {
                            this.placeBlockWithDir(x, y2 + 1, z, (Block) TCBlockRegistry.palmFence, 0);
                        }
                        continue;
                    } else {
                        if (x == 0 || x == width - 1) {
                            this.placeBlockWithDir(x, y2 + 1, z, (Block) TCBlockRegistry.tikiTorch, 1);
                            this.placeBlockWithDir(x, y2 + 2, z, (Block) TCBlockRegistry.tikiTorch, 1);
                            this.placeBlockWithDir(x, y2 + 3, z, (Block) TCBlockRegistry.tikiTorch, 0);
                            continue;
                        }
                        if (x == halfWidth - 1 || x == halfWidth) {
                            continue;
                        }
                        this.placeBlockWithDir(x, y2 + 1, z, (Block) TCBlockRegistry.palmStairs, this.dir);
                        if (!hasGennedTunnel) {
                            this.generateTunnel(x, y2, z);
                            hasGennedTunnel = true;
                        }
                    }
                }
            }
        }
        return true;
    }

    private void generateTunnel(int i, int j, int k) {
        final int depth = this.rand.nextInt(5) + 8;
        for (int y = 0; y < depth; ++y) {
            this.placeBlockWithDir(i, j - y, k, Blocks.air, 0);
        }
        j -= depth;
        final int length = this.rand.nextInt(20) + 30;
        int dir = this.rand.nextInt(4);
        for (int x = 0; x < length; ++x) {
            switch (dir) {
                case 0: {
                    ++i;
                    break;
                }
                case 1: {
                    ++k;
                    break;
                }
                case 2: {
                    --i;
                    break;
                }
                case 3: {
                    --k;
                    break;
                }
            }
            if (this.rand.nextInt(3) == 0) {
                j += this.rand.nextInt(3) - 1;
            }
            this.placeBlockWithDir(i, j, k, Blocks.air, 0);
            this.placeBlockWithDir(i, j + 1, k, Blocks.air, 0);
            this.placeBlockWithDir(i, j + 2, k, Blocks.air, 0);
            if (this.rand.nextInt(5) == 0) {
                dir = this.rand.nextInt(4);
            }
        }
        this.placeBlockWithDir(i, j, k, (Block) TCBlockRegistry.bambooChest, 0);
        final TileEntityBambooChest chest = (TileEntityBambooChest) this.getTEWithDir(i, j, k);
        if (chest != null) {
            chest.setInventorySlotContents(0, this.randLoot());
        }
    }

    public ItemStack randLoot() {
        final int picker = this.rand.nextInt(18);
        if (picker < 6) {
            return new ItemStack((Block) TCBlockRegistry.bambooChute, this.rand.nextInt(20) + 1);
        }
        if (picker < 10) {
            return new ItemStack((Item) TCItemRegistry.scale, this.rand.nextInt(3) + 1);
        }
        if (picker < 12) {
            return new ItemStack((Block) TCBlockRegistry.thatchBundle, this.rand.nextInt(20) + 1);
        }
        if (picker < 14) {
            return new ItemStack((Item) TCItemRegistry.cookedFrogLeg, this.rand.nextInt(4) + 1);
        }
        return new ItemStack((Item) TCItemRegistry.blowGun, 1);
    }
}
