  
  
  package com.cx.bank.util;
  /**
  *<b>���Ϊ�����쳣��</b>
  *@author RG
  *@version 1.2 2018/06/21
  */
  public class  InvalidDepositException extends ArithmeticException
  {
	 public InvalidDepositException()//�޲εĹ��췽��
	 {
		 super();
	 }
	 public InvalidDepositException(String msg)//�вεĹ��췽��
	 {
		 super(msg);
	 }
  }
