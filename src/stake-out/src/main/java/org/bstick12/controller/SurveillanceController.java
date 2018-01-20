package org.bstick12.controller;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping(value = SurveillanceController.SURVEILLANCE_API)
public class SurveillanceController {

    public static final String SURVEILLANCE_API = "/v1/surveillances";

    public HashSet<String> suspects = new HashSet<>();

    @PostMapping
    public String surveillance(String suspect) {
        suspects.add(suspect);
        return suspect;
    }

    @GetMapping
    public List<String> suspects() {
        return Lists.newArrayList(suspects);
    }

    @DeleteMapping(value = "/{suspect}")
    public void closeCase(@PathVariable("suspect") String suspect) {
        suspects.remove(suspect);
    }

    @GetMapping(value = "/{suspect}")
    public boolean evidence(@PathVariable("suspect") String suspect) {
        return suspects.contains(suspect);
    }


}
