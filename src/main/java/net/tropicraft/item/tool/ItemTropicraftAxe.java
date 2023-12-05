package net.tropicraft.item.tool;

import java.util.*;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.tropicraft.block.*;
import net.tropicraft.registry.*;

import com.google.common.collect.*;

public class ItemTropicraftAxe extends ItemTropicraftTool {

    private static final HashSet<Block> effectiveBlocks;

    public ItemTropicraftAxe(final Item.ToolMaterial toolMaterial, final String textureName) {
        super(3.0f, toolMaterial, ItemTropicraftAxe.effectiveBlocks);
        this.setTextureName(textureName);
    }

    public float func_150893_a(final ItemStack itemstack, final Block block) {
        if (block instanceof BlockTropicraft) {}
        return (block.getMaterial() != Material.wood && block.getMaterial() != Material.plants
            && block.getMaterial() != Material.vine) ? super.func_150893_a(itemstack, block)
                : this.efficiencyOnProperMaterial;
    }

    static {
        effectiveBlocks = Sets.newHashSet(
            Blocks.planks,
            Blocks.bookshelf,
            Blocks.log,
            Blocks.log2,
            (Block) Blocks.chest,
            Blocks.pumpkin,
            Blocks.lit_pumpkin,
            (Block) TCBlockRegistry.logs,
            (Block) TCBlockRegistry.mahoganyStairs,
            (Block) TCBlockRegistry.palmFence,
            (Block) TCBlockRegistry.palmFenceGate,
            (Block) TCBlockRegistry.palmStairs,
            (Block) TCBlockRegistry.planks);
    }
}
