package com.fusionflux.fluxtechbalancing.items;

import create_ironworks.item.CopperHammerItem;
import create_ironworks.procedures.HammerProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

public class CopperExcavatorItem extends ShovelItem {
    private static final Tier TOOL_TIER = new Tier() {
        @Override
        public int getUses() {
            return 72;
        }
        @Override
        public float getSpeed() {
            return 3.0F;
        }
        @Override
        public float getAttackDamageBonus() {
            return 0.0F;
        }
        @Override
        public TagKey<Block> getIncorrectBlocksForDrops() {
            return BlockTags.INCORRECT_FOR_STONE_TOOL;
        }
        @Override
        public int getEnchantmentValue() {
            return 12;
        }
        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(new ItemStack[]{new ItemStack(Items.COPPER_INGOT)});
        }
    };

    public CopperExcavatorItem() {
        super(TOOL_TIER, (new Item.Properties()).attributes(DiggerItem.createAttributes(TOOL_TIER, 5.0F, -3.2F)));
    }

    public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
        boolean retval = super.mineBlock(itemstack, world, blockstate, pos, entity);
        HammerProcedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), entity, itemstack);
        return retval;
    }
    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        list.add(Component.translatable("item.fluxtechbalancing.copper_excavator.description_0"));
        list.add(Component.translatable("item.fluxtechbalancing.copper_excavator.description_1"));
    }
}
