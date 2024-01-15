/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import data.Hotel;
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileToTxt {
    public static void outputToFile(ArrayList<Hotel> ds, String file){
        try {
            PrintWriter pw = new PrintWriter(file, "UTF-8");
            for (Hotel d : ds) {
                pw.println(d);
            }
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void inputFromFile(ArrayList<Hotel> ds, String file){
        String id, name, address, phone;
        int room, rating;
        File f = new File(file);
        try {
            List<String> fs =  Files.readAllLines(f.toPath(), StandardCharsets.UTF_8);
            for (String f1 : fs) {
                String tmp[] = f1.trim().split("\\|");
                id = tmp[1].trim();
                name = tmp[2].trim();
                room = Integer.parseInt(tmp[3].trim());
                address = tmp[4].trim();
                phone = tmp[5].trim();
                rating = Integer.parseInt(tmp[6].trim());
                ds.add(new Hotel(id, name, room, address, phone, rating));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
