package net.tropicraft.item;

import net.minecraft.block.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.item.*;

public class ItemFlowerPot extends ItemReed {

    public ItemFlowerPot(final Block block) {
        super(block);
    }

    public void registerIcons(final IIconRegister registry) {
        this.itemIcon = registry.registerIcon("tropicraft:flowerPot");
    }
}
