package net.tropicraft.entity.ai.jobs;

import CoroUtil.componentAI.jobSystem.*;
import net.minecraft.util.*;
import CoroUtil.componentAI.*;
import net.minecraft.entity.*;
import java.util.*;

public class JobAttackTargetShare extends JobBase
{
    public int rangeTargetShare;
    public Class classToShareWith;
    public int shareTriggerCooldown;
    public int shareTriggerCooldownMax;
    
    public JobAttackTargetShare(final JobManager jm, final Class parClass) {
        super(jm);
        this.rangeTargetShare = 24;
        this.classToShareWith = null;
        this.shareTriggerCooldown = 0;
        this.shareTriggerCooldownMax = 60;
        this.classToShareWith = parClass;
    }
    
    public boolean shouldExecute() {
        return true;
    }
    
    public boolean shouldContinue() {
        return true;
    }
    
    public void tick() {
        super.tick();
        if (this.shareTriggerCooldown > 0) {
            --this.shareTriggerCooldown;
        }
    }
    
    public boolean hookHit(final DamageSource ds, final int damage) {
        final Entity target = ds.getEntity();
        if (this.isEnemy(target) && this.shareTriggerCooldown == 0) {
            this.shareTriggerCooldown = this.shareTriggerCooldownMax;
            final List<EntityLivingBase> notifyList = (List<EntityLivingBase>)this.ent.worldObj.getEntitiesWithinAABB(this.classToShareWith, this.ent.boundingBox.expand((double)this.rangeTargetShare, (double)this.rangeTargetShare, (double)this.rangeTargetShare));
            for (int i = 0; i < notifyList.size(); ++i) {
                final EntityLivingBase entN = notifyList.get(i);
                if (!this.ent.isDead && this.ent instanceof ICoroAI && ((ICoroAI)this.ent).getAIAgent().entityToAttack == null) {
                    System.out.println("sharing targetting");
                    ((ICoroAI)this.ent).getAIAgent().entityToAttack = target;
                }
            }
        }
        return super.hookHit(ds, damage);
    }
}
