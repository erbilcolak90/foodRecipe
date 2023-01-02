package com.kitchen.www.inputs;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class PaginationWithListInput extends PaginationInput{

    private List<String> stringList;

    public PaginationWithListInput(int page, int size, String sortBy, List<String> stringList) {
        super(page, size, sortBy);
        this.stringList = stringList;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
}
