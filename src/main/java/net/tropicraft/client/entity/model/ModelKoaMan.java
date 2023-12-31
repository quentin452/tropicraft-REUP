package net.tropicraft.client.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelKoaMan extends ModelBase {

    public ModelRenderer bipedHead;
    public ModelRenderer bipedBody;
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedRightLeg;
    public ModelRenderer bipedLeftLeg;
    public ModelRenderer headband;
    public ModelRenderer armband1;
    public ModelRenderer leaf;
    public ModelRenderer leaf3;
    public ModelRenderer leaf2;
    public ModelRenderer leaf4;
    public ModelRenderer leaf5;
    public ModelRenderer leaf6;
    public ModelRenderer leaf7;
    public ModelRenderer leaf8;
    public ModelRenderer leaf9;
    public ModelRenderer leaf10;
    public ModelRenderer armband11;

    public ModelKoaMan() {
        (this.bipedHead = new ModelRenderer((ModelBase) this, 0, 2)).addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.bipedHead.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedHead.setTextureSize(64, 32);
        this.bipedHead.mirror = true;
        this.setRotation(this.bipedHead, 0.0f, 0.0f, 0.0f);
        (this.bipedBody = new ModelRenderer((ModelBase) this, 16, 16)).addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4);
        this.bipedBody.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedBody.setTextureSize(64, 32);
        this.bipedBody.mirror = true;
        this.setRotation(this.bipedBody, 0.0f, 0.0f, 0.0f);
        (this.bipedRightArm = new ModelRenderer((ModelBase) this, 40, 16)).addBox(-2.0f, -2.0f, -2.0f, 3, 12, 4);
        this.bipedRightArm.setRotationPoint(-4.0f, 3.0f, 0.0f);
        this.bipedRightArm.setTextureSize(64, 32);
        this.bipedRightArm.mirror = true;
        this.setRotation(this.bipedRightArm, 0.0f, 0.0f, 0.0f);
        (this.bipedLeftArm = new ModelRenderer((ModelBase) this, 40, 16)).addBox(-1.0f, -2.0f, -2.0f, 3, 12, 4);
        this.bipedLeftArm.setRotationPoint(5.0f, 3.0f, 0.0f);
        this.bipedLeftArm.setTextureSize(64, 32);
        this.bipedLeftArm.mirror = true;
        this.setRotation(this.bipedLeftArm, 0.0f, 0.0f, 0.0f);
        (this.bipedRightLeg = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.bipedRightLeg.setRotationPoint(-2.0f, 12.0f, 0.0f);
        this.bipedRightLeg.setTextureSize(64, 32);
        this.bipedRightLeg.mirror = true;
        this.setRotation(this.bipedRightLeg, 0.0f, 0.0f, 0.0f);
        (this.bipedLeftLeg = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.bipedLeftLeg.setRotationPoint(2.0f, 12.0f, 0.0f);
        this.bipedLeftLeg.setTextureSize(64, 32);
        this.bipedLeftLeg.mirror = true;
        this.setRotation(this.bipedLeftLeg, 0.0f, 0.0f, 0.0f);
        (this.headband = new ModelRenderer((ModelBase) this, 24, 0)).addBox(-5.0f, 0.0f, -5.0f, 10, 2, 10);
        this.headband.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.headband.setTextureSize(64, 32);
        this.headband.mirror = true;
        this.setRotation(this.headband, 0.0f, 0.0f, 0.0f);
        (this.armband1 = new ModelRenderer((ModelBase) this, 35, 5)).addBox(-2.0f, 0.0f, -3.0f, 4, 1, 6);
        this.armband1.setRotationPoint(-6.0f, 3.0f, 0.0f);
        this.armband1.setTextureSize(64, 32);
        this.armband1.mirror = true;
        this.setRotation(this.armband1, 0.0f, 0.0f, 0.0f);
        (this.leaf = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 0, 1);
        this.leaf.setRotationPoint(2.0f, -6.0f, -6.0f);
        this.leaf.setTextureSize(64, 32);
        this.leaf.mirror = true;
        this.setRotation(this.leaf, 0.0f, 0.0f, 0.0f);
        (this.leaf3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 0, 1);
        this.leaf3.setRotationPoint(-1.0f, -6.0f, -6.0f);
        this.leaf3.setTextureSize(64, 32);
        this.leaf3.mirror = true;
        this.setRotation(this.leaf3, 0.0f, 0.0f, 0.0f);
        (this.leaf2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 0, 1);
        this.leaf2.setRotationPoint(-4.0f, -6.0f, -6.0f);
        this.leaf2.setTextureSize(64, 32);
        this.leaf2.mirror = true;
        this.setRotation(this.leaf2, 0.0f, 0.0f, 0.0f);
        (this.leaf4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 0, 1);
        this.leaf4.setRotationPoint(0.0f, -7.0f, -6.0f);
        this.leaf4.setTextureSize(64, 32);
        this.leaf4.mirror = true;
        this.setRotation(this.leaf4, 0.0f, 0.0f, 0.0f);
        (this.leaf5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 0, 1);
        this.leaf5.setRotationPoint(5.0f, -6.0f, -1.0f);
        this.leaf5.setTextureSize(64, 32);
        this.leaf5.mirror = true;
        this.setRotation(this.leaf5, 0.0f, 0.0f, 0.0f);
        (this.leaf6 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 0, 1);
        this.leaf6.setRotationPoint(5.0f, -6.0f, 3.0f);
        this.leaf6.setTextureSize(64, 32);
        this.leaf6.mirror = true;
        this.setRotation(this.leaf6, 0.0f, 0.0f, 0.0f);
        (this.leaf7 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 0, 1);
        this.leaf7.setRotationPoint(-6.0f, -6.0f, 0.0f);
        this.leaf7.setTextureSize(64, 32);
        this.leaf7.mirror = true;
        this.setRotation(this.leaf7, 0.0f, 0.0f, 0.0f);
        (this.leaf8 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 0, 1);
        this.leaf8.setRotationPoint(-6.0f, -6.0f, -4.0f);
        this.leaf8.setTextureSize(64, 32);
        this.leaf8.mirror = true;
        this.setRotation(this.leaf8, 0.0f, 0.0f, 0.0f);
        (this.leaf9 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 0, 1);
        this.leaf9.setRotationPoint(-2.0f, -6.0f, 5.0f);
        this.leaf9.setTextureSize(64, 32);
        this.leaf9.mirror = true;
        this.setRotation(this.leaf9, 0.0f, 0.0f, 0.0f);
        (this.leaf10 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 0, 1);
        this.leaf10.setRotationPoint(2.0f, -6.0f, 5.0f);
        this.leaf10.setTextureSize(64, 32);
        this.leaf10.mirror = true;
        this.setRotation(this.leaf10, 0.0f, 0.0f, 0.0f);
        (this.armband11 = new ModelRenderer((ModelBase) this, 35, -1)).addBox(-2.0f, 0.0f, -3.0f, 4, 1, 6);
        this.armband11.setRotationPoint(6.0f, 3.0f, 0.0f);
        this.armband11.setTextureSize(64, 32);
        this.armband11.mirror = true;
        this.setRotation(this.armband11, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.bipedHead.render(f5);
        this.bipedBody.render(f5);
        this.bipedRightArm.render(f5);
        this.bipedLeftArm.render(f5);
        this.bipedRightLeg.render(f5);
        this.bipedLeftLeg.render(f5);
        this.headband.render(f5);
        this.armband1.render(f5);
        this.leaf.render(f5);
        this.leaf3.render(f5);
        this.leaf2.render(f5);
        this.leaf4.render(f5);
        this.leaf5.render(f5);
        this.leaf6.render(f5);
        this.leaf7.render(f5);
        this.leaf8.render(f5);
        this.leaf9.render(f5);
        this.leaf10.render(f5);
        this.armband11.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    private void a(final ModelRenderer a, final ModelRenderer b) {
        a.rotateAngleX = b.rotateAngleX;
        a.rotateAngleY = b.rotateAngleY;
        a.rotateAngleZ = b.rotateAngleZ;
    }

    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4,
        final float f5, final Entity ent) {
        this.bipedHead.rotateAngleY = f3 / 57.29578f;
        this.bipedHead.rotateAngleX = f4 / 57.29578f;
        this.a(this.headband, this.bipedHead);
        final ModelRenderer leaf = this.leaf;
        final ModelRenderer leaf2 = this.leaf3;
        final ModelRenderer leaf3 = this.leaf2;
        final ModelRenderer leaf4 = this.leaf4;
        final ModelRenderer leaf5 = this.leaf5;
        final ModelRenderer leaf6 = this.leaf6;
        final ModelRenderer leaf7 = this.leaf7;
        final ModelRenderer leaf8 = this.leaf8;
        final ModelRenderer leaf9 = this.leaf9;
        final ModelRenderer leaf10 = this.leaf10;
        final ModelRenderer headband = this.headband;
        final float rotateAngleY = this.bipedHead.rotateAngleY;
        headband.rotateAngleY = rotateAngleY;
        leaf10.rotateAngleX = rotateAngleY;
        leaf9.rotateAngleX = rotateAngleY;
        leaf8.rotateAngleX = rotateAngleY;
        leaf7.rotateAngleX = rotateAngleY;
        leaf6.rotateAngleX = rotateAngleY;
        leaf5.rotateAngleX = rotateAngleY;
        leaf4.rotateAngleX = rotateAngleY;
        leaf3.rotateAngleX = rotateAngleY;
        leaf2.rotateAngleX = rotateAngleY;
        leaf.rotateAngleX = rotateAngleY;
        final ModelRenderer leaf11 = this.leaf;
        final ModelRenderer leaf12 = this.leaf3;
        final ModelRenderer leaf13 = this.leaf2;
        final ModelRenderer leaf14 = this.leaf4;
        final ModelRenderer leaf15 = this.leaf5;
        final ModelRenderer leaf16 = this.leaf6;
        final ModelRenderer leaf17 = this.leaf7;
        final ModelRenderer leaf18 = this.leaf8;
        final ModelRenderer leaf19 = this.leaf9;
        final ModelRenderer leaf20 = this.leaf10;
        final ModelRenderer headband2 = this.headband;
        final float rotateAngleY2 = this.bipedHead.rotateAngleY;
        headband2.rotateAngleY = rotateAngleY2;
        leaf20.rotateAngleY = rotateAngleY2;
        leaf19.rotateAngleY = rotateAngleY2;
        leaf18.rotateAngleY = rotateAngleY2;
        leaf17.rotateAngleY = rotateAngleY2;
        leaf16.rotateAngleY = rotateAngleY2;
        leaf15.rotateAngleY = rotateAngleY2;
        leaf14.rotateAngleY = rotateAngleY2;
        leaf13.rotateAngleY = rotateAngleY2;
        leaf12.rotateAngleY = rotateAngleY2;
        leaf11.rotateAngleY = rotateAngleY2;
        final ModelRenderer leaf21 = this.leaf;
        final ModelRenderer leaf22 = this.leaf3;
        final ModelRenderer leaf23 = this.leaf2;
        final ModelRenderer leaf24 = this.leaf4;
        final ModelRenderer leaf25 = this.leaf5;
        final ModelRenderer leaf26 = this.leaf6;
        final ModelRenderer leaf27 = this.leaf7;
        final ModelRenderer leaf28 = this.leaf8;
        final ModelRenderer leaf29 = this.leaf9;
        final ModelRenderer leaf30 = this.leaf10;
        final ModelRenderer headband3 = this.headband;
        final float rotateAngleZ = this.bipedHead.rotateAngleZ;
        headband3.rotateAngleZ = rotateAngleZ;
        leaf30.rotateAngleZ = rotateAngleZ;
        leaf29.rotateAngleZ = rotateAngleZ;
        leaf28.rotateAngleZ = rotateAngleZ;
        leaf27.rotateAngleZ = rotateAngleZ;
        leaf26.rotateAngleZ = rotateAngleZ;
        leaf25.rotateAngleZ = rotateAngleZ;
        leaf24.rotateAngleZ = rotateAngleZ;
        leaf23.rotateAngleZ = rotateAngleZ;
        leaf22.rotateAngleZ = rotateAngleZ;
        leaf21.rotateAngleZ = rotateAngleZ;
        this.bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.141593f) * 2.0f * f1 * 0.5f;
        this.bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f;
        this.bipedRightArm.rotateAngleZ = 0.0f;
        this.bipedLeftArm.rotateAngleZ = 0.0f;
        this.a(this.armband1, this.bipedRightArm);
        this.bipedRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        this.bipedLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.141593f) * 1.4f * f1;
        this.bipedRightLeg.rotateAngleY = 0.0f;
        this.bipedLeftLeg.rotateAngleY = 0.0f;
        this.a(this.armband11, this.bipedLeftArm);
        if (this.isRiding) {
            final ModelRenderer bipedRightArm = this.bipedRightArm;
            bipedRightArm.rotateAngleX -= 0.6283185f;
            final ModelRenderer bipedLeftArm = this.bipedLeftArm;
            bipedLeftArm.rotateAngleX -= 0.6283185f;
            this.bipedRightLeg.rotateAngleX = -1.256637f;
            this.bipedLeftLeg.rotateAngleX = -1.256637f;
            this.bipedRightLeg.rotateAngleY = 0.3141593f;
            this.bipedLeftLeg.rotateAngleY = -0.3141593f;
            this.a(this.armband1, this.bipedRightArm);
            this.a(this.armband11, this.bipedLeftArm);
        }
        this.bipedRightArm.rotateAngleY = 0.0f;
        this.bipedLeftArm.rotateAngleY = 0.0f;
        this.a(this.armband1, this.bipedRightArm);
        this.a(this.armband11, this.bipedLeftArm);
        if (this.onGround > -9990.0f) {
            float f6 = this.onGround;
            this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * 3.141593f * 2.0f) * 0.2f;
            this.bipedRightArm.rotationPointZ = MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0f;
            this.bipedRightArm.rotationPointX = -MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0f;
            this.a(this.armband1, this.bipedRightArm);
            this.bipedLeftArm.rotationPointZ = -MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0f;
            this.bipedLeftArm.rotationPointX = MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0f;
            this.a(this.armband11, this.bipedLeftArm);
            final ModelRenderer bipedRightArm2 = this.bipedRightArm;
            bipedRightArm2.rotateAngleY += this.bipedBody.rotateAngleY;
            this.a(this.armband1, this.bipedRightArm);
            final ModelRenderer bipedLeftArm2 = this.bipedLeftArm;
            bipedLeftArm2.rotateAngleY += this.bipedBody.rotateAngleY;
            final ModelRenderer bipedLeftArm3 = this.bipedLeftArm;
            bipedLeftArm3.rotateAngleX += this.bipedBody.rotateAngleY;
            this.a(this.armband1, this.bipedRightArm);
            this.a(this.armband11, this.bipedLeftArm);
            f6 = 1.0f - this.onGround;
            f6 *= f6;
            f6 *= f6;
            f6 = 1.0f - f6;
            final float f7 = MathHelper.sin(f6 * 3.141593f);
            final float f8 = MathHelper.sin(this.onGround * 3.141593f) * -(this.bipedHead.rotateAngleX - 0.7f) * 0.75f;
            final ModelRenderer bipedRightArm3 = this.bipedRightArm;
            bipedRightArm3.rotateAngleX -= (float) (f7 * 1.2 + f8);
            final ModelRenderer bipedRightArm4 = this.bipedRightArm;
            bipedRightArm4.rotateAngleY += this.bipedBody.rotateAngleY * 2.0f;
            this.bipedRightArm.rotateAngleZ = MathHelper.sin(this.onGround * 3.141593f) * -0.4f;
            this.a(this.armband1, this.bipedRightArm);
            this.a(this.armband11, this.bipedLeftArm);
        }
        this.bipedBody.rotateAngleX = 0.0f;
        this.bipedRightLeg.rotationPointZ = 0.0f;
        this.bipedLeftLeg.rotationPointZ = 0.0f;
        this.bipedRightLeg.rotationPointY = 12.0f;
        this.bipedLeftLeg.rotationPointY = 12.0f;
        this.bipedHead.rotationPointY = 0.0f;
        this.a(this.headband, this.bipedHead);
        final float ffff = this.headband.rotationPointY;
        final ModelRenderer leaf31 = this.leaf;
        final ModelRenderer leaf32 = this.leaf3;
        final ModelRenderer leaf33 = this.leaf2;
        final ModelRenderer leaf34 = this.leaf4;
        final ModelRenderer leaf35 = this.leaf5;
        final ModelRenderer leaf36 = this.leaf6;
        final ModelRenderer leaf37 = this.leaf7;
        final ModelRenderer leaf38 = this.leaf8;
        final ModelRenderer leaf39 = this.leaf9;
        final ModelRenderer leaf40 = this.leaf10;
        final ModelRenderer headband4 = this.headband;
        final float rotationPointY = this.bipedHead.rotationPointY + ffff;
        headband4.rotationPointY = rotationPointY;
        leaf40.rotationPointY = rotationPointY;
        leaf39.rotationPointY = rotationPointY;
        leaf38.rotationPointY = rotationPointY;
        leaf37.rotationPointY = rotationPointY;
        leaf36.rotationPointY = rotationPointY;
        leaf35.rotationPointY = rotationPointY;
        leaf34.rotationPointY = rotationPointY;
        leaf33.rotationPointY = rotationPointY;
        leaf32.rotationPointY = rotationPointY;
        leaf31.rotationPointY = rotationPointY;
        final ModelRenderer bipedRightArm5 = this.bipedRightArm;
        bipedRightArm5.rotateAngleZ += MathHelper.cos(f2 * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedLeftArm4 = this.bipedLeftArm;
        bipedLeftArm4.rotateAngleZ -= MathHelper.cos(f2 * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedRightArm6 = this.bipedRightArm;
        bipedRightArm6.rotateAngleX += MathHelper.sin(f2 * 0.067f) * 0.05f;
        final ModelRenderer bipedLeftArm5 = this.bipedLeftArm;
        bipedLeftArm5.rotateAngleX -= MathHelper.sin(f2 * 0.067f) * 0.05f;
        this.a(this.armband1, this.bipedRightArm);
        this.a(this.armband11, this.bipedLeftArm);
    }
}
