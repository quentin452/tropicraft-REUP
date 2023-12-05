package net.tropicraft.block;

import java.util.*;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.tropicraft.block.tileentity.*;
import net.tropicraft.factory.*;
import net.tropicraft.registry.*;

public class BlockBambooMug extends BlockContainer {

    public BlockBambooMug() {
        super(Material.plants);
        this.setBlockBounds(0.3f, 0.0f, 0.3f, 0.7f, 0.45f, 0.7f);
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean canPlaceBlockAt(final World world, final int x, final int y, final int z) {
        return super.canPlaceBlockAt(world, x, y, z)
            && World.doesBlockHaveSolidTopSurface((IBlockAccess) world, x, y - 1, z);
    }

    public int getRenderType() {
        return -1;
    }

    public ItemStack getPickBlock(final MovingObjectPosition target, final World world, final int x, final int y,
        final int z) {
        final TileEntityBambooMug mug = (TileEntityBambooMug) world.getTileEntity(x, y, z);
        if (mug.isEmpty()) {
            return new ItemStack(TCItemRegistry.bambooMug);
        }
        return mug.cocktail.copy();
    }

    public void breakBlock(final World world, final int x, final int y, final int z, final Block par5, final int par6) {
        if (!world.isRemote) {
            final TileEntityBambooMug mug = (TileEntityBambooMug) world.getTileEntity(x, y, z);
            if (!mug.isEmpty()) {
                this.dropBlockAsItem(world, x, y, z, mug.cocktail.copy());
            } else {
                this.dropBlockAsItem(world, x, y, z, new ItemStack(TCItemRegistry.bambooMug));
            }
        }
        super.breakBlock(world, x, y, z, par5, par6);
    }

    public int quantityDropped(final Random par1Random) {
        return 0;
    }

    public void registerBlockIcons(final IIconRegister iconRegistry) {}

    public String getImageName() {
        return "bamboomug";
    }

    public TileEntity createNewTileEntity(final World p_149915_1_, final int p_149915_2_) {
        return TileEntityFactory.getBambooMugTE();
    }
}
