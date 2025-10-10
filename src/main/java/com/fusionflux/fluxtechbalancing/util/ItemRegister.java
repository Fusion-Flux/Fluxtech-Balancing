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


    public ItemRegister() {
    }

    private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
        return REGISTRY.register(block.getId().getPath(), () -> new BlockItem((Block)block.get(), new Item.Properties()));
    }

   // static {
//
   // }
}
