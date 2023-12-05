package net.tropicraft.item;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.tropicraft.entity.projectile.*;

public class ItemStaffOfTaming extends Item {

    public ItemStaffOfTaming() {
        this.maxStackSize = 1;
    }

    public void registerIcons(final IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("tropicraft:staff_taming");
    }

    public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        if (!entityplayer.capabilities.isCreativeMode) {
            itemstack.damageItem(1, (EntityLivingBase) entityplayer);
        }
        world.playSoundAtEntity(
            (Entity) entityplayer,
            "random.bow",
            0.5f,
            0.4f / (ItemStaffOfTaming.itemRand.nextFloat() * 0.4f + 0.8f));
        if (!world.isRemote) {
            world.spawnEntityInWorld((Entity) new EntityTameBall(world, (EntityLivingBase) entityplayer));
        }
        return itemstack;
    }

    public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer player, final Entity entity) {
        if (!player.worldObj.isRemote) {
            if (player.isSneaking()) {
                if (!(entity instanceof EntityPlayer)) {
                    if (entity.ridingEntity != null) {
                        entity.mountEntity((Entity) null);
                    } else {
                        entity.mountEntity((Entity) player);
                    }
                }
            } else if (player.ridingEntity != null) {
                player.mountEntity((Entity) null);
            } else {
                player.mountEntity(entity);
            }
        }
        return true;
    }
}
