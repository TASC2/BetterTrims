package com.bawnorton.bettertrims.effect;

import com.bawnorton.bettertrims.effect.attribute.TrimAttribute;
import com.bawnorton.bettertrims.registry.content.TrimEntityAttributes;
import com.bawnorton.configurable.Configurable;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import java.util.function.Consumer;

@Configurable("chorus")
public final class ChorusFruitTrimEffect extends TrimEffect {
    @Configurable
    public static boolean enabled = true;
    @Configurable(value = "dodge_chance", min = 0, max = 1)
    public static float dodgeChance = 0.07f;

    public ChorusFruitTrimEffect(TagKey<Item> materials) {
        super(materials);
    }

    @Override
    protected void addAttributes(Consumer<TrimAttribute> adder) {
        adder.accept(TrimAttribute.multiplyBase(TrimEntityAttributes.DODGE_CHANCE, dodgeChance));
    }

    @Override
    protected boolean getEnabled() {
        return enabled;
    }
}
