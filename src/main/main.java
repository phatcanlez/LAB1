package main;

import UI.Menu;
import data.hotelManager;
import tools.tool;

public class main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        String choice;
        String id;
        String file = "D:\\phat\\LAB211\\LAB1\\test\\Hotel.txt";
        String menu = "1) Adding new Hotel.|2) Checking exits Hotel.\n|3) Updating Hotel information.|4) Deleting Hotel.|5) Searching Hotel.|6) Displaying a hotel list (descending by Hotel_Name).|7) Quit.|8) Save.";
        hotelManager ds = new hotelManager();
        ds.inputFromFile(file);
        //ds.addSample();
        do {
            choice = Menu.printMenu(menu);
            switch (choice) {
                case "1"://nhập khách sạn
                    ds.addHotel();
                    break;

                case "2"://check có id hotel đó ko
                    if(ds.checkExistInMain() != 1)return;
                    break;

                case "3"://update
                    do {                        
                        id = tools.tool.inputString("Enter ID want to update(Enter exactly ID)");
                        if (ds.checkExist(id)) {
                            break;
                        }
                        System.out.println("Hotel does not exist");
                    } while (true);
                    ds.updateByID(id);
                    break;

                case "4"://xóa hotel
                    id = tools.tool.inputString("Enter ID want to delete(Enter exactly ID)");
                    ds.deleteHotel(id);
                    break;

                case "5"://tìm hotel; 5.1 tìm bằng id ; 5.2 tìm bằng tên
                    String choice2 = Menu.printMenu("|Which search do you want to search|1.Search by Hotel_Id|2.Search by Hotel_name");
                    if (choice2.equals("1")) {
                        id = tool.inputString("Enter find ID");
                        ds.searchById(id);
                    } else {
                        String name = tool.inputString("Enter find name");
                        ds.searchByName(name);
                    }
                    break;

                case "6":// in ra tất cả hotel đang có
                    ds.displayHotel();
                    break;

                case "7":
                    System.out.println("bye bye");
                    break;
                    
                case "8"://lưu vào file
                    ds.saveToFile(file);
                    System.out.println("Save successful");
                    break;
                    
                case "9":
                    ds.updateByName("Retreat");
                    break;
            }
            System.out.println("");
        } while (!choice.equals("7"));
    }
}
