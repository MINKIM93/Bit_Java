import java.util.Scanner;

public class SungjukStaticMethod {
   String hac, name, grade;
   int kor, eng, mat, tot;
   double avg;

   static int cnt = 0; // 카운트
   static double total_avg = 0;

   SungjukStaticMethod() {
   }// 디폴트 생성자 명시적 입력

   boolean input_Sungjuk() { // 입력작업
      Scanner scan = new Scanner(System.in);
      System.out.print("학번을 입력 하세요 => ");
      hac = scan.next();
      if (hac.equals("exit"))
         return true;
      System.out.print("이름을 입력 하세요 => ");
      name = scan.next();
      System.out.print("국어점수를 입력 하세요 => ");
      kor = scan.nextInt();
      System.out.print("영어점수를 입력 하세요 => ");
      eng = scan.nextInt();
      System.out.print("수학점수를 입력 하세요 => ");
      mat = scan.nextInt();
      return false;
   }

   void process() { // 학번 등급
      tot = 0;
      avg = 0.0;
      tot = kor + eng + mat;
      avg = tot / 3.;
      switch ((int) (this.avg / 10)) {
      case 10:
      case 9:
         grade = "수";
         break;
      case 8:
         grade = "우";
         break;
      case 7:
         grade = "미";
         break;
      case 6:
         grade = "양";
         break;
      default:
         grade = "가";
      }
   }

   void output_Sungjuk() {
      System.out.printf("%2s  %3s  %3d  %3d  %3d  %3d  %5.2f %s\n",
                  hac, name, kor, eng, mat, tot, avg, grade);
   }

   static double getTotalAvg() { // 정적메소드 정의
	   return total_avg;    
	   //return total_avg / cnt;   = > 하면 인피니티가 나온다. 
   }// 전체평균 

}