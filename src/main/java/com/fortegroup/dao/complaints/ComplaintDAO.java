package com.fortegroup.dao.complaints;

import com.fortegroup.model.complaints.Complaint;

import java.util.List;

/**
 * Created by alex on 5/9/17.
 */
public interface ComplaintDAO {
    Long saveComplaint(Complaint complaint);
    void updateComplaint(Complaint complaint);
    Complaint getComplaintById(Long id);
    List<Complaint> getAllComplaints();
    List<Complaint> getAllNotApprovedComplaints();
}
