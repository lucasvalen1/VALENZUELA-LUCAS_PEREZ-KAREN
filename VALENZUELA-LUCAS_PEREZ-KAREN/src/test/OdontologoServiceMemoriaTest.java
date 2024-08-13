package test;

import dao.impl.DaoH2Odontologo;
import dao.impl.OdontologoDaoMemoria;
import model.Odontologo;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceMemoriaTest {
    static final Logger logger = Logger.getLogger(OdontologoServiceTest.class);
    OdontologoService odontologoService = new OdontologoService(new OdontologoDaoMemoria());

    @Test
    @DisplayName("Testear que un odontologo se guarde en memoria")
    void caso1(){

        Odontologo odontologo = new Odontologo("A632","JOSE","MARTINEZ");
        Odontologo odontologo1 = odontologoService.guardar(odontologo);
        assertNotNull(odontologo1.getId());
    }

    @Test
    @DisplayName("Testear que traiga todos los odontologos guardados en memoria")
    void caso2(){

        Odontologo odontologo = new Odontologo("A632","JOSE","MARTINEZ");
        Odontologo odontologo1 = odontologoService.guardar(odontologo);

        List<Odontologo> odontologos = new ArrayList<>();
        odontologos = odontologoService.buscarTodos();
        assertNotNull(odontologos.isEmpty());

    }

}