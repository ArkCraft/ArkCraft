package com.quantumsheep.arkcraft.entity;

import com.quantumsheep.arkcraft.ArkCraftMod;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityGiantSpider extends EntityMob
{
		public EntityGiantSpider(World world)
		{
			super(world);
		}

		public void applyEntityAttributes()
		{
			super.applyEntityAttributes();
				this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20D);
				this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6D);
				this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1D);
				this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);	
		}
		
		 protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
		    {
		        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);

		        for (int k = 0; k < j; ++k)
		        {
		            this.dropItem(Items.feather, 1);
		        }

		        if (this.isBurning())
		        {
		            this.dropItem(Items.cooked_chicken, 1);
		        }
		        else
		        {
		            this.dropItem(Items.chicken, 1);
		        }
		    }
}