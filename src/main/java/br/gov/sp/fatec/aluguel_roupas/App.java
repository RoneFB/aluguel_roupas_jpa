package br.gov.sp.fatec.aluguel_roupas;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.gov.sp.fatec.aluguel_roupas.dao.PersistenceManager;
import br.gov.sp.fatec.aluguel_roupas.entity.Aluguel;
import br.gov.sp.fatec.aluguel_roupas.entity.Calcado;
import br.gov.sp.fatec.aluguel_roupas.entity.Cliente;
import br.gov.sp.fatec.aluguel_roupas.entity.Pessoa;
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
        
        Cliente cliente = new Cliente();
        cliente.setNome("Joséfina fina");
        cliente.setEmail("josefina@bol.com");
        cliente.setCpf("12346789");
        cliente.setRua("Av Pico da Bandeira");
        cliente.setTelefone("981565932");
        cliente.setBairro("Altos de Santana");
        cliente.setCidade("São José dos Campos");
        cliente.setNumero(516);
        cliente.setIdade(23);
        
        
        Roupa roupa = new Roupa(); 
        roupa.setTipo("camisa");
        roupa.setTamanho("G");
        roupa.setSexo("F");
        roupa.setPreco(65.99);
        roupa.setCor("Azul");
        
        Calcado calcado = new Calcado();
        calcado.setSexo("F");
        calcado.setPreco(50);
        calcado.setNumero(38);
        calcado.setModelo("Social");
        calcado.setCor("preto");
        
        Aluguel aluguel = new Aluguel(cliente, vendedor,LocalDate.of(2020, 06, 02), LocalDate.of(2020, 06, 05), LocalDate.of(2020, 06, 8), "Barra 2 cm");
       
        aluguel.setRoupas(new HashSet<Roupa>());
        aluguel.getRoupas().add(roupa);
        
        aluguel.setCalcados(new HashSet<Calcado>());
        aluguel.getCalcados().add(calcado);
        
        manager.getTransaction().begin();
        manager.persist(vendedor);
        manager.persist(cliente);
        manager.persist(roupa);
        manager.persist(calcado);
        manager.persist(aluguel);
        manager.getTransaction().commit();
        
        
        String queryText = "select a "+
        		"from Aluguel a "+
        		"where a.cliente = :cliente";
        
        Query query = manager.createQuery(queryText);
        query.setParameter("cliente", cliente);
        
        @SuppressWarnings({"unchecked"})
		List<Aluguel> result = query.getResultList();
        
        for(Aluguel alu: result) {
        	System.out.println("\n-----------------------------------Inf Cliente----------------------------------------------");
        	System.out.println("Cliente: " + alu.getCliente().getNome());
        	System.out.println("Telefone: " + alu.getCliente().getTelefone());
        	System.out.println("Cidade: " + alu.getCliente().getCidade());
        	System.out.println("Bairro: " + alu.getCliente().getBairro());
        	System.out.println("Rua: " + alu.getCliente().getRua());
        	System.out.println("Email: " + alu.getCliente().getEmail());
        	System.out.println("\n-----------------------------------Inf Aluguel----------------------------------------------");
        	System.out.println("Data Aluguel: " + alu.getDataDevolucao());
        	System.out.println("Data Retirada: " + alu.getDataRetirada());
        	System.out.println("Data Devolução: " + alu.getDataDevolucao());
        	System.out.println("\n---------------------------------------------------------------------------------");
        	for(Roupa rou :alu.getRoupas()){
        		System.out.println("Tipo " + rou.getTipo() + " Cor: " + rou.getCor() + " Tamanho " + rou.getTamanho() + " Preço: "+rou.getPreco() );
        	}
        	
        }
        
        manager.close();  
        
        
        
    }
}
