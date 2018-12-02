package com.controller;

import com.dao.TeamDAO;
import com.dao.impl.TeamDAOimpl;
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
public class TeamController {

    @Autowired
    TeamDAOimpl teamDAOimpl;

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public String getTeamsPage(Model model){
        model.addAttribute("teams",teamDAOimpl.getTeams());
        return "teams";
    }

    @RequestMapping(value = "/deleteTeam", method = RequestMethod.GET, params = {"teamId"})
    @ResponseBody
    public ModelAndView deleteTeam(@RequestParam(value = "teamId") int teamId){
        TeamDAO teamDAO = new TeamDAOimpl();
        ((TeamDAOimpl) teamDAO).deleteTeam(teamId);
        ModelAndView model = new ModelAndView("teams");
        model.addObject("teams",teamDAOimpl.getTeams());
        return model;
    }

    @RequestMapping("/addTeam")
    public ModelAndView showAddForm(){
        return new ModelAndView("addTeam","command", new Team());
    }

    @RequestMapping(value = "/saveTeam", method = RequestMethod.POST, params = {"team_name", "team_country"})
    @ResponseBody
    public ModelAndView addTeamPage(@RequestParam(value = "team_name") String team_name,
                                    @RequestParam(value = "team_country") String team_country){
        TeamDAO teamDAO = new TeamDAOimpl();
        teamDAO.createTeam(team_name,team_country);
        ModelAndView model = new ModelAndView("teams");
        model.addObject("teams",teamDAOimpl.getTeams());
        return model;
    }

    @RequestMapping(value = "/editTeam", method = RequestMethod.GET, params = {"teamId"})
    @ResponseBody
    public ModelAndView showEditForm(@RequestParam(value = "teamId") int teamId){
        Team team;
        TeamDAO teamDAO = new TeamDAOimpl();
        team = teamDAO.getTeam(teamId);
        ModelAndView model = new ModelAndView("editTeam","command", new Team());
        model.addObject("teamToEdit",team);
        //return new ModelAndView("editTeam","command", new Team());
        return model;
    }

    @RequestMapping(value = "/updateTeam", method = RequestMethod.POST, params = {"team_name", "team_country"})
    @ResponseBody
    public ModelAndView editTeamPage(@RequestParam(value = "team_name") String team_name,
                                    @RequestParam(value = "team_country") String team_country){
        TeamDAO teamDAO = new TeamDAOimpl();
        Team team = new Team(team_name,team_country);
        ((TeamDAOimpl) teamDAO).updateTeam(team);
        ModelAndView model = new ModelAndView("teams");
        model.addObject("teams",teamDAOimpl.getTeams());
        return model;
    }

}
