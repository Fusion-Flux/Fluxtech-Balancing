package com.fusionflux.fluxtechbalancing.mixin.minecraft;

import com.fusionflux.fluxtechbalancing.FluxtechBalancing;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ServerPlayer.class)
public abstract class PlayerMixin {

    @Shadow public abstract boolean isSpectator();

    @Inject(
            method = "tick",
            at = @At("TAIL")
    )
    private void tickInject(CallbackInfo ci) {
        if (this.isSpectator()){
            List<Entity> nearbyEntities = ((ServerPlayer)(Object)this).level().getEntities( ((ServerPlayer)(Object)this), ((ServerPlayer)(Object)this).getBoundingBox());
            for (Entity entity : nearbyEntities) {
                if (entity instanceof ItemEntity item){
                    ItemStack stack = item.getItem();
                     if(stack.is(FluxtechBalancing.RESITEM)){
                         ((ServerPlayer)(Object)this).setGameMode(GameType.SURVIVAL);
                         ((ServerPlayer)(Object)this).setPos(item.getEyePosition());
                         CriteriaTriggers.USED_TOTEM.trigger(((ServerPlayer)(Object)this), stack);
                         item.discard();
                     }
                }
            }
        }
    }


}
