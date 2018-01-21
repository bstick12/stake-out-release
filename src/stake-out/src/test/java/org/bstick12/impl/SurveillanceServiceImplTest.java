package org.bstick12.impl;

import org.assertj.core.api.Assertions;
import org.bstick12.api.SurveillanceService;
import org.bstick12.api.Suspect;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SurveillanceServiceImplTest {

    private SurveillanceService surveillanceService;

    @Before
    public void before() {
        surveillanceService = new SurveillanceServiceImpl();
    }

    @Test
    public void testSurveil() {
        Suspect one = createSuspect("one");
        String oneId = surveillanceService.surveil(one);
        assertNotNull(oneId);
        assertEquals(one, surveillanceService.evidence(oneId));
    }

    @Test
    public void testSuspects() {
        Assertions.assertThat(surveillanceService.suspects()).hasSize(0);
        Suspect one = createSuspect("one");
        Suspect two = createSuspect("two");
        String oneId = surveillanceService.surveil(one);
        String twoId = surveillanceService.surveil(two);
        Assertions.assertThat(surveillanceService.suspects()).hasSize(2).containsOnlyKeys(oneId, twoId).containsValues(one, two);
    }

    @Test
    public void testCloseCase() {

        Assertions.assertThat(surveillanceService.suspects()).hasSize(0);
        Suspect one = createSuspect("one");
        Suspect two = createSuspect("two");
        String oneId = surveillanceService.surveil(one);
        String twoId = surveillanceService.surveil(two);
        Assertions.assertThat(surveillanceService.suspects()).hasSize(2).containsOnlyKeys(oneId, twoId).containsValues(one, two);
        surveillanceService.closeCase(oneId);
        Assertions.assertThat(surveillanceService.suspects()).hasSize(1).containsOnlyKeys(twoId).containsValues(two);

    }

    public Suspect createSuspect(String name) {
        return SuspectVO.create(name, "http", "www.example.com");
    }

}