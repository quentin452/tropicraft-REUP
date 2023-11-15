package net.tropicraft.item.scuba;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;
import net.tropicraft.util.*;
import net.minecraft.client.renderer.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraftforge.common.*;

public class ItemScubaHelmet extends ItemScubaGear
{
    public ItemScubaHelmet(final ItemArmor.ArmorMaterial material, final ItemScubaGear.ScubaMaterial scubaMaterial, final int renderIndex, final int armorType) {
        super(material, scubaMaterial, renderIndex, armorType);
    }
    
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
    }
    
    @SideOnly(Side.CLIENT)
    public void renderHelmetOverlay(final ItemStack stack, final EntityPlayer player, final ScaledResolution resolution, final float partialTicks, final boolean hasScreen, final int mouseX, final int mouseY) {
        final int width = resolution.getScaledWidth();
        final int height = resolution.getScaledHeight();
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3008);
        Minecraft.getMinecraft().getTextureManager().bindTexture(TropicraftUtils.getTextureGui("snorkel"));
        final Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0, (double)height, -90.0, 0.0, 1.0);
        tessellator.addVertexWithUV((double)width, (double)height, -90.0, 1.0, 1.0);
        tessellator.addVertexWithUV((double)width, 0.0, -90.0, 1.0, 0.0);
        tessellator.addVertexWithUV(0.0, 0.0, -90.0, 0.0, 0.0);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public ISpecialArmor.ArmorProperties getProperties(final EntityLivingBase player, final ItemStack armor, final DamageSource source, final double damage, final int slot) {
        return null;
    }
    
    public int getArmorDisplay(final EntityPlayer player, final ItemStack armor, final int slot) {
        return 0;
    }
    
    public void damageArmor(final EntityLivingBase entity, final ItemStack stack, final DamageSource source, final int damage, final int slot) {
    }
}
