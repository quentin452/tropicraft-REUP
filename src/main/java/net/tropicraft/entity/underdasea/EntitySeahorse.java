package net.tropicraft.entity.underdasea;

import net.minecraft.world.*;
import net.minecraft.nbt.*;

public class EntitySeahorse extends EntityTropicraftWaterMob
{
    private static final int DATAWATCHER_COLOR = 30;
    
    public EntitySeahorse(final World par1World) {
        super(par1World);
        this.type = WaterMobType.OCEAN_DWELLER;
        this.setSize(0.75f, 1.1f);
    }
    
    public EntitySeahorse(final World par1World, final int color) {
        this(par1World);
        this.setColor((byte)color);
    }
    
    @Override
    public void entityInit() {
        this.dataWatcher.addObject(30, (Object)0);
        super.entityInit();
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbt) {
        nbt.setByte("Color", (byte)this.getColor());
        super.writeEntityToNBT(nbt);
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbt) {
        this.setColor(nbt.getByte("Color"));
        super.readEntityFromNBT(nbt);
    }
    
    public byte getColor() {
        return this.dataWatcher.getWatchableObjectByte(30);
    }
    
    public void setColor(final byte color) {
        this.dataWatcher.updateObject(30, (Object)color);
    }
    
    public String getColorName() {
        switch (this.getColor()) {
            case 0: {
                return "razz";
            }
            case 1: {
                return "blue";
            }
            case 2: {
                return "cyan";
            }
            case 3: {
                return "yellow";
            }
            case 4: {
                return "green";
            }
            case 5: {
                return "orange";
            }
            default: {
                return "razz";
            }
        }
    }
    
    @Override
    protected int attackStrength() {
        return 0;
    }
}
