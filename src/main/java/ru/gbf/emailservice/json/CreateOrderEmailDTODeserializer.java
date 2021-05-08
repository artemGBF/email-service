package ru.gbf.emailservice.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import ru.gbf.emailservice.dto.CreateOrderEmailDto;
import ru.gbf.emailservice.dto.GoodDTO;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateOrderEmailDTODeserializer extends JsonDeserializer<CreateOrderEmailDto> {

    @Override
    public CreateOrderEmailDto deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec oc = p.getCodec();
        JsonNode node = oc.readTree(p);

        Map<GoodDTO, Integer> map = new HashMap<>();

        String to = node.get("to").asText();
        String number = node.get("number").asText();
        String delivery = node.get("delivery").asText();
        long idCart = node.get("idCart").asLong();

        JsonNode goods = node.get("goods");
        int i = 0;
        while (goods.has(i)) {
            JsonNode good = goods.get(i).get("good");

            long id = good.get("id").asInt();
            String name = good.get("name").asText();
            int price = good.get("price").asInt();
            long category = good.get("category").asLong();
            map.put(
                    new GoodDTO(id, name, price, category),
                    goods.get(i).get("count").asInt()
            );
            i++;
        }

        return new CreateOrderEmailDto(
                to,
                number,
                delivery,
                idCart,
                map
        );

    }
}
