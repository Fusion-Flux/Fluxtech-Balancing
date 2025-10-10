package com.fusionflux.fluxtechbalancing;

import com.google.gson.Gson;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import static com.simibubi.create.Create.asResource;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.stream.Collectors;

@EventBusSubscriber
public class EventHandler {

    @SubscribeEvent
    public static void remap(RegisterEvent event) {
        Registry<?> registry = event.getRegistry();

        if (registry == Registries.BLOCK) {
            registry.addAlias(ResourceLocation.fromNamespaceAndPath("create_ironworks", "tin_ore"), ResourceLocation.fromNamespaceAndPath("minecraft", "stone"));
            registry.addAlias(ResourceLocation.fromNamespaceAndPath("create_ironworks", "deepslate_tin_ore"), ResourceLocation.fromNamespaceAndPath("minecraft", "deepslate"));
        }
    }

    @SubscribeEvent
    public static void modsFinished(FMLCommonSetupEvent event){

        //String json = new Gson().toJson(BuiltInRegistries.BLOCK
        //        .keySet()
        //        .stream().map(ResourceLocation::toString)
        //        .collect(Collectors.toSet()));
        //System.out.println(json);
    }
}
