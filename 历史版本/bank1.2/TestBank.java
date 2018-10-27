  

  package com.cx.bank.test;
  import com.cx.bank.manager.Manager;
  import com.cx.bank.manager.ManagerImp1;
  import java.util.*;
  import com.cx.bank.util.*;
  /**
  *<b>���Բ�TestBank</b>
  *@author RG
  *@version 1.2 2018/06/21
  */
  public class TestBank 
  {
      public void printMenu()//���в���ϵͳ�˵�
	  {
		  System.out.println("**************************���в���ϵͳ1.2**************************");
          System.out.println("                            1.��ѯ���                             ");
		  System.out.println("                            2.ȡ��                                 ");
		  System.out.println("                            3.���                                 ");
		  System.out.println("                            4.�˳�ϵͳ                             ");
		  System.out.println("******************************��ӭʹ��*****************************");
	  }
	  /**
	  *<b>���в���ϵͳ</b>
	  *@see com.cx.bank.manager.ManagerImp1
	  *����������ݺ�ҵ�����в���
	  */
	  public void bankSystemTest() throws Exception
	  {
		  Scanner sc = new Scanner(System.in);//�����������ݵĶ���
		  int n = 0;//��������
		  Manager mi = new ManagerImp1();//ҵ���ManagerImpl���󸳸�ҵ���ӿ�Manager

		  while(true)//��Ϊtrueʱ�������в���ϵͳ
		  {
			  this.printMenu();
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
				  
				  try{
				      mi.withDrawals(d);
				  }catch(InvalidWithDrawalstException e){//����ȡ���Ϊ�����쳣
					  System.out.println(e);
				  }
				  catch(AccountOverDrawnException e){//����ȡ��������쳣
					  System.out.println(e);
				  }
				  finally{
		              mi.inquiry();
		          }
			  }
			  else if(n == 3)//���
			  {
				  System.out.print("�����ڽ��д��������������");
				  double d = sc.nextDouble();

				  try{
				      mi.deposit(d);
			      }catch(InvalidDepositException e){//�������Ϊ�����쳣
					  System.out.println(e);
				  }
				  finally{
		              mi.inquiry();
		          }
			  }
			  else if(n == 4)//�˳�
			  {
				  System.out.println("****************�������˳����в���ϵͳ��лл����ʹ��***************");
				  mi.secede();
			  }
			  else//�������������
			  {
				  System.out.println("���������������ȷ�Ĳ������֣�����1~4����");
			  }
		  }
	  }
	  /**
	  *<b>������</b>
	  *@param args String[] ���������д�����ַ���
	  *@see TestBank#bankSystemTest
	  */
	  public static void main(String[] args) throws Exception
	  {
		  TestBank tb = new TestBank();
		  tb.bankSystemTest();//������ϵͳ���в���
	  }
  }
