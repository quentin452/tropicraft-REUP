package net.tropicraft.item;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.tropicraft.entity.projectile.*;

public class ItemStaffFireball extends Item {

    public ItemStaffFireball() {
        this.maxStackSize = 1;
        this.setMaxDamage(100);
    }

    public void registerIcons(final IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("tropicraft:staff_fire");
    }

    public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        if (!entityplayer.capabilities.isCreativeMode) {
            itemstack.damageItem(1, (EntityLivingBase) entityplayer);
        }
        world.playSoundAtEntity(
            (Entity) entityplayer,
            "random.bow",
            0.5f,
            0.4f / (ItemStaffFireball.itemRand.nextFloat() * 0.4f + 0.8f));
        if (!world.isRemote) {
            world.spawnEntityInWorld((Entity) new EntityFireBall(world, (EntityLivingBase) entityplayer));
        }
        return itemstack;
    }
}
