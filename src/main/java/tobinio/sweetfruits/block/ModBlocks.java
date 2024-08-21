package tobinio.sweetfruits.block;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import tobinio.sweetfruits.SweetFruits;
import tobinio.sweetfruits.block.custom.AppleBlock;
import tobinio.sweetfruits.world.ModConfiguredFeatures;

import java.util.Optional;

/**
 * Created: 19.08.24
 *
 * @author Tobias Frischmann
 */
public class ModBlocks {
    public static final Block APPLE_SAPLING = registerBlock("apple_sapling",
            new SaplingBlock(new SaplingGenerator("apple",
                    0.1F,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.of(ModConfiguredFeatures.APPLE),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty()), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)),
            true);

    public static final Block APPLE = registerBlock("apple",
            new AppleBlock(AbstractBlock.Settings.create()
                    .noCollision()
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .breakInstantly()
                    .offset(AbstractBlock.OffsetType.XZ)),
            false);

    public static final Block APPLE_LEAVES = registerBlock("apple_leaves",
            Blocks.createLeavesBlock(BlockSoundGroup.GRASS),
            true);

    private static Block registerBlock(String name, Block block, boolean blockItem) {
        if (blockItem) {
            registerBlockItem(name, block);
        }
        return Registry.register(Registries.BLOCK, Identifier.of(SweetFruits.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM,
                Identifier.of(SweetFruits.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void initialize() {
    }
}
