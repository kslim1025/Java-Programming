import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalculaterGUI {

	private Frame f;
	private Panel p1;
	private Panel p2;
	private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
	private Button bPoint, bAdd, bSub, bMultiply, bDiv, bEqual, bSqrt, bClear;
	private TextField tf;
	private String s, op;
	private boolean ifop;
	private Calculater cal= new Calculater();
	
	public CalculaterGUI() {
		// TODO Auto-generated constructor stub
		f=new Frame("Calculater");
		p1 = new Panel();
		p2 = new Panel();
		b0 = new Button("0");
		b1 = new Button("1");
		b2 = new Button("2");
		b3 = new Button("3");
		b4 = new Button("4");
		b5 = new Button("5");
		b6 = new Button("6");
		b7 = new Button("7");
		b8 = new Button("8");
		b9 = new Button("9");
		
		bPoint = new Button(".");
		bAdd = new Button("+");
		bSub= new Button("-");
		bMultiply= new Button("*");
		bDiv= new Button("/");
		bEqual= new Button("=");
		bSqrt= new Button("loute");
		bClear= new Button("C");
		
		tf= new TextField(25);
		tf.setEditable(false);
		
	}
	
	private void launchFrame() {
		f.setSize(220,200);
		f.setLocation(600,200);
		f.setResizable(false);
		f.addWindowListener(new MyWindowListener(){
			
		});
			p1.setLayout(new FlowLayout(FlowLayout.CENTER));
			p1.add(tf);
			f.add(p1, BorderLayout.NORTH);
			p2.setLayout(new GridLayout(6,3));
			b0.addActionListener(new setTextLable_ActionListener());
			b1.addActionListener(new setTextLable_ActionListener());
			b2.addActionListener(new setTextLable_ActionListener());
			b3.addActionListener(new setTextLable_ActionListener());
			b4.addActionListener(new setTextLable_ActionListener());
			b5.addActionListener(new setTextLable_ActionListener());
			b6.addActionListener(new setTextLable_ActionListener());
			b7.addActionListener(new setTextLable_ActionListener());
			b8.addActionListener(new setTextLable_ActionListener());
			b9.addActionListener(new setTextLable_ActionListener());
			
			bPoint.addActionListener(new setTextLable_ActionListener());
			bAdd.addActionListener(new SetOperater_ActionListener()); 
			bSub.addActionListener(new SetOperater_ActionListener());
			bMultiply.addActionListener(new SetOperater_ActionListener()); 
			bDiv.addActionListener(new SetOperater_ActionListener()); 
			bEqual.addActionListener(new SetOperater_ActionListener()); 
			bSqrt.addActionListener(new SetOperater_ActionListener()); 
			bClear.addActionListener(new SetOperater_ActionListener());
			
			p2.add(bAdd);
			p2.add(bSub);
			p2.add(bEqual);
			p2.add(bMultiply);
			p2.add(bDiv);
			p2.add(bSqrt);
			p2.add(bPoint);
			p2.add(b0);
			p2.add(bClear);
			p2.add(b7);
			p2.add(b8);
			p2.add(b9);
			p2.add(b4);
			p2.add(b5);
			p2.add(b6);
			p2.add(b1);
			p2.add(b2);
			p2.add(b3);
			
			f.add(p2, BorderLayout.SOUTH);
			f.setVisible(true);
		
		
	}
	class MyWindowListener extends WindowAdapter{
		public void windowclosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	class setTextLable_ActionListener implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Button tempB= (Button)e.getSource();
			op=tempB.getLabel();
			if(op.equals("+")) {
				tf.setText(cal.opAdd(tf.getText()));
				ifop=true; 	
			}
			else if(op.equals("-")) {
				tf.setText(cal.opSubStract(tf.getText()));
			}
			else if(op.equals("*")) {
				ifop= true;
				tf.setText(cal.opMultiply(tf.getText()));
			}
			else if(op.equals("/")) {
				ifop= true;
				tf.setText(cal.opDivide(tf.getText()));
			}
			else if(op.equals("=")) {
				ifop= true;
				tf.setText(cal.opEqual(tf.getText()));
			}
			else if(op.equals("lout")) {
				ifop= false;
				tf.setText(cal.opSqrt(tf.getText()));
			}else if(op.equals("C")) {
				cal.opClear();
				tf.setText("0");
			}
	    }
	}
	private void SetFieldText_Temp() {
		if(tf.getText().length()<15&&tf.getText().indexOf(".")==-1 || s.equalsIgnoreCase(".")) {
			tf.setText(tf.getText()+s);
			
		}
		else 
			tf.setText((tf.getText()+s).substring(0, 15));
	}

    class SetOperater_ActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main(String[] args) {
		CalculaterGUI cg= new CalculaterGUI();
		cg.launchFrame();
	  }
}
