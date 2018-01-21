package org.bstick12.impl;

import org.bstick12.api.Suspect;

import java.util.Objects;

public class SuspectVO implements Suspect {

    private String name;

    private String type;

    private String host;

    public SuspectVO() {

    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public static final Suspect create(String name, String type, String host) {
        SuspectVO suspect = new SuspectVO();
        suspect.setName(name);
        suspect.setType(type);
        suspect.setHost(host);
        return suspect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuspectVO suspectVO = (SuspectVO) o;
        return Objects.equals(name, suspectVO.name) &&
                Objects.equals(type, suspectVO.type) &&
                Objects.equals(host, suspectVO.host);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, type, host);
    }
}
