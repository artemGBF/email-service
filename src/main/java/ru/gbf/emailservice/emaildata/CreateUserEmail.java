package ru.gbf.emailservice.emaildata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gbf.emailservice.emaildata.EmailData;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserEmail extends EmailData {
    private String login;
    private String password;

    @Override
    public String getTemplateName() {
        return "create-user.ftl";
    }

    public CreateUserEmail(String to, String theme, String login, String password) {
        super(to, theme);
        this.login = login;
        this.password = password;
    }
}