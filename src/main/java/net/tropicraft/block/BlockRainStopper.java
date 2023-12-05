package net.tropicraft.block;

import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.tropicraft.registry.*;

import cpw.mods.fml.relauncher.*;

public class BlockRainStopper extends BlockTropicraft {

    public BlockRainStopper() {
        super(Material.rock);
        this.setCreativeTab(TCCreativeTabRegistry.tabBlock);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World p_149668_1_, final int p_149668_2_,
        final int p_149668_3_, final int p_149668_4_) {
        return super.getCollisionBoundingBoxFromPool(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public boolean isCollidable() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = Blocks.bedrock.getIcon(0, 0);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public int getRenderType() {
        return -1;
    }
}
