  

  package com.cx.bank.manager;
  import java.util.*;
  import java.io.*;
  import com.cx.bank.mode1.*;
  import com.cx.bank.util.*;
  import com.cx.bank.dao.*;
  import com.cx.bank.factory.*;
  /**
  *<b>ҵ���ManagerImp1��</b>
  *@author RG
  *@version 1.3 2018/07/15
  *@see com.cx.bank.mode1.MoneyBean
  *@see com.cx.bank.factory.UserDaoFactory
  */
  public class  ManagerImp1 implements Manager
  {
	  private MoneyBean mb = MoneyBean.getMoneyBean();//MoneyBean�ĵ�������
	  private BankDaoInterface userDao = null;//�־ò�ӿڱ���
	  private UserBean user= new UserBean();//�õ�ģ�Ͳ���UserBean�Ķ����ַ
	  private static ManagerImp1 instance =null;//����ҵ������
	  private MD5 md5=new MD5();//˽��MD5�������������

	  /*˽�й��췽��*/
	  private ManagerImp1() throws Exception
	  {
		  UserDaoFactory udf = UserDaoFactory.getInstance();//ͨ�����������־ò�Ĺ��������
		  userDao = udf.createUserDao();//ͨ������������õ��־ò������
	  }

      /*�õ������ַ�ķ���-����ģʽ*/
	  public static synchronized ManagerImp1 getInstance() throws Exception
	  {
		  if (instance == null)
		  {
			  instance = new ManagerImp1();
		  }
		  return instance;
	  }

	  /**
	  *ʵ��ע�᷽��
	  *@param userName �û���
	  *@param userPwd  �û�����
	  */
	  public boolean register(String userName,String userPwd) throws Exception
	  {   
		  user.setUserName(userName);//���û������õ��û���Ϣ��
		  user.setPwd(userPwd);//���û��������õ��û���Ϣ��
	      if(userDao.register(user)==true)
		      return true;
		  else
		      return false;  
	  }

      /**
	  *ʵ�ֵ�¼����
	  *@param userName �û���
	  *@param userPwd  �û�����
	  */
	  public boolean login(String userName,String userPwd) throws Exception
	  {
		  user.setUserName(userName);//���û������õ��û���Ϣ��
		  user.setPwd(userPwd);//���û��������õ��û���Ϣ��
          if(userDao.login(user)==true)
		      return true;
		  else
		      return false;
	  }

	  /**
	  *ת�˷���
	  *@param username �û���
	  *@param money  �û�����
	  */
	  public boolean transfer(String username,double money) throws Exception
	  {
		  if(money < 0)
		  {
			  System.out.println("ת�˽��Ϊ������");
			  return false;
		  }
		  else if(userDao.transfer(username,money)==true && mb.getMoney()>=money)
		  {
			  mb.setMoney(mb.getMoney()-money);
			  //�д�ת��ʱ����java.io.FileNotFoundException: .\x.proterties (ϵͳ�Ҳ���ָ�����ļ���)
			  //�ѽ��
			  userDao.addBank(user);//�Ѹ��ĺ�����浽�ļ���
		      return true;
		  }
		  else
			  return false;
	  }
	  
	  public void inquiry()//��ѯ���
	  {
		  System.out.println("�����˻���ǰ���Ϊ��"+mb.getMoney()+"Ԫ");
	  }
	  /**
	  *<b>�û�ȡ��</b>
	  *@param m ȡ������
	  */
	  public void withDrawals(double m) throws RuntimeException
	  {
		  if(m > mb.getMoney())//��ȡ�����������ȡ��ʧ��
		  {
			  throw new AccountOverDrawnException("�����˻����㣡ȡ��ʧ�ܣ����������룡");//ȡ�������������쳣
		  }
		  else if(m < 0)//��ȡ������Ϊ������ȡ��ʧ�ܣ��������ȡ�����ǰ�˻����
		  {
			  throw new InvalidWithDrawalstException("�������ȡ����Ϊ������ȡ��ʧ�ܣ����������룡");//ȡ������Ϊ�����쳣
		  }
		  else
		  {
			  mb.setMoney(mb.getMoney() - m);//ȡ����������ý��
			  System.out.println("ȡ��ɹ�����ȡ�"+m+"Ԫ");
		  }
	  }
	  /**
	  *<b>�û����</b>
	  *@param m �������
	  */
	  public void deposit(double m) throws RuntimeException
	  {
		  if(m < 0)//���������Ϊ���������ʧ�ܣ��������������ǰ�˻����
		  {
			  throw new InvalidDepositException("������Ĵ����Ϊ���������ʧ�ܣ����������룡");  
		  }
		  else
		  {
			  mb.setMoney(mb.getMoney() + m);
			  System.out.println("���ɹ�������"+m+"Ԫ");//�����������ý��
		  }	  
	  }
	  /**
	  *<b>�˳�ϵͳ</b>
	  */
	  public void secede() throws Exception
	  {
		  userDao.addBank(user);//�洢�û�����
		  System.out.println("ϵͳ���˳���");
		  System.exit(0);
	  }
  }
