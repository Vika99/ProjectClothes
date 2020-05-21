package Clothes.Network;

import Clothes.Clothes;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerContainer {

    private static ExecutorService executorService;
    private static ArrayList<Clothes<?>> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server Started");

        while (true) {

            Socket socket = serverSocket.accept();
            System.out.println("New connection opened");

            process(socket);
        }
    }

    private static void process(Socket socket) {    // Будет обрабатывать отдельно каждое новое соединение


        executorService.submit(new Runnable() {   // Как только новое соединение мы отправляем новую задачу на выполнение
            @Override
            public void run() {

                try {
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                    System.out.println("Ready to communicate");


                    while (true) {
                        communicate(ois, oos);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private static void communicate(ObjectInputStream ois, ObjectOutputStream out) throws IOException, ClassNotFoundException {    //Отвечает за взаимодействие

        Request request = (Request) ois.readObject();
        System.out.println(request);


        switch (request.getType()) {
            case ADD: {
                Clothes<?> element = (Clothes<?>) request.getPayload();
                list.add(element);
                break;
            }

            case GET: {
                Response response = new Response(list);
                ObjectOutputStream oos = new ObjectOutputStream(out);
                oos.writeObject(response);
                oos.flush();
            }

        }

        switch (request.getType()) {
            case ADD: {
                Clothes<?> index = (Clothes<?>) request.getPayload();
                list.remove(index);
                break;
            }

            case GET: {
                Response response = new Response(list);
                ObjectOutputStream oos = new ObjectOutputStream(out);
                oos.writeObject(response);
                oos.flush();
            }

        }

        /*switch (request.getType()) {
            case ADD: {
                Clothes<?> elementlist = (Clothes<?>) request.getPayload();
                list.set(elementlist);

            }
            case GET: {
                Response response = new Response(list);
                ObjectOutputStream oos = new ObjectOutputStream(out);
                oos.writeObject(response);
                oos.flush();
            }
        }
    }*/


    }
}