package org.bstick12.controller;

import org.bstick12.api.SurveillanceService;
import org.bstick12.api.Suspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = SurveillanceController.SURVEILLANCE_API)
public class SurveillanceController {

    public static final String SURVEILLANCE_API = "/v1/surveillances";

    @Autowired
    private SurveillanceService surveillanceService;

    @PostMapping
    public String surveil(@RequestBody Suspect suspect) {
        return surveillanceService.surveil(suspect);
    }

    @GetMapping
    public Map<String, Suspect> suspects() {
        return surveillanceService.suspects();
    }

    @DeleteMapping(value = "/{suspect}")
    public Suspect closeCase(@PathVariable("suspect") String suspect) {
        return surveillanceService.closeCase(suspect);
    }

    @GetMapping(value = "/{suspect}")
    public Suspect evidence(@PathVariable("suspect") String suspect) {
        return surveillanceService.evidence(suspect);
    }


}
