package pl.coderslab.nbainsider.client.dto;

import lombok.Data;

@Data
public class Meta {
    int total_pages;
    int current_page;
    Integer next_page;
    int per_page;
    int total_count;
}
