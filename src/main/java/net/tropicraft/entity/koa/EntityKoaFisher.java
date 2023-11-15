package net.tropicraft.entity.koa;

import net.minecraft.world.*;
import net.tropicraft.entity.ai.jobs.*;
import CoroUtil.componentAI.jobSystem.*;
import net.minecraft.entity.*;
import net.tropicraft.registry.*;
import net.minecraft.item.*;

public class EntityKoaFisher extends EntityKoaBase
{
    public float castingStrength;
    
    public EntityKoaFisher(final World par1World) {
        super(par1World);
        this.castingStrength = 1.0f;
        this.agent.jobMan.clearJobs();
        this.agent.jobMan.addPrimaryJob((JobBase)new JobFish(this.agent.jobMan));
        this.agent.jobMan.addJob((JobBase)new JobHunt(this.agent.jobMan));
    }
    
    public int getCooldownRanged() {
        return 40;
    }
    
    public IEntityLivingData onSpawnWithEgg(final IEntityLivingData par1EntityLivingData) {
        this.agent.entInv.inventory.setInventorySlotContents(0, new ItemStack(TCItemRegistry.dagger));
        this.agent.entInv.inventory.setInventorySlotContents(1, new ItemStack(TCItemRegistry.leafBall));
        this.agent.entInv.inventory.setInventorySlotContents(2, new ItemStack(TCItemRegistry.fishingRodTropical));
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
