package com.fusionflux.fluxtechbalancing.mixin.minecraft;

import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(RangedBowAttackGoal.class)
public class RangedAttackGoalMixin {

    @ModifyVariable(
            method = "<init>",
            at = @At("CTOR_HEAD"),
            argsOnly = true,
            ordinal = 0
    )
    private double speedModification(double speed) {
        return speed *1.5;
    }

}
