package net.tropicraft.proxy;

import net.minecraft.client.model.*;
import net.tropicraft.*;
import net.tropicraft.client.entity.model.*;
import net.tropicraft.client.renderer.block.*;
import net.tropicraft.encyclopedia.*;
import net.tropicraft.info.*;
import net.tropicraft.registry.*;

import cpw.mods.fml.client.registry.*;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerBooks() {
        Tropicraft.encyclopedia = new Encyclopedia(
            "eTsave.dat",
            "/assets/tropicraft/gui/EncyclopediaTropica.txt",
            "encyclopediaTropica",
            "encyclopediaTropicaInside");
        TCCraftingRegistry.addItemsToEncyclopedia();
    }

    @Override
    public void initRenderHandlersAndIDs() {
        TCRenderIDs.coffeePlant = RenderingRegistry.getNextAvailableRenderId();
        TCRenderIDs.tikiTorch = RenderingRegistry.getNextAvailableRenderId();
        TCRenderIDs.flowerPot = RenderingRegistry.getNextAvailableRenderId();
        TCRenderIDs.bambooChest = RenderingRegistry.getNextAvailableRenderId();
        TCRenderIDs.bambooChute = RenderingRegistry.getNextAvailableRenderId();
        TCRenderIDs.curareBowl = RenderingRegistry.getNextAvailableRenderId();
        TCRenderIDs.eihMixer = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler) new CoffeePlantRenderHandler());
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler) new TikiTorchRenderHandler());
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler) new FlowerPotRenderHandler());
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler) new BambooChestRenderHandler());
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler) new BambooChuteRenderHandler());
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler) new CurareBowlRenderHandler());
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler) new EIHMixerRenderHandler());
    }

    @Override
    public void initRenderRegistry() {
        TCRenderRegistry.initEntityRenderers();
        TCRenderRegistry.initTileEntityRenderers();
    }

    @Override
    public ModelBiped getArmorModel(final int id) {
        if (id == 0) {
            return (ModelBiped) new ModelScubaGear();
        }
        return null;
    }

    @Override
    public void preInit() {}
}
