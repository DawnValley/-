  
  
  package com.cx.bank.util;
  /**
  *<b>ȡ�������쳣��</b>
  *@author RG
  *@version 1.2 2018/06/21
  */
  public class AccountOverDrawnException extends RuntimeException 
  {
	 public AccountOverDrawnException()//�޲εĹ��췽��
	 {
		 super();
	 }
	 public AccountOverDrawnException(String msg)//�вεĹ��췽��
	 {
		 super(msg);
	 }
  }
