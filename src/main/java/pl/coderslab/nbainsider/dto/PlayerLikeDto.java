package pl.coderslab.nbainsider.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerLikeDto {
    private int counter;
    private Long id;
    private String firstName;
    private String lastName;
}
