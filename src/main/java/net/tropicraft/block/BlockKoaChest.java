package net.tropicraft.block;

import net.minecraft.block.*;
import net.tropicraft.registry.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.tropicraft.block.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class BlockKoaChest extends BlockChest
{
    public BlockKoaChest() {
        super(0);
        this.disableStats();
        this.setCreativeTab(TCCreativeTabRegistry.tabBlock);
    }
    
    public int getRenderType() {
        return -1;
    }
    
    public TileEntity createNewTileEntity(final World world, final int meta) {
        return (TileEntity)new TileEntityKoaChest();
    }
    
    public void onBlockAdded(final World world, final int i, final int j, final int k) {
        super.onBlockAdded(world, i, j, k);
    }
    
    public IIcon getIcon(final int i, final int j) {
        return this.blockIcon;
    }
    
    public float getPlayerRelativeBlockHardness(final EntityPlayer player, final World world, final int i, final int j, final int k) {
        final TileEntityKoaChest tile = (TileEntityKoaChest)world.getTileEntity(i, j, k);
        if (tile != null && tile.isUnbreakable()) {
            return 0.0f;
        }
        return super.getPlayerRelativeBlockHardness(player, world, i, j, k);
    }
    
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", "tropicraft:", this.getActualName(super.getUnlocalizedName()));
    }
    
    protected String getActualName(final String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(46) + 1);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("tropicraft:bamboochest");
    }
}
