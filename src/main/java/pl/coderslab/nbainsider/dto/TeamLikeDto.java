package pl.coderslab.nbainsider.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamLikeDto {
    private int counter;
    private Long id;
    private String team;
}