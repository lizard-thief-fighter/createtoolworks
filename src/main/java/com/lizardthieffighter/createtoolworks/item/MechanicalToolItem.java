package com.lizardthieffighter.createtoolworks.item;

import com.simibubi.create.content.equipment.armor.BacktankUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * Base class for pneumatic tools which use Create backtank air as their primary energy source.
 * When no pressurized air is available, the tool falls back to normal item durability.
 */
public abstract class MechanicalToolItem extends Item {
    protected MechanicalToolItem(Properties properties) {
        super(properties);
    }

    /** Number of operations a standard, unenchanted Create backtank should support. */
    protected abstract int maxUses();

    /** Pays for one completed mechanical operation. */
    protected final boolean consumeUse(LivingEntity user, ItemStack stack) {
        if (BacktankUtil.canAbsorbDamage(user, maxUses())) {
            return true;
        }

        if (user instanceof Player player) {
            stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
        } else {
            stack.hurtAndBreak(1, user, LivingEntity.getSlotForHand(user.getUsedItemHand()));
        }
        return false;
    }

    @Override
    public final boolean isBarVisible(ItemStack stack) {
        return BacktankUtil.isBarVisible(stack, maxUses());
    }

    @Override
    public final int getBarWidth(ItemStack stack) {
        return BacktankUtil.getBarWidth(stack, maxUses());
    }

    @Override
    public final int getBarColor(ItemStack stack) {
        return BacktankUtil.getBarColor(stack, maxUses());
    }
}
