package concussion909.apv;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import concussion909.apv.APVItemGroup;
import concussion909.apv.blocks.BlockLogAPV;
import concussion909.apv.entity.monster.EntitySoldierBugfin;
import concussion909.apv.entity.render.RenderSoldierBugfin;
//import concussion909.apv.init.MobRegistry;
import concussion909.apv.items.ItemCustomAxe;
import concussion909.apv.items.ItemCustomPickaxe;
import concussion909.apv.lists.ArmourMaterialList;
import concussion909.apv.lists.BlockList;
import concussion909.apv.lists.ItemList;
import concussion909.apv.lists.ToolMaterialList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("antiplantvirus")
public class AntiPlantVirus 
{
	public static AntiPlantVirus instance;
	public static final String modid = "antiplantvirus";
	private static final Logger Logger = LogManager.getLogger(modid);
	
	public static final ItemGroup apv = new APVItemGroup();
	
	public AntiPlantVirus()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		//ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigurationHandler.spec);
		
		//FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
		
		MinecraftForge.EVENT_BUS.register(this);
		
		
	//}
	
	// public void onClientSetup(FMLClientSetupEvent event) 
	// {
	//	//RenderingRegistry.registerEntityRenderingHandler(EntitySoldierBugfin.class, (RenderManager manager) -> new RenderSoldierBugfin(manager));
		//RenderingRegistry.registerEntityRenderingHandler(EntitySoldierBugfin.class, RenderSoldierBugfin::new);
	
	   // Logger.info("onClientSetup registered."); 
	 }
	
	private void setup(final FMLCommonSetupEvent event)
	{
		// add later - MobRegistry.addSpawn();
		
		Logger.info("Setup method registered.");
	}
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		//RenderingRegistry.registerEntityRenderingHandler(EntitySoldierBugfin.class, (RenderManager renderManager) -> new RenderSoldierBugfin(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntitySoldierBugfin.class, RenderSoldierBugfin::new);
		Logger.info("clientRegistries registered.");
	}
	
	// File Registry separation to item
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
				ItemList.apv_vseed = new Item(new Item.Properties().group(apv)).setRegistryName(location("apv_vseed")),
				
				ItemList.apv_axe = new ItemCustomAxe(ToolMaterialList.apv, -1.0f, 6.0f, new Item.Properties().group(apv)).setRegistryName(location("apv_axe")),
				ItemList.apv_hoe = new ItemHoe(ToolMaterialList.apv, 6.0f, new Item.Properties().group(apv)).setRegistryName(location("apv_hoe")),
				ItemList.apv_pickaxe = new ItemCustomPickaxe(ToolMaterialList.apv, -2, 6.0f, new Item.Properties().group(apv)).setRegistryName(location("apv_pickaxe")),
				ItemList.apv_shovel = new ItemSpade(ToolMaterialList.apv, -3.0f, 6.0f, new Item.Properties().group(apv)).setRegistryName(location("apv_shovel")),
				ItemList.apv_sword = new ItemSword(ToolMaterialList.apv, 0, 6.0f, new Item.Properties().group(apv)).setRegistryName(location("apv_sword")),
				
				ItemList.apv_helmet = new ItemArmor(ArmourMaterialList.apv, EntityEquipmentSlot.HEAD, new Item.Properties().group(apv)).setRegistryName(location("apv_helmet")),
				ItemList.apv_chestplate = new ItemArmor(ArmourMaterialList.apv, EntityEquipmentSlot.CHEST, new Item.Properties().group(apv)).setRegistryName(location("apv_chestplate")),
				ItemList.apv_leggings = new ItemArmor(ArmourMaterialList.apv, EntityEquipmentSlot.LEGS, new Item.Properties().group(apv)).setRegistryName(location("apv_leggings")),
				ItemList.apv_boots = new ItemArmor(ArmourMaterialList.apv, EntityEquipmentSlot.FEET, new Item.Properties().group(apv)).setRegistryName(location("apv_boots")),
				
				ItemList.apv_plaguestonecobble = new ItemBlock(BlockList.apv_plaguestonecobble, new Item.Properties().group(apv)).setRegistryName(BlockList.apv_plaguestonecobble.getRegistryName()),
				ItemList.apv_virallog = new ItemBlock(BlockList.apv_virallog, new Item.Properties().group(apv)).setRegistryName(BlockList.apv_virallog.getRegistryName()),
				ItemList.apv_ore = new ItemBlock(BlockList.apv_ore, new Item.Properties().group(apv)).setRegistryName(BlockList.apv_ore.getRegistryName()),
				ItemList.apv_ore_nether = new ItemBlock(BlockList.apv_ore_nether, new Item.Properties().group(apv)).setRegistryName(BlockList.apv_ore_nether.getRegistryName()),
				ItemList.apv_ore_end = new ItemBlock(BlockList.apv_ore_end, new Item.Properties().group(apv)).setRegistryName(BlockList.apv_ore_end.getRegistryName())

			);
			
			Logger.info("Items registered.");
		}
		
		//Block Registry
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
				BlockList.apv_virallog = new BlockLogAPV(MaterialColor.BROWN_TERRACOTTA, Block.Properties.create(Material.WOOD).hardnessAndResistance(6.0f, 3.0f).lightValue(0).sound(SoundType.WOOD)).setRegistryName(location("apv_virallog")),
				BlockList.apv_plaguestonecobble = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(5).sound(SoundType.STONE)).setRegistryName(location("apv_plaguestonecobble")),
				BlockList.apv_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.METAL)).setRegistryName(location("apv_ore")),
				BlockList.apv_ore_nether = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.METAL)).setRegistryName(location("apv_ore_nether")),
				BlockList.apv_ore_end = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.METAL)).setRegistryName(location("apv_ore_end"))
			);
			
			Logger.info("Blocks registered.");
		}
	}
	
	//public static final ResourceLocation LOOT_ENTITIES_PENGUIN_FISH = LootTableList.register(new ResourceLocation(AntiPlantVirus.modid, "entities/SoldierBugfin"));
	
	private static ResourceLocation location(String name)
	{
		return new ResourceLocation(modid, name);
	}
		
		//Mob Registry
	
	//	@ObjectHolder(AntiPlantVirus.modid) @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD, modid=AntiPlantVirus.modid)
	//	public class ModET {
	//		public static final EntityType<EntitySoldierBugfin> ENTITY = register("Soldier Bug", EntitySoldierBugfin.class, EntitySoldierBugfin::new);

	//		private static <T extends Entity> EntityType<T> register(String name, Class<T> entityClass, Function<? super World, ? extends T> factory) {
	//				return EntityType.register(AntiPlantVirus.modid + ":entity_soldier_bugfin" + name, EntityType.Builder.create(entityClass, factory));
	//		}
	//	}
	

		//@SubscribeEvent
		//public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> event) {
		//     event.getRegistry().register(
		//     EntityType.Builder.create(EntitySoldierBugfin.class, EntitySoldierBugfin::new)
		//                  .build(AntiPlantVirus.modid + ":entity_soldier_bugfin").setRegistryName(AntiPlantVirus.modid, "entity_soldier_bugfin")
		//            );}

		       
		@SubscribeEvent
		public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
		{
		   // EntityInit.register(event.getRegistry());
		    
		
	}	
}

	