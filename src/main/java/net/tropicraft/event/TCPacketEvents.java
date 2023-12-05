package net.tropicraft.event;

import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.tropicraft.util.*;

import CoroUtil.packet.*;
import CoroUtil.util.*;
import cpw.mods.fml.common.eventhandler.*;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.relauncher.*;

public class TCPacketEvents {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onPacketFromServer(final FMLNetworkEvent.ClientCustomPacketEvent event) {
        try {
            final NBTTagCompound nbt = PacketHelper.readNBTTagCompound(event.packet.payload());
            final String packetCommand = nbt.getString("packetCommand");
            System.out.println("Tropicraft packet command from server: " + packetCommand);
            if (packetCommand.equals("effectAdd")) {
                EffectHelper
                    .addEntry((EntityLivingBase) Minecraft.getMinecraft().thePlayer, nbt.getInteger("effectTime"));
            } else if (packetCommand.equals("effectRemove")) {
                EffectHelper.removeEntry((EntityLivingBase) Minecraft.getMinecraft().thePlayer);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SubscribeEvent
    public void onPacketFromClient(final FMLNetworkEvent.ServerCustomPacketEvent event) {
        final EntityPlayerMP entP = ((NetHandlerPlayServer) event.handler).playerEntity;
        try {
            final NBTTagCompound nbt = PacketHelper.readNBTTagCompound(event.packet.payload());
            final String packetCommand = nbt.getString("packetCommand");
            if (packetCommand.equals("")) {}
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SideOnly(Side.CLIENT)
    public String getSelfUsername() {
        return CoroUtilEntity.getName((Entity) Minecraft.getMinecraft().thePlayer);
    }
}
