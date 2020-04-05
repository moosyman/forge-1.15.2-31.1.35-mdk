package com.moosymantheboss.newmod.world.feature;

import java.util.Random;

import com.moosymantheboss.newmod.init.BlockInitNew;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class ExampleTree extends Tree{

	public static final TreeFeatureConfig EXAMPLE_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInitNew.EXAMPLE_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInitNew.EXAMPLE_LEAVES.get().getDefaultState()),
			new BlobFoliagePlacer(3, 0))).baseHeight(14).heightRandA(5).foliageHeight(6).ignoreVines()
					.setSapling((IPlantable) BlockInitNew.EXAMPLE_SAPLING.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(EXAMPLE_TREE_CONFIG);
	}
	
}
