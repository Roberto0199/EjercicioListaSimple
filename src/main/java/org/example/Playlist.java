package org.example;
public class Playlist {
    private Node head;

    // Constructor
    public Playlist() {
        this.head = null;
    }

    // Method to add a song to the end of the playlist
    public void addSong(String name, String artist, String genre, int duration) {
        Node newNode = new Node(name, artist, genre, duration);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    // Method to delete a song by its name
    public void deleteSong(String name) {
        if (head == null) {
            System.out.println("The playlist is empty.");
            return;
        }

        Node previous = null;
        Node current = head;
        while (current != null) {
            if (current.getName().equals(name)) {
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                System.out.println("The song " + name + " has been deleted.");
                return;
            }
            previous = current;
            current = current.getNext();
        }
        System.out.println("The song " + name + " was not found in the playlist.");
    }

    // Method to insert a song at a specific position
    public void insertSong(String name, String artist, String genre, int duration, int position) {
        if (position < 1) {
            System.out.println("The position must be greater than or equal to 1.");
            return;
        }

        Node newNode = new Node(name, artist, genre, duration);
        Node current = head;
    }

    public void printPlaylist() {
        Node current = head;
        if (current == null) {
            System.out.println("The playlist is empty.");
            return;
        }
        System.out.println("Playlist:");
        while (current != null) {
            System.out.println("Name: " + current.getName());
            System.out.println("Artist: " + current.getArtist());
            System.out.println("Genre: " + current.getGenre());
            System.out.println("Duration: " + current.getDuration() + " seconds");
            System.out.println("-----------------------");
            current = current.getNext();
        }
    }
}