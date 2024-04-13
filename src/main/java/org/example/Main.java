package org.example;

import org.example.Playlist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();

        int option;
        do {
            displayMenu();
            System.out.print("Select an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addSong(scanner, playlist);
                    break;
                case 2:
                    playlist.printPlaylist();
                    break;
                case 3:
                    deleteSong(scanner, playlist);
                    break;
                case 4:
                    insertSong(scanner, playlist);
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        } while (option != 0);
        scanner.close();
    }

    // Method to display the menu
    public static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add song");
        System.out.println("2. Print playlist");
        System.out.println("3. Delete song");
        System.out.println("4. Insert song");
        System.out.println("0. Exit");
    }

    // Method to add a song
    public static void addSong(Scanner scanner, Playlist playlist) {
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter song name: ");
        String name = scanner.nextLine();
        System.out.print("Enter artist name: ");
        String artist = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        int duration;
        while (true) { // Continuamos solicitando la duración hasta que sea un número válido
            try {
                System.out.print("Enter duration (in seconds): ");
                duration = Integer.parseInt(scanner.nextLine()); // Convertimos la entrada en un entero
                break; // Salimos del bucle si la conversión fue exitosa
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for duration.");
            }
        }
        playlist.addSong(name, artist, genre, duration);
        System.out.println("Song added successfully!");
    }

    // Method to delete a song
    public static void deleteSong(Scanner scanner, Playlist playlist) {
        System.out.print("Enter the name of the song to delete: ");
        String name = scanner.next();
        playlist.deleteSong(name);
    }

    // Method to insert a song
    public static void insertSong(Scanner scanner, Playlist playlist) {
        System.out.print("Enter song name: ");
        String name = scanner.next();
        System.out.print("Enter artist: ");
        String artist = scanner.next();
        System.out.print("Enter genre: ");
        String genre = scanner.next();
        System.out.print("Enter duration (in seconds): ");
        int duration = scanner.nextInt();

        // Consume the newline character
        scanner.nextLine();

        System.out.print("Enter position to insert: ");
        int position = scanner.nextInt();

        playlist.insertSong(name, artist, genre, duration, position);
    }
}