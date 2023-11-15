package net.tropicraft.client.entity.render;

import net.minecraft.client.renderer.entity.*;
import net.tropicraft.client.entity.model.*;
import net.minecraft.client.model.*;
import org.lwjgl.opengl.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.tropicraft.util.*;

public class RenderEagleRay extends RenderLiving
{
    public RenderEagleRay() {
        super((ModelBase)new ModelEagleRay(), 1.0f);
    }
    
    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        GL11.glTranslatef(0.0f, 1.25f, 0.0f);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return TropicraftUtils.bindTextureEntity("ray/eagleray");
    }
}
