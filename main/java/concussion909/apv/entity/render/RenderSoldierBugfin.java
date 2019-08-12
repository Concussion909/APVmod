package concussion909.apv.entity.render;

import concussion909.apv.mob.SoldierBugModel;

import javax.annotation.Nonnull;

import concussion909.apv.AntiPlantVirus;
import concussion909.apv.entity.monster.EntitySoldierBugfin;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;



public class RenderSoldierBugfin extends RenderLiving<EntitySoldierBugfin>
{
    private static final ResourceLocation Soldier_Bugfin_TEXTURE = new ResourceLocation(AntiPlantVirus.modid + ":textures/entity/soldierbugfin.png");

    public RenderSoldierBugfin(RenderManager manager)
    {
        super(manager, new SoldierBugModel(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySoldierBugfin par1Entity)
    {
        return RenderSoldierBugfin.Soldier_Bugfin_TEXTURE;
       }
}


//@OnlyIn(Dist.CLIENT)
//public class RenderSoldierBugfin extends RenderLiving<EntitySoldierBugfin>
//{

//    public RenderSoldierBugfin(RenderManager renderManager) {
//        super(renderManager, new SoldierBugModel(), 0.5F);
//    }

//   @Override
//   @Nonnull
//    protected ResourceLocation getEntityTexture(@Nonnull EntitySoldierBugfin soldierbug) {
//        String name = soldierbug.getName().getString().toLowerCase().trim();
//        if (name.equals("soldierbugfin") || name.equals("soldierbugfin")) {
//            return this.getSoldierBugTexture("soldierbugfin");
//        } else if (name.equals("soldierbugfin")) {
//            return this.getSoldierBugTexture("soldierbugfin");
//        }
//       return soldierbug.isChild() ? this.getSoldierBugTexture("soldierbugfin") : this.getSoldierBugTexture("soldierbugfin");
//    }

//    private ResourceLocation getSoldierBugTexture(String fileName ) {
//        return new ResourceLocation(AntiPlantVirus.modid, "textures/entity/" + fileName  + ".png");
//    }
//}