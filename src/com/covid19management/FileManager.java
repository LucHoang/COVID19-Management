package com.covid19management;

import java.io.*;
import java.util.Scanner;

public class FileManager {
    static Scanner input = new Scanner(System.in);

    public static void readFile() {
        try {
            File file = new File(".\\data\\import.csv");

            if (!file.exists()) {
                System.out.println("File không tồn tại!");
                return;
            }

            System.out.println("Import thông tin từ file sẽ xóa và cập nhật lại toàn bộ nội dung sản phẩm");
            System.out.println("Nhấn Enter để tiếp tục");
            String choose = input.nextLine();

            if (choose.isEmpty()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

                String line = bufferedReader.readLine();

                CitizenManager.listCitizen.clear();

                while ((line = bufferedReader.readLine()) != null) {
                    String[] words = line.split(",");
                    Citizen citizen = new Citizen();

                    citizen.setName(words[0]);
                    citizen.setIdentityCard(Integer.parseInt(words[1]));
                    citizen.setAge(Integer.parseInt(words[2]));
                    citizen.setGender(words[3]);
                    citizen.setPermanentAddress(words[4]);
                    citizen.setTemporaryAddress(words[5]);
                    citizen.setHealth(words[6]);

                    CitizenManager.listCitizen.add(citizen);
                }
                bufferedReader.close();
                System.out.println("Import thông tin từ file thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeFile() {
        if (CitizenManager.listCitizen.isEmpty()) {
            System.err.println("Danh sách trống!!!");
            return;
        }
        System.out.println("Ghi vào file sẽ cập nhật lại toàn bộ nội dung file");
        System.out.println("Nhấn Enter để tiếp tục");
        String choose = input.nextLine();
        if (choose.isEmpty()) {
            try {
                File file = new File(".\\data\\export.csv");
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fileWriter = new FileWriter(file);

                fileWriter.write("Tên,CMND,Tuổi,Giới tính,Thường trú,Tạm trú,Trạng thái sức khỏe,Lộ trình di chuyển\n");
                for (Citizen citizen : CitizenManager.listCitizen) {
                    fileWriter.write(citizen.formatString() + "\n");
                }

                fileWriter.close();
                System.out.println("Ghi file thành công");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
