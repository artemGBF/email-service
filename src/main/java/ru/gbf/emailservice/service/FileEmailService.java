package ru.gbf.emailservice.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import ru.gbf.emailservice.emaildata.EmailData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
@AllArgsConstructor
public class FileEmailService {

    private final Configuration configuration;

    public void send(EmailData data){
        try {
            Template template = configuration.getTemplate(data.getTemplateName());
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, Map.of("data", data));
            String filename = data.getTo()+"-"+data.getTheme()+"-"+
                    DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SSS").format(LocalDateTime.now())+".html";
            Path destination = Paths.get("./emails/"+filename);
            Files.write(destination, html.getBytes());

        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

}
