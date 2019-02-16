package jj.ubs.controller;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LocateFormValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return LocateForm.class.equals(clazz);
    }

    @Override
    public void validate(final Object object, final Errors errors) {
        final LocateForm form = (LocateForm) object;

        validateCity(form.getCity(), errors);
        validateLatitude(form.getLatitude(), errors);
        validateLongitude(form.getLongitude(), errors);
    }

    private void validateCity(final String city, final Errors errors) {
        if (StringUtils.isEmpty(city)) {
            errors.rejectValue("city", null, "O nome da cidade não pode estar vazio.");
        }
    }

    private void validateLatitude(final String latitude, final Errors errors) {
        if (StringUtils.isEmpty(latitude)) {
            return;
        }

        boolean invalid = false;

        try {
            final Double number = Double.parseDouble(latitude);
            invalid = number > 90 || number < -90;
        } catch (final NumberFormatException e) {
            invalid = true;
        }
        if (invalid) {
            errors.rejectValue("latitude", null, "Latitude inválida.");
        }
    }

    private void validateLongitude(final String longitude, final Errors errors) {
        if (StringUtils.isEmpty(longitude)) {
            return;
        }

        boolean invalid = false;

        try {
            final Double number = Double.parseDouble(longitude);
            invalid = number > 180 || number < -180;
        } catch (final NumberFormatException e) {
            invalid = true;
        }
        if (invalid) {
            errors.rejectValue("longitude", null, "Longitude inválida.");
        }
    }
}
