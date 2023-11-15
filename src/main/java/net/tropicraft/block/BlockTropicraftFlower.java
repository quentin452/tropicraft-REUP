package net.tropicraft.block;

import net.minecraft.block.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.material.*;
import net.tropicraft.registry.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.texture.*;

public class BlockTropicraftFlower extends BlockBush
{
    private String[] names;
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
    
    public BlockTropicraftFlower(final String[] names) {
        super(Material.plants);
        this.names = names;
        this.setBlockTextureName("flower");
        this.setCreativeTab(TCCreativeTabRegistry.tabDecorations);
        this.setStepSound(BlockTropicraftFlower.soundTypeGrass);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int id, int metadata) {
        if (metadata < 0 || metadata > this.names.length - 1) {
            metadata = this.names.length - 1;
        }
        return this.icons[metadata];
    }
    
    public int damageDropped(final int meta) {
        return meta;
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(final Item item, final CreativeTabs tab, final List list) {
        for (int i = 0; i < this.names.length; ++i) {
            list.add(new ItemStack(item, 1, i));
        }
    }
    
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", "tropicraft:", this.getActualName(super.getUnlocalizedName()));
    }
    
    protected String getActualName(final String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(46) + 1);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icons = new IIcon[this.names.length];
        for (int i = 0; i < this.names.length; ++i) {
            this.icons[i] = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "_" + i);
        }
    }
}
