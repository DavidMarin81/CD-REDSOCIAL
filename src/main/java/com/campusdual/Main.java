package com.campusdual;

import com.campusdual.Util.Input;

import java.util.ArrayList;

public class Main {
    public static User mainUser = new User("David");
    public static ArrayList<User> mainUserList = new ArrayList<>();
    public static ArrayList<User> usersList = new ArrayList<>();
    public static ArrayList<Post> postList = new ArrayList<>();

    public static void main(String[] args) {

        //Se crea la BBDD
        createBBDD();

        //Se inicia el programa
        int finalizar = 0;
        do {
            createMenu();
            finalizar = chooseMenuOptions();
        }while (finalizar != 7);

    }

    public static void createBBDD() {
        //Se crean 5 usuarios
        User user1 = new User("Juan");
        User user2 = new User("Pepe");
        User user3 = new User("Maria");
        User user4 = new User("Laura");
        User user5 = new User("Manuel");

        //Se añaden a una lista
        mainUserList.add(mainUser);
        mainUserList.add(user1);
        mainUserList.add(user2);
        mainUserList.add(user3);
        mainUserList.add(user4);
        mainUserList.add(user5);


        //Añadir post a los usuarios
        Post post1 = new Post(user1, "Este es el Post 1 del usuario 1");
        Post post2 = new Post(user1, "Este es el Post 2 del usuario 1");
        Post post3 = new Post(user2, "Este es el Post 1 del usuario 2");
        Post post4 = new Post(user3, "Este es el Post 1 del usuario 3");
        Post post5 = new Post(user3, "Este es el Post 2 del usuario 3");

        postList.add(post1);
        postList.add(post2);
        postList.add(post3);
        postList.add(post4);
        postList.add(post5);

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
                    showUserPost();
                    break;
                case 6:
                    showCommentInAPost();
                    break;
                case 7:
                    //Se usa para salir del programa
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
                    addPost();
                    break;
                case 3:
                    addComment();
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
                    deletePost();
                    break;
                case 3:
                    deleteComment();
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

    public static void showUserPostList(User user){
        int contador = 0;
        for(Post p : postList){
            if(p.getUser().equals(user)){
                System.out.println(p);
                contador++;
            }
        }
        if(contador == 0){
            System.out.println(user.getUserName() + " no ha hecho ninguna publicación");
        }
    }
    public static void showUserPost(){
        System.out.println(" ====================================");
        System.out.println("       VER POSTS DE UN USUARIO");
        System.out.println(" ====================================");
        String newUser = Input.string("Introduce un nombre de usuario:");
        User user = searchUser(mainUserList, newUser);
        if(user != null){
            showUserPostList(user);
        } else {
            System.out.println("No se ha encontrado ningún usuario");
        }
    }

    public static void addPost(){
        ArrayList<String> comments = new ArrayList<>();
        String newPost = Input.string("Introduce un nuevo post: ");
        Post post = new Post(mainUser, newPost);
        postList.add(post);
        System.out.println("El post se ha añadido correctamente");
    }

    public static void deletePost(){
        showPosts();
        int numero = Input.integer("Que post quieres borrar?");
        if(numero <= postList.size() && numero > 0) {
            postList.remove(numero - 1);
            System.out.println("Se ha eliminado el post correctamente");
            System.out.println("Post actuales:");
            showPosts();
        } else {
            System.out.println("Número de post no encontrado");
        }
    }

    public static void showPosts(){
        int contador = 1;
        for(Post p : postList){
            System.out.println(contador + " -> " + p);
            contador++;
        }
    }

    public static void addComment(){
        showPosts();
        int postNumber = Input.integer("Introduce el numero del post en el que quieres comentar: ");
        if(postNumber <= postList.size() &&postNumber > 0) {
            String message = Input.string("Introduce tu comentario: ");
            int contador = 1;
            for(Post p : postList){
                if((postNumber) == contador){
                    p.addComment(message);
                    System.out.println("El comentario se ha añadido correctamente");
                    System.out.println("Comentarios del post: ");
                    showComments(p);
                    break;
                }
                contador++;
            }
        } else {
            System.out.println("Número de post no encontrado");
        }
    }

    public static void showComments(Post post){
        int contador = 1;
        for (Post p : postList){
            if(post == p){
                for(String c : post.getCommentsList()){
                    System.out.println(contador + " -> " + c);
                    contador++;
                }
            }
        }
    }

    public static void showCommentInAPost(){
        showPosts();
        int postNumber = Input.integer("Introduce el numero del post: ");
        if(postNumber <= postList.size() &&postNumber > 0) {
            int contador = 1;
            for(Post p : postList){
                if(postNumber == contador){
                    showComments(p);
                    break;
                }
                contador++;
            }
        } else {
            System.out.println("Número de post no encontrado");
        }
    }

    public static void deleteComment(){
        showPosts();
        int postNumber = Input.integer("Introduce el post que quieres ver: ");
        if(postNumber <= postList.size() &&postNumber > 0) {
            int contador = 1;
            for(Post p : postList){
                if(postNumber == contador){
                    showComments(p);
                    int commentNumber = Input.integer("Introduce el numero del comentario que quieres borrar: ");
                    if (commentNumber <= p.getCommentsList().size() && commentNumber > 0){
                            p.getCommentsList().remove(commentNumber - 1);
                            System.out.println("Se ha borrado el comentario correctamente");
                            showComments(p);
                            break;
                        }
                }
                contador++;
            }
        } else {
            System.out.println("Número de post no encontrado");
        }
    }

}
