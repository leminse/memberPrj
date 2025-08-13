package kr.hs.study.memberPrj.controller;

import jakarta.servlet.http.HttpSession;
import kr.hs.study.memberPrj.dto.memDTO;
import kr.hs.study.memberPrj.entity.memEntity;
import kr.hs.study.memberPrj.repository.memRepository;
import kr.hs.study.memberPrj.service.memService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class testController {

    @Autowired
    private memService service;

    @GetMapping("/input_signup")
    public String input(){
        return "signup";
    }

    @GetMapping("/input_login")
    public String login(Model model){
        model.addAttribute("dto", new memDTO());
        return "login";
    }

    @PostMapping("/signup")
    public String signup(memDTO dto){
        service.signup(dto);
        return "signup";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute ("dto") memDTO dto, HttpSession session, Model model){
        Optional<memEntity> optionalUser = service.findByEmail(dto.getEmail());

        if (optionalUser.isPresent()) {
            memEntity user = optionalUser.get();

            if (user.getPass().equals(dto.getPass())) {
                // 로그인 성공: 세션에 사용자 정보 저장
                session.setAttribute("loginUser", user);
                return "home"; // 로그인 후 이동할 페이지
            }
        }

        // 로그인 실패
        model.addAttribute("error", "이메일 또는 비밀번호가 올바르지 않습니다.");
        return "login";
    }
}
