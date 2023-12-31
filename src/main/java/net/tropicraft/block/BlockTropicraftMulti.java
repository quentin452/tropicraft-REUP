package net.tropicraft.block;

import java.util.*;

import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

import cpw.mods.fml.relauncher.*;

public class BlockTropicraftMulti extends BlockTropicraft {

    @SideOnly(Side.CLIENT)
    protected IIcon[] icons;
    protected String[] names;

    public BlockTropicraftMulti(final String[] names) {
        this.names = names;
    }

    public BlockTropicraftMulti(final String[] names, final Material material) {
        super(material);
        this.names = names;
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

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icons = new IIcon[this.names.length];
        for (int i = 0; i < this.names.length; ++i) {
            this.icons[i] = iconRegister.registerIcon(
                this.getUnlocalizedName()
                    .substring(
                        this.getUnlocalizedName()
                            .indexOf(".") + 1)
                    + "_"
                    + this.names[i]);
        }
    }
}
