package net.tropicraft.client.entity.render;

import net.minecraft.client.renderer.entity.*;
import net.tropicraft.client.entity.model.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.tropicraft.util.*;

public class RenderVMonkey extends RenderLiving
{
    protected ModelVMonkey modelVMonkey;
    
    public RenderVMonkey(final ModelVMonkey modelbase, final float f) {
        super((ModelBase)modelbase, f);
        this.modelVMonkey = modelbase;
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return TropicraftUtils.bindTextureEntity("monkeytext");
    }
}
