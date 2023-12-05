package net.tropicraft.block;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import net.tropicraft.registry.*;

import cpw.mods.fml.relauncher.*;

public class BlockTropicraft extends Block {

    public BlockTropicraft() {
        this(Material.rock);
    }

    public BlockTropicraft(final Material material) {
        super(material);
        this.setCreativeTab(TCCreativeTabRegistry.tabBlock);
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
