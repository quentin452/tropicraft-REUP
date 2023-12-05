package net.tropicraft.event;

import java.util.*;

import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.minecraft.world.*;
import net.minecraftforge.event.world.*;
import net.tropicraft.entity.placeable.*;
import net.tropicraft.util.*;

import CoroUtil.forge.*;
import CoroUtil.world.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.eventhandler.*;
import cpw.mods.fml.common.gameevent.*;
import cpw.mods.fml.relauncher.*;
import extendedrenderer.*;

public class TCMiscEvents {

    @SubscribeEvent
    public void worldLoad(final WorldEvent.Load event) {
        if (!event.world.isRemote && ((WorldServer) event.world).provider.dimensionId == -127
            && WorldDirectorManager.instance()
                .getWorldDirector(CoroAI.modID, event.world) == null) {
            WorldDirectorManager.instance()
                .registerWorldDirector(new WorldDirector(), CoroAI.modID, event.world);
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void tickClient(final TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            EffectHelper.tick();
        }
        if (Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu) {
            for (int ii = 0; ii < ExtendedRenderer.rotEffRenderer.fxLayers.length; ++ii) {
                final List list = ExtendedRenderer.rotEffRenderer.fxLayers[ii];
                list.clear();
            }
        }
    }

    @SubscribeEvent
    public void tickServer(final TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            EffectHelper.tick();
        }
        final World world = (World) FMLCommonHandler.instance()
            .getMinecraftServerInstance()
            .worldServerForDimension(0);
        if (world != null && world instanceof WorldServer) {
            for (int ii = 0; ii < world.playerEntities.size(); ++ii) {
                final Entity entity1 = (Entity) world.playerEntities.get(ii);
                if (entity1 instanceof EntityPlayerMP && ((EntityPlayerMP) entity1).isPotionActive(Potion.confusion)
                    && this.isSunset(world)
                    && entity1.ridingEntity instanceof EntityChair) {
                    entity1.ridingEntity = null;
                    TropicraftWorldUtils.teleportPlayer((EntityPlayerMP) entity1);
                }
            }
        }
    }

    private boolean isSunset(final World world) {
        final long timeDay = world.getWorldTime() % 24000L;
        return timeDay > 12200L && timeDay < 14000L;
    }
}
