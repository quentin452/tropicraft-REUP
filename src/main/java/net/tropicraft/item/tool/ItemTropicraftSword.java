package net.tropicraft.item.tool;

import net.tropicraft.registry.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class ItemTropicraftSword extends ItemSword
{
    public ItemTropicraftSword(final Item.ToolMaterial material, final String textureName) {
        super(material);
        this.setTextureName(textureName);
        this.setCreativeTab(TCCreativeTabRegistry.tabCombat);
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
        this.itemIcon = iconRegister.registerIcon("tropicraft:tools/" + this.getIconString());
    }
}
