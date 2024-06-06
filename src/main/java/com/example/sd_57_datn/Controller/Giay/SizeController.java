package com.example.sd_57_datn.Controller.Giay;

import com.example.sd_57_datn.Model.Size;
import com.example.sd_57_datn.Model.TrongLuong;
import com.example.sd_57_datn.Repository.Giay.SizeRepository;
import com.example.sd_57_datn.Service.Giay.SizeService;
import com.example.sd_57_datn.Service.Giay.TrongLuongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("/size")

public class SizeController {

    @Autowired
    private SizeService sizeService;

    private Size size = new Size();

    @GetMapping()
    public String getIndex(Model model, @RequestParam(name = "page", defaultValue = "1")int page){
        Pageable pageable = PageRequest.of(page-1, 5);
        model.addAttribute("list", sizeService.pagination(pageable));
        return "size/index";
    }

    @GetMapping("search")
    public String search(Model model, @RequestParam(name = "page", defaultValue = "1")int page, @RequestParam("name") String name){
        Pageable pageable = PageRequest.of(page-1, 5);
        model.addAttribute("list", this.sizeService.search(pageable, name));
        return "size/index";
    }

    @GetMapping("create")
    public String getFormCreate(Model model){

        size.setNgayTao(LocalDate.now().toString());
        size.setNgaySua(LocalDate.now().toString());
        size.setTrangThai(1);
        model.addAttribute("s", size);
        return "size/create";
    }

    @PostMapping("create")
    public String add(@Valid @ModelAttribute("s") Size size, BindingResult result){
        if(result.hasErrors()){

            return "size/create";
        }

        size.setNgayTao(size.getNgayTao());
        size.setNgaySua(size.getNgaySua());
        this.sizeService.add(size);

        return "redirect:/size";
    }

//    @GetMapping("{id}")
//    public String delete(@PathVariable("id") UUID id){
//        this.service.delete(id);
//        return "redirect:/thuongHieu";
//    }

    @GetMapping("edit/{id}")
    public String getFormUpdate(Model model, @PathVariable("id") Size size){
        size.setNgaySua(LocalDate.now().toString());
        model.addAttribute("s", size);
        model.addAttribute("action", "update/"+size.getId());
        return "size/edit";
    }

    @PostMapping("/edit/update/{id}")
    public String update(@Valid @ModelAttribute("s") TrongLuong trongLuong, @PathVariable("id") UUID id, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("action", "update/"+id);
            return "size/edit";
        }

        this.sizeService.update(size, id);

        return "redirect:/size";
    }


}
