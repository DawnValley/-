  
  
  package com.cx.bank.manager;
  import java.io.*;
  /**
  *<b>ҵ���Manager�ӿ�</b>
  *@author RG
  *@version 1.3 2018/07
  */
  public interface Manager 
  {
	  void inquiry();//��ѯ���
	  void withDrawals(double m);//�û�ȡ��
	  void deposit(double m);//�û����
	  boolean transfer(String username,double money) throws Exception;//ת��
	  boolean register(String userName,String userPwd) throws Exception;//ע��
	  boolean login(String userName,String userPwd) throws Exception;//��¼
	  void secede() throws Exception;//�˳�ϵͳ
  }
