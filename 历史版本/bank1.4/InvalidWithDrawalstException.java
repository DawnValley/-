  
  
  package com.cx.bank.util;
  /**
  *<b>ȡ��Ϊ�����쳣��</b>
  *@author RG
  *@version 1.2 2018/06/21
  */
  public class InvalidWithDrawalstException extends ArithmeticException 
  {
	 public InvalidWithDrawalstException()//�޲εĹ��췽��
	 {
		 super();
	 }
	 public InvalidWithDrawalstException(String msg)//�вεĹ��췽��
	 {
		 super(msg);
	 }
  }
