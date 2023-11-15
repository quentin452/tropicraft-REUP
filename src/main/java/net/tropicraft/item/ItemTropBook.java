package net.tropicraft.item;

import net.tropicraft.encyclopedia.*;
import net.tropicraft.registry.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import cpw.mods.fml.common.*;
import net.tropicraft.client.gui.*;
import net.tropicraft.*;
import cpw.mods.fml.relauncher.*;

public class ItemTropBook extends ItemTropicraft
{
    private String bookName;
    
    public ItemTropBook(final TropicalBook book, final String name) {
        this.bookName = name;
        this.maxStackSize = 1;
        this.setCreativeTab(TCCreativeTabRegistry.tabMisc);
    }
    
    public ItemTropBook(final String name) {
        this(null, name);
    }
    
    public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        if (world.isRemote && this.getTropBook() != null) {
            System.err.println("Gui");
            this.getTropBook().updatePagesFromInventory(entityplayer.inventory);
            FMLCommonHandler.instance().showGuiScreen((Object)new GuiTropicalBook(this.getTropBook()));
        }
        return itemstack;
    }
    
    @SideOnly(Side.CLIENT)
    private TropicalBook getTropBook() {
        return (TropicalBook)Tropicraft.encyclopedia;
    }
}
