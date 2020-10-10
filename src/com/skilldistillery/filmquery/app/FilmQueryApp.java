package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	Scanner input = new Scanner(System.in);
	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

//	private void test() {
//		Film film = db.findFilmById(1);
//		System.out.println(film);
//	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		boolean keepGoing = true;
		do {

			System.out.println("Welcome to the film query app, please choose from the following options");
			System.out.println("1: Look up film by its id");
			System.out.println("2: Look up a film by a search keyword");
			System.out.println("3: Exit the application");
			int choice = input.nextInt();

			switch (choice) {

			case 1:
				System.out.println("you have chosen to to look up a film by its ID");
				System.out.println("please enter the ID of the film you would like to view");
				int filmId = input.nextInt();

				if (db.findFilmById(filmId) == null) {
					System.out.println("there is no film by that ID, sending back to main menu");
					System.out.println();
					System.out.println();
				} else {
					System.out.println(db.findFilmById(filmId));
				}
				break;
			case 2:
				System.out.println("you have chosen to look a film up by a key word");
				System.out.println("please enter the keyword you would like to search by");
				String keyword = input.next();
				
				if (db.findFilmByKeyword(keyword).size() == 0) {
					System.out.println("there is no movie with the keyword" + " " + keyword + " " + "in the title or description");
					System.out.println("redirecting back to the main menu");
					System.out.println();
					System.out.println();
				} else {
					System.out.println(db.findFilmByKeyword(keyword));
				}
				break;
			case 3:
				System.out.println("you have quit the app, goodbye!");
				keepGoing = false;
				break;
			default:
				System.out.println("invalid option, please selct either 1, 2 or 3");
				break;

			}
		} while (keepGoing);

	}

}
