package net.tropicraft.client.entity.render;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.tropicraft.entity.underdasea.*;
import net.tropicraft.util.*;

import org.lwjgl.opengl.*;

public class RenderTurtleEgg extends RenderLiving {

    public RenderTurtleEgg(final ModelBase modelbase, final float f) {
        super(modelbase, f);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return TropicraftUtils.bindTextureEntity("turtle/eggText");
    }

    public void renderTurtleEgg(final EntityTurtleEgg entityTurtleEgg, final double d, final double d1, final double d2,
        final float f, final float f1) {
        super.doRender((EntityLiving) entityTurtleEgg, d, d1, d2, f, f1);
    }

    public void doRender(final EntityLiving entityliving, final double d, final double d1, final double d2,
        final float f, final float f1) {
        this.renderTurtleEgg((EntityTurtleEgg) entityliving, d, d1, d2, f, f1);
    }

    public void doRender(final Entity entity, final double d, final double d1, final double d2, final float f,
        final float f1) {
        this.renderTurtleEgg((EntityTurtleEgg) entity, d, d1, d2, f, f1);
    }

    protected void preRenderScale(final EntityTurtleEgg egg, final float f) {
        GL11.glScalef(0.5f, 0.5f, 0.5f);
    }

    protected void preRenderCallback(final EntityLivingBase entityliving, final float f) {
        this.preRenderScale((EntityTurtleEgg) entityliving, f);
    }
}
