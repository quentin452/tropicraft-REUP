package net.tropicraft.item.armor;

import cpw.mods.fml.relauncher.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ItemAshenMask extends ItemTropicraftArmor
{
    @SideOnly(Side.CLIENT)
    private IIcon[] images;
    private final String[] displayNames;
    private final String[] imageNames;
    
    public ItemAshenMask(final ItemArmor.ArmorMaterial material, final int renderIndex, final int armorType, final String[] displayNames, final String[] imageNames) {
        super(material, renderIndex, armorType);
        this.imageNames = imageNames;
        this.displayNames = displayNames;
    }
    
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(final int damage) {
        final int j = MathHelper.clamp_int(damage, 0, 15);
        return this.images[j];
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubItems(final Item id, final CreativeTabs creativeTabs, final List list) {
        for (int meta = 0; meta < this.imageNames.length; ++meta) {
            list.add(new ItemStack(id, 1, meta));
        }
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack par1ItemStack) {
        final int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
        return super.getUnlocalizedName() + "." + this.displayNames[i];
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(final IIconRegister iconRegistry) {
        this.images = new IIcon[this.displayNames.length];
        for (int i = 0; i < this.displayNames.length; ++i) {
            this.images[i] = iconRegistry.registerIcon("tropicraft:" + this.imageNames[i]);
        }
    }
    
    @Override
    public void damageArmor(final EntityLivingBase player, final ItemStack stack, final DamageSource source, final int damage, final int slot) {
    }
}
