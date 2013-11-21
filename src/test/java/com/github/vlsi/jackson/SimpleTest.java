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
  "@id" : "51910b6e-4780-436f-9d19-68df0c4a2875",
  "tasks" : [ "java.util.ArrayList", [ [ "com.github.vlsi.jackson.Task", {
    "@id" : "7a176d0a-1599-4dfc-abaa-b9042a1a9179",
    "GPCode" : "NC.TIME.OFF",
    "process" : "51910b6e-4780-436f-9d19-68df0c4a2875",
    "activity" : [ "com.github.vlsi.jackson.Activity", {
      "@id" : "10152d97-93de-415f-b0dc-7857c25a2f05",
      "priority" : 42,
      "assignedEmployee" : [ "com.github.vlsi.jackson.Employee", {
        "@id" : "d2fcf0a1-e7cb-4e50-bba2-8992df8074a9",
        "name" : "employee 1",
        "taskQueue" : [ "java.util.ArrayList", [ "7a176d0a-1599-4dfc-abaa-b9042a1a9179" ] ],
        "currentActivity" : "10152d97-93de-415f-b0dc-7857c25a2f05"
      } ]
    } ],
    "assignedTo" : "d2fcf0a1-e7cb-4e50-bba2-8992df8074a9",
    "objectTypeId" : [ "java.math.BigInteger", 9876543210987654321 ]
  } ], "7a176d0a-1599-4dfc-abaa-b9042a1a9179" ] ],
  "activities" : [ "java.util.ArrayList", [ "10152d97-93de-415f-b0dc-7857c25a2f05", "10152d97-93de-415f-b0dc-7857c25a2f05" ] ]
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
