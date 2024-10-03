package com.ebac.modulo60.model;

import com.ebac.modulo60.dto.Direccion;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DireccionModel {

    private final EntityManager entityManager;

    public DireccionModel(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void guardar(Direccion direccion) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(direccion);
            transaction.commit();
        } catch(Exception e) {
            transaction.rollback();
        }
    }

    public void actualizar(Direccion direccion) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(direccion);
            transaction.commit();
        } catch(Exception e) {
            transaction.rollback();
        }
    }

    public Direccion obtenerPorId(int id) {
        return entityManager.find(Direccion.class, id);
    }

    public void eliminar(Direccion direccion) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.remove(direccion);
            transaction.commit();
        } catch(Exception e) {
            transaction.rollback();
        }
    }
}
