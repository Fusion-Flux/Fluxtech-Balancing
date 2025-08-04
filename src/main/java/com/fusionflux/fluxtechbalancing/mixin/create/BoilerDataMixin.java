package com.fusionflux.fluxtechbalancing.mixin.create;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.simibubi.create.content.fluids.tank.BoilerData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BoilerData.class)
public abstract class BoilerDataMixin {


    @Shadow public abstract boolean isPassive(int boilerSize);

    @Shadow @Final private static float passiveEngineEfficiency;

    @Shadow public int attachedEngines;

    @Shadow public int activeHeat;

    @Shadow protected abstract int getActualHeat(int boilerSize);

    @ModifyReturnValue(
            method = "getEngineEfficiency",
            at = @At(
                    value="RETURN"
            )
    )
    private float engineEfficencyModification(float original, int boilerSize){
        if (isPassive(boilerSize)) {
            //eh.
            return passiveEngineEfficiency / attachedEngines/2/2;
        }
        if (activeHeat == 0)
            return 0;
        float actualHeat = exponentalheat(getActualHeat(boilerSize));
        return attachedEngines <= actualHeat ? 1 : (float) actualHeat / attachedEngines;
    }

    float exponentalheat(int x) {
        float y = x / 18f;
        return (float) (0.0625 + 17.9375 * Math.pow(y, 3.57));
    }
}
