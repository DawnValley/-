  
  
  package com.cx.bank.mode1;
  
  /**����һ���û���
   *�����û��������Լ�����
   *@author RG
   *@version 1.3 2018/07
   */
  public class UserBean  
  {
	  private String userName;
	  private String pwd;
      
      /*�޲ι�����*/
	  public UserBean(){
	  }
  
      /*�вι�����*/
	  public UserBean(String userName,String pWd){
	     this.userName=userName;
		 this.pwd=pwd;
	  }

      /*��������*/
      public void setUserName(String userName){
	      this.userName=userName;
	  }

      /*ȡ������*/
	  public String getUserName(){
	       return this.userName;
	  }
    
	  /*��������*/
	  public void setPwd(String pwd){
	      this.pwd=pwd;
	  }
      
	  /*ȡ������*/
	  public String getPwd(){
	       return this.pwd;
	  }
	
  }
