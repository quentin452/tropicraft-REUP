package net.tropicraft.client.entity.render;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.tropicraft.entity.underdasea.*;
import net.tropicraft.util.*;

import org.lwjgl.opengl.*;

public class RenderSeahorse extends RenderLiving {

    public RenderSeahorse(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderSeahorse((EntitySeahorse) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    private void renderSeahorse(final EntitySeahorse seahorse, final double x, final double y, final double z,
        final float f, final float f1) {
        GL11.glPushMatrix();
        GL11.glTranslated(x, y - 2.2, z);
        super.doRender(seahorse, x, y, z, f, f1);
        GL11.glPopMatrix();
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        EntitySeahorse seahorse = null;
        if (entity instanceof EntitySeahorse) {
            seahorse = (EntitySeahorse) entity;
        }
        if (seahorse == null) {
            return TropicraftUtils.getTextureEntity("seahorse/razz");
        }
        return TropicraftUtils.getTextureEntity(String.format("seahorse/%s", seahorse.getColorName()));
    }
}
