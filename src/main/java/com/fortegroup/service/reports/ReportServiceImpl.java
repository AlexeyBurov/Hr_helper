package com.fortegroup.service.reports;

import com.fortegroup.model.peoples.Person;
import com.fortegroup.service.person.PersonService;
import com.fortegroup.utill.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by alex on 5/4/17.
 */
@Service
public class ReportServiceImpl implements ReportService{
    private final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Autowired
    private PersonService personService;

    @Override
    @Transactional
    public boolean buildReportFile(Long... personsId) {

        List<Person> result = personService.getPersonsById(personsId);
        try(PrintStream out = new PrintStream(Constant.pathToReportsFolder+System.currentTimeMillis()+"report.txt")){
        out.println("Имя,Email,Телефон,Вакансия");
            result.stream().forEach(person ->{
                    out.println(String.format("%s,%s,%s,%s",
                            person.getName(), person.getEmail(), person.getTelephone(), person.getVacancy()));
        });
        out.flush();
        } catch (IOException e) {
            logger.error("IOException",e);
            return false;
        }
        return true;
    }
}
