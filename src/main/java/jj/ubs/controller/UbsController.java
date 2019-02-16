package jj.ubs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jj.ubs.domain.UbsService;
import jj.ubs.domain.infra.Record;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UbsController {

    private final UbsService ubsService;

    @GetMapping("/")
    public String index() {
        return "localizar";
    }

    @PostMapping("/localizar")
    public String getNearestUbs(final Model model, @RequestParam final String city,
            @RequestParam final Double lattitude, @RequestParam final Double longitude) {
        final Record record = ubsService.getNearestUbs(city, lattitude, longitude);
        model.addAttribute("ubs", record);
        return "localizar";
    }

}
