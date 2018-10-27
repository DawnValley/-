
   package com.cx.bank.dao;//�־ò�

   import java.util.*;
   import java.io.*;
   import com.cx.bank.mode1.*;
   import com.cx.bank.util.MD5;

   
   /**����FileDanImpl
    *�����˵���ģʽ�ļ���ģʽ
	*@author RG
	*@version 1.3 2018/07
	*/
   public class FileDaoImp1 implements BankDaoInterface
   {
	   private MD5 md5=new MD5();//˽�м������������
	   private Properties prop =new Properties();//˽���ļ����������
	   private static FileDaoImp1 instance=new  FileDaoImp1();//��������
      

	   //˽�й��췽��
	   private FileDaoImp1()
	   {   
	   }

       
	   //�õ�FileDaoImpl�����
	   public static FileDaoImp1 getInstance()
	   {
	        return instance;
	   }


       /**
	    *ע��
	    *@param user �û���Ϣ
	    */
	   public boolean register(UserBean user)
	   {
           String name=user.getUserName();//�õ�ģ�Ͳ��û���
		   String  pwd=user.getPwd();//�õ�ģ�Ͳ��û�����
		   String password=md5.getMD5(pwd);//����MD5����
		   File f=new File(name+".properties");//�����ļ�
		   if(f.exists()){
		       System.out.println("�û��Ѵ���");
			   return false;
		   }else{
               if("".equals(name)||"".equals(password)){
			   System.out.println("�û��������벻��Ϊ��!");
			   return false;
		   }
           try{            
			   FileInputStream  in  = new FileInputStream (".\\Bank.properties");
			   prop.load(in);//������ļ����ص��ڴ�
			   in.close();
		   }catch(IOException e){
			   System.out.println(e);
		   }
		   try{
			   FileOutputStream out = new FileOutputStream(f);//�ڴ�������ͨ��
			   prop.setProperty("userName",name);//��������
			   prop.setProperty("password",password);//��������
			   prop.store(out,".\\"+name+".properties");//���ڴ��ļ��洢�����
			   out.close();
		   }catch(FileNotFoundException e){
			   System.out.println(e);
		   }catch(IOException e){
		       System.out.println(e);
		   } 
			   return true;
	       } 	
        }

        /**
	    *��¼
		*@param user �û���Ϣ
	    */
		public boolean login(UserBean user){
            String name=user.getUserName();//�õ�ģ�Ͳ��û���
		    String  pwd=user.getPwd();//�õ�ģ�Ͳ��û�����
		    String password=md5.getMD5(pwd);//����MD5����
			File f=new File(name+".properties");
		    if(f.exists()==true){
				try{            
			     FileInputStream  in  = new FileInputStream (".\\"+name+".properties");
			     prop.load(in);
			     in.close();
			    }catch(IOException e){
			       System.out.println(e);
			    }
			    if(password.equals(prop.getProperty("password"))){
					   double money=Double.parseDouble((prop.getProperty("money")));
					   MoneyBean.getMoneyBean().setMoney(money);
					   return true;
				}else{
					   prop.getProperty("password");
					   return false;
				 }		        
			}else{
				    System.out.println("�û������ڣ�");
					return false;
			}				   
		}


       /**
	   *ת��
	   *@param name Ҫת����˺��û���
	   *@param money Ҫת���Ǯ
	   */
	   public boolean  transfer(String name,double money){
		  File f=new File(name+".properties");
		  if(f.exists()==true){//��Ҫ�ж�Ҫת����˺��Ƿ����
              try{            
			     FileInputStream  in  = new FileInputStream (".\\"+name+".properties");
			     prop.load(in);
			     in.close();
			  }catch(IOException e){
			       System.out.println(e);
			  }
              try{
			      FileOutputStream out = new FileOutputStream(f);  
                  String proMoney=Double.parseDouble((prop.getProperty("money")))+money+"";
			      prop.setProperty("money",proMoney);
                  prop.store(out,".\\"+name+".propertise");
			      out.close();
			  }catch(IOException e){
				   
			  }    
			  return true;
		  }else{
		     System.out.println("���˻������ڣ�");
			 return false;
		  }	   
	   }

       

	  /**
	  *�洢����
	  *@param user �û���Ϣ
	  */
	   public boolean addBank(UserBean user){
		   String name=user.getUserName();
		   File f=new File(name+".properties");//�����ļ�
		   try{            
			     FileInputStream  in  = new FileInputStream (".\\"+name+".properties");
			     prop.load(in);
			     in.close();
		   }catch(IOException e){
			       System.out.println(e);
		   } 
		   try{
				  FileOutputStream out=new FileOutputStream(f);
				  prop.setProperty("money",MoneyBean.getMoneyBean().getMoney()+"");
                  prop.store(out,".\\"+name+".propertise");
			      out.close();
		   }catch(IOException e){
				  System.out.println(e);
		   }	
		   return true;
		   
	   }


        /**
	    *��ȡ���
		*@param user �û���Ϣ
		*/
		public double getBalance(UserBean user){
		     String name=user.getUserName();
			 File f=new File(name+".properties");//�����ļ�
		     if(f.exists()){
			    try{
				   FileInputStream in = new FileInputStream(f);
				   prop.load(in);
				   in.close();
				}catch(IOException e){
				     System.out.println(e);
				}
                double money=Double.parseDouble(prop.getProperty("money"));
				return money;
			 }else{
			    return -1;//�ļ������ڷ���-1
			 }			
		}
   }
        


		
