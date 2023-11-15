package net.tropicraft.client.entity.render;

import net.tropicraft.client.entity.model.*;
import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.tropicraft.util.*;
import net.tropicraft.entity.underdasea.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;

public class RenderTropicalFish extends RenderWaterMob
{
    public ModelFish fish;
    private MaskRenderer mask;
    
    public RenderTropicalFish(final ModelBase modelbase, final float f) {
        super(modelbase, f);
        this.fish = (ModelFish)modelbase;
        this.mask = new MaskRenderer();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return TropicraftUtils.bindTextureEntity("tropicalFish");
    }
    
    public void renderTropicalFish(final EntityTropicalFish fish, final double d, final double d1, final double d2, final float f, final float f1) {
        super.renderWaterMob(fish, d, d1, d2, f, f1);
    }
    
    public void func_110827_b(final EntityLiving entityliving, final double d, final double d1, final double d2, final float f, final float f1) {
        this.renderTropicalFish((EntityTropicalFish)entityliving, d, d1, d2, f, f1);
    }
    
    public void doRender(final Entity entity, final double d, final double d1, final double d2, final float f, final float f1) {
        this.renderTropicalFish((EntityTropicalFish)entity, d, d1, d2, f, f1);
    }
    
    protected void renderEquippedItems(final EntityLivingBase entityliving, final float f) {
        GL11.glPushMatrix();
        this.fish.Body.postRender(0.045f);
        this.bindEntityTexture((Entity)entityliving);
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.85f, 0.0f, 0.0f);
        this.mask.renderFish(((EntityTropicalFish)entityliving).getColor() * 2);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        this.fish.Tail.postRender(0.045f);
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.9f, 0.725f, 0.0f);
        this.mask.renderFish(((EntityTropicalFish)entityliving).getColor() * 2 + 1);
        GL11.glPopMatrix();
    }
    
    protected void preRenderScale(final EntityTropicalFish entityTropicalFish, final float f) {
        GL11.glScalef(0.75f, 0.2f, 0.2f);
    }
    
    protected void preRenderCallback(final EntityLivingBase entityliving, final float f) {
        this.preRenderScale((EntityTropicalFish)entityliving, f);
    }
}
