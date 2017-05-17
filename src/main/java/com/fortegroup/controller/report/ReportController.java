package com.fortegroup.controller.report;

import com.fortegroup.model.email.EmailRequest;
import com.fortegroup.service.reports.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 5/5/17.
 */
@RestController
@RequestMapping("/rest/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/protected/buildReport",method = RequestMethod.POST)
    public ResponseEntity<?> buildResult(@RequestBody EmailRequest request){
        return ResponseEntity.ok(reportService.buildReportFile(request.getPersonsId()));
    }
}
