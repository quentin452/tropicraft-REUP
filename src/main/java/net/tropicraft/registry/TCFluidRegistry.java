package net.tropicraft.registry;

import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraftforge.fluids.*;
import net.tropicraft.fluid.*;

public class TCFluidRegistry {

    public static final Fluid tropicsWater;
    public static final Fluid tropicsPortal;

    public static void init() {
        registerFluid(TCFluidRegistry.tropicsWater);
        registerFluid(TCFluidRegistry.tropicsPortal);
    }

    public static void postInit() {
        TCFluidRegistry.tropicsWater.setBlock((Block) TCBlockRegistry.tropicsWater)
            .setUnlocalizedName(TCBlockRegistry.tropicsWater.getUnlocalizedName());
        TCFluidRegistry.tropicsPortal.setBlock((Block) TCBlockRegistry.tropicsPortal)
            .setUnlocalizedName(TCBlockRegistry.tropicsPortal.getUnlocalizedName());
        FluidRegistry.registerFluid(TCFluidRegistry.tropicsWater);
        FluidContainerRegistry.registerFluidContainer(
            TCFluidRegistry.tropicsWater,
            new ItemStack((Item) TCItemRegistry.bucketTropicsWater),
            new ItemStack(Items.bucket));
    }

    private static void registerFluid(final Fluid fluid) {
        FluidRegistry.registerFluid(fluid);
    }

    static {
        tropicsWater = (Fluid) new FluidTropicsWater("tropicsWater");
        tropicsPortal = (Fluid) new FluidTropicsPortal("tropicsPortal");
    }
}
