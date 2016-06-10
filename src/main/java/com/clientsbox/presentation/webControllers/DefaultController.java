package com.clientsbox.presentation.webControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultIndex(ModelMap model) {
        //  User mUser = _userSerice.GetUserById(0);
        //model.addAttribute("application", name);
        return "index";
    }
    
    @RequestMapping(value = "/{name:.+}", method = RequestMethod.GET)
    public String spaIndex(@PathVariable("name") String name, ModelMap model) {
        //  User mUser = _userSerice.GetUserById(0);
        model.addAttribute("application", name);
        return "index";
    }
}
