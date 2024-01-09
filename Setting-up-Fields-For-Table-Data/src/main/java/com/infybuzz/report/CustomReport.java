package com.infybuzz.report;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author E.Parominsky 09/01/2024 09:25
 */
public class CustomReport {

    public static void main(String[] args) {
        try {
            String filePath = "/home/parom/IdeaProjects/JasperReports/Setting-up-Fields-For-Table-Data/src/main/resources/studentsReport.jrxml";

            Subject subject1 = new Subject("Java", 80);
            Subject subject2 = new Subject("MySQL", 70);
            Subject subject3 = new Subject("PHP", 50);
            Subject subject4 = new Subject("MongoDB", 40);
            Subject subject5 = new Subject("C++", 60);

            List<Subject> list = new ArrayList<Subject>();
            list.add(subject1);
            list.add(subject2);
            list.add(subject3);
            list.add(subject4);
            list.add(subject5);

            // create DateSource
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);

            JRBeanCollectionDataSource chartDataSource = new JRBeanCollectionDataSource(list);

            // create Parameters
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("studentName", "John Little");
            parameters.put("tableData", dataSource);

            // compile reportTemplate
            JasperReport report = JasperCompileManager.compileReport(filePath);

            // filling the Template
//            JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
            JasperPrint print = JasperFillManager.fillReport(report, parameters, chartDataSource);

            // Export to necessary format
            JasperExportManager.exportReportToPdfFile(print, "/home/parom/IdeaProjects/JasperReports/Setting-up-Fields-For-Table-Data/src/main/resources/studRep.pdf");

            JasperExportManager.exportReportToHtmlFile(print, "/home/parom/IdeaProjects/JasperReports/Setting-up-Fields-For-Table-Data/src/main/resources/studRep.html");

            System.out.println("Report Create...");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
