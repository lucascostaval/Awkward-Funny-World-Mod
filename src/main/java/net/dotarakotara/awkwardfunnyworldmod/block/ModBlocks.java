package net.dotarakotara.awkwardfunnyworldmod.block;

import net.dotarakotara.awkwardfunnyworldmod.AwkwardFunnyWorldMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block CALZONE_BLOCK = registerBlock("calzone_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(AwkwardFunnyWorldMod.MOD_ID, name), block);
    }
    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(AwkwardFunnyWorldMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void addItemsToBuildingItemGroup(FabricItemGroupEntries entries) {
        entries.add(CALZONE_BLOCK);
    }

    public static void registerModBlocks() {
        AwkwardFunnyWorldMod.LOGGER.info("Registering modblocks for " + AwkwardFunnyWorldMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addItemsToBuildingItemGroup);
    }
}
