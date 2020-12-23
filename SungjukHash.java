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
         System.out.print("�޴� ���� => ");
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
               System.out.println("�޴��� �ٽ� �����ϼ���!!!\n");
         }
      }   
   }
   
   static void printMenu()
   {
      System.out.println("*** �������� ***");
      System.out.println("1. �������� �Է�");
      System.out.println("2. �������� ���");
      System.out.println("3. �������� ��ȸ");
      System.out.println("4. �������� ����");
      System.out.println("5. �������� ����");
      System.out.println("6. ���α׷� ����");
      System.out.println();
   }
   
   static void input_sungjuk(HashMap<String,SungjukStaticMethod> hashmap){
	  SungjukStaticMethod obj = new SungjukStaticMethod();
	  obj.input_Sungjuk();;
	  
	  //if (hashmap.get(obj.hakbun) ! = null){
	 if (hashmap.containsKey(obj.hac)) {
		 System.out.println("\n�й� �Է� ����(�ߺ�)!!\n");
		 return;
	 }
   
      obj.process();;
      hashmap.put(obj.hac,obj);
      System.out.println("\n�������� �Է� ����!!\n");
   }
   
   static void search_sungjuk(HashMap<String,SungjukStaticMethod> hashmap)
   {
      Scanner scan = new Scanner(System.in);
      
      
      System.out.print("��ȸ�� �й� �Է� => ");
      String hakbun = scan.next();
      
      SungjukStaticMethod obj = hashmap.get(hakbun);// null - > �ش��й��̾��� 
       if (obj != null) {
            System.out.println("\n�й�    �̸�    ����    ����    ����    ����    ���   ���");
            System.out.println("=======================================");
            obj.output_Sungjuk();;
            System.out.println("=======================================\n");
            return;
         }
       System.out.println("\n��ȸ�� �й� �Է� ����!!\n");
      }
         
   static void update_sungjuk(HashMap<String,SungjukStaticMethod> hashmap)
   {
      Scanner scan = new Scanner(System.in);
      
      
      System.out.print("������ �й� �Է� => ");
      String hakbun = scan.next();
      
      SungjukStaticMethod obj = hashmap.get(hakbun);
         if (obj != null) {
            System.out.print("���� �Է� => ");
            obj.kor = scan.nextInt();
            System.out.print("���� �Է� => ");
            obj.eng = scan.nextInt();
            System.out.print("���� �Է� => ");
            obj.mat = scan.nextInt();
            obj.process();;
            System.out.println("\n�������� ���� ����!!\n");
            return;
         } 
         System.out.println("\n������ �й� �Է� ����!!\n");
      }
         
   static void delete_sungjuk(HashMap<String,SungjukStaticMethod> hashmap)
   {
      Scanner scan = new Scanner(System.in);
      
      
      System.out.print("������ �й� �Է� => ");
      String hakbun = scan.next();
      
      SungjukStaticMethod obj = hashmap.get(hakbun);
      if (obj != null) {
            hashmap.remove(obj.hac);
            System.out.println("\n�������� ���� ����!!\n");
            return;
         }   
      System.out.println("\n������ �й� �Է� ����!!\n");
   }
   
   static void output_sungjuk (HashMap<String,SungjukStaticMethod> hashmap) //  keyset() = key ������ ����
   {	
	   // 1. keySet() �̿�
	   /*
	   Set<String> keyset = hashmap.keySet(); // hashmap�� �����ϴ� Ű ������ ����
	   
	   if (keyset.size() == 0) //if (hashmap.isEmpty())
	   {
		   System.out.println("����� ���������� �����ϴ�!!\n");
		   return;
	   }
	   System.out.println("             *** ����ǥ ***");
	      System.out.println("=======================================");
	      System.out.println("�й�    �̸�    ����    ����    ����    ����    ���   ���");
	      System.out.println("=======================================");
	      SungjukStaticMethod.total_avg = 0;
	      for (String hakbun : keyset) {
	    	  SungjukStaticMethod obj = hashmap.get(hakbun);
	    	  SungjukStaticMethod.total_avg += obj.avg;
	    	  obj.output_Sungjuk();
	      }
	      System.out.println("=======================================");
	      System.out.printf("\t ���л��� : %d, ��ü ��� : %5.2f\n\n",
	            keyset.size(), SungjukStaticMethod.getTotalAvg()/keyset.size());
	   /*												                   // values() = ��(value)�� ������ ���� 10���� �����ϸ� 10�� �� �ҷ���
      // 3. values�� �̿��� �۾�       
      if (hashmap.size() == 0) // if (hashmap.isEmpty())
      {
         System.out.println("����� ���������� �����ϴ�!!\n");
         return;
      }
      
      System.out.println("             *** ����ǥ ***");
      System.out.println("=======================================");
      System.out.println("�й�    �̸�    ����    ����    ����    ����    ���   ���");
      System.out.println("=======================================");
      SungjukStaticMethod.total_avg = 0;
      for (SungjukStaticMethod obj : hashmap.values()) {
    	  
           SungjukStaticMethod.total_avg += obj.avg;
           obj.output_Sungjuk();
      }
      System.out.println("=======================================");
      System.out.printf("\t ���л��� : %d, ��ü ��� : %5.2f\n\n",
            hashmap.size(), SungjukStaticMethod.getTotalAvg()/hashmap.size());
            */
	   //2.entrySet()�̿�
	  Set entryset = hashmap.entrySet();
	  
	  if (entryset.size() == 0) //if (hashmap.isEmpty())
	  {
		  System.out.println("����� ���������� �����ϴ�!!\n");
		  return;
	  }
	  System.out.println("                   *** ����ǥ ***");
	  System.out.println("=========================================");
	  System.out.println("�й�    �̸�    ����    ����    ����    ����    ���   ���");
	  System.out.println("=======================================");
	  SungjukStaticMethod.total_avg = 0;
	  Iterator it_entry = entryset.iterator();//�������� ������ ���� Iterator
	  while(it_entry.hasNext())
	  {
		  //Ű�� ���� �б� ���� Map.Entry�� ĳ��Ʈ ����
		  Map.Entry e = (Map.Entry) it_entry.next(); //Ŭ�����ȿ� Ŭ�����ִ±��� (map.Entry) map = �ܺ�Ŭ���� Entry = ����Ŭ����
		  //e.getValue() : ������ ���� �о� ��, e.getKey():Ű ���� �о��
		  //e.getValue()�� ���� Ÿ���� Object�̹Ƿ� Sungjuk���� ĳ��Ʈ ����
		  SungjukStaticMethod obj = (SungjukStaticMethod)e.getValue();
		  obj.output_Sungjuk();
		  SungjukStaticMethod.total_avg += obj.avg;
   }
	  System.out.println("=======================================");
      System.out.printf("\t ���л��� : %d, ��ü ��� : %5.2f\n\n",
            entryset.size(), SungjukStaticMethod.getTotalAvg()/entryset.size());  
   }
}
