  
  
  package com.cx.bank.dao;
  import java.util.*;
  import java.io.*;
  import com.cx.bank.util.*;
  import com.cx.bank.mode1.*;

  /**
  *<b>����FileDanImpl</b>
  *@author RG
  *@version 1.3 2018/07/15
  *@see com.cx.bank.util.MD5
  *@see com.cx.bank.mode1.UserBean
  *@see com.cx.bank.mode1.MoneyBean
  */
  public class FileDaoImp1 implements BankDaoInterface
  {

	  private MD5 md5 = new MD5();//˽�м������������
	  private Properties prop = new Properties();//˽���ļ����������
	  public FileDaoImp1()
	  {
	  }
	  /*private static FileDaoImp1 instance = new FileDaoImp1();//�־ò�û��Ҫ������ҵ��㵥������

	  private FileDaoImp1()
	  {
	  }
	  public static FileDaoImp1 getInstance()
	  {
		  return instance;
	  }*/

	  /**
	  *ע��
	  *@param user �û���Ϣ
	  */
	  public boolean register(UserBean user) throws FileNotFoundException,IOException,Exception
	  {
		  String name = user.getUserName();//�õ�ģ�Ͳ��û���
		  String pwd = user.getPwd();//�õ�ģ�Ͳ��û�����
		  String password = md5.getMD5(pwd);//����MD5����
		  File f = new File(name+".properties");//�����ļ�
		  if(f.exists())
		  {
			  System.out.println("�û��Ѵ��ڣ�������ע�ᣡ");
			  return false;
		  }
		  else
		  {
			  if("".equals(name)||"".equals(pwd))
			  {
				  System.out.println("�û��������벻��Ϊ�գ�������ע�ᣡ");
				  return false;
			  }
		  }
			  FileInputStream in = new FileInputStream(".\\Bank.properties");
			  prop.load(in);//������ļ����ص��ڴ�
			  in.close();

			  FileOutputStream out = new FileOutputStream(f);//�ڴ�������ͨ��
			  prop.setProperty("userName",name);//��������
			  prop.setProperty("password",password);//��������
			  prop.store(out,".\\"+name+".properties");//���ڴ��ļ��洢�����
			  //prop.store(out,name+".properties");//����Ч����ͬ
			  out.close();

		      //this.addBank(user);
			  //���Խ����ת�ˣ�java.io.FileNotFoundException: .\*.proterties (ϵͳ�Ҳ���ָ�����ļ���)
			  //���շ��� FileInputStream in = new FileInputStream(".\\"+name+".properties");д����
			  //д����".proterties"

		      return true;
	  }

      /**
	  *��¼
	  *@param user �û���Ϣ
	  */
	  public boolean login(UserBean user) throws Exception
	  {
		  String name = user.getUserName();
		  String pwd = user.getPwd();
		  String password = md5.getMD5(pwd);
		  File f = new File(name+".properties");
		  if(f.exists() == true)
		  {
			  FileInputStream in = new FileInputStream(".\\"+name+".properties");
			  prop.load(in);
			  in.close();
			  if(prop.getProperty("password").equals(password))
			  {
				  Double money = Double.parseDouble(prop.getProperty("money"));
				  MoneyBean.getMoneyBean().setMoney(money);
				  return true;
			  }
			  else
			  {
				  System.out.println("������������µ�¼��");
				  return false;
			  }
		  }
		  else
		  {
			  System.out.println("�û������ڣ������µ�¼��");
			  return false;
		  }
	  }

	  /**
	  *ת��
	  *@param name Ҫת����˺��û���
	  *@param money Ҫת���Ǯ
	  */
	  public boolean transfer(String name,double money) throws Exception
	  {
		  File f = new File(name+".properties");
		  if(f.exists()==true)//��Ҫ�ж�Ҫת����˺��Ƿ����
		  {
			  FileInputStream in = new FileInputStream(".\\"+name+".properties");
			  prop.load(in);
			  in.close();

			  FileOutputStream out = new FileOutputStream(f);
			  String proMoney = Double.parseDouble((prop.getProperty("money")))+money+"";
			  prop.setProperty("money",proMoney);
			  prop.store(out,".\\"+name+".properties");
			  out.close();
		      return true;
		  }
		  else
		  {
			  System.out.println("���û������ڣ�");
		      return false;
		  }
	  }

	  /**
	  *�洢����
	  *@param user �û���Ϣ
	  */
	  public boolean addBank(UserBean user) throws Exception
	  {
		  String name = user.getUserName();
          File f = new File(name+".properties");//�����ļ�
		  if(f.exists())
		  {
			  FileInputStream in = new FileInputStream(".\\"+name+".properties");
			  in.close();

			  FileOutputStream out = new FileOutputStream(f);
			  prop.setProperty("money",MoneyBean.getMoneyBean().getMoney()+"");
			  prop.store(out,".\\"+name+".properties");
			  out.close();
			  
			  return true;
		  }
		  else
		  {
			  System.out.println("��δע����¼���û������ڣ�");
			  return false;
		  }
	  }

	  /**
	  *��ȡ���
	  *@param user �û���Ϣ
	  *@return money ����-1
	  */
	  public double getBalance(UserBean user) throws Exception
	  {
		  String name = user.getUserName();
		  File f = new File(name+".properties");//�����ļ�
		  if(f.exists())
		  {
			  FileInputStream in = new FileInputStream(f);
			  prop.load(in);
			  in.close();

			  double money = Double.parseDouble(prop.getProperty("money"));
			  return money;
		  }
		  else
		  {
		      System.out.println("�û������ڣ�");
			  return -1;//�ļ������ڷ���-1
		  }
	  }
  }
