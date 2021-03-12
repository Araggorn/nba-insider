package pl.coderslab.nbainsider.client.dto;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {
    private List<T> data;
    private Meta meta;
}
