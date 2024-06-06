package com.example.sd_57_datn.Controller.Giay;

import com.example.sd_57_datn.Model.ChatLieu;
import com.example.sd_57_datn.Service.Giay.ChatLieuService;
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
@RequestMapping("chatLieu")
public class ChatLieuController {

   @Autowired
   ChatLieuService chatLieuService;

    private ChatLieu chatLieu = new ChatLieu();

    @GetMapping()
    public String getIndex(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        model.addAttribute("list", this.chatLieuService.pagination(pageable));
        model.addAttribute("read", "chatLieu?");
        return "/ChatLieu/index";
    }

    @GetMapping("search")
    public String search(Model model, @RequestParam(name = "page", defaultValue = "1") int page,
                         @RequestParam("name") String name) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        model.addAttribute("list", this.chatLieuService.search(pageable, name));
        model.addAttribute("read", "chatLieu/search?name=" + name + "&");
        return "ChatLieu/index";
    }

    @GetMapping("create")
    public String getFormCreate(Model model) {

        chatLieu.setNgayTao(LocalDate.now().toString());
        chatLieu.setNgaySua(LocalDate.now().toString());
        chatLieu.setTrangThai(1);
        model.addAttribute("cl", chatLieu);
        return "ChatLieu/create";
    }

    // @GetMapping("{id}")
    // public String delete(@PathVariable("id") UUID id){
    // this.service.delete(id);
    // return "redirect:/deGiay";
    // }

    @PostMapping("create")
    public String add(@Valid @ModelAttribute("cl") ChatLieu chatLieu, BindingResult result) {
        if (result.hasErrors()) {

            return "ChatLieu/create";
        }

        chatLieu.setNgayTao(chatLieu.getNgayTao());
        chatLieu.setNgaySua(chatLieu.getNgaySua());
        this.chatLieuService.add(chatLieu);

        return "redirect:/chatLieu";
    }

    @GetMapping("edit/{id}")
    public String getFormUpdate(Model model, @PathVariable("id") ChatLieu chatLieu) {
        chatLieu.setNgaySua(LocalDate.now().toString());
        model.addAttribute("cl", chatLieu);
        model.addAttribute("action", "update/" + chatLieu.getId());
        return "ChatLieu/edit";
    }

    @PostMapping("/edit/update/{id}")
    public String update(@ModelAttribute("cl") ChatLieu chatLieu, @PathVariable("id") UUID id) {

        this.chatLieuService.update(chatLieu, id);

        return "redirect:/chatLieu";
    }

}


