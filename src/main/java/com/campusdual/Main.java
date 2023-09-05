package com.campusdual;

import com.campusdual.Util.Input;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static ArrayList<User> mainUserList = new ArrayList<>();
    public static ArrayList<User> usersList = new ArrayList<>();
    public static void main(String[] args) {

        //Se crean 5 usuarios
        createUsers();

        //Se inicia el programa
        int finalizar = 0;
        do {
            createMenu();
            finalizar = chooseMenuOptions();
        }while (finalizar != 7);


    }

    public static void createUsers(){
        //Se crean 5 usuarios
        User mainUser = new User("Owner");
        User user1 = new User("Juan");
        User user2 = new User("Pepe");
        User user3 = new User("Maria");
        User user4 = new User("Laura");
        User user5 = new User("Manuel");

        //Se añaden a una lista
        mainUserList.add(user1);
        mainUserList.add(user2);
        mainUserList.add(user3);
        mainUserList.add(user4);
        mainUserList.add(user5);
    }

    public static void createMenu(){
        System.out.println(" ====================================");
        System.out.println("             RED SOCIAL");
        System.out.println(" ====================================");
        System.out.println("1.- Añadir...");
        System.out.println("2.- Dejar de seguir a un usuario");
        System.out.println("3.- Seguir a un usuario");
        System.out.println("4.- Eliminar...");
        System.out.println("5.- Listar los posts de un usuario");
        System.out.println("6.- Mostrar el numero de comentarios de un post");
        System.out.println("7.- Salir");
        System.out.println(" ====================================");
    }

    public static void createMenuAdd(){
        System.out.println(" ====================================");
        System.out.println("          ¿Qué deseas añadir?");
        System.out.println(" ====================================");
        System.out.println("1.- Usuario");
        System.out.println("2.- Post");
        System.out.println("3.- Comentario");
        System.out.println("4.- Volver al menu principal");
        System.out.println(" ====================================");
    }

    public static void createMenuDelete(){
        System.out.println(" ====================================");
        System.out.println("         ¿Qué deseas eliminar?");
        System.out.println(" ====================================");
        System.out.println("1.- Usuario");
        System.out.println("2.- Post");
        System.out.println("3.- Comentario");
        System.out.println("4.- Volver al menu principal");
        System.out.println(" ====================================");
    }

    public static int chooseMenuOptions(){
        boolean correct;
        int option;
        do{
            option = Input.integer("Introduce una opcion: ");
            correct = true;
            switch(option){
                case 1:
                    chooseAddOptions();
                    break;
                case 2:
                    unFollowUser();
                    break;
                case 3:
                    followUser();
                    break;
                case 4:
                    chooseDeleteOptions();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    System.out.println("Debe introducir un numero del 1 al 7");
                    correct = false;
            }
        }while (!correct);
        return option;
    }

    public static int chooseAddOptions(){
        boolean correct;
        int option;
        do{
            createMenuAdd();
            option = Input.integer("Introduce una opcion: ");
            correct = true;
            switch(option){
                case 1:
                    addUser();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    System.out.println("Debe introducir una opcion del 1 al 4");
                    correct = false;
            }
        }while (!correct);
        return option;
    }

    public static int chooseDeleteOptions(){
        boolean correct;
        int option;
        do{
            createMenuDelete();
            option = Input.integer("Introduce una opcion: ");
            correct = true;
            switch(option){
                case 1:
                    deleteUser();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    System.out.println("Debe introducir una opcion del 1 al 4");
                    correct = false;
            }
        }while (!correct);
        return option;
    }

    public static void addUser(){
        System.out.println(" ====================================");
        System.out.println("       INTRODUCIR NUEVO USUARIO");
        System.out.println(" ====================================");
        String newUser = Input.string("Introduce un nombre de usuario:");
        User user = searchUser(mainUserList, newUser);
        if(user == null){
            User userToAdd = new User(newUser);
            mainUserList.add(userToAdd);
            System.out.println("El usuario se ha añadido correctamente");
        } else {
            System.out.println("Ya existe un usuario con ese nombre");
        }
        System.out.println("Lista de usuarios registrados: ");
        showUserList(mainUserList);
    }

    public static void deleteUser(){
        System.out.println(" ====================================");
        System.out.println("          BORRAR USUARIO");
        System.out.println(" ====================================");
        String userToRemove = Input.string("Introduce un nombre de usuario:");
        User user = searchUser(mainUserList, userToRemove);
        if (user != null) {
            mainUserList.remove(user);
            usersList.remove(user);
            System.out.println("El usuario se ha eliminado correctamente");
        } else {
            System.out.println("No se ha encontrado ningun usuario con ese nombre");
        }
        System.out.println("Lista de usuarios registrados: ");
        showUserList(mainUserList);
    }

    public static User searchUser(ArrayList<User> list, String userName){
        User user = null;
        for(User u : list){
            if(userName.equals(u.getUserName())){
                user = u;
                break;
            }
        }
        return user;
    }

    public static void followUser(){
        System.out.println(" ====================================");
        System.out.println("       SEGUIR A UN USUARIO");
        System.out.println(" ====================================");
        showUserList(mainUserList);
        System.out.println(" ====================================");
        String userToFollow = Input.string("Introduce el nombre de usuario al que quieras seguir:");
        User user = searchUser(mainUserList, userToFollow);
        if (user != null) {
            usersList.add(user);
            System.out.println("Empiezas a seguir a este usuario");
        } else {
            System.out.println("No existe un usuario con ese nombre");
        }
        System.out.println(" ====================================");
        System.out.println("Sigues a: ");
        showUserList(usersList);
    }

    public static void unFollowUser(){
        System.out.println(" ====================================");
        System.out.println("     DEJAR DE SEGUIR A UN USUARIO");
        System.out.println(" ====================================");
        String userToUnfollow = Input.string("Introduce el nombre de usuario al que quieras dejar de seguir:");
        User user = searchUser(usersList, userToUnfollow);
        if (user != null) {
            usersList.remove(user);
            System.out.println("Has dejado de seguir a este usuario");
        } else {
            System.out.println("No existe un usuario con ese nombre");
        }
        System.out.println(" ====================================");
        System.out.println("Sigues a: ");
        showUserList(usersList);
    }

    public static void showUserList(ArrayList<User> userList){
        for(User u : userList){
            System.out.println(u);
        }
    }
}
