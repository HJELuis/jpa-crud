package com.ebac.modulo60;

import com.ebac.modulo60.dto.Direccion;
import com.ebac.modulo60.model.DireccionModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class Contexto {

    public static void main(String[] args) throws SQLException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("coneccionLocalMySQL");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        DireccionModel direccionModel = new DireccionModel(entityManager);

        Direccion direccionGuanajuato = new Direccion();
        direccionGuanajuato.setIdUsuario(1);
        direccionGuanajuato.setCalle("Privada rosales");
        direccionGuanajuato.setNumero(900);
        direccionGuanajuato.setEstado("Guanajuato");

        direccionModel.guardar(direccionGuanajuato);

        Direccion direccionObtenida = direccionModel.obtenerPorId(1);
        System.out.println(direccionObtenida);
        System.out.println("-----------------------");

        direccionObtenida.setEstado("Veracruz");
        direccionModel.actualizar(direccionObtenida);

        Direccion direccionActualizada = direccionModel.obtenerPorId(1);
        System.out.println(direccionActualizada);

        Direccion direccionAEliminar = direccionModel.obtenerPorId(1);
        direccionModel.eliminar(direccionAEliminar);

        Direccion direccionEliminada = direccionModel.obtenerPorId(1);
        System.out.println(direccionEliminada);

        entityManager.close();
        entityManagerFactory.close();

    }
}
