package com.controller;

import com.dao.BicycleDAO;
import com.dao.CyclistDAO;
import com.dao.impl.BicycleDAOimpl;
import com.dao.impl.CyclistDAOimpl;
import com.entity.Bicycle;
import com.entity.Cyclist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BicycleController {

    @Autowired
    BicycleDAOimpl bicycleDAOimpl;

    @RequestMapping(value = "/bicycles", method = RequestMethod.GET)
    public String getCyclistsPage(Model model){
        model.addAttribute("bicycles",bicycleDAOimpl.getBicycles());
        return "bicycles";
    }

    @RequestMapping(value = "/deleteBicycle", method = RequestMethod.GET, params = {"bicycleId"})
    @ResponseBody
    public ModelAndView deleteTeam(@RequestParam(value = "bicycleId") int bicycleId){
        BicycleDAO bicycleDAO = new BicycleDAOimpl();
        bicycleDAO.deleteBicycle(bicycleId);
        ModelAndView model = new ModelAndView("bicycles");
        model.addObject("bicycles",bicycleDAOimpl.getBicycles());
        return model;
    }

    @RequestMapping("/addBicycle")
    public ModelAndView showAddForm(){
        CyclistDAO cyclistDAO = new CyclistDAOimpl();
        ModelAndView model = new ModelAndView("addBicycle","command", new Bicycle());
        model.addObject("cyclists",cyclistDAO.getCyclists());
        return model;
    }

    @RequestMapping(value = "/saveBicycle", method = RequestMethod.POST, params = {"cyclistSelector", "bicycle_name", "bicycle_material", "bicycle_weight"})
    @ResponseBody
    public ModelAndView addBicyclePage(@RequestParam(value = "cyclistSelector") String cyclist_name,
                                       @RequestParam(value = "bicycle_name") String bicycle_name,
                                       @RequestParam(value = "bicycle_material") String bicycle_material,
                                       @RequestParam(value = "bicycle_weight") byte bicycle_weight) {
        Cyclist cyclist;
        CyclistDAO cyclistDAO = new CyclistDAOimpl();
        cyclist = ((CyclistDAOimpl) cyclistDAO).getCyclist(cyclist_name);
        BicycleDAO bicycleDAO = new BicycleDAOimpl();
        bicycleDAO.createBicycle(cyclist,bicycle_name,bicycle_material,bicycle_weight);
        ModelAndView model = new ModelAndView("bicycles");
        model.addObject("bicycles", bicycleDAO.getBicycles());
        return model;
    }

    @RequestMapping(value = "/editBicycle", method = RequestMethod.GET, params = {"bicycleId"})
    @ResponseBody
    public ModelAndView showEditForm(@RequestParam(value = "bicycleId") int bicycleId){
        BicycleDAO bicycleDAO = new BicycleDAOimpl();
        CyclistDAO cyclistDAO = new CyclistDAOimpl();
        Bicycle bicycle = ((BicycleDAOimpl) bicycleDAO).getBicycle(bicycleId);
        ModelAndView model = new ModelAndView("editBicycle","command", new Bicycle());
        model.addObject("bicycleToEdit",bicycle);
        model.addObject("cyclists",cyclistDAO.getCyclists());
        return model;
    }

    @RequestMapping(value = "/updateBicycle", method = RequestMethod.POST, params = {"bicycleId", "cyclistSelector", "bicycle_name", "bicycle_material", "bicycle_weight"})
    @ResponseBody
    public ModelAndView editCyclistPage(@RequestParam(value = "bicycleId") int bicycleId,
                                        @RequestParam(value = "cyclistSelector") String cyclist_name,
                                        @RequestParam(value = "bicycle_name") String bicycle_name,
                                        @RequestParam(value = "bicycle_material") String bicycle_material,
                                        @RequestParam(value = "bicycle_weight") byte bicycle_weight){
        BicycleDAO bicycleDAO = new BicycleDAOimpl();
        CyclistDAO cyclistDAO = new CyclistDAOimpl();
        Cyclist cyclist = cyclistDAO.getCyclist(cyclist_name);
        Bicycle bicycle = new Bicycle(bicycleId, cyclist, bicycle_name, bicycle_material, bicycle_weight);
        bicycleDAO.updateBicycle(bicycle);
        ModelAndView model = new ModelAndView("bicycles");
        model.addObject("bicycles",bicycleDAOimpl.getBicycles());
        return model;
    }

}

