  
  
  package com.cx.bank.dao;
  import java.io.*;
  import com.cx.bank.mode1.*;
  
   /*����dao��ӿ�
   *@author RG
   *@version 1.3 2018/07
   */
   public interface  BankDaoInterface
   {
	   boolean register(UserBean user) throws Exception;//ע�᷽��
       boolean login(UserBean user) throws Exception;//��¼����
	   boolean transfer(String name,double money) throws Exception;//ת�˷���
	   boolean addBank(UserBean user) throws Exception;//�洢����
	   double getBalance(UserBean user) throws Exception;//����ѯ����
   }  