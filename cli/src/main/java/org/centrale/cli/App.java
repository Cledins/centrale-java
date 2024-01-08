package org.centrale.cli;

import org.centrale.domain.Ciseaux;
import org.centrale.domain.Feuille;
import org.centrale.domain.Hand;
import org.centrale.domain.Pierre;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Jouons au Chifoumi !");
        Scanner scYou = new Scanner(System.in);
        System.out.println("Tapez 1 pour pierre, 2 pour feuille, 3 pour ciseaux :");
        int yourChoice = scYou.nextInt();

        Hand yourPick;

        if (yourChoice == 1){
            yourPick = new Pierre();
        } else if (yourChoice == 2){
            yourPick = new Feuille();
        } else {
            yourPick = new Ciseaux();
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Scanner scMe = new Scanner(System.in);
        System.out.println("A mon tour de taper 1 pour pierre, 2 pour feuille, 3 pour ciseaux :");
        int myChoice = scMe.nextInt();

        Hand myPick;

        if (myChoice == 1){
            myPick = new Pierre();
        } else if (myChoice == 2){
            myPick = new Feuille();
        } else {
            myPick = new Ciseaux();
        }
        System.out.println("Vous avez choisi " + yourPick.toString() + " et j'ai choisi " + myPick.toString() + " donc...\n");
        int resultat = myPick.playWith(yourPick);

        if (resultat==1){
            System.out.println("Vous avez gagné !");
        } else if (resultat==0){
            System.out.println("Egalité !");
        } else if (resultat==-1){
            System.out.println("J'ai gagné !");
        }

    }
}
