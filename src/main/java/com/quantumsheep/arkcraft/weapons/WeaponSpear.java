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
  
	public void onPlayerStoppedUsing(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_)
	   {
	       int j = this.getMaxItemUseDuration(p_77615_1_) - p_77615_4_;

	       ArrowLooseEvent event = new ArrowLooseEvent(p_77615_3_, p_77615_1_, j);
	       MinecraftForge.EVENT_BUS.post(event);
	       if (event.isCanceled())
	       {
	           return;
	       }
	       j = event.charge;

	       boolean flag = p_77615_3_.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, p_77615_1_) > 0;

	       if (flag || p_77615_3_.inventory.hasItem(ArkCraftMod.weaponSpear)) //Ici, change par le nom de ton item (Inutile dans le contexte, mais laise toujours )
	       {
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

	           EntitySpear entityarrow = new EntitySpear(p_77615_2_, p_77615_3_, f * 2.0F); //Tu a juste a changer le nom de l'entity ici

	           if (f == 1.0F)
	           {
	               entityarrow.setIsCritical(true);
	           }


	           p_77615_1_.damageItem(1, p_77615_3_);
	           p_77615_2_.playSoundAtEntity(p_77615_3_, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

	           if (flag)
	           {
	               entityarrow.canBePickedUp = 2;
	           }
	           else
	           {
	               p_77615_3_.inventory.consumeInventoryItem(Items.arrow); //Ici, change aussi par ton item
	           }

	           if (!p_77615_2_.isRemote)
	           {
	               p_77615_2_.spawnEntityInWorld(entityarrow);
	           }
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