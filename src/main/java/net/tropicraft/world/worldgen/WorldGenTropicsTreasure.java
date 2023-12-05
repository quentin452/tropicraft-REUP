package net.tropicraft.world.worldgen;

import java.util.*;

import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;
import net.minecraft.world.storage.*;
import net.tropicraft.registry.*;

public class WorldGenTropicsTreasure extends TCGenBase {

    private static final List<Item> treasureList;
    private static final List<Block> sandBlocks;

    public WorldGenTropicsTreasure(final World worldObj, final Random rand) {
        super(worldObj, rand);
    }

    public boolean generate(final int i, int j, final int k) {
        final int depth = this.rand.nextInt(2) + 2;
        int tries = 0;
        Label_0015: while (tries < 10) {
            final int x = i + this.rand.nextInt(8) - this.rand.nextInt(8);
            final int z = k + this.rand.nextInt(8) - this.rand.nextInt(8);
            int y;
            int sandArea;
            Label_0427: while (true) {
                for (j = (y = this.getTerrainHeightAt(x, z) - 1); y > j - depth; --y) {
                    if (!WorldGenTropicsTreasure.sandBlocks.contains(this.worldObj.getBlock(x, y, z))) {
                        ++tries;
                        continue Label_0015;
                    }
                }
                sandArea = 3;
                for (int surroundZ = z - sandArea; surroundZ <= z + sandArea; ++surroundZ) {
                    for (int surroundX = x - sandArea; surroundX <= x + sandArea; ++surroundX) {
                        if (!WorldGenTropicsTreasure.sandBlocks
                            .contains(this.worldObj.getBlock(surroundX, j, surroundZ))) {
                            continue Label_0427;
                        }
                    }
                }
                break;
            }
            for (int surroundZ = z - sandArea; surroundZ <= z + sandArea; ++surroundZ) {
                for (int surroundX = x - sandArea; surroundX <= x + sandArea; ++surroundX) {
                    if (this.rand.nextFloat() < 0.2f) {
                        this.worldObj.setBlock(surroundX, j, surroundZ, TCBlockRegistry.purifiedSand);
                    }
                }
            }
            this.worldObj.setBlock(x, y, z, TCBlockRegistry.bambooChest);
            final TileEntityChest tileentitychest = (TileEntityChest) this.worldObj.getTileEntity(x, y, z);
            if (tileentitychest == null) {
                return false;
            }
            boolean hasAddedMap = false;
            for (int e = 0; e < 8; ++e) {
                final ItemStack itemstack = this.pickCheckLootItem(this.worldObj, this.rand, x, y, z);
                if (itemstack.getItem() != Items.map || !hasAddedMap) {
                    if (itemstack.getItem() == Items.map) {
                        hasAddedMap = true;
                        this.initializeMap(this.worldObj, itemstack, x, y, z);
                    }
                    tileentitychest
                        .setInventorySlotContents(this.rand.nextInt(tileentitychest.getSizeInventory()), itemstack);
                }
            }
            return true;
        }
        return true;
    }

    private ItemStack pickCheckLootItem(final World worldObj, final Random rand, final int x, final int y,
        final int z) {
        final Item loot = WorldGenTropicsTreasure.treasureList
            .get(rand.nextInt(WorldGenTropicsTreasure.treasureList.size()));
        if (loot == Items.iron_ingot) {
            return new ItemStack(loot, rand.nextInt(36) + 1);
        }
        if (loot == Items.gold_ingot) {
            return new ItemStack(loot, rand.nextInt(46) + 1);
        }
        if (loot == Items.diamond) {
            return new ItemStack(loot, rand.nextInt(24) + 6);
        }
        if (loot == Items.arrow) {
            return new ItemStack(loot, rand.nextInt(45) + 1);
        }
        if (loot == Items.gold_nugget) {
            return new ItemStack(loot, rand.nextInt(40) + 1);
        }
        if (loot == TCItemRegistry.ore) {
            return new ItemStack(loot, rand.nextInt(10) + 5, rand.nextInt(5));
        }
        if (loot == TCItemRegistry.shells) {
            return new ItemStack(loot, rand.nextInt(4) + 2, rand.nextInt(6));
        }
        return new ItemStack(loot);
    }

    private void initializeMap(final World worldObj, final ItemStack mapItem, final int x, final int y, final int z) {
        mapItem.setItemDamage(worldObj.getUniqueDataId("map"));
        final String mapName = "map_" + mapItem.getItemDamage();
        final MapData data = new MapData(mapName);
        worldObj.setItemData(mapName, data);
        data.xCenter = x;
        data.zCenter = z;
        data.scale = 3;
        data.markDirty();
    }

    static {
        treasureList = new ArrayList<>();
        sandBlocks = new ArrayList<>();
        WorldGenTropicsTreasure.treasureList.add(Items.iron_ingot);
        WorldGenTropicsTreasure.treasureList.add(Items.gold_ingot);
        WorldGenTropicsTreasure.treasureList.add(Items.diamond);
        WorldGenTropicsTreasure.treasureList.add(TCItemRegistry.ore);
        WorldGenTropicsTreasure.treasureList.add(TCItemRegistry.shells);
        WorldGenTropicsTreasure.treasureList.add(TCItemRegistry.scaleHelmet);
        WorldGenTropicsTreasure.treasureList.add(TCItemRegistry.scaleBoots);
        WorldGenTropicsTreasure.treasureList.add(TCItemRegistry.scaleChestplate);
        WorldGenTropicsTreasure.treasureList.add(TCItemRegistry.scaleLeggings);
        WorldGenTropicsTreasure.treasureList.add(Items.golden_apple);
        WorldGenTropicsTreasure.treasureList.add(Items.arrow);
        WorldGenTropicsTreasure.treasureList.add(TCItemRegistry.swordEudialyte);
        WorldGenTropicsTreasure.treasureList.add(TCItemRegistry.swordZircon);
        WorldGenTropicsTreasure.treasureList.add(Items.gold_nugget);
        WorldGenTropicsTreasure.treasureList.add(Items.map);
        WorldGenTropicsTreasure.treasureList.add(Items.spider_eye);
        WorldGenTropicsTreasure.treasureList.add(TCItemRegistry.recordTradeWinds);
        WorldGenTropicsTreasure.treasureList.add(TCItemRegistry.recordEasternIsles);
        WorldGenTropicsTreasure.treasureList.add(TCItemRegistry.recordBuriedTreasure);
        WorldGenTropicsTreasure.treasureList.add(TCItemRegistry.recordLowTide);
        WorldGenTropicsTreasure.treasureList.add(TCItemRegistry.recordSummering);
        WorldGenTropicsTreasure.treasureList.add(TCItemRegistry.recordTheTribe);
        WorldGenTropicsTreasure.sandBlocks.add(Blocks.sand);
        WorldGenTropicsTreasure.sandBlocks.add(Blocks.sandstone);
        WorldGenTropicsTreasure.sandBlocks.add(TCBlockRegistry.purifiedSand);
    }
}
