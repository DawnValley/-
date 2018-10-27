  
  
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
  *ת�˽���1.5
  *@author RG
  *@version 1.5 2018/07/21
  */
  public class InputMessage extends Frame
  {
	  BankSystemScreen bss;//����ϵͳ����
	  Manager mi;//ҵ������

	  //��ǩ��
	  JLabel jl1 = new JLabel("������Է��û�����");
	  JLabel jl2 = new JLabel("������ת�˽�  ");
	  //�ı�����
	  JTextField jtf1 = new JTextField("�������û���");
	  JTextField jtf2 = new JTextField("��������");
	  //��ť��
	  JButton jb1 = new JButton("ȷ��");
	  JButton jb2 = new JButton("��");
	  public InputMessage(BankSystemScreen bs)
	  {
		  this.bss = bs;
		  this.mi = bss.mi;
		  this.init();
	  }
	  public void init()
	  {
		  jtf1.setForeground(Color.gray);//�����ı���������ɫĬ��Ϊ��ɫ
		  jtf2.setForeground(Color.gray);//�����ı���������ɫĬ��Ϊ��ɫ
		  //���ÿ�ܲ�������
		  this.setLayout(new GridLayout(3,2,5,5));
		  this.setSize(300,100);
		  this.setResizable(false);
		  this.setLocation(700,450);
		  this.setVisible(true);
		  this.setTitle("ת��");
		  this.add(jl1);
		  this.add(jtf1);
		  this.add(jl2);
		  this.add(jtf2);
		  this.add(jb1);
		  this.add(jb2);
		  //this.setAlwaysOnTop(true);//�Ѵ�����Ϊ��ǰ
		  this.show();

		  //ע���¼�
		  jtf1.addFocusListener(new LoginTextFocusListener1());//ע�������û����ı��򽹵��¼�
		  jtf2.addFocusListener(new SystemTextFocusListener1());//ע���������ı��򽹵��¼�
		  jb1.addActionListener(new InputButton1Action(this));//ע��ȷ����ť
		  jb2.addActionListener(new InputButton2Action(this));//ע��񶨰�ť
		  this.addWindowListener(new SystemWindowListener(this));//ע��Windows�¼�
	  }
  }

  /**
  *����ı������������
  *@author RG
  *@version 1.5 2018/07/19
  */
  class SystemTextFocusListener1 implements FocusListener
  {
	  public void focusGained(FocusEvent event)//�����ü��̽���ʱ����
	  {
		  JTextField tf = (JTextField)event.getSource();//��ȡ�����¼��ı���ԭ����
		  String s = tf.getText();//��ȡ�ı�������
		  if(s.equals("��������"))//����ı���ΪĬ�����ݣ�������գ����ͷŽ���
		  {
			  tf.setForeground(Color.black);//�����ı���������ɫĬ��Ϊ��ɫ
			  tf.setText("");
			  tf.requestFocus();
		  }
	  }
	  public void focusLost(FocusEvent event)//���ʧȥ���̽���ʱ����
	  {
		  JTextField tf = (JTextField)event.getSource();
		  String s = tf.getText();
		  if(s.equals(""))//����ı���Ϊ��ֵ����ΪĬ��ֵ
		  {
			  tf.setText("��������");
			  tf.setForeground(Color.gray);//�����ı���������ɫĬ��Ϊ��ɫ
		  }
	  }
  }
  /**
  *ת��ȷ����ť������
  *@author RG
  *@version 1.5 2018/07/19
  */
  class InputButton1Action implements ActionListener//ȷ����ť������
  {
	  InputMessage im;//ת�˽���
	  public InputButton1Action(InputMessage ims)
	  {
		  this.im = ims;//��ȡת�˽������
	  }
	  public void actionPerformed(ActionEvent e)
	  {
		  String name = null;//�ѵ�¼���û����û���
		  String userName = im.jtf1.getText();//ת�˵ĶԷ��û���
		  String money = im.jtf2.getText();//ת��������
		  double m = 0.0;//���
		  boolean flag = false;//ת�˽��Ϸ����λ
		  boolean fg = false;//ת�˱��λ
		  int count = 0;//С������������
		  char[] ch = money.toCharArray();//������ı�����õ��ַ���ת�����ַ�����
		  name = this.im.bss.bls.userName;//�õ���ǰ�û���
		  //����Է��˺�Ϊ��¼�û���������ʾ�򣬷��������һ���ж�
		  if(userName.equals(name) == true)
		  {
			  JOptionPane.showMessageDialog(null,"ת���û�Ϊ��ǰ�û�������������");
		  }
		  else
		  {
			  for(int i = 0;i<money.length();i++)
			  {//�ַ�������ַ�������Ϸ��ַ��Ƚ�
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
				  count = 0;
			  }
			  if(flag == false)//������Ϸ����λΪ�٣�����ת�˲���
			  {
				  m = Double.parseDouble(money);//������ַ���ת����double����
				  try
				  {
					  fg = im.mi.transfer(userName,m);//ִ��ҵ���ת�˷���
				  }
				  catch(Exception ee)
				  {
					  System.out.println(ee);
				  }finally
				  {
					  if(fg == true)//ת�˱��λΪ�棬ת�˳ɹ�������ʧ��
					  {
						  System.out.println("ת�˳ɹ���");
						  JOptionPane.showMessageDialog(null,"ת�˳ɹ�����ת�"+m+"Ԫ");//��ʾת��ɹ���ʾ��Ϣ
						  //�����ı���
						  im.jtf1.setText("�������û���");
						  im.jtf2.setText("��������");
						  this.im.dispose();//�رյ�ǰ����
						  this.im.bss.setEnabled(true);//�ϼ�������Ϊ������״̬
					  }
					  else
					  {
						  System.out.println("ת��ʧ�ܣ�");
						  JOptionPane.showMessageDialog(null,"ת��ʧ�ܣ�");
					  }
				  }
			  }
			  else//������Ϸ����λΪ�棬�������������뵯��
			  {
				  JOptionPane.showMessageDialog(null,"����������");
				  //�����ı�������ΪĬ��ֵ
				  im.jtf1.setText("�������û���");
				  im.jtf2.setText("��������");
			  }
			  
		  }
	  }	  
  }
  /**
  *ת�˷񶨰�ť������
  *@author RG
  *@version 1.5 2018/07/19
  */
  class InputButton2Action implements ActionListener//��ť������
  {
	  InputMessage im;//ת�˽���
	  public InputButton2Action(InputMessage ims)
	  {
		  this.im = ims;//ת�˽������
	  }
	  public void actionPerformed(ActionEvent e)
	  {
		  //�����ı�������ΪĬ��ֵ
		  im.jtf1.setText("�������û���");
		  im.jtf2.setText("��������");
	  }	  
  }
  /**
  *Windows�˳�������
  *@author RG
  *@version 1.5 2018/07/19
  */
  class SystemWindowListener extends WindowAdapter
  {
	  InputMessage im;//ת�˽���
	  public SystemWindowListener(InputMessage ims)
	  {
		  this.im = ims;//ת�˽������
	  }
	  public void windowClosing(WindowEvent wevent)//�ر�
	  {
		  //�����ı�������ΪĬ��ֵ
		  im.jtf1.setText("�������û���");
		  im.jtf2.setText("��������");
		  im.dispose();//�رյ�ǰ����
		  im.bss.setEnabled(true);//��������ϵͳ����Ϊ������״̬
      }
  }

