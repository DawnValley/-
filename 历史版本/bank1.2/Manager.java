  
  
  package com.cx.bank.manager;
  /**
  *<b>ҵ���Manager�ӿ�</b>
  *@author RG
  *@version 1.2 2018/06/21
  */
  public interface Manager 
  {
	  void inquiry();//��ѯ���
	  void withDrawals(double m)throws Exception;//�û�ȡ��
	  void deposit(double m)throws Exception;//�û����
	  void secede();//�˳�ϵͳ
  }
