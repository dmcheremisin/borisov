package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.ProphetService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BankVerificationController {

    private final ProphetService prophetService;

    @GetMapping("/approveCredit")
    public boolean shouldApproveCredit(@RequestParam("name") String name) {
        return prophetService.willSurvive(name);
    }
}
