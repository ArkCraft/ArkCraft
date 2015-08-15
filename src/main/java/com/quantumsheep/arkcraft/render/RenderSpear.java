package com.quantumsheep.arkcraft.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.quantumsheep.arkcraft.entity.EntitySpear;
import com.quantumsheep.arkcraft.lib.References;
import com.quantumsheep.arkcraft.models.ModelSpear;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderSpear extends Render
{
    private static final ResourceLocation SpearTextures = new ResourceLocation(References.MODID, "textures/models/ModelSpear.png");

    protected ModelBase model;

    public RenderSpear()
    {
        this.shadowSize = 0.5F;
        this.model = new ModelSpear();
    }

    public void renderSpear(EntitySpear entitySpear, double par2, double par4, double par6, float par8, float par9)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glRotatef(180.0F - par8, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(entitySpear.prevRotationYaw + (entitySpear.rotationYaw - entitySpear.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(entitySpear.prevRotationPitch + (entitySpear.rotationPitch - entitySpear.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
        float f4 = 5.75F;
        GL11.glScalef(f4, f4, f4);
        GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
        this.bindEntityTexture(entitySpear);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        this.model.render(entitySpear, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    protected ResourceLocation getTextures(EntitySpear entitySpear)
    {
        return SpearTextures;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getTextures((EntitySpear)entity);
    }

    @Override
    public void doRender(Entity entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderSpear((EntitySpear)entity, par2, par4, par6, par8, par9);
    }
}