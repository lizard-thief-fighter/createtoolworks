package com.lizardthieffighter.createtoolworks;

import com.lizardthieffighter.createtoolworks.registry.ModCreativeTabs;
import com.lizardthieffighter.createtoolworks.registry.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(CreateToolworks.MOD_ID)
public class CreateToolworks {
    public static final String MOD_ID = "createtoolworks";

    public CreateToolworks(IEventBus modEventBus) {
        ModItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
    }
}
