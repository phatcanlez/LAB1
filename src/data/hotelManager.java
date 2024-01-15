package data;

import UI.Menu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import tools.tool;

public class hotelManager {

    public ArrayList<Hotel> ds = new ArrayList<>();

    public void addHotel() {
        do {
            Hotel h = inputHotel();
            if (h == null) {
                System.out.println("Add fail");
                return;
            }
            ds.add(h);
            System.out.println("Add successful!!!");
            int choice = tool.inputInt("Create a new hotel or go back to the main menu ?\n1.Create a new hotel\n2.Back to the main menu");
            if (choice != 1) {
                return;
            }
        } while (true);
    }//thêm khách sạn

    public void addSample() {
        ds.add(new Hotel("H02", "Vinstar", 5, "200 Ung Van Khiem, Ward 25, Binh Thanh District, Ho Chi Minh City", "0918940111", 5));
        ds.add(new Hotel("H01", "Seraton", 10, "189 Ung Van Khiem, Ward 25, Binh Thanh District, Ho Chi Minh City", "0911796099", 4));
        ds.add(new Hotel("H03", "Outstring", 7, "300 D1, Ward 24, Binh Thanh District, Ho Chi Minh City", "0988940222", 6));
        ds.add(new Hotel("H04", "Betigar", 8, "189 Duong Quang Ham, Ward 5, Go Vap District, Ho Chi Minh City", "0977940100", 3));
//        ds.add(new Hotel("005", "Mountain Retreat", 15, "555 Summit Lane", "444-333-2222", 3));
//        ds.add(new Hotel("006", "Ocean Breeze Hotel", 60, "777 Shore Boulevard", "111-222-3333", 4));
//        ds.add(new Hotel("007", "Downtown Haven", 25, "999 Center Street", "666-555-4444", 4));
//        ds.add(new Hotel("008", "Lakeside Lodge", 35, "222 Lakeview Drive", "888-777-6666", 3));
//        ds.add(new Hotel("009", "Palm Oasis", 45, "444 Palm Street", "333-999-0000", 5));
//        ds.add(new Hotel("010", "Riverside Retreat", 18, "666 River Road", "222-888-7777", 3));
//        ds.add(new Hotel("011", "Skyline Suites", 28, "111 Sky High Avenue", "777-000-5555", 4));
//        ds.add(new Hotel("012", "Green Valley Inn", 33, "333 Meadow Lane", "444-666-9999", 3));
//        ds.add(new Hotel("013", "Silver Springs Hotel", 22, "888 Silver Street", "123-456-7890", 5));
//        ds.add(new Hotel("014", "Majestic Manor", 38, "555 Regal Road", "999-888-7777", 4));
//        ds.add(new Hotel("015", "Countryside Comfort", 17, "777 Country Lane", "111-222-3333", 3));
//        ds.add(new Hotel("016", "Golden Gate Suites", 42, "999 Golden Gate Avenue", "444-555-6666", 4));
//        ds.add(new Hotel("017", "Emerald Enclave", 27, "222 Emerald Street", "666-777-8888", 3));
//        ds.add(new Hotel("018", "Rosewood Retreat", 31, "444 Rose Lane", "555-333-1111", 4));
//        ds.add(new Hotel("019", "Sunflower Inn", 19, "666 Sunflower Road", "888-222-4444", 3));
//        ds.add(new Hotel("020", "Sapphire Suites", 50, "777 Sapphire Street", "111-000-9999", 5));
    }//add 20 mẫu

    public Hotel inputHotel() {
        String id, name, address, phone;
        int room, rating;
        String regexID = "H[0-9]{1,5}";
        do {
            id = tools.tool.inputStringRegex("Please enter ID", regexID);
            if (!id.matches(regexID)) {
                System.out.print("ID with format: H**\n");
            }
        } while (!id.matches(regexID));
        name = tools.tool.inputString("Please enter name");
        room = tools.tool.inputIntRegex("Please enter number of room available", "\\d{0,}");
        address = tools.tool.inputString("Please enter address");
        phone = tools.tool.inputStringRegex("Please enter phone", "\\d{10}");
        rating = tools.tool.inputIntRegex("Please enter rating", "\\d{0,10}");
        if (checkExist(id)) {
            System.out.println("hotel have exist!!!");
            return null;
        }
        Hotel re = new Hotel(id, name, room, address, phone, rating);
        return re;
    }

    public void displayHotel() {
        ArrayList<Hotel> tmp = ds;
        Collections.sort(tmp, descName.reversed());
        for (Hotel t : tmp) {
            System.out.println(t);
        }
    }//in ra toàn bộ theo giảm dần

    public boolean checkExist(String id) {
        boolean re = false;
        for (Hotel d : ds) {
            if (d.getHotel_id().toUpperCase().equalsIgnoreCase(id.toUpperCase())) {
                re = true;
            }
        }
        return re;
    }//kiểm tra tồn tại (đã tồn tại trả ra true)

    public int checkExistInMain() {
        String id = tools.tool.inputString("Enter find ID");
        if (checkExist(id)) {
            System.out.println("Exist Hotel");
        } else {
            System.out.println("No Hotel Found!");
        }
        int choice = tool.inputInt("Do you want to back to main menu\n1.Yes\n2.No");
        if (choice != 1) {
            System.out.println("bye bye");
        }
        return choice;
    }//kiểm tra tồn tại trong main

    //kiểm tra có ko nhập gì ko (nếu nhập blank thì trả ra true)
    public boolean checkFormat(String msg) {
        return msg == null || msg.equalsIgnoreCase("") || msg.isEmpty();
    }

    public void updateByID(String idOfMain) {
        String id, name, address, phone, tmp;
        int room, rating;
        id = tools.tool.inputStringRegex("Please enter ID", "H[0-9]{1,5}");
        name = tools.tool.inputString("Please enter name");
        tmp = tools.tool.inputString("Please enter number of room available");
        if (tmp.isEmpty() || !tmp.matches("\\d{0,}")) {
            room = -1;
        } else {
            room = Integer.parseInt(tmp);
        }
        address = tools.tool.inputString("Please enter address");
        phone = tools.tool.inputStringRegex("Please enter phone", "\\d{10}");
        tmp = tools.tool.inputString("Please enter rating");
        if (tmp.isEmpty() || !tmp.matches("^\\d{0,10}")) {
            rating = -1;
        } else {
            rating = Integer.parseInt(tmp);
        }
        Hotel update_Hotel = new Hotel(id, name, room, address, phone, rating);

        for (Hotel d : ds) {
            if (d.getHotel_id().toUpperCase().contains(idOfMain.toUpperCase())) {
                //updateID
                if (!checkFormat(update_Hotel.getHotel_id())) {
                    d.setHotel_id(update_Hotel.getHotel_id());
                }
                //updateName
                if (!checkFormat(update_Hotel.getHotel_Name())) {
                    d.setHotel_Name(update_Hotel.getHotel_Name());
                }
                //updateRoom
                if (update_Hotel.getHotel_Room_Available() >= 0) {
                    d.setHotel_Room_Available(update_Hotel.getHotel_Room_Available());
                }
                //updateAddress
                if (!checkFormat(update_Hotel.getHotel_Address())) {
                    d.setHotel_Address(update_Hotel.getHotel_Address());
                }
                //updatePhone
                if (!checkFormat(update_Hotel.getHotel_Phone())) {
                    d.setHotel_Phone(update_Hotel.getHotel_Phone());
                }
                //updateRating
                if (update_Hotel.getHotel_Rating() >= 0) {
                    d.setHotel_Rating(update_Hotel.getHotel_Rating());
                }
            }
        }
    }

    public void updateByName(String nameOfMain) {
        String id, name, address, phone, tmp;
        int room, rating;
        id = tools.tool.inputStringRegex("Please enter ID", "H[0-9]{1,5}");
        name = tools.tool.inputString("Please enter name");
        tmp = tools.tool.inputString("Please enter number of room available");
        if (tmp.isEmpty() || !tmp.matches("\\d{0,}")) {
            room = -1;
        } else {
            room = Integer.parseInt(tmp);
        }
        address = tools.tool.inputString("Please enter address");
        phone = tools.tool.inputStringRegex("Please enter phone", "\\d{9}");
        tmp = tools.tool.inputString("Please enter rating");
        if (tmp.isEmpty() || !tmp.matches("^\\d{0,10}")) {
            rating = -1;
        } else {
            rating = Integer.parseInt(tmp);
        }
        Hotel update_Hotel = new Hotel(id, name, room, address, phone, rating);

        for (Hotel d : ds) {
            if (d.getHotel_Name().toUpperCase().contains(nameOfMain.toUpperCase())) {
                //updateID
                if (!checkFormat(update_Hotel.getHotel_id())) {
                    d.setHotel_id(update_Hotel.getHotel_id());
                }
                //updateName
                if (!checkFormat(update_Hotel.getHotel_Name())) {
                    d.setHotel_Name(update_Hotel.getHotel_Name());
                }
                //updateRoom
                if (update_Hotel.getHotel_Room_Available() >= 0) {
                    d.setHotel_Room_Available(update_Hotel.getHotel_Room_Available());
                }
                //updateAddress
                if (!checkFormat(update_Hotel.getHotel_Address())) {
                    d.setHotel_Address(update_Hotel.getHotel_Address());
                }
                //updatePhone
                if (!checkFormat(update_Hotel.getHotel_Phone())) {
                    d.setHotel_Phone(update_Hotel.getHotel_Phone());
                }
                //updateRating
                if (update_Hotel.getHotel_Rating() >= 0) {
                    d.setHotel_Rating(update_Hotel.getHotel_Rating());
                }
            }
        }
    }

    public void searchById(String id) {
        ArrayList<Hotel> ho = new ArrayList<>();
        for (Hotel d : ds) {
            if (d.getHotel_id().toUpperCase().contains(id.toUpperCase())) {
                ho.add(d);
            }
        }
        Collections.sort(ho, descID.reversed());
        int count = 0;
        for (Hotel h : ho) {
            System.out.println(h);
            count++;
        }
        if (count == 0) {
            System.out.println("Can't find any ID !!!");
        }
    }

    public void searchByName(String name) {
        ArrayList<Hotel> ho = new ArrayList<>();
        for (Hotel d : ds) {
            if (d.getHotel_Name().toUpperCase().contains(name.toUpperCase())) {
                ho.add(d);
            }
        }
        Collections.sort(ho, descName);
        int count = 0;
        for (int i = 0; i < ho.size(); i++) {
            System.out.println(ho.get(i).toString());
            count++;
        }
        if (count == 0) {
            System.out.println("Can't find any Name !!!");
        }
    }

    public int findIndex(String id) {
        for (Hotel d : ds) {
            if (d.getHotel_id().equalsIgnoreCase(id)) {
                return ds.indexOf(d);
            }
        }
        return -1;
    }

    public void deleteHotel(String id) {
        String choice = Menu.printMenu("Do you ready want to delete this hotel\n1.yes\n2.no");
        if (choice.equals("1") && checkExist(id)) {
            ds.remove(findIndex(id));
            System.out.println("delete success");
        } else {
            System.out.println("delete fail");
        }
        System.out.println("After delete");
        for (Hotel d : ds) {
            System.out.println(d);
        }
    }

    public void saveToFile(String file) {
        DTO.FileToTxt.outputToFile(ds, file);
    }

    public void inputFromFile(String file) {
        DTO.FileToTxt.inputFromFile(ds, file);
    }

    Comparator<Hotel> descName = new Comparator<Hotel>() {
        @Override
        public int compare(Hotel o1, Hotel o2) {
            if(o1.getHotel_Name().compareTo(o2.getHotel_Name()) > 0)
                return 1;
            else if (o1.getHotel_Name().compareTo(o2.getHotel_Name()) < 0)
                return -1;
            else return o1.getHotel_id().compareTo(o2.getHotel_id());
        }
    };

    Comparator<Hotel> descID = new Comparator<Hotel>() {
        @Override
        public int compare(Hotel o1, Hotel o2) {
            return o1.getHotel_id().compareTo(o2.getHotel_id());
        }
    };
}
