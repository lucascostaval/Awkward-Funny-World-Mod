package net.dotarakotara.awkwardfunnyworldmod.item;

import net.dotarakotara.awkwardfunnyworldmod.AwkwardFunnyWorldMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CALZONE_INGOT = registerItem("calzone_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_CALZONE = registerItem("raw_calzone", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AwkwardFunnyWorldMod.MOD_ID, name), item);
    }

    private static void addItemsToFoodItemGroup(FabricItemGroupEntries entries) {
        entries.add(CALZONE_INGOT);
        entries.add(RAW_CALZONE);
    }

    public static void registerModItems() {
        AwkwardFunnyWorldMod.LOGGER.info("Registering mod items for " + AwkwardFunnyWorldMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodItemGroup);
    }
}
