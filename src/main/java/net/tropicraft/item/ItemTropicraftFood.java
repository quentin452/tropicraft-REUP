package net.tropicraft.item;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.item.*;
import net.tropicraft.registry.*;

import cpw.mods.fml.relauncher.*;

public class ItemTropicraftFood extends ItemFood {

    public ItemTropicraftFood(final int healAmt, final float saturationModifier) {
        super(healAmt, saturationModifier, false);
        this.setCreativeTab(TCCreativeTabRegistry.tabFood);
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
        this.itemIcon = iconRegister.registerIcon(
            this.getUnlocalizedName()
                .substring(
                    this.getUnlocalizedName()
                        .indexOf(".") + 1));
    }
}
