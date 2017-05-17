package com.fortegroup.dao.complaints;

import com.fortegroup.model.complaints.Complaint;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by alex on 5/9/17.
 */
public class ComplaintDAOImpl implements ComplaintDAO{

    private final Logger logger = LoggerFactory.getLogger(ComplaintDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long saveComplaint(Complaint complaint) {

         Long id = (Long) sessionFactory.
                         getCurrentSession().
                                   save(complaint);
         logger.info("Save complete Complaint details:"+complaint);
         return id;
    }

    @Override
    public void updateComplaint(Complaint complaint) {
        sessionFactory.
                getCurrentSession().
                        update(complaint);
        logger.info("Update complete Complaint details:"+complaint);

    }

    @Override
    public Complaint getComplaintById(Long id) {
        Complaint complaint =  sessionFactory.
                                getCurrentSession().
                                    get(Complaint.class,id);
        logger.info("Complaint successfully get Complaint details:"+complaint);
        return complaint;
    }

    @Override
    public List<Complaint> getAllComplaints() {
        List<Complaint> result = sessionFactory.
                    getCurrentSession().
                        createCriteria(Complaint.class).
                            list();
        logger.info("Getting complete List details:"+result.size());
        return result;
    }

    @Override
    public List<Complaint> getAllNotApprovedComplaints() {
        List<Complaint> result = sessionFactory.
                getCurrentSession().
                    createCriteria(Complaint.class).
                        add(Restrictions.eq("stage","GETTING")).
                list();
        logger.info("Getting complete List details:"+result.size());
        return result;

    }
}
