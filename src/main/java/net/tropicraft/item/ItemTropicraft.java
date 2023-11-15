package net.tropicraft.item;

import net.tropicraft.registry.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class ItemTropicraft extends Item
{
    public ItemTropicraft() {
        this.maxStackSize = 1;
        this.setNoRepair();
        this.setCreativeTab(TCCreativeTabRegistry.tabMisc);
    }
    
    public String getUnlocalizedName() {
        return String.format("item.%s%s", "tropicraft:", this.getActualName(super.getUnlocalizedName()));
    }
    
    public String getUnlocalizedName(final ItemStack itemStack) {
        return String.format("item.%s%s", "tropicraft:", this.getActualName(super.getUnlocalizedName()));
    }
    
    protected String getActualName(final String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}
