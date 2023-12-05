package net.tropicraft.item.armor;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public class ItemScaleArmor extends ItemTropicraftArmor {

    public ItemScaleArmor(final ItemArmor.ArmorMaterial material, final int renderIndex, final int armorType) {
        super(material, renderIndex, armorType);
    }

    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {}
}
