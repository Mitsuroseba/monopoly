package com.bostonunisoft.students.monopoly;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;


/**
 * Class, that represents server of Monopoly game.
 * @author Yaroslav
 *
 */
public class MultiThreadedServer implements Runnable{
	
	
	    private static Logger logger = Logger.getLogger(MultiThreadedServer.class);
	    
	    protected int          serverPort   = 9000;
	    protected ServerSocket serverSocket = null;
	    protected boolean      isStopped    = false;
	 
	    public MultiThreadedServer(int port){
	        this.serverPort = port;
	    }
	    
	    public MultiThreadedServer(){
	    
	    }
	 
	    @Override
	    public void run(){
	    	
	        openServerSocket();
	        while(! isStopped()){
	        	
	            Socket clientSocket = null;
	            try {
	                clientSocket = this.serverSocket.accept();
	            } catch (IOException e) {
	                if(isStopped()) {
	                    logger.info("Server Stopped.") ;
	                    return;
	                }
	                logger.error("Error accepting client connection", e);
	            }
	            new Thread(
	                new ClientHandler()
	            ).start();
	        }
	        logger.info("Server Stopped.") ;
	    }
	 
	 
	    private synchronized boolean isStopped() {
	        return this.isStopped;
	    }
	 
	    public synchronized void stop(){
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
	    public static void main(String[] s){
	    	
	    	MultiThreadedServer server=new MultiThreadedServer();
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
