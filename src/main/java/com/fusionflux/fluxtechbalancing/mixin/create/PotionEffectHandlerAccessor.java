package com.fusionflux.fluxtechbalancing.mixin.create;

import com.simibubi.create.impl.effect.PotionEffectHandler;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.neoforge.fluids.FluidStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PotionEffectHandler.class)
public interface PotionEffectHandlerAccessor {
    @Invoker("getContents")
    static PotionContents callGetContents(FluidStack fluid) { throw new UnsupportedOperationException(); }
}
