  

  package com.cx.bank.test;
  import java.util.*;
  import java.io.*;
  import com.cx.bank.manager.*;
  import com.cx.bank.util.*;
  /**
  *<b>���Բ�TestBank</b>
  *@author RG
  *@version 1.3 2018/07/15
  *@see com.cx.bank.manager.ManagerImp1
  */
  public class TestBank 
  {

	  public void printMenu1()//���в���ע���¼�˵�
	  {
		  System.out.println("**************************���в���ϵͳ1.3**************************");
          System.out.println("                            1.��¼                            ");
		  System.out.println("                            2.ע��                                 ");
		  System.out.println("                            3.�˳�ϵͳ                             ");
		  System.out.println("******************************��ӭʹ��*****************************");
	  }
	  public void printMenu2()//���в���ϵͳ�˵�
	  {
		  System.out.println("**************************���в���ϵͳ1.3**************************");
          System.out.println("                            1.��ѯ���                             ");
		  System.out.println("                            2.ȡ��                                 ");
		  System.out.println("                            3.���                                 ");
		  System.out.println("                            4.ת��                                 ");
		  System.out.println("                            5.�˳�ϵͳ                             ");
		  System.out.println("******************************��ӭʹ��*****************************");
	  }

	  /**
	  *<b>���е�¼����</b>
	  *@param mi ҵ������
	  *�Ե�¼ע�����
	  */
	  public void bankSystem(Manager mi)
	  {
		  Scanner sc = new Scanner(System.in);//�����������ݵĶ���
		  //int n = 0;//��������
		  String n = null;
		  //Manager mi = ManagerImp1.getInstance();//ҵ���ManagerImpl���󸳸�ҵ���ӿ�Manager
		  while(true)//��Ϊtrueʱ�������в���ϵͳ
		  {
			  this.printMenu1();
			  System.out.print("�������������(����1~3)��");
			  //�����벻������ʱ����Exception in thread "main" java.util.InputMismatchException
			  //δ��������˼��:�����׳��쳣�Ĵ���ʽ
			  //�ѽ��������Ϊ���ַ�����������������������쳣����String��equals�����Ƚϼ���
			  //n = sc.nextInt();
			  n = sc.next();
			  //char n = n1.charAt(0);

			  if("1".equals(n))//��¼
			  {
				  System.out.print("��������û���:");
			      String userName=sc.next();
                  System.out.print("�����������:");
                  String userPwd=sc.next();
				  boolean flag = false;
				try{
				  flag = mi.login(userName,userPwd);
				}catch(FileNotFoundException e){
			        System.out.println(e);
		        }catch(IOException e){
					System.out.println(e);
				}catch(Exception e){
					System.out.println(e);
				}
                  if(flag)
				  {
				      System.out.println("��¼�ɹ���");
					  this.bankSystemTest(mi);
				  }
				  else System.out.println("��¼ʧ�ܣ���ע�ᣡ");
			  }

			  else if("2".equals(n))//ע��
			  {
				  System.out.print("��������û���:");
                  String userName=sc.next();
                  System.out.print("�����������:");
                  String userPwd=sc.next();
				  boolean flag = false;

				try{
				  flag = mi.register(userName,userPwd);
				}catch(FileNotFoundException e){
					/*����: �Ѳ����쳣����FileNotFoundException
                                }catch(FileNotFoundException e){
					ԭ��:��Ϊcatch(FileNotFoundException e)������catch(IOException e)����
					û�������������ò�����쳣��
					*/
			        System.out.println(e);
		        }catch(IOException e){
					System.out.println(e);
				}catch(Exception e){
					System.out.println(e);
				}

			      if(flag){
				      System.out.println("ע��ɹ���");
				  }else{
				      System.out.println("ע��ʧ�ܣ�");
				  }
			  }
			  else if("3".equals(n))//�˳�
			  {
				  System.out.println("****************�������˳����в���ϵͳ��лл����ʹ��***************");
				try{
				  mi.secede();
				}catch(FileNotFoundException e){
			        System.out.println(e);
		        }catch(IOException e){
					System.out.println(e);
				}catch(Exception e){
					System.out.println(e);
				}
			  }
			  else//�������������
			  {
				  System.out.println("���������������ȷ�Ĳ������֣�����1~3����");
			  }
		  }

	  }
	  /**
	  *<b>���в���ϵͳ</b>
	  *@param mi ҵ������
	  *����������ݺ�ҵ�����в���
	  */
	  public void bankSystemTest(Manager mi) 
	  {
		  Scanner sc = new Scanner(System.in);//�����������ݵĶ���
		  //int n = 0;//��������
		  String n = null;

		  while(true)//��Ϊtrueʱ�������в���ϵͳ
		  {
			  this.printMenu2();
			  System.out.print("�������������(����1~5)��");
			  //�����벻������ʱ����Exception in thread "main" java.util.InputMismatchException
			  //δ��������˼��:�����׳��쳣�Ĵ���ʽ
			  //n = sc.nextInt();
			  n = sc.next();

			  if("1".equals(n))//��ѯ
			  {
				  System.out.println("�����ڽ��в�ѯ�������Ĳ�ѯ������£�");
				  mi.inquiry();
			  }
			  else if("2".equals(n))//ȡ��
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
				  }catch(Exception e){//ȡ���쳣
					  System.out.println(e);
				  }
				  finally{
		              mi.inquiry();
		          }
			  }
			  else if("3".equals(n))//���
			  {
				  System.out.print("�����ڽ��д��������������");
				  double d = sc.nextDouble();

				  try{
				      mi.deposit(d);
			      }catch(InvalidDepositException e){//�������Ϊ�����쳣
					  System.out.println(e);
				  }catch(Exception e){//����쳣
					  System.out.println(e);
				  }
				  finally{
		              mi.inquiry();
		          }
			  }

              else if("4".equals(n))//ת��
			  {
				  System.out.print("��������Ҫת�˵��˻�:");
				  String account=sc.next();
                  System.out.print("��������Ҫת�˵Ľ��:");
				  double money=sc.nextDouble();
				  boolean flag = false;
				try{
				  flag = mi.transfer(account,money);
				}catch(FileNotFoundException e){
			        System.out.println(e);
		        }catch(IOException e){
					System.out.println(e);
				}catch(Exception e){
					System.out.println(e);
				}

				  if(flag)
				  {
				      System.out.println("ת�˳ɹ���");
				  }
				  else
				  {
				      System.out.println("ת��ʧ�ܣ�");
				  }  
			  }

			  else if("5".equals(n))//�˳�
			  {
				  System.out.println("****************�������˳����в���ϵͳ��лл����ʹ��***************");
				try{
				  mi.secede();
				}catch(FileNotFoundException e){
			        System.out.println(e);
		        }catch(IOException e){
					System.out.println(e);
				}catch(Exception e){
					System.out.println(e);
				}
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
	  *@see TestBank#bankSystemTest(Manager mi)
	  *@see TestBank#bankSystem(Manager mi)
	  */
	  public static void main(String[] args) //throws Exception
	  {
		try{
		  Manager mi = ManagerImp1.getInstance();
		
		  TestBank tb = new TestBank();
		  tb.bankSystem(mi);//������ϵͳ���в���
		}catch(ClassCastException e){
			System.out.println(e);
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}catch(RuntimeException e){
			System.out.println(e);
		}catch(Exception e){
			System.out.println(e);
		}
	  }
  }
