  
  
  package com.cx.bank.dao;
  import com.cx.bank.mode1.*;
  
   /*����dao��ӿ�
   *@author RG
   *@version 1.3 2018/07
   */
   public interface  BankDaoInterface
   {
	   boolean register(UserBean user);//ע�᷽��
       boolean login(UserBean user);//��¼����
	   boolean transfer(String name,double money);//ת�˷���
	   boolean addBank(UserBean user);//�洢����
	   double getBalance(UserBean user);//����ѯ����
   }  