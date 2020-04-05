package com.moosymantheboss.newmod.world.gen;

import com.moosymantheboss.newmod.init.Blockinit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class TutorialOreGen {

	public static void generateOre() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			//Jaden ore generation
			ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 5, 5, 25));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
			Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
			Blockinit.jaden_ore.getDefaultState(), 4)).withPlacement(customConfig));
			
			//Gem vein generation
			ConfiguredPlacement customConfig2 = Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 5, 15, 25));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
			Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
			Blockinit.gem_vein.getDefaultState(), 4)).withPlacement(customConfig));			
		}
	}
}
