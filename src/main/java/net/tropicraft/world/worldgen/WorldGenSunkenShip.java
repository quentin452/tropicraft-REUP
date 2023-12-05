package net.tropicraft.world.worldgen;

import java.util.*;

import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.tropicraft.block.tileentity.*;
import net.tropicraft.registry.*;

public class WorldGenSunkenShip extends TCDirectionalGen {

    public WorldGenSunkenShip(final World world, final Random random) {
        super(world, random, random.nextInt(4));
    }

    public boolean generate(final int i, int j, final int k) {
        this.setOrigin(i, k);
        if (this.worldObj.getBlock(i, j + 4, k) != TCBlockRegistry.tropicsWater) {
            return false;
        }
        ++j;
        final int length = this.rand.nextInt(25) + 25;
        int y = j;
        while (true) {
            boolean hasGenned = false;
            int fib = 2;
            int lastFib = 1;
            int width = y - j;
            for (int x = 0; x < length; ++x) {
                if (x == fib && x <= length / 3.0) {
                    ++width;
                    fib += lastFib;
                    lastFib = fib - lastFib;
                }
                if (x > length - 3) {
                    --width;
                }
                if (width >= 0) {
                    for (int z = -width; z <= width; ++z) {
                        if (this.rand.nextInt(5) < 3) {
                            if (y == j || x == length - 1) {
                                this.placeBlockWithDir(x, y, z, (Block) TCBlockRegistry.planks, 1);
                                if (z == -width || z == width || x == length - 1) {
                                    this.placeBlockWithDir(x, y + 1, z, (Block) TCBlockRegistry.planks, 1);
                                }
                                if (x == length / 2 && z == 0) {
                                    this.placeBlockWithDir(x, y + 1, z, (Block) TCBlockRegistry.planks, 1);
                                    this.placeBlockWithDir(x, y + 2, z, (Block) TCBlockRegistry.planks, 1);
                                    this.placeBlockWithDir(x, y + 3, z, (Block) TCBlockRegistry.planks, 1);
                                }
                            } else if (x == length / 2 && z == 0 && y == j - 2) {
                                this.placeBlockWithDir(x, y, z, (Block) TCBlockRegistry.bambooChest, 0);
                                final TileEntityBambooChest chest = (TileEntityBambooChest) this.getTEWithDir(x, y, z);
                                if (chest != null) {
                                    chest.setInventorySlotContents(0, this.randLoot());
                                }
                            } else if (z == -width || z == width) {
                                this.placeBlockWithDir(x, y, z, (Block) TCBlockRegistry.planks, 1);
                            } else {
                                this.placeBlockWithDir(x, y, z, Blocks.air, 0);
                            }
                        }
                    }
                    hasGenned = true;
                }
            }
            if (!hasGenned) {
                break;
            }
            --y;
        }
        return false;
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
            return new ItemStack(Items.gold_ingot, this.rand.nextInt(4) + 2);
        }
        if (picker < 15) {
            return new ItemStack(TCItemRegistry.shells, this.rand.nextInt(5) + 1, this.rand.nextInt(6));
        }
        return new ItemStack((Item) TCItemRegistry.blowGun, 1);
    }
}
