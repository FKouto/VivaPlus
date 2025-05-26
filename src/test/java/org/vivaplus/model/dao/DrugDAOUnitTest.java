package org.vivaplus.model.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.vivaplus.model.bean.Drug;
import org.vivaplus.model.enums.Prescription;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class DrugDAOUnitTest {

    private DrugDAO drugDAO;
    private final String testDrugId = "1000"; // deve ser um número em String, pois é tratado como int nas queries

    @Before
    public void setUp() {
        drugDAO = new DrugDAO();
        // Remove o registro se ele existir para não interferir nos testes
        drugDAO.delete(testDrugId);
    }

    @After
    public void tearDown() {
        // Remove o registro de teste após cada método
        drugDAO.delete(testDrugId);
    }

    @Test
    public void testCreateAndRead() {
        // Cria um novo Drug com dados de teste
        Drug drug = new Drug(
                testDrugId,
                "Produto Teste",
                10,
                20.5,
                Prescription.NO,  // ajuste para um valor válido do enum Prescription
                "BATCH-TESTE",
                new Date(),
                0,
                null
        );
        boolean created = drugDAO.create(drug);
        assertTrue("Falha ao criar drug", created);

        // Leitura do mesmo drug
        Drug fetched = drugDAO.read(testDrugId);
        assertNotNull("Drug não encontrada após criação", fetched);
        assertEquals("Produto Teste", fetched.getProduct());
    }

    @Test
    public void testGetAll() {
        // Cria um novo Drug para garantir que haja pelo menos um registro de teste
        Drug drug = new Drug(
                testDrugId,
                "Produto GetAll",
                5,
                15.0,
                Prescription.NO,
                "BATCH-GETALL",
                new Date(),
                0,
                null
        );
        drugDAO.create(drug);

        List<Drug> drugs = drugDAO.getAll();
        assertNotNull("A lista de drugs não deveria ser nula", drugs);

        // Verifica se o produto de teste está na lista
        boolean found = drugs.stream().anyMatch(d -> testDrugId.equals(d.getId()));
        assertTrue("Drug de teste não encontrada na lista", found);
    }

    @Test
    public void testUpdate() {
        // Cria um novo Drug para atualização
        Drug drug = new Drug(
                testDrugId,
                "Produto Original",
                8,
                30.0,
                Prescription.NO,
                "BATCH-UPDATE",
                new Date(),
                0,
                null
        );
        drugDAO.create(drug);

        // Atualiza dados do drug
        drug.setProduct("Produto Atualizado");
        drug.setQuantity(12);
        boolean updated = drugDAO.update(drug);
        assertTrue("Falha ao atualizar drug", updated);

        // Verifica atualização
        Drug fetched = drugDAO.read(testDrugId);
        assertNotNull("Drug não encontrada após atualização", fetched);
        assertEquals("Produto Atualizado", fetched.getProduct());
        assertEquals(12, fetched.getQuantity());
    }

    @Test
    public void testDelete() {
        // Cria um novo Drug para deleção
        Drug drug = new Drug(
                testDrugId,
                "Produto Delete",
                7,
                25.0,
                Prescription.NO  ,
                "BATCH-DELETE",
                new Date(),
                0,
                null
        );
        drugDAO.create(drug);

        // Remove o drug
        boolean deleted = drugDAO.delete(testDrugId);
        assertTrue("Falha ao deletar drug", deleted);

        // Verifica se o drug foi removido
        Drug fetched = drugDAO.read(testDrugId);
        assertNull("Drug encontrada mesmo após exclusão", fetched);
    }
}