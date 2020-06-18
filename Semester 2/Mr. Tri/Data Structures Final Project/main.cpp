#include <iostream>
#include "logic.h"

using namespace std;

void mainMenu(string username){
    cout << endl << endl << "Hello " << username << ", Welcome to Ainsoft Hotel Booking System" << endl;
    cout << "1. Show all available hotel" << endl;
    cout << "2. Search hotel by..." << endl;
    cout << "3. Sort by rating" << endl;
    cout << "4. Sort by price" << endl;
    cout << "5. Book hotel by ID" << endl;
    cout << "6. View bookings" << endl;
    cout << "7. Cancel booking by ID" << endl;
    cout << "8. Exit the app" << endl << endl;
    cout << "Please enter your option:" << endl;
}

void searchBy(){
    cout << "1. By Hotel name" << endl;
    cout << "2. By Location" << endl;
}

int main(){
    // Variables declarations
    int prompt, searchby;
    string username, locationPrompt, hotelPrompt, hotelToBook, cancelOrder;
    bool flag = true;

    // Convert csv to linked list
    construct();

    // Enter name
    cout << "Enter your name: ";
    getline(cin, username);

    // Main iteration
    while(flag){
        mainMenu(username);
        cin >> prompt;

        // Prompt logic using switch
        switch (prompt){
            case 1: printLinkedList();
                    break;
            case 2: searchBy();
                    cin >> searchby;

                    // Switch case for search function
                    switch (searchby){
                        case 1: cout << "Enter the hotel name you want to search" << endl;
                                cin >> hotelPrompt;
                                byHotelName(hotelPrompt);
                                break;
                        case 2: cout << "Enter the location you want to search" << endl;
                                cin >> locationPrompt;
                                byLocation(locationPrompt);
                                break;
                    }
                    break;
            case 3: sortByRating();
                    break;
            case 4: sortByPrice();
            		break;
            case 5: cout << "Enter hotel ID: ";
                    cin >> hotelToBook;
                    addToCart(hotelToBook);
                    break;
            case 6: showBook();
                    break;
            case 7: cout << "Enter hotel ID to remove";
                    cin >> cancelOrder;
                    cancelBook(cancelOrder);
                    break;
            case 8: writeCsv();
		        flag = false;
                    break;
        }

    }

}
