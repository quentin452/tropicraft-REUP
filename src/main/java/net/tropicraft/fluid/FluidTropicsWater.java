package net.tropicraft.fluid;

import net.minecraftforge.fluids.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.relauncher.*;
import net.tropicraft.block.*;

public class FluidTropicsWater extends Fluid
{
    public FluidTropicsWater(final String fluidName) {
        super(fluidName);
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            this.setIcons(BlockTropicsWater.stillIcon, BlockTropicsWater.flowingIcon);
        }
    }
}
