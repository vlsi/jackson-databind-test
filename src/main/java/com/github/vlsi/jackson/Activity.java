package com.github.vlsi.jackson;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Created by sitnikov on 20/11/13.
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class Activity {
    public int priority;
    @JsonManagedReference
    public Employee assignedEmployee;
}
