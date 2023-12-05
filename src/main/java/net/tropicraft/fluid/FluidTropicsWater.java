package net.tropicraft.fluid;

import net.minecraftforge.fluids.*;
import net.tropicraft.block.*;

import cpw.mods.fml.common.*;
import cpw.mods.fml.relauncher.*;

public class FluidTropicsWater extends Fluid {

    public FluidTropicsWater(final String fluidName) {
        super(fluidName);
        if (FMLCommonHandler.instance()
            .getEffectiveSide() == Side.CLIENT) {
            this.setIcons(BlockTropicsWater.stillIcon, BlockTropicsWater.flowingIcon);
        }
    }
}
