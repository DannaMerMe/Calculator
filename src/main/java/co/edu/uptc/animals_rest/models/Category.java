package co.edu.uptc.animals_rest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Category {

    private String category;
    private int number;
    private String nameContent;
    private String date;
}
