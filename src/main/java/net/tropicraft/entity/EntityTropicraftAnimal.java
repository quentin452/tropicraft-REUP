package net.tropicraft.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.world.*;

public abstract class EntityTropicraftAnimal extends EntityAnimal
{
    public EntityTropicraftAnimal(final World world) {
        super(world);
    }
    
    protected String tcSound(final String postfix) {
        return String.format("%s:%s", "tropicraft", postfix);
    }
}
