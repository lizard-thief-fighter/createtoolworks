package com.lizardthieffighter.createtoolworks.datagen;

import com.lizardthieffighter.createtoolworks.CreateToolworks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = CreateToolworks.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class ToolworksDataGenerators {
    private ToolworksDataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var output = generator.getPackOutput();
        var existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(
                event.includeClient(),
                new ToolworksItemModelProvider(output, existingFileHelper)
        );
        generator.addProvider(
                event.includeClient(),
                new ToolworksLanguageProvider(output)
        );
        generator.addProvider(
                event.includeServer(),
                new ToolworksRecipeProvider(output, event.getLookupProvider())
        );
    }
}
