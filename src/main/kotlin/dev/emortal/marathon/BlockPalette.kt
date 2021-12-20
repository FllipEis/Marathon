package dev.emortal.marathon

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.minestom.server.instance.block.Block
import net.minestom.server.item.Material
import net.minestom.server.sound.SoundEvent
import world.cepi.kstom.adventure.asMini

enum class BlockPalette(
    val displayItem: Material,
    val displayName: Component,
    val soundEffect: SoundEvent,
    vararg val blocks: Block
) {
    GRASS(
        Material.GRASS_BLOCK,
        Component.text("Grass", NamedTextColor.GREEN),
        SoundEvent.BLOCK_GRASS_BREAK,
        Block.GRASS_BLOCK,
        Block.OAK_LOG,
        Block.BIRCH_LOG,
        Block.OAK_LEAVES,
        Block.BIRCH_LEAVES
    ),

    CAVE(
        Material.STONE,
        Component.text("Cave", NamedTextColor.GRAY),
        SoundEvent.BLOCK_DEEPSLATE_BREAK,
        Block.STONE,
        Block.STONE,
        Block.STONE,
        Block.STONE,
        Block.STONE,
        Block.STONE,
        Block.STONE,
        Block.STONE,
        Block.ANDESITE,
        Block.ANDESITE,
        Block.ANDESITE,
        Block.ANDESITE,
        Block.ANDESITE,
        Block.DEEPSLATE,
        Block.IRON_ORE,
        Block.DEEPSLATE_IRON_ORE,
        Block.DIAMOND_ORE,
        Block.DEEPSLATE_DIAMOND_ORE,
        Block.EMERALD_ORE,
        Block.DEEPSLATE_EMERALD_ORE,
        Block.REDSTONE_ORE,
        Block.DEEPSLATE_REDSTONE_ORE,
        Block.COAL_ORE,
        Block.DEEPSLATE_COAL_ORE,
        Block.LAPIS_ORE,
        Block.DEEPSLATE_LAPIS_ORE
    ),

    RAINBOW(
        Material.PINK_WOOL,
        "<rainbow>Rainbow".asMini(),
        SoundEvent.BLOCK_WOOL_BREAK,
        Block.RED_WOOL,
        Block.ORANGE_WOOL,
        Block.YELLOW_WOOL,
        Block.LIME_WOOL,
        Block.LIGHT_BLUE_WOOL,
        Block.CYAN_WOOL,
        Block.PINK_WOOL,
        Block.MAGENTA_WOOL,
        Block.PURPLE_WOOL
    )
}