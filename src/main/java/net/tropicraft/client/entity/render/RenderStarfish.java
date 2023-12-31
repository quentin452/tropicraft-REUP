package net.tropicraft.client.entity.render;

import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.tropicraft.entity.underdasea.*;

import org.lwjgl.opengl.*;

public class RenderStarfish extends Render {

    public static final float BABY_RENDER_SCALE = 0.25f;
    public static final float ADULT_RENDER_SCALE = 1.0f;

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return null;
    }

    public void doRender(final Entity entity, final double d0, final double d1, final double d2, final float yaw,
        final float partialTicks) {
        final EntityStarfish starfish = (EntityStarfish) entity;
        final StarfishType type = starfish.getStarfishType();
        final float f = 0.0f;
        final float f2 = 1.0f;
        final float f3 = 0.0f;
        final float f4 = 1.0f;
        final float f1shifted = 1.0f;
        final float f3shifted = 1.0f;
        final Tessellator tessellator = Tessellator.instance;
        GL11.glPushMatrix();
        GL11.glTranslatef((float) d0 - 0.5f, (float) d1, (float) d2 - 0.5f);
        GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        final float growthProgress = starfish.getGrowthProgress();
        final float scale = 0.25f + growthProgress * 0.75f;
        GL11.glScalef(scale, scale, scale);
        GL11.glEnable(32826);
        for (int i = 0; i < type.getLayerCount(); ++i) {
            this.renderManager.renderEngine.bindTexture(
                new ResourceLocation(
                    (String) type.getTexturePaths()
                        .get(i)));
            this.popper(tessellator, f2, f3, f, f4, f1shifted, f3shifted, type.getLayerHeights()[i]);
            GL11.glTranslatef(0.0f, 0.0f, -type.getLayerHeights()[i]);
        }
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    private void popper(final Tessellator tessellator, final float f, final float f1, final float f2, final float f3,
        final float f1shifted, final float f3shifted, final float layerHeight) {
        final float f4 = 1.0f;
        final float f5 = layerHeight;
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, 0.0f, 1.0f);
        tessellator.addVertexWithUV(0.0, 0.0, 0.0, (double) f, (double) f3shifted);
        tessellator.addVertexWithUV((double) f4, 0.0, 0.0, (double) f2, (double) f3shifted);
        tessellator.addVertexWithUV((double) f4, 1.0, 0.0, (double) f2, (double) f1shifted);
        tessellator.addVertexWithUV(0.0, 1.0, 0.0, (double) f, (double) f1shifted);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, 0.0f, -1.0f);
        tessellator.addVertexWithUV(0.0, 1.0, (double) (0.0f - f5), (double) f, (double) f1);
        tessellator.addVertexWithUV((double) f4, 1.0, (double) (0.0f - f5), (double) f2, (double) f1);
        tessellator.addVertexWithUV((double) f4, 0.0, (double) (0.0f - f5), (double) f2, (double) f3);
        tessellator.addVertexWithUV(0.0, 0.0, (double) (0.0f - f5), (double) f, (double) f3);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0f, 0.0f, 0.0f);
        for (int i = 0; i < 32; ++i) {
            final float f6 = i / 32.0f;
            final float f7 = f + (f2 - f) * f6 - 0.001953125f;
            final float f8 = f4 * f6;
            tessellator.addVertexWithUV((double) f8, 0.0, (double) (0.0f - f5), (double) f7, (double) f3);
            tessellator.addVertexWithUV((double) f8, 0.0, 0.0, (double) f7, (double) f3);
            tessellator.addVertexWithUV((double) f8, 1.0, 0.0, (double) f7, (double) f1);
            tessellator.addVertexWithUV((double) f8, 1.0, (double) (0.0f - f5), (double) f7, (double) f1);
        }
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0f, 0.0f, 0.0f);
        for (int j = 0; j < 32; ++j) {
            final float f9 = j / 32.0f;
            final float f10 = f + (f2 - f) * f9 - 0.001953125f;
            final float f11 = f4 * f9 + 0.03125f;
            tessellator.addVertexWithUV((double) f11, 1.0, (double) (0.0f - f5), (double) f10, (double) f1);
            tessellator.addVertexWithUV((double) f11, 1.0, 0.0, (double) f10, (double) f1);
            tessellator.addVertexWithUV((double) f11, 0.0, 0.0, (double) f10, (double) f3);
            tessellator.addVertexWithUV((double) f11, 0.0, (double) (0.0f - f5), (double) f10, (double) f3);
        }
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, 1.0f, 0.0f);
        for (int k = 0; k < 32; ++k) {
            final float f12 = k / 32.0f;
            final float f13 = f3 + (f1 - f3) * f12 - 0.001953125f;
            final float f14 = f4 * f12 + 0.03125f;
            tessellator.addVertexWithUV(0.0, (double) f14, 0.0, (double) f, (double) f13);
            tessellator.addVertexWithUV((double) f4, (double) f14, 0.0, (double) f2, (double) f13);
            tessellator.addVertexWithUV((double) f4, (double) f14, (double) (0.0f - f5), (double) f2, (double) f13);
            tessellator.addVertexWithUV(0.0, (double) f14, (double) (0.0f - f5), (double) f, (double) f13);
        }
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, -1.0f, 0.0f);
        for (int l = 0; l < 32; ++l) {
            final float f15 = l / 32.0f;
            final float f16 = f3 + (f1 - f3) * f15 - 0.001953125f;
            final float f17 = f4 * f15;
            tessellator.addVertexWithUV((double) f4, (double) f17, 0.0, (double) f2, (double) f16);
            tessellator.addVertexWithUV(0.0, (double) f17, 0.0, (double) f, (double) f16);
            tessellator.addVertexWithUV(0.0, (double) f17, (double) (0.0f - f5), (double) f, (double) f16);
            tessellator.addVertexWithUV((double) f4, (double) f17, (double) (0.0f - f5), (double) f2, (double) f16);
        }
        tessellator.draw();
    }
}
