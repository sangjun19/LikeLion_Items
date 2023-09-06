package org.likelion.item.domain.item;

import lombok.Data;
@Data
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;
    private String itemManager;

    public Item() { }
    public Item(String itemName, Integer price, Integer quantity, String itemManager) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.itemManager = itemManager;
    }
}
