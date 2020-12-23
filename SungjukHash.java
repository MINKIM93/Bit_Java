import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;
public class SungjukHash { 
   
   public static void main(String[] args) {
	   HashMap<String,SungjukStaticMethod> hashmap =
				new HashMap<String,SungjukStaticMethod>();
      int menu;
      
      Scanner scan = new Scanner(System.in);
      
      while(true) {
         printMenu();
         System.out.print("메뉴 선택 => ");
         menu = scan.nextInt();
         System.out.println();
         
         if (menu == 6) {
            System.out.println("The End...");
            break;
         }
         
         switch (menu)
         {
            case 1:
               input_sungjuk(hashmap);
               break;
            case 2:
               output_sungjuk(hashmap);
               break;
            case 3:
               search_sungjuk(hashmap);
               break;
            case 4:
               update_sungjuk(hashmap);
               break;
            case 5:
               delete_sungjuk(hashmap);
               break;
            default: 
               System.out.println("메뉴를 다시 선택하세요!!!\n");
         }
      }   
   }
   
   static void printMenu()
   {
      System.out.println("*** 성적관리 ***");
      System.out.println("1. 성적정보 입력");
      System.out.println("2. 성적정보 출력");
      System.out.println("3. 성적정보 조회");
      System.out.println("4. 성적정보 수정");
      System.out.println("5. 성적정보 삭제");
      System.out.println("6. 프로그램 종료");
      System.out.println();
   }
   
   static void input_sungjuk(HashMap<String,SungjukStaticMethod> hashmap){
	  SungjukStaticMethod obj = new SungjukStaticMethod();
	  obj.input_Sungjuk();;
	  
	  //if (hashmap.get(obj.hakbun) ! = null){
	 if (hashmap.containsKey(obj.hac)) {
		 System.out.println("\n학번 입력 오류(중복)!!\n");
		 return;
	 }
   
      obj.process();;
      hashmap.put(obj.hac,obj);
      System.out.println("\n성적정보 입력 성공!!\n");
   }
   
   static void search_sungjuk(HashMap<String,SungjukStaticMethod> hashmap)
   {
      Scanner scan = new Scanner(System.in);
      
      
      System.out.print("조회할 학번 입력 => ");
      String hakbun = scan.next();
      
      SungjukStaticMethod obj = hashmap.get(hakbun);// null - > 해당학번이없음 
       if (obj != null) {
            System.out.println("\n학번    이름    국어    영어    수학    총점    평균   등급");
            System.out.println("=======================================");
            obj.output_Sungjuk();;
            System.out.println("=======================================\n");
            return;
         }
       System.out.println("\n조회할 학번 입력 오류!!\n");
      }
         
   static void update_sungjuk(HashMap<String,SungjukStaticMethod> hashmap)
   {
      Scanner scan = new Scanner(System.in);
      
      
      System.out.print("수정할 학번 입력 => ");
      String hakbun = scan.next();
      
      SungjukStaticMethod obj = hashmap.get(hakbun);
         if (obj != null) {
            System.out.print("국어 입력 => ");
            obj.kor = scan.nextInt();
            System.out.print("영어 입력 => ");
            obj.eng = scan.nextInt();
            System.out.print("수학 입력 => ");
            obj.mat = scan.nextInt();
            obj.process();;
            System.out.println("\n성적정보 수정 성공!!\n");
            return;
         } 
         System.out.println("\n수정할 학번 입력 오류!!\n");
      }
         
   static void delete_sungjuk(HashMap<String,SungjukStaticMethod> hashmap)
   {
      Scanner scan = new Scanner(System.in);
      
      
      System.out.print("삭제할 학번 입력 => ");
      String hakbun = scan.next();
      
      SungjukStaticMethod obj = hashmap.get(hakbun);
      if (obj != null) {
            hashmap.remove(obj.hac);
            System.out.println("\n성적정보 삭제 성공!!\n");
            return;
         }   
      System.out.println("\n삭제할 학번 입력 오류!!\n");
   }
   
   static void output_sungjuk (HashMap<String,SungjukStaticMethod> hashmap) //  keyset() = key 집합을 구함
   {	
	   // 1. keySet() 이용
	   /*
	   Set<String> keyset = hashmap.keySet(); // hashmap에 존재하는 키 집합을 구함
	   
	   if (keyset.size() == 0) //if (hashmap.isEmpty())
	   {
		   System.out.println("출력할 성적정보가 없습니다!!\n");
		   return;
	   }
	   System.out.println("             *** 성적표 ***");
	      System.out.println("=======================================");
	      System.out.println("학번    이름    국어    영어    수학    총점    평균   등급");
	      System.out.println("=======================================");
	      SungjukStaticMethod.total_avg = 0;
	      for (String hakbun : keyset) {
	    	  SungjukStaticMethod obj = hashmap.get(hakbun);
	    	  SungjukStaticMethod.total_avg += obj.avg;
	    	  obj.output_Sungjuk();
	      }
	      System.out.println("=======================================");
	      System.out.printf("\t 총학생수 : %d, 전체 평균 : %5.2f\n\n",
	            keyset.size(), SungjukStaticMethod.getTotalAvg()/keyset.size());
	   /*												                   // values() = 값(value)의 집합을 구함 10개다 저장하면 10개 다 불러옴
      // 3. values를 이용한 작업       
      if (hashmap.size() == 0) // if (hashmap.isEmpty())
      {
         System.out.println("출력할 성적정보가 없습니다!!\n");
         return;
      }
      
      System.out.println("             *** 성적표 ***");
      System.out.println("=======================================");
      System.out.println("학번    이름    국어    영어    수학    총점    평균   등급");
      System.out.println("=======================================");
      SungjukStaticMethod.total_avg = 0;
      for (SungjukStaticMethod obj : hashmap.values()) {
    	  
           SungjukStaticMethod.total_avg += obj.avg;
           obj.output_Sungjuk();
      }
      System.out.println("=======================================");
      System.out.printf("\t 총학생수 : %d, 전체 평균 : %5.2f\n\n",
            hashmap.size(), SungjukStaticMethod.getTotalAvg()/hashmap.size());
            */
	   //2.entrySet()이용
	  Set entryset = hashmap.entrySet();
	  
	  if (entryset.size() == 0) //if (hashmap.isEmpty())
	  {
		  System.out.println("출력할 성적정보가 없습니다!!\n");
		  return;
	  }
	  System.out.println("                   *** 성적표 ***");
	  System.out.println("=========================================");
	  System.out.println("학번    이름    국어    영어    수학    총점    평균   등급");
	  System.out.println("=======================================");
	  SungjukStaticMethod.total_avg = 0;
	  Iterator it_entry = entryset.iterator();//순차적인 접근을 위해 Iterator
	  while(it_entry.hasNext())
	  {
		  //키와 값을 읽기 위해 Map.Entry로 캐스트 연산
		  Map.Entry e = (Map.Entry) it_entry.next(); //클래스안에 클래스있는구조 (map.Entry) map = 외부클래스 Entry = 내부클래스
		  //e.getValue() : 데이터 값을 읽어 옴, e.getKey():키 값을 읽어옴
		  //e.getValue()의 리턴 타입이 Object이므로 Sungjuk으로 캐스트 연산
		  SungjukStaticMethod obj = (SungjukStaticMethod)e.getValue();
		  obj.output_Sungjuk();
		  SungjukStaticMethod.total_avg += obj.avg;
   }
	  System.out.println("=======================================");
      System.out.printf("\t 총학생수 : %d, 전체 평균 : %5.2f\n\n",
            entryset.size(), SungjukStaticMethod.getTotalAvg()/entryset.size());  
   }
}
