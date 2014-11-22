package com.senyume.taskmaster.controller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.senyume.taskmaster.util.CalendarDeserializer;
import com.senyume.taskmaster.util.CalendarSerializer;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Calendar;

/**
 * @author jigish
 */

public class TasksCommand {

    @NotBlank
    private String name;

    @JsonDeserialize(using = CalendarDeserializer.class, as=Calendar.class)
    @JsonSerialize(using = CalendarSerializer.class)
    private Calendar due;

    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDue() {
        return due;
    }

    public void setDue(Calendar due) {
        this.due = due;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
