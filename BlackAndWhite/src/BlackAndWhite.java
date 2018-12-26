import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BlackAndWhite extends JFrame {

	private ChessBoard chessBoard;
	private JPanel toolbar;
	private JButton startButton;
	private JButton backButton;
	private JButton exitButton;
	
	public BlackAndWhite() {
		// TODO Auto-generated constructor stub
		setTitle("Black And White");
		chessBoard= new ChessBoard();
		MyItemListener lis=new MyItemListener();//初始化按钮事件监听器内部类

		toolbar=new JPanel();//工具面板栏实例化

		startButton=new JButton("重新开始");

		backButton=new JButton("悔棋");

		exitButton=new JButton("退出");//三个按钮初始化

		toolbar.setLayout((LayoutManager) new FlowLayout(FlowLayout.LEFT));//将工具面板按钮用FlowLayout布局

		toolbar.add(backButton);

		toolbar.add(startButton);

		toolbar.add(exitButton);//将三个按钮添加到工具面板上

		startButton.addActionListener(lis);

		backButton.addActionListener(lis);

		exitButton.addActionListener(lis);//将三个按钮事件注册监听事件

		add(toolbar,BorderLayout.SOUTH);//将工具面板布局到界面南方也就是下面

		add(chessBoard);//将面板对象添加到窗体上

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置界面关闭事件

		pack();//自适应大小
		
		setVisible(true);
	}
	
	private class MyItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object ob= e.getSource();
			if(ob==startButton) {
				System.out.println("重新开始...");//重新开始

				//JFiveFrame.this内部类引用外部类

				chessBoard.restartGame();
			}else if(ob==exitButton){

				System.exit(0);//结束应用程序

			}else if(ob==backButton){

				System.out.println("悔棋...");//悔棋

				chessBoard.goback();

			}		
			
		}
		
	}
	public static void main(String argc[]) {
		new BlackAndWhite();
	}
}
