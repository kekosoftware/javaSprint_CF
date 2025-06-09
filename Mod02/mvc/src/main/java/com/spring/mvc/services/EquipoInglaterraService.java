package com.spring.mvc.services;

import com.spring.mvc.models.Equipo;
import com.spring.mvc.models.Jugador;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class EquipoInglaterraService implements IService{

    @Override
    public List<Equipo> getTodos() {
        Equipo manchesteUnited = new Equipo();
        manchesteUnited.setNombre("ManchesteUnited");
        manchesteUnited.addJuagdor(new Jugador("TER STEGEN_", 1));
        manchesteUnited.addJuagdor(new Jugador("ARAUJO_", 4));
        manchesteUnited.addJuagdor(new Jugador("DEMBELE_", 9));

        Equipo manchesterCity = new Equipo();
        manchesterCity.setNombre("ManchesterCity");
        manchesterCity.addJuagdor(new Jugador("CARABAJAL_", 1));
        manchesterCity.addJuagdor(new Jugador("MODRIC_", 4));
        manchesterCity.addJuagdor(new Jugador("HAZARD_", 9));

        return List.of(manchesteUnited, manchesterCity);
    }
}
