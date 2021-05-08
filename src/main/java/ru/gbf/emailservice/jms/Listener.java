package ru.gbf.emailservice.jms;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import ru.gbf.emailservice.dto.EmailDto;
import ru.gbf.emailservice.service.FileEmailService;
import ru.gbf.emailservice.service.MapperService;

import java.net.URISyntaxException;

@Component
@RequiredArgsConstructor
public class Listener {

    private final FileEmailService emailService;
    private final MapperService mapperService;

    @JmsListener(destination = "${destination.queue}")
    public void receive(EmailDto email) throws URISyntaxException {
        System.out.println("jsonEmail = " + email.getTo());
        emailService.send(mapperService.toData(email));
    }

}
