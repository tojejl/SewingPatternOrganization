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
    public String saveAddNewPatterns(Model model, @RequestParam String patternCompany,
                                     @RequestParam String patternNumber,
                                     @RequestParam String sizeRanges,
                                     @RequestParam String patternDescription,
                                     @RequestParam String patternNotes,
                                     @RequestParam String keyword) {
        model.addAttribute("patternCompany", patternCompany);
        model.addAttribute("patternNumber", patternNumber);
        model.addAttribute("sizeRanges", sizeRanges);
        model.addAttribute("patternDescription", patternDescription);
        model.addAttribute("patternNotes", patternNotes);
        model.addAttribute("keyword", keyword);

        System.out.println("Saved it..." + patternCompany + " " + " " + patternNumber +
                " " + " " + sizeRanges + " " + " " + patternDescription +
                " " + patternNotes + " " + " " + keyword);

        sewingDAO.addPattern(new Pattern(-1, patternCompany, patternNumber, sizeRanges, patternDescription, patternNotes, keyword));

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

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        model.addAttribute("keyword", keyword);
        List<Pattern> patterns = sewingDAO.findByString(keyword);
        model.addAttribute("patterns", patterns);
        return "search";
    }
}


    /*@RequestMapping("/new")
    public String addNewPattern(Model model, @RequestParam String patternInfo){
        System.out.println("Adding New Pattern: " + patternInfo);

        patterns.add(new PatternInfo(patternInfo, null, null, null, null, null));
        return "redirect:";

    }
     */


    /*public PatternController(){
        patterns = new ArrayList<PatternInfo>();
        patterns.add(new PatternInfo("Simplicity W2341", null, null, null, null, null));
    }

     */
