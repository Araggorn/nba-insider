package pl.coderslab.nbainsider.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserItemDto {

    private Long id;
    private String login;
    private String email;
    private String team;
    private String player;
}
