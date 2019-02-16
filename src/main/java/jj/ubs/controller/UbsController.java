package jj.ubs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jj.ubs.domain.UbsService;
import jj.ubs.domain.infra.Record;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/ubs")
@AllArgsConstructor
public class UbsController {

    private UbsService ubsService;

    @GetMapping
    public String getNearestUbs(Model model) {//, @RequestParam String city, @RequestParam String lattitude, @RequestParam String longitude) {
        //        Record ubs = new Record();
        //        ubs.setCodMunic("421770");
        //        ubs.setDscCidade("Sombrio");
        //        ubs.setDscEndereco("RUA ANICETO SILVEIRA");
        //        ubs.setVlrLatitude("-29.1107439994804");
        //        ubs.setVlrLongitude("-49.6437835693345");
        //        model.addAttribute("ubs", ubs);
        Record record = ubsService.getNearestUbs("São José dos Campos", -23.2365917, 45.9234772);
        model.addAttribute("ubs", record);
        return "index";
    }

}
