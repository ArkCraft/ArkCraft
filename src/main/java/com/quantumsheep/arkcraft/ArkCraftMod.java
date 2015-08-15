package com.quantumsheep.arkcraft;

import java.awt.Color;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.quantumsheep.arkcraft.entity.EntityGiantSpider;
import com.quantumsheep.arkcraft.entity.EntitySpear;
import com.quantumsheep.arkcraft.lib.CommonProxy;
import com.quantumsheep.arkcraft.lib.EntityEventHandler;
import com.quantumsheep.arkcraft.lib.References;
import com.quantumsheep.arkcraft.weapons.WeaponSpear;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.gui.Gui;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = References.MODID, name = "ArkCraft Mod", version = References.VERSION)

public class ArkCraftMod {

	@Instance("arkcraft")
	public static ArkCraftMod instance;
	
	@SidedProxy(clientSide = References.Client, serverSide = References.Common)
	public static CommonProxy proxy;

	public static Item weaponSpear;
	
	public static final Logger LOGGER = LogManager.getLogger(References.NAME);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		weaponSpear = new WeaponSpear().setUnlocalizedName("weaponSpear").setTextureName(References.MODID + ":weaponSpear").setCreativeTab(CreativeTabs.tabMaterials);
		
		GameRegistry.registerItem(weaponSpear, "weapon_spear");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		EntityRegistry.registerGlobalEntityID(EntitySpear.class, "entitySpear", EntityRegistry.findGlobalUniqueEntityId(), new Color(0, 255, 0).getRGB(), new Color(255, 0, 0).getRGB());
		EntityRegistry.registerModEntity(EntitySpear.class, "entitySpear", 420, this.instance, 40, 1, true);
		//
		EntityRegistry.registerGlobalEntityID(EntityGiantSpider.class, "giantSpider", EntityRegistry.findGlobalUniqueEntityId(), 0x7AE8FF, 0x47FFE2);
		
        MinecraftForge.EVENT_BUS.register(new EntityEventHandler());
		proxy.registerRender();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}
}