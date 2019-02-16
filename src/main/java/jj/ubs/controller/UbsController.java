package jj.ubs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import jj.ubs.domain.UbsService;
import jj.ubs.domain.infra.Record;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UbsController {

    private final UbsService ubsService;

    private final LocateFormValidator locateFormValidator;

    @InitBinder("locateForm")
    protected void formInitBinder(final WebDataBinder binder) {
        binder.addValidators(locateFormValidator);
    }

    @GetMapping("/")
    public String index() {
        return "localizar";
    }

    @PostMapping("/localizar")
    public String locate(@Valid final LocateForm locateForm, final BindingResult result, final Model model) {
        if (result.hasErrors()) {
            fillModelWithErrors(model, result);
            return "localizar";
        }

        final List<Record> records = new ArrayList<>();
        if (!locateForm.isOnlyCity()) {
            final List<Record> record = ubsService.getNearestUbs(locateForm.getCity(), locateForm.getLatitudeAsDouble(),
                    locateForm.getLongitudeAsDouble(), 3);
            records.addAll(record);
        } else {
            final List<Record> list = ubsService.getUbsByCity(locateForm.getCity());
            records.addAll(list);
        }

        model.addAttribute("records", records);
        return "localizar";
    }

    private void fillModelWithErrors(final Model model, final BindingResult result) {
        final List<String> errorList = new ArrayList<>();
        for (final FieldError error : result.getFieldErrors()) {
            errorList.add(error.getDefaultMessage());
        }
        model.addAttribute("errorList", errorList);
    }

}
