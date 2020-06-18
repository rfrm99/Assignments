#include <iostream>
#include <fstream>
#include <sstream> 

using namespace std;


struct hotel {
    string room, hotelname, nation, province, city, roomtype, roomclass, pricepernight, rating;
    hotel *next;
};

hotel *head;
hotel *tail;
hotel *bookedHead;
hotel *bookedTail;

void construct() {
    ifstream ip("database.csv");

    if(!ip.is_open()) cout << "ERROR: File Open" << '\n';

    string room, hotelname, nation, province, city, roomtype, roomclass, pricepernight, rating;

    int count = 0;


    while(ip.good()){

        getline(ip,room,',');
        getline(ip,hotelname,',');
        getline(ip,nation,',');
        getline(ip,province,',');
        getline(ip,city,',');
        getline(ip,roomtype,',');
        getline(ip,roomclass,',');
        getline(ip,pricepernight,',');
        getline(ip,rating,'\n');

        hotel *temp = new hotel;
        temp->room = room;
        temp->hotelname = hotelname;
        temp->nation = nation;
        temp->province = province;
        temp->city = city;
        temp->roomtype = roomtype;
        temp->roomclass = roomclass;
        temp->pricepernight = pricepernight;
        temp->rating = rating;

        if (head == NULL){
        head = temp; // First node
        tail = temp;
        } else {
            tail->next = temp;
            tail = temp;
        }
        count += 1;
    }
};

void printLinkedList(){
    hotel *current;
    current = head;

    while (current != NULL){
        cout << "-------------------" << endl;
        cout << "Room ID: " << current->room << "\n";
        cout << "Hotel Name:"<< current->hotelname << "\n";
        cout << "Location:"<< current->city << "," << current->province << "," << current->nation << "\n";
        cout << "Room type:" << current->roomtype << "\n";
        cout << "Room class:" << current->roomclass << "\n";
        cout << "Price per night: " << "IDR" << current->pricepernight << "\n";
        cout << "Rating:" << current->rating << "\n";

        current = current->next;
    }
}

void byLocation(string toSearch){
    hotel *current;
    current = head;
    while(current != NULL){
        string cityName = current->city;
        string provinceName = current->province;
        string nationName = current->nation;

        int pos = 0;
        int index;
        int count = 0;

        if((index = cityName.find(toSearch, pos)) != string::npos) {
            cout << "-------------------" << endl;
            cout << "Room ID: " << current->room << "\n";
            cout << "Hotel Name:"<< current->hotelname << "\n";
            cout << "Location:"<< current->city << "," << current->province << "," << current->nation << "\n";
            cout << "Room type:" << current->roomtype << "\n";
            cout << "Room class:" << current->roomclass << "\n";
            cout << "Price per night: " << "IDR" << current->pricepernight << "\n";
            cout << "Rating:" << current->rating << "\n";

            current = current->next;
            count += 1;
        } else if ((index = provinceName.find(toSearch, pos)) != string::npos) {
            cout << "-------------------" << endl;
            cout << "Room ID: " << current->room << "\n";
            cout << "Hotel Name:"<< current->hotelname << "\n";
            cout << "Location:"<< current->city << "," << current->province << "," << current->nation << "\n";
            cout << "Room type:" << current->roomtype << "\n";
            cout << "Room class:" << current->roomclass << "\n";
            cout << "Price per night: " << "IDR" << current->pricepernight << "\n";
            cout << "Rating:" << current->rating << "\n";

            current = current->next;
            count += 1;
        } else if ((index = nationName.find(toSearch, pos)) != string::npos) {
            cout << "-------------------" << endl;
            cout << "Room ID: " << current->room << "\n";
            cout << "Hotel Name:"<< current->hotelname << "\n";
            cout << "Location:"<< current->city << "," << current->province << "," << current->nation << "\n";
            cout << "Room type:" << current->roomtype << "\n";
            cout << "Room class:" << current->roomclass << "\n";
            cout << "Price per night: " << "IDR" << current->pricepernight << "\n";
            cout << "Rating:" << current->rating << "\n";

            current = current->next;
            count += 1;
        }
        current = current->next;
    }
}

void byHotelName(string name){

    hotel *current;
    current = head;
    while(current != NULL){
        string hotelname = current->hotelname;

        int pos = 0;
        int index;
        int count = 0;

        if((index = hotelname.find(name, pos)) != string::npos) {

            cout << "-------------------" << endl;
            cout << "Room ID: " << current->room << "\n";
            cout << "Hotel Name:"<< current->hotelname << "\n";
            cout << "Location:"<< current->city << "," << current->province << "," << current->nation << "\n";
            cout << "Room type:" << current->roomtype << "\n";
            cout << "Room class:" << current->roomclass << "\n";
            cout << "Price per night: " << "IDR" << current->pricepernight << "\n";
            cout << "Rating:" << current->rating << "\n";

            current = current->next;
            count += 1;
        }
        current = current->next;
    }
}


void sortByRating()
{   
    int count = 0;

    hotel *current;
    current = head;
    while (current!= NULL){
        count += 1;
        current = current->next;
    }

    string tempRoom, tempHotelName, tempNation, tempProvince, tempCity, tempRoomType, tempRoomClass, tempPrice, tempRating;
    if (head == NULL){
        cout << "Your contact is empty" << endl;
    } else {
        for (int i=0; i<count; i++)
        {
            hotel *temp = head;
            for (int j=0; j<count; j++)
            {
                while (temp -> next!=NULL)
                {
                    if (temp->rating > temp->next->rating)
                    {
                        i = 0;
                        j = 0;
                        tempRoom = temp->room;
                        temp->room = temp->next->room;
                        temp->next->room = tempRoom;

                        tempHotelName = temp->hotelname;
                        temp->hotelname = temp->next->hotelname;
                        temp->next->hotelname = tempHotelName;

                        tempNation = temp->nation;
                        temp->nation = temp->next->nation;
                        temp->next->nation = tempNation;

                        tempProvince = temp->province;
                        temp->province = temp->next->province;
                        temp->next->province = tempProvince;

                        tempCity = temp->city;
                        temp->city = temp->next->city;
                        temp->next->city = tempCity;

                        tempRoomType = temp->roomtype;
                        temp->roomtype = temp->next->roomtype;
                        temp->next->roomtype = tempRoomType; 

                        tempRoomClass = temp->roomclass;
                        temp->roomclass = temp->next->roomclass;
                        temp->next->roomclass = tempRoomClass;

                        tempPrice = temp->pricepernight;
                        temp->pricepernight = temp->next->pricepernight;
                        temp->next->pricepernight = tempPrice;

                        tempRating = temp->rating;
                        temp->rating = temp->next->rating;
                        temp->next->rating = tempRating;
                    }
                    temp = temp->next;
                }
            }
        }
        cout << "Your contact has been sorted!" << endl;
    
    }

}

void sortByPrice()
{   
    int count = 0;

    hotel *current;
    current = head;
    while (current!= NULL){
        count += 1;
        current = current->next;
    }

    string tempRoom, tempHotelName, tempNation, tempProvince, tempCity, tempRoomType, tempRoomClass, tempPrice, tempRating;
    if (head == NULL){
        cout << "Your contact is empty" << endl;
    } else {
        for (int i=0; i<count; i++)
        {
            hotel *temp = head;
            for (int j=0; j<count; j++)
            {
                while (temp -> next!=NULL)
                {	
                	stringstream geek(temp->pricepernight); 
        			int x = 0; 
        			geek >> x;
        			stringstream geek1(temp->next->pricepernight);
        			int y = 0;
        			geek1 >> y;
                    if (x > y)
                    {
                        i = 0;
                        j = 0;
                        tempRoom = temp->room;
                        temp->room = temp->next->room;
                        temp->next->room = tempRoom;

                        tempHotelName = temp->hotelname;
                        temp->hotelname = temp->next->hotelname;
                        temp->next->hotelname = tempHotelName;

                        tempNation = temp->nation;
                        temp->nation = temp->next->nation;
                        temp->next->nation = tempNation;

                        tempProvince = temp->province;
                        temp->province = temp->next->province;
                        temp->next->province = tempProvince;

                        tempCity = temp->city;
                        temp->city = temp->next->city;
                        temp->next->city = tempCity;

                        tempRoomType = temp->roomtype;
                        temp->roomtype = temp->next->roomtype;
                        temp->next->roomtype = tempRoomType; 

                        tempRoomClass = temp->roomclass;
                        temp->roomclass = temp->next->roomclass;
                        temp->next->roomclass = tempRoomClass;

                        tempPrice = temp->pricepernight;
                        temp->pricepernight = temp->next->pricepernight;
                        temp->next->pricepernight = tempPrice;

                        tempRating = temp->rating;
                        temp->rating = temp->next->rating;
                        temp->next->rating = tempRating;
                    }
                    temp = temp->next;
                }
            }
        }
        cout << "Your contact has been sorted!" << endl;
    
    }

}

void addToCart(string hotelid){
    
    bool searchFlag = false;
    hotel *current;
    hotel *previous;

    current = head;
    previous = current;

    while (current != NULL){
        // If hotel ID matches with the one in database such function will be executed
        if (hotelid == current->room){
            // Here is to create a new linked list with the head of bookedHead for the booked ones.
            hotel *ptr = new hotel;
            ptr->room = current->room;
            ptr->hotelname = current->hotelname;
            ptr->nation = current->nation;
            ptr->province = current->province;
            ptr->city = current->city;
            ptr->roomtype = current->roomtype;
            ptr->roomclass = current->roomclass;
            ptr->pricepernight = current->pricepernight;
            ptr->rating = current->rating;

            // Node logic
            if (bookedHead == NULL){
            bookedHead = ptr; // First node
            bookedTail = ptr;
            } else {
                bookedTail->next = ptr;
                bookedTail = ptr;
            }

            // This is to remove the selected hotel from the "ALL HOTEL" 
            if (current == head){
                current = head;
                head = current->next;
            } else {
                previous->next = current->next;
            }
        
            searchFlag = true;
        }
        previous = current;
        current = current->next;
    }
    if (searchFlag == true){
        cout << "Your hotel is booked!" << endl;
    } else {
        cout << "Hotel ID is unidentified!" << endl;
    }
}

void showBook(){
    hotel *ptr;
    ptr = bookedHead;
    hotel *previous = ptr;

    if (ptr == NULL){
        cout << "You haven't book any hotel ^_^" << endl;
    } else {
        while (ptr != NULL){
            cout << "-------------------" << endl;
                cout << "Room ID: " << ptr->room << "\n";
                cout << "Hotel Name:"<< ptr->hotelname << "\n";
                cout << "Location:"<< ptr->city << "," << ptr->province << "," << ptr->nation << "\n";
                cout << "Room type:" << ptr->roomtype << "\n";
                cout << "Room class:" << ptr->roomclass << "\n";
                cout << "Price per night: " << "IDR" << ptr->pricepernight << "\n";
                cout << "Rating:" << ptr->rating << "\n";

                ptr = ptr->next;
        }
    }
}

void cancelBook(string hotelid){
    hotel *ptr;
    hotel *previous;

    bool flagCancel = false;

    ptr = bookedHead;
    previous = ptr;

    while (ptr != NULL){
        if (hotelid == ptr->room){
            hotel *current = new hotel;
            current->room = ptr->room;
            current->hotelname = ptr->hotelname;
            current->nation = ptr->nation;
            current->province = ptr->province;
            current->city = ptr->city;
            current->roomtype = ptr->roomtype;
            current->roomclass = ptr->roomclass;
            current->pricepernight = ptr->pricepernight;
            current->rating = ptr->rating;

            // Node logic
            if (head == NULL){
            head = current; // First node
            head = current;
            } else {
                tail->next = current;
                tail = current;
            }

            if (ptr == bookedHead){
                ptr = bookedHead;
                bookedHead = ptr->next;
            } else {
                previous->next = ptr->next;
            }
            flagCancel = true;
        }  
        previous = ptr;
        ptr = ptr->next;
    }

    if (flagCancel == true){
        cout << "Your order has been cancelled!" << endl;
    } else {
        cout << "Failed to cancel your order! Please try again later" << endl;
    }

}

void writeCsv(){
	hotel *ptr;
  	std::ofstream myfile;
    myfile.open ("database.csv");
    ptr = head;
    while (ptr!=NULL){
	    myfile << ptr->room << ",";
	    myfile << ptr->hotelname << ",";
	    myfile << ptr->nation << ",";
	    myfile << ptr->province << ",";
	    myfile << ptr->city << ",";
	    myfile << ptr->roomtype << ",";
	    myfile << ptr->roomclass << ",";
	    myfile << ptr->pricepernight << ",";
	    myfile << ptr->rating << ",";
	    myfile << "\n";
	    ptr = ptr->next;
	}
    myfile.close();
}
