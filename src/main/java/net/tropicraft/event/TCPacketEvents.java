package net.tropicraft.event;

import cpw.mods.fml.common.network.*;
import CoroUtil.packet.*;
import net.minecraft.client.*;
import net.tropicraft.util.*;
import net.minecraft.nbt.*;
import cpw.mods.fml.relauncher.*;
import cpw.mods.fml.common.eventhandler.*;
import net.minecraft.network.*;
import net.minecraft.entity.player.*;
import CoroUtil.util.*;
import net.minecraft.entity.*;

public class TCPacketEvents
{
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onPacketFromServer(final FMLNetworkEvent.ClientCustomPacketEvent event) {
        try {
            final NBTTagCompound nbt = PacketHelper.readNBTTagCompound(event.packet.payload());
            final String packetCommand = nbt.getString("packetCommand");
            System.out.println("Tropicraft packet command from server: " + packetCommand);
            if (packetCommand.equals("effectAdd")) {
                EffectHelper.addEntry((EntityLivingBase)Minecraft.getMinecraft().thePlayer, nbt.getInteger("effectTime"));
            }
            else if (packetCommand.equals("effectRemove")) {
                EffectHelper.removeEntry((EntityLivingBase)Minecraft.getMinecraft().thePlayer);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @SubscribeEvent
    public void onPacketFromClient(final FMLNetworkEvent.ServerCustomPacketEvent event) {
        final EntityPlayerMP entP = ((NetHandlerPlayServer)event.handler).playerEntity;
        try {
            final NBTTagCompound nbt = PacketHelper.readNBTTagCompound(event.packet.payload());
            final String packetCommand = nbt.getString("packetCommand");
            if (packetCommand.equals("")) {}
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @SideOnly(Side.CLIENT)
    public String getSelfUsername() {
        return CoroUtilEntity.getName((Entity)Minecraft.getMinecraft().thePlayer);
    }
}
