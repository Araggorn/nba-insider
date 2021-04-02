package pl.coderslab.nbainsider.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerLikeDto {
    private int counter;
    private Long id;
    private String firstName;
    private String lastName;
}
