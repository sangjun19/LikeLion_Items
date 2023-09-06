package org.likelion.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.likelion.item.domain.item.Item;
import org.likelion.item.domain.item.ItemRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


public class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() { itemRepository.clearStore(); }

    @Test
    void save() {
        Item item = new Item("itemA", 10000, 10, "안상준");

        Item savedItem = itemRepository.save(item);

        Item findItem = itemRepository.findById(item.getId());
        Assertions.assertEquals(findItem, savedItem);
    }

    @Test
    void findAll() {
        Item item1 = new Item("item1", 10000, 10, "안상준");
        Item item2 = new Item("item2", 20000, 20, "안상준");

        itemRepository.save(item1);
        itemRepository.save(item2);

        List<Item> result = itemRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(item1, item2);
    }

    @Test
    void updateItem() {
        Item item = new Item("item1", 10000, 10, "안상준");
        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();

        Item updateParam = new Item("item2", 20000 ,30, "안상준");
        itemRepository.update(itemId, updateParam);
        Item findItem = itemRepository.findById(itemId);

        assertThat(findItem.getItemName()).isEqualTo(savedItem.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(savedItem.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(savedItem.getQuantity());
    }
}