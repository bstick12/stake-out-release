package org.bstick12.api;

import feign.Param;
import feign.RequestLine;

import java.util.Map;

public interface SurveillanceService {

    @RequestLine("POST /v1/surveillances")
    String surveil(Suspect suspect);

    @RequestLine("GET /v1/surveillances")
    Map<String, Suspect> suspects();

    @RequestLine("DELETE /v1/surveillances/{suspectId}")
    Suspect closeCase(@Param("suspectId") String suspectId);

    @RequestLine("GET /v1/surveillances/{suspectId}")
    Suspect evidence(@Param("suspectId") String suspectId);

}
