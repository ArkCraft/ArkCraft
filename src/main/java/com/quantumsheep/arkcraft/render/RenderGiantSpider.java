package com.quantumsheep.arkcraft.render;

import com.quantumsheep.arkcraft.entity.EntityGiantSpider;
import com.quantumsheep.arkcraft.lib.References;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderGiantSpider extends RenderBiped
{
	public final ResourceLocation texture = new ResourceLocation(References.MODID, "textures/entity/giantSpider.png"); 
	
	public RenderGiantSpider(ModelBiped model, float shadow)
	{
		super(model, shadow);
	}
	
	protected ResourceLocation getEntityTexture(EntityLiving living)
	{
		return this.getGiantSpiderTexture((EntityGiantSpider)living);
	}

	private ResourceLocation getGiantSpiderTexture(EntityGiantSpider mobTutoriel)
	{
		return texture;
	}
}