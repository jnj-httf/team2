package jj.ubs.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocateForm {

    private String city;

    private String latitude;

    private String longitude;

    Double getLatitudeAsDouble() {
        return Double.valueOf(latitude);
    }

    Double getLongitudeAsDouble() {
        return Double.valueOf(longitude);
    }

}
