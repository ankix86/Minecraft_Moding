package com.dexter_mode.tabs;

import com.dexter_mode.item.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;


public class customTab extends ItemGroup  {

	public customTab(int index, String label) {
		super(12,label);
	}
	@Override
	public ItemStack createIcon() {
		// TODO Auto-generated method stub
		return new ItemStack(ItemList.redChillie);
	}
}
