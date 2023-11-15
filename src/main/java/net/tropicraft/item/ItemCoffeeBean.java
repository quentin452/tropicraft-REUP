package net.tropicraft.item;

import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import net.tropicraft.info.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraftforge.common.*;
import net.minecraft.block.*;
import net.tropicraft.registry.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraftforge.common.util.*;

public class ItemCoffeeBean extends ItemTropicraftMulti implements IPlantable
{
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
    
    public ItemCoffeeBean() {
        super(TCNames.coffeeBeanNames);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(TCCreativeTabRegistry.tabFood);
    }
    
    @Override
    public void getSubItems(final Item item, final CreativeTabs tab, final List list) {
        list.add(new ItemStack((Item)this, 1, 0));
        list.add(new ItemStack((Item)this, 1, 1));
        list.add(new ItemStack((Item)this, 1, 2));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(final IIconRegister iconRegistry) {
        this.icons = new IIcon[] { iconRegistry.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "_Raw"), iconRegistry.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "_Roasted"), iconRegistry.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "_Berry") };
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int dmg) {
        dmg &= 0x3;
        return this.icons[dmg];
    }
    
    public EnumPlantType getPlantType(final IBlockAccess world, final int x, final int y, final int z) {
        return EnumPlantType.Crop;
    }
    
    public Block getPlant(final IBlockAccess world, final int x, final int y, final int z) {
        return (Block)TCBlockRegistry.coffeePlant;
    }
    
    public int getPlantMetadata(final IBlockAccess world, final int x, final int y, final int z) {
        return 0;
    }
    
    public boolean onItemUse(final ItemStack stack, final EntityPlayer player, final World world, final int x, final int y, final int z, final int side, final float offsetX, final float offsetY, final float offsetZ) {
        if (stack.getItemDamage() != 0) {
            return false;
        }
        if (side != 1) {
            return false;
        }
        if (!player.canPlayerEdit(x, y, z, side, stack) || !player.canPlayerEdit(x, y + 1, z, side, stack)) {
            return false;
        }
        if (world.getBlock(x, y, z) != Blocks.farmland) {
            return false;
        }
        if (!Blocks.farmland.canSustainPlant((IBlockAccess)world, x, y, z, ForgeDirection.UP, (IPlantable)this)) {
            return false;
        }
        if (!world.isAirBlock(x, y + 1, z)) {
            return false;
        }
        world.setBlock(x, y + 1, z, (Block)TCBlockRegistry.coffeePlant, 0, 2);
        --stack.stackSize;
        return true;
    }
}
