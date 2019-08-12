package concussion909.apv.init;

import concussion909.apv.AntiPlantVirus;

//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.function.Function;

//import javax.naming.Reference;

//import com.mojang.datafixers.types.templates.List;

//import concussion909.apv.AntiPlantVirus;
//import concussion909.apv.entity.monster.EntitySoldierBugfin;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityType;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.world.World;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.registries.IForgeRegistry;
//import net.minecraftforge.registries.ObjectHolder;

//public class EntityInit 


//package com.girafi.waddles.init;

import concussion909.apv.entity.monster.EntitySoldierBugfin;
//import com.girafi.waddles.utils.BiomeDictionaryHelper;
//import com.girafi.waddles.utils.ConfigurationHandler;

import com.google.common.base.CaseFormat;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
//import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemSpawnEgg;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
//import net.minecraft.world.biome.Biome;
//import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

//import java.util.Arrays;
import java.util.List;
//import java.util.Set;
import java.util.function.Function;

@EventBusSubscriber(modid = AntiPlantVirus.modid, bus = EventBusSubscriber.Bus.MOD)

public class EntityInit 
{
    private static List<EntityType> entities = Lists.newArrayList();
    private static List<Item> spawnEggs = Lists.newArrayList();

    public static final EntityType<EntitySoldierBugfin> SOLDIER_BUG = createEntity(EntitySoldierBugfin.class, EntitySoldierBugfin::new, 0x000000, 0xFFFFFF);

    private static EntityType<EntitySoldierBugfin> createEntity(Class<? extends Entity> entityClass, Function<? super World, ? extends Entity> entityInstance, int eggPrimary, int eggSecondary) {
        ResourceLocation location = new ResourceLocation(AntiPlantVirus.modid, classToString(entityClass));
        EntityType entity = EntityType.Builder.create(entityClass, entityInstance).tracker(64, 1, true).build(location.toString());
        entity.setRegistryName(location);
        //EntityInit.biomes = biomes;
        entities.add(entity);
        Item spawnEgg = new ItemSpawnEgg(entity, eggPrimary, eggSecondary, (new Item.Properties()).group(ItemGroup.MISC));
        spawnEgg.setRegistryName(new ResourceLocation(AntiPlantVirus.modid, classToString(entityClass) + "_spawn_egg"));
        spawnEggs.add(spawnEgg);

        return entity;
    }

    private static String classToString(Class<? extends Entity> entityClass) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, entityClass.getSimpleName()).replace("entity_", "");
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerBugfin(RegistryEvent.Register<EntityType<?>> event) {
        for (EntityType entity : entities) {
            Preconditions.checkNotNull(entity.getRegistryName(), "registryName");
            event.getRegistry().register(entity);
        }
    }

    @SubscribeEvent
    public static void registerSpawnEggs(RegistryEvent.Register<Item> event) {
        for (Item spawnEgg : spawnEggs) {
            Preconditions.checkNotNull(spawnEgg.getRegistryName(), "registryName");
            event.getRegistry().register(spawnEgg);
        }
    }
}
    
    
//	    @ObjectHolder(AntiPlantVirus.modid + ":entity_soldier_bugfin")
//		private static final EntityType<EntitySoldierBugfin> ENTITY_SOLDIER_BUGFIN;
///		
//		static
//		{ 
//			
//			ENTITY_SOLDIER_BUGFIN = createEntityType("entity_soldier_bugfin", EntitySoldierBugfin.class, EntitySoldierBugfin::new, 64, 1, false);
//		}??

//		private static <?T extends Entity> EntityType<T> createEntityType(String id, Class<? extends T> entityClass, Function<? super World, ? extends T> factory, int range, int updateFrequency, boolean sendsVelocityUpdates)
//		{
//			EntityType<T> type = EntityType.Builder.create(entityClass, factory).tracker(range, updateFrequency, sendsVelocityUpdates).build(AntiPlantVirus.modid + ":" + id);
//			type.setRegistryName(new ResourceLocation(AntiPlantVirus.modid + ":" + id));
//			return type;
//		}
////
//		public static void addEntityTypes()
//		{
//			EntityInit.add(ENTITY_SOLDIER_BUGFIN);
//		}
		
//		public static final List<EntityType<?>> ENTITY_TYPES = new LinkedList<>();
//
//		public static <T extends Entity> void add(EntityType<T> type)
//		{
//			ENTITY_TYPES.add(type);
//		}

//		public static List<EntityType<?>> getEntityTypes()
//		{
//			return Collections.unmodifiableList(ENTITY_TYPES);
//		}
//	}
	
//	@ObjectHolder(AntiPlantVirus.modid) @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD, modid=AntiPlantVirus.modid)
//	public class ModET {
//		public static final EntityType<EntitySoldierBugfin> ENTITY = register("Soldier Bug", EntitySoldierBugfin.class, EntitySoldierBugfin::new);
//
//		private static <T extends Entity> EntityType<T> register(String name, Class<T> entityClass, Function<? super World, ? extends T> factory) {
//				return EntityType.register(AntiPlantVirus.modid + ":entity_soldier_bugfin" + name, EntityType.Builder.create(entityClass, factory));
//		}
//	}
	
	
	
	
	
	
	
	
   // @ObjectHolder(AntiPlantVirus.modid + ":entity_soldier_bugfin")
  //  public static EntityType<EntitySoldierBugfin> ENTITY_SOLDIER_BUGFIN;

  //  public static void register(IForgeRegistry<EntityType<?>> registry) {
   //     registry.register(EntityType.Builder.create(EntitySoldierBugfin.class, EntitySoldierBugfin::new).build(AntiPlantVirus.modid + ":entity_soldier_bugfin").setRegistryName(AntiPlantVirus.modid, "entity_soldier_bugfin"));
  //  }
	//}
    

