package net.tropicraft.entity.koa;

import net.minecraft.world.*;
import net.tropicraft.entity.ai.jobs.*;
import CoroUtil.componentAI.jobSystem.*;
import net.minecraft.entity.*;
import net.tropicraft.registry.*;
import net.minecraft.item.*;

public class EntityKoaShaman extends EntityKoaBase
{
    public EntityKoaShaman(final World par1World) {
        super(par1World);
        this.agent.jobMan.addJob((JobBase)new JobQuestGiver(this.agent.jobMan));
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.agent.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0);
    }
    
    public int getCooldownRanged() {
        return 10;
    }
    
    public IEntityLivingData onSpawnWithEgg(final IEntityLivingData par1EntityLivingData) {
        this.agent.entInv.inventory.setInventorySlotContents(0, new ItemStack(TCItemRegistry.bambooSpear));
        this.agent.entInv.inventory.setInventorySlotContents(1, new ItemStack((Item)TCItemRegistry.swordZirconium));
        this.agent.entInv.syncToClient();
        return super.onSpawnWithEgg(par1EntityLivingData);
    }
}
