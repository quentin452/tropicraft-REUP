package net.tropicraft.block;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import net.tropicraft.registry.*;

import cpw.mods.fml.relauncher.*;

public class BlockTropicraftFenceGate extends BlockFenceGate {

    private Block blockForTexture;
    private int textureMeta;

    public BlockTropicraftFenceGate(final Block block, final int meta, final String name, final Material material) {
        this.blockForTexture = block;
        this.textureMeta = meta;
        this.setCreativeTab(TCCreativeTabRegistry.tabDecorations);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int side, final int meta) {
        return this.blockForTexture.getIcon(side, this.textureMeta);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {}

    public String getUnlocalizedName() {
        return String.format("tile.%s%s", "tropicraft:", this.getActualName(super.getUnlocalizedName()));
    }

    protected String getActualName(final String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(46) + 1);
    }
}
