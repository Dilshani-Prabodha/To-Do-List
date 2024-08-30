package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ToDoList {
    private String addListText;

    public ToDoList(String addListText){
        this.addListText = addListText;
    }
}
