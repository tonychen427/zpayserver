package com.clientsbox.presentation.webControllers;

import com.clientsbox.core.model.User;
import com.clientsbox.logic.services.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

    @Autowired
    IUserService _userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultIndex(ModelMap model) {
        //  User mUser = _userSerice.GetUserById(0);
        //model.addAttribute("application", name);
        return "index";
    }

    @RequestMapping(value = "/{name:.+}", method = RequestMethod.GET)
    public ModelAndView spaIndex(@PathVariable("name") String appName, ModelMap model) {
        //  User mUser = _userSerice.GetUserById(0);
        model.addAttribute("application", appName);
        List<User> mUser = _userService.getUsers();
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName(appName);
        modelView.addObject("users", mUser);

        return modelView;
    }

//    @RequestMapping(value = "/dashboard/", method = RequestMethod.GET)
//    public ModelAndView zpayIndex() {
//
//        List<User> mUser = _userService.getUsers();
//        ModelAndView modelView = new ModelAndView();
//        modelView.setViewName("dashboard");
//        modelView.addObject("users", mUser);
//        return modelView;
//    }
}
