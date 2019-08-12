package concussion909.apv.entity.monster;

import concussion909.apv.AntiPlantVirus;
import concussion909.apv.init.EntityInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;

public class EntitySoldierBugfin extends EntityMob
{
//	@ObjectHolder(AntiPlantVirus.modid + ":soldier_bugfin")
	
//	public static EntityType<EntitySoldierBugfin> SOLDIER_BUG;
	
	public EntitySoldierBugfin(World world)
	{
		super(EntityInit.SOLDIER_BUG, world);
	}	

}

