package com.github.vlsi.jackson;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;

/**
 * Created by sitnikov on 20/11/13.
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class Process {
    @JsonManagedReference
    public List<Task> tasks;

    @JsonManagedReference
    public List<Activity> activities;
}
