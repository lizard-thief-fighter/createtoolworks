package com.lizardthieffighter.createtoolworks.datagen;

import com.lizardthieffighter.createtoolworks.CreateToolworks;
import com.lizardthieffighter.createtoolworks.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ToolworksLanguageProvider extends LanguageProvider {
    public ToolworksLanguageProvider(PackOutput output) {
        super(output, CreateToolworks.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.MECHANICAL_DRILL.get(), "Mechanical Drill");
        add("itemGroup.createtoolworks.toolworks", "Create: Toolworks");
    }
}
