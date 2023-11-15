package net.tropicraft.entity.damage;

import net.minecraft.util.*;
import net.tropicraft.entity.projectile.*;
import net.minecraft.entity.*;

public class TCDamageSource extends DamageSource
{
    public TCDamageSource(final String par1Str) {
        super(par1Str);
    }
    
    public static DamageSource causeDartDamage(final EntityDart dart, final Entity shooter) {
        return new DartDamage("dart", (Entity)dart, shooter).setProjectile();
    }
}
