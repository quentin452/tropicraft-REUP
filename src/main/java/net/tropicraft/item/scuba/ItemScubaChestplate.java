package net.tropicraft.item.scuba;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;

public class ItemScubaChestplate extends ItemScubaGear {

    public ItemScubaChestplate(final ItemArmor.ArmorMaterial material, final ScubaMaterial scubaMaterial,
        final int renderIndex, final int armorType) {
        super(material, scubaMaterial, renderIndex, armorType);
    }

    public ISpecialArmor.ArmorProperties getProperties(final EntityLivingBase player, final ItemStack armor,
        final DamageSource source, final double damage, final int slot) {
        return super.getProperties(player, armor, source, damage, slot);
    }

    public int getArmorDisplay(final EntityPlayer player, final ItemStack armor, final int slot) {
        return 0;
    }

    public void damageArmor(final EntityLivingBase entity, final ItemStack stack, final DamageSource source,
        final int damage, final int slot) {
        stack.damageItem(damage, entity);
    }

    @Override
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {}
}
