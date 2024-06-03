package com.example.sd_57_datn.Controller.Giay;

import com.example.sd_57_datn.Model.DeGiay;
import com.example.sd_57_datn.Model.KieuBuoc;
import com.example.sd_57_datn.Service.Giay.DeGiayService;
import com.example.sd_57_datn.Service.Giay.KieuBuocService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;
@Controller
@RequestMapping("kieuBuoc")
public class KieuBuocController {
    @Autowired
    private KieuBuocService service;

    private KieuBuoc kieuBuoc = new KieuBuoc();

    @GetMapping()
    public String getIndex(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        model.addAttribute("list", this.service.pagination(pageable));
        model.addAttribute("read", "kieuBuoc?");
        return "/kieuBuoc/index";
    }

    @GetMapping("search")
    public String search(Model model, @RequestParam(name = "page", defaultValue = "1") int page,
                         @RequestParam("name") String name) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        model.addAttribute("list", this.service.search(pageable, name));
        model.addAttribute("read", "kieuBuoc/search?name=" + name + "&");
        return "kieuBuoc/index";
    }

    @GetMapping("create")
    public String getFormCreate(Model model) {

        kieuBuoc.setNgayTao(LocalDate.now().toString());
        kieuBuoc.setNgaySua(LocalDate.now().toString());
        kieuBuoc.setTrangThai(1);
        model.addAttribute("kb", kieuBuoc);
        return "kieuBuoc/create";
    }

    // @GetMapping("{id}")
    // public String delete(@PathVariable("id") UUID id){
    // this.service.delete(id);
    // return "redirect:/deGiay";
    // }

    @PostMapping("create")
    public String add(@Valid @ModelAttribute("kb") KieuBuoc kieuBuoc, BindingResult result) {
        if (result.hasErrors()) {

            return "kieuBuoc/create";
        }

        kieuBuoc.setNgayTao(kieuBuoc.getNgayTao());
        kieuBuoc.setNgaySua(kieuBuoc.getNgaySua());
        this.service.add(kieuBuoc);

        return "redirect:/kieuBuoc";
    }

    @GetMapping("edit/{id}")
    public String getFormUpdate(Model model, @PathVariable("id") KieuBuoc kieuBuoc) {
        kieuBuoc.setNgaySua(LocalDate.now().toString());
        model.addAttribute("kb", kieuBuoc);
        model.addAttribute("action", "update/" + kieuBuoc.getId());
        return "kieuBuoc/edit";
    }

    @PostMapping("/edit/update/{id}")
    public String update(@ModelAttribute("kb") KieuBuoc kieuBuoc, @PathVariable("id") UUID id) {

        this.service.update(kieuBuoc, id);

        return "redirect:/kieuBuoc";
    }

}

