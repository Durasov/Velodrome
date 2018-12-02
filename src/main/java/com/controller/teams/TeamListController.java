package com.controller.teams;

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
public class TeamListController {

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

    @RequestMapping(value = "/save", method = RequestMethod.POST, params = {"team_name", "team_country"})
    @ResponseBody
    public ModelAndView addTeamPage(@RequestParam(value = "team_name") String team_name,
                                    @RequestParam(value = "team_country") String team_country){
        TeamDAO teamDAO = new TeamDAOimpl();
        teamDAO.createTeam(team_name,team_country);
        ModelAndView model = new ModelAndView("teams");
        model.addObject("teams",teamDAOimpl.getTeams());
        return model;
    }

}
