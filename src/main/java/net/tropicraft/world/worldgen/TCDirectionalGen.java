package net.tropicraft.world.worldgen;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;

public abstract class TCDirectionalGen extends TCGenBase
{
    public static final int Z_PLUS = 0;
    public static final int Z_MINUS = 1;
    public static final int X_PLUS = 2;
    public static final int X_MINUS = 3;
    public int originX;
    public int originZ;
    public int dir;
    
    public TCDirectionalGen(final World world, final Random rand) {
        super(world, rand);
    }
    
    public TCDirectionalGen(final World world, final Random rand, final int dir) {
        super(world, rand);
        this.dir = dir;
    }
    
    public void setOrigin(final int originX, final int originZ) {
        this.originX = originX;
        this.originZ = originZ;
    }
    
    public void setDir(final int dir) {
        this.dir = dir;
    }
    
    public Block getBlockWithDir(final int i, final int j, final int k) {
        switch (this.dir) {
            case 2: {
                return this.worldObj.getBlock(this.originX + i, j, this.originZ + k);
            }
            case 0: {
                return this.worldObj.getBlock(this.originX + k, j, this.originZ - i);
            }
            case 3: {
                return this.worldObj.getBlock(this.originX - i, j, this.originZ - k);
            }
            case 1: {
                return this.worldObj.getBlock(this.originX - k, j, this.originZ + i);
            }
            default: {
                return null;
            }
        }
    }
    
    public void placeBlockWithDir(final int i, final int j, final int k, final Block block, final int meta) {
        switch (this.dir) {
            case 2: {
                this.worldObj.setBlock(this.originX + i, j, this.originZ + k, block, meta, TCDirectionalGen.blockGenNotifyFlag);
            }
            case 0: {
                this.worldObj.setBlock(this.originX + k, j, this.originZ - i, block, meta, TCDirectionalGen.blockGenNotifyFlag);
            }
            case 3: {
                this.worldObj.setBlock(this.originX - i, j, this.originZ - k, block, meta, TCDirectionalGen.blockGenNotifyFlag);
            }
            case 1: {
                this.worldObj.setBlock(this.originX - k, j, this.originZ + i, block, meta, TCDirectionalGen.blockGenNotifyFlag);
            }
            default: {}
        }
    }
    
    public TileEntity getTEWithDir(final int i, final int j, final int k) {
        switch (this.dir) {
            case 2: {
                return this.worldObj.getTileEntity(this.originX + i, j, this.originZ + k);
            }
            case 0: {
                return this.worldObj.getTileEntity(this.originX + k, j, this.originZ - i);
            }
            case 3: {
                return this.worldObj.getTileEntity(this.originX - i, j, this.originZ - k);
            }
            case 1: {
                return this.worldObj.getTileEntity(this.originX - k, j, this.originZ + i);
            }
            default: {
                return null;
            }
        }
    }
    
    public int getTerrainHeightWithDir(final int i, final int k) {
        switch (this.dir) {
            case 2: {
                return this.getTerrainHeightAt(this.originX + i, this.originZ + k);
            }
            case 0: {
                return this.getTerrainHeightAt(this.originX + k, this.originZ - i);
            }
            case 3: {
                return this.getTerrainHeightAt(this.originX - i, this.originZ - k);
            }
            case 1: {
                return this.getTerrainHeightAt(this.originX - k, this.originZ + i);
            }
            default: {
                return 64;
            }
        }
    }
    
    public int getActualXAt(final int i, final int k) {
        switch (this.dir) {
            case 2: {
                return this.originX + i;
            }
            case 0: {
                return this.originX + k;
            }
            case 3: {
                return this.originX - i;
            }
            case 1: {
                return this.originX - k;
            }
            default: {
                return this.originX;
            }
        }
    }
    
    public int getActualZAt(final int i, final int k) {
        switch (this.dir) {
            case 2: {
                return this.originZ + k;
            }
            case 0: {
                return this.originZ - i;
            }
            case 3: {
                return this.originZ - k;
            }
            case 1: {
                return this.originZ + i;
            }
            default: {
                return this.originZ;
            }
        }
    }
}
