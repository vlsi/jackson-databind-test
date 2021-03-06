package com.github.vlsi.jackson;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.math.BigInteger;

/**
 * Created by sitnikov on 20/11/13.
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class Task {
    public String GPCode;
    @JsonManagedReference
    public Process process;
    @JsonManagedReference
    public Activity activity;
    @JsonManagedReference
    public Employee assignedTo;
    public BigInteger objectTypeId;
}
