package ssackdama.ssackdama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/")
    public String test(Model model){
        model.addAttribute("data","테스트 중");
        return "index";
    }

}

/*
@Controller   //해당 클래스를 컨트롤러로 동작하게 한다.
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping("/apple")    // 이 주소로 접속하면 이 메소드를 호출한다.(매핑한다.)
	public ModelAndView openBoardList() throws Exception{
		ModelAndView mv = new ModelAndView("/apple/boardList");

		List<BoardDto> list = boardService.selectBoardList(); //서비스 호출!!!!
		mv.addObject("list",list);

		return mv;
	}
}

 */