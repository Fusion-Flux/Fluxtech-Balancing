package com.fusionflux.fluxtechbalancing.util;

import com.fusionflux.fluxtechbalancing.mixin.create.PotionEffectHandlerAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.neoforge.fluids.FluidStack;

public class PotionHelper {
    public static int getBottleAmount() {
        // PotionFluidHandler.getRequiredAmountForFilledBottle
        return 250;
    }

    public static boolean isPotionFluid(FluidStack fluidStack) {
        //CompoundTag tag = fluidStack.getOrCreateTag();
        return PotionEffectHandlerAccessor.callGetContents(fluidStack).hasEffects();
    }
}
