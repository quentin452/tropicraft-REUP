package net.tropicraft.block;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.tropicraft.factory.*;

public class BlockFirePit extends BlockTropicraft implements ITileEntityProvider
{
    public BlockFirePit() {
        super(Material.circuits);
        this.setBlockTextureName("firePit");
        this.setBlockBoundsForItemRender();
        this.lightValue = 15;
    }
    
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.05f, 0.0f, 0.05f, 0.95f, 0.1f, 0.95f);
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public TileEntity createNewTileEntity(final World var1, final int var2) {
        return TileEntityFactory.getFirePitTE();
    }
}
