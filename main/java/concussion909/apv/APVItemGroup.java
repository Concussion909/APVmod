package concussion909.apv;

import concussion909.apv.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class APVItemGroup extends ItemGroup
{
	public APVItemGroup() 
	{
		super("apv");
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(ItemList.apv_vseed);
	}
}

