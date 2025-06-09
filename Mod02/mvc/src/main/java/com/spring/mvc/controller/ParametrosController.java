package com.spring.mvc.controller;

import com.spring.mvc.models.Equipo;
import com.spring.mvc.models.Jugador;
import com.spring.mvc.services.IService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

@Controller
public class ParametrosController {

    private IService equipoService;

    public ParametrosController(@Qualifier("equiposEspaña") IService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping("/parametros")
    public String parametros(@RequestParam(defaultValue = "valor default") String valor,
                             @RequestParam(defaultValue = "valor default 02", name = "valor_dos") String valor2,
                             Model model) {

        model.addAttribute("titulo", "Parametros");
        model.addAttribute("parametro", valor);
        model.addAttribute("valor_dos", valor2);

        return "parametros";
    }

    @GetMapping("/equipos/{nombre}/{numero}")
    public String parametrosPorPath(@PathVariable String nombre, @PathVariable("numero") Integer numero, Model model) {

        Optional<Equipo> equipoOptional = equipoService.getTodos().stream()
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

}
