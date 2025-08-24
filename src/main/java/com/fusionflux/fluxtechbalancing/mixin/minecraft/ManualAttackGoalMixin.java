package com.fusionflux.fluxtechbalancing.mixin.minecraft;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Zombie;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

    @Mixin(MeleeAttackGoal.class)
public class ManualAttackGoalMixin {

        @Shadow @Final protected PathfinderMob mob;

        @ModifyVariable(
            method = "<init>",
            at = @At("CTOR_HEAD"),
            argsOnly = true,
            ordinal = 0
    )
    private double speedModification(double speed) {
            if(mob != null) {
                if (mob.isBaby())
                    return speed;
                if (mob instanceof WitherSkeleton)
                    return speed * 1.15;
            }
        return speed *1.25;
    }

}
