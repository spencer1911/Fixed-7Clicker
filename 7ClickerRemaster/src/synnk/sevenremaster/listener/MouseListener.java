/*
 * Decompiled with CFR 0.151.
 *
 * Could not load the following classes:
 *  org.jnativehook.mouse.NativeMouseEvent
 *  org.jnativehook.mouse.NativeMouseListener
 */
package synnk.sevenremaster.listener;

import synnk.sevenremaster.AutoClicker;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

public class MouseListener
		implements NativeMouseListener {
	private boolean leftClick;
	private boolean rightClick;
	private long lastClickTime = 0L;

	public void nativeMousePressed(NativeMouseEvent event) {
		if (event.getButton() == AutoClicker.toggleMouseButton && !AutoClicker.gui.focused) {
			AutoClicker.toggle();
		}
		if (AutoClicker.toggled && !AutoClicker.skipNext) {
			if (event.getButton() == 1) {
				this.leftClick = true;
			} else if (event.getButton() == 2) {
				this.rightClick = true;
			}
			if (this.leftClick && this.rightClick) {
				AutoClicker.blockHit = true;
			}
			if (event.getButton() == AutoClicker.button) {
				AutoClicker.mousePos = event.getPoint();
				AutoClicker.activated = true;
				AutoClicker.lastTime = System.currentTimeMillis();
			}
		}
		if (event.getButton() != AutoClicker.button) return;
		if (System.currentTimeMillis() - this.lastClickTime > 1000L && this.lastClickTime != 0L) {
			this.lastClickTime = 0L;
		}
		if (this.lastClickTime == 0L) {
			this.lastClickTime = System.currentTimeMillis();
			return;
		}
		if (System.currentTimeMillis() == this.lastClickTime) return;
		int cps = Math.round(1000.0f / (float)(System.currentTimeMillis() - this.lastClickTime));
		AutoClicker.gui.cpsNumber.setText(cps < 10 ? "0" + cps : String.valueOf(cps));
		this.lastClickTime = 0L;
	}

	public void nativeMouseReleased(NativeMouseEvent event) {
		if (!AutoClicker.skipNext) {
			if (event.getButton() == AutoClicker.button) {
				this.leftClick = false;
				AutoClicker.activated = false;
				return;
			}
			if (event.getButton() != (AutoClicker.button == 1 ? 2 : 1)) return;
			this.rightClick = false;
			AutoClicker.blockHit = false;
			return;
		}
		AutoClicker.skipNext = event.getButton() == AutoClicker.button && AutoClicker.blockHit;
	}

	public void nativeMouseClicked(NativeMouseEvent event) {
	}
}

