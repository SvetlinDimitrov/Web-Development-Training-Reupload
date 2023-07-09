package org.example;

import org.example.styles.Style;

public class Fighter {
    private Style style;
    private final String name;

    public Fighter(String name) {
        this.name = name;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Style getStyle() {
        return style;
    }

    public String getName() {
        return name;
    }

    public void fight(){
        if(style == null){
            System.out.println("I dont know any martial arts");
            return;
        }
        style.fight();
    }
}
