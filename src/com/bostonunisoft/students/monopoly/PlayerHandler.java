package com.bostonunisoft.students.monopoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

import org.apache.log4j.Logger;

/**
 * Class that will operate with client-server connection
 * 
 * @author Yura Demenkov
 * 
 */
public class PlayerHandler extends Thread {
	private static Logger logger = Logger.getLogger(PlayerHandler.class);
	private Socket playerSocket = null;
	private Queue<PlayerHandler> players = null;
	private BufferedReader bufferedReader = null;
	private PrintStream printStream = null;

	public PlayerHandler(Socket playerSocket, Queue<PlayerHandler> players) {
		try {
			this.playerSocket = playerSocket;
			this.players = players;
			bufferedReader = new BufferedReader(new InputStreamReader(
					playerSocket.getInputStream()));
			printStream = new PrintStream(playerSocket.getOutputStream());
			start();
		} catch (Exception ex) {
			logger.error("There are some problems with connection establishing to player with IP:"
					+ playerSocket.getRemoteSocketAddress());
		}
	}

	public PlayerHandler() {

	}

	public void run() {
		while (!this.isInterrupted()) {
			try {
				String commandLine = bufferedReader.readLine();
						System.out.println(commandLine);
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("There are problems with connection to player with IP:"
						+ playerSocket.getRemoteSocketAddress());
			}
		}

	}

	private void closeSocket() {
		try {
			players.remove(this);
			bufferedReader.close();
			printStream.close();
			this.playerSocket.close();
		} catch (Exception ex) {
			logger.error("There are some troubles with disconnecting player with IP:"
					+ playerSocket.getRemoteSocketAddress());
		}
	}

}
