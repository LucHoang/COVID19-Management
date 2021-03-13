package com.covid19management;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CitizenManager citizenManager = new CitizenManager();
        String choose;

        CitizenManager.listCitizen.add(new Citizen("1",1,1,"1","1","1"));
        CitizenManager.listCitizen.add(new Citizen("3",3,3,"3","3","3"));
        CitizenManager.listCitizen.add(new Citizen("2",2,2,"2","2","2"));
        CitizenManager.listCitizen.add(new Citizen("5",5,5,"5","5","5"));
        CitizenManager.listCitizen.add(new Citizen("4",4,4,"4","4","4"));

        while (true) {
            try {
                while (true) {
                    showMenu();
                    choose = input.nextLine();

                    switch (choose) {
                        case "1":
                            citizenManager.createCitizen();
                            citizenManager.display();
                            break;
                        case "2":
                            if (CitizenManager.listCitizen.isEmpty()) {
                                System.out.println("Danh sach trong!!!");
                                break;
                            }
                            citizenManager.findByName();
                            break;
                        case "3":
                            if (CitizenManager.listCitizen.isEmpty()) {
                                System.out.println("Danh sach trong!!!");
                                break;
                            }
                            citizenManager.findByIdentityCard();
                            break;
                        case "4":
                            if (CitizenManager.listCitizen.isEmpty()) {
                                System.out.println("Danh sach trong!!!");
                                break;
                            }
                            citizenManager.editHealth();
                            break;
                        case "5":
                            if (CitizenManager.listCitizen.isEmpty()) {
                                System.out.println("Danh sach trong!!!");
                                break;
                            }
                            citizenManager.setMove();
                            break;
                        case "6":
                            if (CitizenManager.listCitizen.isEmpty()) {
                                System.out.println("Danh sach trong!!!");
                                break;
                            }
                            citizenManager.findCitizenByListMove();
                            break;
                        case "7":
                            if (CitizenManager.listCitizen.isEmpty()) {
                                System.out.println("Danh sach trong!!!");
                                break;
                            }
                            citizenManager.displayPositive();
                            break;
                        case "8":
                            if (CitizenManager.listCitizen.isEmpty()) {
                                System.out.println("Danh sach trong!!!");
                                break;
                            }
                            citizenManager.displayContact();
                            break;
                        case "9":
                            System.out.println("1. Import thông tin từ file");
                            System.out.println("2. Export thông tin ra file");
                            System.out.println("0. Exit");
                            System.out.print("Choose: ");
                            String select = input.nextLine();
                            switch (select) {
                                case "1":
                                    FileManager.readFile();
                                    break;
                                case "2":
                                    FileManager.writeFile();
                                    break;
                                case "0":
                                    break;
                                default:
                                    System.out.println("Lua chon ngoai pham vi!!!");
                            }
                            break;
                        case "0":
                            System.out.println("Goodbye!!!");
                            System.exit(1);
                        default:
                            System.err.println("Lua chon ngoai pham vi!!!");
                    }
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Nhap sai dinh dang!!!");
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n--------------------------------------MENU---------------------------------------");
        System.out.println("1. Lập danh sách tất cả công dân tại Việt Nam");
        System.out.println("2. Tìm kiếm thông tin công dân theo tên");
        System.out.println("3. Tìm kiếm công dân theo CMTND");
        System.out.println("4. Thiết lập tình trạng sức khoẻ");
        System.out.println("5. Thiết lập lộ trình di chuyển của 1 bệnh nhân.");
        System.out.println("6. Thiết lập trạng thái các bệnh nhân đã tiếp xúc vs một bệnh nhân dương tính COVID-19");
        System.out.println("7. Hiển thị danh sách bệnh nhân dương tính COVID-19");
        System.out.println("8. Hiển thị danh sách bệnh nhân đang theo dõi");
        System.out.println("9. Đọc và ghi file");
        System.out.println("0. Thoát");
        System.out.print("Choose: ");
    }
}