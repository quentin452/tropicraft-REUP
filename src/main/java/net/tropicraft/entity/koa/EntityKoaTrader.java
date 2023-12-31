package net.tropicraft.entity.koa;

import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.tropicraft.entity.ai.jobs.*;
import net.tropicraft.registry.*;

import CoroUtil.componentAI.jobSystem.*;

public class EntityKoaTrader extends EntityKoaBase {

    public EntityKoaTrader(final World par1World) {
        super(par1World);
        this.agent.jobMan.clearJobs();
        this.agent.jobMan.addPrimaryJob((JobBase) new JobTrade(this.agent.jobMan));
        this.agent.scanForHomeChest = false;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.agent.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(80.0);
    }

    public int getCooldownRanged() {
        return 5;
    }

    public IEntityLivingData onSpawnWithEgg(final IEntityLivingData par1EntityLivingData) {
        this.agent.entInv.setSlotContents(0, new ItemStack((Item) TCItemRegistry.swordEudialyte));
        this.agent.entInv.syncToClient();
        return super.onSpawnWithEgg(par1EntityLivingData);
    }
}
