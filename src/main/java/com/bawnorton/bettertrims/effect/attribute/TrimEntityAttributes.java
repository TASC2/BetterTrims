package com.bawnorton.bettertrims.effect.attribute;

import com.bawnorton.bettertrims.BetterTrims;
import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class TrimEntityAttributes {
    private static final Set<RegistryEntry<EntityAttribute>> ENTITY_ATTRIBUTES = new HashSet<>();

    public static final RegistryEntry<EntityAttribute> BREWERS_DREAM = registerAttribute("brewers_dream");
    public static final RegistryEntry<EntityAttribute> ELECTRIFYING = registerAttribute("electrifying", true);
    public static final RegistryEntry<EntityAttribute> MINERS_RUSH = registerAttribute("miners_rush");
    public static final RegistryEntry<EntityAttribute> FORTUNE = registerAttribute("fortune");
    public static final RegistryEntry<EntityAttribute> TRADE_DISCOUNT = registerAttribute("trade_discount", 1, 1, 100);
    public static final RegistryEntry<EntityAttribute> SUNS_BLESSING = registerAttribute("suns_blessing", true);
    public static final RegistryEntry<EntityAttribute> ITEM_MAGNET = registerAttribute("item_magnet");
    public static final RegistryEntry<EntityAttribute> ENCHANTERS_BLESSING = registerAttribute("enchanters_blessing");
    public static final RegistryEntry<EntityAttribute> FIREPROOF = registerAttribute("fireproof");
    public static final RegistryEntry<EntityAttribute> RESISTANCE = registerAttribute("resistance", 1, 1, 100);
    public static final RegistryEntry<EntityAttribute> BONUS_XP = registerAttribute("bonus_xp", 1, 1, 2048);

    private static RegistryEntry<EntityAttribute> registerAttribute(String id) {
        return registerAttribute(id, 0, 0, 4);
    }

    private static RegistryEntry<EntityAttribute> registerAttribute(String id, boolean tracked) {
        return registerAttribute(id, 0, 0, 4, tracked);
    }

    private static RegistryEntry<EntityAttribute> registerAttribute(String id, double fallback, double min, double max) {
        return registerAttribute(id, fallback, min, max, false);
    }

    private static RegistryEntry<EntityAttribute> registerAttribute(String id, double fallback, double min, double max, boolean tracked) {
        return registerAttribute(id, fallback, min, max, tracked, EntityAttribute.Category.POSITIVE);
    }

    private static RegistryEntry<EntityAttribute> registerAttribute(String id, double fallback, double min, double max, boolean tracked, EntityAttribute.Category category) {
        RegistryEntry<EntityAttribute> ref = Registry.registerReference(
                Registries.ATTRIBUTE,
                BetterTrims.id(id),
                new ClampedEntityAttribute(
                        "bettertrims.attribute.name.%s".formatted(id),
                        fallback,
                        min,
                        max
                ).setTracked(tracked).setCategory(category)
        );
        ENTITY_ATTRIBUTES.add(ref);
        return ref;
    }

    public static void init() {
        //no-op
    }

    public static void forEachAttribute(Consumer<RegistryEntry<EntityAttribute>> consumer) {
        ENTITY_ATTRIBUTES.forEach(consumer);
    }
}
