package net.tropicraft.entity.projectile;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;

public class EntityPoisonBlot extends EntityThrowable
{
    public EntityPoisonBlot(final World par1World) {
        super(par1World);
    }
    
    public EntityPoisonBlot(final World par1World, final EntityLivingBase thrower) {
        super(par1World, thrower);
    }
    
    protected void onImpact(final MovingObjectPosition mop) {
        if (mop.entityHit != null && mop.entityHit instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)mop.entityHit;
            player.addPotionEffect(new PotionEffect(Potion.poison.id, 240, 0));
            this.setDead();
        }
    }
}
