/*
 * Decompiled with CFR 0.151.
 */
package synnk.sevenremaster.gui;

import synnk.sevenremaster.AutoClicker;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class RangeSlider
		extends JPanel {
	private static final long serialVersionUID = 1L;
	public int sliderVal1 = 7;
	public int sliderVal2 = 11;
	Rectangle2D.Double sliderBody = new Rectangle2D.Double(0.0, 2.5, 130.0, 5.0);
	Ellipse2D.Double sliderThumb1 = new Ellipse2D.Double((float)this.sliderVal1 / 20.0f * 130.0f, 0.0, 10.0, 10.0);
	Ellipse2D.Double sliderThumb2 = new Ellipse2D.Double((float)this.sliderVal2 / 20.0f * 130.0f, 0.0, 10.0, 10.0);
	Rectangle2D.Double sliderRange = new Rectangle2D.Double((float)this.sliderVal1 / 20.0f * 130.0f + 5.0f, 3.0, (float)(this.sliderVal2 - this.sliderVal1) / 20.0f * 130.0f, 4.0);

	public RangeSlider(JPanel panel, int x, int y) {
		this.setLayout(null);
		this.setBounds(x, y, 130, 10);
		this.setBackground(new Color(60, 70, 73));
		MouseAdapter dragListener = new MouseAdapter(){
			private boolean thumbPressed1 = false;
			private boolean thumbPressed2 = false;

			@Override
			public void mousePressed(MouseEvent e) {
				if (RangeSlider.this.sliderThumb1.getBounds().contains(e.getPoint())) {
					this.thumbPressed1 = true;
					return;
				}
				if (!RangeSlider.this.sliderThumb2.getBounds().contains(e.getPoint())) return;
				this.thumbPressed2 = true;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				this.thumbPressed1 = false;
				this.thumbPressed2 = false;
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				if (this.thumbPressed1) {
					RangeSlider.this.sliderThumb1.x = e.getX() - 5 < -5 ? -5 : (e.getX() - 5 > 124 ? 124 : e.getX() - 5);
					RangeSlider.this.sliderRange.x = Math.min(RangeSlider.this.sliderThumb1.x, RangeSlider.this.sliderThumb2.x) + 5.0;
					RangeSlider.this.sliderRange.width = Math.max(RangeSlider.this.sliderThumb1.x, RangeSlider.this.sliderThumb2.x) - Math.min(RangeSlider.this.sliderThumb1.x, RangeSlider.this.sliderThumb2.x);
					RangeSlider.this.sliderVal1 = (int)Math.round((RangeSlider.this.sliderThumb1.x + 2.0) / 130.0 * 20.0);
					AutoClicker.minCPS = Math.min(RangeSlider.this.sliderVal1, RangeSlider.this.sliderVal2) + 1;
					AutoClicker.maxCPS = Math.max(RangeSlider.this.sliderVal1, RangeSlider.this.sliderVal2) + 1;
					AutoClicker.gui.minCPSField.setText(String.valueOf(AutoClicker.minCPS));
					AutoClicker.gui.maxCPSField.setText(String.valueOf(AutoClicker.maxCPS));
					RangeSlider.this.repaint();
					return;
				}
				if (!this.thumbPressed2) return;
				RangeSlider.this.sliderThumb2.x = e.getX() - 5 < -5 ? -5 : (e.getX() - 5 > 124 ? 124 : e.getX() - 5);
				RangeSlider.this.sliderRange.x = Math.min(RangeSlider.this.sliderThumb1.x, RangeSlider.this.sliderThumb2.x) + 5.0;
				RangeSlider.this.sliderRange.width = Math.max(RangeSlider.this.sliderThumb1.x, RangeSlider.this.sliderThumb2.x) - Math.min(RangeSlider.this.sliderThumb1.x, RangeSlider.this.sliderThumb2.x);
				RangeSlider.this.sliderVal2 = (int)Math.round((RangeSlider.this.sliderThumb2.x + 2.0) / 130.0 * 20.0);
				AutoClicker.minCPS = Math.min(RangeSlider.this.sliderVal1, RangeSlider.this.sliderVal2) + 1;
				AutoClicker.maxCPS = Math.max(RangeSlider.this.sliderVal1, RangeSlider.this.sliderVal2) + 1;
				AutoClicker.gui.minCPSField.setText(String.valueOf(AutoClicker.minCPS));
				AutoClicker.gui.maxCPSField.setText(String.valueOf(AutoClicker.maxCPS));
				RangeSlider.this.repaint();
			}
		};
		this.addMouseListener(dragListener);
		this.addMouseMotionListener(dragListener);
		panel.add(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(new Color(45, 47, 49));
		g2d.fill(this.sliderBody);
		g2d.setColor(new Color(35, 168, 105));
		g2d.fill(this.sliderRange);
		g2d.setColor(Color.BLACK);
		g2d.fill(this.sliderThumb1);
		g2d.setColor(Color.BLACK);
		g2d.fill(this.sliderThumb2);
	}
}

