package com.controller;

import com.dao.BicycleDAO;
import com.dao.CyclistDAO;
import com.dao.ResultDAO;
import com.dao.TeamDAO;
import com.dao.impl.BicycleDAOimpl;
import com.dao.impl.CyclistDAOimpl;
import com.dao.impl.ResultDAOimpl;
import com.dao.impl.TeamDAOimpl;
import com.entity.Bicycle;
import com.entity.Cyclist;
import com.entity.Result;
import com.entity.Team;
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

    @RequestMapping("/addResult")
    public ModelAndView showAddForm(){
        CyclistDAO cyclistDAO = new CyclistDAOimpl();
        TeamDAO teamDAO = new TeamDAOimpl();
        ModelAndView model = new ModelAndView("addResult","command", new Result());
        model.addObject("cyclists",cyclistDAO.getCyclists());
        model.addObject("teams",teamDAO.getTeams());
        return model;
    }

    @RequestMapping(value = "/saveResult", method = RequestMethod.POST, params = {"cyclistSelector", "teamSelector", "race_type", "result_place"})
    @ResponseBody
    public ModelAndView addBicyclePage(@RequestParam(value = "cyclistSelector") String cyclist_name,
                                       @RequestParam(value = "teamSelector") String team_name,
                                       @RequestParam(value = "race_type") String race_type,
                                       @RequestParam(value = "result_place") int result_place) {
        Cyclist cyclist;
        CyclistDAO cyclistDAO = new CyclistDAOimpl();
        cyclist = ((CyclistDAOimpl) cyclistDAO).getCyclist(cyclist_name);

        Team team;
        TeamDAO teamDAO = new TeamDAOimpl();
        team = teamDAO.getTeam(team_name);

        ResultDAO resultDAO = new ResultDAOimpl();
        resultDAO.createResult(team, cyclist, race_type, result_place);
        ModelAndView model = new ModelAndView("results");
        model.addObject("results", resultDAOimpl.getResults());
        return model;
    }

    @RequestMapping(value = "/editResult", method = RequestMethod.GET, params = {"resultId"})
    @ResponseBody
    public ModelAndView showEditForm(@RequestParam(value = "resultId") int resultId){
        TeamDAO teamDAO = new TeamDAOimpl();
        CyclistDAO cyclistDAO = new CyclistDAOimpl();
        ResultDAO resultDAO = new ResultDAOimpl();

        Result result = ((ResultDAOimpl) resultDAO).getResult(resultId);
        ModelAndView model = new ModelAndView("editResult","command", new Result());
        model.addObject("resultToEdit",result);
        model.addObject("cyclists",cyclistDAO.getCyclists());
        model.addObject("teams",teamDAO.getTeams());
        return model;
    }

    @RequestMapping(value = "/updateResult", method = RequestMethod.POST, params = {"resultId", "teamSelector", "cyclistSelector", "race_type", "result_place"})
    @ResponseBody
    public ModelAndView editCyclistPage(@RequestParam(value = "resultId") int resultId,
                                        @RequestParam(value = "teamSelector") String team_name,
                                        @RequestParam(value = "cyclistSelector") String cyclist_name,
                                        @RequestParam(value = "race_type") String race_type,
                                        @RequestParam(value = "result_place") int result_place){
        TeamDAO teamDAO = new TeamDAOimpl();
        CyclistDAO cyclistDAO = new CyclistDAOimpl();
        Cyclist cyclist = cyclistDAO.getCyclist(cyclist_name);
        Team team = teamDAO.getTeam(team_name);

        ResultDAO resultDAO = new ResultDAOimpl();

        Result result = new Result(resultId, team, cyclist, race_type, result_place);
        resultDAO.updateResult(result);
        ModelAndView model = new ModelAndView("results");
        model.addObject("results",resultDAOimpl.getResults());
        return model;
    }

}
