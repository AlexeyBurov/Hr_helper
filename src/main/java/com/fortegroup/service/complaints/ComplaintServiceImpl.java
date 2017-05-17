package com.fortegroup.service.complaints;

import com.fortegroup.dao.complaints.ComplaintDAO;
import com.fortegroup.model.complaints.Complaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by alex on 5/9/17.
 */
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintDAO complaintDAO;

    @Override
    @Transactional
    public Long saveComplaint(Complaint complaint) {
        //complaint.setDate(new Timestamp(System.currentTimeMillis()));
        complaint.setStage("GETTING");
        return complaintDAO.saveComplaint(complaint);
    }

    @Override
    @Transactional
    public void approveComplaint(Complaint complaint) {
        Complaint daoComplaint = complaintDAO.getComplaintById(complaint.getId());
        daoComplaint.setStage("APPROVED");
        complaintDAO.updateComplaint(daoComplaint);
    }

    @Override
    @Transactional
    public Complaint getComplaintById(Long id) {
        return complaintDAO.getComplaintById(id);
    }

    @Override
    @Transactional
    public List<Complaint> getAllComplaints() {
        return complaintDAO.getAllComplaints();
    }

    @Override
    @Transactional
    public List<Complaint> getAllNotApprovedComplaints() {
        return complaintDAO.getAllNotApprovedComplaints();
    }
}
