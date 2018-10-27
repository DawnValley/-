  
  package com.cx.bank.factory;
  import java.util.*;
  import java.io.*;
  import com.cx.bank.dao.*;
  /**
  *�־ò�Ĺ���ģʽ
  *@author RG
  *@version 1.6 2018/07/25
  *@see com.cx.bank.dao.FileDaoImp1
  */
  public class UserDaoFactory
  {
	  private BankDaoInterface userDao;//�־ò�ӿ�
	  private static UserDaoFactory instance = null;//˽�о�̬�Ĺ����������������һҪ��

	  private UserDaoFactory() throws Exception//˽�еĹ��췽���������ڶ�Ҫ��
	  {
		  Properties prop = new Properties();//�ļ�����
		  FileInputStream fis = new FileInputStream(new File(".\\classInfo.properties"));//�ļ�����������
		  prop.load(fis);//��������ļ����ݵ��ڴ���ļ�������
		  fis.close();//�ر��ļ�

		  String className = prop.getProperty("className");//��ȡ�ļ�������className��ֵ
		  Class c = Class.forName(className);//ͨ������ȡ����Ӧ�ķ������
		  Object o = c.newInstance();//ͨ��������󴴽���Ӧ�������
		  userDao = (BankDaoInterface)o;//��ȡ�õ����������Ϊ�־ò�ӿ�����
	  }
	  /**
	  *���еĻ��instance����ֵ�ķ�������������Ҫ��
	  *@exception Exception �쳣
	  *@return instance ����Ķ���
	  *ͬ��������֤��ȫ����Ϊֻ����һ�Σ���Ӱ��Ч��
	  */
	  public static synchronized UserDaoFactory getInstance() throws Exception
	  {
		  if(instance == null)//���instanceֵΪ�գ�����UserDaoFactory���󣬷��ظö���
		  {
			  instance = new UserDaoFactory();
		  }
		  return instance;
	  }

	  /**
	  *���س־ò������ķ���
	  *@return userDao �־ò������
	  */
	  public BankDaoInterface createUserDao()
	  {
		  return userDao;
	  }
  }
