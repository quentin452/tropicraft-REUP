package net.tropicraft.block;

import net.minecraft.block.material.*;

public class BlockChunkOHead extends BlockTropicraft {

    public BlockChunkOHead() {
        super(Material.rock);
        this.setBlockName("chunk");
        this.setHardness(2.0f);
        this.setResistance(30.0f);
    }
}
