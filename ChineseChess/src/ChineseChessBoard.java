import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class ChineseChessBoard extends JFrame{
	
	public ChineseChessBoard() {
		// TODO Auto-generated constructor stub
		setTitle("Chinese Chess Board");
		Container con= getContentPane();
		setBounds(500,350,500,500);
		con.setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		setSize(1500,1500);
		setVisible(true);
		
	}

	public void paint(Graphics g) {
		Font f= new Font("微软雅黑",Font.BOLD,30);  
		g.setFont(f);
		int length=60;
		//g.drawRect(60,50,500,560);
		//g.drawRect(70, 60, 480, 540); 
		g.drawRect(60,50,500,560);
		g.drawRect(70, 60, 480, 540);
		
		for(int i=0; i<9; i++) {
			g.drawLine(70, length, 550, length);
			 length+=60; 
			 
			  /*中间汉字*/  
	           g.drawString("楚河", 130, 350);  
	           g.drawString("汉界",400 , 350);  
		}
		length=130;  
        /*上半部分竖线*/  
        for(int i=0;i<7;i++){  
            g.drawLine( length,60, length,300);  
            length+=60;
        }
        /*下半部分竖线*/  
        length=130;  
      
        for(int i=0;i<7;i++){  
            g.drawLine( length,360, length,600);  
            length+=60;  
        }  
        /*上半部分九宫格斜线*/  
     g.drawLine(250, 60, 370, 180);  
     g.drawLine(370, 60, 250, 180);  
     /*下半部分九宫格斜线*/  
      
     g.drawLine(250, 480, 370, 600);  
     g.drawLine(250, 600, 370, 480);  
       
    }  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChineseChessBoard();
	}

}
