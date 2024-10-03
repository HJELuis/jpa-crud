package com.ebac.modulo60;

import com.ebac.modulo60.model.TelefonoModel;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Optional;

public class ContextoMongo {
    public static void main(String[] args) {
        String connection = "mongodb://root:toor@localhost:27017";
        MongoClient mongoClient = MongoClients.create(connection);
        MongoDatabase database = mongoClient.getDatabase("modulo60");

        TelefonoModel telefonoModel = new TelefonoModel(database);
        Document document = new Document("idUsuario", 1)
                .append("numero","+52 654-2121-3232")
                .append("tipo", "celular");

        Document document2 = new Document("idUsuario", 2)
                .append("numero","++52 654-9874-1549")
                .append("tipo", "oficina");

        telefonoModel.guardar(document);
        telefonoModel.guardar(document2);
        telefonoModel.obtener();

//        ObjectId objectId = new ObjectId("66feed49d76a747081c95101");
//        Document document3 = new Document("_id", objectId);
//        Optional<Document> telefonoEncontrado = telefonoModel.obtenerPorId(document3);
//
//        telefonoEncontrado.ifPresent(telefonActual -> {
//            Document documento = new Document("idUsuario" , 5).append("tipo", "casa");
//            Document telefonActualizado = new Document("$set", documento);
//
//            telefonoModel.actualizar(telefonActual, telefonActualizado);
//        });
//
//        telefonoModel.obtener();
//
//        telefonoEncontrado.ifPresent(telefonoModel::eliminar);
//
//        telefonoModel.obtener();
    }
}
