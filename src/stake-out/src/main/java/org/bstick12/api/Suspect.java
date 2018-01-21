package org.bstick12.api;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.bstick12.impl.SuspectVO;

@JsonDeserialize(as = SuspectVO.class)
public interface Suspect {

    String getName();

    String getType();

    String getHost();

}
