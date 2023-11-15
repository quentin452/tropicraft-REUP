package net.tropicraft.item.scuba;

import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraftforge.common.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public class ItemScubaFlippers extends ItemScubaGear
{
    public ItemScubaFlippers(final ItemArmor.ArmorMaterial material, final ScubaMaterial scubaMaterial, final int renderIndex, final int armorType) {
        super(material, scubaMaterial, renderIndex, armorType);
    }
    
    public ISpecialArmor.ArmorProperties getProperties(final EntityLivingBase player, final ItemStack armor, final DamageSource source, final double damage, final int slot) {
        return null;
    }
    
    public int getArmorDisplay(final EntityPlayer player, final ItemStack armor, final int slot) {
        return 0;
    }
    
    public void damageArmor(final EntityLivingBase entity, final ItemStack stack, final DamageSource source, final int damage, final int slot) {
    }
    
    @Override
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        if (player.isInWater() || this.isFullyUnderwater(world, player)) {
            player.capabilities.isFlying = true;
            player.setAIMoveSpeed(player.capabilities.getWalkSpeed());
            player.moveFlying(1.0E-4f, 1.0E-4f, 1.0E-11f);
            player.motionX /= 1.06999999;
            player.motionZ /= 1.06999999;
            player.moveEntityWithHeading(-1.0E-4f, -1.0E-4f);
        }
        else {
            player.setAIMoveSpeed((float)(player.getAIMoveSpeed() / 1.33333));
            player.capabilities.isFlying = false;
        }
    }
    
    private boolean isFullyUnderwater(final World world, final EntityPlayer player) {
        final int x = MathHelper.ceiling_double_int(player.posX);
        final int y = MathHelper.ceiling_double_int(player.posY + player.height - 0.5);
        final int z = MathHelper.ceiling_double_int(player.posZ);
        return world.getBlock(x, y, z).getMaterial().isLiquid();
    }
}
