package net.tropicraft.fluid;

import net.minecraftforge.fluids.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.relauncher.*;
import net.tropicraft.block.*;

public class FluidTropicsPortal extends Fluid
{
    public FluidTropicsPortal(final String fluidName) {
        super(fluidName);
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            this.setIcons(BlockTropicsWater.stillIcon, BlockTropicsWater.flowingIcon);
        }
    }
}
