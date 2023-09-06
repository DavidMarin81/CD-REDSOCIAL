package com.campusdual;

import com.campusdual.Util.Input2;

import java.util.ArrayList;

public class Main {
    public static User mainUser = new User("David");
    public static ArrayList<User> mainUserList = new ArrayList<>();
    public static ArrayList<User> followedUsers = new ArrayList<>();
    public static ArrayList<Post> postList = new ArrayList<>();

    public static void main(String[] args) {

        //Se crea la BBDD
        createBBDD();

        //Se inicia el programa
        int finalizar = -1;
        do {
            createMenu();
            finalizar = chooseMenuOptions();
        }while (finalizar != 0);

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

        Comment comment1 = new Comment(user1, "Este es el primer comentario de Juan");
        Comment comment2 = new Comment(user2, "Este es el primer comentario de Pepe");

        Comment comment3 = new Comment(user1, "Este es el segundo comentario de Juan");
        Comment comment4 = new Comment(user2, "Este es el segundo comentario de Pepe");

        Comment comment5 = new Comment(user2, "Este es el tercer comentario de Pepe");
        Comment comment6 = new Comment(user4, "Este es el primer comentario de Laura");
        Comment comment7 = new Comment(user5, "Este es el primer comentario de Manuel");

        post1.addComment(comment1);
        post1.addComment(comment2);

        post2.addComment(comment3);
        post2.addComment(comment4);

        post3.addComment(comment5);
        post3.addComment(comment6);
        post4.addComment(comment7);

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
        System.out.println("6.- Listar los comentarios de un usuario");
        System.out.println("7.- Mostrar el numero de comentarios de un post");
        System.out.println("8.- Mostrar los 10 post de usuarios a los que sigues");
        System.out.println("9.- Usuarios que sigues");
        System.out.println("0.- Salir");
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
            option = Input2.integer("Introduce una opcion: ");
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
                    showUserComment();
                    break;
                case 7:
                    showTotalComments();
                    break;
                case 8:
                    showFollowedUserPost();
                    break;
                case 9:
                    showFollowedUsers();
                    break;
                case 0:
                    //Se usa para salir del programa
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    System.out.println("Debe introducir un numero del 1 al 8");
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
            option = Input2.integer("Introduce una opcion: ");
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
            option = Input2.integer("Introduce una opcion: ");
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
        String newUser = Input2.string("Introduce un nombre de usuario:");
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
        String userToRemove = Input2.string("Introduce un nombre de usuario:");
        User user = searchUser(mainUserList, userToRemove);
        if (user != null) {
            mainUserList.remove(user);
            followedUsers.remove(user);
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
        System.out.println("Sigues a: ");
        showUserList(followedUsers);
        System.out.println(" ====================================");
        String userToFollow = Input2.string("Introduce el nombre de usuario al que quieras seguir: ");
        User user = searchUser(mainUserList, userToFollow);
        if (user != null) {
            followedUsers.add(user);
            System.out.println("Empiezas a seguir a este usuario");
        } else {
            System.out.println("No existe un usuario con ese nombre");
        }
    }

    public static void unFollowUser(){
        System.out.println(" ====================================");
        System.out.println("     DEJAR DE SEGUIR A UN USUARIO");
        System.out.println(" ====================================");
        System.out.println("Sigues a:");
        showUserList(followedUsers);
        System.out.println(" ====================================");
        String userToUnfollow = Input2.string("Introduce el nombre de usuario al que quieras dejar de seguir:");
        User user = searchUser(followedUsers, userToUnfollow);
        if (user != null) {
            followedUsers.remove(user);
            System.out.println("Has dejado de seguir a este usuario");
        } else {
            System.out.println("No existe un usuario con ese nombre");
        }
        System.out.println(" ====================================");
        System.out.println("Sigues a: ");
        showUserList(followedUsers);
    }

    public static void showUserList(ArrayList<User> userList){
        for(User u : userList){
            System.out.println(u);
        }
    }

    public static void showUserPost(){
        System.out.println(" ====================================");
        System.out.println("       VER POSTS DE UN USUARIO");
        System.out.println(" ====================================");
        String chosedUser = Input2.string("Introduce un nombre de usuario:");
        User user = searchUser(mainUserList, chosedUser);
        if(user != null){
            showUserPostList(user);
        } else {
            System.out.println("No se ha encontrado ningún usuario");
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

    public static void showUserComment(){
        System.out.println(" ====================================");
        System.out.println("    VER COMENTARIOS DE UN USUARIO");
        System.out.println(" ====================================");
        String chosedUser = Input2.string("Introduce un nombre de usuario:");
        User user = searchUser(mainUserList, chosedUser);
        if(user != null){
            showComments(user);
        } else {
            System.out.println("No se ha encontrado ningún usuario");
        }
    }

    public static void showComments(User user){
        int contador = 1;
        for (Post p : postList){
            for(Comment c : p.getCommentsList()){
                if(c.getUser().equals(user)){
                    System.out.println(contador + " -> " + c.getUserComment());
                    System.out.println(p);
                    contador++;
                }
            }
            if(p.getCommentsList().size() == 0){
                System.out.println("El usuario no tiene comentarios");
            }
        }
    }

    public static void addPost(){
        ArrayList<String> comments = new ArrayList<>();
        String newPost = Input2.string("Introduce un nuevo post: ");
        Post post = new Post(mainUser, newPost);
        postList.add(post);
        System.out.println("El post se ha añadido correctamente");
    }

    public static void deletePost(){
        showPosts();
        int numero = Input2.integer("Que post quieres borrar?");
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
        int postNumber = Input2.integer("Introduce el numero del post en el que quieres comentar: ");
        if(postNumber <= postList.size() &&postNumber > 0) {
            String message = Input2.string("Introduce tu comentario: ");
            int contador = 1;
            for(Post p : postList){
                if((postNumber) == contador){
                    Comment comment = new Comment(mainUser, message);
                    p.addComment(comment);
                    System.out.println("El comentario se ha añadido correctamente");
                    break;
                }
                contador++;
            }
        } else {
            System.out.println("Número de post no encontrado");
        }
    }

    public static void showTotalComments(){
        int contador = 1;
        showPosts();
        int postNumber = Input2.integer("Introduce el numero del post en el que quieres comentar: ");
        if(postNumber <= postList.size() &&postNumber > 0) {
            for(Post p : postList){
                if((postNumber) == contador){
                    for(Comment c : p.getCommentsList()){
                        if(c.getUser().equals(p.getUser())){
                            showComments(p.getUser());
                        }
                    }
                    System.out.println("Total comentarios -> " + p.getCommentsList().size());
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
        int postNumber = Input2.integer("Introduce el post que quieres ver: ");
        if(postNumber <= postList.size() &&postNumber > 0) {
            int contador = 1;
            for(Post p : postList){
                if(postNumber == contador){
                    //Mostrar todos los comentarios
                    int cont = 1;
                    for(Comment c : p.getCommentsList()){
                        System.out.println(cont + " -> " + c.getUserComment());
                        cont++;
                    }
                    int commentNumber = Input2.integer("Introduce el numero del comentario que quieres borrar: ");
                    if (commentNumber <= p.getCommentsList().size() && commentNumber > 0){
                            p.getCommentsList().remove(commentNumber - 1);
                            System.out.println("Se ha borrado el comentario correctamente");
                            break;
                        }
                }
                contador++;
            }
        } else {
            System.out.println("Número de post no encontrado");
        }
    }

    private static void showFollowedUserPost() {
        //Sin implementar
    }

    private static void showFollowedUsers(){
        System.out.println(" ====================================");
        System.out.println("      USUARIO A LOS QUE SIGUES");
        System.out.println(" ====================================");
        if(followedUsers.size() != 0){
            for(User u : followedUsers){
                System.out.println(u.getUserName());
            }
        } else {
            System.out.println("No sigues a ningun usuario");
        }

    }
}
