  
  
  package com.cx.bank.manager;
  /**
  *<b>ҵ���Manager�ӿ�</b>
  *@author RG
  *@version 1.3 2018/07
  */
  public interface Manager 
  {
	  void inquiry();//��ѯ���
	  void withDrawals(double m)throws Exception;//�û�ȡ��
	  void deposit(double m)throws Exception;//�û����
	  boolean transfer(String username,double money);//ת��
	  boolean register(String userName,String userPwd);//ע��
	  boolean login(String userName,String userPwd);//��¼
	  void secede();//�˳�ϵͳ
  }
