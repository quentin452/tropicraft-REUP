package net.tropicraft.block;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.tropicraft.registry.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class BlockPurifiedSand extends BlockFalling
{
    public BlockPurifiedSand() {
        super(Material.sand);
        this.setHardness(0.5f);
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
