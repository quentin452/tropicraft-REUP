package net.tropicraft.item.tool;

import java.util.*;

import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

import com.google.common.collect.*;

public class ItemTropicraftShovel extends ItemTropicraftTool {

    private static final HashSet<Block> blocksEffectiveAgainst;

    public ItemTropicraftShovel(final Item.ToolMaterial toolMaterial, final String textureName) {
        super(1.0f, toolMaterial, ItemTropicraftShovel.blocksEffectiveAgainst);
        this.setTextureName(textureName);
    }

    public boolean func_150897_b(final Block block) {
        return block == Blocks.snow_layer || block == Blocks.snow;
    }

    static {
        blocksEffectiveAgainst = Sets.newHashSet(
            (Block) Blocks.grass,
            Blocks.dirt,
            (Block) Blocks.sand,
            Blocks.gravel,
            Blocks.snow_layer,
            Blocks.snow,
            Blocks.clay,
            Blocks.farmland,
            Blocks.soul_sand,
            (Block) Blocks.mycelium);
    }
}
