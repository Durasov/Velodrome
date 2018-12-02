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

    @RequestMapping(value = "/saveBicycle", method = RequestMethod.POST, params = {"cyclist_name", "teamSelector", "cyclist_age"})
    @ResponseBody
    public ModelAndView addBicyclePage(@RequestParam(value = "cyclist_name") String cyclist_name,
                                    @RequestParam(value = "teamSelector") String team_name,
                                    @RequestParam(value = "cyclist_age") int cyclist_age) {
        Cyclist cyclist;
        CyclistDAO cyclistDAO = new CyclistDAOimpl();
        //cyclist = cyclistDAO.getTeam(team_name);
        BicycleDAO bicycleDAO = new BicycleDAOimpl();
        //bicycleDAO.createBicycle(team.getTeamId(),cyclist_name,cyclist_age);
        ModelAndView model = new ModelAndView("cyclists");
        model.addObject("cyclists", cyclistDAO.getCyclists());
        return model;
    }

}

