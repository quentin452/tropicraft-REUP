package net.tropicraft.item.tool;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.item.*;
import net.tropicraft.registry.*;

import cpw.mods.fml.relauncher.*;

public class ItemTropicraftHoe extends ItemHoe {

    protected Item.ToolMaterial toolMaterial;

    public ItemTropicraftHoe(final Item.ToolMaterial toolMaterial, final String textureName) {
        super(toolMaterial);
        this.toolMaterial = toolMaterial;
        this.maxStackSize = 1;
        this.setMaxDamage(toolMaterial.getMaxUses());
        this.setTextureName(textureName);
        this.setCreativeTab(TCCreativeTabRegistry.tabTools);
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
