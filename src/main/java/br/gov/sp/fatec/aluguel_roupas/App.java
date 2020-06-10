package br.gov.sp.fatec.aluguel_roupas;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import br.gov.sp.fatec.aluguel_roupas.dao.PersistenceManager;
import br.gov.sp.fatec.aluguel_roupas.entity.Aluguel;
import br.gov.sp.fatec.aluguel_roupas.entity.Cliente;
import br.gov.sp.fatec.aluguel_roupas.entity.Roupa;
import br.gov.sp.fatec.aluguel_roupas.entity.Vendedor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        EntityManager manager = PersistenceManager
                .getInstance().getEntityManager();
        
        Vendedor vendedor = new Vendedor();
        vendedor.setNome("Rone Felipe Bento");
        vendedor.setEmail("ronefelipe97@gmail.com");
        vendedor.setSenha("1234");
        
        Cliente cliente = new Cliente("Jurema",
        		"jurema@gmail.com", "5588774466", 23, "Altos de Santana",
        		"Pico da Bandeira", 516, "São José dos Campos", "981565932");
        
        Roupa calca = new Roupa("Calça", "Preta", "44", 60.0);
        Roupa camisa = new Roupa("Camisa", "Amarela", "G", 45.0);
        Roupa sapato = new Roupa("Sapato", "Preto", "42", 50.0);
        Roupa gravata = new Roupa("Gravata", "Azul", "M", 15.0);
        Set<Roupa> roupas = new HashSet<Roupa>();
        roupas.add(calca);
        roupas.add(camisa);
        roupas.add(sapato);
        roupas.add(gravata);

        
        Aluguel aluguel = new Aluguel(cliente, vendedor,roupas, LocalDate.of(2020, 06, 02), LocalDate.of(2020, 06, 05), LocalDate.of(2020, 06, 8), "Barra 2 cm");

        
     
        
        manager.getTransaction().begin();
        manager.persist(vendedor);
        manager.persist(cliente);
        manager.persist(roupas);
        manager.persist(aluguel);
        manager.getTransaction().commit();
        
        manager.clear();
        
    }
}
