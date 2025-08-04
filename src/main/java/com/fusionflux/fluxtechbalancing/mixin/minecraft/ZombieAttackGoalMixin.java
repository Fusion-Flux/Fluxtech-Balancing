package com.fusionflux.fluxtechbalancing.mixin.minecraft;

import net.minecraft.world.entity.ai.goal.ZombieAttackGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ZombieAttackGoal.class)
public class ZombieAttackGoalMixin {

    //@ModifyVariable(
    //        method = "<init>",
    //        at = @At("CTOR_HEAD"),
    //        argsOnly = true,
    //        ordinal = 0
    //)
    //private double speedModification(double speed) {
    //    return speed *1.5;
    //}

}
