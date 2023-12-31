package net.tropicraft.item;

import java.util.*;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.tropicraft.registry.*;
import net.tropicraft.util.*;
import net.tropicraft.world.*;

import cpw.mods.fml.common.*;
import cpw.mods.fml.relauncher.*;

public class ItemPortalEnchanter extends ItemTropicraft {

    public ItemPortalEnchanter() {
        this.maxStackSize = 1;
        this.setCreativeTab(TCCreativeTabRegistry.tabMisc);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack itemstack, final EntityPlayer ent, final List list, final boolean wat) {
        list.add(StatCollector.translateToLocal("portalenchanter.type_" + itemstack.getItemDamage()));
    }

    public void getSubItems(final Item item, final CreativeTabs tabs, final List list) {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
    }

    public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        if (!world.isRemote && (itemstack.getItemDamage() == 1 || entityplayer.capabilities.isCreativeMode)) {
            final int destination = (entityplayer.dimension == 0) ? -127 : 0;
            TropicraftWorldUtils.teleportPlayer((EntityPlayerMP) entityplayer);
            return itemstack;
        }
        final double playerX = entityplayer.prevPosX + (entityplayer.posX - entityplayer.prevPosX);
        final double playerY = entityplayer.prevPosY + (entityplayer.posY - entityplayer.prevPosY)
            + 1.62
            - entityplayer.yOffset;
        final double playerZ = entityplayer.prevPosZ + (entityplayer.posZ - entityplayer.prevPosZ);
        final MovingObjectPosition target = this.getMovingObjectPositionFromPlayer(world, entityplayer, true);
        if (target == null || world.isRemote) {
            return itemstack;
        }
        if (target.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            final int x = target.blockX;
            final int y = target.blockY;
            final int z = target.blockZ;
            final int l = world.getBlockMetadata(x, y, z);
            if (!world.canMineBlock(entityplayer, x, y, z)) {
                return itemstack;
            }
            if (!entityplayer.canPlayerEdit(x, y, z, l, itemstack)) {
                return itemstack;
            }
            boolean found = false;
            for (int searchZ = -4; searchZ <= 4 && !found; ++searchZ) {
                for (int searchX = -4; searchX <= 4 && !found; ++searchX) {
                    if (this.canGen(world, x + searchX, y, z + searchZ)) {
                        found = true;
                        entityplayer.swingItem();
                        new TeleporterTropics(
                            FMLCommonHandler.instance()
                                .getMinecraftServerInstance()
                                .worldServerForDimension(entityplayer.dimension))
                                    .buildTeleporterAt(x + searchX, y, z + searchZ, (Entity) entityplayer);
                        itemstack.damageItem(1, (EntityLivingBase) entityplayer);
                    }
                }
            }
        }
        return itemstack;
    }

    public boolean canGen(final World world, final int x, final int y, final int z) {
        if (y < 9) {
            return false;
        }
        for (int offsetZ = -2; offsetZ < 3; ++offsetZ) {
            for (int offsetX = -2; offsetX < 3; ++offsetX) {
                if (offsetX == -2 || offsetX == 2 || offsetZ == -2 || offsetZ == 2) {
                    final Block block = world.getBlock(x + offsetX, y, z + offsetZ);
                    if (block != Blocks.sandstone && block != TCBlockRegistry.tropicsPortalWall) {
                        return false;
                    }
                } else {
                    if (world.getBlock(x + offsetX, y, z + offsetZ)
                        .getMaterial() != Material.water) {
                        return false;
                    }
                    if (!world.isAirBlock(x + offsetX, y + 1, z + offsetZ)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isFull3D() {
        return true;
    }
}
