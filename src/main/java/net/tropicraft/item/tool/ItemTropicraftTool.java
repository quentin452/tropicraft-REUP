package net.tropicraft.item.tool;

import java.util.*;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.item.*;
import net.tropicraft.registry.*;

import cpw.mods.fml.relauncher.*;

public class ItemTropicraftTool extends ItemTool {

    public ItemTropicraftTool(final float damageModifier, final Item.ToolMaterial toolMaterial,
        final Set<?> effectiveBlocks) {
        super(damageModifier, toolMaterial, (Set) effectiveBlocks);
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
