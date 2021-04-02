package pl.coderslab.nbainsider.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TeamLikeDto {
    private int counter;
    private Long id;
    private String team;
}
