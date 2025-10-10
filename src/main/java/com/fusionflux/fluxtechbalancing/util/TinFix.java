package com.fusionflux.fluxtechbalancing.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TinFix {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("fluxtechbalancing");
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("fluxtechbalancing");
    static {
        BLOCKS.addAlias(ResourceLocation.fromNamespaceAndPath("create_ironworks","tin_ore"), ResourceLocation.withDefaultNamespace("stone"));
        BLOCKS.addAlias(ResourceLocation.fromNamespaceAndPath("create_ironworks","deepslate_tin_ore"), ResourceLocation.withDefaultNamespace("deepslate"));
        ITEMS.addAlias(ResourceLocation.fromNamespaceAndPath("create_ironworks","raw_tin"), ResourceLocation.withDefaultNamespace("raw_iron"));
        ITEMS.addAlias(ResourceLocation.fromNamespaceAndPath("create_ironworks","tin_ingot"), ResourceLocation.withDefaultNamespace("iron_ingot"));
        ITEMS.addAlias(ResourceLocation.fromNamespaceAndPath("create_ironworks","bronze_ingot"), ResourceLocation.fromNamespaceAndPath("create","brass_ingot"));
        ITEMS.addAlias(ResourceLocation.fromNamespaceAndPath("create_ironworks","iron_hammer"), ResourceLocation.fromNamespaceAndPath("onlyhammersandexcavators","iron_hammer"));
        ITEMS.addAlias(ResourceLocation.fromNamespaceAndPath("create_ironworks","golden_hammer"), ResourceLocation.fromNamespaceAndPath("onlyhammersandexcavators","gold_hammer"));
        ITEMS.addAlias(ResourceLocation.fromNamespaceAndPath("create_ironworks","diamond_hammer"), ResourceLocation.fromNamespaceAndPath("onlyhammersandexcavators","diamond_hammer"));
        ITEMS.addAlias(ResourceLocation.fromNamespaceAndPath("create_ironworks","netherite_hammer"), ResourceLocation.fromNamespaceAndPath("onlyhammersandexcavators","netherite_hammer"));
        ITEMS.addAlias(ResourceLocation.fromNamespaceAndPath("fluxtechbalancing","iron_excavator"), ResourceLocation.fromNamespaceAndPath("onlyhammersandexcavators","iron_excavator"));
        ITEMS.addAlias(ResourceLocation.fromNamespaceAndPath("fluxtechbalancing","golden_excavator"), ResourceLocation.fromNamespaceAndPath("onlyhammersandexcavators","golden_excavator"));
        ITEMS.addAlias(ResourceLocation.fromNamespaceAndPath("fluxtechbalancing","diamond_excavator"), ResourceLocation.fromNamespaceAndPath("onlyhammersandexcavators","diamond_excavator"));
        ITEMS.addAlias(ResourceLocation.fromNamespaceAndPath("fluxtechbalancing","netherite_excavator"), ResourceLocation.fromNamespaceAndPath("onlyhammersandexcavators","netherite_excavator"));
    }
}
