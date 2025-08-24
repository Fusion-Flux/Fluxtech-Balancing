package com.fusionflux.fluxtechbalancing.items;

import create_ironworks.item.NetheriteHammerItem;
import create_ironworks.procedures.HammerProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class NetheriteExcavatorItem extends ShovelItem {
    private static final Tier TOOL_TIER = new Tier() {
        @Override
        public int getUses() {
            return 1015;
        }
        @Override
        public float getSpeed() {
            return 7.0F;
        }
        @Override
        public float getAttackDamageBonus() {
            return 0.0F;
        }
        @Override
        public TagKey<Block> getIncorrectBlocksForDrops() {
            return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
        }
        @Override
        public int getEnchantmentValue() {
            return 15;
        }
        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(new ItemStack[]{new ItemStack(Items.NETHERITE_INGOT)});
        }
    };

    public NetheriteExcavatorItem() {
        super(TOOL_TIER, (new Item.Properties()).attributes(DiggerItem.createAttributes(TOOL_TIER, 8.0F, -3.2F)).fireResistant());
    }

    public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
        boolean retval = super.mineBlock(itemstack, world, blockstate, pos, entity);
        HammerProcedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), entity, itemstack);
        return retval;
    }
}
