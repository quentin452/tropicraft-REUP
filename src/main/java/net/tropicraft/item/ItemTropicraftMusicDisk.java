package net.tropicraft.item;

import net.tropicraft.registry.*;
import net.minecraft.item.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.util.*;

public class ItemTropicraftMusicDisk extends ItemRecord
{
    private String imagePostfixName;
    private String artistName;
    
    public ItemTropicraftMusicDisk(final String recordName, final String imagePostfixName, final String artist) {
        super(recordName);
        this.imagePostfixName = imagePostfixName;
        this.artistName = artist;
        this.setCreativeTab(TCCreativeTabRegistry.tabMusic);
    }
    
    public String getUnlocalizedName() {
        return String.format("item.%s%s", "tropicraft:", this.getActualName(super.getUnlocalizedName()));
    }
    
    public String getUnlocalizedName(final ItemStack itemStack) {
        return String.format("item.%s%s", "tropicraft:", this.getActualName(super.getUnlocalizedName()));
    }
    
    protected String getActualName(final String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
    
    @SideOnly(Side.CLIENT)
    public String getRecordNameLocal() {
        return String.format("%s - %s", this.artistName, StatCollector.translateToLocal("item.tropicraft:record_" + this.recordName + ".name"));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("tropicraft:record_" + this.imagePostfixName);
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack itemstack, final EntityPlayer ent, final List list, final boolean wat) {
        list.add(this.getRecordNameLocal());
    }
    
    public ResourceLocation getRecordResource(String name) {
        name = ("tropicraft:records/" + name.substring(8)).replace("/", ".");
        return new ResourceLocation(name);
    }
}
