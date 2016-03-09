package org.coderatchet.javaadvanced.networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GreetingNetworking {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		threadPool.submit(new EchoServerTask());
		threadPool.submit(new ClientTask());
		try {
			threadPool.shutdown();
			boolean finishedOnTime = threadPool.awaitTermination(100, TimeUnit.MILLISECONDS);
			if (finishedOnTime) System.out.println("finished on time!");
			else System.out.println("didn't finish in time!");
			
			System.out.println("\n\n\n");
			urlExample();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static class ClientTask implements Runnable {

		private Socket server = null;

		@Override
		public void run() {
			try {
				System.out.println("Client: Connecting to server at port 12345 on localhost");
				server = new Socket(InetAddress.getLocalHost(), 12345);

				System.out.println("Client: Connected!");
				
				DataOutputStream out = new DataOutputStream(
						server.getOutputStream());
				System.out.println("Client: Writing 'hello, networking world!' to server");
				out.writeUTF("hello, networking world!");

				System.out.println("Client: Waiting for response from server");
				DataInputStream in = new DataInputStream(
						server.getInputStream());
				System.out.println("Client: Echo received - " + in.readUTF());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (null != server) {
					try {
						server.close();
					} catch (IOException ignore) {
					}
				}
			}
		}

	}

	private static class EchoServerTask implements Runnable {

		private ServerSocket serverSocket = null;

		@Override
		public void run() {
			try {
				
				serverSocket = new ServerSocket(12345);
				System.out.println("Server: Waiting for client on port "
						+ serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();
				System.out.println("Server: Just connected to port: "
						+ server.getRemoteSocketAddress());

				DataInputStream in = new DataInputStream(
						server.getInputStream());
				System.out.println("Server: Received - " + in.readUTF());

				DataOutputStream out = new DataOutputStream(
						server.getOutputStream());
				System.out.println("Server: Writing response 'Thanks!' to client");
				out.writeUTF("Thanks!");

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (null != serverSocket) {
					try {
						serverSocket.close();
					} catch (IOException ignore) {
					}
				}
			}
		}

	}
	
	private static void urlExample() {
		try
	      {
	         URL url = new URL("http://www.amrood.com:8080/index.htm?language=en#j2se");
	         
	         System.out.println("URL is " + url.toString());
	         System.out.println("protocol is " + url.getProtocol());
	         System.out.println("authority is " + url.getAuthority());
	         System.out.println("file name is " + url.getFile());
	         System.out.println("host is " + url.getHost());
	         System.out.println("path is " + url.getPath());
	         System.out.println("port is " + url.getPort());
	         System.out.println("default port is " + url.getDefaultPort());
	         System.out.println("query is " + url.getQuery());
	         System.out.println("ref is " + url.getRef());
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	      }
	}
}
