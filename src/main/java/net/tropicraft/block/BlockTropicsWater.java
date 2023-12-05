package net.tropicraft.block;

import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.fluids.*;
import net.tropicraft.registry.*;

import cpw.mods.fml.relauncher.*;

public class BlockTropicsWater extends BlockFluidClassic {

    @SideOnly(Side.CLIENT)
    public static IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    public static IIcon flowingIcon;

    public BlockTropicsWater(final Fluid fluid, final Material material) {
        super(fluid, material);
        this.lightOpacity = 0;
        this.setCreativeTab((CreativeTabs) null);
        this.displacements.put(TCBlockRegistry.coral, false);
        this.displacements.put(TCBlockRegistry.bambooFence, false);
        this.setRenderPass(1);
    }

    public void registerBlockIcons(final IIconRegister iconRegister) {
        BlockTropicsWater.stillIcon = iconRegister.registerIcon("tropicraft:tropicsWater");
        BlockTropicsWater.flowingIcon = iconRegister.registerIcon("tropicraft:flowingTropicsWater");
        TCFluidRegistry.tropicsWater.setIcons(BlockTropicsWater.stillIcon, BlockTropicsWater.flowingIcon);
    }

    public IIcon getIcon(final int side, final int meta) {
        return (side != 0 && side != 1) ? BlockTropicsWater.flowingIcon : BlockTropicsWater.stillIcon;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(final IBlockAccess world, final int x, final int y, final int z,
        final int side) {
        final Material material = world.getBlock(x, y, z)
            .getMaterial();
        return material != this.blockMaterial && (side == 1 || super.shouldSideBeRendered(world, x, y, z, side));
    }
}
