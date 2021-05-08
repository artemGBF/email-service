package ru.gbf.emailservice.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gbf.emailservice.json.CreateOrderEmailDTODeserializer;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(using = CreateOrderEmailDTODeserializer.class)
public class CreateOrderEmailDto extends EmailDto {
    private String number;
    private String delivery;
    private Long idCart;

    private Map<GoodDTO, Integer> goods;

    public CreateOrderEmailDto(String to, String number, String delivery, Long idCart, Map<GoodDTO, Integer> goods) {
        super(to);
        this.number = number;
        this.delivery = delivery;
        this.idCart = idCart;
        this.goods = goods;
    }
}