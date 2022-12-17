package org.q2;

import org.q2.entities.DiscMag;
import org.q2.entities.Magazine;
import org.q2.entities.SaleableItem;
import org.q2.entities.Book;
import org.q2.entities.Publication;
import org.q2.entities.Ticket;

import org.q2.controllers.DiscMagJpaController;
import org.q2.controllers.MagazineJpaController;
//import org.q2.controllers.SaleableItemJpaController;
import org.q2.controllers.BookJpaController;
import org.q2.controllers.PublicationJpaController;
import org.q2.controllers.TicketJpaController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.persistence.jpa.PersistenceProvider;

public class Main {

        private static EntityManagerFactory emf;

        private Scanner input = new Scanner(System.in);

        private static String menuString = ""
            + "----------------\n"
            + " 1. Books\n"
            + " 2. Tickets\n"
            + " 3. Magazine\n"
            + " 4. Exit\n";
        public static void main(String[] args) {

            try {
                emf = new PersistenceProvider().createEntityManagerFactory("default", null);

                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Entity Manager created (" + emf + ")");

                boolean done = false;
                Scanner input = new Scanner(System.in);
                while (!done) {
                    System.out.println("" + menuString);
                    int choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("User");
                            break;
                        case 2:
                            System.out.println("Listing");
                            break;
                        case 3:
                            System.out.println("Categories");
                            break;
                        case 4:
                            System.out.println("Exit");
                            done = true;
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }

//                BookJpaController bookController = new BookJpaController(emf);
//
//                Book book = new Book();
//                book.setAuthor("J.K. Rowling");
//                book.setTitle("Harry Potter and the Philosopher's Stone");
//                book.setPrice(10.00);
//                book.setCopies(100);
//
//                bookController.create(book);
//
//                List<Book> listOfBooks = bookController.findBookEntities();
//
//System.out.println("\n------------------\nList of Books\n------------------");
//
//                for (Book bookEntity : listOfBooks) {
//                    System.out.println(bookEntity.toString());
//                }



            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
