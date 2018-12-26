package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Othello: ���ࣺʵ���˽��桢����ÿ����ť�������ڲ�����ʵ���¼��������ܣ�ÿ�����̸�����button��ʾ��
 *
 * @author zhaoyuan
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Othello extends JFrame
{

	private boolean isBlackPlay = true;// �Ƿ��Ǻ�������
	boolean gameOver = false;
	private int blackChess = 0, whiteChess = 0;
	private int data[][] = new int[4][4];

	private JPanel p1 = new JPanel();
	private JButton newB = new JButton("���¿�ʼ");
	private JButton saveB = new JButton("����");
	private JButton openB = new JButton("����");
	private JButton exitB = new JButton("�˳�");

	private JPanel p2 = new JPanel();
	private JButton button[][] = new JButton[4][4];

	/**
	 * Othello(): ���췽����ʵ���˽��棬Ϊ�����������¼�������
	 */
	public Othello()
	{
		Container c = getContentPane();

		c.add(p1, BorderLayout.NORTH);
		p1.add(newB);
		p1.add(saveB);
		p1.add(openB);
		p1.add(exitB);

		c.add(p2, BorderLayout.CENTER);
		p2.setLayout(new GridLayout(4, 4));

		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				button[i][j] = new JButton("");
			}
		}
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				p2.add(button[i][j]);
				button[i][j].setBackground(Color.GREEN);
				button[i][j].addActionListener(new Handler(i, j));
			}
		}
		button[1][1].setBackground(Color.WHITE);
		button[1][2].setBackground(Color.BLACK);
		button[2][1].setBackground(Color.BLACK);
		button[2][2].setBackground(Color.WHITE);

		newB.addActionListener(new newHandler());
		saveB.addActionListener(new saveHandler());
		openB.addActionListener(new openHandler());
		exitB.addActionListener(new exitHandler());

	}

	/**
	 * newHandler�� �ڲ��ࡪ�����㡰���¿�ʼ����ťʱ�����³��Ի����漰һЩ����
	 *
	 * @author zhaoyuan
	 * @version 1.0
	 *
	 */
	private class newHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			for (int i = 0; i < 4; i++)
			{
				for (int j = 0; j < 4; j++)
				{
					button[i][j].setBackground(Color.GREEN);
				}
			}
			button[1][1].setBackground(Color.WHITE);
			button[1][2].setBackground(Color.BLACK);
			button[2][1].setBackground(Color.BLACK);
			button[2][2].setBackground(Color.WHITE);

			isBlackPlay = true;
			blackChess = 0;
			whiteChess = 0;
		}
	}

	/**
	 * saveHandler�� �ڲ��ࡪ�����㡰���桱��ťʱ���������ݵ�ָ���ļ��У��ö�Ԫ������ʾ���̣������ֱ�ʾ����
	 *
	 * @author zhaoyuan
	 * @version 1.0
	 *
	 */
	private class saveHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			for (int i = 0; i < 4; i++)
			{
				for (int j = 0; j < 4; j++)
				{
					if (button[i][j].getBackground() == Color.BLACK)// ������1��ʾ
						data[i][j] = 1;
					else if (button[i][j].getBackground() == Color.WHITE)// ������-1��ʾ
						data[i][j] = -1;
					else
						data[i][j] = 0;// ���̿�λ����0��ʾ
				}
			}
			try
			{
				FileWriter fw = new FileWriter("10.txt");
				for (int i = 0; i < 4; i++)
				{
					fw.write(data[i][0] + "," + data[i][1] + "," + data[i][2] + "," + data[i][3] + "\r\n");
				}
				fw.write(isBlackPlay + "\r\n");
				fw.write("0��ʾ�հף�1��ʾ���壬-1��ʾ���塣true��ʾ�ú�������");

				fw.close();
				JOptionPane.showMessageDialog(null, "�����ɹ�");
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}

	/**
	 * openHandler�� �ڲ��ࡪ�����㡰�򿪡���ťʱ�������ļ��������ݣ����ָ̻�������ʱ��״̬
	 *
	 * @author zhaoyuan
	 * @version 1.0
	 *
	 */
	private class openHandler implements ActionListener
	{
		String ss;

		public void actionPerformed(ActionEvent e)
		{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader("10.txt"));

				for (int i = 0; i < 4; i++)
				{
					String line = br.readLine();
					String temp[] = line.split(",");

					data[i][0] = Integer.parseInt(temp[0]);
					data[i][1] = Integer.parseInt(temp[1]);
					data[i][2] = Integer.parseInt(temp[2]);
					data[i][3] = Integer.parseInt(temp[3]);
				}
				String s = br.readLine();
				isBlackPlay = Boolean.parseBoolean(s);
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}

			for (int i = 0; i < 4; i++)
			{
				for (int j = 0; j < 4; j++)
				{
					if (data[i][j] == 1)
						button[i][j].setBackground(Color.BLACK);
					else if (data[i][j] == -1)
						button[i][j].setBackground(Color.WHITE);
					else
						button[i][j].setBackground(Color.GREEN);
				}
			}

			if (isBlackPlay == true)
				ss = "��";
			else
				ss = "��";

			JOptionPane.showMessageDialog(null, "�򿪳ɹ�,������" + ss + "����");

		}
	}

	/**
	 * exitHandler�� �ڲ��ࡪ�����㡰�˳�����ťʱ���˳���Ϸ���ر�
	 *
	 * @author zhaoyuan
	 * @version 1.0
	 *
	 */
	private class exitHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);// //
		}
	}

	/**
	 * Handler�� �ڲ��ࡪ������ÿ�����̸��Ӱ�ťʱ���ж�����λ���Ƿ��Ϸ������Ϸ�����������
	 *
	 * @author zhaoyuan
	 * @version 1.0
	 *
	 */
	private class Handler implements ActionListener
	{
		private int row = -1, col = -1;

		/**
		 * Handler�� ���췽��������ť������ֵ������
		 *
		 * @param x
		 *            ��ť�ĺ�����
		 * @param y
		 *            ��ť��������
		 */
		public Handler(int x, int y)
		{
			row = x;
			col = y;
		}

		/**
		 * isValidPosition�� �жϸ�λ���Ƿ��Ϸ�
		 *
		 * @param x
		 *            ��ť�ĺ�����
		 * @param y
		 *            ��ť��������
		 * @return
		 */
		private boolean isValidPosition(int x, int y)
		{
			if (button[x][y].getBackground() != Color.GREEN)
				return false;

			if (isBlackPlay == true) // ���Ǻڷ���
			{
				// ˮƽ�������ж�
				for (int i = 0; i < 4; i++)
				{
					if (button[i][y].getBackground() == Color.BLACK)
					{
						if ((i - x) >= 2)// ������λ������
						{
							int count = 0;
							for (int k = x; k < i; k++)// ʵ����kӦ��x+1��ʼ����Ϊ�ú����ߣ�����button[x][y]�϶����ǰ���
							{
								if (button[k][y].getBackground() == Color.WHITE)
									count++;
							}
							if (count == (i - x - 1))// ����count����������ֵ��˵��û�а��ӱ��У�λ���Բ��Ϸ�
								return true;
						}

						if ((x - i) >= 2)// ������λ������
						{
							int count = 0;
							for (int k = x; k > i; k--)// ʵ����kӦ��x-1��ʼ����Ϊ�ú����ߣ�����button[x][y]�϶����ǰ���
							{
								if (button[k][y].getBackground() == Color.WHITE)
									count++;
							}
							if (count == (x - i - 1))
								return true;
						}
					}
				}

				// ��ֱ�����ж�
				for (int j = 0; j < 4; j++)
				{

					if (button[x][j].getBackground() == Color.BLACK)
					{
						if ((j - y) >= 2)// ������λ������
						{
							int count = 0;
							for (int k = y + 1; k < j; k++)
							{
								if (button[x][k].getBackground() == Color.WHITE)
									count++;
							}
							if (count == (j - y - 1))
								return true;
						}

						if ((y - j) >= 2)// ������λ������
						{
							int count = 0;
							for (int k = y - 1; k > j; k--)
							{
								if (button[x][k].getBackground() == Color.WHITE)
									count++;
							}
							if (count == (y - j - 1))
								return true;
						}
					}
				}

				// б�߷������ж�
				for (int i = 0; i < 4; i++)
				{
					for (int j = 0; j < 4; j++)
					{
						if (button[i][j].getBackground() == Color.BLACK)
						{
							if ((x - i) == (y - j) && (x - i) >= 2)// ������λ��������
							{
								int yy = y;
								int count = 0;
								for (int k = x; k > i; k--)
								{
									if (button[k][yy].getBackground() == Color.WHITE)
									{
										count++;
									}
									yy--;
								}
								if (count == (x - i - 1))
									return true;
							}

							if ((x - i) == (j - y) && (x - i) >= 2)// ������λ��������
							{
								int yy = y;
								int count = 0;
								for (int k = x; k > i; k--)
								{
									if (button[k][yy].getBackground() == Color.WHITE)
									{
										count++;
									}
									yy++;

								}
								if (count == (x - i - 1))
									return true;
							}

							if ((i - x) == (y - j) && (i - x) >= 2)// ������λ��������
							{
								int yy = y;
								int count = 0;
								for (int k = x; k < i; k++)
								{
									if (button[k][yy].getBackground() == Color.WHITE)
									{
										count++;
									}
									yy--;

								}
								if (count == (i - x - 1))
									return true;
							}

							if ((i - x) == (j - y) && (i - x) >= 2)// ������λ��������
							{
								int yy = y;
								int count = 0;
								for (int k = x; k < i; k++)
								{
									if (button[k][yy].getBackground() == Color.WHITE)
									{
										count++;
									}
									yy++;

								}
								if (count == (i - x - 1))
									return true;
							}

						}
					}
				}

				return false;

			}

			else
			// ���ǰ׷���
			{
				for (int i = 0; i < 4; i++)
				{
					if (button[i][y].getBackground() == Color.WHITE)
					{
						if ((i - x) >= 2)
						{
							int count = 0;
							for (int k = x; k < i; k++)
							{
								if (button[k][y].getBackground() == Color.BLACK)
									count++;
							}
							if (count == (i - x - 1))
								return true;
						}
						if ((x - i) >= 2)
						{
							int count = 0;
							for (int k = x; k > i; k--)
							{
								if (button[k][y].getBackground() == Color.BLACK)
									count++;
							}
							if (count == (x - i - 1))
								return true;
						}
					}
				}

				for (int j = 0; j < 4; j++)
				{
					if (button[x][j].getBackground() == Color.WHITE)
					{
						if ((j - y) >= 2)
						{
							int count = 0;
							for (int k = y; k < j; k++)
							{
								if (button[x][k].getBackground() == Color.BLACK)
									count++;
							}
							if (count == (j - y - 1))
								return true;
						}

						if ((y - j) >= 2)
						{
							int count = 0;
							for (int k = y; k > j; k--)
							{
								if (button[x][k].getBackground() == Color.BLACK)
									count++;
							}
							if (count == (y - j - 1))
								return true;
						}

					}
				}

				for (int i = 0; i < 4; i++)
				{
					for (int j = 0; j < 4; j++)
					{
						if (button[i][j].getBackground() == Color.WHITE)
						{
							if ((x - i) == (y - j) && (x - i) >= 2)
							{
								int yy = y;
								int count = 0;
								for (int k = x; k > i; k--)
								{
									if (button[k][yy].getBackground() == Color.BLACK)
									{
										count++;
									}
									yy--;

								}
								if (count == (x - i - 1))
									return true;
							}

							if ((x - i) == (j - y) && (x - i) >= 2)
							{
								int yy = y;
								int count = 0;
								for (int k = x; k > i; k--)
								{
									if (button[k][yy].getBackground() == Color.BLACK)
									{
										count++;
									}
									yy++;

								}
								if (count == (x - i - 1))
									return true;
							}

							if ((i - x) == (y - j) && (i - x) >= 2)
							{
								int yy = y;
								int count = 0;
								for (int k = x; k < i; k++)
								{
									if (button[k][yy].getBackground() == Color.BLACK)
									{
										count++;
									}
									yy--;
								}
								if (count == (i - x - 1))
									return true;
							}

							if ((i - x) == (j - y) && (i - x) >= 2)
							{
								int yy = y;
								int count = 0;
								for (int k = x; k < i; k++)
								{
									if (button[k][yy].getBackground() == Color.BLACK)
									{
										count++;
									}
									yy++;
								}
								if (count == (i - x - 1))
									return true;
							}

						}
					}
				}

				return false;

			}

		}

		/**
		 * refresh�� ��������
		 *
		 * @param x
		 *            ��ť�ĺ�����
		 * @param y
		 *            ��ť��������
		 */
		private void refresh(int x, int y)
		{
			if (isBlackPlay == true)// ���Ǻڷ���
			{
				for (int i = 0; i < 4; i++)
				{
					if (button[i][y].getBackground() == Color.BLACK)
					{
						if ((i - x) >= 2)
						{
							int count = 0;
							for (int k = x; k < i; k++)
							{
								if (button[k][y].getBackground() == Color.WHITE)
									count++;
							}

							if (count == (i - x - 1))
							{
								for (int k = x; k < i; k++)
									button[k][y].setBackground(Color.BLACK);
							}

						}

						if ((x - i) >= 2)
						{
							int count = 0;// /////////////////////////
							for (int k = x; k > i; k--)
							{
								if (button[k][y].getBackground() == Color.WHITE)
									count++;
							}

							if (count == (x - i - 1))
							{
								for (int k = x; k > i; k--)
									button[k][y].setBackground(Color.BLACK);
							}
						}
					}
				}

				for (int j = 0; j < 4; j++)
				{
					if (button[x][j].getBackground() == Color.BLACK)
					{
						if ((j - y) >= 2)
						{
							int count = 0;
							for (int k = y; k < j; k++)
							{
								if (button[x][k].getBackground() == Color.WHITE)
									count++;
							}

							if (count == (j - y - 1))
							{
								for (int k = y; k < j; k++)
									button[x][k].setBackground(Color.BLACK);
							}
						}

						if ((y - j) >= 2)
						{
							int count = 0;
							for (int k = y; k > j; k--)
							{
								if (button[x][k].getBackground() == Color.WHITE)
									count++;
							}
							if (count == (y - j - 1))
							{
								for (int k = y; k > j; k--)
									button[x][k].setBackground(Color.BLACK);
							}
						}
					}
				}

				for (int i = 0; i < 4; i++)
				{
					for (int j = 0; j < 4; j++)
					{
						if (button[i][j].getBackground() == Color.BLACK)
						{
							if ((x - i) == (y - j) && (x - i) >= 2)
							{
								int yy = y;
								int count = 0;
								for (int k = x; k > i; k--)
								{
									if (button[k][yy].getBackground() == Color.WHITE)
									{
										count++;
									}
									yy--;

								}
								if (count == (x - i - 1))
								{
									yy = y;
									for (int k = x; k > i; k--)
									{
										button[k][yy].setBackground(Color.BLACK);
										yy--;
									}
								}
							}

							if ((x - i) == (j - y) && (x - i) >= 2)
							{
								int yy = y;
								int count = 0;
								for (int k = x; k > i; k--)
								{
									if (button[k][yy].getBackground() == Color.WHITE)
									{
										count++;
									}
									yy++;

								}
								if (count == (x - i - 1))
								{
									yy = y;
									for (int k = x; k > i; k--)
									{
										button[k][yy].setBackground(Color.BLACK);
										yy++;
									}
								}
							}

							if ((i - x) == (y - j) && (i - x) >= 2)
							{
								int yy = y;
								int count = 0;
								for (int k = x; k < i; k++)
								{
									if (button[k][yy].getBackground() == Color.WHITE)
									{
										count++;
									}
									yy--;

								}
								if (count == (i - x - 1))
								{
									yy = y;
									for (int k = x; k < i; k++)
									{
										button[k][yy].setBackground(Color.BLACK);
										yy--;
									}
								}
							}

							if ((i - x) == (j - y) && (i - x) >= 2)
							{
								int yy = y;
								int count = 0;
								for (int k = x; k < i; k++)
								{
									if (button[k][yy].getBackground() == Color.WHITE)
									{
										count++;
									}
									yy++;

								}
								if (count == (i - x - 1))
								{
									yy = y;
									for (int k = x; k < i; k++)
									{
										button[k][yy].setBackground(Color.BLACK);
										yy++;
									}
								}
							}

						}
					}
				}

			}
			else
			// ���ǰ׷���
			{
				for (int i = 0; i < 4; i++)
				{
					if (button[i][y].getBackground() == Color.WHITE)
					{
						if ((i - x) >= 2)
						{
							int count = 0;
							for (int k = x; k < i; k++)
							{
								if (button[k][y].getBackground() == Color.BLACK)
									count++;
							}

							if (count == (i - x - 1))
							{
								for (int k = x; k < i; k++)
									button[k][y].setBackground(Color.WHITE);
							}

						}
						if ((x - i) >= 2)
						{
							int count = 0;
							for (int k = x; k > i; k--)
							{
								if (button[k][y].getBackground() == Color.BLACK)
									count++;
							}

							if (count == (x - i - 1))
							{
								for (int k = x; k > i; k--)
									button[k][y].setBackground(Color.WHITE);
							}
						}
					}
				}

				for (int j = 0; j < 4; j++)
				{
					if (button[x][j].getBackground() == Color.WHITE)
					{
						if ((j - y) >= 2)
						{
							int count = 0;
							for (int k = y; k < j; k++)
							{
								if (button[x][k].getBackground() == Color.BLACK)
									count++;
							}

							if (count == (j - y - 1))
							{
								for (int k = y; k < j; k++)
									button[x][k].setBackground(Color.WHITE);
							}
						}
						if ((y - j) >= 2)
						{
							int count = 0;
							for (int k = y; k > j; k--)
							{
								if (button[x][k].getBackground() == Color.BLACK)
									count++;
							}
							if (count == (y - j - 1))
							{
								for (int k = y; k > j; k--)
									button[x][k].setBackground(Color.WHITE);
							}
						}
					}
				}

				for (int i = 0; i < 4; i++)
				{
					for (int j = 0; j < 4; j++)
					{
						if (button[i][j].getBackground() == Color.WHITE)
						{
							if ((x - i) == (y - j) && (x - i) >= 2)
							{
								int yy = y;
								int count = 0;
								for (int k = x; k > i; k--)
								{
									if (button[k][yy].getBackground() == Color.BLACK)
									{
										count++;
									}
									yy--;
								}
								if (count == (x - i - 1))
								{
									yy = y;
									for (int k = x; k > i; k--)
									{
										button[k][yy].setBackground(Color.WHITE);
										yy--;
									}
								}
							}

							if ((x - i) == (j - y) && (x - i) >= 2)
							{
								int yy = y;
								int count = 0;
								for (int k = x; k > i; k--)
								{
									if (button[k][yy].getBackground() == Color.BLACK)
									{
										count++;
									}
									yy++;

								}
								if (count == (x - i - 1))
								{
									yy = y;
									for (int k = x; k > i; k--)
									{
										button[k][yy].setBackground(Color.WHITE);
										yy++;
									}
								}
							}
							if ((i - x) == (y - j) && (i - x) >= 2)
							{
								int yy = y;
								int count = 0;
								for (int k = x; k < i; k++)
								{
									if (button[k][yy].getBackground() == Color.BLACK)
									{
										count++;
									}
									yy--;

								}
								if (count == (i - x - 1))
								{
									yy = y;
									for (int k = x; k < i; k++)
									{
										button[k][yy].setBackground(Color.WHITE);
										yy--;
									}
								}
							}
							if ((i - x) == (j - y) && (i - x) >= 2)
							{
								int yy = y;
								int count = 0;
								for (int k = x; k < i; k++)
								{
									if (button[k][yy].getBackground() == Color.BLACK)
									{
										count++;
									}
									yy++;

								}
								if (count == (i - x - 1))
								{
									yy = y;
									for (int k = x; k < i; k++)
									{
										button[k][yy].setBackground(Color.WHITE);
										yy++;

									}
								}
							}

						}
					}
				}

			}

		}

		/**
		 * hasValidPosition�� �ж��Ƿ�����λ�ÿ���
		 *
		 * @return��true��ʾ����λ�ÿ��£�false��ʾ��λ�ÿ���
		 */
		private boolean hasValidPosition()
		{
			for (int i = 0; i < 4; i++)
			{
				for (int j = 0; j < 4; j++)
				{
					if (isValidPosition(i, j))
						return true;
				}
			}
			return false;
		}

		/**
		 * changePlayer�� �л�����һ��
		 */
		public void changePlayer()
		{
			if (isBlackPlay == true)
				isBlackPlay = false;
			else
				isBlackPlay = true;
		}

		/**
		 * whoWin�� ������������ʣ�������������ж���һ����ʤ
		 */
		private void whoWin()
		{
			for (int i = 0; i < 4; i++)
			{
				for (int j = 0; j < 4; j++)
				{
					if (button[i][j].getBackground() == Color.BLACK)
						blackChess++;
					if (button[i][j].getBackground() == Color.WHITE)
						whiteChess++;
				}
			}

			if (blackChess > whiteChess)
				JOptionPane.showMessageDialog(null, "��ϲ�ڷ���ʤ");
			else if (blackChess < whiteChess)
				JOptionPane.showMessageDialog(null, "��ϲ�׷���ʤ");
			else
				JOptionPane.showMessageDialog(null, "ƽ����");

		}

		/**
		 * actionPerformed�� ������Ϸ�Ѿ������򷵻أ����������ж�λ���Ƿ��Ϸ�����������ʾ�����أ��������������̣�
		 * ���л����Է�����ʱ�ж��Ƿ�����λ�ÿ��£������򷵻أ����������л�����������ʱ��
		 * �ж��Ƿ���λ�ÿ��£���������Ϸ�����ж�ʤ������������ʾ�л����˼���������
		 */
		public void actionPerformed(ActionEvent e)
		{
			if (gameOver == true)
			{
				JOptionPane.showMessageDialog(null, "�����ѽ����������¿�ʼ");
				return;
			}
			else
			{
				if (!isValidPosition(row, col))
				{
					JOptionPane.showMessageDialog(null, "�Ƿ�λ�ã����ط�");
					return;
				}
				else
				{
					refresh(row, col);
					changePlayer();
					if (!hasValidPosition())
					{
						changePlayer();
						{
							if (!hasValidPosition())
							{
								gameOver = true;
								whoWin();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "�Է��޴����£���������");
								return;
							}
						}
					}
					else
						return;

				}

			}

		}
	}

	/**
	 * main��
	 *
	 * @param args
	 */
	public static void main(String[] args)
	{
		Othello app = new Othello();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(350, 400);
		app.setVisible(true);

	}

}
