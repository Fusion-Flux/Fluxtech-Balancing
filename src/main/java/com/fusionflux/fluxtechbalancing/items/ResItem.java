package com.fusionflux.fluxtechbalancing.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class ResItem extends Item {
    public ResItem(Properties properties) {
        super(properties);
    }

    @Override
     public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("fluxtechbalancing.resitemlore").withStyle(ChatFormatting.LIGHT_PURPLE));
     }

}
