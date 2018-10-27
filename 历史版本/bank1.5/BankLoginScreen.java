  
  package com.cx.bank.test;
  import java.awt.*;
  import java.awt.event.*;
  import javax.swing.*;
  import java.util.*;
  import java.io.*;
  import com.cx.bank.manager.*;
  import com.cx.bank.util.*;
  import com.cx.bank.test.*;
  //javac -d . *.java          java com.cx.bank.test.BankLoginScreen

  /**
  *���е�¼����
  *@author RG
  *@version 1.6 2018/07/22
  */
  public class BankLoginScreen extends JFrame
  {  
	  String userName = null;//�ѵ�¼���û���
	  Manager mi;//ҵ������
	  BankSystemScreen bss = null;//ϵͳ����
	  //��ǩ��
	  JLabel jl1 = new JLabel("�� �� ��");
	  JLabel jl2 = new JLabel("�û�����");

	  //�ı�����
	  JTextField jt1 = new JTextField("�������û���",10);
	  JTextField jt2 = new JTextField("����������",10);

	  //��ť��
	  JButton jb1 = new JButton("ע��");
	  JButton jb2 = new JButton("��¼");

	  //�˵�
	  MenuBar mb = new MenuBar();

	  public void init()//��ʼ�����
	  {
		  //���ø�������壬��ɫ
		  jl1.setFont(new java.awt.Font("Dialog",1,24));//��dialog���������壬1������ʽ(1�Ǵ��壬0��ƽ���ģ�24���ֺ�
		  jl2.setFont(new java.awt.Font("Dialog",1,24));
		  jt1.setFont(new java.awt.Font("Dialog",0,18));
		  jt2.setFont(new java.awt.Font("Dialog",0,18));
		  jb1.setFont(new java.awt.Font("Dialog",1,20));
		  jb2.setFont(new java.awt.Font("Dialog",1,20));
		  jt1.setForeground(Color.gray);//�����ı���������ɫĬ��Ϊ��ɫ
		  jt2.setForeground(Color.gray); 

          Container ct;//����
          BackgroundPanel bgp;//�Զ���ı����� 
		  bgp=new BackgroundPanel((new ImageIcon("image01.jpg")).getImage()); //������һ��Image����
		  bgp.setLayout(null);//Ҫ����ʾ�Զ��岼�֣����ֱ�����Ϊnull
		  jl1.setBounds(125,275,100,50);//���������С��λ�á��ֱ�Ϊ���Ͻ�x,y���꣬���x,y��С
		  jt1.setBounds(275,275,200,50);
		  jl2.setBounds(125,350,100,50);
		  jt2.setBounds(275,350,200,50);
		  jb1.setBounds(150,600,100,50);
		  jb2.setBounds(350,600,100,50);
		  //������
		  bgp.add(jl1);
	      bgp.add(jt1);
	      bgp.add(jl2);
	      bgp.add(jt2);
		  bgp.add(jb1);
	      bgp.add(jb2);
		  
		  //���ÿ�ܲ��ֺ���������ʾ
		  this.setSize(600,800);//���ÿ�ܽ���ߴ�
		  this.setResizable(false);//���ÿ�ܽ����Ƿ�ɵ���С����
		  this.setLocation(750,200);//��������λ��
		  ct=this.getContentPane();		  
		  bgp.setBounds(0,0,600,800);  
		  ct.add(bgp);

		  //��Ӳ˵��Ͳ˵���
		  this.setMenuBar(mb);
		  Menu m = new Menu("����");
		  mb.add(m);
		  MenuItem mi1 = new MenuItem("�˳�");
		  m.add(mi1);

		  //ע������¼�
		  //ע���ı������̽����¼�
		  jt1.addFocusListener(new LoginTextFocusListener1());
		  jt2.addFocusListener(new LoginTextFocusListener2());
		  //ע��ע���¼��ť����¼�
		  jb1.addActionListener(new LoginButton1Action(this));
		  jb2.addActionListener(new LoginButton2Action(this));
		  //ע��˵��˳��¼�
		  mi1.addActionListener(new LoginMenu1Action(this));
		  //ע��Windows�¼�
		  this.addWindowListener(new LoginWindowListener(this));
	  }
	  public BankLoginScreen(Manager mai)//���췽��
	  {
		  this.setTitle("���е�¼ϵͳ");
		  this.mi = mai;
		  init();
	  }
	  /**
	  *���е�¼ϵͳ��������
	  *@param args �������н��յ��ַ���
	  */
	  public static void main(String[] args) 
	  {  
		  try
		  {
			  Manager mai = ManagerImp1.getInstance();//Ϊ���ӳ�ҵ��������������ڣ����������������ó�Ա��������
			  BankLoginScreen b = new BankLoginScreen(mai);
			  b.show();
		  }
		  catch (Exception ee)
		  {
			  System.out.println(ee);
		  }
	  }
  }


  /**
  *ע�ᰴť������
  *@author RG
  *@version 1.5 2018/07/19
  */
  class LoginButton1Action implements ActionListener
  {
	  BankLoginScreen bls;//��¼�������
	  public LoginButton1Action(BankLoginScreen bls)
	  {
		  this.bls = bls;
	  }
	  public void actionPerformed(ActionEvent e)//����¼�
	  {
		  String userName = bls.jt1.getText();//��ȡ��¼�����û����ı�������
		  String userPwd = bls.jt2.getText();//��ȡ��¼���������ı�������
		  boolean flag = false;//�ж�ע���Ƿ�ɹ��ı��λ
		  //�����¼���������ı�������ݲ���Ĭ�����ݣ�ע���û�������ǰѱ��λ��Ϊ��
		  if("�������û���".equals(userName)==false&&"����������".equals(userPwd)==false)
		  {
			  if(userName.length()>10) 
				  JOptionPane.showMessageDialog(null,"�û�������С��1λ,����10λ");
			  else
			  {
				  if(userPwd.length()>=6&&userPwd.length()<=16)
				  {
					  try
					  {
						  flag = bls.mi.register(userName,userPwd);//���λ��Ϊҵ���ע�᷽���ķ���ֵ
					  }
					  catch(FileNotFoundException ee)
					  {
						  System.out.println(ee);
					  }catch(IOException ee)
					  {
						  System.out.println(ee);
					  }catch(Exception ee)
					  {
						  System.out.println(ee);
					  }
				  }
				  else JOptionPane.showMessageDialog(null,"���벻��С��6λ,����16λ");
			  }
				  
		  }
		  if(flag)//���λΪ�棬ע��ɹ�
		  {
			  //System.out.println("ע��ɹ���");
			  JOptionPane.showMessageDialog(null,"ע��ɹ������¼��");
			  bls.jt1.setText("�������û���");
			  bls.jt2.setText("����������"); 
		  }
		  else
		  {
			  JOptionPane.showMessageDialog(null,"ע��ʧ��,������ע�ᣡ");
			  //System.out.println("ע��ʧ�ܣ�");
		  }
	  }	  
  }
  /**
  *��¼��ť������
  *@author RG
  *@version 1.5 2018/07/19
  */
  class LoginButton2Action implements ActionListener
  {
	  BankLoginScreen bls;
	  public LoginButton2Action(BankLoginScreen bls)
	  {
		  this.bls = bls;
	  }
	  public void actionPerformed(ActionEvent e)
	  {
		  String userName=bls.jt1.getText();//��ȡ��¼�����û����ı�������
		  String userPwd=bls.jt2.getText();//��ȡ��¼���������ı�������
		  boolean flag = false;//�жϵ�¼�Ƿ�ɹ��ı��λ
		  //�����¼���������ı�������ݲ���Ĭ�����ݣ��û���¼
		  if("�������û���".equals(userName)==false&&"����������".equals(userPwd)==false)
		  {
			  try
			  {
				  flag = bls.mi.login(userName,userPwd);//���λ��Ϊҵ����¼�����ķ���ֵ
			  }
			  catch(FileNotFoundException ee)
			  {
				  System.out.println(ee);
			  }catch(IOException ee)
			  {
				  System.out.println(ee);
			  }catch(Exception ee)
			  {
				  System.out.println(ee);
			  }
		  }
		  else flag = false;
		  if(flag == true)//������λΪ�棬��¼�ɹ�,���򵯳���¼ʧ����ʾ����
		  {
			  System.out.println("��¼�ɹ���");
			  JOptionPane.showMessageDialog(null,"��¼�ɹ���");
			  //this.bankSystemTest(mi);
			  /*���ظ�����
			  �ѽ���������ʽ����BankSystemScreen���е�������صİ�
			  */
			  //���ı���λ
			  bls.jt1.setText("�������û���");
			  bls.jt2.setText("����������");
			  bls.jt1.setForeground(Color.gray);
			  bls.jt2.setForeground(Color.gray);

			  bls.userName = userName;//ȡ�õ�ǰ��¼���û���
			  bls.dispose();//�رյ�ǰ��¼����
			  //���ϵͳ�������Ϊnull�򴴽����󣬷�����ʾ����ϵͳ����
			  if(this.bls.bss == null)
			  {
				  this.bls.bss = new BankSystemScreen(bls);
			  }
			  else
			  {
				  this.bls.bss.show();
			  }
		  }
		  else
		  {
			  JOptionPane.showMessageDialog(null,"��¼ʧ�ܣ������µ�¼��");
			  System.out.println("��¼ʧ�ܣ������µ�¼��");
		  }
	  }
  }
  /**
  *�˵��˳�������
  *@author RG
  *@version 1.5 2018/07/19
  */
  class LoginMenu1Action implements ActionListener
  {
	  BankLoginScreen bls;
	  public LoginMenu1Action(BankLoginScreen bls)
	  {
		  this.bls = bls;
	  }
	  public void actionPerformed(ActionEvent ee)
	  {
		  try{
			  bls.mi.secede();//����ҵ����˳�����
		  }catch(FileNotFoundException e){
			  System.out.println(e);
		  }catch(IOException e){
			  System.out.println(e);
		  }catch(Exception e){
			  System.out.println(e);
		  }
      }
  }
  /**
  *�û����ı������������
  *@author RG
  *@version 1.5 2018/07/19
  */
  class LoginTextFocusListener1 implements FocusListener
  {
	  public void focusGained(FocusEvent event)//�����ü��̽���ʱ����
	  {
		  JTextField tf = (JTextField)event.getSource();//��ȡ�����¼��ı���ԭ����
		  String s = tf.getText();//��ȡ�ı�������
		  if(s.equals("�������û���"))//����ı���ΪĬ�����ݣ�������գ����ͷŽ���
		  {
			  tf.setForeground(Color.black);//�����ı���������ɫΪ��ɫ
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
			  tf.setText("�������û���");
			  tf.setForeground(Color.gray);//�����ı���������ɫĬ��Ϊ��ɫ
		  }
	  }
  }
  /**
  *�����ı������������
  *@author RG
  *@version 1.5 2018/07/19
  */
  class LoginTextFocusListener2 implements FocusListener
  {
	  public void focusGained(FocusEvent event)//�����ü��̽���ʱ����
	  {
		  JTextField tf = (JTextField)event.getSource();//��ȡ�����¼��ı���ԭ����
		  String s = tf.getText();//��ȡ�ı�������
		  if(s.equals("����������"))//����ı���ΪĬ�����ݣ�������գ����ͷŽ���
		  {
			  tf.setForeground(Color.black);
			  tf.setText("");
			  tf.requestFocus();
		  }
	  }
	  public void focusLost(FocusEvent event)//���ʧȥ���̽���ʱ���á�
	  {
		  JTextField tf = (JTextField)event.getSource();
		  String s = tf.getText();
		  if(s.equals(""))//����ı���Ϊ��ֵ����ΪĬ��ֵ
		  {
			  tf.setText("����������");
			  tf.setForeground(Color.gray);
		  }
	  }
  }
  /**
  *Windows�˳�������
  *@author RG
  *@version 1.5 2018/07/19
  */
  class LoginWindowListener extends WindowAdapter
  {
	  BankLoginScreen bls;
	  public LoginWindowListener(BankLoginScreen bls)
	  {
		  this.bls = bls;
	  }
	  public void windowClosing(WindowEvent wevent)
	  {
		  try{
		      //bls.getManager().secede();
			  bls.mi.secede();//����ҵ����˳�����
		  }catch(FileNotFoundException e){
			  System.out.println(e);
		  }catch(IOException e){
			  System.out.println(e);
		  }catch(Exception e){
			  System.out.println(e);
		  }
      }
  }
  /**
  *�Զ��屳����
  *@author RG
  *@version 1.5 2018/07/22
  */
  class BackgroundPanel extends JPanel  
  {  
	  Image im;  
	  public BackgroundPanel(Image im)  
	  {  
		  this.im=im;  
		  this.setOpaque(true);//���ÿؼ���͸��,����false,��ô����͸��
	  }  
	  public void paintComponent(Graphics g)//��ͼ��,����ɼ�������Java �� java-Graphics 
	  {  
		  super.paintComponents(g);  
		  g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);  //����ָ��ͼ���е�ǰ���õ�ͼ��ͼ������Ͻ�λ�ڸ�ͼ������������ռ�� (x, y)��ͼ���е�͸�����ز�Ӱ��ô��Ѵ��ڵ�����
	  }  
  }

