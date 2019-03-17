package com.dexter_mode.item.food;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.IPlantable;

public class ItemGreenChillie extends ItemFood implements IPlantable {
	 	public final IBlockState state;
	   public ItemGreenChillie(int healAmountIn, float saturation,Block crop,Item.Properties builder) {
	      super(healAmountIn, saturation, false, builder);
	      state = crop.getDefaultState();
	   }
	   
	   public EnumActionResult onItemUse(ItemUseContext p_195939_1_) {
	      IWorld iworld = p_195939_1_.getWorld();
	      BlockPos blockpos = p_195939_1_.getPos().up();
	      if (p_195939_1_.getFace() == EnumFacing.UP && iworld.isAirBlock(blockpos) && this.state.isValidPosition(iworld, blockpos) && iworld.getBlockState(p_195939_1_.getPos()).canSustainPlant(iworld, p_195939_1_.getPos(), EnumFacing.UP, this)) {
	          iworld.setBlockState(blockpos,this.state, 11);
	          EntityPlayer entityplayer = p_195939_1_.getPlayer();
	          ItemStack itemstack = p_195939_1_.getItem();
	          if (entityplayer instanceof EntityPlayerMP) {
	             CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)entityplayer, blockpos, itemstack);
	          }

	          itemstack.shrink(1);
	          return EnumActionResult.SUCCESS;
	       } else {
	          return EnumActionResult.PASS;
	       }
	    }

	   @Override
	   public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockReader world, BlockPos pos) {
	      return net.minecraftforge.common.EnumPlantType.Crop;
	   }

	   @Override
	   public IBlockState getPlant(net.minecraft.world.IBlockReader world, BlockPos pos) {
	      return this.state;
	   }
}