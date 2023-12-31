package net.tropicraft.item;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.tropicraft.entity.projectile.*;

import CoroUtil.entity.*;
import cpw.mods.fml.relauncher.*;

public class ItemTropicraftLeafballNew extends ItemTropicraftLeafball {

    public ItemTropicraftLeafballNew() {
        this.maxStackSize = 16;
    }

    public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        if (!entityplayer.capabilities.isCreativeMode) {
            --itemstack.stackSize;
        }
        world.playSoundAtEntity(
            (Entity) entityplayer,
            "random.bow",
            0.5f,
            0.4f / (ItemTropicraftLeafballNew.itemRand.nextFloat() * 0.4f + 0.8f));
        if (!world.isRemote) {
            world.spawnEntityInWorld((Entity) new EntityTropicraftLeafballNew(world, (EntityLivingBase) entityplayer));
        }
        return itemstack;
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
