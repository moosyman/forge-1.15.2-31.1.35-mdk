package com.moosymantheboss.newmod.world.biomes;

import com.google.common.collect.ImmutableList;
import com.moosymantheboss.newmod.world.feature.ExampleTree;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class ExampleBiome extends Biome {

	public ExampleBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715F)));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.02F)));
		DefaultBiomeFeatures.addOceanCarvers(this);
		this.addCarver(GenerationStage.Carving.LIQUID,
				Biome.createCarver(WorldCarver.UNDERWATER_CANYON, new ProbabilityConfig(0.04F)));
		this.addCarver(GenerationStage.Carving.LIQUID,
				Biome.createCarver(WorldCarver.UNDERWATER_CAVE, new ProbabilityConfig(0.1634F)));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.BAMBOO.withConfiguration(new ProbabilityConfig(0.0F))
						.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(16))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG)
						.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(20))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.DEFAULT_FLOWER_CONFIG)
						.withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addExtraEmeraldOre(this);
		DefaultBiomeFeatures.addStoneVariants(this);
		DefaultBiomeFeatures.addSedimentDisks(this);
		DefaultBiomeFeatures.addBerryBushes(this);
		DefaultBiomeFeatures.addExtraReedsAndPumpkins(this);
		DefaultBiomeFeatures.func_222340_ak(this);
		DefaultBiomeFeatures.addKelp(this);
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.NORMAL_TREE.withConfiguration(ExampleTree.EXAMPLE_TREE_CONFIG).withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(8, 0.1f, 1))));
		DefaultBiomeFeatures.addStructures(this);
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 2, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.LLAMA, 15, 2, 7));
		this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.TURTLE, 15, 2, 5));

	}
}
