package com.dexels.navajo.xtext.navascript.navajobridge;

//import java.awt.desktop.SystemEventListener;
//import java.io.PrintStream;
//
//import org.eclipse.core.runtime.ILog;
//import org.eclipse.core.runtime.Platform;
//import org.eclipse.core.runtime.Status;
//import org.eclipse.jface.resource.ImageDescriptor;
//import org.eclipse.ui.IWorkbenchPage;
//import org.eclipse.ui.PlatformUI;
//import org.eclipse.ui.console.ConsolePlugin;
//import org.eclipse.ui.console.IConsole;
//import org.eclipse.ui.console.IConsoleConstants;
//import org.eclipse.ui.console.IConsoleView;
//import org.eclipse.ui.console.MessageConsole;
//import org.eclipse.ui.console.MessageConsoleStream;
//import org.osgi.framework.Bundle;
//import org.osgi.framework.FrameworkUtil;

public class EclipseLogger {

//	private static final Bundle BUNDLE = FrameworkUtil.getBundle(EclipseLogger.class);
//	private static final ILog LOGGER = Platform.getLog(BUNDLE);
	static boolean done = false;

	private static synchronized void init() {					

//		if ( done ) {
//			return;
//		}
//
//		try {
//
//			MessageConsole console = new MessageConsole("System Output", null); 
//			ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] { console });  
//
//			ConsolePlugin.getDefault().getConsoleManager().showConsoleView(console);
//
//
//			MessageConsoleStream stream = console.newMessageStream();
//			System.setOut(new PrintStream(stream, true));
//			System.setErr(new PrintStream(stream, true));
//
//			done = true;
//		} catch (Throwable e) {
//			e.printStackTrace(System.err);
//		}

	}

	public static void log(String msg) {
		init();
		System.err.println(msg);
	}


}
