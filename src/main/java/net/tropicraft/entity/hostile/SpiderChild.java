package net.tropicraft.entity.hostile;

import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.tropicraft.entity.ai.jobs.*;

import CoroUtil.componentAI.jobSystem.*;
import cpw.mods.fml.relauncher.*;

public class SpiderChild extends SpiderBase {

    public int age;
    public int ageMax;

    public SpiderChild(final World par1World) {
        super(par1World);
        this.age = 0;
        this.ageMax = 12000;
        this.agent.jobMan.addJob((JobBase) new JobExtraTargetting(this.agent.jobMan));
        this.setSize(0.5f, 0.35f);
        this.experienceValue = 2;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(5.0);
    }

    @SideOnly(Side.CLIENT)
    public float spiderScaleAmount() {
        return 0.5f;
    }
}
