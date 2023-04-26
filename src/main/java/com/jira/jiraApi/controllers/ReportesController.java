package com.jira.jiraApi.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jira.jiraApi.MyJsonClass;

import jakarta.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

@Controller
public class ReportesController {
    private String url = "https://test-mesa-ayuda.atlassian.net/rest/api/3/search?jql=project=Test&fields=issuetype,project,priority,assignee,summary";
    private String email = "salvador243gm@gmail.com";
    private String apiToken = "ATATT3xFfGF0PMr8HdwF5_464tWk3k5idRXCn45DmWI74HBNEQQv-ZQDtcwUVu7PKo7e2iNt2K7UR87ijh6kOnu5PDo4fENnqwPjHKRAS9bTIjF89p7kWGOtALSBymMPlLEPw0R7M29MbKhMFDeGqQGsjDZI-9dprGRZzCjM6tjWHiY6oBRo4Rc=1B4AD62A";
    @Autowired
    JiraController jiraController;

    @GetMapping("/reportePDF")
    public void generarPDF(HttpServletResponse response) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Authorization", "Basic " + JiraController.getAuthString(email, apiToken));
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
        String inputLine;
        StringBuffer res = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            res.append(inputLine);
        }
        in.close();

        Map<String, Object> dict = new HashMap<String, Object>();
        dict.put("codigo", responseCode);
        dict.put("errores", res.toString());

        ObjectMapper objectMapper = new ObjectMapper();
        MyJsonClass frutas = objectMapper.readValue(res.toString(), MyJsonClass.class);

        List<MyJsonClass.IssueData> i = frutas.getIssues();

        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font boldFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
        Paragraph paragraph = new Paragraph("Reporte de errores en Jira", boldFont);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.setWidths(new float[] { (float) 0.5, (float) 1.5, 2, 2, 2, 2 });
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        table.addCell("ID");
        table.addCell("KEY");
        table.addCell("SUMMARY");
        table.addCell("DISPLAY NAME");
        table.addCell("EMAIL ADDRESS");
        table.addCell("PRIORITY NAME");

        for (MyJsonClass.IssueData issue : i) {
            PdfPCell id = new PdfPCell(new Paragraph(issue.getId()));
            id.setMinimumHeight(22f);
            table.addCell(id);

            PdfPCell key = new PdfPCell(new Paragraph(issue.getKey()));
            id.setMinimumHeight(22f);
            table.addCell(key);

            PdfPCell summary = new PdfPCell(new Paragraph(issue.getFields().getSummary()));
            summary.setMinimumHeight(22f);
            table.addCell(summary);

            if (issue.getFields().getAssignee() != null) {
                PdfPCell display_name = new PdfPCell(new Paragraph(issue.getFields().getAssignee().getDisplayName()));
                display_name.setMinimumHeight(22f);
                table.addCell(display_name);

                PdfPCell emailAddress = new PdfPCell(new Paragraph(issue.getFields().getAssignee().getEmailAddress()));
                emailAddress.setMinimumHeight(22f);
                table.addCell(emailAddress);
            }

            if (issue.getFields().getPriority() != null) {
                PdfPCell priority = new PdfPCell(new Paragraph(issue.getFields().getPriority().getName()));
                priority.setMinimumHeight(22f);
                table.addCell(priority);
            }

        }

        document.add(table);
        document.close();
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=reporte_issues.pdf");
    }
}
