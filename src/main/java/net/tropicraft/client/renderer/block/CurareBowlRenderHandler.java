package net.tropicraft.client.renderer.block;

import net.minecraft.block.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;
import net.tropicraft.block.tileentity.*;
import net.tropicraft.info.*;

import org.lwjgl.opengl.*;

import cpw.mods.fml.client.registry.*;

public class CurareBowlRenderHandler implements ISimpleBlockRenderingHandler {

    private TileEntityCurareBowl dummyTileEntity;

    public CurareBowlRenderHandler() {
        this.dummyTileEntity = new TileEntityCurareBowl();
    }

    public void renderInventoryBlock(final Block block, final int metadata, final int modelID,
        final RenderBlocks renderer) {
        GL11.glPushMatrix();
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        TileEntityRendererDispatcher.instance
            .renderTileEntityAt((TileEntity) this.dummyTileEntity, 0.0, 0.0, 0.0, 0.0f);
        GL11.glPopMatrix();
    }

    public boolean renderWorldBlock(final IBlockAccess world, final int x, final int y, final int z, final Block block,
        final int modelId, final RenderBlocks renderer) {
        return false;
    }

    public int getRenderId() {
        return TCRenderIDs.curareBowl;
    }

    public boolean shouldRender3DInInventory(final int modelId) {
        return false;
    }
}
