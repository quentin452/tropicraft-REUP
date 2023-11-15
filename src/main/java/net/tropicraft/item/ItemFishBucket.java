package net.tropicraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.tropicraft.entity.underdasea.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.tropicraft.registry.*;
import net.minecraftforge.fluids.*;
import net.minecraft.creativetab.*;
import java.util.*;
import cpw.mods.fml.relauncher.*;

public class ItemFishBucket extends ItemTropicraft
{
    public ItemFishBucket() {
        this.maxStackSize = 1;
        this.hasSubtypes = true;
        this.setCreativeTab(TCCreativeTabRegistry.tabMisc);
    }
    
    public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        if (!world.isRemote) {
            final EntityTropicalFish fish = new EntityTropicalFish(world);
            fish.setPosition(entityplayer.posX, entityplayer.posY, entityplayer.posZ);
            fish.setColor(itemstack.getItemDamage());
            fish.disableDespawning();
            world.spawnEntityInWorld((Entity)fish);
        }
        final ItemStack stack = new ItemStack((Item)TCItemRegistry.bucketTropicsWater);
        TCItemRegistry.bucketTropicsWater.fill(stack, new FluidStack(TCFluidRegistry.tropicsWater, 1000), true);
        return stack;
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubItems(final Item item, final CreativeTabs par2CreativeTabs, final List par3List) {
        for (int index = 0; index < EntityTropicalFish.names.length; ++index) {
            par3List.add(new ItemStack(item, 1, index));
        }
    }
    
    public String getItemStackDisplayName(final ItemStack itemstack) {
        return EntityTropicalFish.names[itemstack.getItemDamage()];
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack itemstack, final EntityPlayer ent, final List list, final boolean wat) {
        list.clear();
        list.add(EntityTropicalFish.names[itemstack.getItemDamage()]);
    }
}
