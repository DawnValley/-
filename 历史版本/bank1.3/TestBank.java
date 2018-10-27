  

  package com.cx.bank.test;
  import com.cx.bank.mode1.MoneyBean;
  import com.cx.bank.manager.Manager;
  import com.cx.bank.manager.ManagerImp1;
  import java.util.*;
  import com.cx.bank.util.*;
  /**
  *<b>���Բ�TestBank</b>
  *@author RG
  *@version 1.3 2018/07
  */
  public class TestBank 
  {
      public void printMenu2()//���в���ϵͳ�˵�
	  {
		  System.out.println("**************************���в���ϵͳ1.2**************************");
          System.out.println("                            1.��ѯ���                             ");
		  System.out.println("                            2.ȡ��                                 ");
		  System.out.println("                            3.���                                 ");
		  System.out.println("                            4.ת��                                 ");
		  System.out.println("                            5.�˳�ϵͳ                             ");
		  System.out.println("******************************��ӭʹ��*****************************");
	  }
	  public void printMenu1()//���в���ע���¼�˵�
	  {
		  System.out.println("**************************���в���ϵͳ1.2**************************");
          System.out.println("                            1.��¼                            ");
		  System.out.println("                            2.ע��                                 ");
		  System.out.println("                            3.�˳�ϵͳ                             ");
		  System.out.println("******************************��ӭʹ��*****************************");
	  }

	  /**
	  *<b>���е�¼����</b>
	  *@see com.cx.bank.manager.ManagerImp1
	  *�Ե�¼ע�����
	  */
	  public void bankSystem()throws Exception
	  {
		  Scanner sc = new Scanner(System.in);//�����������ݵĶ���
		  int n = 0;//��������
		  Manager mi = ManagerImp1.getInstance();//ҵ���ManagerImpl���󸳸�ҵ���ӿ�Manager
		  while(true)//��Ϊtrueʱ�������в���ϵͳ
		  {
			  this.printMenu1();
			  System.out.print("�������������(����1~3)��");
			  //�����벻������ʱ����Exception in thread "main" java.util.InputMismatchException
			  //δ��������˼��:�����׳��쳣�Ĵ���ʽ
			  n = sc.nextInt();

			  if(n == 1)//��¼
			  {
				  System.out.print("��������û���:");
			      String userName=sc.next();
                  System.out.print("�����������:");
                  String userPwd=sc.next();
                  if(mi.login(userName,userPwd))
				  {
				      System.out.println("��¼�ɹ���");
					  this.bankSystemTest(mi);
				  }
				  else System.out.println("��¼ʧ�ܣ���ע�ᣡ");
			  }

			  else if(n == 2)//ע��
			  {
				  System.out.print("��������û���:");
                  String userName=sc.next();
                  System.out.print("�����������:");
                  String userPwd=sc.next();
			      if(mi.register(userName,userPwd)){
				      System.out.println("ע��ɹ���");
				  }else{
				      System.out.println("ע��ʧ�ܣ�");
				  }
			  }
			  else if(n == 3)//�˳�
			  {
				  System.out.println("****************�������˳����в���ϵͳ��лл����ʹ��***************");
				  mi.secede();
			  }
			  else//�������������
			  {
				  System.out.println("���������������ȷ�Ĳ������֣�����1~3����");
			  }
		  }

	  }
	  /**
	  *<b>���в���ϵͳ</b>
	  *@see com.cx.bank.manager.ManagerImp1
	  *����������ݺ�ҵ�����в���
	  */
	  public void bankSystemTest(Manager mi) throws Exception
	  {
		  Scanner sc = new Scanner(System.in);//�����������ݵĶ���
		  int n = 0;//��������

		  while(true)//��Ϊtrueʱ�������в���ϵͳ
		  {
			  this.printMenu2();
			  System.out.print("�������������(����1~5)��");
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

              else if(n == 4)//ת��
			  {
				  System.out.println("��������Ҫת�˵��˻�:");
				  String account=sc.next();
                  System.out.println("��������Ҫת�˵Ľ��:");
				  double money=sc.nextDouble();
				  if(mi.transfer(account,money))
				  {
				      System.out.println("ת�˳ɹ���");
				  }
				  else
				  {
				      System.out.println("ת��ʧ�ܣ�");
				  }  
			  }

			  else if(n == 5)//�˳�
			  {
				  System.out.println("****************�������˳����в���ϵͳ��лл����ʹ��***************");
				  mi.secede();
			  }
			  else//�������������
			  {
				  System.out.println("���������������ȷ�Ĳ������֣�����1~5����");
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
		  tb.bankSystem();//������ϵͳ���в���
	  }
  }
