package net.tropicraft.item;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.tropicraft.config.*;
import net.tropicraft.entity.projectile.*;
import net.tropicraft.registry.*;

public class ItemCoconutBomb extends ItemTropicraft {

    public ItemCoconutBomb() {
        this.setCreativeTab(TCCreativeTabRegistry.tabCombat);
    }

    public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer player) {
        --itemstack.stackSize;
        world.playSoundAtEntity(
            (Entity) player,
            "random.bow",
            0.5f,
            0.4f / (ItemCoconutBomb.itemRand.nextFloat() * 0.4f + 0.8f));
        if (!world.isRemote && ConfigMisc.coconutBombWhitelistedUsers.contains(
            player.getGameProfile()
                .getName())) {
            world.spawnEntityInWorld((Entity) new EntityCoconutGrenade(world, player));
        } else if (!world.isRemote && !ConfigMisc.coconutBombWhitelistedUsers.contains(
            player.getGameProfile()
                .getName())) {
                    player.addChatMessage(
                        (IChatComponent) new ChatComponentText(
                            StatCollector.translateToLocal("tropicraft.coconutBombWarning")));
                }
        return itemstack;
    }

    private String getName(final EntityPlayer player) {
        return player.getCommandSenderName();
    }
}
