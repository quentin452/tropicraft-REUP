package net.tropicraft.block;

import net.minecraft.block.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.tropicraft.block.tileentity.*;
import net.tropicraft.factory.*;
import net.tropicraft.info.*;
import net.tropicraft.registry.*;

import cpw.mods.fml.relauncher.*;

public class BlockBambooChest extends BlockChest {

    public BlockBambooChest() {
        super(0);
        this.disableStats();
        this.setCreativeTab(TCCreativeTabRegistry.tabBlock);
    }

    public int getRenderType() {
        return TCRenderIDs.bambooChest;
    }

    public TileEntity createNewTileEntity(final World world, final int i) {
        return TileEntityFactory.getBambooChestTE();
    }

    public IIcon getIcon(final int i, final int j) {
        return this.blockIcon;
    }

    public float getPlayerRelativeBlockHardness(final EntityPlayer player, final World world, final int i, final int j,
        final int k) {
        final TileEntityBambooChest tile = (TileEntityBambooChest) world.getTileEntity(i, j, k);
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
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(String.format("%s", this.getActualName(this.getUnlocalizedName())));
    }
}
