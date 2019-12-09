package com.CoderGirl.SewingPatternStorage.controllers;


import com.CoderGirl.SewingPatternStorage.dao.SewingDAO;
import com.CoderGirl.SewingPatternStorage.model.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
//@RequestMapping("patterns")
public class PatternController {

    @Autowired
    private SewingDAO sewingDAO;

    //Request path: /patterns
    @RequestMapping(value = "/patterns", method = GET)
    public String listPatterns(Model model) {
        List<Pattern> patterns = sewingDAO.getAll();
        model.addAttribute(("patterns"), patterns);

        model.addAttribute("count", patterns.size());

        return "patternsList.html";
    }


    @RequestMapping(value = "/about")
    public String loadPatterOrganizationController() {
        return "about.html";
    }

    @GetMapping("/new")
    public String loadNewPatternsPage() {
        return "patternNew.html";
    }

    @RequestMapping(value = "/addPatterns", method = POST)
    public String saveAddNewPatterns(Model model, @RequestParam String patternCompanyAndNumber,
                                     @RequestParam String sizeRanges,
                                     @RequestParam String patternDescription,
                                     @RequestParam String patternNotes,
                                     @RequestParam String keyword) {
        model.addAttribute("patternCompanyAndNumber", patternCompanyAndNumber);
        model.addAttribute("sizeRanges", sizeRanges);
        model.addAttribute("patternDescription", patternDescription);
        model.addAttribute("patternNotes", patternNotes);
        model.addAttribute("keyword", keyword);

        System.out.println("Saved it..." + patternCompanyAndNumber + " " + " " + patternDescription +
                " " + patternNotes + " " + " " + keyword);

        sewingDAO.addPattern(new Pattern(-1, patternCompanyAndNumber, sizeRanges, patternDescription, patternNotes, keyword));

        return confirmSavedPatterns(model);
    }

    @RequestMapping(value = "/addPatterns", method = GET)
    public String confirmSavedPatterns(Model model) {
        List<Pattern> patterns = sewingDAO.getAll();
        model.addAttribute(("pattern"), patterns);

        model.addAttribute("count", patterns.size());

        return "result.html";
    }

    @RequestMapping(value = "/edit/{id}", method = GET)
    public String viewPatterns(Model model, @PathVariable int id) {
        Pattern pattern = sewingDAO.findById(id);
        model.addAttribute("pattern", pattern);

        return "patternsEdit.html";
    }

    @PostMapping("/edit/{id}")
    public String editPattern(@ModelAttribute Pattern pattern, @PathVariable int id) {
        sewingDAO.updatePattern(id, pattern);
        return "redirect:/patterns";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        model.addAttribute("keyword", keyword);
        List<Pattern> patterns = sewingDAO.findByString(keyword);
        model.addAttribute("patterns", patterns);
        return "search";
    }
}



