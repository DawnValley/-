  
  package com.cx.bank.test;
  import java.awt.*;
  import java.awt.event.*;
  import javax.swing.*;
  import java.util.*;
  import java.io.*;
  import com.cx.bank.manager.*;
  import com.cx.bank.util.*;
  import com.cx.bank.test.*;

  /**
  *����ϵͳ1.5
  *@author RG
  *@version 1.5 2018/07/20
  */
  public class BankSystemScreen extends JFrame
  {
	  BankLoginScreen bls;//��¼����Ķ���
	  InputMessage ims;//ת�˽���
	  Manager mi;//ҵ������
	  //�˵�
	  MenuBar mb = new MenuBar();
	  
	  //��ť��
	  JButton jb1 = new JButton("��ѯ���");
	  JButton jb2 = new JButton("ȡ��");
	  JButton jb3 = new JButton("���");
	  JButton jb4 = new JButton("ת��");
	  JButton jb5 = new JButton("�˳�ϵͳ");

	  public BankSystemScreen(BankLoginScreen bl)//���췽��
	  {
		  this.bls = bl;
		  this.mi = bls.mi;
		  this.init();
	  }
	  public void init()//��ʼ�����
	  {
		  //�˵����ֺ����
		  Menu m = new Menu("����");
		  m.add("��ӭ");
		  m.addSeparator();//��Ӽ��
	      MenuItem mi1 = new MenuItem("������һ��");
		  MenuItem mi2 = new MenuItem("�˳�");
		  m.add(mi1);
		  m.add(mi2);
		  mb.add(m);
		  this.setMenuBar(mb);

		  //��ܰ�ť����-���񲼾�
		  this.setTitle("����ϵͳ");
		  this.setLayout(new FlowLayout());
		  this.setSize(300,400);
		  this.setResizable(false);//���ÿ�ܽ����Ƿ�ɵ���С����
		  this.setLocation(700,300);
		  this.setVisible(true);

		  JPanel jp = new JPanel(new GridLayout(5,1,20,20));
		  jp.add(jb1);
		  jp.add(jb2);
		  jp.add(jb3);
		  jp.add(jb4);
		  jp.add(jb5);
		  this.add(jp);

		  //ע���¼�
		  this.addWindowListener(new LoginWindowListener(this.bls));//ע��Windows�¼�
		  jb1.addActionListener(new SystemButton1Action(this.mi));//ע���ѯ��ť�¼�
		  jb2.addActionListener(new SystemButton2Action(this.mi));//ע��ȡ�ť�¼�
		  jb3.addActionListener(new SystemButton3Action(this.mi));//ע���ť�¼�
		  jb4.addActionListener(new SystemButton4Action(this));//ע��ת�˰�ť�¼�
		  jb5.addActionListener(new LoginMenu1Action(this.bls));//ע���˳���ť�¼�
		  mi1.addActionListener(new SystemMenuItem1Action(this));//ע�᷵����һ��˵����¼�
		  mi2.addActionListener(new LoginMenu1Action(this.bls));//ע���˳��˵����¼�

		  this.show();//��ʾ������
	  }
  }
  /**
  *������һ��˵��������
  *@author RG
  *@version 1.5 2018/07/20
  */
  class SystemMenuItem1Action implements ActionListener
  {
	  BankSystemScreen bss;
	  public SystemMenuItem1Action(BankSystemScreen bs)
	  {
		  this.bss = bs;
	  }
	  public void actionPerformed(ActionEvent e)
	  {
		  this.bss.dispose();//�رյ�ǰ����
		  this.bss.bls.show();//����һ�㴰��
	  }
  }
  /**
  *��ѯ��ť������
  *@author RG
  *@version 1.5 2018/07/20
  */
  class SystemButton1Action implements ActionListener
  {
	  Manager mi;
	  public SystemButton1Action(Manager m)
	  {
		  this.mi = m;
	  }
	  public void actionPerformed(ActionEvent e)
	  {
		  String s = null;
		  s = mi.inquiry();//����ҵ����ѯ������ȡ������ַ���
		  JOptionPane.showMessageDialog(null,"�����˻����Ϊ��"+s+"Ԫ");
	  }
  }
  /**
  *ȡ�ť������
  *@author RG
  *@version 1.5 2018/07/20
  */
  class SystemButton2Action implements ActionListener
  {
	  Manager mi;
	  public SystemButton2Action(Manager m)
	  {
		  this.mi = m;
	  }
	  public void actionPerformed(ActionEvent ae)
	  {
		  String inputValue = null;//�����ı������ݵ��ַ���
		  boolean flag = true;//���벻�Ϸ����λ
		  double d = 0.0;//���
		  int count = 0;//С�������������
		 
		  inputValue = JOptionPane.showInputDialog("������ȡ���");
		  //����ı�������Ϊ�մ�����null�����벻�Ϸ����λ��Ϊ��
		  if("".equals(inputValue)||inputValue == null)
		  {
			  flag = true;
		  }
		  else
		  {//���������ݣ����Ϸ����λ��٣��ж��Ƿ�Ϊ���ֻ�С���㣬�������ֲ��Ϸ����λ��Ϊ�棬
		  //���ж�С�����������������1���Ϸ����λҲ����
			  flag = false;
			  char[] ch = inputValue.toCharArray();//���ı�����õ��ַ���ת�����ַ�����
			  for(int i = 0;i<inputValue.length();i++)//�ַ�������ַ�������Ϸ��ַ��Ƚ�
			  {
				  if("0123456789.".indexOf(ch[i])<0||"0123456789.".indexOf(ch[i])>=11)
				  {//������ںϷ��ַ���Χ�ڣ����Ϸ����λ���棬�˳�ѭ���Ƚ�
					  flag = true;
					  break;
				  }
				  if(".".indexOf(ch[i])==0)//���һ��ѭ�����ַ���С���㣬С���������1
				  {
					  count=count+1;
				  }
			  }
			  if(count > 1) //���С�����������1�����Ϸ����λ����
			  {
				  flag = true;
			  }
		  }
		  if(flag == true)//������Ϸ����λΪ�棬�������������뵯��
		  {
			  JOptionPane.showMessageDialog(null,"����������");
		  }
		  if(flag == false)//������Ϸ����λΪ�٣�����ȡ�����
		  {
			  boolean f = false;//ȡ����λ
			  d = Double.parseDouble(inputValue);
			  try{
				  f = mi.withDrawals(d);
			  }catch(InvalidWithDrawalstException e)
			  {//����ȡ���Ϊ�����쳣
				  System.out.println(e);
			  }catch(AccountOverDrawnException e)
			  {//����ȡ��������쳣
				  System.out.println(e);
			  }catch(Exception e)
			  {//����ȡ���쳣
				  System.out.println(e);
			  }finally
			  {
				  if(f == true)//ȡ����λΪ�棬ȡ��ɹ�������ʧ��
				  {
					  JOptionPane.showMessageDialog(null,"ȡ��ɹ�,��ȡ�"+d+"Ԫ��");
				  }
				  else
				  {
					  JOptionPane.showMessageDialog(null,"ȡ��ʧ�ܣ�");
				  }
				  mi.inquiry();//��ѯ���
			  }
		  }  
	  }
  }
  /**
  *��ť������
  *@author RG
  *@version 1.5 2018/07/21
  */
  class SystemButton3Action implements ActionListener//��ť�¼�
  {
	  Manager mi;
	  public SystemButton3Action(Manager m)
	  {
		  this.mi = m;
	  }
	  public void actionPerformed(ActionEvent e)
	  {
		  String inputValue = null;//�����ı������ݵ��ַ���
		  double d = 0.0;//���
		  boolean flag = true;//���벻�Ϸ����λ
		  int count = 0;//С�������������
		  
		  inputValue = JOptionPane.showInputDialog("���������");
		  //����ı�������Ϊ�մ�����null�����벻�Ϸ����λ��Ϊ��
		  if("".equals(inputValue)||inputValue == null)
		  {//���������ݣ����Ϸ����λ��٣��ж��Ƿ�Ϊ���ֻ�С���㣬�������ֲ��Ϸ����λ��Ϊ�棬
		  //���ж�С�����������������1���Ϸ����λҲ����
			  flag = true;
		  }
		  else
		  {
			  flag = false;
			  char[] ch = inputValue.toCharArray();//���ı�����õ��ַ���ת�����ַ�����
			  for(int i = 0;i<inputValue.length();i++)//�ַ�������ַ�������Ϸ��ַ��Ƚ�
			  {
				  if("0123456789.".indexOf(ch[i])<0||"0123456789.".indexOf(ch[i])>=11)
				  {//������ںϷ��ַ���Χ�ڣ����Ϸ����λ���棬�˳�ѭ���Ƚ�
					  flag = true;
					  break;
				  }
				  if(".".indexOf(ch[i])==0)//���һ��ѭ�����ַ���С���㣬С���������1
				  {
					  count=count+1;
				  }
			  }
			  if(count > 1)//���С�����������1�����Ϸ����λ����
			  {
				  flag = true;
			  }
		  }
		  if(flag == true)//������Ϸ����λΪ�棬�������������뵯��
		  {
			  JOptionPane.showMessageDialog(null,"���ʧ�ܣ����������룡");
		  }
		  if(flag == false)//������Ϸ����λΪ�٣�����ȡ�����
		  {
			  boolean f = false;//�����λ
			  d = Double.parseDouble(inputValue);
			  try{
				  f = mi.deposit(d);
			  }catch(InvalidDepositException ee)
			  {//�������Ϊ�����쳣
				  System.out.println(ee);
			  }catch(Exception ee)
			  {//����ȡ���쳣
				  System.out.println(ee);
			  }finally
			  {//ȡ����λΪ�棬ȡ��ɹ�������ʧ��
				  if(f == true)
				  {
					  JOptionPane.showMessageDialog(null,"���ɹ�,����"+d+"Ԫ��");
				  }
				  else
				  {
					  JOptionPane.showMessageDialog(null,"���ʧ�ܣ�");
				  }
				  mi.inquiry();//��ѯ���
			  }
		  }  
	  }
  }
  /**
  *ת�˰�ť������
  *@author RG
  *@version 1.5 2018/07/21
  */
  class SystemButton4Action implements ActionListener
  {
	  BankSystemScreen bss;//ϵͳ����
	  public SystemButton4Action(BankSystemScreen bs)
	  {
		  this.bss = bs;//��ȡϵͳ�������
	  }
	  public void actionPerformed(ActionEvent e)
	  {
		  bss.setEnabled(false);//����ϵͳ���洰��Ϊ��������
		  //���ת�˽���Ϊnull�½�ת�˽�����󣬷�����ʾת�˽���
		  if(this.bss.ims == null)
		  {
			  this.bss.ims = new InputMessage(this.bss);
		  }
		  else this.bss.ims.show();
	  }
  }

