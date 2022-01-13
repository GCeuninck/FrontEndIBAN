package org.imt.nordeurope.j2ee.nickler.FrontEndIBAN.Controller;

import org.imt.nordeurope.j2ee.nickler.FrontEndIBAN.Model.IBANForm;
import org.imt.nordeurope.j2ee.nickler.FrontEndIBAN.Model.IBANValidation;
import org.imt.nordeurope.j2ee.nickler.FrontEndIBAN.Service.IIBANService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.inject.Inject;

@Controller
public class IBANController {

    @Inject
    IIBANService IBANService;

    @GetMapping(value = { "/" })
    public String index(Model model) {
        IBANForm ibanForm = new IBANForm();
        model.addAttribute("ibanForm", ibanForm);
        return "index";
    }

    @PostMapping(value = "/checkIBAN")
    public String getCountryTemperature(Model model, @ModelAttribute("ibanForm") IBANForm ibanForm) {
        IBANValidation ibanValidation = IBANService.checkIBAN(ibanForm.getIBAN());
        model.addAttribute("iban", ibanValidation);
        return "iban";
    }
}
