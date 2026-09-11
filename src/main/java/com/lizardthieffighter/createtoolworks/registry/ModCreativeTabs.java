package com.lizardthieffighter.createtoolworks.registry;

import com.lizardthieffighter.createtoolworks.CreateToolworks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class ModCreativeTabs {
    private ModCreativeTabs() {}

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateToolworks.MOD_ID);

    public static final Supplier<CreativeModeTab> TOOLWORKS_TAB = CREATIVE_MODE_TABS.register(
            "toolworks",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.createtoolworks.toolworks"))
                    .icon(() -> new ItemStack(ModItems.MECHANICAL_DRILL.get()))
                    .displayItems((parameters, output) -> output.accept(ModItems.MECHANICAL_DRILL.get()))
                    .build()
    );

    public static void register(net.neoforged.bus.api.IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
