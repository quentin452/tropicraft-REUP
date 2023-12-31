package net.tropicraft.block.tileentity;

import java.util.*;

import net.minecraft.client.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.minecraft.network.play.server.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;

import cpw.mods.fml.relauncher.*;
import extendedrenderer.particle.*;
import extendedrenderer.particle.behavior.*;
import extendedrenderer.particle.entity.*;

public class TileEntityFirePit extends TileEntity {

    @SideOnly(Side.CLIENT)
    public ParticleBehaviors pm;

    public void readFromNBT(final NBTTagCompound nbt) {
        super.readFromNBT(nbt);
    }

    public void updateEntity() {
        super.updateEntity();
        if (this.worldObj.isRemote) {
            if (this.pm == null) {
                this.pm = new ParticleBehaviors(
                    Vec3.createVectorHelper(
                        (double) (this.xCoord + 0.5f),
                        (double) (this.yCoord + 0.5f),
                        (double) (this.zCoord + 0.5f)));
            }
            this.tickAnimate();
        }
    }

    @SideOnly(Side.CLIENT)
    public void tickAnimate() {
        final int amount = 5 / (Minecraft.getMinecraft().gameSettings.particleSetting + 1);
        final Random rand = new Random();
        for (int i = 0; i < amount; ++i) {
            final double speed = 0.15;
            final EntityRotFX entityfx = this.pm.spawnNewParticleIconFX(
                this.worldObj,
                ParticleRegistry.smoke,
                this.xCoord + rand.nextDouble(),
                this.yCoord + 0.2 + rand.nextDouble() * 0.2,
                this.zCoord + rand.nextDouble(),
                (rand.nextDouble() - rand.nextDouble()) * speed,
                0.03,
                (rand.nextDouble() - rand.nextDouble()) * speed);
            ParticleBehaviors.setParticleRandoms(entityfx, true, true);
            ParticleBehaviors.setParticleFire(entityfx);
            entityfx.setMaxAge(100 + rand.nextInt(300));
            entityfx.spawnAsWeatherEffect();
            this.pm.particles.add(entityfx);
        }
    }

    public void writeToNBT(final NBTTagCompound nbt) {
        super.writeToNBT(nbt);
    }

    public void onDataPacket(final NetworkManager net, final S35PacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.func_148857_g());
    }

    public Packet getDescriptionPacket() {
        final NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return (Packet) new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 5, nbttagcompound);
    }
}
