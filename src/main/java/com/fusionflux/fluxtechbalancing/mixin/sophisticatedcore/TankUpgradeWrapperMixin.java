package com.fusionflux.fluxtechbalancing.mixin.sophisticatedcore;

import com.fusionflux.fluxtechbalancing.util.PotionHelper;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.simibubi.create.content.fluids.potion.PotionFluidHandler;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.p3pp3rf1y.sophisticatedcore.upgrades.tank.TankUpgradeWrapper;
import net.p3pp3rf1y.sophisticatedcore.upgrades.tank.TankUpgradeWrapper.TankComponentItemHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TankUpgradeWrapper.class)
public abstract class TankUpgradeWrapperMixin {
    @Shadow @Final private TankUpgradeWrapper.TankComponentItemHandler inventory;

    @Shadow private FluidStack contents;

    @Shadow public abstract int getTankCapacity();

    @Shadow public abstract int fill(FluidStack resource, IFluidHandler.FluidAction action, boolean ignoreInOutLimit);

    @Shadow public abstract FluidStack drain(int maxDrain, IFluidHandler.FluidAction action, boolean ignoreInOutLimit);

	@Shadow
	@Final
	public static int INPUT_SLOT;

	@Shadow
	@Final
	public static int OUTPUT_SLOT;

	@Shadow
	@Final
	public static int OUTPUT_RESULT_SLOT;

	@Shadow
	@Final
	public static int INPUT_RESULT_SLOT;

	@ModifyExpressionValue(method = "tick(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;)V", at = @At(value = "INVOKE", target = "Lnet/p3pp3rf1y/sophisticatedcore/upgrades/tank/TankUpgradeWrapper;tryFilling(Lnet/minecraft/world/item/ItemStack;)Z"))
    public boolean injectTick(boolean original) {
		if (!original) {
			ItemStack inputStack = inventory.getStackInSlot(INPUT_SLOT);
			ItemStack outputStack = inventory.getStackInSlot(OUTPUT_SLOT);

			ItemStack inputResultStack = inventory.getStackInSlot(INPUT_RESULT_SLOT);
			ItemStack outputResultStack = inventory.getStackInSlot(OUTPUT_RESULT_SLOT);

			if (PotionFluidHandler.isPotionItem(inputStack)) {
				FluidStack fluid = PotionFluidHandler.getFluidFromPotionItem(inputStack);

				if (contents.isEmpty() || FluidStack.isSameFluidSameComponents(contents, fluid) &&
						getTankCapacity() - contents.getAmount() >= fluid.getAmount()) {

					inputStack.shrink(1);
					inventory.setStackInSlot(INPUT_SLOT, inputStack);

					if (inputResultStack.isEmpty()) {
						inputResultStack = Items.GLASS_BOTTLE.getDefaultInstance();
					} else {
						inputResultStack.grow(1);
					}

					inventory.setStackInSlot(INPUT_RESULT_SLOT, inputResultStack);

					fill(fluid, IFluidHandler.FluidAction.EXECUTE, false);

					original = true;
				}
			}

			if (outputStack.is(Items.GLASS_BOTTLE) && outputResultStack.isEmpty()) {
				int outAmount = PotionHelper.getBottleAmount();
				if (contents.getAmount() >= outAmount && PotionHelper.isPotionFluid(contents)) {
					ItemStack filledItem = PotionFluidHandler.fillBottle(outputStack, contents);

					drain(outAmount, IFluidHandler.FluidAction.EXECUTE, false);

					outputStack.shrink(1);
					inventory.setStackInSlot(OUTPUT_SLOT, outputStack);
					inventory.setStackInSlot(OUTPUT_RESULT_SLOT, filledItem);

					original = true;
				}
			}
		}

		return original;
	}
	
	@Mixin(TankComponentItemHandler.class)
	public static class TankComponentItemHandlerMixin {
		@Inject(method = "isItemValid", at = @At("HEAD"), remap = false, cancellable = true)
		public void injectIsValidFluidItem(int slot, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		    if ((slot == 0 && PotionFluidHandler.isPotionItem(stack)) || (slot == 1 && stack.is(Items.GLASS_BOTTLE))) {
		        cir.setReturnValue(true);
		        cir.cancel();
		    }
		}
	}
}
