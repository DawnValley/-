  
  package com.cx.bank.manager;
  import com.cx.bank.mode1.MoneyBean;
  import com.cx.bank.util.*;
  /**
  *<b>ҵ���ManagerImp1��</b>
  *@author RG
  *@version 1.2 2018/06/21
  *@see com.cx.bank.model.MoneyBean
  */
  public class  ManagerImp1 implements Manager
  {
	  MoneyBean mb = MoneyBean.getMoneyBean();//MoneyBean�ĵ�������
	  public void inquiry()//��ѯ���
	  {
		  System.out.println("�����˻���ǰ���Ϊ��"+mb.getMoney()+"Ԫ");
	  }
	  /**
	  *<b>�û�ȡ��</b>
	  *@param m double ȡ������
	  */
	  public void withDrawals(double m) throws RuntimeException
	  {
		  if(m > mb.getMoney())//��ȡ�����������ȡ��ʧ��
		  {
			  throw new AccountOverDrawnException("�����˻����㣡ȡ��ʧ�ܣ����������룡");//ȡ�������������쳣
		  }
		  else if(m < 0)//��ȡ������Ϊ������ȡ��ʧ�ܣ��������ȡ�����ǰ�˻����
		  {
			  throw new InvalidWithDrawalstException("�������ȡ����Ϊ������ȡ��ʧ�ܣ����������룡");//ȡ������Ϊ�����쳣
		  }
		  else
		  {
			  mb.setMoney(mb.getMoney() - m);//ȡ����������ý��
			  System.out.println("ȡ��ɹ�����ȡ�"+m+"Ԫ");
		  }
	  }
	  /**
	  *<b>�û����</b>
	  *@param m double �������
	  */
	  public void deposit(double m) throws RuntimeException
	  {
		  if(m < 0)//���������Ϊ���������ʧ�ܣ��������������ǰ�˻����
		  {
			  throw new InvalidDepositException("������Ĵ����Ϊ���������ʧ�ܣ����������룡");  
		  }
		  else
		  {
			  mb.setMoney(mb.getMoney() + m);
			  System.out.println("���ɹ�������"+m+"Ԫ");//�����������ý��
		  }	  
	  }
	  /**
	  *<b>�˳�ϵͳ</b>
	  */
	  public void secede()
	  {
		  System.exit(0);
	  }
  }
