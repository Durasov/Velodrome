package com.controller;

import com.dao.CyclistDAO;
import com.dao.TeamDAO;
import com.dao.impl.CyclistDAOimpl;
import com.dao.impl.TeamDAOimpl;
import com.entity.Cyclist;
import com.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CyclistController {

    @Autowired
    CyclistDAOimpl cyclistDAOimpl;

    @RequestMapping(value = "/cyclists", method = RequestMethod.GET)
    public String getCyclistsPage(Model model){
        model.addAttribute("cyclists",cyclistDAOimpl.getCyclists());
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
        TeamDAO teamDAO = new TeamDAOimpl();
        ModelAndView model = new ModelAndView("addCyclist","command", new Cyclist());
        model.addObject("teams",teamDAO.getTeams());
        return model;
    }

    @RequestMapping(value = "/saveCyclist", method = RequestMethod.POST, params = {"cyclist_name", "teamSelector", "cyclist_age"})
    @ResponseBody
    public ModelAndView addCyclistPage(@RequestParam(value = "cyclist_name") String cyclist_name,
                                       @RequestParam(value = "teamSelector") String team_name,
                                       @RequestParam(value = "cyclist_age") int cyclist_age) {
        Team team;
        TeamDAO teamDAO = new TeamDAOimpl();
        team = teamDAO.getTeam(team_name);

/*        String requestEnc = "ISO-8859-1";
        if(clientEnc==null) clientEnc="Cp1251";
        cyclist_name = new String(cyclist_name.getBytes(requestEnc), clientEnc);*/

        CyclistDAO cyclistDAO = new CyclistDAOimpl();
        cyclistDAO.createCyclist(team,cyclist_name,cyclist_age);
        ModelAndView model = new ModelAndView("cyclists");
        model.addObject("cyclists", cyclistDAO.getCyclists());
        return model;
    }

}

