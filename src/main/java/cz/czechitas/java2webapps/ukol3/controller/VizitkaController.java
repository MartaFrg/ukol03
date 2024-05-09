package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
    private final List<Vizitka> seznamVizitek = List.of(
            new Vizitka("Dita (Přikrylová) Formánková", "Czechitas z. s.", "Tošov 17", "51771 České Meziříčí", "dita@czechitas.cs", null, "www.czechitas.cz"),
            new Vizitka("Barbora Bühnová", "Czechitas z. s.", "Václavské náměstí 837/11", "11000 Praha 1", null, "+420 800123456", "www.czechitas.cz"),
            new Vizitka("Monika Ptáčníková", "Czechitas z. s.", "K Jakubu 51", "28401 Kutná Hora", "monika@czechitas.cs", "+420 800123456", null),
            new Vizitka("Mirka Zatloukalová", "ABC firma", "Nerudova 863", "50002 Hradec Králové", "mirka@czechitas.cs", null, null),
            new Vizitka("Marie Černá", "ABC firma", "Tyršová 629", "76811 Chropyně", "cerna@post.abc", "777 888 999", "www.cerna.cz")
    );
    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView modelAndView = new ModelAndView("/seznam");
        modelAndView.addObject("vizitky", seznamVizitek);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("vizitka", seznamVizitek.get(id));
        return modelAndView;
    }
}
