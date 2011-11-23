package com.bostonunisoft.students.monopoly;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

import org.apache.log4j.Logger;

import com.bostonunisoft.students.monopoly.config.ServerConfig;

/**
 * Class, that represents server of Monopoly game.
 * 
 * @author Yaroslav
 * 
 */
public class MultiThreadedServer implements Runnable,ServerConfig {

	private static Logger logger = Logger.getLogger(MultiThreadedServer.class);
	private Queue<PlayerHandler> players=new SynchronousQueue<PlayerHandler>();
	
	private ServerSocket serverSocket = null;
	private boolean isStopped = false;

	@Override
	public void run() {

		openServerSocket();
		while (!isStopped()) {

			Socket playerSocket = null;
			try {
				playerSocket = this.serverSocket.accept();
			} catch (IOException e) {
				if (isStopped()) {
					logger.info("Server Stopped.");
					return;
				}
				logger.error("Error accepting client connection", e);
			}
			PlayerHandler playerHandler=new PlayerHandler(playerSocket,players);
		}
		logger.info("Server Stopped.");
	}

	private synchronized boolean isStopped() {
		return this.isStopped;
	}

	public synchronized void stop() {
		this.isStopped = true;
		try {
			this.serverSocket.close();
		} catch (IOException e) {
			logger.error("Error closing server", e);
		}
	}

	private void openServerSocket() {
		logger.info("Opening server socket...");
		try {
			this.serverSocket = new ServerSocket(this.serverPort);
		} catch (IOException e) {
			logger.error("Cannot open port " + this.serverPort, e);
		}
	}

	/**
	 * Testing of server
	 * 
	 */
	public static void main(String[] s) {

		MultiThreadedServer server = new MultiThreadedServer();
		new Thread(server).start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.error("Thread is interrupted");
		}

		server.stop();

	}

}
