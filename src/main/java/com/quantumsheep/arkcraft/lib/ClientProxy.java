package com.quantumsheep.arkcraft.lib;

import com.quantumsheep.arkcraft.entity.EntityGiantSpider;
import com.quantumsheep.arkcraft.render.RenderGiantSpider;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
	public ClientProxy() {
		// registering the PROXY to use events from MinecraftForge
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public void registerRender()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityGiantSpider.class, new RenderGiantSpider(new ModelBiped(), 0.5F));
	}
}