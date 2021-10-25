package com.mindex.challenge.data;

import static org.junit.Assert.assertEquals;

import com.mindex.challenge.dao.EmployeeRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportingStructureTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
	public void reportingStructureNullDirectReportEmployee(){
		Employee employee = employeeRepository.findByEmployeeId("62c1084e-6e34-4630-93fd-9153afb65309");
		ReportingStructure reportingStructure = new ReportingStructure(employee);

		int numberOfReports = reportingStructure.getNumberOfReports();
		Employee reportingStructureEmployee = reportingStructure.getEmployee();

		assertEquals(employee, reportingStructureEmployee);
		assertEquals(0, numberOfReports);		
	}

	@Test
	public void reportingStructureNonNullDirectReportEmployee(){
		Employee employee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
		ReportingStructure reportingStructure = new ReportingStructure(employee);

		int numberOfReports = reportingStructure.getNumberOfReports();
		Employee reportingStructureEmployee = reportingStructure.getEmployee();

		assertEquals(employee, reportingStructureEmployee);
		assertEquals(4, numberOfReports);		
	}	
}
