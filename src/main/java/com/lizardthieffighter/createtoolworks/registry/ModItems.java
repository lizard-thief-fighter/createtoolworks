package com.lizardthieffighter.createtoolworks.registry;

import com.lizardthieffighter.createtoolworks.CreateToolworks;
import com.lizardthieffighter.createtoolworks.item.MechanicalDrillItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.bus.api.IEventBus;

public final class ModItems {
    private ModItems() {}

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateToolworks.MOD_ID);

    public static final DeferredItem<Item> MECHANICAL_DRILL = ITEMS.registerItem(
            "mechanical_drill",
            MechanicalDrillItem::new,
            new Item.Properties().stacksTo(1).durability(1024)
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
