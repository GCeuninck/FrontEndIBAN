package org.imt.nordeurope.j2ee.nickler.FrontEndIBAN.Service;

import org.imt.nordeurope.j2ee.nickler.FrontEndIBAN.Model.IBANValidation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Component
public class IBANService implements IIBANService {

    static final String URL_BACKEND = "http://localhost:9000/";

    @Override
    public IBANValidation checkIBAN(@RequestParam String IBAN) {
        RestTemplate restTemplate = new RestTemplate();
        IBANValidation ibanValidation = restTemplate.getForObject(URL_BACKEND + "checkIBAN?IBAN=" + IBAN , IBANValidation.class);
        return ibanValidation;
    }
}
