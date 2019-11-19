package com.CoderGirl.SewingPatternStorage.controllers;


import com.CoderGirl.SewingPatternStorage.model.PatternInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("patterns")
public class PatternController {

    private static List<PatternInfo> patterns;

    public PatternController(){
        patterns = new ArrayList<PatternInfo>();
        patterns.add(new PatternInfo("Simplicity W2341", null, null));
    }

    @RequestMapping("/about")
    public String loadPatterOrganizationController() {
        return "about.html";
    }

    @RequestMapping("")
    public String loadpatterns(Model model){
        System.out.println("Loading Patterns");

        model.addAttribute("patterns", patterns);
        model.addAttribute("count", 27);
        return "patternsList.html";
    }

    @RequestMapping("/new")
    public String addNewPattern(Model model, @RequestParam String patternInfo){
        System.out.println("Adding New Pattern: " + patternInfo);

        patterns.add(new PatternInfo(patternInfo, null, null));
        return "redirect:";
    }







}
