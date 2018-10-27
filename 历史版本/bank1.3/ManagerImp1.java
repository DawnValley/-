  

  package com.cx.bank.manager;
  import com.cx.bank.mode1.*;
  import com.cx.bank.util.*;
  import com.cx.bank.dao.*;
  /**
  *<b>ҵ���ManagerImp1��</b>
  *@author RG
  *@version 1.3 2018/07
  *@see com.cx.bank.model.MoneyBean
  */
  public class  ManagerImp1 implements Manager
  {
	  //private MoneyBean moneybean=MoneyBean.getInstance();//�õ�ģ�Ͳ���MoneyBean�Ķ����ַ
	  private MoneyBean mb = MoneyBean.getMoneyBean();//MoneyBean�ĵ�������

      private FileDaoImp1 filedao=FileDaoImp1.getInstance();//�õ��־ò�Ķ����ַ

	  private UserBean user= new UserBean();//�õ�ģ�Ͳ���UserBean�Ķ����ַ

	  private static ManagerImp1 instance =new ManagerImp1();//����ҵ������

	  private MD5 md5=new MD5();//˽��MD5�������������

	  /*˽�й��췽��*/
	  private ManagerImp1(){
	     
	  }

      /*�õ������ַ�ķ���*/
	  public static ManagerImp1 getInstance(){
		  return instance;
	  }

	  /**
	  *ʵ��ע�᷽��
	  *@param userName �û���
	  *@param userPwd  �û�����
	  */
	  public boolean register(String userName,String userPwd)
	  {   
		  user.setUserName(userName);//���û������õ��û���Ϣ��
		  user.setPwd(userPwd);//���û��������õ��û���Ϣ��
	      if(filedao.register(user)==true){
		      return true;
		  }else{
		      return false;
		  }
	  }

      /**
	  *ʵ�ֵ�¼����
	  *@param userName �û���
	  *@param userPwd  �û�����
	  */
	  public boolean login(String userName,String userPwd){
		  user.setUserName(userName);//���û������õ��û���Ϣ��
		  user.setPwd(userPwd);//���û��������õ��û���Ϣ��
          if(filedao.login(user)==true){
		      return true;
		  }else{
		      return false;
		  }
	  }

	  /**
	  *ת�˷���
	  *@param userName �û���
	  *@param userPwd  �û�����
	  */
	  public boolean transfer(String username,double money)
	  {
		  if(filedao.transfer(username,money)==true && mb.getMoney()>=money )
		  {
			  mb.setMoney(mb.getMoney()-money);
			  filedao.addBank(user);//�Ѹ��ĺ�����浽�ļ���
		      return true;
		  }
		  else{
			   return false;
		  }
	  }
	  
	  public void inquiry()//��ѯ���
	  {
		  System.out.println("�����˻���ǰ���Ϊ��"+mb.getMoney()+"Ԫ");
	  }
	  /**
	  *<b>�û�ȡ��</b>
	  *@param m double ȡ������
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
	  *@param m double �������
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
	  public void secede()
	  {
		  System.exit(0);
	  }
  }
