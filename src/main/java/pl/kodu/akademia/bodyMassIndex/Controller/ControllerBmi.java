package pl.kodu.akademia.bodyMassIndex.Controller;

import org.decimal4j.util.DoubleRounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kodu.akademia.bodyMassIndex.Model.bodyMassIndex;
import pl.kodu.akademia.bodyMassIndex.Service.bmiService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ControllerBmi {

    @Autowired
    bmiService ServiceBMI;


    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("bodyMassIndex", new bodyMassIndex());
        return "home";
    }

    // Metoda na dodawanie danych do listy
    //Przesyłanie z widoku do obiektu wartości @ModelAttribute
    @PostMapping("/")
    public String formSubmit(@ModelAttribute bodyMassIndex solve) {
        ServiceBMI.getbodyMassIndexById(solve.getId());
        double height = (double) solve.getWzrost() / (double) 100;
        double bmi = (solve.getWaga() / Math.pow(height, 2));
        double bmi2 = DoubleRounder.round(bmi, 2);
        solve.setPoliczoneBMI(bmi2);
        ServiceBMI.saveBmi(solve);
        ServiceBMI.updateBMI(solve);
        return "result";
    }

    @RequestMapping(value = "/wyszukiwanie", method = RequestMethod.GET)
    public String showReserarch() {
        return "research";
    }

    @RequestMapping(value = "/wyszukiwanie", method = RequestMethod.POST)
    public String researchSubmit(@RequestParam int id, Model model) {
        List<bodyMassIndex> result = new ArrayList<>();
        List<bodyMassIndex> lista = ServiceBMI.getInformWithForm();
        for (bodyMassIndex wyszukiwanie : lista) {
            if (wyszukiwanie.getId() == id) {
                result.add(wyszukiwanie);
            }
        }
            model.addAttribute("bodyMassIndex", result);
            return "research";
        }
    }



