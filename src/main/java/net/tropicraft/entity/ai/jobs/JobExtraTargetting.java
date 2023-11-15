package net.tropicraft.entity.ai.jobs;

import CoroUtil.componentAI.jobSystem.*;
import net.minecraft.entity.*;

public class JobExtraTargetting extends JobBase
{
    public int rangeTarget;
    
    public JobExtraTargetting(final JobManager jm) {
        super(jm);
        this.rangeTarget = 48;
    }
    
    public boolean shouldExecute() {
        return true;
    }
    
    public boolean shouldContinue() {
        return true;
    }
    
    public void tick() {
        super.tick();
        if (this.ai.entityToAttack == null) {
            this.ai.entityToAttack = (Entity)this.ent.worldObj.getClosestVulnerablePlayerToEntity((Entity)this.ent, (double)this.rangeTarget);
        }
    }
}
