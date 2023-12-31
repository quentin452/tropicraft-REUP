package net.tropicraft.client.entity.render;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.tropicraft.entity.passive.*;
import net.tropicraft.util.*;

public class RenderIguana extends RenderLiving {

    public RenderIguana(final ModelBase modelbase, final float f) {
        super(modelbase, f);
    }

    public void renderIguana(final EntityIguana entityiguana, final double d, final double d1, final double d2,
        final float f, final float f1) {
        super.doRender((EntityLiving) entityiguana, d, d1, d2, f, f1);
    }

    public void doRender(final EntityLiving entityliving, final double d, final double d1, final double d2,
        final float f, final float f1) {
        this.renderIguana((EntityIguana) entityliving, d, d1, d2, f, f1);
    }

    public void doRender(final Entity entity, final double d, final double d1, final double d2, final float f,
        final float f1) {
        this.renderIguana((EntityIguana) entity, d, d1, d2, f, f1);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return TropicraftUtils.bindTextureEntity("iguana/iggytexture");
    }
}
