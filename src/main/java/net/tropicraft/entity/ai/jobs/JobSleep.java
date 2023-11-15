package net.tropicraft.entity.ai.jobs;

import CoroUtil.componentAI.jobSystem.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.tropicraft.item.tool.*;
import net.minecraft.item.*;

public class JobSleep extends JobBase
{
    public boolean sleeping;
    
    public JobSleep(final JobManager jm) {
        super(jm);
        this.sleeping = true;
    }
    
    public boolean shouldExecute() {
        return true;
    }
    
    public boolean shouldContinue() {
        return !this.sleeping;
    }
    
    public boolean hookHit(final DamageSource ds, final int damage) {
        if (ds.getEntity() instanceof EntityPlayer) {
            this.sleeping = false;
            final ItemStack is = ((EntityPlayer)ds.getEntity()).getCurrentEquippedItem();
            return is != null && (is.getItem() instanceof ItemPickaxe || is.getItem() instanceof ItemTropicraftPickaxe);
        }
        return false;
    }
    
    public void onIdleTickAct() {
        if (!this.sleeping) {
            super.onIdleTickAct();
        }
    }
}
