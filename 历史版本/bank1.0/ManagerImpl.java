  
  package com.cx.bank.manager;
  import com.cx.bank.model.MoneyBean;
  /**
  *<b>ҵ���Manager��</b>
  *@author RG
  *@version 1.0 2018/06/11
  *@see com.cx.bank.model.MoneyBean
  */
  public class  ManagerImpl
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
	  public void withDrawals(double m)
	  {
		  if(m > mb.getMoney())//��ȡ�����������ȡ��ʧ��
		  {
			  System.out.println("�����˻����㣬ȡ��ʧ�ܣ�");
			  this.inquiry();
		  }
		  else if(m < 0)//��ȡ������Ϊ������ȡ��ʧ�ܣ��������ȡ�����ǰ�˻����
		  {
			  System.out.println("����ȡ�������ô���ȡ��ʧ�ܣ����������룡");
			  this.inquiry();
		  }
		  else
		  {
			  mb.setMoney(mb.getMoney() - m);//ȡ����������ý��
			  System.out.println("ȡ��ɹ�����ȡ�"+m+"Ԫ");
			  this.inquiry();
		  }
	  }
	  /**
	  *<b>�û����</b>
	  *@param m double �������
	  */
	  public void deposit(double m)
	  {
		  if(m < 0)//���������Ϊ���������ʧ�ܣ��������������ǰ�˻����
		  {
			  System.out.println("���Ĵ�������ô��󣬴��ʧ�ܣ����������룡");
			  this.inquiry();
		  }
		  else
		  {
			  mb.setMoney(mb.getMoney() + m);
			  System.out.println("���ɹ�������"+m+"Ԫ");//�����������ý��
			  this.inquiry();
		  }
	  }
  }
