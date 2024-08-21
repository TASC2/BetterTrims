package com.bawnorton.bettertrims.data;

import com.bawnorton.bettertrims.BetterTrims;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import org.jetbrains.annotations.NotNull;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class TrimMaterialTags implements Iterable<TagKey<Item>> {
    private static final Set<TagKey<Item>> TAGS = new HashSet<>();

    public static final TagKey<Item> AMETHYST = register("amethyst");
    public static final TagKey<Item> COPPER = register("copper");
    public static final TagKey<Item> DIAMOND = register("diamond");
    public static final TagKey<Item> EMERALD = register("emerald");
    public static final TagKey<Item> GOLD = register("gold");
    public static final TagKey<Item> IRON = register("iron");
    public static final TagKey<Item> LAPIS = register("lapis");
    public static final TagKey<Item> NETHERITE = register("netherite");
    public static final TagKey<Item> QUARTZ = register("quartz");
    public static final TagKey<Item> REDSTONE = register("redstone");

    private static TagKey<Item> register(String material) {
        TagKey<Item> tagKey = TagKey.of(RegistryKeys.ITEM, BetterTrims.id("trim_materials/%s".formatted(material)));
        TAGS.add(tagKey);
        return tagKey;
    }

    @NotNull
    @Override
    public Iterator<TagKey<Item>> iterator() {
        return TAGS.iterator();
    }
}
