package net.tropicraft.item;

import net.minecraft.block.*;
import net.minecraft.item.*;
import net.tropicraft.block.*;

public class ItemTropicraftSlab extends ItemSlab {

    public ItemTropicraftSlab(final Block block, final BlockTropicraftSlab slab1, final BlockTropicraftSlab slab2,
        final Boolean isFullSlab) {
        super(block, (BlockSlab) slab1, (BlockSlab) slab2, (boolean) isFullSlab);
    }
}
