package com.example.sd_57_datn.Controller.Giay;

import com.example.sd_57_datn.Model.ThuongHieu;
import com.example.sd_57_datn.Model.TrongLuong;
import com.example.sd_57_datn.Repository.Giay.TrongLuongRepository;
import com.example.sd_57_datn.Service.Giay.ThuongHieuService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/trongLuong")
public class TrongLuongController {
    @Autowired
    private TrongLuongService trongLuongService;

    private TrongLuong trongLuong = new TrongLuong();

    @GetMapping()
    public String getIndex(Model model, @RequestParam(name = "page", defaultValue = "1")int page){
        Pageable pageable = PageRequest.of(page-1, 5);
        model.addAttribute("list", trongLuongService.pagination(pageable));
        return "trongLuong/index";
    }

    @GetMapping("search")
    public String search(Model model, @RequestParam(name = "page", defaultValue = "1")int page, @RequestParam("name") String name){
        Pageable pageable = PageRequest.of(page-1, 5);
        model.addAttribute("list", this.trongLuongService.search(pageable, name));
        return "trongLuong/index";
    }

    @GetMapping("create")
    public String getFormCreate(Model model){

        trongLuong.setNgayTao(LocalDate.now().toString());
        trongLuong.setNgaySua(LocalDate.now().toString());
        trongLuong.setTrangThai(1);
        model.addAttribute("tl", trongLuong);
        return "trongLuong/create";
    }

    @PostMapping("create")
    public String add(@Valid @ModelAttribute("tl") TrongLuong trongLuong, BindingResult result){
        if(result.hasErrors()){

            return "trongLuong/create";
        }

        trongLuong.setNgayTao(trongLuong.getNgayTao());
        trongLuong.setNgaySua(trongLuong.getNgaySua());
        this.trongLuongService.add(trongLuong);

        return "redirect:/trongLuong";
    }

//    @GetMapping("{id}")
//    public String delete(@PathVariable("id") UUID id){
//        this.service.delete(id);
//        return "redirect:/thuongHieu";
//    }

    @GetMapping("edit/{id}")
    public String getFormUpdate(Model model, @PathVariable("id") TrongLuong trongLuong){
        trongLuong.setNgaySua(LocalDate.now().toString());
        model.addAttribute("tl", trongLuong);
        model.addAttribute("action", "update/"+trongLuong.getId());
        return "trongLuong/edit";
    }

    @PostMapping("/edit/update/{id}")
    public String update(@Valid @ModelAttribute("tl") TrongLuong trongLuong, @PathVariable("id") UUID id, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("action", "update/"+id);
            return "trongLuong/edit";
        }

        this.trongLuongService.update(trongLuong, id);

        return "redirect:/trongLuong";
    }


}
