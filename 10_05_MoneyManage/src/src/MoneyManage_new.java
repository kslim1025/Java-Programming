package src;

/*
 * MoneyManage.java:
 * ����ļ����������µ��ࣺ
 * ����:MoneyManage;
 * �ࣺMoney;
 * �ڲ��ࣺaddHandler,modifyHandler,delHandler,nextHandler,preHandler,saveHandler,openHandler,resultHandler
 * 
 */

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
 * Money: ��������Money�ļ�������
 * 
 * @author ZhangYuchao
 * @version 1.0
 */
class Money
{
	public String name = null;
	public String source = null;
	public String date = null;
	public String amount = null;
}

/**
 * MoneyManage: ���࣬ʵ���˽��棬��ͨ������ڲ���������¼�������
 * 
 * @author ZhangYuchao
 * @version 1.0
 */
@SuppressWarnings("serial")
public class MoneyManage_new extends JFrame
{
	private ArrayList<Money> list = new ArrayList<Money>();
	private int position = -1;// λ��Ϊ-1��ʾ�в�����Ԫ��

	private JButton addB = new JButton("����");
	private JButton modifyB = new JButton("�޸�");
	private JButton delB = new JButton("ɾ��");
	private JButton preB = new JButton("��һ��");
	private JButton nextB = new JButton("��һ��");
	private JButton saveB = new JButton("�����ļ�");
	private JButton openB = new JButton("���ļ�");

	private JLabel nameL = new JLabel("����");
	private JTextField nameT = new JTextField("", 4);
	private JLabel sourceL = new JLabel("��Դ");
	private JTextField sourceT = new JTextField("", 4);
	private JLabel dateL = new JLabel("����-yyyymmdd");
	private JTextField dateT = new JTextField("", 4);
	private JLabel amountL = new JLabel("��������������ʾ��֧���ø�����ʾ");
	private JTextField amountT = new JTextField("", 4);

	private JLabel staticL = new JLabel("����ʱ��ε���֧ͳ��Ϊ");
	private JLabel fromL = new JLabel("��(yyyymmdd)");
	private JTextField fromT = new JTextField("", 4);
	private JLabel toL = new JLabel("��(yyyymmdd)");
	private JTextField toT = new JTextField("", 4);
	private JButton resultB = new JButton("����ǣ�");
	private JTextField resultT = new JTextField("", 3);

	/**
	 * MoneyManage(): ���췽������ʼ�����棬����¼�������
	 */
	public MoneyManage_new()
	{
		Container c = getContentPane();
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

	}

	/**
	 * refresh: ��Ա������ͨ�������ı�������ʾ����Ϣ�����½���
	 * 
	 * @param i
	 *            list�������С��ֵ
	 */
	public void refresh(int i)
	{
		nameT.setText(list.get(i).name);
		sourceT.setText(list.get(i).source);
		dateT.setText(list.get(i).date);
		amountT.setText(list.get(i).amount);
	}

	/**
	 * setEmptyInfo: ��Ա���������ı��������Ϣ����Ϊ�հ���Ϣ
	 */
	public void setEmptyInfo()
	{
		nameT.setText("");
		sourceT.setText("");
		dateT.setText("");
		amountT.setText("");
	}

	/**
	 * addHandler: �ڲ��ࡪ��ʵ���˵������ӡ���ťʱ�����Ĳ�������Ӽ�¼��list��
	 * 
	 * @author ZhangYuchao
	 * @version 1.0
	 */
	class addHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (nameT.getText().equals("") || sourceT.getText().equals("") || dateT.getText().equals("")
					|| amountT.getText().equals(""))
				JOptionPane.showMessageDialog(null, "����һ�����Ϊ�գ�����������");
			else
			{
				Money money = new Money();

				money.name = nameT.getText();
				money.source = sourceT.getText();
				money.date = dateT.getText();
				money.amount = amountT.getText();
				list.add(money);

				position = list.size() - 1;// positionλ��ʼ��ָ���β����һ���ڶ�β���
				refresh(position);
				JOptionPane.showMessageDialog(null, "�����");
			}

		}
	}

	/**
	 * modifyHandler: �ڲ��ࡪ��ʵ���˵�����޸ġ���ťʱ�����Ĳ������޸ĵ�ǰ��¼
	 * 
	 * @author ZhangYuchao
	 * @version 1.0
	 */
	class modifyHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (list.size() == 0)
			{
				JOptionPane.showMessageDialog(null, "��¼Ϊ��");
				setEmptyInfo();
			}
			else
			{
				list.get(position).name = nameT.getText();// �ӱ��Ŀ��ж�ȡ��Ϣ���浽list��
				list.get(position).source = sourceT.getText();
				list.get(position).date = dateT.getText();
				list.get(position).amount = amountT.getText();

				refresh(position);
				JOptionPane.showMessageDialog(null, "���޸�");
			}

		}

	}

	/**
	 * delHandler: �ڲ��ࡪ��ʵ���˵����ɾ������ťʱ�����Ĳ�����ɾ����ǰ��¼
	 * 
	 * @author student
	 * @version 1.0
	 */
	class delHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (list.size() == 0)
			{
				JOptionPane.showMessageDialog(null, "��¼Ϊ��");
				setEmptyInfo();
			}
			else
			{
				if (list.size() == 1)
				{
					list.remove(position);
					setEmptyInfo();
				}
				else
				{
					if (position == list.size() - 1)
					{
						list.remove(position);
						position = list.size() - 1;
					}
					else
						list.remove(position);

					refresh(position);// ɾ��һ����¼��ˢ�³����λ�õ���Ԫ��
					JOptionPane.showMessageDialog(null, "��ɾ��");
				}
			}

		}

	}

	/**
	 * preHandler: �ڲ��ࡪ��ʵ���˵������һ������ťʱ�����Ĳ�������ǰ��¼�����һ����¼
	 * 
	 * @author student
	 * @version 1.0
	 */
	class preHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (position == -1)
				JOptionPane.showMessageDialog(null, "��û�м�¼");

			else if (position == 0)
				JOptionPane.showMessageDialog(null, "�Ѿ��ǵ�һ����¼");
			else
			{
				position--;
				refresh(position);// ˢ�³���λ�õ�Ԫ����ʾ�ڽ�����
			}

		}
	}

	/**
	 * addHandler: �ڲ��ࡪ��ʵ���˵������һ������ťʱ�����Ĳ�������ǰ��¼�����һ����¼
	 * 
	 * @author student
	 * @version 1.0
	 */
	class nextHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (position == -1)
				JOptionPane.showMessageDialog(null, "��û�м�¼");

			else if (position == list.size() - 1)
				JOptionPane.showMessageDialog(null, "�Ѿ������һ����¼");
			else
			{
				position++;
				refresh(position);
			}
		}
	}

	/**
	 * addHandler: �ڲ��ࡪ��ʵ���˵�������桱��ťʱ�����Ĳ�������list��ļ�¼���浽�ļ�����֧��¼�浵�ļ�.txt����
	 * 
	 * @author student
	 * @version 1.0
	 */
	class saveHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				FileWriter fw = new FileWriter("��֧��¼�浵�ļ�.txt");
				for (int i = 0; i < list.size(); i++)
				{
					fw.write(list.get(i).name + "," + list.get(i).source + "," + list.get(i).date + ","
							+ list.get(i).amount + "," + "\r\n");
				}
				fw.close();
				JOptionPane.showMessageDialog(null, "��֧��¼����ɹ���");
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}

	/**
	 * addHandler: �ڲ��ࡪ��ʵ���˵�����򿪡���ťʱ�����Ĳ��������ļ�����֧��¼�浵�ļ�.txt����ļ�¼������
	 * 
	 * @author ZhangYuchao
	 * @version 1.0
	 */
	class openHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				File f = new File("��֧��¼�浵�ļ�.txt");
				if (!f.exists())
				{
					JOptionPane.showMessageDialog(null, "�ļ�������");
					setEmptyInfo();
				}
				else
				{
					BufferedReader br = new BufferedReader(new FileReader(f));
					String line = br.readLine();// ��ȡһ���ַ�������

					if (line == null)
					{
						JOptionPane.showMessageDialog(null, "��¼Ϊ��");
						setEmptyInfo();
					}
					else
					{
						list.clear();
						while (line != null)
						{
							String temp[] = line.split(",");

							Money money = new Money();

							money.name = temp[0];
							money.source = temp[1];
							money.date = temp[2];
							money.amount = temp[3];

							list.add(money);

							line = br.readLine();// ���������¶�һ�У���Ϊд���ʱ��ÿ����¼���˶�д���˸�"\r\n"
						}
						position = 0;// �ӵ�0����¼�����ݿ�ʼ��ʾ
						refresh(position);
					}

				}

			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}

	/**
	 * addHandler: �ڲ��ࡪ��ʵ���˵��������ǡ���ťʱ�����Ĳ�������������ĸö�ʱ�����֧�ĺ���ʾ���ı�����
	 * 
	 * @author ZhangYuchao
	 * @version 1.0
	 */
	class resultHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Float result = 0.0f;
			for (int i = 0; i < list.size(); i++)
			{
				if (Float.parseFloat(list.get(i).date) >= Integer.parseInt(fromT.getText())
						&& Float.parseFloat(list.get(i).date) <= Integer.parseInt(toT.getText()))

					result = result + Float.parseFloat(list.get(i).amount);
			}
			resultT.setText(String.valueOf(result));
		}
	}

	/**
	 * main: ������
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		MoneyManage_new app = new MoneyManage_new();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(570, 180);
		app.setVisible(true);

	}

}
