package org.elsys.P.trip;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Trip implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
}
