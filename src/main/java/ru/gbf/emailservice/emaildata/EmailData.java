package ru.gbf.emailservice.emaildata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class EmailData {
    String to;
    String theme;

    public abstract String getTemplateName();
}
