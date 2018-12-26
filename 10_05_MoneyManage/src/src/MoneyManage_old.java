package src;

/**
 * ˵����ʵ����һ���򵥵ļ�ͥ�����Ϣϵͳ
 */

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Money:
 * ��������Money�ļ�������
 * @author zhaoyuan
 * @version 1.0
 */


/**
 * J5:
 * ���࣬ʵ���˽��棬��ͨ������ڲ���������¼�������
 * @author zhaoyuan
 * @version 1.0
 */
public class MoneyManage_old extends JFrame{
	private ArrayList<Money> list=new ArrayList<Money>();
	private int position=-1;
	
	private JButton addB=new JButton("����");
	private JButton modifyB=new JButton("�޸�");
	private JButton delB=new JButton("ɾ��");
	private JButton preB=new JButton("��һ��");
	private JButton nextB=new JButton("��һ��");
	private JButton saveB=new JButton("�����ļ�");
	private JButton openB=new JButton("���ļ�");
	
	private JLabel nameL=new JLabel("����");
	private JTextField nameT=new JTextField("zhaoyuan");
	private JLabel sourceL=new JLabel("��Դ");
	private JTextField sourceT=new JTextField("bonus");
	private JLabel dateL=new JLabel("����-��д��yyyymmdd��ʽ");
	private JTextField dateT=new JTextField("20071010");
	private JLabel amountL=new JLabel("��������������ʾ��֧���ø�����ʾ");
	private JTextField amountT=new JTextField("1000.0");
	
	private JLabel staticL=new JLabel("����ʱ��ε���֧ͳ��Ϊ");
	private JLabel fromL=new JLabel("��(��д��yyyymmdd��ʽ)");
	private JTextField fromT=new JTextField("",4);
	private JLabel toL=new JLabel("��(��д��yyyymmdd��ʽ)");
	private JTextField toT=new JTextField("",4);
	private JButton resultB=new JButton("����ǣ�");
	private JTextField resultT=new JTextField("",3);

	/**
	 * J5:
	 * ���췽�������Ի����棬����¼�������	 
	 */
	public MoneyManage_old() {
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(addB);
		c.add(modifyB);
		c.add(delB);
		c.add(preB);
		c.add(nextB);
		c.add(saveB);
		c.add(openB);
		
		c.add(nameL);
		c.add(nameT);
		c.add(sourceL);
		c.add(sourceT);
		c.add(dateL);
		c.add(dateT);
		c.add(amountL);
		c.add(amountT);
		
		c.add(staticL);
		c.add(fromL);
		c.add(fromT);
		c.add(toL);
		c.add(toT);
		c.add(resultB);
		c.add(resultT);
		
		addB.addActionListener(new addHandler());
		modifyB.addActionListener(new modifyHandler());
		delB.addActionListener(new delHandler());
		preB.addActionListener(new preHandler());
		nextB.addActionListener(new nextHandler());
		saveB.addActionListener(new saveHandler());
		openB.addActionListener(new openHandler());
		resultB.addActionListener(new resultHandler());
		
		setVisible(true);
		setSize(900,300);
		// TODO Auto-gene
	}
	
	/**
	 * refresh:
	 * ��Ա������ͨ�������ı�������ʾ����Ϣ�����½���
	 * @param i list�������С��ֵ	
	 */
 public void refresh(int i)
 {
	 nameT.setText(list.get(i).name);
	 sourceT.setText(list.get(i).source);
	 dateT.setText(list.get(i).date);
	 amountT.setText(list.get(i).amount);
 }
 
 /**
  * myInfo:
  * ��Ա���������ı��������Ϣ����Ϊ�Լ�����Ϣ  
  */
 public void myInfo()
 {
	 nameT.setText("zhaoyuan");
	 sourceT.setText("bonus");
	 dateT.setText("20071010");
	 amountT.setText("1000.0");
 }
 
	/**
	 * addHandler:
	 * �ڲ��ࡪ�������˵������ӡ���ťʱ�����Ĳ�������Ӽ�¼��list��
	 * @author student
	 * @version 1.0
	 */
class addHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		if(nameT.getText().equals("")|| sourceT.getText().equals("")||
				dateT.getText().equals("")||amountT.getText().equals(""))
			JOptionPane.showMessageDialog(null, "����һ�����Ϊ�գ�����������");
		else
		{
			Money money=new Money();
			
			money.name=nameT.getText();
			money.source=sourceT.getText();
			money.date=dateT.getText();
			money.amount=amountT.getText();		
			list.add(money);
			
			position=list.size()-1;		
			refresh(position);
			JOptionPane.showMessageDialog(null, "�����");
		}
		
	}
}

/**
 * modifyHandler:
 * �ڲ��ࡪ�������˵�����޸ġ���ťʱ�����Ĳ������޸ĵ�ǰ��¼
 * @author student
 * @version 1.0
 */
class modifyHandler implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
	if(list.size()==0)
	{
		 JOptionPane.showMessageDialog(null, "��¼Ϊ��");
		   myInfo();
	}
	else
	{
		Money money=(Money)list.get(position);
		
		list.get(position).name=nameT.getText();
		list.get(position).source=sourceT.getText();
		list.get(position).date=dateT.getText();
		list.get(position).amount=amountT.getText();
		
		refresh(position);
		JOptionPane.showMessageDialog(null, "���޸�");
	}
	
}
	
}

/**
 * delHandler:
 * �ڲ��ࡪ�������˵����ɾ������ťʱ�����Ĳ�����ɾ����ǰ��¼
 * @author student
 * @version 1.0
 */
class delHandler implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
	if(list.size()==0)
		{
		 JOptionPane.showMessageDialog(null, "��¼Ϊ��");
		   myInfo();
		}
	else
	{
		Money money=new Money();
		if(list.size()==1)
		{
			list.remove(position);
			myInfo();		
		}
		else
		{
			if(position==list.size()-1)
			{
				list.remove(position);
				position=list.size()-1;
			}
			else
				list.remove(position);
			
			refresh(position);
			JOptionPane.showMessageDialog(null, "��ɾ��");
		}
	}
	
  }
			
}

/**
 * preHandler:
 * �ڲ��ࡪ�������˵������һ������ťʱ�����Ĳ�������ǰ��¼�����һ����¼
 * @author student
 * @version 1.0
 */
class preHandler implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
	if(position==0)
		JOptionPane.showMessageDialog(null, "�Ѿ��ǵ�һ����¼");
	else
	{
		position--;
		refresh(position);
	}
		
}
}

/**
 * addHandler:
 * �ڲ��ࡪ�������˵������һ������ťʱ�����Ĳ�������ǰ��¼�����һ����¼
 * @author student
 * @version 1.0
 */
class nextHandler implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
	if(position==list.size()-1)
		JOptionPane.showMessageDialog(null, "�Ѿ������һ����¼");
	else
	{
		position++;
		refresh(position);
	}
}
}

/**
 * addHandler:
 * �ڲ��ࡪ�������˵�������桱��ťʱ�����Ĳ�������list��ļ�¼���浽�ļ���5.txt����
 * @author student
 * @version 1.0
 */
class saveHandler implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
	try
	{
	 FileWriter fw=new FileWriter("5.txt");
	 for(int i=0;i<list.size();i++)
	 {
		 fw.write(list.get(i).name+","+list.get(i).source+","+list.get(i).date+","+list.get(i).amount+","+"\n");
	 }
	 fw.close();/////////////////////////
	}
	catch(Exception e1)
	{
		e1.printStackTrace();
	}
}
}

/**
 * addHandler:
 * �ڲ��ࡪ�������˵�����򿪡���ťʱ�����Ĳ��������ļ���5.txt����ļ�¼������
 * @author student
 * @version 1.0
 */
class openHandler implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
	try
	{
		File f=new File("5.txt");
		if(!f.exists())
		{
			 JOptionPane.showMessageDialog(null, "�ļ�������");
			  myInfo();
		}
		else
		{
			BufferedReader br=new BufferedReader(new FileReader(f));
			String line=br.readLine();
			
			if(line==null)
			{
				 JOptionPane.showMessageDialog(null, "��¼Ϊ��");
				  myInfo();
			}
			else
			{
				list.clear();	////////////////////////////////////////////		
				while(line!=null)///////////////////////////////////////////////
				{
					String temp[]=line.split(",");
					
					Money money=new Money();////////////////////////////////////
					
					money.name=temp[0];
					money.source=temp[1];
					money.date=temp[2];
					money.amount=temp[3];					
					
					list.add(money);
					
					line=br.readLine();					
				}
				
				position=0;
				refresh(position);
			}
				
		}
		
	}
	catch(Exception e1)
	{
		e1.printStackTrace();
	}
}
}

/**
 * addHandler:
 * �ڲ��ࡪ�������˵��������ǡ���ťʱ�����Ĳ�������������ĸö�ʱ�����֧�ĺ���ʾ���ı�����
 * @author student
 * @version 1.0
 */
class resultHandler implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
	Float result=0.0f;
	for(int i=0;i<list.size();i++)
	{
		if(Float.parseFloat(list.get(i).date)>=Integer.parseInt(fromT.getText())&&
				Float.parseFloat(list.get(i).date)<=Integer.parseInt(toT.getText()))
			
			result=result+Float.parseFloat(list.get(i).amount);		
	}
	resultT.setText(String.valueOf(result));
}
}
	/**
	 * main:
	 * ������
	 * @param args	 
	 */
	public static void main(String[] args) {
		MoneyManage_old app=new MoneyManage_old();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
