package com.github.vlsi.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by sitnikov on 21/11/13.
 */
public class SimpleTest {
    /* Prints the following:
Serialized json is:
[ "com.github.vlsi.jackson.Process", {
  "@id" : "2b37b99c-6852-4b29-b6b8-ef078118a8f1",
  "tasks" : [ "java.util.ArrayList", [ [ "com.github.vlsi.jackson.Task", {
    "@id" : "004e1e10-714d-40c9-bee1-c7eb3eafb882",
    "GPCode" : "NC.TIME.OFF",
    "activity" : [ "com.github.vlsi.jackson.Activity", {
      "@id" : "b2ca3ef9-f4a9-490d-b28f-b872e4f411e2",
      "priority" : 42
    } ],
    "objectTypeId" : [ "java.math.BigInteger", 9876543210987654321 ]
  } ], "004e1e10-714d-40c9-bee1-c7eb3eafb882" ] ],
  "activities" : [ "java.util.ArrayList", [ "b2ca3ef9-f4a9-490d-b28f-b872e4f411e2", "b2ca3ef9-f4a9-490d-b28f-b872e4f411e2" ] ]
} ]
     */
    @Test
    public void test() throws JsonProcessingException {
        Employee e = new Employee();
        Activity a = new Activity();
        Task t = new Task();
        Process p = new Process();
        e.name = "employee 1";
        e.currentActivity = a;
        e.taskQueue = new ArrayList<Task>(Collections.singleton(t));
        a.assignedEmployee = e;
        a.priority = 42;
        t.assignedTo = e;
        t.activity = a;
        t.process = p;
        t.GPCode = "NC.TIME.OFF";
        t.objectTypeId = new BigInteger("9876543210987654321");
        p.activities = Arrays.asList(a, a);
        p.tasks = Arrays.asList(t, t);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String res = mapper.writeValueAsString(p);
        System.out.print("Serialized json is:\n");
        System.out.println(res);
    }
}
