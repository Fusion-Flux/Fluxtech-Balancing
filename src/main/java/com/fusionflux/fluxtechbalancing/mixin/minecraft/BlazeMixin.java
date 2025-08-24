package com.fusionflux.fluxtechbalancing.mixin.minecraft;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(targets = "net/minecraft/world/entity/monster/Blaze$BlazeAttackGoal")
public class BlazeMixin {


    @Shadow @Final private Blaze blaze;

    @ModifyExpressionValue(
            method = "tick()V",
          at =  @At(value = "CONSTANT", args = "doubleValue=2.297")
    )
    private double modifySpreadConstant(double constant) {
        return .1; // Replace 2.297 with your desired value
    }

    @ModifyArgs(method = "tick()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/phys/Vec3;<init>(DDD)V"))
    private void modifyBlazeTargeting(Args args) {
        LivingEntity livingentity = this.blaze.getTarget();
        assert livingentity != null;


        double distance =  livingentity.distanceTo(this.blaze)*1.5;
        Vec3 vec = livingentity.getKnownMovement().multiply(distance,1,distance);
        double x = args.get(0);
        double y = args.get(1);
        double z = args.get(2);
        args.set(0, x + vec.x());
        args.set(1, y + vec.y());
        args.set(2, z + vec.z());
    }

}
