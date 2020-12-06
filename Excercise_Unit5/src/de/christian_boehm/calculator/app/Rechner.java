package de.christian_boehm.calculator.app;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Rechner extends Frame {
    private BorderLayout borderLayout1 = new BorderLayout();
    /*
     * AWT-Komponenten fuer Eingabetextfeld, Zifferntasten, Operatortasten sowie
     * Ziffernpanel und Operatorpanel deklarieren und soweit moeglich bereits
     * zugehoerige Objekte erzeugen
     */
    
    private Button bZero;
    private Button bOne;
    private Button bTwo;
    private Button bThree;
    private Button bFour;
    private Button bFive;
    private Button bSix;
    private Button bSeven;
    private Button bEight;
    private Button bNine;
    
    private Button bPlus;
    private Button bMinus;
    private Button bTimes;
    private Button bEquals;
    
    private Panel pNumberPanel;
    private Panel pOperatorPanel;
    
    private HinweisFenster hf = new HinweisFenster(this);
    private TextField tfOutputField = new TextField("", 5);
    private Dimension buttonDim = new Dimension(25, 25);
    private ZiffernListener ziffernLister = new ZiffernListener(getTfOutputField());
    
    /*
     * declare and partly initialize calculation logic variables 
     */
    
    private int a = 0;
    private int b = 0;
    private String operator;

    
    /*
     * these calculation logic methods are intentionally declared here
     * for clarity
     */
    
	private String plus(int x, int y) {
		
		try {
			int result = Math.addExact(x, y);
		    return String.valueOf(result);
		} catch(ArithmeticException e) {
			excDialog(e);
		    return "";
		}
	}

	private String minus(int x, int y) {
		
		try {
			int result = Math.subtractExact(x, y);
		    return String.valueOf(result);
		} catch(ArithmeticException e) {
			excDialog(e);
		    return "";
		}
	}
    
	private String mult(int x, int y) {
		
		try {
			int result = Math.multiplyExact(x, y);
		    return String.valueOf(result);
		} catch(ArithmeticException e) {
			excDialog(e);
		    return "";
		}
	}
	/*
	 * end calculation helper method declaration
	 */
	
	public Rechner() {
		/* Ggf. lokale Variablen deklarieren */
    	
    	class MyButton extends Button {
    		MyButton(Dimension d, String text, ActionListener ziffernListern, Color color) {
    			this.setPreferredSize(d);
    			this.setLabel(text);
    			this.setActionCommand(text);
    			if (!(ziffernListern == null)) {
    				this.addActionListener(ziffernListern);
    			}
    			if (!(color == null)) {
    				this.setForeground(color);
    			}
    		}
    	}

        /* Layout fuer Frame festlegen */
        this.setLayout(borderLayout1);
        this.setSize(150, 200);
        this.setLocation(100, 100);
        this.setBackground(Color.gray);
        
        /* set Textfield non editable */
        getTfOutputField().setEditable(false);
       

        /* FlowLayout fuer Ziffern- und Operatorpanel setzen */
        pNumberPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 3, 3));
        pOperatorPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 3, 3));
        
        /* Zifferntasten ggf. erzeugen und in Ziffernpanel einfuegen */
        bZero 	= new MyButton(getButtonDim(), "0", getZiffernLister(), null);
        bOne 	= new MyButton(getButtonDim(), "1", getZiffernLister(), null);
        bTwo 	= new MyButton(getButtonDim(), "2", getZiffernLister(), null);
        bThree 	= new MyButton(getButtonDim(), "3", getZiffernLister(), null);
        bFour 	= new MyButton(getButtonDim(), "4", getZiffernLister(), null);
        bFive 	= new MyButton(getButtonDim(), "5", getZiffernLister(), null); 
        bSix 	= new MyButton(getButtonDim(), "6", getZiffernLister(), null);
        bSeven 	= new MyButton(getButtonDim(), "7", getZiffernLister(), null);
        bEight 	= new MyButton(getButtonDim(), "8", getZiffernLister(), null);
        bNine 	= new MyButton(getButtonDim(), "9", getZiffernLister(), null);
        
        pNumberPanel.add(bZero);
        pNumberPanel.add(bOne);
        pNumberPanel.add(bTwo);
        pNumberPanel.add(bThree);
        pNumberPanel.add(bFour);
        pNumberPanel.add(bFive);
        pNumberPanel.add(bSix);
        pNumberPanel.add(bSeven);
        pNumberPanel.add(bEight);
        pNumberPanel.add(bNine);
        
        /* Operatortasten ggf. erzeugen und in Operatorpanel einfuegen */
        bPlus = new MyButton(buttonDim, "+", null, Color.red);
        bPlus.addActionListener(e -> {
        	if(e.getActionCommand().equals("+")) {
        		try {
        			setA(Integer.valueOf(getTfOutputField().getText()).intValue());
        		} catch (NumberFormatException ex) {
        			errorDialog();
        		    return;
        		}
        		setOperator(e.getActionCommand());
        		getTfOutputField().setText("");
        		}
        });
        
        bMinus = new MyButton(buttonDim, "-", null, Color.red);
        bMinus.addActionListener(e -> {
        	if(e.getActionCommand().equals("-")) {
        		try {
        			setA(Integer.valueOf(getTfOutputField().getText()).intValue());
        		} catch (NumberFormatException ex) {
        			errorDialog();
        		    return;
        		}
        		setOperator(e.getActionCommand());
        		getTfOutputField().setText("");
        	}
        });
        
        bTimes = new MyButton(buttonDim, "*", null, Color.red);
        bTimes.addActionListener(e -> {
        	if(e.getActionCommand().equals("*")) {
        		try {
        			setA(Integer.valueOf(getTfOutputField().getText()).intValue());
        		} catch (NumberFormatException ex) {
        			errorDialog();
        		    return;
        		}
        		setOperator(e.getActionCommand());
        		getTfOutputField().setText("");
        	}
        });
        
        bEquals = new MyButton(buttonDim, "=", null, Color.red);
        bEquals.addActionListener(e -> {
        	if(e.getActionCommand().equals("=")) {
				try {
					setB(Integer.valueOf(getTfOutputField().getText()).intValue());
				} catch (NumberFormatException ex) {
					errorDialog();
        		    return;
				}
        		try {
        			switch (getOperator()) {
					case "+":
						getTfOutputField().setText(plus(getA(), getB()));
						break;
					case "-":
						getTfOutputField().setText(minus(getA(), getB()));
						break;
					case "*":
						getTfOutputField().setText(mult(getA(), getB()));
						break;
					default:
						break;
					} 
				} catch (Exception exc) {
					exc.printStackTrace();
					getTfOutputField().setText("");
				}
        	}
        });
        
        
        pOperatorPanel.add(bPlus);
        pOperatorPanel.add(bMinus);
        pOperatorPanel.add(bTimes);
        pOperatorPanel.add(bEquals);
        
        /* Objekte in Frame plazieren */
        this.add(tfOutputField, BorderLayout.NORTH);
        this.add(pNumberPanel);
        this.add(pOperatorPanel, BorderLayout.SOUTH);
        /* ... */
    }
	
	/*
	 * ArithmeticException dialog helper method
	 */
	
	private void excDialog(ArithmeticException e) {
		hf.setText(e.getMessage());
		hf.setVisible(true);
		setA(0);
		setB(0);
	}

	/*
	 * NumberFormatException dialog helper method
	 */
	
	private void errorDialog() {
		hf.setText("NumberFormatException !");
		hf.setVisible(true);
		getTfOutputField().setText("");
	}

	/* ... */
    public static void main(String argv[]) {
        Rechner rechner = new Rechner();
        rechner.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        rechner.setVisible(true);
    }
    
    
    /*
     * setter and getter methods for private attributes
     */
    
    public ZiffernListener getZiffernLister() {
		return ziffernLister;
	}
	public void setZiffernLister(ZiffernListener ziffernLister) {
		this.ziffernLister = ziffernLister;
	}
	public TextField getTfOutputField() {
		return tfOutputField;
	}
	public void setTfOutputField(TextField tfOutputField) {
		this.tfOutputField = tfOutputField;
	}
	public Dimension getButtonDim() {
		return buttonDim;
	}
	public void setButtonDim(Dimension dButtonDim) {
		this.buttonDim = dButtonDim;
	}
	
    public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operand) {
		operator = operand;
	}
}

