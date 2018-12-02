package com.controller;

import com.dao.CyclistDAO;
import com.dao.TeamDAO;
import com.dao.impl.CyclistDAOimpl;
import com.dao.impl.TeamDAOimpl;
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
public class CyclistController {

    @Autowired
    CyclistDAOimpl cyclistDAOimpl;

    @RequestMapping(value = "/cyclists", method = RequestMethod.GET)
    public String getCyclistsPage(Model model){
        TeamDAO teamDAO = new TeamDAOimpl();
        model.addAttribute("cyclists",cyclistDAOimpl.getCyclists());
        model.addAttribute("teamDAO",teamDAO);
        return "cyclists";
    }

    @RequestMapping(value = "/deleteCyclist", method = RequestMethod.GET, params = {"cyclistId"})
    @ResponseBody
    public ModelAndView deleteTeam(@RequestParam(value = "cyclistId") int cyclistId){
        CyclistDAO cyclistDAO = new CyclistDAOimpl();
        cyclistDAO.deleteCyclist(cyclistId);
        ModelAndView model = new ModelAndView("cyclists");
        model.addObject("cyclists",cyclistDAOimpl.getCyclists());
        return model;
    }

    @RequestMapping("/addCyclist")
    public ModelAndView showAddForm(){
        return new ModelAndView("addTeam","command", new Cyclist());
    }

    @RequestMapping(value = "/saveCyclist", method = RequestMethod.POST, params = {"team_name", "team_country"})
    @ResponseBody
    public ModelAndView addTeamPage(@RequestParam(value = "team_name") String team_name,
                                    @RequestParam(value = "team_country") String team_country) {
        CyclistDAO cyclistDAO = new CyclistDAOimpl();
        //teamDAO.createTeam(team_name,team_country);
        ModelAndView model = new ModelAndView("cyclists");
        model.addObject("cyclists", cyclistDAO.getCyclists());
        return model;
    }

}

