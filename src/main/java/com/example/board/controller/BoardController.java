package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// HTTP 요청을 받아서 응답하는 컴포넌트, 스프링 부트가 자동으로 Bean으로 생성한다.
@Controller
public class BoardController {
	// 게시물 목록을 보여준다.
	// 컨트롤러의 메소그가 리턴하는 문자열은 팀플릿 이름이다.
	// http://localhost:8092/ ----> "list"라는 이름의 템플릿을 사용(forward)하여 화면에 출력.
	// list를 리턴한다는 것은 -> classpath:/templates/list.html 파일이 필요한것.
	
	@GetMapping("/")
	public String list() {
		
		// 게시물 목록을 읽어온다. 페이징 처리
		return "list";
	}
	
	// /board?id=3 // 파라미터 id, 파라미터 id의 값은 3, board를 받는곳 
	// /board?id=2
	// /board?id=1
	@GetMapping("/board")
	public String board(@RequestParam("id") int id) {
		System.out.println("id : " + id);
		
		// id에 해당하는 게시물을 읽어온다.
		// id에 해당하는 게시물의 조회수도 1증가 해야함
		
		return "board";
	}
	
	// 삭제한다. 관리자는 모든 글을 삭제할 수 있다.
	// 수정한다.
	
	@GetMapping("writeForm")
	public String writeForm() {
		// 로그인한 사용자만 글을 작성할 수 있다. 로그인을 하지 않았다면 리스트보기로 자동으로 이동하게 만들 예정
		// 세션에서 로그인한 정보를 읽어들인다.

		
		return "writeForm";
	}
	
	// 글 작성
	@PostMapping("/write")
	public String write(
			@RequestParam("title") String title,
			@RequestParam("content") String content
		) {
		// 로그인한 사용자먼 글을 써야한다.
		// 세션에서 로그인한 정보를 읽어들인다. 로그인을 하지 않았다면 리스트보기로 자동 이동 시킨다.
		System.out.println("title : " + title );
		System.out.println("content : " + content);
		
		// 로그인 한 회원 정보 + 제목, 내용을 저장한다.
		// 글을 쓴 후에는 리스트보기로 자동 이동 시킨다.
	
		return "redirect:/"; // 리스트보기로 리다이렉트한다.
		
	}
	
	
	
}
