package com.reasonable.calendar.domain.photo;

import lombok.Getter;

public enum RekognitionEmotionField {
    BOX_LEFT("boundLeft"),
    BOX_TOP("boundTop"),
    BOX_WIDTH("boundWidth"),
    BOX_HEIGHT("boundHeight"),
    CALM("calm"),
    SAD("sad"),
    ANGRY("angry"),
    HAPPY("happy"),
    CONFUSED("confused"),
    SURPRISED("surprised"),
    DISGUSTED("disgusted"),
    FEAR("fear")
    ;

    RekognitionEmotionField(String column) {
        this.column = column;
    }

    @Getter
    private String column;

}
