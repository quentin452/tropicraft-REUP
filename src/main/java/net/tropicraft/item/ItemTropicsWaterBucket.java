package net.tropicraft.item;

import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.tropicraft.registry.*;
import net.minecraftforge.fluids.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.util.*;

public class ItemTropicsWaterBucket extends ItemFluidContainer
{
    public ItemTropicsWaterBucket() {
        super(0, 1000);
        this.maxStackSize = 1;
        this.setCreativeTab(TCCreativeTabRegistry.tabMisc);
    }
    
    public void getSubItems(final Item item, final CreativeTabs creativeTabs, final List list) {
        final ItemStack fluid = new ItemStack(item);
        this.fill(fluid, new FluidStack(TCFluidRegistry.tropicsWater, 1000), true);
        list.add(fluid);
    }
    
    public ItemStack onItemRightClick(final ItemStack itemStack, final World world, final EntityPlayer player) {
        final MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, false);
        if (movingobjectposition != null) {
            int i = movingobjectposition.blockX;
            int j = movingobjectposition.blockY;
            int k = movingobjectposition.blockZ;
            if (movingobjectposition.sideHit == 0) {
                --j;
            }
            if (movingobjectposition.sideHit == 1) {
                ++j;
            }
            if (movingobjectposition.sideHit == 2) {
                --k;
            }
            if (movingobjectposition.sideHit == 3) {
                ++k;
            }
            if (movingobjectposition.sideHit == 4) {
                --i;
            }
            if (movingobjectposition.sideHit == 5) {
                ++i;
            }
            if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemStack)) {
                return itemStack;
            }
            if (this.tryPlaceContainedLiquid(itemStack, world, i, j, k) && !player.capabilities.isCreativeMode) {
                return new ItemStack(Items.bucket);
            }
        }
        return itemStack;
    }
    
    public boolean tryPlaceContainedLiquid(final ItemStack itemStack, final World world, final int x, final int y, final int z) {
        final FluidStack fluid = this.getFluid(itemStack);
        if (fluid == null || fluid.amount == 0) {
            return false;
        }
        final Material material = world.getBlock(x, y, z).getMaterial();
        final boolean isSolid = material.isSolid();
        if (!world.isAirBlock(x, y, z) && isSolid) {
            return false;
        }
        if (!world.isRemote && !isSolid && !material.isLiquid()) {
            world.func_147480_a(x, y, z, true);
        }
        world.setBlock(x, y, z, fluid.getFluid().getBlock(), 0, 3);
        return true;
    }
    
    public IIcon getIcon(final ItemStack itemStack, final int renderPass) {
        final FluidStack fluid = this.getFluid(itemStack);
        if (fluid != null && fluid.amount != 0 && this.itemIcon != null) {
            return this.itemIcon;
        }
        return Items.bucket.getIconFromDamage(0);
    }
    
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("tropicraft:bucketTropicsWater");
    }
    
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return true;
    }
    
    public String getItemStackDisplayName(final ItemStack itemStack) {
        final FluidStack fluid = this.getFluid(itemStack);
        if (fluid != null && fluid.amount != 0) {
            return StatCollector.translateToLocal(fluid.getFluid().getUnlocalizedName().replace("fluid.", String.format("item.%s:", "tropicraft")).split(":")[0] + ":" + "bucketTropicsWater" + ".name");
        }
        return Items.bucket.getUnlocalizedName() + ".name";
    }
}
