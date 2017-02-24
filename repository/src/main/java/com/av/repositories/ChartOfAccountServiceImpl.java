package com.av.repositories;

import com.av.data.services.ChartOfAccountService;
import com.av.domain.accounting.ChartOfAccount;
import javafx.collections.ObservableList;

import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.logging.Logger;

/**
 * Created by vasiliev-alexey on 21.01.17.
 */
@Transactional
public class ChartOfAccountServiceImpl implements ChartOfAccountService {
    private final Logger logger = Logger.getLogger(ChartOfAccountServiceImpl.class.getName());

    @PersistenceContext
    private EntityManager emf;

    @Override

    public ObservableList<ChartOfAccount> save(ObservableList<ChartOfAccount> chartOfAccounts) {



        for (ChartOfAccount chartOfAccount : chartOfAccounts) {

            saveOrCreate(chartOfAccount);

        }


        return null;
    }

@Cacheable
    public ChartOfAccount saveOrCreate(ChartOfAccount chartOfAccount) {
        String jpql = "select s from ChartOfAccount s where" +
                "  s.segment1 = :s1 " +
                " and s.segment2 = :s2 " +
                " and s.segment3 = :s3 " +
                " and s.segment4 = :s4 " +
                " and s.segment5 = :s5 " +
                " and s.segment6 = :s6 " +
                " and s.segment7 = :s7 " +
                " and s.segment8 = :s8 " +
                " and s.segment9 = :s9 " +
                " and s.segment10 = :s10 ";


        Query query = emf.createQuery(jpql).
                setParameter("s1", chartOfAccount.getSegment1()).
                setParameter("s2", chartOfAccount.getSegment2()).
                setParameter("s3", chartOfAccount.getSegment3()).
                setParameter("s4", chartOfAccount.getSegment4()).
                setParameter("s5", chartOfAccount.getSegment5()).
                setParameter("s6", chartOfAccount.getSegment6()).
                setParameter("s7", chartOfAccount.getSegment7()).
                setParameter("s8", chartOfAccount.getSegment8()).
                setParameter("s9", chartOfAccount.getSegment9()).
                setParameter("s10", chartOfAccount.getSegment10());
        try {
            return (ChartOfAccount) query.getSingleResult();

        } catch (NoResultException ex) {
            logger.info("create new CAS");
            emf.persist(chartOfAccount );
        }

        return chartOfAccount;
    }


}
