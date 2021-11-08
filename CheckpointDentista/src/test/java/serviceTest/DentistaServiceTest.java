package serviceTest;

import dao.impl.DentistaDaoH2;
import model.Dentista;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import service.DentistaService;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DentistaServiceTest {

        private static DentistaService dentistaService = new DentistaService(new DentistaDaoH2());


        @BeforeClass
        public static void cadastrarDentistas(){

            Dentista dentista = dentistaService.salvar((new Dentista(1,"1","Adriano", "Silva")));
            Dentista dentista2= dentistaService.salvar((new Dentista(2,"2","Adriana", "Santos")));
        }

        @Test
        public void salvarEBuscarTest() {

            Dentista dentista = dentistaService.salvar(new Dentista(1,"1","Adriano", "Silva"));

            Assert.assertNotNull(dentistaService.buscar(dentista.getId()));
        }

        @Test
        public void excluirTest() {
            dentistaService.excluir(2);
            Assert.assertTrue(dentistaService.buscar(1).isEmpty());
        }
            public void buscarTodosTest() {
            List<Dentista> dentistas = dentistaService.buscarTodos();
            Assert.assertTrue(!dentistas.isEmpty());
            Assert.assertTrue(dentistas.size() == 2);
            System.out.println(dentistas);
        }

    }


