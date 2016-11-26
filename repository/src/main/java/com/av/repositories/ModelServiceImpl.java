package com.av.repositories;

import com.av.domain.Model;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Vasiliev.Alexey on 26.11.16.
 */

@Service(value = "modelService")
@Repository
//@Transactional
public class ModelServiceImpl implements ModelService {

    @PersistenceContext
    private EntityManager emf;

    @Override

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Model Save(Model model) {


        emf.persist(model);

        // emf.getTransaction().commit();
        return model;


    }
}
