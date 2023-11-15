package net.tropicraft.client.entity.render;

import net.minecraft.client.renderer.entity.*;
import net.tropicraft.client.entity.model.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.tropicraft.util.*;

public class RenderFailgull extends RenderLiving
{
    public RenderFailgull(final float f) {
        super((ModelBase)new ModelFailgull(), f);
    }
    
    public void renderNew(final EntityLiving entityliving, final double d, final double d1, final double d2, final float f, final float f1) {
        super.doRender(entityliving, d, d1, d2, f, f1);
    }
    
    public void doRenderLiving(final EntityLiving entityliving, final double d, final double d1, final double d2, final float f, final float f1) {
        this.renderNew(entityliving, d, d1, d2, f, f1);
    }
    
    public void doRender(final Entity entity, final double d, final double d1, final double d2, final float f, final float f1) {
        this.renderNew((EntityLiving)entity, d, d1, d2, f, f1);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return TropicraftUtils.bindTextureEntity("failgull");
    }
}
