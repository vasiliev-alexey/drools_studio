package com.av.repositories;

import com.av.domain.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by Vasiliev.Alexey on 26.11.16.
 */


@Repository
@Transactional
public class ModelServiceImpl implements ModelService {

    @PersistenceContext
    private EntityManager emf;

    @Override


    public Model Save(Model model) {


        if(model.getId() == null) {
            emf.persist(model);
        } else  {
            emf.merge(model);
        }
        return model;


    }

    @Override
    public ObservableList<Model> getAll() {

        CriteriaBuilder cb = emf.getCriteriaBuilder();
        CriteriaQuery<Model> cq = cb.createQuery(Model.class);
        Root<Model> rootEntry = cq.from(Model.class);
        CriteriaQuery<Model> all = cq.select(rootEntry);
        TypedQuery<Model> allQuery = emf.createQuery(all);
        return FXCollections.observableArrayList( allQuery.getResultList());

    }
}
