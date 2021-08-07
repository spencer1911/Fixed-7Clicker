/*
 * Decompiled with CFR 0.151.
 *
 * Could not load the following classes:
 *  com.apple.eawt.Application
 *  org.pushingpixels.trident.Timeline
 */
package synnk.sevenremaster.gui;

import com.apple.eawt.Application;
import synnk.sevenremaster.AutoClicker;
import synnk.sevenremaster.gui.RangeSlider;
import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import org.pushingpixels.trident.Timeline;

public class ClickerGui {
	private final int WINDOW_WIDTH = 150;
	private final int WINDOW_HEIGHT = 125;
	private final int DROPDOWN_HEIGHT = 100;
	private final Color LIGHT_GRAY = new Color(60, 70, 73);
	private final Color DARK_GRAY = new Color(45, 47, 49);
	private final Color GREEN = new Color(35, 168, 105);
	public JFrame frame = new JFrame("7Clicker");
	public JPanel mainPane = new JPanel(null);
	public JPanel titleBar = new JPanel(null);
	public JPanel dropdown = new JPanel(null);
	public JLabel titleText = new JLabel("7Clicker");
	public JLabel cpsRange = new JLabel("CPS Range");
	public JLabel cpsNumber = new JLabel("00");
	public JLabel dropdownArrow = new JLabel(new ImageIcon(AutoClicker.class.getClassLoader().getResource("assets/arrow_down.png")));
	public JLabel powerButton = new JLabel(new ImageIcon(AutoClicker.class.getClassLoader().getResource("assets/power_button.png")));
	public JLabel toggleKeyText = new JLabel("Toggle Button");
	public JTextField minCPSField = new JTextField("8", 2);
	public JTextField maxCPSField = new JTextField("12", 2);
	public JTextField toggleKeyField = new JTextField("Mouse 3");
	public JCheckBox overlayBox = new JCheckBox("Overlay", true);
	public JCheckBox rightClickBox = new JCheckBox("Right Click", false);
	public RangeSlider slider = new RangeSlider(this.mainPane, 10, 130);
	public boolean focused = false;

	public ClickerGui() {
		this.setupFrame();
		this.setupMainPane();
		this.setupTitleBar();
		this.setupDropdown();
		this.setupSettings();
		this.setupMisc();
	}

	private void setupFrame() {
		this.frame.setSize(150, 125);
		this.frame.setLocation(50, 50);
		this.frame.setLayout(null);
		this.frame.setDefaultCloseOperation(3);
		this.frame.setUndecorated(true);
		this.frame.setBackground(new Color(0, 0, 0, 0));
		this.frame.setAlwaysOnTop(true);
		this.frame.setResizable(false);
		if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			Application.getApplication().setDockIconImage(new ImageIcon(AutoClicker.class.getClassLoader().getResource("assets/7Clicker.png")).getImage());
		} else {
			this.frame.setIconImage(new ImageIcon(AutoClicker.class.getClassLoader().getResource("assets/7Clicker.png")).getImage());
		}
		this.frame.addWindowFocusListener(new WindowAdapter(){

			@Override
			public void windowGainedFocus(WindowEvent e) {
				ClickerGui.this.frame.requestFocusInWindow();
				ClickerGui.this.focused = true;
			}

			@Override
			public void windowLostFocus(WindowEvent e) {
				ClickerGui.this.frame.requestFocusInWindow();
				ClickerGui.this.focused = false;
			}
		});
		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener(){

			@Override
			public void eventDispatched(AWTEvent event) {
				if (event.getID() != 500) return;
				if (((MouseEvent)event).getSource() instanceof JTextField) return;
				KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
			}
		}, 16L);
	}

	private void setupMainPane() {
		this.mainPane.setBounds(0, 0, 150, 225);
		this.mainPane.setBackground(this.LIGHT_GRAY);
		this.mainPane.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, this.DARK_GRAY));
		this.powerButton.setBounds(10, 45, 50, 50);
		this.powerButton.addMouseListener(new MouseAdapter(){

			@Override
			public void mousePressed(MouseEvent e) {
				AutoClicker.toggle();
			}
		});
		this.mainPane.add(this.powerButton);
		this.cpsNumber.setBounds(75, 45, 75, 50);
		this.cpsNumber.setForeground(this.GREEN);
		this.mainPane.add(this.cpsNumber);
	}

	private void setupTitleBar() {
		MouseAdapter dragListener = new MouseAdapter(){
			private int pX;
			private int pY;

			@Override
			public void mousePressed(MouseEvent e) {
				this.pX = e.getX();
				this.pY = e.getY();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				ClickerGui.this.frame.setLocation(ClickerGui.this.frame.getLocation().x + e.getX() - this.pX, ClickerGui.this.frame.getLocation().y + e.getY() - this.pY);
			}
		};
		this.titleBar.setBounds(0, 0, 150, 30);
		this.titleBar.setBackground(this.DARK_GRAY);
		this.titleBar.addMouseListener(dragListener);
		this.titleBar.addMouseMotionListener(dragListener);
		this.titleText.setBounds(0, 0, 150, 30);
		this.titleText.setHorizontalAlignment(0);
		this.titleText.setForeground(Color.WHITE);
		this.titleBar.add(this.titleText);
	}

	private void setupDropdown() {
		this.dropdown.setBounds(0, 110, 150, 15);
		this.dropdown.setBackground(this.DARK_GRAY);
		this.dropdown.addMouseListener(new MouseAdapter(){

			@Override
			public void mousePressed(MouseEvent e) {
				if (ClickerGui.this.frame.getHeight() == 125) {
					ClickerGui.this.dropdownArrow.setIcon(new ImageIcon(AutoClicker.class.getClassLoader().getResource("assets/arrow_up.png")));
					Timeline dropdownTimeline = new Timeline((Object)ClickerGui.this.dropdown);
					dropdownTimeline.addPropertyToInterpolate("location", (Object)ClickerGui.this.dropdown.getLocation(), (Object)new Point(0, ClickerGui.this.dropdown.getY() + 100));
					dropdownTimeline.setDuration(300L);
					dropdownTimeline.play();
					Timeline frameTimeline = new Timeline((Object)ClickerGui.this.frame);
					frameTimeline.addPropertyToInterpolate("size", (Object)ClickerGui.this.frame.getSize(), (Object)new Dimension(150, 225));
					frameTimeline.setDuration(300L);
					frameTimeline.play();
					KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
					return;
				}
				if (ClickerGui.this.frame.getHeight() != 225) return;
				ClickerGui.this.dropdownArrow.setIcon(new ImageIcon(AutoClicker.class.getClassLoader().getResource("assets/arrow_down.png")));
				Timeline dropdownTimeline = new Timeline((Object)ClickerGui.this.dropdown);
				dropdownTimeline.addPropertyToInterpolate("location", (Object)ClickerGui.this.dropdown.getLocation(), (Object)new Point(0, 110));
				dropdownTimeline.setDuration(300L);
				dropdownTimeline.play();
				Timeline frameTimeline = new Timeline((Object)ClickerGui.this.frame);
				frameTimeline.addPropertyToInterpolate("size", (Object)ClickerGui.this.frame.getSize(), (Object)new Dimension(150, 125));
				frameTimeline.setInitialDelay(50L);
				frameTimeline.setDuration(300L);
				frameTimeline.play();
				KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
			}
		});
		this.dropdownArrow.setBounds(69, 2, 13, 10);
		this.dropdown.add(this.dropdownArrow);
	}

	private void setupSettings() {
		this.cpsRange.setBounds(0, 110, 150, 13);
		this.cpsRange.setHorizontalAlignment(0);
		this.cpsRange.setForeground(Color.WHITE);
		this.mainPane.add(this.cpsRange);
		this.minCPSField.setBounds(10, 140, 20, 20);
		this.minCPSField.setHorizontalAlignment(0);
		this.minCPSField.setBackground(this.DARK_GRAY);
		this.minCPSField.setForeground(Color.WHITE);
		this.minCPSField.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		this.minCPSField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ClickerGui.this.textFieldSetCPS(true);
			}
		});
		this.minCPSField.addFocusListener(new FocusAdapter(){

			@Override
			public void focusLost(FocusEvent e) {
				ClickerGui.this.textFieldSetCPS(true);
			}
		});
		this.mainPane.add(this.minCPSField);
		this.maxCPSField.setBounds(120, 140, 20, 20);
		this.maxCPSField.setHorizontalAlignment(0);
		this.maxCPSField.setBackground(this.DARK_GRAY);
		this.maxCPSField.setForeground(Color.WHITE);
		this.maxCPSField.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		this.maxCPSField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ClickerGui.this.textFieldSetCPS(false);
			}
		});
		this.maxCPSField.addFocusListener(new FocusAdapter(){

			@Override
			public void focusLost(FocusEvent e) {
				ClickerGui.this.textFieldSetCPS(false);
			}
		});
		this.mainPane.add(this.maxCPSField);
		this.overlayBox.setBounds(5, 163, 67, 16);
		this.overlayBox.setBackground(this.LIGHT_GRAY);
		this.overlayBox.setForeground(Color.WHITE);
		this.overlayBox.setIcon(new ImageIcon(AutoClicker.class.getClassLoader().getResource("assets/checkbox_unchecked.png")));
		this.overlayBox.setSelectedIcon(new ImageIcon(AutoClicker.class.getClassLoader().getResource("assets/checkbox_checked.png")));
		this.overlayBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ClickerGui.this.frame.setAlwaysOnTop(ClickerGui.this.overlayBox.isSelected());
			}
		});
		this.mainPane.add(this.overlayBox);
		this.rightClickBox.setBounds(66, 163, 80, 16);
		this.rightClickBox.setBackground(this.LIGHT_GRAY);
		this.rightClickBox.setForeground(Color.WHITE);
		this.rightClickBox.setIcon(new ImageIcon(AutoClicker.class.getClassLoader().getResource("assets/checkbox_unchecked.png")));
		this.rightClickBox.setSelectedIcon(new ImageIcon(AutoClicker.class.getClassLoader().getResource("assets/checkbox_checked.png")));
		this.rightClickBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				AutoClicker.button = ClickerGui.this.rightClickBox.isSelected() ? 2 : 1;
			}
		});
		this.mainPane.add(this.rightClickBox);
		this.toggleKeyText.setBounds(11, 180, 66, 25);
		this.toggleKeyText.setForeground(Color.WHITE);
		this.mainPane.add(this.toggleKeyText);
		this.toggleKeyField.setBounds(80, 182, 60, 20);
		this.toggleKeyField.setHorizontalAlignment(0);
		this.toggleKeyField.setBackground(this.DARK_GRAY);
		this.toggleKeyField.setForeground(Color.WHITE);
		this.toggleKeyField.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		((AbstractDocument)this.toggleKeyField.getDocument()).setDocumentFilter(new DocumentFilter(){

			@Override
			public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attributes) throws BadLocationException {
				if (offset != -1) return;
				if (length != -1) return;
				super.replace(fb, 0, ClickerGui.this.toggleKeyField.getText().length(), text, attributes);
			}

			@Override
			public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
			}

			@Override
			public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attributes) throws BadLocationException {
			}
		});
		this.toggleKeyField.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent e) {
				try {
					if (KeyEvent.getKeyModifiersText(e.getModifiers()).contains(KeyEvent.getKeyText(e.getKeyCode()))) return;
					if (e.getKeyCode() == 20) return;
					AutoClicker.toggleKey[0] = KeyEvent.getKeyText(e.getKeyCode());
					AutoClicker.toggleKey[1] = KeyEvent.getKeyModifiersText(e.getModifiers());
					AutoClicker.toggleMouseButton = -1;
					((AbstractDocument)ClickerGui.this.toggleKeyField.getDocument()).replace(-1, -1, ClickerGui.this.getKeyString(e.getKeyCode(), e.getModifiers()), null);
					return;
				}
				catch (BadLocationException ex) {
					ex.printStackTrace();
				}
			}
		});
		this.toggleKeyField.addMouseListener(new MouseAdapter(){

			@Override
			public void mousePressed(MouseEvent e) {
				try {
					if (e.getButton() != 2) {
						if (e.getButton() <= 3) return;
					}
					AutoClicker.toggleMouseButton = e.getButton() == 2 ? 3 : e.getButton();
					AutoClicker.toggleKey[0] = "";
					AutoClicker.toggleKey[1] = "";
					((AbstractDocument)ClickerGui.this.toggleKeyField.getDocument()).replace(-1, -1, "Mouse " + (e.getButton() == 2 ? 3 : e.getButton()), null);
					return;
				}
				catch (BadLocationException ex) {
					ex.printStackTrace();
				}
			}
		});
		this.mainPane.add(this.toggleKeyField);
	}

	private void setupMisc() {
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			InputStream fontFile = AutoClicker.class.getClassLoader().getResourceAsStream("assets/BebasNeue.otf");
			Font font = Font.createFont(0, fontFile);
			ge.registerFont(font);
			fontFile.close();
			this.titleText.setFont(font.deriveFont(0, 25.0f));
			this.cpsNumber.setFont(font.deriveFont(0, 69.0f));
			this.cpsRange.setFont(font.deriveFont(0, 18.0f));
			this.overlayBox.setFont(font.deriveFont(0, 14.0f));
			this.rightClickBox.setFont(font.deriveFont(0, 14.0f));
			this.toggleKeyText.setFont(font.deriveFont(0, 14.0f));
			this.minCPSField.setFont(new Font("arial", 0, 12));
			this.maxCPSField.setFont(new Font("arial", 0, 12));
			this.toggleKeyField.setFont(new Font("arial", 0, 12));
		}
		catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		this.frame.add(this.titleBar);
		this.frame.add(this.dropdown);
		this.frame.add(this.mainPane);
		this.frame.setVisible(true);
	}

	private void textFieldSetCPS(boolean isMin) {
		JTextField textField;
		JTextField jTextField = textField = isMin ? this.minCPSField : this.maxCPSField;
		if (textField.getText().matches("^\\d+$") && isMin && Integer.parseInt(textField.getText()) >= 1 && Integer.parseInt(textField.getText()) <= AutoClicker.maxCPS || !isMin && Integer.parseInt(textField.getText()) >= AutoClicker.minCPS && Integer.parseInt(textField.getText()) <= 99) {
			int cpsFieldVal = Integer.parseInt(textField.getText());
			if (isMin && this.slider.sliderVal1 <= this.slider.sliderVal2 || !isMin && this.slider.sliderVal1 > this.slider.sliderVal2) {
				this.slider.sliderVal1 = cpsFieldVal > 20 ? 19 : cpsFieldVal - 1;
				this.slider.sliderThumb1.x = (float)this.slider.sliderVal1 / 20.0f * 130.0f;
			} else {
				this.slider.sliderVal2 = cpsFieldVal > 20 ? 19 : cpsFieldVal - 1;
				this.slider.sliderThumb2.x = (float)this.slider.sliderVal2 / 20.0f * 130.0f;
			}
			this.slider.sliderRange.x = Math.min(this.slider.sliderThumb1.x, this.slider.sliderThumb2.x) + 5.0;
			this.slider.sliderRange.width = Math.max(this.slider.sliderThumb1.x, this.slider.sliderThumb2.x) - Math.min(this.slider.sliderThumb1.x, this.slider.sliderThumb2.x);
			textField.setText(textField.getText().replaceFirst("^0*", ""));
			KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
			if (isMin) {
				AutoClicker.minCPS = cpsFieldVal;
			} else {
				AutoClicker.maxCPS = cpsFieldVal;
			}
			this.slider.repaint();
			return;
		}
		textField.setText(String.valueOf(isMin ? AutoClicker.minCPS : AutoClicker.maxCPS));
	}

	private String getKeyString(int keyCode, int modifiers) {
		String keyString;
		String modifiersString = KeyEvent.getKeyModifiersText(modifiers).replace("+", "");
		if (keyCode == 0) {
			keyString = "Invalid Key";
			modifiersString = "";
			return String.valueOf(modifiersString) + keyString;
		}
		if (keyCode == 32) {
			keyString = "Space";
			return String.valueOf(modifiersString) + keyString;
		}
		keyString = KeyEvent.getKeyText(keyCode);
		return String.valueOf(modifiersString) + keyString;
	}
}

