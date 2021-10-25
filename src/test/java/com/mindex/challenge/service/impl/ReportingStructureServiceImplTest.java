package com.mindex.challenge.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingStructureServiceImplTest {


    private String employeeUrl;
    private String reportStructureURL;

    @Autowired
    ReportingStructureService reportingStructureService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        employeeUrl = "http://localhost:" + port + "/employee";
        reportStructureURL = "http://localhost:" + port + "/reportingStructure/{id}";
    }

    @Test
    public void testRead(){
        //setting up Employees for directReports Lists
        Employee testEmployee1 = new Employee();
        testEmployee1.setFirstName("John");
        testEmployee1.setLastName("Doe");
        testEmployee1.setDepartment("Engineering");
        testEmployee1.setPosition("Developer");

        Employee testEmployee2 = new Employee();
        testEmployee2.setFirstName("Bob");
        testEmployee2.setLastName("Smith");
        testEmployee2.setDepartment("Engineering");
        testEmployee2.setPosition("Junior Developer");

        Employee testEmployee3 = new Employee();
        testEmployee3.setFirstName("Sheryll");
        testEmployee3.setLastName("Green");
        testEmployee3.setDepartment("Business Administration");
        testEmployee3.setPosition("Business Admin");

        Employee testEmployee4 = new Employee();
        testEmployee4.setFirstName("Jessie");
        testEmployee4.setLastName("Stevens");
        testEmployee4.setDepartment("Mangement");
        testEmployee4.setPosition("Lead Manager");

        //creating directReportsLists and initializing 
        List<Employee> directReportsForTestEmployee1 = new ArrayList<Employee>();
        directReportsForTestEmployee1.add(testEmployee2);
        testEmployee1.setDirectReports(directReportsForTestEmployee1);

        List<Employee> directReportsForTestEmployee4 = new ArrayList<Employee>();
        directReportsForTestEmployee4.add(testEmployee1);
        directReportsForTestEmployee4.add(testEmployee3);
        testEmployee4.setDirectReports(directReportsForTestEmployee4);

        Employee postedTestEmployee = restTemplate.postForEntity(employeeUrl, testEmployee4, Employee.class).getBody();

        ReportingStructure createdReportingStructure = new ReportingStructure(postedTestEmployee);

        //read checks
        ReportingStructure readReportingStructure = restTemplate.getForEntity(reportStructureURL, ReportingStructure.class, postedTestEmployee.getEmployeeId()).getBody();

        assertEmployeeEquivalence(createdReportingStructure.getEmployee(), readReportingStructure.getEmployee());
        assertEmployeeDirectReportEquivalence(createdReportingStructure, readReportingStructure, 3);
    }

    private static void assertEmployeeEquivalence(Employee expected, Employee actual) {
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getDepartment(), actual.getDepartment());
        assertEquals(expected.getPosition(), actual.getPosition());
    }

    private static void assertEmployeeDirectReportEquivalence(ReportingStructure expected, ReportingStructure actual, int expectedValue){
        assertEquals(expected.getNumberOfReports(), actual.getNumberOfReports());
        assertEquals(expectedValue, expected.getNumberOfReports());
        assertEquals(expectedValue, expected.getNumberOfReports());
    }
}
