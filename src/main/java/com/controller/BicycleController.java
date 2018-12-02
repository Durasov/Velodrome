package com.controller;

import com.dao.BicycleDAO;
import com.dao.CyclistDAO;
import com.dao.impl.BicycleDAOimpl;
import com.dao.impl.CyclistDAOimpl;
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

}

