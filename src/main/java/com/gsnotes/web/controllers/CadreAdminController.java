package com.gsnotes.web.controllers;

import com.gsnotes.bo.Module;
import com.gsnotes.bo.*;
import com.gsnotes.web.models.*;
import org.slf4j.Logger;
import com.gsnotes.services.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.gsnotes.utils.export.ExcelExporter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/cadreadmin")
public class CadreAdminController {
    @Autowired
    private IEnseignantService enseignantService;
    @Autowired
    private IFiliereService filiereService;
    @Autowired
    private  IModuleService moduleService;
    @Autowired
    private IElementService elementService;
    @Autowired
    private INiveauService niveauService;
    @Autowired
    private HttpSession httpSession;

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    public CadreAdminController() {
    }

    @RequestMapping(value = "formFiliere", method = RequestMethod.GET)
    public String formFiliere(Model model) {
        FiliereModel fm = new FiliereModel();
        model.addAttribute("filiereModel", fm);
        List<Filiere> filieres = filiereService.getAllFilieres();
        List<FiliereModel> modelFiliere = new ArrayList<FiliereModel>();
        for (int i = 0; i < filieres.size(); i++) {
            FiliereModel filiereModel = new FiliereModel();
            BeanUtils.copyProperties((Filiere) filieres.get(i), filiereModel);
            modelFiliere.add(filiereModel);
        }
        model.addAttribute("enseignantList",enseignantService.getAllEnseignants());
        model.addAttribute("filiereList", modelFiliere);
        return "cadreadmin/formFiliere";
    }


    @RequestMapping(value = "formModule", method = RequestMethod.GET)
    public String showFormModule(Model model) {
        ModuleModel mm = new ModuleModel();
        model.addAttribute("moduleModel", mm);
        List<Module> modules = moduleService.getAllModules();
        List<ModuleModel> modelModules = new ArrayList<ModuleModel>();
        for (int i = 0; i < modules.size(); i++) {
            ModuleModel moduleModel = new ModuleModel();
            BeanUtils.copyProperties((Module) modules.get(i), moduleModel);
            modelModules.add(moduleModel);
        }
        model.addAttribute("niveauList",niveauService.getAllNiveaus());
        model.addAttribute("enseignantList",enseignantService.getAllEnseignants());
        model.addAttribute("moduleList", modelModules);
        return "cadreadmin/formModule";
    }



    @RequestMapping(value = "formElement", method = RequestMethod.GET)
    public String formElement(Model model) {
        ElementModel em = new ElementModel();
        model.addAttribute("elementModel", em);
        List<Element> elements = elementService.getAllElements();
        List<ElementModel> modelElementes = new ArrayList<ElementModel>();
        for (int k = 0; k < elements.size(); k++) {
            ElementModel elementModel = new ElementModel();
            BeanUtils.copyProperties((Element) elements.get(k), elementModel);
            modelElementes.add(elementModel);
        }
        model.addAttribute("moduleList",moduleService.getAllModules());
        model.addAttribute("elementList", modelElementes);
        return "cadreadmin/formElement";
    }

    @RequestMapping(value = "formNiveau", method = RequestMethod.GET)
    public String formNiveau(Model model) {
        NiveauModel nm = new NiveauModel();
        model.addAttribute("niveauModel", nm);
        List<Niveau> niveaux = niveauService.getAllNiveaus();
        List<NiveauModel> modelNiveaux = new ArrayList<NiveauModel>();
        for (int j = 0; j < niveaux.size(); j++) {
            NiveauModel niveauModel = new NiveauModel();
            BeanUtils.copyProperties((Niveau) niveaux.get(j), niveauModel);
            modelNiveaux.add(niveauModel);
        }
        model.addAttribute("filiereList",filiereService.getAllFilieres());
        model.addAttribute("niveauList", modelNiveaux);
        return "cadreadmin/formNiveau";
    }


    @RequestMapping(value = "addNiveau", method = RequestMethod.POST)
    public String process(@Valid @ModelAttribute("niveauModel") NiveauModel niveau, BindingResult bindingResult,
                          Model model, HttpServletRequest rq) {
        if (bindingResult.hasErrors()) {
            return "cadreadmin/formNiveau";
        }
        Niveau niv = new Niveau();
        BeanUtils.copyProperties(niveau, niv);
        niveauService.addNiveau(niv);
        return "redirect:/cadreadmin/formNiveau";
    }

    @RequestMapping(value = "addFiliere", method = RequestMethod.POST)
    public String process(@Valid @ModelAttribute("filiereModel")
                                  FiliereModel filiere,
                          BindingResult bindingResult,
                          Model model, HttpServletRequest rq) {
        if (bindingResult.hasErrors()) {
            return "formFiliere";
        }
        Filiere filiere1 = new Filiere();
        BeanUtils.copyProperties(filiere, filiere1);
        filiereService.addFiliere(filiere1);
        return "redirect:/cadreadmin/formFiliere";
    }


    @RequestMapping(value = "addElement", method = RequestMethod.POST)
    public String addElement(@Valid @ModelAttribute("elementModel") ElementModel elementModel, BindingResult bindingResult,
                          Model model, HttpServletRequest rq) {
        if (bindingResult.hasErrors()) {
            return "cadreadmin/formElement";
        }
        Element elmt = new Element();
        BeanUtils.copyProperties(elementModel, elmt);
        elementService.addElement(elmt);
        return "redirect:/cadreadmin/formElement";
    }

    @RequestMapping(value = "addModule", method = RequestMethod.POST)
    public String addModule(@Valid @ModelAttribute("moduleModel")
                                        ModuleModel module,
                                        BindingResult bindingResult,
                                        Model model, HttpServletRequest rq) {
        if (bindingResult.hasErrors()) {
            return "cadreadmin/formModule";
        }
        Module module1 = new Module();
        BeanUtils.copyProperties(module, module1);
        moduleService.addModule(module1);
        return "redirect:/cadreadmin/formModule";
    }


    @RequestMapping(value = "deleteNiveau/{idNiveau}", method = RequestMethod.GET)
    public String deleteNiveau(@PathVariable int idNiveau) {
        niveauService.deleteNiveau(Long.valueOf(idNiveau));
        return "redirect:/cadreadmin/formNiveau";
    }

    @RequestMapping(value = "deleteModule/{idModule}", method = RequestMethod.GET)
    public String deleteModule(@PathVariable int idModule) {
        moduleService.deleteModule(Long.valueOf(idModule));
        return "redirect:/cadreadmin/formModule";
    }


    @RequestMapping(value = "deleteElement/{idMatiere}", method = RequestMethod.GET)
    public String deleteElement(@PathVariable int idMatiere) {
        elementService.deleteElement(Long.valueOf(idMatiere));
        return "redirect:/cadreadmin/formElement";
    }


    @RequestMapping(value = "deleteFiliere/{idFiliere}", method = RequestMethod.GET)
    public String delete(@PathVariable int idFiliere) {
        filiereService.deleteFiliere(Long.valueOf(idFiliere));
        return "redirect:/cadreadmin/formFiliere";
    }


    @RequestMapping(path = "updateModuleForm/{idModule}", method = RequestMethod.GET)
    public ModelAndView updateModuleForm(@PathVariable int idModule, Model model) {
        Module m = moduleService.getModuleById(Long.valueOf(idModule));
        ModuleModel moduleModel = new ModuleModel();
        BeanUtils.copyProperties(m, moduleModel);
        model.addAttribute("niveauList",niveauService.getAllNiveaus());
        model.addAttribute("moduleModel", moduleModel);
        model.addAttribute("moduleList",moduleService.getAllModules());
        model.addAttribute("enseignantList",enseignantService.getAllEnseignants());

        return new ModelAndView("cadreadmin/updateModule","moduleModel",moduleModel);
    }


    @RequestMapping(path = "updateNiveauForm/{idNiveau}", method = RequestMethod.GET)
    public ModelAndView updateNiveauForm(@PathVariable int idNiveau, Model model) {
        Niveau niveau = niveauService.getNiveauById(Long.valueOf(idNiveau));
        NiveauModel nm = new NiveauModel();
        BeanUtils.copyProperties(niveau, nm);
        model.addAttribute("niveauModel", nm);
        model.addAttribute("filiereList",filiereService.getAllFilieres());
        return new ModelAndView("cadreadmin/updateNiveau","niveauModel",nm);
    }

    @RequestMapping("updateModule")
    public String updatePerson(@Valid @ModelAttribute("moduleModel")
                                       ModuleModel moduleModel,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            return "cadreadmin/updateModule";
        }
        System.out.println(moduleModel.toString());
        Module module = new Module();
        BeanUtils.copyProperties(moduleModel, module);
        moduleService.updateModule(module);
        model.addAttribute("msg", "Opération effectuée avec succès");
        return "cadreadmin/updateModule";
    }


    @RequestMapping("updateNiveau")
    public String updateNiveau(@Valid @ModelAttribute("niveauModel")
                                           NiveauModel niveauModel,
                                            BindingResult bindingResult,
                                            Model model) {
        if (bindingResult.hasErrors()) {
            return "cadreadmin/updateNiveau";
        }
        System.out.println(niveauModel.getIdNiveau());
        Niveau niveau = new Niveau();
        BeanUtils.copyProperties(niveauModel, niveau);
        niveauService.updateNiveau(niveau);
        model.addAttribute("msg", "Opération effectuée avec succès");
        return "cadreadmin/updateNiveau";
    }


    @RequestMapping("updateElement")
    public String update(@Valid @ModelAttribute("elementModel")
                                     ElementModel elementModel,
                                    BindingResult bindingResult,
                                    Model model) {
        if (bindingResult.hasErrors()) {
            return "cadreadmin/updateElement";
        }
        System.out.println(elementModel.toString());
        Element elmt = new Element();
        BeanUtils.copyProperties(elementModel,elmt);
        model.addAttribute("moduleList",moduleService.getAllModules());
        elementService.updateElement(elmt);
        model.addAttribute("msg", "Opération effectuée avec succès");
        return "cadreadmin/updateElement";
    }

    @RequestMapping(path = "updateElementForm/{idMatiere}", method = RequestMethod.GET)
    public ModelAndView updateElementForm(@PathVariable int idMatiere, Model model) {
        Element elmt = elementService.getElementById(Long.valueOf(idMatiere));
        ElementModel elementModel = new ElementModel();
        BeanUtils.copyProperties(elmt, elementModel);
        model.addAttribute("moduleList",moduleService.getAllModules());
        model.addAttribute("elementModel", elementModel);
        return new ModelAndView("cadreadmin/updateElement","elementModel",elementModel);
    }


    @RequestMapping(path = "updateFiliereForm/{idFiliere}", method = RequestMethod.GET)
    public ModelAndView updatePersonForm(@PathVariable int idFiliere, Model model) {
        Filiere filiere = filiereService.getFiliereById(Long.valueOf(idFiliere));
        FiliereModel fm = new FiliereModel();
        BeanUtils.copyProperties(filiere, fm);
        model.addAttribute("filiereModel", fm);
        model.addAttribute("enseignantList",enseignantService.getAllEnseignants());
        return new ModelAndView("cadreadmin/updateFiliere","filiereModel",fm);
    }


    @RequestMapping("updateFiliere")
    public String updateModule(@Valid @ModelAttribute("filiereModel") FiliereModel filiereModel, BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            return "cadreadmin/updateFiliere";
        }
        System.out.println(filiereModel.toString());
        Filiere filiere = new Filiere();
        BeanUtils.copyProperties(filiereModel, filiere);
        filiereService.updateFiliere(filiere);
        model.addAttribute("msg", "Opération effectuée avec succès");
        return "cadreadmin/updateFiliere";
    }

}

