package com.moosymantheboss.newmod.init;

import com.moosymantheboss.newmod.NewMod;
import com.moosymantheboss.newmod.objects.blocks.ModSaplingBlock;
import com.moosymantheboss.newmod.world.feature.ExampleTree;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInitNew {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, NewMod.MOD_ID);

	public static final RegistryObject<Block> EXAMPLE_PLANKS = BLOCKS.register("example_planks",
			() -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));

	public static final RegistryObject<Block> EXAMPLE_LOG = BLOCKS.register("example_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> EXAMPLE_LEAVES = BLOCKS.register("example_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> EXAMPLE_SAPLING = BLOCKS.register("example_sapling",
			() -> new ModSaplingBlock(() -> new ExampleTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
}
