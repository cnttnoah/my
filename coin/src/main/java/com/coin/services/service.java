package com.coin.services;
import org.springframework.stereotype.Service;
import com.coin.parameters.parameter;

import java.text.DecimalFormat;

@Service
public class service{
	String t;
	DecimalFormat dc =new DecimalFormat("##,###");	// 숫자 입력 형식 표현을 위해 ex 10000 >> 10,000

	
	public parameter Service(String btn,parameter Par) {
		// TODO Auto-generated method stub
		int num=2;
		/*if(Par.getNum() != null){
			String s=Par.getNum();
			num = Integer.parseInt(s);
		}*/
		
		if(btn.equals("+")){num++;}
		
		if(btn.equals("-")) {num--;}	// POST된 버튼의 종류에 따라 K값 증감
		
		if(btn.equals("계산")) {
			if(Par.getPrice()==""||Par.getPrice()==null){// T 유효성 체크
				Par.setNum(Integer.toString(num));
				t=Par.getPrice();
				Par.setStr("입력이 유효하지 않습니다.1"); // jsp에서 출력 할 메세지
				return Par;
			}
		
			int T = Integer.parseInt(Par.getPrice());	// main.jsp의 T 값을 가져와 int 값으로 변형
			int Pi[] = new int[num+1];
			int Ni[] = new int[num+1];
			int Cnt[] = new int[num+1];	//동전 개수를 증가 시키기 위한 함수
			int temp=0;	// 잔돈들의 총합 임시 저장
			
			for(int i=0; i<num; i++){
				if(Par.getStr_P()[0]==""||Par.getStr_N()[0]==""	//유효성 체크
						||Par.getStr_P()[0]==null||Par.getStr_N()[0]==null) {
					Par.setNum(Integer.toString(num));
					Par.setStr("입력이 유효하지 않습니다.2"); // jsp에서 출력 할 메세지	
					return Par;
				}
				Pi[i] = Integer.parseInt(Par.getStr_P()[i]);	// P0, P1, P2...값을 저장
				Ni[i] = Integer.parseInt(Par.getStr_N()[i]);
			}
			while(Cnt[num]==0) {//동전 수를 Ni[i]까지 증가시키며 잔돈 계산
	    		Cnt[0]++;
	    		
	    		for(int k=0; k<num;k++){
	    			if(Cnt[k]>Ni[k]||Pi[k]*Cnt[k]>T) {
		    			Cnt[k]=0;
		    			Cnt[k+1]++;
		    		}
	    		}
	    		
	    		for(int k=0; k<num;k++) { temp=temp+Cnt[k]*Pi[k]; }//잔돈 총 합
	    		
	    		if(temp==T) {//잔돈이 지폐(T)와 일치 할 때 >> str을 이용해 결과 값에 추가해준다
	    			Par.setStr(Par.getStr()+dc.format(T)+" =");
	    			for(int k=0; k<num;k++){//경우에 따른 +, x 사용
	    				if(Cnt[k]!=0){
	    					Par.setStr(Par.getStr()+" "+dc.format(Pi[k])+" x "+dc.format(Cnt[k]));
	    					if(Cnt[k+1]!=0)
	    						Par.setStr(Par.getStr()+" +");
	    				}
	    			}
	    			Par.setStr(Par.getStr()+"<br>"); //str=str+<br>;
	    			Par.setResult(Par.getResult()+1);	//result++
	    		}    		
	    		temp=0;
			}
		}
		Par.setNum(Integer.toString(num));
		Par.setStr("총 "+Par.getResult()+"가지<br>"+Par.getStr()+"버튼 :");
		return Par;
	}
}