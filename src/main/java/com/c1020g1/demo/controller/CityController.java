package com.c1020g1.demo.controller;

import com.c1020g1.demo.model.City;
import com.c1020g1.demo.model.Nation;
import com.c1020g1.demo.service.city.ICityService;
import com.c1020g1.demo.service.nation.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private ICityService cityService;
    @Autowired
    private INationService nationService;

    @ModelAttribute("nationList")
    public List<Nation> categoryList() {
        return nationService.findAll();
    }

    @GetMapping
    public ModelAndView showAll(@PageableDefault(size = 5) Pageable pageable) {
        Page<City> list = cityService.findAll(pageable);
        return new ModelAndView("list", "list", list);
    }

    @GetMapping("/create")
    public ModelAndView showFormCreateCity(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city",new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCity(@Validated @ModelAttribute City city, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("create");

        }

        cityService.save(city);
        return new ModelAndView("redirect:/city");

    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id)  {
        ModelAndView modelAndView = new ModelAndView("edit");
        City city = cityService.findById(id);
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editCity(@ModelAttribute City city, @PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/city");
        city.setId(id);
        cityService.save(city);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteCity(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/city");
        cityService.delete(id);
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteCity (@ModelAttribute City city, @PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/city");
        cityService.delete(id);
        return modelAndView;
    }

   @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id){
       City city = cityService.findById(id);
       ModelAndView modelAndView = new ModelAndView("detail");
       modelAndView.addObject("detail",city);
       return modelAndView;
   }

}
