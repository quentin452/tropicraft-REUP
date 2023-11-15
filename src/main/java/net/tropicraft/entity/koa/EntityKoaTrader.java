package net.tropicraft.entity.koa;

import net.minecraft.world.*;
import net.tropicraft.entity.ai.jobs.*;
import CoroUtil.componentAI.jobSystem.*;
import net.minecraft.entity.*;
import net.tropicraft.registry.*;
import net.minecraft.item.*;

public class EntityKoaTrader extends EntityKoaBase
{
    public EntityKoaTrader(final World par1World) {
        super(par1World);
        this.agent.jobMan.clearJobs();
        this.agent.jobMan.addPrimaryJob((JobBase)new JobTrade(this.agent.jobMan));
        this.agent.scanForHomeChest = false;
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.agent.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0);
    }
    
    public int getCooldownRanged() {
        return 5;
    }
    
    public IEntityLivingData onSpawnWithEgg(final IEntityLivingData par1EntityLivingData) {
        this.agent.entInv.inventory.setInventorySlotContents(0, new ItemStack((Item)TCItemRegistry.swordEudialyte));
        this.agent.entInv.syncToClient();
        return super.onSpawnWithEgg(par1EntityLivingData);
    }
}
