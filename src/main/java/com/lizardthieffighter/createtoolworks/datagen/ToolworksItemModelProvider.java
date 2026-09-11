package com.lizardthieffighter.createtoolworks.datagen;

import com.lizardthieffighter.createtoolworks.CreateToolworks;
import com.lizardthieffighter.createtoolworks.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ToolworksItemModelProvider extends ItemModelProvider {
    public ToolworksItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CreateToolworks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Temporary placeholder: render the drill using Minecraft's stick model.
        withExistingParent(ModItems.MECHANICAL_DRILL.getId().getPath(), mcLoc("item/stick"));
    }
}
