package ru.gbf.emailservice.emaildata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrder extends EmailData {
    private String number;
    private String delivery;

    private List<Item> items;

    private Integer total;

    public CreateOrder(String to, String theme, String number, String delivery, List<Item> items) {
        super(to, theme);
        this.number = number;
        this.delivery = delivery;
        this.items = items;

        this.total = 0;
        for (Item item : items) {
            this.total += item.count * item.price;
        }
    }

    @Override
    public String getTemplateName() {
        return "create-order.ftl";
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        private String name;
        private Integer price;
        private Integer count;
    }
}
