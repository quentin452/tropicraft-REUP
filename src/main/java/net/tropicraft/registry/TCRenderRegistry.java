package net.tropicraft.registry;

import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.item.*;
import net.tropicraft.entity.koa.*;
import CoroUtil.entity.*;
import net.tropicraft.entity.*;
import net.tropicraft.entity.projectile.*;
import net.tropicraft.entity.hostile.*;
import net.tropicraft.entity.passive.*;
import net.tropicraft.client.entity.model.*;
import net.tropicraft.entity.underdasea.*;
import net.tropicraft.entity.placeable.*;
import net.tropicraft.client.entity.render.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.renderer.tileentity.*;
import net.tropicraft.block.tileentity.*;
import net.tropicraft.client.tileentity.*;
import cpw.mods.fml.client.registry.*;

public class TCRenderRegistry
{
    public static void initEntityRenderers() {
        registerEntityRender((Class<? extends Entity>)EntityChair.class, (Render)new RenderChair());
        registerEntityRender((Class<? extends Entity>)EntityUmbrella.class, (Render)new RenderUmbrella());
        registerEntityRender((Class<? extends Entity>)EntitySeahorse.class, (Render)new RenderSeahorse((ModelBase)new ModelSeahorse(), 0.75f));
        registerEntityRender((Class<? extends Entity>)EntityDart.class, (Render)new RenderDart());
        registerEntityRender((Class<? extends Entity>)EntityIguana.class, (Render)new RenderIguana((ModelBase)new ModelIguana(), 0.75f));
        registerEntityRender((Class<? extends Entity>)EntityEIH.class, (Render)new RenderEIH(new ModelEIH(), 0.75f));
        registerEntityRender((Class<? extends Entity>)EntityTreeFrog.class, (Render)new RenderTreeFrog((ModelBase)new ModelTreeFrog(), 0.5f));
        registerEntityRender((Class<? extends Entity>)EntityPoisonBlot.class, (Render)new RenderPoisonBlot());
        registerEntityRender((Class<? extends Entity>)EntitySeaTurtle.class, (Render)new RenderSeaTurtle((ModelBase)new ModelSeaTurtle(), 0.75f));
        registerEntityRender((Class<? extends Entity>)EntityTurtleEgg.class, (Render)new RenderTurtleEgg((ModelBase)new ModelTurtleEgg(), 0.75f));
        registerEntityRender((Class<? extends Entity>)EntityEagleRay.class, (Render)new RenderEagleRay());
        registerEntityRender((Class<? extends Entity>)EntityAshenHunter.class, (Render)new RenderAshen((ModelBase)new ModelAshen(), 0.75f));
        registerEntityRender((Class<? extends Entity>)EntityCoconutGrenade.class, (Render)new RenderSnowball((Item)TCItemRegistry.coconutBomb));
        registerEntityRender((Class<? extends Entity>)EntityTropiCreeper.class, (Render)new RenderTropiCreeper());
        registerEntityRender((Class<? extends Entity>)EntityTropiSkeleton.class, (Render)new RenderTropiSkeleton(0.5f));
        registerEntityRender((Class<? extends Entity>)SpiderAdult.class, (Render)new RenderTropiSpider());
        registerEntityRender((Class<? extends Entity>)SpiderChild.class, (Render)new RenderTropiSpider());
        registerEntityRender((Class<? extends Entity>)SpiderEgg.class, (Render)new RenderSpiderEgg(new ModelSpiderEgg(), 0.5f));
        registerEntityRender((Class<? extends Entity>)VMonkey.class, (Render)new RenderVMonkey(new ModelVMonkey(), 0.5f));
        registerEntityRender((Class<? extends Entity>)EntityKoaBase.class, (Render)new RenderKoaMan(new ModelKoaMan(), 0.7f));
        registerEntityRender((Class<? extends Entity>)EntityTropicalFishHook.class, (Render)new RenderFishHook());
        registerEntityRender((Class<? extends Entity>)EntityTCItemFrame.class, (Render)new RenderTCItemFrame());
        registerEntityRender((Class<? extends Entity>)EntityTropicraftLeafballNew.class, (Render)new RenderSnowball(TCItemRegistry.leafBall));
        registerEntityRender((Class<? extends Entity>)EntityTropicalFish.class, (Render)new RenderTropicalFish((ModelBase)new ModelFish(), 0.25f));
        registerEntityRender((Class<? extends Entity>)EntityLostMask.class, (Render)new RenderLostMask());
        registerEntityRender((Class<? extends Entity>)EntityMarlin.class, (Render)new RenderMarlin((ModelBase)new ModelMarlin(), 0.25f));
        registerEntityRender((Class<? extends Entity>)EntitySnareTrap.class, (Render)new RenderSnareTrap());
        registerEntityRender((Class<? extends Entity>)Failgull.class, (Render)new RenderFailgull(0.5f));
        registerEntityRender((Class<? extends Entity>)EntityManOWar.class, (Render)new RenderManOWar((ModelBase)new ModelManOWar(32, 20, true), (ModelBase)new ModelManOWar(0, 20, false), 0.35f));
        registerEntityRender((Class<? extends Entity>)EntityStarfish.class, (Render)new RenderStarfish());
        registerEntityRender((Class<? extends Entity>)EntityStarfishEgg.class, (Render)new RenderEchinodermEgg());
        registerEntityRender((Class<? extends Entity>)EntitySeaUrchin.class, (Render)new RenderSeaUrchin());
        registerEntityRender((Class<? extends Entity>)EntitySeaUrchinEgg.class, (Render)new RenderEchinodermEgg());
        registerEntityRender((Class<? extends Entity>)EntityWallStarfish.class, (Render)new RenderWallStarfish());
    }
    
    public static void initTileEntityRenderers() {
        registerTileEntityRenderer((Class<? extends TileEntity>)TileEntityBambooChest.class, (TileEntitySpecialRenderer)new TileEntityBambooChestRenderer());
        registerTileEntityRenderer((Class<? extends TileEntity>)TileEntityAirCompressor.class, (TileEntitySpecialRenderer)new TileEntityAirCompressorRenderer());
        registerTileEntityRenderer((Class<? extends TileEntity>)TileEntitySifter.class, (TileEntitySpecialRenderer)new TileEntitySifterRenderer());
        registerTileEntityRenderer((Class<? extends TileEntity>)TileEntityCurareBowl.class, (TileEntitySpecialRenderer)new TileEntityCurareBowlRenderer());
        registerTileEntityRenderer((Class<? extends TileEntity>)TileEntityKoaChest.class, (TileEntitySpecialRenderer)new TileEntityKoaChestRenderer());
        registerTileEntityRenderer((Class<? extends TileEntity>)TileEntityEIHMixer.class, (TileEntitySpecialRenderer)new TileEntityEIHMixerRenderer());
        registerTileEntityRenderer((Class<? extends TileEntity>)TileEntityPurchasePlate.class, (TileEntitySpecialRenderer)new TileEntityPurchasePlateRenderer());
        registerTileEntityRenderer((Class<? extends TileEntity>)TileEntityBambooMug.class, (TileEntitySpecialRenderer)new TileEntityBambooMugRenderer());
    }
    
    private static void registerTileEntityRenderer(final Class<? extends TileEntity> tileEntityClass, final TileEntitySpecialRenderer specialRenderer) {
        ClientRegistry.bindTileEntitySpecialRenderer((Class)tileEntityClass, specialRenderer);
    }
    
    private static void registerEntityRender(final Class<? extends Entity> entityClass, final Render render) {
        RenderingRegistry.registerEntityRenderingHandler((Class)entityClass, render);
    }
}
