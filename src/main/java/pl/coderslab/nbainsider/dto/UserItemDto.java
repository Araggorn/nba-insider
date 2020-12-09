package pl.coderslab.nbainsider.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserItemDto {

    private Long id;
    private String login;
    @Email
    private String email;
    private String team;
    private String player;
}
