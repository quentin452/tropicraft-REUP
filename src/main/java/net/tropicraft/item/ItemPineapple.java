package net.tropicraft.item;

import java.util.*;

import net.minecraft.block.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

import cpw.mods.fml.relauncher.*;

public class ItemPineapple extends ItemTallFlowers {

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public ItemPineapple(final Block block, final ArrayList<String> names) {
        super(block, names);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(final IIconRegister iconRegister) {
        this.icons = new IIcon[this.names.length];
        for (int i = 0; i < this.names.length; ++i) {
            this.icons[i] = iconRegister.registerIcon(
                this.getUnlocalizedName()
                    .substring(
                        this.getUnlocalizedName()
                            .indexOf(".") + 1)
                    + "Item_"
                    + this.names[i]);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(final int damage) {
        return this.block.getIcon(0, 8);
    }

    @Override
    public boolean placeBlockAt(final ItemStack stack, final EntityPlayer player, final World world, final int x,
        final int y, final int z, final int side, final float hitX, final float hitY, final float hitZ,
        final int metadata) {
        if (!world.setBlock(x, y, z, this.block, 0, 3)) {
            return false;
        }
        if (world.getBlock(x, y, z) == this.block) {
            this.block.onBlockPlacedBy(world, x, y, z, (EntityLivingBase) player, stack);
            this.block.onPostBlockPlaced(world, x, y, z, metadata);
        }
        return true;
    }

    @Override
    public int getMetadata(final int par1) {
        return par1;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(final Item item, final CreativeTabs tab, final List list) {
        for (int i = 0; i < this.icons.length; ++i) {
            list.add(new ItemStack(item, 1, i + 1));
        }
    }

    @Override
    public boolean onItemUse(final ItemStack itemstack, final EntityPlayer player, final World world, int x, int y,
        int z, int side, final float hitX, final float hitY, final float hitZ) {
        final Block block = world.getBlock(x, y, z);
        if (block == Blocks.snow_layer && (world.getBlockMetadata(x, y, z) & 0x7) < 1) {
            side = 1;
        } else if (block != Blocks.vine && block != Blocks.tallgrass
            && block != Blocks.deadbush
            && !block.isReplaceable((IBlockAccess) world, x, y, z)) {
                if (side == 0) {
                    --y;
                }
                if (side == 1) {
                    ++y;
                }
                if (side == 2) {
                    --z;
                }
                if (side == 3) {
                    ++z;
                }
                if (side == 4) {
                    --x;
                }
                if (side == 5) {
                    ++x;
                }
            }
        if (itemstack.stackSize == 0) {
            return false;
        }
        if (!player.canPlayerEdit(x, y, z, side, itemstack)) {
            return false;
        }
        if (y == 255 && this.block.getMaterial()
            .isSolid()) {
            return false;
        }
        if (world.canPlaceEntityOnSide(this.block, x, y, z, false, side, (Entity) player, itemstack)) {
            final int meta = this.block.onBlockPlaced(world, x, y, z, side, hitX, hitY, hitZ, 0);
            if (this.placeBlockAt(itemstack, player, world, x, y, z, side, hitX, hitY, hitZ, meta)) {
                world.playSoundEffect(
                    (double) (x + 0.5f),
                    (double) (y + 0.5f),
                    (double) (z + 0.5f),
                    this.block.stepSound.func_150496_b(),
                    (this.block.stepSound.getVolume() + 1.0f) / 2.0f,
                    this.block.stepSound.getPitch() * 0.8f);
                --itemstack.stackSize;
            }
            return true;
        }
        return false;
    }
}
