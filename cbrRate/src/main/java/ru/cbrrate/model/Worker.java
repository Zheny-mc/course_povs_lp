package ru.cbrrate.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Builder(toBuilder = true)
@ToString
public class Worker {
    private String name;
    private String birthday;
    private String post; //должность
    private String experienceYear; //стаж
}
