package com.spring.mvc.controller;

import com.spring.mvc.models.Equipo;
import com.spring.mvc.models.Jugador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

@Controller
public class ParametrosController {

    @GetMapping("/parametros")
    public String parametros(@RequestParam(defaultValue = "valor default") String valor,
                             @RequestParam(defaultValue = "valor default 02", name = "valor_dos") String valor2,
                             Model model) {

        model.addAttribute("titulo", "Parametros");
        model.addAttribute("parametro", valor);
        model.addAttribute("valor_dos", valor2);

        return "parametros";
    }

    // /equipos/{nombre_equipo}/{numero_jugador}

    // /equipos/Barcelona/9
    // => lewandoski (9)

    @GetMapping("/equipos/{nombre}/{numero}")
    public String parametrosPorPath(@PathVariable String nombre, @PathVariable("numero") Integer numero, Model model) {

        Optional<Equipo> equipoOptional = getEquipos().stream()
                .filter(equipo -> nombre.toLowerCase().equals(equipo.getNombre().toLowerCase()))
                .findFirst();

        if(equipoOptional.isPresent()) {
            Optional<Jugador> jugadorOptional = equipoOptional.get().getPlantilla().stream()
                    .filter(jugador -> numero == jugador.getNumero())
                    .findFirst();

            if (jugadorOptional.isPresent()) {
                model.addAttribute("jugador", jugadorOptional.get());
            }
        }

        return "parametros";
    }

    private List<Equipo> getEquipos() {
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
