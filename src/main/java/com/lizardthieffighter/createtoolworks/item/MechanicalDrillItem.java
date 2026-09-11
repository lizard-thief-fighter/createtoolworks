package com.lizardthieffighter.createtoolworks.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

/** First concrete pneumatic tool used to validate the MechanicalToolItem foundation. */
public class MechanicalDrillItem extends MechanicalToolItem {
    private static final int USES_PER_TANK = 64;

    public MechanicalDrillItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    protected int maxUses() {
        return USES_PER_TANK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        HitResult hit = Item.getPlayerPOVHitResult(level, player, ClipContext.Fluid.NONE);

        if (!(hit instanceof BlockHitResult blockHit) || hit.getType() != HitResult.Type.BLOCK) {
            return InteractionResultHolder.pass(stack);
        }

        BlockPos pos = blockHit.getBlockPos();
        BlockState state = level.getBlockState(pos);
        if (state.isAir() || state.getDestroySpeed(level, pos) < 0) {
            return InteractionResultHolder.pass(stack);
        }

        if (level.isClientSide) {
            return InteractionResultHolder.success(stack);
        }

        if (!level.destroyBlock(pos, true, player)) {
            return InteractionResultHolder.pass(stack);
        }

        consumeUse(player, stack);
        return InteractionResultHolder.success(stack);
    }
}
