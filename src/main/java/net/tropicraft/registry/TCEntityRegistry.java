package net.tropicraft.registry;

import net.minecraft.entity.*;
import net.tropicraft.*;
import net.tropicraft.entity.*;
import net.tropicraft.entity.hostile.*;
import net.tropicraft.entity.koa.*;
import net.tropicraft.entity.passive.*;
import net.tropicraft.entity.placeable.*;
import net.tropicraft.entity.projectile.*;
import net.tropicraft.entity.underdasea.*;

import CoroUtil.entity.*;
import cpw.mods.fml.common.registry.*;

public class TCEntityRegistry {

    private static int entityID;

    public static void init() {
        registerEntity((Class<? extends Entity>) EntityChair.class, "beachChair", 120, 10, true);
        registerEntity((Class<? extends Entity>) EntityUmbrella.class, "beachUmbrella", 120, 10, false);
        registerEntity((Class<? extends Entity>) EntitySeahorse.class, "Seahorse", 120, 3, true);
        registerEntity((Class<? extends Entity>) EntityDart.class, "Dart", 120, 4, true);
        registerEntity((Class<? extends Entity>) EntityIguana.class, "Iguana", 80, 3, true);
        registerEntity((Class<? extends Entity>) EntityEIH.class, "Easter Island Head", 80, 3, true);
        registerEntity((Class<? extends Entity>) EntityTreeFrogGreen.class, "TreeFrogGreen", 80, 3, true);
        registerEntity((Class<? extends Entity>) EntityTreeFrogRed.class, "TreeFrogRed", 80, 3, true);
        registerEntity((Class<? extends Entity>) EntityTreeFrogBlue.class, "TreeFrogBlue", 80, 3, true);
        registerEntity((Class<? extends Entity>) EntityTreeFrogYellow.class, "TreeFrogYellow", 80, 3, true);
        registerEntity((Class<? extends Entity>) EntityPoisonBlot.class, "PoisonBlot", 120, 2, true);
        registerEntity((Class<? extends Entity>) EntitySeaTurtle.class, "SeaTurtle", 80, 3, true);
        registerEntity((Class<? extends Entity>) EntityTurtleEgg.class, "SeaTurtleEgg", 80, 5, false);
        registerEntity((Class<? extends Entity>) EntityEagleRay.class, "EagleRay", 80, 1, true);
        registerEntity((Class<? extends Entity>) EntityAshenHunter.class, "AshenHunter", 80, 3, true);
        registerEntity((Class<? extends Entity>) EntityCoconutGrenade.class, "CoconutBomb", 120, 5, true);
        registerEntity((Class<? extends Entity>) EntityTropiCreeper.class, "TropiCreeper", 80, 3, true);
        registerEntity((Class<? extends Entity>) EntityTropiSkeleton.class, "TropiSkeleton", 80, 3, true);
        registerEntity((Class<? extends Entity>) EntityTropiCreeper.class, "TropiCreeper", 80, 3, true);
        registerEntity((Class<? extends Entity>) SpiderAdult.class, "SpiderAdult", 48, 3, true);
        registerEntity((Class<? extends Entity>) SpiderChild.class, "SpiderChild", 48, 3, true);
        registerEntity((Class<? extends Entity>) SpiderEgg.class, "SpiderEgg", 48, 3, true);
        registerEntity((Class<? extends Entity>) VMonkey.class, "VMonkey", 64, 3, true);
        registerEntity((Class<? extends Entity>) EntityKoaHunter.class, "KoaHunter", 64, 3, true);
        registerEntity((Class<? extends Entity>) EntityKoaFisher.class, "KoaFisher", 64, 3, true);
        registerEntity((Class<? extends Entity>) EntityKoaTrader.class, "KoaTrader", 64, 3, true);
        registerEntity((Class<? extends Entity>) EntityKoaShaman.class, "KoaShaman", 64, 3, true);
        registerEntity((Class<? extends Entity>) EntityTropicalFishHook.class, "TropiFishHook", 64, 1, true);
        registerEntity((Class<? extends Entity>) EntityTCItemFrame.class, "TCItemFrame", 64, 10, false);
        registerEntity((Class<? extends Entity>) EntityTropicraftLeafballNew.class, "TropiLeafball", 64, 1, true);
        registerEntity((Class<? extends Entity>) EntityTropicalFish.class, "TropicalFish", 80, 3, true);
        registerEntity((Class<? extends Entity>) EntityLostMask.class, "LostMask", 64, 3, true);
        registerEntity((Class<? extends Entity>) EntityMarlin.class, "Marlin", 80, 3, true);
        registerEntity((Class<? extends Entity>) EntitySnareTrap.class, "SnareTrap", 80, 20, false);
        registerEntity((Class<? extends Entity>) Failgull.class, "Failgull", 64, 3, true);
        registerEntity((Class<? extends Entity>) EntityManOWar.class, "MOW", 64, 3, true);
        registerEntity((Class<? extends Entity>) EntitySeaUrchin.class, "SeaUrchin", 64, 3, true);
        registerEntity((Class<? extends Entity>) EntitySeaUrchinEgg.class, "SeaUrchinEgg", 64, 3, false);
        registerEntity((Class<? extends Entity>) EntityStarfish.class, "Starfish", 64, 3, false);
        registerEntity((Class<? extends Entity>) EntityStarfishEgg.class, "StarfishEgg", 64, 3, false);
        registerEntity(
            (Class<? extends Entity>) EntityWallStarfish.class,
            "WallStarfish",
            160,
            Integer.MAX_VALUE,
            false);
    }

    private static void registerEntity(final Class<? extends Entity> entityClass, final String entityName,
        final int trackingRange, final int updateFrequency, final boolean sendsVelocityUpdates) {
        EntityRegistry.registerModEntity(
            (Class) entityClass,
            entityName,
            TCEntityRegistry.entityID++,
            (Object) Tropicraft.instance,
            trackingRange,
            updateFrequency,
            sendsVelocityUpdates);
    }

    static {
        TCEntityRegistry.entityID = 0;
    }
}
