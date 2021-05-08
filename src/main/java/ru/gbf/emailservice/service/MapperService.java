package ru.gbf.emailservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gbf.emailservice.dto.CreateOrderEmailDto;
import ru.gbf.emailservice.dto.EmailDto;
import ru.gbf.emailservice.dto.GoodDTO;
import ru.gbf.emailservice.emaildata.CreateOrder;
import ru.gbf.emailservice.emaildata.EmailData;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MapperService {

    private final RestTemplate restTemplate = new RestTemplate();

    public EmailData toData(EmailDto dto) throws URISyntaxException {
        if (dto instanceof CreateOrderEmailDto) {
            return mapper((CreateOrderEmailDto) dto);
        }
        return null;
    }

    private CreateOrder mapper(CreateOrderEmailDto dto) throws URISyntaxException {
        Map<GoodDTO, Integer> goods = dto.getGoods();
        List<CreateOrder.Item> items = new ArrayList<>();
        for (Map.Entry<GoodDTO, Integer> entry : goods.entrySet()) {
            GoodDTO key = entry.getKey();
            Integer value = entry.getValue();
            items.add(new CreateOrder.Item(key.getName(), key.getPrice(), value));
        }
        return new CreateOrder(
                dto.getTo(),
                null,
                dto.getNumber(),
                dto.getDelivery(),
                items
        );
    }
}
