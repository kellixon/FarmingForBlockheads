package net.blay09.mods.farmingforblockheads.block;

import net.blay09.mods.farmingforblockheads.FarmingForBlockheads;
import net.blay09.mods.farmingforblockheads.ModConfig;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public abstract class BlockFertilizedFarmland extends BlockFarmland {

	public BlockFertilizedFarmland() {
		setSoundType(SoundType.GROUND);
		setHardness(1f);
		setCreativeTab(FarmingForBlockheads.creativeTab);
	}

	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
		return true;
	}

	@Override
	public boolean isFertile(World world, BlockPos pos) {
		return world.getBlockState(pos).getValue(MOISTURE) > 0;
	}

	public float getDoubleGrowthChance() {
		return 0f;
	}

	public float getBonusCropChance() {
		return 0f;
	}

	public float getRegressionChance() {
		return ModConfig.general.fertilizerRegressionChance;
	}
}
