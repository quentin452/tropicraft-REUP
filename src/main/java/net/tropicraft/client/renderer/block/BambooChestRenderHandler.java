package net.tropicraft.client.renderer.block;

import cpw.mods.fml.client.registry.*;
import net.minecraft.tileentity.*;
import net.tropicraft.block.tileentity.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.tileentity.*;
import org.lwjgl.opengl.*;
import net.minecraft.world.*;
import net.tropicraft.info.*;

public class BambooChestRenderHandler implements ISimpleBlockRenderingHandler
{
    private TileEntity dummyTileEnt;
    
    public BambooChestRenderHandler() {
        this.dummyTileEnt = (TileEntity)new TileEntityBambooChest();
    }
    
    public void renderInventoryBlock(final Block block, final int metadata, final int modelID, final RenderBlocks renderer) {
        if (modelID == this.getRenderId()) {
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.dummyTileEnt, 0.0, 0.0, 0.0, 0.0f);
            GL11.glEnable(32826);
        }
    }
    
    public boolean renderWorldBlock(final IBlockAccess world, final int x, final int y, final int z, final Block block, final int modelId, final RenderBlocks renderer) {
        return false;
    }
    
    public boolean shouldRender3DInInventory(final int modelId) {
        return true;
    }
    
    public int getRenderId() {
        return TCRenderIDs.bambooChest;
    }
}
