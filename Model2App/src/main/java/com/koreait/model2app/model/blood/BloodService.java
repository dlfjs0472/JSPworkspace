package com.koreait.model2app.model.blood;

//공통 로직을 처리하기 위한 클래스 (웹이건 응용이건 상관없이 중립적으로 처리가 가능한 수준)
public class BloodService {
	
	
	//웹이건 응용이건 이 메서드를 호출하는 자는 혈액형을 넘기면, 알아서 판단하여 결과 반환
	public String getAdvice(String blood) {
		String msg=null;
		   //넘겨받은 혈액형에 대한 판단 결과 도출
		   if(blood.equals("A형")){
		      msg="소심";
		   }else if(blood.equals("B형")){
		      msg="고집";
		   }else if(blood.equals("O형")){
		      msg="오지랖";
		   }else if(blood.equals("AB형")){
		      msg="또라이";
		   }
		   return msg;
	}
}
