package com.fusionflux.fluxtechbalancing.mixin.minecraft;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(Projectile.class)
public class ArrowMixin {

    @Shadow @Nullable private Entity cachedOwner;

    @Inject(method="canHitEntity", at = @At("HEAD"), cancellable = true)
    private void skeletonfixer(Entity target, CallbackInfoReturnable<Boolean> cir){
    if((cachedOwner instanceof Skeleton && target instanceof Monster) ||  (cachedOwner instanceof Pillager && target instanceof Monster) || (cachedOwner instanceof Drowned && target instanceof Monster) || (cachedOwner instanceof Piglin && target instanceof Monster) ){
        cir.setReturnValue(false);
    }
}

}
