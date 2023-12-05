package net.tropicraft.entity.koa;

import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.tropicraft.entity.ai.jobs.*;
import net.tropicraft.registry.*;

import CoroUtil.componentAI.jobSystem.*;

public class EntityKoaFisher extends EntityKoaBase {

    public float castingStrength;

    public EntityKoaFisher(final World par1World) {
        super(par1World);
        this.castingStrength = 1.0f;
        this.agent.jobMan.clearJobs();
        this.agent.jobMan.addPrimaryJob(new JobFish(this.agent.jobMan));
        this.agent.jobMan.addJob(new JobHunt(this.agent.jobMan));
    }

    public int getCooldownRanged() {
        return 40;
    }

    public IEntityLivingData onSpawnWithEgg(final IEntityLivingData par1EntityLivingData) {
        this.agent.entInv.setSlotContents(0, new ItemStack(TCItemRegistry.dagger));
        this.agent.entInv.setSlotContents(1, new ItemStack(TCItemRegistry.leafBall));
        this.agent.entInv.setSlotContents(2, new ItemStack(TCItemRegistry.fishingRodTropical));
        this.agent.entInv.syncToClient();
        return super.onSpawnWithEgg(par1EntityLivingData);
    }

    public void onUpdate() {
        if (!this.worldObj.isRemote) {
            this.agent.entInv.setSlotActive(0);
            this.agent.entInv.setSlotActive(2);
        }
        super.onUpdate();
    }
}
