package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "result_prediction")
@Getter
@Setter
@NoArgsConstructor
public class ResultPrediction extends IdExtender{
    @Enumerated(EnumType.STRING)
    private EnumResult result;

}
