package com.kitchen.www.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationInput {

    private int page;
    private int size;
    private String sortBy;
}
