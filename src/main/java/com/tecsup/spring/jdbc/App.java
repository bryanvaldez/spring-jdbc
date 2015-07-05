package com.tecsup.spring.jdbc;

import com.tecsup.spring.jdbc.dao.ProgramaDAO;
import com.tecsup.spring.jdbc.model.Programa;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args){
        ApplicationContext cntx = new ClassPathXmlApplicationContext("h_database.xml");
        ProgramaDAO dao = (ProgramaDAO) cntx.getBean("programaDAO");
        //App.guardar(dao);
        //App.actualizar(dao);
        //App.eliminar(dao);
        App.listar(dao);
    } 

    public static void guardar (ProgramaDAO dao){
        Programa programa = new Programa();
        programa.setNombre("Programa Maribel");
        programa.setDescripcion("xyz");
        programa.setCodigo("201");
        dao.save(programa);
        System.out.println(programa.getId());
    }
    
    public static void listar(ProgramaDAO dao) {
        List<Programa> programas = dao.list();
        
        for (Programa programa : programas){
            System.out.println(programa.getId()+ " " +programa.getNombre());
        }
    }
    public static void actualizar(ProgramaDAO dao){
        Programa programa = dao.get(21L);
        programa.setNombre("Programa Modificado Pet");
        dao.update(programa);
    }
    public static void eliminar(ProgramaDAO dao){
        Programa programa = dao.get(21L);
        dao.delete(programa);
        
    }
    
}
