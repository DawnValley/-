  

  package com.cx.bank.test;
  import com.cx.bank.manager.ManagerImpl;
  import java.util.*;
  /**
  *<b>���Բ�TestBank</b>
  *@author RG
  *@version 1.0 2018/06/11
  */
  public class TestBank 
  {
	  /**
	  *<b>���в���ϵͳ</b>
	  *@see com.cx.bank.manager.ManagerImpl
	  *����������ݺ�ҵ�����в���
	  */
	  public void bankSystemTest()
	  {
		  Scanner sc = new Scanner(System.in);//�����������ݵĶ���
		  int n = 0;//��������
		  ManagerImpl mi = new ManagerImpl();//ҵ���ManagerImpl����

		  while(true)//��Ϊtrueʱ�������в���ϵͳ
		  {
			  System.out.println("***************************���в���ϵͳ***************************");
              System.out.println("                            1.��ѯ���                            ");
			  System.out.println("                            2.ȡ��                                ");
			  System.out.println("                            3.���                                ");
			  System.out.println("                            4.�˳�ϵͳ                            ");
			  System.out.print("�������������(����1~4)��");
			  //�����벻������ʱ����Exception in thread "main" java.util.InputMismatchException
			  //δ��������˼��:�����׳��쳣�Ĵ���ʽ
			  n = sc.nextInt();

			  if(n == 1)//��ѯ
			  {
				  System.out.println("�����ڽ��в�ѯ�������Ĳ�ѯ������£�");
				  mi.inquiry();
			  }
			  else if(n == 2)//ȡ��
			  {
				  System.out.print("�����ڽ���ȡ�����������ȡ���");
				  double d = sc.nextDouble();
				  mi.withDrawals(d);
			  }
			  else if(n == 3)//���
			  {
				  System.out.print("�����ڽ��д��������������");
				  double d = sc.nextDouble();
				  mi.deposit(d);
			  }
			  else if(n == 4)//�˳�
			  {
				  System.out.println("***************�������˳����в���ϵͳ��лл����ʹ��***************");
				  break;
			  }
			  else//�������������
			  {
				  System.out.println("���������������ȷ�Ĳ������֣�����1~4����");
			  }
			  System.out.println("*****************************��ӭʹ��*****************************");
		  }
	  }
	  /**
	  *<b>������</b>
	  *@param args String[] ���������д�����ַ���
	  *@see TestBank#bankSystemTest
	  */
	  public static void main(String[] args) 
	  {
		  TestBank tb = new TestBank();
		  tb.bankSystemTest();//������ϵͳ���в���
	  }
  }
