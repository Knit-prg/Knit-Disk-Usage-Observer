package io.github.knit_prg.kduo;

import java.io.File;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Knit Disk Usage Observer
 *
 * @author Knit prg.
 * @since 0.1.0
 */
public class Main {

	/**
	 * 表示するドライブ
	 *
	 * @since 0.1.0
	 */
	public static File drive;

	/**
	 * 前回の取得時点での使用スペース
	 */
	public static long previousUsedSpace = 0;

	public static void main(String[] args) {
		if (args.length == 0) {
			drive = new File("/");
		} else {
			String driveLetter = args[0];
			if (driveLetter.length() != 1) {
				System.out.println("Drive letter format is not correct.");
				System.exit(1);
			}
			drive = new File(driveLetter + ":\\");
		}
		Timer timer = new Timer();
		timer.schedule(new PeriodicPrint(), 0, 1000);
	}

	/**
	 * 標準出力に表示する
	 *
	 * @since 0.1.0
	 */
	public static void print() {
		long currentTotalSpace = drive.getTotalSpace();
		long currentUsedSpace = currentTotalSpace - drive.getFreeSpace();
		long deltaTotalSpace = currentUsedSpace - previousUsedSpace;
		String usage = String.format("%.4f", (double) currentUsedSpace / (double) currentTotalSpace * 100);
		System.out.println("[" + Calendar.getInstance().getTime() + "] " + currentUsedSpace + " / " + currentTotalSpace + " [" + usage + "%]" + " (" + deltaTotalSpace + ")");
		previousUsedSpace = currentUsedSpace;
	}

	/**
	 * 定期的に標準出力に出力する
	 *
	 * @since 0.1.0
	 */
	private static class PeriodicPrint extends TimerTask {
		@Override
		public void run() {
			print();
		}
	}
}

