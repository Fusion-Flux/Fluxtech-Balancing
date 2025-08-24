package com.fusionflux.fluxtechbalancing.util;

import com.fusionflux.fluxtechbalancing.items.*;
import create_ironworks.item.BrassAxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegister {

    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems("fluxtechbalancing");
    public static final DeferredItem<Item> IRONEXCAVATOR;
    public static final DeferredItem<Item> GOLDENEXCAVATOR;
    public static final DeferredItem<Item> COPPEREXCAVATOR;
    public static final DeferredItem<Item> DIAMONDEXCAVATOR;
    public static final DeferredItem<Item> NETHERITEEXCAVATOR;
    public static final DeferredItem<Item> BRONZEEXCAVATOR;
    public static final DeferredItem<Item> BRASSEXCAVATOR;
    public static final DeferredItem<Item> STEELEXCAVATOR;

    public ItemRegister() {
    }

    private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
        return REGISTRY.register(block.getId().getPath(), () -> new BlockItem((Block)block.get(), new Item.Properties()));
    }

    static {
        IRONEXCAVATOR = REGISTRY.register("iron_excavator", IronExcavatorItem::new);
        GOLDENEXCAVATOR = REGISTRY.register("golden_excavator", GoldExcavatorItem::new);
        COPPEREXCAVATOR = REGISTRY.register("copper_excavator", CopperExcavatorItem::new);
        DIAMONDEXCAVATOR = REGISTRY.register("diamond_excavator", DiamondExcavatorItem::new);
        NETHERITEEXCAVATOR = REGISTRY.register("netherite_excavator", NetheriteExcavatorItem::new);
        BRASSEXCAVATOR = REGISTRY.register("brass_excavator", BrassExcavatorItem::new);
        BRONZEEXCAVATOR = REGISTRY.register("bronze_excavator", BronzeExcavatorItem::new);
        STEELEXCAVATOR = REGISTRY.register("steel_excavator", SteelExcavatorItem::new);
    }
}
