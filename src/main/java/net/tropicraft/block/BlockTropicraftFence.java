package net.tropicraft.block;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.world.*;
import net.tropicraft.registry.*;

import cpw.mods.fml.relauncher.*;

public class BlockTropicraftFence extends BlockFence {

    private BlockTropicraftFenceGate fenceGate;

    public BlockTropicraftFence(final String name, final String textureName, final BlockTropicraftFenceGate fenceGate,
        final Material material) {
        super(name, material);
        this.setCreativeTab(TCCreativeTabRegistry.tabDecorations);
        this.setBlockName(name);
        this.setBlockTextureName(textureName);
    }

    public boolean canConnectFenceTo(final IBlockAccess world, final int x, final int y, final int z) {
        final Block block = world.getBlock(x, y, z);
        return block == this || block == TCBlockRegistry.bambooFenceGate
            || block == TCBlockRegistry.palmFenceGate
            || (block != null && block.getMaterial()
                .isOpaque() && block.renderAsNormalBlock() && block.getMaterial() != Material.gourd);
    }

    public boolean canPlaceTorchOnTop(final World world, final int x, final int y, final int z) {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(this.getActualName(this.getFormattedTextureName()));
    }

    protected String getFormattedTextureName() {
        return String.format("tile.%s%s", "tropicraft:", this.getActualName(this.getTextureName()));
    }

    public String getUnlocalizedName() {
        return String.format("tile.%s%s", "tropicraft:", this.getActualName(super.getUnlocalizedName()));
    }

    protected String getActualName(final String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(46) + 1);
    }
}
