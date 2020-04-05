package com.moosymantheboss.newmod.init;

import com.moosymantheboss.newmod.NewMod;
import com.moosymantheboss.newmod.world.biomes.ExampleBiome;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Builder;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, NewMod.MOD_ID);

	public static final RegistryObject<Biome> EXAMPLE_BIOME = BIOMES.register("example_biome",
			() -> new ExampleBiome(new Biome.Builder().precipitation(RainType.SNOW).scale(1.2f).temperature(0.5f)
					.waterColor(0x8ed7da).waterFogColor(16762304)
					.surfaceBuilder(SurfaceBuilder.GIANT_TREE_TAIGA,
							new SurfaceBuilderConfig(Blocks.DIRT.getDefaultState(),
									Blocks.STONE.getDefaultState(), Blocks.CLAY.getDefaultState()))
					.category(Category.PLAINS).downfall(0.5f).depth(0.11f).parent(null)));

	public static void registerBiomes() {
		registerBiome(EXAMPLE_BIOME.get(), Type.PLAINS, Type.LUSH, Type.OVERWORLD);
	}
	
	private static void registerBiome(Biome biome, Type... types) {
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}
}
