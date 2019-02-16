package jj.ubs.controller;

import org.springframework.util.StringUtils;

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

    boolean isOnlyCity() {
        return StringUtils.isEmpty(latitude) && StringUtils.isEmpty(longitude);
    }

}
