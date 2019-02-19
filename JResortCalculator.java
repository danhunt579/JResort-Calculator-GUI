/*
	Filename: 	JResortCalculator
	Author: 	Dan Hunt
	Date:		02.15.19
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JResortCalculator extends JFrame implements ItemListener
{
	final int BASE_PRICE = 200;
	final int WEEKEND_PREMIUM = 100;
	final int BREAKFAST_PREMIUM = 20;
	final int GOLF_PREMIUM = 75;
	int totalPrice = BASE_PRICE;
	
	// Create 3 JCheckBox objects
	JCheckBox weekendBox = new JCheckBox("Weekend Premium $" + WEEKEND_PREMIUM, false);
	JCheckBox breakfastBox = new JCheckBox("Breakfast $" + BREAKFAST_PREMIUM, false);
	JCheckBox golfBox = new JCheckBox("Golf $" + GOLF_PREMIUM, false);
	
	// Create 4 JLabels and 1 JTextField
	JLabel resortLabel = new JLabel("Resort Price Calculator");
	JLabel priceLabel = new JLabel("The price for your stay is");
	JLabel optionExplainLabel = new JLabel("Base price for your room is $" + BASE_PRICE + ".");
	JLabel optionExplainLabel2 = new JLabel("Check the options you want.");
	
	JTextField total = new JTextField(4);
	
	// Constructor for the JResortCalculator class
	public JResortCalculator()
	{
		super("Resort Price Estimator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(300, 200);
		setVisible(true);
		add(weekendBox);
		add(breakfastBox);
		add(golfBox);
		add(resortLabel);
		add(priceLabel);
		add(optionExplainLabel);
		add(optionExplainLabel2);
		add(total);

		total.setText("$" + totalPrice);
		weekendBox.addItemListener(this);
		breakfastBox.addItemListener(this);
		golfBox.addItemListener(this);		
	}
	
	// Listens for change in state of check boxes
	@Override
	public void itemStateChanged(ItemEvent event)
	{
		Object source = event.getSource();
		int select = event.getStateChange();
		
		if(source == weekendBox)
		{
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += WEEKEND_PREMIUM;				
			}
			else
			{
				totalPrice -= WEEKEND_PREMIUM;				
			}			
		}
		else
		{
			if(source == breakfastBox)
			{
				if(select == ItemEvent.SELECTED)
				{
					totalPrice += BREAKFAST_PREMIUM;				
				}
				else
				{
					totalPrice -= BREAKFAST_PREMIUM;				
				}
			}
			else // it must be golfBox
			{
				if(select == ItemEvent.SELECTED)
				{
					totalPrice += GOLF_PREMIUM;				
				}
				else
				{
					totalPrice -= GOLF_PREMIUM;				
				}
			}
		}
		
		// After all the decision making, keep pushing total price to jtext field that we created
		
		total.setText("$" + totalPrice);		
	}		
	
	public static void main(String[] args)
	{
		JResortCalculator aFrame = new JResortCalculator();
	}
}