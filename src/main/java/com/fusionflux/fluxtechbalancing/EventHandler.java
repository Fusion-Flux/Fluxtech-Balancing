package com.fusionflux.fluxtechbalancing;

import com.google.gson.Gson;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.stream.Collectors;

@EventBusSubscriber
public class EventHandler {
   // @SubscribeEvent
   // public static void modsFinished(FMLCommonSetupEvent event){
   //   String json = new Gson().toJson(BuiltInRegistries.BLOCK
   //           .keySet()
   //           .stream().map(ResourceLocation::toString)
   //           .collect(Collectors.toSet()));
   //   System.out.println(json);
   // }
}
