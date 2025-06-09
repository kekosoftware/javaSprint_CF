package com.spring.mvc.services;

import com.spring.mvc.models.Equipo;
import com.spring.mvc.models.Jugador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("equiposEspaña")
public class EquipoService implements IService {
    public List<Equipo> getTodos() {
        Equipo barcelona = new Equipo();
        barcelona.setNombre("Barcelona");
        barcelona.addJuagdor(new Jugador("TER STEGEN", 1));
        barcelona.addJuagdor(new Jugador("ARAUJO", 4));
        barcelona.addJuagdor(new Jugador("DEMBELE", 9));

        Equipo realMadrid = new Equipo();
        realMadrid.setNombre("RealMadrid");
        realMadrid.addJuagdor(new Jugador("CARABAJAL", 1));
        realMadrid.addJuagdor(new Jugador("MODRIC", 4));
        realMadrid.addJuagdor(new Jugador("HAZARD", 9));

        return List.of(barcelona, realMadrid);
    }
}
