package net.tropicraft.item;

import java.util.*;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;

import cpw.mods.fml.relauncher.*;

public class ItemTropicraftMulti extends ItemTropicraft {

    @SideOnly(Side.CLIENT)
    protected IIcon[] icons;
    protected String[] names;

    public ItemTropicraftMulti(final String[] names) {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.names = names;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(final int par1) {
        final int j = MathHelper.clamp_int(par1, 0, this.names.length - 1);
        return this.icons[j];
    }

    public String getUnlocalizedName(final ItemStack par1ItemStack) {
        final int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, this.names.length - 1);
        return super.getUnlocalizedName() + "_" + this.names[i];
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(final Item item, final CreativeTabs tab, final List list) {
        for (int i = 0; i < this.names.length; ++i) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
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

    public NBTTagCompound getTagCompound(final ItemStack stack) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }
        return stack.getTagCompound();
    }
}
