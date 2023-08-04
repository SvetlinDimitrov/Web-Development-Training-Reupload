package com.example.pathfinder.domain.bindingViews;


import com.example.pathfinder.domain.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewMessages {
    private Long id;
    private LocalDate dateTime;
    private String textContent;

    public ViewMessages(Message message){
        this.id = message.getId();
        this.dateTime = message.getDateTime();
        this.textContent = message.getTextContent();
    }
}
