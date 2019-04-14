package com.coin.controllers;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.text.DecimalFormat;

@Controller
public class MainController {
	int K=1; // 동전의 가지 수  >> 1로 초기값 설정
	
	@RequestMapping(value="/main", method = {RequestMethod.GET,RequestMethod.POST}) // GET방식과 POST방식이 가능하게 해둔다
	public String main(Locale locale,Model model,HttpServletRequest request) {
		int result=0;  // 교환하는 방법의 가지 수 >> 0초기화
		String str=""; // 출력 할 결과   >> 초기화
		
		DecimalFormat dc =new DecimalFormat("##,###");	// 숫자 입력 형식 표현을 위해 ex 10000 >> 10,000
		if (request.getMethod().equals("POST")) {
			if (request.getParameter("action").equals("+")) {K++;}	// 버튼이 POST 방식으로 전달되면 버튼의 name과 value가 함께 온다 이를 이용한 버튼 상호 작용
			if (request.getParameter("action").equals("-")&&K>1) {K--;}	// POST된 버튼의 종류에 따라 K값 증감
			
			if(request.getParameter("action").equals("계산")) {
				if(request.getParameter("T")==""||request.getParameter("T")==null){// T 유효성 체크
					request.setAttribute("KK", String.valueOf(K));	// K값을 main.jsp로 전달해주기 위해
					model.addAttribute("result","입력이 유효하지 않습니다."); // jsp에서 출력 할 메세지
					return "main";
				}
				
				int T = Integer.parseInt(request.getParameter("T"));	// main.jsp의 T 값을 가져와 int 값으로 변형
				int Pi[] = new int[K+1];
				int Ni[] = new int[K+1];
				int Cnt[] = new int[K+1];	//동전 개수를 증가 시키기 위한 함수
				int temp=0;	// 잔돈들의 총합 임시 저장
				
				for(int i=0; i<K; i++){
					String str_P="P"+i;	//P0 , P1 , P2... 값을 가져오기 위해
					String str_N="N"+i;
					
					if(request.getParameter(str_N)==""||request.getParameter(str_P)==""	//유효성 체크
							||request.getParameter(str_N)==null||request.getParameter(str_P)==null) {
						request.setAttribute("KK", String.valueOf(K));
						model.addAttribute("result","입력이 유효하지 않습니다.");
						return "main";
					}
					Pi[i] = Integer.parseInt(request.getParameter(str_P));	// P0, P1, P2...값을 저장
					Ni[i] = Integer.parseInt(request.getParameter(str_N));
				}
				while(Cnt[K]==0) {//동전 수를 Ni[i]까지 증가시키며 잔돈 계산
		    		Cnt[0]++;
		    		
		    		for(int k=0; k<K;k++){
		    			if(Cnt[k]>Ni[k]||Pi[k]*Cnt[k]>T) {
			    			Cnt[k]=0;
			    			Cnt[k+1]++;
			    		}
		    		}
		    		
		    		for(int k=0; k<K;k++) { temp=temp+Cnt[k]*Pi[k]; }//잔돈 총 합
		    		
		    		if(temp==T) {//잔돈이 지폐(T)와 일치 할 때 >> str을 이용해 결과 값에 추가해준다
		    			str=str+dc.format(T)+" =";
		    			for(int k=0; k<K;k++){//경우에 따른 +, x 사용
		    				if(Cnt[k]!=0){
		    					str=str+" "+dc.format(Pi[k])+" x "+dc.format(Cnt[k]);
		    					if(Cnt[k+1]!=0)
			    					str=str+" +";
		    				}
		    			}
		    			str=str+"<br>";
		    			result++;
		    		}    		
		    		temp=0;
		        }
				K=1; // 동전 가지수와 입력 양식을 1개 다시 초기화 
				model.addAttribute("result", "총 "+result+"가지");
			}
		}
		request.setAttribute("KK", String.valueOf(K));
		model.addAttribute("str", str);	// 결과값 전달
		return "main";	
	}
}
