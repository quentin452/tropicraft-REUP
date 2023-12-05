package net.tropicraft.entity.ai.jobs;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.tropicraft.item.tool.*;

import CoroUtil.componentAI.jobSystem.*;

public class JobSleep extends JobBase {

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
            final ItemStack is = ((EntityPlayer) ds.getEntity()).getCurrentEquippedItem();
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
