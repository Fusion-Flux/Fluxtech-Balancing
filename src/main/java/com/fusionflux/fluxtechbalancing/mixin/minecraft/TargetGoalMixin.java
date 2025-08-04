package com.fusionflux.fluxtechbalancing.mixin.minecraft;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TargetGoal.class)
public class TargetGoalMixin {

    @ModifyReturnValue(method = "getFollowDistance", at = @At("RETURN"))
    private double modifyGetFollowDistance(double originalDistance) {
        return originalDistance*2;
    }
}
