package org.imt.nordeurope.j2ee.nickler.FrontEndIBAN.Service;

import org.imt.nordeurope.j2ee.nickler.FrontEndIBAN.Model.IBANValidation;
import org.springframework.web.bind.annotation.RequestParam;

public interface IIBANService {
    public IBANValidation checkIBAN(@RequestParam String id);
}
