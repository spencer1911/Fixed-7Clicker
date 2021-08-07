/*
 * Decompiled with CFR 0.151.
 *
 * Could not load the following classes:
 *  org.jnativehook.keyboard.NativeKeyEvent
 *  org.jnativehook.keyboard.NativeKeyListener
 */
package synnk.sevenremaster.listener;

import synnk.sevenremaster.AutoClicker;
import java.util.Arrays;
import java.util.List;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyListener
		implements NativeKeyListener {
	public void nativeKeyPressed(NativeKeyEvent event) {
		List<String> modifiers1 = Arrays.asList(NativeKeyEvent.getModifiersText((int)event.getModifiers()).split("\\+"));
		List<String> modifiers2 = Arrays.asList(AutoClicker.toggleKey[1].split("\\+"));
		if (!NativeKeyEvent.getKeyText((int)event.getKeyCode()).equals(AutoClicker.toggleKey[0])) return;
		if (!modifiers1.containsAll(modifiers2)) return;
		if (AutoClicker.gui.focused) return;
		AutoClicker.toggle();
	}

	public void nativeKeyReleased(NativeKeyEvent event) {
	}

	public void nativeKeyTyped(NativeKeyEvent event) {
	}
}

