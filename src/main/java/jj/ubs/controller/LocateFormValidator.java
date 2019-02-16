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
            errors.rejectValue("latitude", null, "A latitude não pode estar vazio.");
            return;
        }

        try {
            Double.parseDouble(latitude);
        } catch (final NumberFormatException e) {
            errors.rejectValue("latitude", null, "Latitude inválida.");
        }
    }

    private void validateLongitude(final String longitude, final Errors errors) {
        if (StringUtils.isEmpty(longitude)) {
            errors.rejectValue("longitude", null, "A longitude da cidade não pode estar vazio.");
            return;
        }

        try {
            Double.parseDouble(longitude);
        } catch (final NumberFormatException e) {
            errors.rejectValue("longitude", null, "Longitude inválida.");
        }
    }
}
