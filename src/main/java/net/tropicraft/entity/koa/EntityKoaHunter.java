package net.tropicraft.entity.koa;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.tropicraft.registry.*;
import net.minecraft.item.*;

public class EntityKoaHunter extends EntityKoaBase
{
    public EntityKoaHunter(final World par1World) {
        super(par1World);
    }
    
    public int getCooldownRanged() {
        return 10;
    }
    
    public IEntityLivingData onSpawnWithEgg(final IEntityLivingData par1EntityLivingData) {
        this.agent.entInv.inventory.setInventorySlotContents(0, new ItemStack(TCItemRegistry.dagger));
        this.agent.entInv.inventory.setInventorySlotContents(1, new ItemStack(TCItemRegistry.leafBall));
        this.agent.entInv.syncToClient();
        return super.onSpawnWithEgg(par1EntityLivingData);
    }
}
