package net.tropicraft.client.entity.render;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.tropicraft.client.entity.model.*;
import net.tropicraft.util.*;

public class RenderSpiderEgg extends RenderLiving {

    protected ModelSpiderEgg modelVMonkey;

    public RenderSpiderEgg(final ModelSpiderEgg modelbase, final float f) {
        super((ModelBase) modelbase, f);
        this.modelVMonkey = modelbase;
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return TropicraftUtils.bindTextureEntity("spideregg");
    }
}
