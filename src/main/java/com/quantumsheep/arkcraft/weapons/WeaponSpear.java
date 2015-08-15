package com.quantumsheep.arkcraft.weapons;

import com.quantumsheep.arkcraft.ArkCraftMod;
import com.quantumsheep.arkcraft.entity.EntitySpear;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class WeaponSpear extends Item {
  
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int useTime)
    {
         int j = this.getMaxItemUseDuration(stack) - useTime;
         float f = (float)j / 5.0F;
         f = (f * f + f * 2.0F) / 3.0F;

         if ((double)f < 0.1D)
         {
             return;
         }

         if (f > 1.0F)
         {
             f = 1.0F;
         }

         EntitySpear entityarrow = new EntitySpear(world, player, f * 2.0F);

         if (f == 1.0F)
         {
             entityarrow.setIsCritical(true);
         }

         world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

         player.setCurrentItemOrArmor(0, null);
         player.inventory.markDirty();

         if (!world.isRemote)
         {
             world.spawnEntityInWorld(entityarrow);
         }
    }
	
		public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
	    {
	        return p_77654_1_;
	    }
	
		public int getMaxItemUseDuration(ItemStack p_77626_1_)
	    {
	        return 72000;
	    }
	
	 public EnumAction getItemUseAction(ItemStack p_77661_1_)
	    {
	        return EnumAction.bow;
	    }
	
	 public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
	    {
	        ArrowNockEvent event = new ArrowNockEvent(p_77659_3_, p_77659_1_);
	        MinecraftForge.EVENT_BUS.post(event);
	        if (event.isCanceled())
	        {
	            return event.result;
	        }
	
	        if (p_77659_3_.capabilities.isCreativeMode || p_77659_3_.inventory.hasItem(ArkCraftMod.weaponSpear))
	        {
	            p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
	        }
	
	        return p_77659_1_;
	    }
}