package org.bstick12.impl;

import org.bstick12.api.SurveillanceService;
import org.bstick12.api.Suspect;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SurveillanceServiceImpl implements SurveillanceService {

    private Map<String, Suspect> suspects = new ConcurrentHashMap<>();

    @Override
    public String surveil(Suspect suspect) {
        String suspectUUID = UUID.randomUUID().toString();
        suspects.put(suspectUUID, suspect);
        return suspectUUID;
    }

    @Override
    public Map<String, Suspect> suspects() {
        return new HashMap<>(suspects);
    }

    @Override
    public Suspect closeCase(String suspectId) {
        return suspects.remove(suspectId);
    }

    @Override
    public Suspect evidence(String suspectId) {
        return suspects.get(suspectId);
    }

}
