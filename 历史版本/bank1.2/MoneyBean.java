  
  
  package com.cx.bank.mode1;
  /**<b>ģ�Ͳ�MoneyBean��</b>
  *@author RG
  *@version 1.0 2018/06/11
  */
  public class  MoneyBean
  {
	  private double money;//�洢�û��Ĵ��
	  private static MoneyBean moneyBean;//�����ı������

	  
	  private MoneyBean()//˽�л����޲ι��췽��
	  {
		  this.money = 0.0;
	  }

	  /**
	  *<b>���ý��</b>
	  *@param m double ���õĽ��
	  */
	  public void setMoney(double m)
	  {
		  this.money = m;
	  }
	  public double getMoney()//��ȡ��ǰ���
	  {
		  return this.money;
	  }
	  public static MoneyBean getMoneyBean()//���ض���ĵ�ַ
	  {
		  if(moneyBean == null) moneyBean = new MoneyBean();//����ģʽ���������Ϊ���򴴽�moneyBean����
		  return moneyBean;
	  }

  }
