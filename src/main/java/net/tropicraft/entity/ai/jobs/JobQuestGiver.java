package net.tropicraft.entity.ai.jobs;

import net.minecraft.entity.player.*;

import CoroUtil.componentAI.jobSystem.*;
import CoroUtil.quest.*;
import CoroUtil.quest.quests.*;

public class JobQuestGiver extends JobBase {

    public JobQuestGiver(final JobManager jm) {
        super(jm);
    }

    public boolean shouldExecute() {
        return true;
    }

    public boolean shouldContinue() {
        return true;
    }

    public boolean hookInteract(final EntityPlayer par1EntityPlayer) {
        if (!this.ent.worldObj.isRemote) {
            final ActiveQuest quest = PlayerQuestManager.i()
                .getPlayerQuests(par1EntityPlayer)
                .getFirstQuestByStatus(EnumQuestState.CONCLUDING);
            if (quest == null) {
                final int randID = 0;
            } else {
                quest.eventComplete();
                this.questComplete(par1EntityPlayer);
            }
            return true;
        }
        return super.hookInteract(par1EntityPlayer);
    }

    public void tick() {
        super.tick();
    }

    public void questComplete(final EntityPlayer par1EntityPlayer) {}
}
