package com.controller;

import com.dao.CyclistDAO;
import com.dao.ResultDAO;
import com.dao.impl.CyclistDAOimpl;
import com.dao.impl.ResultDAOimpl;
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
public class ResultController {

    @Autowired
    ResultDAOimpl resultDAOimpl;

    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public String getCyclistsPage(Model model){
        model.addAttribute("results",resultDAOimpl.getResults());
        return "results";
    }

    @RequestMapping(value = "/deleteResult", method = RequestMethod.GET, params = {"resultId"})
    @ResponseBody
    public ModelAndView deleteTeam(@RequestParam(value = "resultId") int resultId){
        ResultDAO resultDAO = new ResultDAOimpl();
        resultDAO.deleteResult(resultId);
        ModelAndView model = new ModelAndView("results");
        model.addObject("results",resultDAOimpl.getResults());
        return model;
    }

}
