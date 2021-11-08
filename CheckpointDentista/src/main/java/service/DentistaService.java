package service;

import dao.IDao;
import model.Dentista;

import java.util.List;
import java.util.Optional;

public class DentistaService {

        private IDao<Dentista> dentistaIDao;

        public DentistaService(IDao<Dentista> dentistaIDao) {
            this.dentistaIDao = dentistaIDao;
        }

        public Dentista salvar(Dentista dentista) {
            dentistaIDao.salvar(dentista);
            return dentista;
        }



        public Optional<Dentista> buscar (Integer id) {
            return dentistaIDao.buscar(id);
        }

        public List<Dentista> buscarTodos(){
            return dentistaIDao.buscarTodos();
        }

        public void excluir (Integer id) {
            dentistaIDao.excluir(id);
        }

    }



