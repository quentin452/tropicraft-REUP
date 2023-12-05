package net.tropicraft.entity.hostile;

import net.minecraft.entity.monster.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.tropicraft.entity.*;

import CoroUtil.componentAI.jobSystem.*;

public class EntityTropiSkeleton extends EntityCoroAI implements IMob {

    public EntityTropiSkeleton(final World par1World) {
        super(par1World);
        for (int i = 0; i < this.equipmentDropChances.length; ++i) {
            this.equipmentDropChances[i] = 0.0f;
        }
        this.agent.jobMan.addJob((JobBase) new JobFormation(this.agent.jobMan));
        this.agent.shouldAvoid = false;
        this.experienceValue = 6;
    }

    public boolean getCanSpawnHere() {
        return this.isValidLightLevel() && super.getCanSpawnHere();
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        for (int j = this.rand.nextInt(2) + this.rand.nextInt(1 + par2), k = 0; k < j; ++k) {
            this.dropItem(Items.bone, 1);
        }
    }

    protected String getLivingSound() {
        return "mob.skeleton.say";
    }

    protected String getHurtSound() {
        return "mob.skeleton.hurt";
    }

    protected String getDeathSound() {
        return "mob.skeleton.death";
    }
}
