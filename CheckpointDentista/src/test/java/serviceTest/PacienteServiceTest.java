package serviceTest;

import dao.impl.EnderecoDaoH2;
import dao.impl.PacienteDaoH2;
import model.Endereco;
import model.Paciente;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import service.EnderecoService;
import service.PacienteService;

import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PacienteServiceTest {

    private static PacienteService pacienteService = new PacienteService(new PacienteDaoH2(new EnderecoDaoH2()));
    private EnderecoService enderecoService = new EnderecoService(new EnderecoDaoH2());

    @BeforeClass
    public static void cadastrarPessoas(){
        Endereco endereco = new Endereco("Av. Avenida", "444", "Cidade", "Estado");
        Paciente paciente= pacienteService.salvar((new Paciente("Carlos", "Alberto", "999999999999", new Date(), endereco)));
        Endereco endereco2 = new Endereco("Av. Avenida2", "4555", "Cidade2", "Estado2");
        Paciente paciente2= pacienteService.salvar((new Paciente("Marcela", "Moura", "88888888888888", new Date(), endereco2)));
    }

    @Test
    public void salvarEBuscarTest() {
        Endereco endereco = new Endereco("Rua dos Oliveiras", "1234", "Cidade Bela", "Estado3");
        Paciente paciente = pacienteService.salvar(new Paciente("Marcio", "Oliveira", "1234535436", new Date(), endereco));

        Assert.assertNotNull(pacienteService.buscar(paciente.getId()));
    }

    @Test
    public void excluirTest() {
        pacienteService.excluir(6);
        Assert.assertTrue(pacienteService.buscar(6).isEmpty());
    }

    @Test
    public void buscarTodosTest() {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() == 2);
        System.out.println(pacientes);
    }

}
